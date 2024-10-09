package com.makainb.springboot3.security.s010.controller;

import com.makainb.springboot3.security.s010.config.SessionUser;
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
    public String admin(Authentication authentication) {
        SessionUser myUser = (SessionUser) authentication.getPrincipal();
        return "<h1>Welcome Admin!</h1>" +
                "<h2>" + authentication.getName() + "</h2>" +
                "<p>SessionUser:<br>User name: " + myUser.getUsername() +
                "<br>Authorities: " + myUser.getAuthorities();
    }
}
