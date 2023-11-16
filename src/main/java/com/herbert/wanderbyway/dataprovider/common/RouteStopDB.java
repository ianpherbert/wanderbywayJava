package com.herbert.wanderbyway.dataprovider.common;

public class RouteStopDB {
    private String id;
    private String name;
    private LocationDB location;
    private RouteStopTypeDB type;
}

enum RouteStopTypeDB {
    AIRPORT,
    BUS_STATION,
    TRAIN_STATION,
    FERRY_PORT,
    OTHER
}