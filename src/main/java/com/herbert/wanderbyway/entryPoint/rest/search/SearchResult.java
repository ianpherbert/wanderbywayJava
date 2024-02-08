package com.herbert.wanderbyway.entryPoint.rest.search;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.SearchOptions;

import java.util.List;

public class SearchResult {
    int count;
    SearchOptions options;
    List<SearchItem> results;

    public SearchResult(int count, SearchOptions options, List<SearchItem> results) {
        this.count = count;
        this.options = options;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public SearchOptions getOptions() {
        return options;
    }

    public List<SearchItem> getResults() {
        return results;
    }
}
