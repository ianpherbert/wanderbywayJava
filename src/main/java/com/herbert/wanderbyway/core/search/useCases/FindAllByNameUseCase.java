package com.herbert.wanderbyway.core.search.useCases;

import com.herbert.wanderbyway.core.search.SearchItem;

import java.util.List;

public interface FindAllByNameUseCase {
    List<SearchItem> findAllByName(String query);
}
