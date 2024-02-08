package com.herbert.wanderbyway.core.search;

import java.util.List;

public class SearchItem {
    int id;
    String name;
    String slug;
    SearchItemType type;
    String country;
    List<SearchItem> children;

    public SearchItem(int id, String name, String slug, SearchItemType type, List<SearchItem> children, String country) {
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

    public int getId() {
        return id;
    }
}
