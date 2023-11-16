package com.herbert.wanderbyway.core.city;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityService implements CityGetter {
    @Override
    public List<City> getAllCities() {
        return null;
    }

    @Override
    public List<City> searchCities(String queryString) {
        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(new City(queryString, CityType.MEDIUM_CITY, 9000, 90, 90, "France", "shareId", "idId", "areaId", new ArrayList<String>(), new ArrayList<String>()));
        return cityList;
    }

    @Override
    public City getCityById(String cityId) {
        return null;
    }
}
