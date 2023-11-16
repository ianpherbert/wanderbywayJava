package com.herbert.wanderbyway.dataprovider.airport;

import com.herbert.wanderbyway.dataprovider.common.LocationDB;
import com.herbert.wanderbyway.dataprovider.common.RouteDB;
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

}
