package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchAirport;

import java.util.List;

public interface FindAirportsFromIata {
    List<RouteSearchAirport> findFromIataIn(List<String> iatas);
    RouteSearchAirport findFromIata(String iata);
}
