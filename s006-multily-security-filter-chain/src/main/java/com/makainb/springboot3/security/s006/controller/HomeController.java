package com.makainb.springboot3.security.s006.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Welcome index!";
    }

    @GetMapping("/user")
    public String user(Authentication authentication){
        return "Welcome user " + authentication.getName() + "!";
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication){
        return "Welcome admin " + authentication.getName() + " " + authentication.getAuthorities() + "!";
    }
}
