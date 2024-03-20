package com.herbert.wanderbyway.entryPoint.rest.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthRestController {

    private final String environment;
    private final String version;

    HealthRestController(
            @Value("${environment}")String environment,
            @Value("${version}")String version
    ){
        this.environment = environment;
        this.version = version;
    }

    @GetMapping("/ping")
    String ping(){
        return "ok";
    }

    @GetMapping("/version")
    VersionInfo getVersionInfo(){
        return new VersionInfo(version, environment);
    }
}
