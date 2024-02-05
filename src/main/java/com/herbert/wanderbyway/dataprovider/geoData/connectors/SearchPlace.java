package com.herbert.wanderbyway.dataprovider.geoData.connectors;

import com.herbert.wanderbyway.dataprovider.geoData.entity.PlaceInfo;

import java.util.List;

public interface SearchPlace {
    public List<PlaceInfo> searchGeoData(String queryString);
}
