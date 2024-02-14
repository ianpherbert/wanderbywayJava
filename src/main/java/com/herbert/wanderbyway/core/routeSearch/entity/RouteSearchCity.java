package com.herbert.wanderbyway.core.routeSearch.entity;

import java.util.List;

public class RouteSearchCity {
    private final String id;
    private final String name;
    private final String country;
    private final Double latitude;
    private final Double longitude;
    private final List<RouteSearchTrainStation> stations;
    private final List<RouteSearchAirport> airports;

    public RouteSearchCity(
            String name,
            String country,
            Double latitude,
            Double longitude,
            List<RouteSearchTrainStation> stations,
            List<RouteSearchAirport> airports,
            String id
    ) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stations = stations;
        this.airports = airports;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<RouteSearchTrainStation> getStations() {
        return stations;
    }

    public List<RouteSearchAirport> getAirports() {
        return airports;
    }

    public String getId() {
        return id;
    }
}
