package com.herbert.wanderbyway.utils.rest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.lang.model.type.NullType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class RestUtils {
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final HttpHeaders headers = new HttpHeaders();
    public RestUtils(RestTemplate restTemplate, String baseUrl, List<Header> headers) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.forEach(this::setHeader);
    }

    public RestUtils(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    private void setHeader(Header header){
        this.headers.set(header.getKey(), header.getValue());
    }

    private <T>T callApi(URI uri, HttpMethod method, Class<T> responseType) {
        HttpEntity<NullType> request = new HttpEntity<>(null, this.headers);
        ResponseEntity<T> response = this.restTemplate.exchange(uri, method, request, responseType);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return null;
    }

    private <T, B>T callApi(URI uri, HttpMethod method, B body, Class<T> responseType) {
        HttpEntity<B> request = new HttpEntity<B>(body, this.headers);
        ResponseEntity<T> response = this.restTemplate.exchange(uri, method, request, responseType);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return null;
    }

    private URI buildUri(String endpoint, SearchParams params) throws URISyntaxException {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl.concat(endpoint))
                .queryParams(params.toMap())
                .build()
                .toUri();
    }

    private URI buildUri(String endpoint) throws URISyntaxException {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl.concat(endpoint))
                .build()
                .toUri();
    }

    public <T> T call(String endpoint, HttpMethod method, Class<T> responseType) throws URISyntaxException {
        URI uri = buildUri(endpoint);
        return callApi(uri, method, responseType);
    }

    public <T> T call(String endpoint, HttpMethod method, SearchParams params, Class<T> responseType) throws URISyntaxException {
        URI uri = buildUri(endpoint, params);
        return callApi(uri, method, responseType);
    }

    public <T, B> T call(String endpoint, HttpMethod method, SearchParams params, B body, Class<T> responseType) throws URISyntaxException {
        URI uri = buildUri(endpoint, params);
        return callApi(uri, method, body, responseType);
    }

}
