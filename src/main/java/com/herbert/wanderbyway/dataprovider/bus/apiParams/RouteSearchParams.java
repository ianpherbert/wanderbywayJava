package com.herbert.wanderbyway.dataprovider.bus.apiParams;

import com.herbert.wanderbyway.utils.rest.SearchParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class RouteSearchParams implements SearchParams {
    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public MultiValueMap<String, String> toMap() {
        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(date != null) items.add("date", date);
        return items;
    }
}
