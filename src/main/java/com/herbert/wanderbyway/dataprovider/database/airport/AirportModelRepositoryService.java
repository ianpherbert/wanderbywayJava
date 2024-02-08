package com.herbert.wanderbyway.dataprovider.database.airport;

import com.herbert.wanderbyway.core.search.SearchResult;
import com.herbert.wanderbyway.core.search.connectors.FindAirportsByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirportModelRepositoryService implements FindAirportsByName {
    AirportModelRepository airportModelRepository;
    AirportModelMapper airportModelMapper;

    public AirportModelRepositoryService(AirportModelRepository airportModelRepository, AirportModelMapper airportModelMapper) {
        this.airportModelRepository = airportModelRepository;
        this.airportModelMapper = airportModelMapper;
    }


    @Override
    public List<SearchResult> findByName(String query) {
        List<AirportModel> results = airportModelRepository.findBySlugContaining(query);
        return airportModelMapper.toSearchResults(results);
    }
}
