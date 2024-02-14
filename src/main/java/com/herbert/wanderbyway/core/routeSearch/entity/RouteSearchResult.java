package com.herbert.wanderbyway.core.routeSearch.entity;

import java.util.List;

public class RouteSearchResult {
    List<RouteSearchItem> results;
    RouteSearchItemPlace origin;

    public RouteSearchResult(List<RouteSearchItem> results, RouteSearchItemPlace origin) {
        this.results = results;
        this.origin = origin;
    }

    public List<RouteSearchItem> getResults() {
        return results;
    }

    public void setResults(List<RouteSearchItem> results) {
        this.results = results;
    }

    public RouteSearchItemPlace getOrigin() {
        return origin;
    }

    public void setOrigin(RouteSearchItemPlace origin) {
        this.origin = origin;
    }
}
