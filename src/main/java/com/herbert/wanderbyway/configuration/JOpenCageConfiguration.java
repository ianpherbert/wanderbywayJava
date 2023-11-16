package com.herbert.wanderbyway.configuration;

import com.byteowls.jopencage.JOpenCageGeocoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JOpenCageConfiguration {
    private final String openCageApiKey;

    JOpenCageConfiguration(@Value("${open-cage.api-key}")String openCageApiKey) {
        this.openCageApiKey = openCageApiKey;
    }

    @Bean
    public JOpenCageGeocoder openCageGeocoder() {
        return new JOpenCageGeocoder(openCageApiKey);
    }
}
