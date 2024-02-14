package com.herbert.wanderbyway.core.search.useCases;

import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;

public interface FindByIdAndTypeUseCase {
    SearchItem findByIdAndType(int id, SearchItemType type);
}
