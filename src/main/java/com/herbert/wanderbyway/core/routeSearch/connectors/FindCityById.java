package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchCity;

public interface FindCityById {
    RouteSearchCity findById(int id);
}
