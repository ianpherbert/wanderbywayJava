package com.herbert.wanderbyway.core.search.connectors;

import com.herbert.wanderbyway.core.search.SearchResult;

import java.util.List;

public interface FindTrainStationsByName {
    List<SearchResult> findByName(String query);
}
