package com.herbert.wanderbyway.entryPoint.rest.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchResult;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.RouteSearchQueryResult;
import org.springframework.web.bind.annotation.*;

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
    RouteSearchQueryResult getRoutes(
            @PathVariable int id,
            @RequestParam(required = true) RouteSearchItemPlaceType type
            ){
        RouteSearchResult routes = findRoutesFromPlaceUseCase.findRoutes(id, type);
        return routeSearchRestMapper.toRouteSearchQueryResult(routes);
    }
}
