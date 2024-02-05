package com.herbert.wanderbyway.dataprovider.database.common;

public class RouteDB {
    private RouteStopDB to;
    private RouteTypeDB type;
    private int durationTotal;
    private int durationMinutes;
    private int durationHours;

    public RouteStopDB getTo() {
        return to;
    }

    public RouteTypeDB getType() {
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

