package com.herbert.wanderbyway.core.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindFlightsFromAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteSearchService implements FindRoutesFromPlaceUseCase {
    FindFlightsFromAirport findFlightsFromAirport;

    public RouteSearchService(FindFlightsFromAirport findFlightsFromAirport) {
        this.findFlightsFromAirport = findFlightsFromAirport;
    }

    @Override
    public List<RouteSearchItem> findRoutes(String id, RouteSearchItemPlaceType type) {
        switch (type){
            case AIRPORT -> {
                return findFlightsFromAirport.findFlights(id);
            }
            default -> {
                return null;
            }
        }

    }
}
