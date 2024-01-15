package com.herbert.wanderbyway.dataprovider.city;

import com.herbert.wanderbyway.core.city.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDBMapper {
    public City toCity(CityDB cityDB);


    public List<City> toCities(List<CityDB> cityDBS);


}