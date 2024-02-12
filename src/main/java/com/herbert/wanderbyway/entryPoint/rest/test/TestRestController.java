package com.herbert.wanderbyway.entryPoint.rest.test;

import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItemPlaceType;
import com.herbert.wanderbyway.core.routeSearch.useCases.FindRoutesFromPlaceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestRestController {
    @Autowired
    FindRoutesFromPlaceUseCase findRoutesFromPlaceUseCase;

    @GetMapping("/airport/{id}")
    List<RouteSearchItem> getFlights(@PathVariable int id){
        return findRoutesFromPlaceUseCase.findRoutes(id, RouteSearchItemPlaceType.AIRPORT);
    }
}
