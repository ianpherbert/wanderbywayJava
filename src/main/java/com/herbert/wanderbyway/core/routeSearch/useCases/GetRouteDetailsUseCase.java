package com.herbert.wanderbyway.core.routeSearch.useCases;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;

import java.util.List;

public interface GetRouteDetailsUseCase {
    RouteDetails findRouteDetails(String routeId);
    List<RouteDetails> findRouteDetails(List<String> routeIds);
}
