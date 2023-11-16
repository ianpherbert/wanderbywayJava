package com.herbert.wanderbyway.core.route;

import com.herbert.wanderbyway.core.common.Location;

public class RouteStop {
    private final String id;
    private final String name;
    private final Location location;
    private final RouteStopType type;

    public RouteStop(String name, String id, Location location, RouteStopType type) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public RouteStopType getType() {
        return type;
    }

}

