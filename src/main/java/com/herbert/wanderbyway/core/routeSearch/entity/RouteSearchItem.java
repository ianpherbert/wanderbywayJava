package com.herbert.wanderbyway.core.routeSearch.entity;

public class RouteSearchItem {
    RouteSearchItemType type;
    RouteSearchItemPlace origin;
    RouteSearchItemPlace destination;
    int durationMinutes;

    public RouteSearchItem(RouteSearchItemType type, RouteSearchItemPlace destination, int durationMinutes) {
        this.type = type;
        this.destination = destination;
        this.durationMinutes = durationMinutes;
    }

    public void completePlaces(RouteSearchAirport toAirport, RouteSearchAirport fromAirport){
        this.origin = new RouteSearchItemPlace(fromAirport);
        this.destination.completeFromAirport(toAirport);
    }

    public RouteSearchItemType getType() {
        return type;
    }

    public void setType(RouteSearchItemType type) {
        this.type = type;
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

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDestinationIata(){
        return this.destination.getIata();
    }
}
