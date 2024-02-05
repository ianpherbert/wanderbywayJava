package com.herbert.wanderbyway.dataprovider.database.common;

public class RouteStopDB {
    private String id;
    private String name;
    private LocationDB location;
    private RouteStopTypeDB type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocationDB getLocation() {
        return location;
    }

    public RouteStopTypeDB getType() {
        return type;
    }
}

