package com.herbert.wanderbyway.dataprovider.city;

import com.herbert.wanderbyway.core.city.City;
import com.herbert.wanderbyway.core.trainStation.TrainStation;
import com.herbert.wanderbyway.dataprovider.trainStation.TrainStationDB;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDBMapper {
    public City toCity(CityDB cityDB);

    public CityDB toCityDB(City city);

    public List<City> toCities(List<CityDB> cityDBS);

    public List<CityDB> toCityDBs(List<City> cities);
}