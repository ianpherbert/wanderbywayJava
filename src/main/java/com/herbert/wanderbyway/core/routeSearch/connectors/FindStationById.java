package com.herbert.wanderbyway.core.routeSearch.connectors;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchTrainStation;

import java.util.List;

public interface FindStationById {
    RouteSearchTrainStation findById(int id);
}
