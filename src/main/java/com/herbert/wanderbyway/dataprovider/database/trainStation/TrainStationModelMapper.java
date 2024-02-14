package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchTrainStation;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrainStationModelMapper {
    SearchItem toSearchResult(TrainStationModel station){
        return new SearchItem(station.getId(), station.getName(), station.getSlug(), SearchItemType.TRAIN_STATION, null, station.getCountry());
    }

    List<SearchItem> toSearchResults(List<TrainStationModel> stations){
        return stations.stream().map(this::toSearchResult).toList();
    }

    abstract List<RouteSearchTrainStation> toRouteSearchTrainStation(List<TrainStationModel> station);
    abstract RouteSearchTrainStation toRouteSearchTrainStation(TrainStationModel station);
}
