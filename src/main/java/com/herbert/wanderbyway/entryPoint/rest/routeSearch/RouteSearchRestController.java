package com.herbert.wanderbyway.entryPoint.rest.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlace;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemType;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.RouteSearchResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search/route")
public class RouteSearchRestController {

    FindRoutesFromPlaceUseCase findRoutesFromPlaceUseCase;
    RouteSearchRestMapper routeSearchRestMapper;

    public RouteSearchRestController(
            FindRoutesFromPlaceUseCase findRoutesFromPlaceUseCase,
            RouteSearchRestMapper routeSearchRestMapper
            ) {
        this.findRoutesFromPlaceUseCase = findRoutesFromPlaceUseCase;
        this.routeSearchRestMapper = routeSearchRestMapper;
    }

    @GetMapping("/{id}")
    RouteSearchResult getRoutes(
            @PathVariable int id,
            @RequestParam(required = true) RouteSearchItemPlaceType type
            ){
        List<RouteSearchItem> routes = findRoutesFromPlaceUseCase.findRoutes(id, type);
        return routeSearchRestMapper.toDestinationGroup(routes);
    }
}
