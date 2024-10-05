package com.makainb.springboot3.security.s004;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class S004Application {

    public static void main(String[] args) {
        SpringApplication.run(S004Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
        return args -> {
            var admin = User.builder()
                    .username("laoma")
                    .password("{noop}laoma123")
                    .roles("USER", "ADMIN")
                    .build();

            var user = User.builder()
                    .username("makai")
                    .password("{noop}makai123")
                    .roles("USER")
                    .build();

            jdbcUserDetailsManager.createUser(user);
            jdbcUserDetailsManager.createUser(admin);
        };
    }

}
