package com.herbert.wanderbyway.dataprovider.bus;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlace;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemType;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.core.search.entity.SearchItemType;
import com.herbert.wanderbyway.dataprovider.bus.entity.BusRoute;
import com.herbert.wanderbyway.dataprovider.bus.entity.Location;
import com.herbert.wanderbyway.utils.StringUtils;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
abstract class BusMapper {
    SearchItem toSearchItem(Location location){
        return new SearchItem(
                location.getId(),
                location.getName(),
                StringUtils.removeAccentsAndSpecialCharacters(location.getName()),
                SearchItemType.BUS_STATION,
                location.getStops().stream().map(stop -> new SearchItem(
                        stop.getId(),
                        stop.getName(),
                        StringUtils.removeAccentsAndSpecialCharacters(stop.getName()),
                        SearchItemType.BUS_STATION,
                        null,
                        location.getCountryCode()
                )).toList(),
                location.getCountryCode()
        );
    }

    List<SearchItem> toSearchItems(List<Location> locations){
        return locations.stream().map(this::toSearchItem).toList();
    }

    List<RouteSearchItem> toRouteSearchItems(List<BusRoute> routes){
        return routes.stream().map(this::toRouteSearchItem).toList();
    }

    RouteSearchItem toRouteSearchItem(BusRoute route){
        return new RouteSearchItem(
                RouteSearchItemType.BUS,
                new RouteSearchItemPlace(route.getLastStop()),
                new RouteSearchItemPlace(route.getFirstStop()),
                route.getDuration(),
                route.getFirstStop().getDepartureTime(),
                route.getLastStop().getArrivalTime(),
                null,
                route.getTripId()
        );
    }
}
