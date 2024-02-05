package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.dataprovider.database.common.LocationDB;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class TrainStationDB {
    private String name;
    private String slug;
    private LocationDB location;
    private Boolean airport;
    private String airportId;
    private String apiId;
    private String uicId;
    private List<TrainCompanyIdDB> companyIds;
    private String id;

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public LocationDB getLocation() {
        return location;
    }

    public Boolean getAirport() {
        return airport;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getApiId() {
        return apiId;
    }

    public String getUicId() {
        return uicId;
    }

    public List<TrainCompanyIdDB> getCompanyIds() {
        return companyIds;
    }

    public String getId() {
        return id;
    }
}

