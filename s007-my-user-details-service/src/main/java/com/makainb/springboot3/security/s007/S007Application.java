package com.makainb.springboot3.security.s007;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class S007Application {

    public static void main(String[] args) {
        SpringApplication.run(S007Application.class, args);
    }

    
}
