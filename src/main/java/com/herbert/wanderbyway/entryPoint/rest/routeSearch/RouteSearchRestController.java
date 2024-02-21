package com.herbert.wanderbyway.entryPoint.rest.routeSearch;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchResult;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;
import com.herbert.wanderbyway.core.routeSearch.useCases.GetRouteDetailsUseCase;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.entryPoint.rest.routeSearch.entity.RouteSearchQueryResult;
import com.herbert.wanderbyway.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/route")
public class RouteSearchRestController {

    FindRoutesFromPlaceUseCase findRoutesFromPlaceUseCase;
    RouteSearchRestMapper routeSearchRestMapper;
    GetRouteDetailsUseCase getRouteDetailsUseCase;

    public RouteSearchRestController(
            FindRoutesFromPlaceUseCase findRoutesFromPlaceUseCase,
            RouteSearchRestMapper routeSearchRestMapper,
            GetRouteDetailsUseCase getRouteDetailsUseCase
    ) {
        this.findRoutesFromPlaceUseCase = findRoutesFromPlaceUseCase;
        this.routeSearchRestMapper = routeSearchRestMapper;
        this.getRouteDetailsUseCase = getRouteDetailsUseCase;
    }

    @GetMapping("search/{id}")
    RouteSearchQueryResult getRoutes(
            @PathVariable int id,
            @RequestParam(required = true) RouteSearchItemPlaceType type
            ){
        try{
            RouteSearchResult routes = findRoutesFromPlaceUseCase.findRoutes(id, type);
            return routeSearchRestMapper.toRouteSearchQueryResult(routes);
        }catch (NotFoundException error){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Nothing fond for id: ".concat(String.valueOf(id)).concat("and type ").concat(type.name())
            );
        }

    }

    @GetMapping("/{id}")
    RouteDetails getRouteDetails(@PathVariable String id){
        return getRouteDetailsUseCase.findRouteDetails(id);
    }

}
