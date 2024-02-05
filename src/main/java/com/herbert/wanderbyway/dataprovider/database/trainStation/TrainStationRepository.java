package com.herbert.wanderbyway.dataprovider.database.trainStation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainStationRepository extends MongoRepository<TrainStationDB, String> {
}
