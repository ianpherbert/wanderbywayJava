package com.herbert.wanderbyway.dataprovider.database.airport;

import com.herbert.wanderbyway.core.search.SearchResult;
import com.herbert.wanderbyway.core.search.SearchResultType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AirportModelMapper {
    SearchResult toSearchResult(AirportModel airport){
        return new SearchResult(airport.getName(), airport.getSlug(), SearchResultType.AIRPORT, null, airport.getCountry());
    }

    List<SearchResult> toSearchResults(List<AirportModel> airports){
        return airports.stream().map(this::toSearchResult).toList();
    }
}
