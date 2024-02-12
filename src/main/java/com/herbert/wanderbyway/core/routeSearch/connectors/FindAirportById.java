package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchAirport;

public interface FindAirportById {
    RouteSearchAirport findById(int id);
}
