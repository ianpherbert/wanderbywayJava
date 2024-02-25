package com.herbert.wanderbyway.core.routeSearch.useCases;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchResult;

import java.util.Date;
import java.util.List;

public interface FindRoutesFromPlaceUseCase {
    RouteSearchResult findRoutes(int id, RouteSearchItemPlaceType type, Date startDate, Date endDate);
}
