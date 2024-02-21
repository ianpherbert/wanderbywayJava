package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;

public interface GetTrainRouteDetails {
    RouteDetails getRouteDetails(String id);
}
