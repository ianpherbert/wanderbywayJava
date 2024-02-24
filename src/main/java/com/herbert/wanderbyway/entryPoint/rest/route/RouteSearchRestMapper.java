package com.herbert.wanderbyway.entryPoint.rest.route;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchResult;
import com.herbert.wanderbyway.entryPoint.rest.route.entity.RouteSearchQueryResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RouteSearchRestMapper {
    RouteSearchQueryResult toRouteSearchQueryResult(RouteSearchResult result){
        return new RouteSearchQueryResult(result);
    }
}
