package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.SearchItemType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrainStationModelMapper {
    SearchItem toSearchResult(TrainStationModel station){
        return new SearchItem(station.getName(), station.getSlug(), SearchItemType.TRAIN_STATION, null, station.getCountry());
    }

    List<SearchItem> toSearchResults(List<TrainStationModel> stations){
        return stations.stream().map(this::toSearchResult).toList();
    }
}
