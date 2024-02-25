package com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip;

public class TripSearchResult {
    int realtimeDataUpdatedAt;
    TrainRouteTrip trainRouteTrip;

    public TripSearchResult(){}

    public int getRealtimeDataUpdatedAt() {
        return realtimeDataUpdatedAt;
    }

    public void setRealtimeDataUpdatedAt(int realtimeDataUpdatedAt) {
        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
    }

    public TrainRouteTrip getTrip() {
        return trainRouteTrip;
    }

    public void setTrip(TrainRouteTrip trainRouteTrip) {
        this.trainRouteTrip = trainRouteTrip;
    }
}
