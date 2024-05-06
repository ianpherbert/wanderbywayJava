package com.herbert.wanderbyway.core.search;

import com.herbert.wanderbyway.core.search.connectors.*;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import com.herbert.wanderbyway.core.search.entity.SearchOptions;
import com.herbert.wanderbyway.core.search.useCases.FindAllByNameUseCase;
import com.herbert.wanderbyway.core.search.useCases.FindByIdAndTypeUseCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService implements FindAllByNameUseCase, FindByIdAndTypeUseCase {
    FindCitiesByName findCitiesByName;
    FindAirportsByName findAirportsByName;
    FindTrainStationsByName findTrainStationsByName;
    FindSearchStationById findSearchStationById;
    FindSearchAirportById findSearchAirportById;
    FindSearchCityById findSearchCityById;
    FindBusStationsByName findBusStationsByName;

    public SearchService(
            FindCitiesByName findCitiesByName,
            FindAirportsByName findAirportsByName,
            FindTrainStationsByName findTrainStationsByName,
            FindSearchStationById findSearchStationById,
            FindSearchAirportById findSearchAirportById,
            FindSearchCityById findSearchCityById,
            FindBusStationsByName findBusStationsByName
    ) {
        this.findCitiesByName = findCitiesByName;
        this.findAirportsByName = findAirportsByName;
        this.findTrainStationsByName = findTrainStationsByName;
        this.findSearchStationById = findSearchStationById;
        this.findSearchAirportById = findSearchAirportById;
        this.findSearchCityById = findSearchCityById;
        this.findBusStationsByName = findBusStationsByName;
    }

    @Override
    public List<SearchItem> findAllByName(String query, SearchOptions options) {
        List<SearchItem> results = new ArrayList<>();

        if(options.getCity()){
            results.addAll(findCitiesByName.findByName(query));
        }
        if(options.getTrain()){
            results.addAll(findTrainStationsByName.findByName(query));
        }
        if(options.getAirport()){
            results.addAll(findAirportsByName.findByName(query));
        }
        if(options.getBus()){
            results.addAll(findBusStationsByName.findBusStationsByName(query));
        }

       return results;
    }

    @Override
    public SearchItem findByIdAndType(int id, SearchItemType type) {
        switch (type){
            case CITY -> {
                return findSearchCityById.findSearchCityById(id);
            }
            case TRAIN_STATION -> {
                return findSearchStationById.findSearchStationById(id);
            }
            case AIRPORT -> {
                return findSearchAirportById.findSearchAirportById(id);
            }
            default -> {
                return null;
            }
        }
    }
}
