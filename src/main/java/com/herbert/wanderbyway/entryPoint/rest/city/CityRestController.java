package com.herbert.wanderbyway.entryPoint.rest.city;

import com.herbert.wanderbyway.core.city.City;
import com.herbert.wanderbyway.core.city.useCases.FindCitiesUseCase;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityRestController {

    private final FindCitiesUseCase findCitiesUseCase;

    public CityRestController(FindCitiesUseCase findCitiesUseCase) {
        this.findCitiesUseCase = findCitiesUseCase;
    }

    @GetMapping("")
    List<City> getAllCities(){
        return findCitiesUseCase.findCities();
    }

    @GetMapping("/{query}")
    List<City> findCity(@PathVariable String query){
        System.out.println(query);
        return findCitiesUseCase.findCities(query);
    }

}
