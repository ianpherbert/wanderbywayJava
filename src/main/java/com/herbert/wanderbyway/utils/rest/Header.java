package com.herbert.wanderbyway.utils.rest;

public class Header {
    private final String key;
    private final String value;

    public Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Header(String key, int value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public Header(String key, boolean value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public Header(String key, Double value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public Header(String key, Float value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
