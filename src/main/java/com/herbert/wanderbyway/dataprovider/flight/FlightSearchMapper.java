package com.herbert.wanderbyway.dataprovider.flight;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlace;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemType;
import com.herbert.wanderbyway.dataprovider.flight.entity.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FlightSearchMapper {
    RouteSearchItem toRouteSearchItem(Flight flight){
        RouteSearchItemPlace to = RouteSearchItemPlace.buildSearchAirport(flight.getCityCodeTo());
        return new RouteSearchItem(RouteSearchItemType.PLANE, to, flight.getDuration().getTotal() );
    }

    List<RouteSearchItem> toRouteSearchItems(List<Flight> flights){
        return flights.stream().map(this::toRouteSearchItem).toList();
    }
}
