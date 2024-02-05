package com.herbert.wanderbyway.dataprovider.geoData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbert.wanderbyway.dataprovider.geoData.connectors.GetPlaceInfo;
import com.herbert.wanderbyway.dataprovider.geoData.connectors.SearchPlace;
import com.herbert.wanderbyway.dataprovider.geoData.entity.PlaceInfo;
import com.herbert.wanderbyway.dataprovider.geoData.entity.SearchElement;

import com.herbert.wanderbyway.utils.RestController;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class PlaceController implements SearchPlace, GetPlaceInfo {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final RestController restController;

    public PlaceController(RestTemplate restTemplate, ObjectMapper objectMapper, RestController restController) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.restController = restController;
    }

    private String createUrl(String queryString){
        return String.format("https://nominatim.openstreetmap.org/search?format=json&q=%s", queryString);
    }

    @Override
    public List<PlaceInfo> searchGeoData(String queryString) {
        String url = createUrl(queryString);
        return restController.get(url, new TypeReference<List<PlaceInfo>>() {});
    }


    @Override
    public SearchElement getInfo(String id) {
        String query = "[out:json];relation("+id+");out body;";
        return restController.post("https://overpass-api.de/api/interpreter", query, new TypeReference<SearchElement>() {});
    }
}
