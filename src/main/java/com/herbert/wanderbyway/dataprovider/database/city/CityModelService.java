package com.herbert.wanderbyway.dataprovider.database.city;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.connectors.FindCitiesByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityModelService implements FindCitiesByName {

    CityModelRepository cityModelRepository;
    CityModelMapper cityModelMapper;

    public CityModelService(CityModelRepository cityModelRepository, CityModelMapper cityModelMapper) {
        this.cityModelRepository = cityModelRepository;
        this.cityModelMapper = cityModelMapper;
    }

    @Override
    public List<SearchItem> findByName(String query) {
        List<CityModel> results = cityModelRepository.findBySlugContaining(query);
        return cityModelMapper.toSearchResults(results);
    }
}
