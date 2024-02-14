package com.herbert.wanderbyway.utils;

public enum DateFormat {
    DB_BAHN("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    TEQUILA("dd/MM/yyyy");

    private final String value;

    DateFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}