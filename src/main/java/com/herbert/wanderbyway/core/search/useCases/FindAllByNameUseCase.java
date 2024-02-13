package com.herbert.wanderbyway.core.search.useCases;

import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchOptions;

import java.util.List;

public interface FindAllByNameUseCase {
    List<SearchItem> findAllByName(String query, SearchOptions options);
}
