package com.herbert.wanderbyway.core.search;

public class SearchOptions {
    Boolean airport;
    Boolean train;
    Boolean city;
    Boolean port;
    Boolean bus;

    public SearchOptions(Boolean airport, Boolean train, Boolean city, Boolean port, Boolean bus) {
        this.airport = airport == null || airport;
        this.train = train == null || train;
        this.city = city == null || city;
        this.port = port == null || port;
        this.bus = bus == null || bus;
    }

    public Boolean getAirport() {
        return airport;
    }

    public Boolean getTrain() {
        return train;
    }

    public Boolean getCity() {
        return city;
    }

    public Boolean getPort() {
        return port;
    }

    public Boolean getBus() {
        return bus;
    }
}
