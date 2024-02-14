package com.herbert.wanderbyway.dataprovider.trainRoute;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlace;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemType;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.TrainRoute;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.TrainRouteStop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrainRouteMapper {
    RouteSearchItem toRouteSearchItem(TrainRoute route) {
        TrainRouteStop originStop = route.getOrigin();
        TrainRouteStop destinationStop = route.getDestination();

        RouteSearchItemPlace origin = new RouteSearchItemPlace(
                originStop.getName(),
                null,
                RouteSearchItemPlaceType.TRAIN_STATION,
                originStop.getLocation().getLongitude(),
                originStop.getLocation().getLatitude(),
                null,
                null,
                originStop.getId()
        );

        RouteSearchItemPlace destination = new RouteSearchItemPlace(
                destinationStop.getName(),
                null,
                RouteSearchItemPlaceType.TRAIN_STATION,
                destinationStop.getLocation().getLongitude(),
                destinationStop.getLocation().getLatitude(),
                null,
                null,
                destinationStop.getId()
        );

        return new RouteSearchItem(RouteSearchItemType.TRAIN,  destination, origin,0);
    }

    List<RouteSearchItem> toRouteSearchItem(List<TrainRoute> route){
        return route.stream().map(this::toRouteSearchItem).toList();
    }
}