package com.herbert.wanderbyway.dataprovider.database.city;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindRouteSearchCityById;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchCity;
import com.herbert.wanderbyway.core.search.connectors.FindSearchCityById;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.connectors.FindCitiesByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteSearchCityModelService implements FindCitiesByName, FindRouteSearchCityById, FindSearchCityById {

    CityModelRepository cityModelRepository;
    CityModelMapper cityModelMapper;

    public RouteSearchCityModelService(CityModelRepository cityModelRepository, CityModelMapper cityModelMapper) {
        this.cityModelRepository = cityModelRepository;
        this.cityModelMapper = cityModelMapper;
    }

    @Override
    public List<SearchItem> findByName(String query) {
        List<CityModel> results = cityModelRepository.findBySlugContaining(query);
        return cityModelMapper.toSearchResults(results);
    }

    @Override
    public RouteSearchCity findRouteSearchCityById(int id) {
        CityModel result = cityModelRepository.findById(id);
        if(result == null) return null;
        return cityModelMapper.toRouteSearchCity(result);
    }

    @Override
    public SearchItem findSearchCityById(int id) {
        CityModel result = cityModelRepository.findById(id);
        return cityModelMapper.toSearchResult(result);
    }
}
