package com.herbert.wanderbyway.dataprovider.trainRoute.entity.common;

import com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures.TrainRouteStopProducts;

public class TrainRouteStop {
    private String type;
    private String id;
    private String name;
    private TrainRouteStopLocation location;
    private TrainRouteStopProducts products;

    public TrainRouteStop() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainRouteStopLocation getLocation() {
        return location;
    }

    public void setLocation(TrainRouteStopLocation location) {
        this.location = location;
    }

    public TrainRouteStopProducts getProducts() {
        return products;
    }

    public void setProducts(TrainRouteStopProducts products) {
        this.products = products;
    }
}
