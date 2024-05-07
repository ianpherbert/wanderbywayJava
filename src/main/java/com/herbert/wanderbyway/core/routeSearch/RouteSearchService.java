package com.herbert.wanderbyway.core.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.connectors.*;
import com.herbert.wanderbyway.core.routeSearch.entity.*;
import com.herbert.wanderbyway.core.routeSearch.useCases.GetRouteDetailsUseCase;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteSearchService implements FindRoutesFromPlaceUseCase, GetRouteDetailsUseCase {
    FindFlightsFromAirport findFlightsFromAirport;
    FindRoutesFromDbId findRoutesFromDbId;
    FindAirportsFromIata findAirportsFromIata;
    FindRouteSearchAirportById findRouteSearchAirportById;
    FindRouteSearchStationById findRouteSearchStationById;
    FindStationsFromDbId findStationsFromDbId;
    FindRouteSearchCityById findRouteSearchCityById;
    GetTrainRouteDetails getTrainRouteDetails;
    FindBusRoutesFromLocationId findBusRoutesFromLocationId;
    public RouteSearchService(
            FindFlightsFromAirport findFlightsFromAirport,
            FindAirportsFromIata findAirportsFromIata,
            FindRouteSearchAirportById findRouteSearchAirportById,
            FindRoutesFromDbId findRoutesFromDbId,
            FindStationsFromDbId findStationsFromDbId,
            FindRouteSearchStationById findRouteSearchStationById,
            FindRouteSearchCityById findRouteSearchCityById,
            GetTrainRouteDetails getTrainRouteDetails,
            FindBusRoutesFromLocationId findBusRoutesFromLocationId
    ) {
        this.findFlightsFromAirport = findFlightsFromAirport;
        this.findAirportsFromIata = findAirportsFromIata;
        this.findRouteSearchAirportById = findRouteSearchAirportById;
        this.findRoutesFromDbId = findRoutesFromDbId;
        this.findStationsFromDbId = findStationsFromDbId;
        this.findRouteSearchStationById = findRouteSearchStationById;
        this.findRouteSearchCityById = findRouteSearchCityById;
        this.getTrainRouteDetails = getTrainRouteDetails;
        this.findBusRoutesFromLocationId = findBusRoutesFromLocationId;
    }

    @Override
    public RouteSearchResult findRoutes(
            int id,
            RouteSearchItemPlaceType type,
            Date startDate,
            Date endDate
    ) throws NotFoundException {
        switch (type){
            case AIRPORT -> {
                return Optional.ofNullable(findRouteSearchAirportById.findRouteSearchAirportById(id))
                        .map(origin -> new RouteSearchResult(getFlightRoutes(origin, startDate, endDate), new RouteSearchItemPlace(origin)))
                        .orElseThrow(() -> new NotFoundException("Could not find airport for id: " + id));
            }
            case TRAIN_STATION -> {
                return Optional.ofNullable(findRouteSearchStationById.findRouteSearchStationById(id))
                        .map(origin -> new RouteSearchResult(getTrainRoutes(origin, startDate, endDate), new RouteSearchItemPlace(origin)))
                        .orElseThrow(() -> new NotFoundException("Could not find station for id: " + id));
            }
            case CITY -> {
                RouteSearchCity origin = Optional.ofNullable(findRouteSearchCityById.findRouteSearchCityById(id)).orElseThrow(() -> new NotFoundException("Could not find city for id: " + id));
                List<RouteSearchItem> routes = new LinkedList<RouteSearchItem>();
                origin.getAirports().forEach(it -> routes.addAll(this.getFlightRoutes(it, startDate, endDate)));
                origin.getStations().forEach(it -> routes.addAll(this.getTrainRoutes(it, startDate, endDate)));
                return new RouteSearchResult(routes, new RouteSearchItemPlace(origin));
            }
            case BUS_STATION -> {
                return getBusRoutes(id, startDate);
            }
            default -> {
                throw new NotFoundException("Could not find station for id: " + id);
            }
        }
    }

    private RouteSearchResult getBusRoutes(int id, Date startDate){
        List<RouteSearchItem> routes = findBusRoutesFromLocationId.findRoutes(id, startDate);
        if(routes.isEmpty()) return null;
        RouteSearchItemPlace origin = routes.stream().findFirst().get().getOrigin();
        return new RouteSearchResult(routes, origin);
    }

    private List<RouteSearchItem> getTrainRoutes(RouteSearchTrainStation origin, Date startDate, Date endDate){
        if(!origin.hasDbId()) return new ArrayList<>();
        List<RouteSearchItem> routes = findRoutesFromDbId.findRoutesWithDbId(origin.getDbId(), startDate, endDate);
        List<String> dbIds = routes.stream().map(it -> it.getDestination().getDbId()).toList();
        List<RouteSearchTrainStation> destinations = findStationsFromDbId.findFromDbId(dbIds);

        ArrayList<RouteSearchItem> result = new ArrayList<>();

        routes.forEach(route -> {
            RouteSearchTrainStation match = destinations
                    .stream()
                    .filter(destination -> destination.getDbId().equals(route.getDestinationDbId()))
                    .findAny()
                    .orElse(null);

            if(match != null){
                route.completePlaces(match, origin);
                result.add(route);
            }
        });

        return result;
    }

    private List<RouteSearchItem> getFlightRoutes(RouteSearchAirport origin, Date startDate, Date endDate){
        List<RouteSearchItem> flights = findFlightsFromAirport.findFlights(origin.getIata(), startDate, endDate);
        if(flights == null) return new ArrayList<>();

        List<String> iatas = flights.stream().map(it -> it.getDestination().getIata()).toList();
        List<RouteSearchAirport> destinations = findAirportsFromIata.findFromIataIn(iatas);

        ArrayList<RouteSearchItem> result = new ArrayList<>();

        flights.forEach(flight -> {
            RouteSearchAirport match = destinations
                    .stream()
                    .filter(destination -> destination.getIata().equals(flight.getDestinationIata()))
                    .findAny()
                    .orElse(null);

            if(match != null){
                flight.completePlaces(match, origin);
                result.add(flight);
            }
        });

        return result;
    }

    @Override
    public RouteDetails findRouteDetails(String routeId) {
        return getTrainRouteDetails.getRouteDetails(routeId);
    }

    @Override
    public List<RouteDetails> findRouteDetails(List<String> routeIds, RouteSearchItemPlaceType type) {
        if (type == RouteSearchItemPlaceType.TRAIN_STATION) {
            return this.findTrainRouteDetails(routeIds);
        }
        return null;
    }

    private List<RouteDetails> findTrainRouteDetails(List<String> routeIds){
        List<RouteDetails> routes = routeIds.stream().map(this::findRouteDetails).toList();
        List<String> dbIds = routes.stream().flatMap(RouteDetails::retrieveAllDbIds).toList();
        List<String> uniqueList = new ArrayList<>(new HashSet<>(dbIds));

        HashMap<String, RouteSearchTrainStation> stationHashMap = new HashMap<>();
        findStationsFromDbId.findFromDbId(uniqueList).forEach(station -> stationHashMap.put(station.getDbId(), station));

        routes.forEach(route -> {
            RouteSearchTrainStation origin = stationHashMap.get(route.getOrigin().getDbId());
            if(origin != null){
                route.setOrigin(origin.toRouteSearchItemPlace());
            }
            RouteSearchTrainStation destination = stationHashMap.get(route.getDestination().getDbId());
            if(destination != null){
                route.setDestination(destination.toRouteSearchItemPlace());
            }
            route.getStops().forEach(stop -> {
                RouteSearchTrainStation stopStation = stationHashMap.get(stop.getDbId());
                if(stopStation != null){
                    stop.setStop(stopStation.toRouteSearchItemPlace());
                }
            });
        });
        return routes;
    }
}
