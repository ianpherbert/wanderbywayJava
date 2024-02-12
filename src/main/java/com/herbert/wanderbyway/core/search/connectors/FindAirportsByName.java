package com.herbert.wanderbyway.core.search.connectors;

import com.herbert.wanderbyway.core.search.entity.SearchItem;

import java.util.List;

public interface FindAirportsByName {
    List<SearchItem> findByName(String query);
}
