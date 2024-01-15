package com.herbert.wanderbyway.core.airport;

import com.herbert.wanderbyway.core.common.Location;
import com.herbert.wanderbyway.core.route.Route;
import com.herbert.wanderbyway.core.route.RouteStop;
import com.herbert.wanderbyway.core.route.RouteStopType;

import java.util.List;

public class Airport {
    private final String id;
    private final Location location;
    private final String name;
    private final String iata;
    private final String iaco;
    private final List<Route> routes;
    private final String slug;

    public Airport(String id, Location location, String name, String iata, String iaco, List<Route> routes, String slug) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.iata = iata;
        this.iaco = iaco;
        this.routes = routes;
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getIata() {
        return iata;
    }

    public String getIaco() {
        return iaco;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public RouteStop toRouteStop(){
        return new RouteStop(name, id, location, RouteStopType.AIRPORT);
    }
}
