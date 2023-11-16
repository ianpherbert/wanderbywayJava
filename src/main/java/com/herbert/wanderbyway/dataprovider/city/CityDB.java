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
    private String country;
    private String shareId;
    private String id;
    private String areaId;
    private List<String> airports;
    private List <String> trainStations;
}

enum CityDBType{
    MEGA_CITY,
    LARGE_CITY,
    MEDIUM_CITY,
    SMALL_CITY,
    TOWN,
    VILLAGE
}