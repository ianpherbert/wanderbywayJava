package com.herbert.wanderbyway.core.search;

import com.herbert.wanderbyway.core.search.connectors.FindAirportsByName;
import com.herbert.wanderbyway.core.search.connectors.FindCitiesByName;
import com.herbert.wanderbyway.core.search.connectors.FindTrainStationsByName;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchOptions;
import com.herbert.wanderbyway.core.search.useCases.FindAllByNameUseCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService implements FindAllByNameUseCase {
    FindCitiesByName findCitiesByName;
    FindAirportsByName findAirportsByName;
    FindTrainStationsByName findTrainStationsByName;

    public SearchService(FindCitiesByName findCitiesByName, FindAirportsByName findAirportsByName, FindTrainStationsByName findTrainStationsByName) {
        this.findCitiesByName = findCitiesByName;
        this.findAirportsByName = findAirportsByName;
        this.findTrainStationsByName = findTrainStationsByName;
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

       return results;
    }
}
