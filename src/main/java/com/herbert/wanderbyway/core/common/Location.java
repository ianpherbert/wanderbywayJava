package com.herbert.wanderbyway.core.common;

import java.util.List;

public class Location {
    private final Double latitude;
    private final Double longitude;
    private final List<Region> regions;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public Location(Double latitude, Double longitude, List<Region> regions) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.regions = regions;
    }




}

