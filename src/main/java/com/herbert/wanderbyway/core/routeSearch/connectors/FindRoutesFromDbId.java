package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;

import java.util.List;

public interface FindRoutesFromDbId {
    List<RouteSearchItem> findRoutesWithDbId(String dbId);
}
