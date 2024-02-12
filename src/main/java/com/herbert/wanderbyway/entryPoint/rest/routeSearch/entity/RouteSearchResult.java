package com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.DestinationGroup;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RouteSearchResult {
    private final List<DestinationGroup> destinations;
    private final int count;

    public RouteSearchResult(List<RouteSearchItem> items){
        Map<String,List<RouteSearchItem>> groupedItems = items.stream().collect(Collectors.groupingBy(it -> it.getDestination().getId()));
        this.destinations = groupedItems.values().stream().map(DestinationGroup::new).toList();
        this.count = items.size();
    }

    public List<DestinationGroup> getDestinations() {
        return destinations;
    }

    public int getCount() {
        return this.count;
    }
}
