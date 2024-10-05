package com.makainb.springboot3.security.s001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Welcome to Spring Boot 3 Security!";
    }
}
