package com.herbert.wanderbyway.core.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindAirportById;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindAirportsFromIata;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindFlightsFromAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteSearchService implements FindRoutesFromPlaceUseCase {
    FindFlightsFromAirport findFlightsFromAirport;
    FindAirportsFromIata findAirportsFromIata;

    FindAirportById findAirportById;
    public RouteSearchService(
            FindFlightsFromAirport findFlightsFromAirport,
            FindAirportsFromIata findAirportsFromIata,
            FindAirportById findAirportById
    ) {
        this.findFlightsFromAirport = findFlightsFromAirport;
        this.findAirportsFromIata = findAirportsFromIata;
        this.findAirportById = findAirportById;
    }

    @Override
    public List<RouteSearchItem> findRoutes(int id, RouteSearchItemPlaceType type) {
        switch (type){
            case AIRPORT -> {
                return this.getFlightRoutes(id);
            }
            default -> {
                return null;
            }
        }

    }

    private List<RouteSearchItem> getFlightRoutes(int id){
        RouteSearchAirport origin = findAirportById.findById(id);
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
