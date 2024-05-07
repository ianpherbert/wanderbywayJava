package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;

import java.util.Date;
import java.util.List;

public interface FindBusRoutesFromLocationId {
    List<RouteSearchItem> findRoutes(int locationId);

    List<RouteSearchItem> findRoutes(int locationId, Date date);
}
