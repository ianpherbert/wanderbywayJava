package com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteLine;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStop;

import java.util.List;

public class TrainRoute {
    String tripId;
    @JsonProperty("stop")
    TrainRouteStop origin;
    String when;
    String plannedWhen;
    String delay;
    String platform;
    String plannedPlatform;
    String prognosisType;
    String direction;
    String provenance;
    TrainRouteLine line;
    List<String> remarks;
    String originName;
    TrainRouteStop destination;

    public TrainRoute(){}

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public TrainRouteStop getOrigin() {
        return origin;
    }

    public void setOrigin(TrainRouteStop origin) {
        this.origin = origin;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getPlannedWhen() {
        return plannedWhen;
    }

    public void setPlannedWhen(String plannedWhen) {
        this.plannedWhen = plannedWhen;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlannedPlatform() {
        return plannedPlatform;
    }

    public void setPlannedPlatform(String plannedPlatform) {
        this.plannedPlatform = plannedPlatform;
    }

    public String getPrognosisType() {
        return prognosisType;
    }

    public void setPrognosisType(String prognosisType) {
        this.prognosisType = prognosisType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public TrainRouteLine getLine() {
        return line;
    }

    public void setLine(TrainRouteLine line) {
        this.line = line;
    }

    public List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public TrainRouteStop getDestination() {
        return destination;
    }

    public void setDestination(TrainRouteStop destination) {
        this.destination = destination;
    }

    public List<String> getProviders(){
        return List.of(this.line.getOperator().getId());
    }
}
