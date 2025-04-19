package com.ss.restaurant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/")
public class HealthCheckController {

    @RequestMapping
    public String healthCheck() {
        return "OK";
    }
}
