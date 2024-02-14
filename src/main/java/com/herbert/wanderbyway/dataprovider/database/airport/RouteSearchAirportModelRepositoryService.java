package com.herbert.wanderbyway.dataprovider.database.airport;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindRouteSearchAirportById;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindAirportsFromIata;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchAirport;
import com.herbert.wanderbyway.core.search.connectors.FindSearchAirportById;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.connectors.FindAirportsByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteSearchAirportModelRepositoryService implements FindAirportsByName, FindAirportsFromIata, FindRouteSearchAirportById, FindSearchAirportById {
    AirportModelRepository airportModelRepository;
    AirportModelMapper airportModelMapper;

    public RouteSearchAirportModelRepositoryService(AirportModelRepository airportModelRepository, AirportModelMapper airportModelMapper) {
        this.airportModelRepository = airportModelRepository;
        this.airportModelMapper = airportModelMapper;
    }


    @Override
    public List<SearchItem> findByName(String query) {
        List<AirportModel> results = airportModelRepository.findBySlugContaining(query);
        return airportModelMapper.toSearchResults(results);
    }

    @Override
    public List<RouteSearchAirport> findFromIataIn(List<String> iatas) {
        List<AirportModel> results = airportModelRepository.findByIataIn(iatas);
        return airportModelMapper.toRouteSearchAirport(results);
    }

    @Override
    public RouteSearchAirport findFromIata(String iata) {
        AirportModel result = airportModelRepository.findByIata(iata);
        return airportModelMapper.toRouteSearchAirport(result);
    }

    @Override
    public RouteSearchAirport findRouteSearchAirportById(int id) {
        AirportModel result = airportModelRepository.findById(id);
        return airportModelMapper.toRouteSearchAirport(result);
    }

    @Override
    public SearchItem findSearchAirportById(int id) {
        AirportModel result = airportModelRepository.findById(id);
        return airportModelMapper.toSearchResult(result);
    }
}
