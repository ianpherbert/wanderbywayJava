package com.herbert.wanderbyway.core.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.connectors.*;
import com.herbert.wanderbyway.core.routeSearch.entity.*;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteSearchService implements FindRoutesFromPlaceUseCase {
    FindFlightsFromAirport findFlightsFromAirport;
    FindRoutesFromDbId findRoutesFromDbId;
    FindAirportsFromIata findAirportsFromIata;
    FindAirportById findAirportById;
    FindStationById findStationById;
    FindStationsFromDbId findStationsFromDbId;
    FindCityById findCityById;

    public RouteSearchService(
            FindFlightsFromAirport findFlightsFromAirport,
            FindAirportsFromIata findAirportsFromIata,
            FindAirportById findAirportById,
            FindRoutesFromDbId findRoutesFromDbId,
            FindStationsFromDbId findStationsFromDbId,
            FindStationById findStationById,
            FindCityById findCityById
    ) {
        this.findFlightsFromAirport = findFlightsFromAirport;
        this.findAirportsFromIata = findAirportsFromIata;
        this.findAirportById = findAirportById;
        this.findRoutesFromDbId = findRoutesFromDbId;
        this.findStationsFromDbId = findStationsFromDbId;
        this.findStationById = findStationById;
        this.findCityById = findCityById;
    }

    @Override
    public RouteSearchResult findRoutes(int id, RouteSearchItemPlaceType type) throws NotFoundException {
        switch (type){
            case AIRPORT -> {
                return Optional.ofNullable(findAirportById.findById(id))
                        .map(origin -> new RouteSearchResult(getFlightRoutes(origin), new RouteSearchItemPlace(origin)))
                        .orElseThrow(() -> new NotFoundException("Could not find airport for id: " + id));
            }
            case TRAIN_STATION -> {
                return Optional.ofNullable(findStationById.findById(id))
                        .map(origin -> new RouteSearchResult(getTrainRoutes(origin), new RouteSearchItemPlace(origin)))
                        .orElseThrow(() -> new NotFoundException("Could not find station for id: " + id));
            }
            case CITY -> {
                RouteSearchCity origin = Optional.ofNullable(findCityById.findById(id)).orElseThrow(() -> new NotFoundException("Could not find city for id: " + id));
                List<RouteSearchItem> routes = new LinkedList<RouteSearchItem>();
                origin.getAirports().forEach(it -> routes.addAll(this.getFlightRoutes(it)));
                origin.getStations().forEach(it -> routes.addAll(this.getTrainRoutes(it)));
                return new RouteSearchResult(routes, new RouteSearchItemPlace(origin));
            }
            default -> {
                throw new NotFoundException("Could not find station for id: " + id);
            }
        }
    }

    private List<RouteSearchItem> getTrainRoutes(RouteSearchTrainStation origin){
        if(!origin.hasDbId()) return new ArrayList<>();
        List<RouteSearchItem> routes = findRoutesFromDbId.findRoutesWithDbId(origin.getDbId());
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

    private List<RouteSearchItem> getFlightRoutes(RouteSearchAirport origin){
        List<RouteSearchItem> flights = findFlightsFromAirport.findFlights(origin.getIata());
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
}
