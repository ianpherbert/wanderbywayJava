package com.herbert.wanderbyway.dataprovider.trainRoute;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindRoutesFromDbId;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.DepartureSearchResult;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.TrainRouteSearchParams;
import com.herbert.wanderbyway.utils.rest.RestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainRouteController implements FindRoutesFromDbId {

    RestUtils restUtils;
    String baseUrl;
    TrainRouteMapper trainRouteMapper;
    public TrainRouteController(RestTemplate restTemplate, @Value("${dbBahn.baseUrl}")String baseUrl, TrainRouteMapper trainRouteMapper) {
        this.restUtils = new RestUtils(restTemplate, baseUrl);
        this.baseUrl = baseUrl;
        this.trainRouteMapper = trainRouteMapper;
    }


    @Override
    public List<RouteSearchItem> findRoutesWithDbId(String dbId) {
        TrainRouteSearchParams params = new TrainRouteSearchParams();
            params.setWhen(ZonedDateTime.now().plusDays(7));
            params.setDuration(1440);
            params.setResults(500);
        String path = "stops/".concat(dbId).concat("/departures");
        try{
            DepartureSearchResult results = restUtils.call(path, HttpMethod.GET, params, DepartureSearchResult.class);
            if(results == null) return new ArrayList<>();
            return trainRouteMapper.toRouteSearchItem(results.getDepartures());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
