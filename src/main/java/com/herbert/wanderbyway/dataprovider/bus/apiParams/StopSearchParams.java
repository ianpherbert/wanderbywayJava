package com.herbert.wanderbyway.dataprovider.bus.apiParams;

import com.herbert.wanderbyway.utils.rest.SearchParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

enum QueryType {
    NAME("name"),
    COORDINATES("coordinates");

    private final String value;

    QueryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

public class StopSearchParams implements SearchParams {
    private String queryString;
    private QueryType queryType;

    public StopSearchParams(){}

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setQueryType(String queryType) {
        this.queryType = QueryType.valueOf(queryType.toUpperCase());
    }


    public MultiValueMap<String, String> toMap() {
        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(queryString != null) items.add("queryString", queryString);
        if(queryType != null) items.add("queryType", queryType.getValue());
        return items;
    }
}
