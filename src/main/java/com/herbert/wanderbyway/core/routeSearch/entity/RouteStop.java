package com.herbert.wanderbyway.core.routeSearch.entity;

import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStop;

public class RouteStop {
    private final String name;
    private final String dbId;
    private final Double latitude;
    private final Double longitude;
    private final String arrival;
    private final String plannedArrival;
    private final String arrivalDelay;
    private final String arrivalPlatform;
    private final String plannedDeparture;
    private final String departureDelay;

    public RouteStop(String name, String dbId, Double latitude, Double longitude, String arrival, String plannedArrival, String arrivalDelay, String arrivalPlatform, String plannedDeparture, String departureDelay) {
        this.name = name;
        this.dbId = dbId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.arrival = arrival;
        this.plannedArrival = plannedArrival;
        this.arrivalDelay = arrivalDelay;
        this.arrivalPlatform = arrivalPlatform;
        this.plannedDeparture = plannedDeparture;
        this.departureDelay = departureDelay;
    }

    public String getName() {
        return name;
    }

    public String getDbId() {
        return dbId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getArrival() {
        return arrival;
    }

    public String getPlannedArrival() {
        return plannedArrival;
    }

    public String getArrivalDelay() {
        return arrivalDelay;
    }

    public String getArrivalPlatform() {
        return arrivalPlatform;
    }

    public String getPlannedDeparture() {
        return plannedDeparture;
    }

    public String getDepartureDelay() {
        return departureDelay;
    }
}
