package com.herbert.wanderbyway.dataprovider.trainStation;

import com.herbert.wanderbyway.dataprovider.common.LocationDB;
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

    private static class TrainCompanyIdDB {
        private String companyId;
        private String companyName;
        private String id;
    }
}

