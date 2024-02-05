package com.herbert.wanderbyway.dataprovider.geoData.connectors;

import com.herbert.wanderbyway.dataprovider.geoData.entity.SearchElement;

public interface GetPlaceInfo {
    public SearchElement getInfo(String id);
}
