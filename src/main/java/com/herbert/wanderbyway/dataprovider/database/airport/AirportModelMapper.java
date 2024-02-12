package com.herbert.wanderbyway.dataprovider.database.airport;

import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AirportModelMapper {
    SearchItem toSearchResult(AirportModel airport){
        return new SearchItem(airport.getId(), airport.getName(), airport.getSlug(), SearchItemType.AIRPORT, null, airport.getCountry());
    }

    List<SearchItem> toSearchResults(List<AirportModel> airports){
        return airports.stream().map(this::toSearchResult).toList();
    }
}
