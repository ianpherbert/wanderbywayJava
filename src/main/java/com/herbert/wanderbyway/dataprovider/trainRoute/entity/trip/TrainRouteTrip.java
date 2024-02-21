package com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip;

import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteLine;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStop;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStopLocation;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TrainRouteTrip {
    private String departure;
    private String plannedDeparture;
    private String departureDelay;
    private String arrival;
    private String plannedArrival;
    private String arrivalDelay;
    private List<TrainRouteStopover> stopovers;
    private TrainRouteStop origin;
    private TrainRouteStop destination;
    private TrainRouteLine line;
    private String direction;
    private TrainRouteStopLocation currentLocation;
    private String arrivalPlatform;
    private String plannedArrivalPlatform;
    private String arrivalPrognosisType;
    private String departurePlatform;
    private String plannedDeparturePlatform;
    private String departurePrognosisType;
    private List<TrainRouteRemark> trainRouteRemarks;
    private String id;


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

    public List<TrainRouteStopover> getStopovers() {
        return stopovers;
    }

    public void setStopovers(List<TrainRouteStopover> stopovers) {
        this.stopovers = stopovers;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
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

    public long getDuration() {
        if (this.arrival == null || this.departure == null) return 0;
        OffsetDateTime startTime = OffsetDateTime.parse(this.departure);
        OffsetDateTime endTime = OffsetDateTime.parse(this.arrival);

        return ChronoUnit.MINUTES.between(startTime, endTime);
    }

    public TrainRouteStop getOrigin() {
        return origin;
    }

    public void setOrigin(TrainRouteStop origin) {
        this.origin = origin;
    }

    public TrainRouteStop getDestination() {
        return destination;
    }

    public void setDestination(TrainRouteStop destination) {
        this.destination = destination;
    }

    public TrainRouteLine getTrainRouteLine() {
        return line;
    }

    public void setTrainRouteLine(TrainRouteLine line) {
        this.line = line;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public TrainRouteStopLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(TrainRouteStopLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getArrivalPlatform() {
        return arrivalPlatform;
    }

    public void setArrivalPlatform(String arrivalPlatform) {
        this.arrivalPlatform = arrivalPlatform;
    }

    public String getPlannedArrivalPlatform() {
        return plannedArrivalPlatform;
    }

    public void setPlannedArrivalPlatform(String plannedArrivalPlatform) {
        this.plannedArrivalPlatform = plannedArrivalPlatform;
    }

    public String getArrivalPrognosisType() {
        return arrivalPrognosisType;
    }

    public void setArrivalPrognosisType(String arrivalPrognosisType) {
        this.arrivalPrognosisType = arrivalPrognosisType;
    }

    public String getDeparturePlatform() {
        return departurePlatform;
    }

    public void setDeparturePlatform(String departurePlatform) {
        this.departurePlatform = departurePlatform;
    }

    public String getPlannedDeparturePlatform() {
        return plannedDeparturePlatform;
    }

    public void setPlannedDeparturePlatform(String plannedDeparturePlatform) {
        this.plannedDeparturePlatform = plannedDeparturePlatform;
    }

    public String getDeparturePrognosisType() {
        return departurePrognosisType;
    }

    public void setDeparturePrognosisType(String departurePrognosisType) {
        this.departurePrognosisType = departurePrognosisType;
    }

    public List<TrainRouteRemark> getRemarks() {
        return trainRouteRemarks;
    }

    public void setRemarks(List<TrainRouteRemark> trainRouteRemarks) {
        this.trainRouteRemarks = trainRouteRemarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

