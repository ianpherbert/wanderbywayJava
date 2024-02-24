package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;

import java.util.List;

public interface GetTrainRouteDetails {
    RouteDetails getRouteDetails(String id);
    List<RouteDetails> getRouteDetails(List<String> ids);
}
