package com.herbert.wanderbyway.core.city.useCases;

import com.herbert.wanderbyway.core.city.City;

import java.util.List;

public interface FindCitiesUseCase {
    List<City> findCities();
    List<City> findCities(String query);
}
