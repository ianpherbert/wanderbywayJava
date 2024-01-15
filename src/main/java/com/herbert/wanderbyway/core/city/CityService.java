package com.herbert.wanderbyway.core.city;

import com.herbert.wanderbyway.core.city.connectors.FindCitiesConnector;
import com.herbert.wanderbyway.core.city.useCases.FindCitiesUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService implements FindCitiesUseCase {
    FindCitiesConnector findCitiesConnector;

    public CityService(FindCitiesConnector findCitiesConnector) {
        this.findCitiesConnector = findCitiesConnector;
    }

    @Override
    public List<City> findCities() {
        return findCitiesConnector.findCities();
    }

    @Override
    public List<City> findCities(String query) {
        return findCitiesConnector.findCities(query);
    }
}
