package com.herbert.wanderbyway.dataprovider.database.airport;

import com.herbert.wanderbyway.dataprovider.database.common.LocationDB;
import com.herbert.wanderbyway.dataprovider.database.common.RouteDB;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class AirportDB {
    private String id;
    private LocationDB location;
    private String name;
    private String iata;
    private String iaco;
    private List<RouteDB> routes;
    private String slug;

    public String getSlug() {
        return slug;
    }

    public String getId() {
        return id;
    }

    public LocationDB getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getIata() {
        return iata;
    }

    public String getIaco() {
        return iaco;
    }

    public List<RouteDB> getRoutes() {
        return routes;
    }
}
