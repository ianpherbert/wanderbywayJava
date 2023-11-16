package com.herbert.wanderbyway.dataprovider.trainStation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainStationRepository extends MongoRepository<TrainStationDB, String> {
}
