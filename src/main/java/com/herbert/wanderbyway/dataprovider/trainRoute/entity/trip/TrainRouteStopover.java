package com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip;

import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStop;

public class TrainRouteStopover {
    TrainRouteStop stop;
    String arrival;
    String plannedArrival;
    String arrivalDelay;
    String arrivalPlatform;
    String arrivalPrognosisType;
    String plannedDeparture;
    String departureDelay;
    String departurePlatform;
    String departurePrognosisType;
    String plannedDeparturePlatform;

    public TrainRouteStopover(){}

    public TrainRouteStop getStop() {
        return stop;
    }

    public void setStop(TrainRouteStop stop) {
        this.stop = stop;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getPlannedArrival() {
        return plannedArrival;
    }

    public void setPlannedArrival(String plannedArrival) {
        this.plannedArrival = plannedArrival;
    }

    public String getArrivalDelay() {
        return arrivalDelay;
    }

    public void setArrivalDelay(String arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public String getArrivalPlatform() {
        return arrivalPlatform;
    }

    public void setArrivalPlatform(String arrivalPlatform) {
        this.arrivalPlatform = arrivalPlatform;
    }

    public String getArrivalPrognosisType() {
        return arrivalPrognosisType;
    }

    public void setArrivalPrognosisType(String arrivalPrognosisType) {
        this.arrivalPrognosisType = arrivalPrognosisType;
    }

    public String getPlannedDeparture() {
        return plannedDeparture;
    }

    public void setPlannedDeparture(String plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    public String getDepartureDelay() {
        return departureDelay;
    }

    public void setDepartureDelay(String departureDelay) {
        this.departureDelay = departureDelay;
    }

    public String getDeparturePlatform() {
        return departurePlatform;
    }

    public void setDeparturePlatform(String departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public String getDeparturePrognosisType() {
        return departurePrognosisType;
    }

    public void setDeparturePrognosisType(String departurePrognosisType) {
        this.departurePrognosisType = departurePrognosisType;
    }

    public String getPlannedDeparturePlatform() {
        return plannedDeparturePlatform;
    }

    public void setPlannedDeparturePlatform(String plannedDeparturePlatform) {
        this.plannedDeparturePlatform = plannedDeparturePlatform;
    }
}

