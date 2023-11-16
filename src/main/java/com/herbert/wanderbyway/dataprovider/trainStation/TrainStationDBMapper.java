package com.herbert.wanderbyway.dataprovider.trainStation;

import com.herbert.wanderbyway.core.trainStation.TrainStation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainStationDBMapper {
    public TrainStation toTrainStation(TrainStationDB trainStationDB);

    public TrainStationDB toTrainStationDB(TrainStation trainStation);

    public List<TrainStation> toTrainStations(List<TrainStationDB> trainStationDBS);

    public List<TrainStationDB> toTrainStationDBs(List<TrainStation> trainStations);
}
