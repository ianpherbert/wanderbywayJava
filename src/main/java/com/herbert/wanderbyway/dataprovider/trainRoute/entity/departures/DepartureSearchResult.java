package com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures;

import java.util.List;

public class DepartureSearchResult {
    List<TrainRoute> departures;
    int realtimeDataUpdatedAt;

    public DepartureSearchResult() {
    }

    public List<TrainRoute> getDepartures() {
        return departures;
    }

    public void setDepartures(List<TrainRoute> departures) {
        this.departures = departures;
    }

    public int getRealtimeDataUpdatedAt() {
        return realtimeDataUpdatedAt;
    }

    public void setRealtimeDataUpdatedAt(int realtimeDataUpdatedAt) {
        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
    }
}
