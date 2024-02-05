package com.herbert.wanderbyway.utils;

import com.fasterxml.jackson.core.type.TypeReference;

public interface RestController {
    public <T> T get(String url, TypeReference<T> responseType);
    public <T> T post(String url, TypeReference<T> responseType);
    public <T> T post(String url, Object body, TypeReference<T> responseType);
    public <T> T post(String url, String body, TypeReference<T> responseType);

}
