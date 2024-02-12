package com.herbert.wanderbyway.dataprovider.flight.entity;

import com.herbert.wanderbyway.utils.DateUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

public class SearchParams {
    String origin;
    String destination;
    String dateFrom;
    String dateTo;

    String maxStopovers = "0";
    String onePerCity = "true";
    public SearchParams(String origin) {
        this.origin = origin;
    }

    public SearchParams(String origin, String destination, String dateFrom, String dateTo) {
        this.origin = origin;
        this.destination = destination;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public MultiValueMap<String, String> toMap(){

        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(origin != null) items.add("fly_from", origin);
        if(destination != null) items.add("fly_to", destination);
        items.add("dateFrom", Objects.requireNonNullElseGet(dateFrom, DateUtils::getTodayString));
        items.add("dateTo", Objects.requireNonNullElseGet(dateTo, () -> DateUtils.weeksFromNowString(15)));
        if(maxStopovers!= null) items.add("max_stopovers", maxStopovers);
        if(onePerCity != null) items.add("one_for_city", onePerCity);
        items.add("limit", "1000");
        items.add("sort", "duration");
        return items;
    }
}