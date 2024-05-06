package com.herbert.wanderbyway.dataprovider.bus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Location {
    private String id;
    private String name;
    @JsonProperty("postalcode")
    private String postalCode;
    @JsonProperty("countrycode")
    private String countryCode;
    private List<BusStop> stops;

    Location(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<BusStop> getStops() {
        return stops;
    }

    public void setStops(List<BusStop> stops) {
        this.stops = stops;
    }
}
