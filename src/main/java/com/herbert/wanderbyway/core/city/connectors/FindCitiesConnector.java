package com.herbert.wanderbyway.core.city.connectors;

import com.herbert.wanderbyway.core.city.City;

import java.util.List;

public interface FindCitiesConnector {
    public List<City> findCities();
    public List<City> findCities(String query);
}
