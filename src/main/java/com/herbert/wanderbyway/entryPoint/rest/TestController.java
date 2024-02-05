package com.herbert.wanderbyway.entryPoint.rest;

import com.herbert.wanderbyway.dataprovider.geoData.connectors.GetPlaceInfo;
import com.herbert.wanderbyway.dataprovider.geoData.connectors.SearchPlace;
import com.herbert.wanderbyway.dataprovider.geoData.entity.PlaceInfo;
import com.herbert.wanderbyway.dataprovider.geoData.entity.SearchElement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    SearchPlace searchPlace;
    GetPlaceInfo getPlaceInfo;

    public TestController(SearchPlace searchPlace, GetPlaceInfo getPlaceInfo) {
        this.searchPlace = searchPlace;
        this.getPlaceInfo = getPlaceInfo;
    }

    @GetMapping("/search/{query}")
    List<PlaceInfo> findCity(@PathVariable String query){
        return searchPlace.searchGeoData(query);
    }

    @GetMapping("/find/{query}")
    SearchElement getCity(@PathVariable String query){
        return getPlaceInfo.getInfo(query);
    }
}
