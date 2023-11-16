package com.herbert.wanderbyway.dataprovider.common;

public class RouteDB {
    private RouteStopDB to;
    private RouteTypeDB type;
    private int durationTotal;
    private int durationMinutes;
    private int durationHours;
}

enum RouteTypeDB {
    BUS,
    TRAIN,
    FLIGHT,
    FERRY,
    OTHER
}
