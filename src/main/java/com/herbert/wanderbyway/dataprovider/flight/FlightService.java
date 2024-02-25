package com.herbert.wanderbyway.dataprovider.flight;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbert.wanderbyway.core.routeSearch.connectors.FindFlightsFromAirport;
import com.herbert.wanderbyway.core.routeSearch.entity.RouteSearchItem;
import com.herbert.wanderbyway.dataprovider.flight.entity.FlightSearchResponse;
import com.herbert.wanderbyway.dataprovider.flight.entity.FlightSearchParams;
import com.herbert.wanderbyway.utils.DateFormat;
import com.herbert.wanderbyway.utils.DateUtils;
import com.herbert.wanderbyway.utils.rest.Header;
import com.herbert.wanderbyway.utils.rest.RestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightService implements FindFlightsFromAirport {
    String tequilaApiKey;
    String baseUrl;
    ObjectMapper objectMapper;
    FlightSearchMapper flightSearchMapper;
    RestUtils restUtils;

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
        this.flightSearchMapper = flightSearchMapper;
        this.restUtils = new RestUtils(restTemplate, baseUrl, List.of(new Header("apiKey", tequilaApiKey)));
    }
    @Override
    public List<RouteSearchItem> findFlights(String iata, Date startDate, Date endDate) {
        try{
            FlightSearchParams params = new FlightSearchParams();
            params.setOrigin(iata);
            params.setDateFrom(DateUtils.formatDateToString(startDate, DateFormat.TEQUILA));
            params.setDateTo(DateUtils.formatDateToString(endDate, DateFormat.TEQUILA));
            FlightSearchResponse response = restUtils.call("/search", HttpMethod.GET, params, FlightSearchResponse.class);
            if(response == null) return new ArrayList<>();
            return flightSearchMapper.toRouteSearchItems(response.getData());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
