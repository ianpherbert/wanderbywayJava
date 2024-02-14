package com.herbert.wanderbyway.dataprovider.database.city;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchTrainStation;
import com.herbert.wanderbyway.dataprovider.database.airport.AirportModel;
import com.herbert.wanderbyway.dataprovider.database.trainStation.TrainStationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityModelRepository extends JpaRepository<CityModel, Long> {
    List<CityModel> findBySlugContaining(String slug);

    CityModel findById(int id);
}
