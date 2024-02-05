package com.herbert.wanderbyway.core.trainStation;

import com.herbert.wanderbyway.core.common.Location;
import com.herbert.wanderbyway.core.route.RouteStop;
import com.herbert.wanderbyway.core.route.RouteStopType;

import java.util.List;

public class TrainStation {
    private final String name;
    private final String slug;
    private final Location location;
    private final Boolean airport;
    private final String airportId;
    private final String apiId;
    private final String uicId;
    private final List<TrainCompanyId> companyIds;
    private final String id;

    public TrainStation(String name, String slug, Location location, Boolean airport, String airportId, String apiId, String uicId, List<TrainCompanyId> companyIds, String id) {
        this.name = name;
        this.slug = slug;
        this.location = location;
        this.airport = airport;
        this.airportId = airportId;
        this.apiId = apiId;
        this.uicId = uicId;
        this.companyIds = companyIds;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public Location getLocation() {
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

    public List<TrainCompanyId> getCompanyIds() {
        return companyIds;
    }

    public String getId() {
        return id;
    }

    private RouteStop toRouteStop(){
        return new RouteStop(name, id, location, RouteStopType.TRAIN_STATION);
    }
}
