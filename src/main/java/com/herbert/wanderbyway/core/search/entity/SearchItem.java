package com.herbert.wanderbyway.core.search.entity;

import java.util.List;

public class SearchItem {
    String id;
    String name;
    String slug;
    SearchItemType type;
    String country;
    List<SearchItem> children;

    public SearchItem(String id, String name, String slug, SearchItemType type, List<SearchItem> children, String country) {
        this.id = id;
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

    public SearchItemType getType() {
        return type;
    }

    public List<SearchItem> getChildren() {
        return children;
    }

    public String getId() {
        return id;
    }
}
