package com.herbert.wanderbyway.dataprovider.city;

import com.herbert.wanderbyway.core.city.City;
import com.herbert.wanderbyway.core.city.connectors.FindCitiesConnector;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDBService implements FindCitiesConnector {
    private final CityDBMapper cityDBMapper;
    private final CityRepository cityRepository;


    public CityDBService(CityDBMapper cityDBMapper, CityRepository cityRepository) {
        this.cityDBMapper = cityDBMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findCities() {
        List<CityDB> allCities = cityRepository.findAll();
        return cityDBMapper.toCities(allCities);
    }

    @Override
    public List<City> findCities(String query) {
        List<CityDB> cities = cityRepository.findCityDBBySlugContaining(query);
        return cityDBMapper.toCities(cities);
    }
}
