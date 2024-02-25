package com.herbert.wanderbyway.dataprovider.trainRoute;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindRoutesFromDbId;
import com.herbert.wanderbyway.core.routeSearch.connectors.GetTrainRouteDetails;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures.DepartureSearchResult;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures.TrainRoute;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures.TrainRouteSearchParams;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip.TripSearchResult;
import com.herbert.wanderbyway.utils.DateUtils;
import com.herbert.wanderbyway.utils.rest.RestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class TrainRouteController implements FindRoutesFromDbId, GetTrainRouteDetails {

    RestUtils restUtils;
    String baseUrl;
    TrainRouteMapper trainRouteMapper;

    public TrainRouteController(RestTemplate restTemplate, @Value("${dbBahn.baseUrl}")String baseUrl, TrainRouteMapper trainRouteMapper) {
        this.restUtils = new RestUtils(restTemplate, baseUrl);
        this.baseUrl = baseUrl;
        this.trainRouteMapper = trainRouteMapper;
    }

    private List<RouteSearchItem> findRoutes(String dbId, Date startDate, Date endDate) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        String path = "stops/".concat(dbId).concat("/departures");
        List<RouteSearchItem> routes = new ArrayList<>();
        LocalDateTime start = DateUtils.atMidnight(startDate);
        LocalDateTime end = DateUtils.atMidnight(endDate);
        List<CompletableFuture<Void>> futures = DateUtils.getDatesBetween(start, end).stream().map(it -> CompletableFuture.runAsync(() -> {
            TrainRouteSearchParams params = new TrainRouteSearchParams();
            params.setWhen(it);
            params.setDuration(1440); // The number of minutes in a day
            params.setResults(500);
            try {
                DepartureSearchResult results = restUtils.call(path, HttpMethod.GET, params, DepartureSearchResult.class);
                if (results != null) {
                    synchronized (routes) {
                        routes.addAll(trainRouteMapper.toRouteSearchItem(results.getDepartures()));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }, executor)).toList();

        // Wait for all futures to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // Shutdown the executor
        executor.shutdown();

        return routes;
    }

    @Override
    public List<RouteSearchItem> findRoutesWithDbId(String dbId) {
        return this.findRoutes(dbId, new Date(), new Date());
    }

    @Override
    public List<RouteSearchItem> findRoutesWithDbId(String dbId, Date startDate, Date endDate) {
        return this.findRoutes(dbId, startDate, endDate);
    }

    @Override
    public RouteDetails getRouteDetails(String id) {
        String correctedId = id.replace("-", "|");
        String path = "trips/".concat(correctedId);
        try{
            TripSearchResult results = restUtils.call(path, HttpMethod.GET, TripSearchResult.class);
            if(results == null) return null;
            return trainRouteMapper.toTrainRouteDetails(results.getTrip());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private CompletableFuture<RouteDetails> getRouteDetailsAsync(String id) {
        return CompletableFuture.supplyAsync(() -> getRouteDetails(id));
    }
    @Override
    public List<RouteDetails> getRouteDetails(List<String> ids) {
        List<CompletableFuture<RouteDetails>> futures = ids.stream()
                .map(this::getRouteDetailsAsync)
                .toList();

        CompletableFuture<Void> allDoneFuture =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<RouteDetails>> allCompletableFuture = allDoneFuture.thenApply(v ->
                futures.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.toList())
        );

        try {
            return allCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }
}
