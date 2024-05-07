package com.herbert.wanderbyway.dataprovider.bus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.herbert.wanderbyway.utils.DateUtils;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class BusRoute {
    @JsonProperty("trip_id")
    private String tripId;
    @JsonProperty("route_long_name")
    private String routeName;
    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
    private String companyCode;
    private Date date;
    private List<BusRouteStop> stops;

    public BusRoute(){}


    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            this.startDate = LocalDate.parse(startDate, formatter);
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.startDate = LocalDate.parse(endDate, formatter);
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<BusRouteStop> getStops() {
        return stops;
    }

    public void setStops(List<BusRouteStop> stops) {
        this.stops = stops;
    }

    public BusRouteStop getLastStop(){
        return this.stops.get(this.stops.size() -1);
    }

    public BusRouteStop getFirstStop(){
        return this.stops.get(0);
    }

    public long getDuration(){
        return DateUtils.calculateDifference(getFirstStop().getArrivalTime(), getLastStop().getArrivalTime());
    }

    public long getDuration(int startIndex){
        return DateUtils.calculateDifference(stops.get(startIndex).getArrivalTime(), getLastStop().getArrivalTime());
    }
}
