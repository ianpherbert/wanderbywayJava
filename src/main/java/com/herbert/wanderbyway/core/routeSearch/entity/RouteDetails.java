package com.herbert.wanderbyway.core.routeSearch.entity;


import java.util.List;

public class RouteDetails {
    RouteSearchItemPlace origin;
    RouteSearchItemPlace destination;
    String departure;
    String arrival;
    long duration;
    String routeId;
    RouteSearchItemType type;
    List<RouteStop> stops;
    List<String> operators;

    public RouteDetails(
            RouteSearchItemPlace origin,
            RouteSearchItemPlace destination,
            String departure, String arrival,
            long duration, String routeId,
            RouteSearchItemType type,
            List<RouteStop> stops,
            List<String> operators
    ) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
        this.routeId = routeId;
        this.type = type;
        this.stops = stops;
        this.operators = operators;
    }

    public RouteSearchItemPlace getOrigin() {
        return origin;
    }

    public void setOrigin(RouteSearchItemPlace origin) {
        this.origin = origin;
    }

    public RouteSearchItemPlace getDestination() {
        return destination;
    }

    public void setDestination(RouteSearchItemPlace destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public RouteSearchItemType getType() {
        return type;
    }

    public void setType(RouteSearchItemType type) {
        this.type = type;
    }

    public List<RouteStop> getStops() {
        return stops;
    }

    public List<String> getOperators() {
        return operators;
    }
}
