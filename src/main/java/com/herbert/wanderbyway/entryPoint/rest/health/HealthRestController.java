package com.herbert.wanderbyway.entryPoint.rest.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthRestController {

    private final String environment;

    HealthRestController(@Value("${environment}")String environment){
        this.environment = environment;
    }

    @GetMapping("/ping")
    String ping(){
        return "ok";
    }

    @GetMapping("/version")
    VersionInfo getVersionInfo(){
        return new VersionInfo("0.0.1", "NOW", environment);
    }
}
