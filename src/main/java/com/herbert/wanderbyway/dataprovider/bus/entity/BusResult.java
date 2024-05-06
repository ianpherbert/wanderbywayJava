package com.herbert.wanderbyway.dataprovider.bus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class BusResult <T>{
    private int count;
    private Map<String, String> query;
    @JsonProperty("delay_ms")
    private int delay;
    private List<T> data;

    public BusResult(){}

    public int getCount() {
        return count;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public int getDelay() {
        return delay;
    }

    public List<T> getData() {
        return data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
