package com.herbert.wanderbyway.core.routeSearch.useCases;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;

public interface GetRouteDetailsUseCase {
    RouteDetails findRouteDetails(String routeId);
}
