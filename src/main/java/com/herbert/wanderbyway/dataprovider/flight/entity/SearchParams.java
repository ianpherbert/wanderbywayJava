package com.herbert.wanderbyway.dataprovider.flight.entity;

import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class SearchParams {
    // date from
    String fly_from;
    // date to
    String fly_to;
    String dateFrom;
    String dateTo;

    public SearchParams(String fly_from) {
        this.fly_from = fly_from;
    }

    public SearchParams(String fly_from, String fly_to, String dateFrom, String dateTo) {
        this.fly_from = fly_from;
        this.fly_to = fly_to;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public MultiValueMap<String, String> toMap(){
        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(fly_from != null) items.add("fly_from", fly_from);
        if(fly_to != null) items.add("fly_to", fly_to);
        if(dateFrom != null) items.add("dateFrom", dateFrom);
        if(dateTo != null) items.add("dateTo", dateTo);
        return items;
    }
}