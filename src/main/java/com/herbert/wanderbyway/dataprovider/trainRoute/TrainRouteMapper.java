package com.herbert.wanderbyway.dataprovider.trainRoute;


import com.herbert.wanderbyway.core.routeSearch.entity.*;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.common.TrainRouteStop;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.departures.TrainRoute;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip.TrainRouteTrip;
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

        return new RouteSearchItem(
                RouteSearchItemType.TRAIN,
                destination,
                origin,
                0,
                route.getWhen(),
                null,
                route.getProviders(),
                route.getTripId().replace("|", "-")
                );
    }

    List<RouteSearchItem> toRouteSearchItem(List<TrainRoute> route){
        return route.stream().map(this::toRouteSearchItem).toList();
    }

    RouteDetails toTrainRouteDetails(TrainRouteTrip trip){
        TrainRouteStop originStop = trip.getOrigin();
        TrainRouteStop destinationStop = trip.getDestination();

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
        return new RouteDetails(origin, destination, trip.getDeparture(), trip.getArrival(), trip.getDuration(), trip.getId(), RouteSearchItemType.TRAIN);

    }
}