package com.herbert.wanderbyway.dataprovider.bus;

public enum Endpoints {
    STOP_SEARCH("/stop"),
    ROUTE("/route/location"),
    LOCATION("/location");
    private final String value;

    Endpoints(String value) {
        this.value = value;
    }

    public String getValue() {
            return this.value;
    }

    public String getValue(String param) {
        return this.value.concat("/").concat(param);
    }

}