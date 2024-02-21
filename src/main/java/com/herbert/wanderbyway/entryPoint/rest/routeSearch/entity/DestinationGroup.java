package com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlace;

import java.util.List;

public class DestinationGroup {
    private final RouteSearchItemPlace destination;
    private final List<RouteSearchItem> routes;
    private final Double averageTime;

    public DestinationGroup(List<RouteSearchItem> items) {
        this.routes = items;
        this.destination = items.stream().findFirst().orElseThrow().getDestination();
        this.averageTime = items.stream()
                .mapToLong(RouteSearchItem::getDurationMinutes)
                .average().orElse(0);
    }

    public Double getAverageTime() {
        return this.averageTime;
    }

    public RouteSearchItemPlace getDestination() {
        return destination;
    }

    public List<RouteSearchItem> getRoutes() {
        return routes;
    }
}
