package com.herbert.wanderbyway.core.search.useCases;

import com.herbert.wanderbyway.core.search.SearchResult;

import java.util.List;

public interface FindAllByNameUseCase {
    List<SearchResult> findAllByName(String query);
}
