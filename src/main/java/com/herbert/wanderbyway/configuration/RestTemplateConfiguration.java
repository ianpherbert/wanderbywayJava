package com.herbert.wanderbyway.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        // Find and configure MappingJackson2HttpMessageConverter
        restTemplate.getMessageConverters().stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findFirst()
                .ifPresent(converter -> {
                    List<MediaType> supportedMediaTypes = new ArrayList<>(((MappingJackson2HttpMessageConverter) converter).getSupportedMediaTypes());
                    // Add text/html as an acceptable media type for JSON conversion
                    supportedMediaTypes.add(MediaType.TEXT_HTML);
                    ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(supportedMediaTypes);
                });

        // Ensure UTF-8 is used by the StringHttpMessageConverter
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper() {

        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }
}
