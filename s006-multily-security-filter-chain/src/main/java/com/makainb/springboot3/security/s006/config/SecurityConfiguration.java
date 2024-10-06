package com.makainb.springboot3.security.s006.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @Order(100)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/user")
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers("/user/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER");
                    authConfig.anyRequest().authenticated();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(101)
    SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/admin")
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
                    authConfig.anyRequest().authenticated();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(102)
    SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/")
                .authorizeHttpRequests(authConfig -> {
                    authConfig.anyRequest().permitAll();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(103)
    SecurityFilterChain securityFilterChain3(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authConfig -> {
                    authConfig.anyRequest().denyAll();
                })
                .formLogin(withDefaults());
        return http.build();
    }


    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("")
                .build();
    }

//    方式2
//    @Bean
//    DataSource dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }

}
