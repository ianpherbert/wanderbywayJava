package com.herbert.wanderbyway.entryPoint.rest.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class HealthRestController {
    @GetMapping("/ping")
    String ping(){
        return "ok";
    }
}
