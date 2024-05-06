package com.herbert.wanderbyway.dataprovider.bus;

import com.herbert.wanderbyway.core.search.connectors.FindBusStationsByName;
import com.herbert.wanderbyway.core.search.entity.SearchItem;
import com.herbert.wanderbyway.dataprovider.bus.apiParams.LocationSearchParams;
import com.herbert.wanderbyway.dataprovider.bus.apiParams.RouteSearchParams;
import com.herbert.wanderbyway.dataprovider.bus.apiParams.StopSearchParams;
import com.herbert.wanderbyway.dataprovider.bus.entity.BusResult;
import com.herbert.wanderbyway.dataprovider.bus.entity.BusRoute;
import com.herbert.wanderbyway.dataprovider.bus.entity.BusStop;
import com.herbert.wanderbyway.dataprovider.bus.entity.Location;
import com.herbert.wanderbyway.exceptions.NotFoundException;
import com.herbert.wanderbyway.utils.DateFormat;
import com.herbert.wanderbyway.utils.DateUtils;
import com.herbert.wanderbyway.utils.rest.RestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

class LocationResults extends BusResult<Location>{}
class StopResults extends BusResult<BusStop>{}
class BusRouteResults extends BusResult<BusRoute>{}

@Service
public class BusController implements FindBusStationsByName {
    private final RestUtils restUtils;
    private final BusMapper busMapper;
    public BusController(RestTemplate restTemplate, @Value("${busApi.baseUrl}")String baseUrl, BusMapper busMapper){
        this.restUtils = new RestUtils(restTemplate, baseUrl);
        this.busMapper = busMapper;
    }
    private List<BusStop> doStopSearch(StopSearchParams params){
        try{
            return restUtils.call(Endpoints.STOP_SEARCH.getValue(), HttpMethod.GET, params, StopResults.class).getData();
        }catch (URISyntaxException error){
            return null;
        }
    }

    public List<BusStop> findStop(String name){
        StopSearchParams params = new StopSearchParams();
        params.setQueryString(name);
        params.setQueryType("name");
        return doStopSearch(params);
    }

    public List<BusStop> findStop(Double latitude, Double longitude){
        StopSearchParams params = new StopSearchParams();
        params.setQueryString(latitude.toString().concat(",").concat(longitude.toString()));
        params.setQueryType("coordinates");
        return doStopSearch(params);
    }

    public List<BusRoute> findRoutesForStopForDay(String stopId, Date date) throws URISyntaxException {
        RouteSearchParams params = new RouteSearchParams();
        params.setDate(DateUtils.formatDateToString(date, DateFormat.BUS_API));
        return restUtils.call(Endpoints.ROUTE.getValue(stopId), HttpMethod.GET, params, BusRouteResults.class).getData();
    }
    @Override
    public List<SearchItem> findBusStationsByName(String name) throws NotFoundException{
        LocationSearchParams params = new LocationSearchParams();
        params.setName(name);
        try{
            List<Location> results = restUtils.call(Endpoints.LOCATION.getValue(), HttpMethod.GET, params, LocationResults.class).getData();
            return busMapper.toSearchItems(results);
        }catch (URISyntaxException error){
            throw new NotFoundException("URI exception: ".concat(error.getMessage()));
        }
    }
}

