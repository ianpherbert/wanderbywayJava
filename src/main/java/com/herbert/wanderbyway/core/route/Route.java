package com.herbert.wanderbyway.core.route;

public class Route {
    private final RouteStop to;
    private final RouteType type;
    private final int durationTotal;
    private final int durationMinutes;
    private final int durationHours;

    public Route(RouteStop to, RouteType type, int durationTotal, int durationMinutes, int durationHours) {
        this.to = to;
        this.type = type;
        this.durationTotal = durationTotal;
        this.durationMinutes = durationMinutes;
        this.durationHours = durationHours;
    }
    public RouteStop getTo() {
        return to;
    }

    public RouteType getType() {
        return type;
    }

    public int getDurationTotal() {
        return durationTotal;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getDurationHours() {
        return durationHours;
    }


}
