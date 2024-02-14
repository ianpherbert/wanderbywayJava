package com.herbert.wanderbyway.utils.rest;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface SearchParams {
    MultiValueMap<String, String>  toMap();
}
