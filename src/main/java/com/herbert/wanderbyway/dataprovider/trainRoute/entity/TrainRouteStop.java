package com.herbert.wanderbyway.dataprovider.trainRoute.entity;

public class TrainRouteStop {
    String type;
    String id;
    String name;
    TrainRouteStopLocation location;
    TrainRouteStopProducts products;

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
