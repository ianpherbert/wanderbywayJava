package com.herbert.wanderbyway.core.trainStation;

public class TrainCompanyId {
    private final String companyId;
    private final String companyName;
    private final String id;

    public TrainCompanyId(String companyId, String companyName, String id) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getId() {
        return id;
    }
}
