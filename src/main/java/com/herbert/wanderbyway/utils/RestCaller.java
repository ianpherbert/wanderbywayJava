package com.herbert.wanderbyway.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCaller implements RestController{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public RestCaller(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private <T> T getData(String url, Object requestBody, TypeReference<T> responseType, HttpMethod method, MediaType mediaType) {
        try {
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);

            // Create the HTTP entity with the JSON body and headers
            HttpEntity<String> httpEntity = new HttpEntity<>(jsonBody, headers);

            // Perform the POST request and get the response
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, httpEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                // Deserialize the response body using Jackson
                String responseBody = responseEntity.getBody();
                return objectMapper.readValue(responseBody, responseType);
            } else {
                // Handle error responses here
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T get(String url, TypeReference<T> responseType) {
        return getData(url, null, new TypeReference<T>(){}, HttpMethod.GET, MediaType.APPLICATION_JSON);
    }

    @Override
    public <T> T post(String url, TypeReference<T> responseType) {
        return getData(url, null, new TypeReference<T>(){}, HttpMethod.POST, MediaType.APPLICATION_JSON);
    }

    @Override
    public <T> T post(String url, Object body, TypeReference<T> responseType) {
        return getData(url, body, new TypeReference<T>(){}, HttpMethod.POST, MediaType.APPLICATION_JSON);
    }

    @Override
    public <T> T post(String url, String body, TypeReference<T> responseType) {
        return getData(url, body, new TypeReference<T>(){}, HttpMethod.POST, MediaType.TEXT_PLAIN);
    }
}
