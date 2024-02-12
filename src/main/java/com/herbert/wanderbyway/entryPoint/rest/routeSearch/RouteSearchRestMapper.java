package com.herbert.wanderbyway.entryPoint.rest.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.DestinationGroup;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.RouteSearchResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RouteSearchRestMapper {
    RouteSearchResult toDestinationGroup(List<RouteSearchItem> items){
        return new RouteSearchResult(items);
    }
}
