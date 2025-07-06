package com.genesis.ecoverde.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String hello() {
        return "Hola desde Spring Boot esto es un demo";
    }
}

