package com.herbert.wanderbyway.dataprovider.flight;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindFlightsFromAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.dataprovider.flight.entity.FlightSearchResponse;
import com.herbert.wanderbyway.dataprovider.flight.entity.SearchParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Service
public class FlightService implements FindFlightsFromAirport {
    String tequilaApiKey;
    String baseUrl;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;
    FlightSearchMapper flightSearchMapper;

    public FlightService(
            @Value("${tequila.apiKey}")String tequilaApiKey,
            @Value("${tequila.baseUrl}")String baseUrl,
            ObjectMapper objectMapper,
            RestTemplate restTemplate,
            FlightSearchMapper flightSearchMapper
    ) {
        this.baseUrl = baseUrl;
        this.tequilaApiKey = tequilaApiKey;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
        this.flightSearchMapper = flightSearchMapper;
    }

    private HttpHeaders buildHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", tequilaApiKey);
        return headers;
    }

    private <T>T callApi(URI uri, HttpMethod method, Class<T> responseType) throws JsonProcessingException {
        HttpHeaders headers = buildHeaders();
        HttpEntity request = new HttpEntity(null, headers);
        ResponseEntity<T> response = restTemplate.exchange(uri, method, request, responseType);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return null;
    }

    private URI buildUri(String endpoint, SearchParams params) throws URISyntaxException {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl.concat(endpoint))
                .queryParams(params.toMap())
                .build()
                .toUri();
    }
    @Override
    public List<RouteSearchItem> findFlights(String iata) {
        try{
            SearchParams params = new SearchParams();
                params.setOrigin(iata);
            URI uri = buildUri("/search",params);
            FlightSearchResponse response = callApi(uri, HttpMethod.GET, FlightSearchResponse.class);
            assert response != null;
            return flightSearchMapper.toRouteSearchItems(response.getData());
        }catch (Exception e){
            //LOG
            return null;
        }
    }
}
