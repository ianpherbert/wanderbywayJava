package com.herbert.wanderbyway.entryPoint.rest.route;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchResult;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteDetails;
import com.herbert.wanderbyway.core.routeSearch.useCases.GetRouteDetailsUseCase;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import com.herbert.wanderbyway.entryPoint.rest.route.entity.RouteSearchQueryResult;
import com.herbert.wanderbyway.exceptions.NotFoundException;
import com.herbert.wanderbyway.utils.DateUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.herbert.wanderbyway.utils.DateFormat;

import java.util.Date;
import java.util.List;

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

    @Cacheable("routeSearch")
    @GetMapping("search/{id}")
    RouteSearchQueryResult getRoutes(
            @PathVariable int id,
            @RequestParam() RouteSearchItemPlaceType type,
            @RequestParam() String startDate
    ){
        try{
            Date start = DateUtils.parseDate(startDate, DateFormat.ENTRY.getValue());
            RouteSearchResult routes = findRoutesFromPlaceUseCase.findRoutes(id, type, start, start);
            return routeSearchRestMapper.toRouteSearchQueryResult(routes);
        }catch (NotFoundException error){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Nothing fond for id: ".concat(String.valueOf(id)).concat("and type ").concat(type.name())
            );
        }

    }

    @Cacheable("routeDetails")
    @GetMapping("/{id}")
    List<RouteDetails> getRouteDetails(@PathVariable String id, @RequestParam(required = true) RouteSearchItemPlaceType type){
        List<String> ids = List.of(id.split(","));
        return getRouteDetailsUseCase.findRouteDetails(ids, type);
    }

}
