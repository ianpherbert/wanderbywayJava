package com.herbert.wanderbyway.dataprovider.flight.entity;

import com.herbert.wanderbyway.utils.DateUtils;
import com.herbert.wanderbyway.utils.rest.SearchParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

public class FlightSearchParams implements SearchParams {
    String origin;
    String destination;
    String dateFrom;
    String dateTo;
    String limit = "1000";
    String sort = "duration";

    String maxStopovers = "0";
    String onePerCity = "true";

    public FlightSearchParams(){

    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setLimit(int limit) {
        this.limit = String.valueOf(limit);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setMaxStopovers(int maxStopovers) {
        this.maxStopovers = String.valueOf(maxStopovers);
    }

    public void setOnePerCity(boolean onePerCity) {
        this.onePerCity = String.valueOf(onePerCity);
    }

    public MultiValueMap<String, String> toMap(){

        MultiValueMap<String, String> items = new LinkedMultiValueMap<>();
        if(origin != null) items.add("fly_from", origin);
        if(destination != null) items.add("fly_to", destination);
        items.add("dateFrom", Objects.requireNonNullElseGet(dateFrom, DateUtils::getTodayString));
        items.add("dateTo", Objects.requireNonNullElseGet(dateTo, () -> DateUtils.weeksFromNowString(15)));
        if(maxStopovers != null) items.add("max_stopovers", maxStopovers);
        if(onePerCity != null) items.add("one_for_city", onePerCity);
        if(limit != null) items.add("limit", limit);
        if(sort != null) items.add("sort", sort);
        return items;
    }
}