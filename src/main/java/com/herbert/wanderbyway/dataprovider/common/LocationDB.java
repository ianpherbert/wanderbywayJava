package com.herbert.wanderbyway.dataprovider.common;

import com.herbert.wanderbyway.core.common.Region;

import java.util.List;

public class LocationDB {
    private Double latitude;
    private Double longitude;
    private List<Region> regions;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Region> getRegions() {
        return regions;
    }
}
