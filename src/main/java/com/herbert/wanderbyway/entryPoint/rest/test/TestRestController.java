package com.herbert.wanderbyway.entryPoint.rest.test;

import com.herbert.wanderbyway.core.routeSearch.connectors.FindRoutesFromDbId;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
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
    FindRoutesFromDbId findRoutesFromDbId;

    @GetMapping("/station/{id}")
    List<RouteSearchItem> getFlights(@PathVariable String id){
        return findRoutesFromDbId.findRoutesWithDbId(id);
    }
}
