package com.herbert.wanderbyway.entryPoint.rest.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthRestController {

    private String testString;

    HealthRestController(@Value("${test}")String testString){
        this.testString = testString;
    }

    @GetMapping("/ping")
    String ping(){
        return "ok";
    }

    @GetMapping("/version")
    VersionInfo getVersionInfo(){
        return new VersionInfo("0.0.1", "NOW");
    }

    @GetMapping("/test")
    String returnTestString(){
        return this.testString;
    }
}
