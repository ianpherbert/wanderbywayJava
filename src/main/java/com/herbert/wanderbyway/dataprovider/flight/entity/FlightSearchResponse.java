package com.herbert.wanderbyway.dataprovider.flight.entity;

import java.util.List;

public class FlightSearchResponse {
        String search_id;
        String currency;
        List<Flight> data;
        int fx_rate;
        int _results;

    public FlightSearchResponse() {
    }

    public List<Flight> getData() {
        return data;
    }

    public void setData(List<Flight> data) {
        this.data = data;
    }

    public String getSearch_id() {
        return search_id;
    }

    public void setSearch_id(String search_id) {
        this.search_id = search_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getFx_rate() {
        return fx_rate;
    }

    public void setFx_rate(int fx_rate) {
        this.fx_rate = fx_rate;
    }

    public int get_results() {
        return _results;
    }

    public void set_results(int _results) {
        this._results = _results;
    }
}
