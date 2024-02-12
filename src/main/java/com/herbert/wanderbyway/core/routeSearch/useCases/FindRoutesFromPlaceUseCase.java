package com.herbert.wanderbyway.core.routeSearch.useCases;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;

import java.util.List;

public interface FindRoutesFromPlaceUseCase {
    List<RouteSearchItem> findRoutes(int id, RouteSearchItemPlaceType type);
}
