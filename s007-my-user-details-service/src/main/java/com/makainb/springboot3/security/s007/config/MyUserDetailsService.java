package com.makainb.springboot3.security.s007.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MyUserDetailsService implements UserDetailsService {

    public static Map<String, String> users = new HashMap<>();
    static {
        users.put("makai", "makai123");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        if(!users.containsKey(username)) {
            throw new UsernameNotFoundException(username);
        }

        String password = users.get(username);

        return User.builder()
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .disabled(false)
                .build();
    }

}
