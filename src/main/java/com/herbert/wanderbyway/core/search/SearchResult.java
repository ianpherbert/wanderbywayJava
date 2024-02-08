package com.herbert.wanderbyway.core.search;

import java.util.List;

public class SearchResult {
    String name;
    String slug;
    SearchResultType type;
    String country;
    List<SearchResult> children;

    public SearchResult(String name, String slug, SearchResultType type, List<SearchResult> children, String country) {
        this.name = name;
        this.slug = slug;
        this.type = type;
        this.children = children;
        this.country = country;
    }

    public String getCountry(){
        return this.country;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public SearchResultType getType() {
        return type;
    }

    public List<SearchResult> getChildren() {
        return children;
    }
}
