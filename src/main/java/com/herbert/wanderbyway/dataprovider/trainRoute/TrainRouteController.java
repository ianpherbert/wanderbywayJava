package com.herbert.wanderbyway.dataprovider.trainRoute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindRoutesFromDbId;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.DepartureSearchResult;
import com.herbert.wanderbyway.dataprovider.trainRoute.entity.SearchParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainRouteController implements FindRoutesFromDbId {

    RestTemplate restTemplate;
    String baseUrl;
    TrainRouteMapper trainRouteMapper;
    public TrainRouteController(RestTemplate restTemplate, @Value("${dbBahn.baseUrl}")String baseUrl, TrainRouteMapper trainRouteMapper) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.trainRouteMapper = trainRouteMapper;
    }

    private URI buildUri(String endpoint, SearchParams params) throws URISyntaxException {
        return UriComponentsBuilder
                .fromHttpUrl(endpoint)
                .queryParams(params.toMap())
                .build()
                .toUri();
    }

    private <T>T callApi(URI uri, HttpMethod method, Class<T> responseType) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(null, headers);
        ResponseEntity<T> response = restTemplate.exchange(uri, method, request, responseType);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return null;
    }


    @Override
    public List<RouteSearchItem> findRoutesWithDbId(String dbId) {
        SearchParams params = new SearchParams();
            params.setWhen(ZonedDateTime.now().plusDays(7));
            params.setDuration(1440);
            params.setResults(500);
        String path = baseUrl.concat("stops/").concat(dbId).concat("/departures");
        try{
            URI uri = this.buildUri(path, params);
            DepartureSearchResult results = callApi(uri, HttpMethod.GET, DepartureSearchResult.class);
            assert results != null;
            return trainRouteMapper.toRouteSearchItem(results.getDepartures());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
