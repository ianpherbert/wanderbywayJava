package com.herbert.wanderbyway.core.search;

import com.herbert.wanderbyway.core.search.connectors.FindAirportsByName;
import com.herbert.wanderbyway.core.search.connectors.FindCitiesByName;
import com.herbert.wanderbyway.core.search.connectors.FindTrainStationsByName;
import com.herbert.wanderbyway.core.search.useCases.FindAllByNameUseCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    public List<SearchItem> findAllByName(String query) {
        List<SearchItem> cities = findCitiesByName.findByName(query);
        List<SearchItem> airports = findAirportsByName.findByName(query);
        List<SearchItem> trainStations = findTrainStationsByName.findByName(query);
        List<SearchItem> results = new ArrayList<SearchItem>();
       Stream.of(cities.stream(), airports.stream(), trainStations.stream()).forEach(it ->results.addAll(it.toList()));
       return results;
    }
}
