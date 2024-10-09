package com.makainb.springboot3.security.s010.config;

import com.makainb.springboot3.security.s010.model.User;
import com.makainb.springboot3.security.s010.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userByUsername = userRepository.findByUsername(username);
        if (userByUsername.isEmpty()) {
            log.error("用户名不正确: {}", username);
            throw new UsernameNotFoundException("用户名不正确");
        }

        User user = userByUsername.get();
        Set<GrantedAuthority> grantedAuthorities = user.getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet());

        return new SessionUser(user.getUsername(), user.getPassword(), user.getEnabled(), true, user.getCredentialsNonExpired(), user.getAccountNonLocked(), grantedAuthorities);
    }

}
