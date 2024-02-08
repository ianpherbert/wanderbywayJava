package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.core.search.SearchResult;
import com.herbert.wanderbyway.core.search.SearchResultType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrainStationModelMapper {
    SearchResult toSearchResult(TrainStationModel station){
        return new SearchResult(station.getName(), station.getSlug(), SearchResultType.TRAIN_STATION, null, station.getCountry());
    }

    List<SearchResult> toSearchResults(List<TrainStationModel> stations){
        return stations.stream().map(this::toSearchResult).toList();
    }
}
