package com.herbert.wanderbyway.dataprovider.database.city;

import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CityModelMapper {
    SearchItem toSearchResult(CityModel city) {
        List<SearchItem> stations = city.getStations().stream().map(station ->
                new SearchItem(station.getId(), station.getName(), station.getSlug(), SearchItemType.TRAIN_STATION, null, station.getCountry())
        ).toList();
        List<SearchItem> airports = city.getAirports().stream().map(airport ->
                new SearchItem(airport.getId(), airport.getName(), airport.getSlug(), SearchItemType.AIRPORT, null, airport.getCountry())
        ).toList();
        List<SearchItem> children = new ArrayList<>();
        children.addAll(stations);
        children.addAll(airports);

        return new SearchItem(city.getId(), city.getName(), city.getSlug(), SearchItemType.CITY, children, city.getCountry());
    }

    List<SearchItem> toSearchResults(List<CityModel> cities){
        return cities.stream().map(this::toSearchResult).toList();
    }
}
