package com.herbert.wanderbyway.dataprovider.database.trainStation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainStationModelRepository  extends JpaRepository<TrainStationModel, Long> {
    List<TrainStationModel> findBySlugContaining(String slug);
}
