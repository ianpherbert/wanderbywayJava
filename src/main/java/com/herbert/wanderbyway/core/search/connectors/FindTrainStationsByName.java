package com.herbert.wanderbyway.core.search.connectors;

import com.herbert.wanderbyway.core.search.SearchItem;

import java.util.List;

public interface FindTrainStationsByName {
    List<SearchItem> findByName(String query);
}
