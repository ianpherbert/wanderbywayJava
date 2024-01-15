package com.herbert.wanderbyway.dataprovider.city;

import com.herbert.wanderbyway.dataprovider.common.LocationDB;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CityDB {
    private String name;
    private CityDBType type;
    private int population;
    private LocationDB location;
    private String shareId;
    private String id;
    private List<String> areaId;
    private List<String> airports;
    private List <String> trainStations;
    private String slug;

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public CityDBType getType() {
        return type;
    }

    public int getPopulation() {
        return population;
    }

    public LocationDB getLocation() {
        return location;
    }

    public String getShareId() {
        return shareId;
    }

    public String getId() {
        return id;
    }

    public List<String> getAreaId() {
        return areaId;
    }

    public List<String> getAirports() {
        return airports;
    }

    public List<String> getTrainStations() {
        return trainStations;
    }
}

