package com.herbert.wanderbyway.core.routeSearch.entity;

public class RouteSearchItemPlace {
    String name;
    String id;
    RouteSearchItemPlaceType type;
    Double longitude;
    Double latitude;
    String country;
    String iata;

    public RouteSearchItemPlace(String name, String id, RouteSearchItemPlaceType type, Double longitude, Double latitude, String country, String iata) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.iata = iata;
    }

    public RouteSearchItemPlace(RouteSearchAirport airport){
        this.name = airport.getName();
        this.id = airport.getId();
        this.type = RouteSearchItemPlaceType.AIRPORT;
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLongitude();
        this.iata = airport.getIata();
        this.country = airport.getCountry();
    }

    public static RouteSearchItemPlace buildSearchAirport(String iata){
        return new RouteSearchItemPlace(null, null, RouteSearchItemPlaceType.AIRPORT, null, null, null, iata);
    }

    public void completeFromAirport(RouteSearchAirport airport){
        this.id = airport.getId();
        this.latitude = airport.getLatitude();
        this.longitude = airport.getLongitude();
        this.country = airport.getCountry();
        this.name = airport.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        if(id != null) return id;
        return "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public RouteSearchItemPlaceType getType() {
        return type;
    }

    public void setType(RouteSearchItemPlaceType type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
