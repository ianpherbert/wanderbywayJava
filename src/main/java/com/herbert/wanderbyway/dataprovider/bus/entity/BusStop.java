package com.herbert.wanderbyway.dataprovider.bus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusStop {
    @JsonProperty("stop_id")
    private String id;
    @JsonProperty("stop_name")
    private String name;
    @JsonProperty("stop_lat")
    private Double latitude;
    @JsonProperty("stop_lon")
    private Double longitude;
    @JsonProperty("stop_timezone")
    private String timeZone;
    private String company;

    public BusStop(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getCompany() {
        return company;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}