package com.herbert.wanderbyway.dataprovider.database.city;

import com.herbert.wanderbyway.core.search.SearchResult;
import com.herbert.wanderbyway.core.search.SearchResultType;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CityModelMapper {
    SearchResult toSearchResult(CityModel city) {
        List<SearchResult> stations = city.getStations().stream().map(station ->
                new SearchResult(station.getName(), station.getSlug(), SearchResultType.TRAIN_STATION, null, station.getCountry())
        ).toList();
        List<SearchResult> airports = city.getAirports().stream().map(airport ->
                new SearchResult(airport.getName(), airport.getSlug(), SearchResultType.AIRPORT, null, airport.getCountry())
        ).toList();
        List<SearchResult> children = new ArrayList<>();
        children.addAll(stations);
        children.addAll(airports);

        return new SearchResult(city.getName(), city.getSlug(), SearchResultType.CITY, children, city.getCountry());
    }

    List<SearchResult> toSearchResults(List<CityModel> cities){
        return cities.stream().map(this::toSearchResult).toList();
    }
}
