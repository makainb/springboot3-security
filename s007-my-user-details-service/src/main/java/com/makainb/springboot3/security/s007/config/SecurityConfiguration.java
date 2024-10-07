package com.makainb.springboot3.security.s007.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.GET, "/").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/user").hasAnyAuthority("ROLE_USER");
                    authConfig.requestMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN");
                    authConfig.anyRequest().authenticated();

                })
                .csrf(AbstractHttpConfigurer::disable) //
                .headers(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    MyUserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    ApplicationListener<AuthenticationSuccessEvent> authenticationSuccessEvent() {
        return event -> System.err.println("登录成功!" + event.getAuthentication().getClass().getName() + " - " + event.getAuthentication().getName());
    }


    @Bean
    ApplicationListener<AuthenticationFailureBadCredentialsEvent> authenticationFailureBadCredentialsEvent() {
        return event -> System.err.println("登录失败!" + event.getException().getClass() + " - " + event.getAuthentication().getName() + " - " + event.getException().getMessage());
    }
}
