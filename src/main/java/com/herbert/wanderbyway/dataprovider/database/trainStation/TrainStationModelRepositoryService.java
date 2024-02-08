package com.herbert.wanderbyway.dataprovider.database.trainStation;

import com.herbert.wanderbyway.core.search.SearchItem;
import com.herbert.wanderbyway.core.search.connectors.FindTrainStationsByName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainStationModelRepositoryService implements FindTrainStationsByName {

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
}
