package com.herbert.wanderbyway.dataprovider.airport;

import com.herbert.wanderbyway.core.airport.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportDBMapper {
    public Airport toAirport(AirportDB airportDB);

    public List<Airport> toCities(List<AirportDB> airportDBS);
}
