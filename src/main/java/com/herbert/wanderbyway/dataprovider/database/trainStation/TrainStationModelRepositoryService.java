package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindStationById;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindStationsFromDbId;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchTrainStation;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.connectors.FindTrainStationsByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainStationModelRepositoryService implements FindTrainStationsByName, FindStationById, FindStationsFromDbId {

    TrainStationModelMapper trainStationModelMapper;
    TrainStationModelRepository trainStationModelRepository;

    public TrainStationModelRepositoryService(TrainStationModelMapper trainStationModelMapper, TrainStationModelRepository trainStationModelRepository) {
        this.trainStationModelMapper = trainStationModelMapper;
        this.trainStationModelRepository = trainStationModelRepository;
    }

    @Override
    public List<SearchItem> findByName(String query) {
        List<TrainStationModel> results = trainStationModelRepository.findBySlugContaining(query);
        return trainStationModelMapper.toSearchResults(results);
    }

    @Override
    public RouteSearchTrainStation findById(int id) {
        TrainStationModel result = trainStationModelRepository.findById(id);
        if(result == null) return null;
        return trainStationModelMapper.toRouteSearchTrainStation(result);
    }

    @Override
    public List<RouteSearchTrainStation> findFromDbId(List<String> dbIds) {
        List<TrainStationModel> results = trainStationModelRepository.findByDbIdIn(dbIds);
        if(results.isEmpty()) return null;
        return trainStationModelMapper.toRouteSearchTrainStation(results);
    }
}
