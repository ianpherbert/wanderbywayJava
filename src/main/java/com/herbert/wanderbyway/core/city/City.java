package com.herbert.wanderbyway.core.city;

import com.herbert.wanderbyway.core.common.Location;

import java.util.List;

public class City {
    private final String name;
    private final CityType type;
    private final int population;
    private final Location location;
    private final String country;
    private final String shareId;
    private final String id;
    private final String areaId;
    private final List<String> airports;
    private final List <String> trainStations;

    public City(
            String name,
            CityType type,
            int population,
            double latitude,
            double longitude,
            String country,
            String shareId,
            String id,
            String areaId,
            List<String> airports,
            List<String> trainStations
    ) {
        this.name = name;
        this.type = type;
        this.population = population;
        this.location = new Location(latitude, longitude, null);
        this.country = country;
        this.shareId = shareId;
        this.id = id;
        this.areaId = areaId;
        this.airports = airports;
        this.trainStations = trainStations;
    }

    public String getName() {
        return name;
    }

    public CityType getType() {
        return type;
    }

    public int getPopulation() {
        return population;
    }

    public Location getLocation(){
        return location;
    }

    public String getCountry() {
        return country;
    }

    public String getShareId() {
        return shareId;
    }

    public String getId() {
        return id;
    }

    public String getAreaId() {
        return areaId;
    }

    public List<String> getAirports() {
        return airports;
    }

    public List<String> getTrainStations() {
        return trainStations;
    }
}

enum CityType{
    MEGA_CITY,
    LARGE_CITY,
    MEDIUM_CITY,
    SMALL_CITY,
    TOWN,
    VILLAGE
}