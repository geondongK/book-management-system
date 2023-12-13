package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.domain.User;
import com.bookManagementSystem.domain.auth.dto.CustomUserDetails;
import com.bookManagementSystem.domain.auth.mapper.SignInMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final SignInMapper signInMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = signInMapper.findById(Integer.parseInt(username));

        if (user != null) {

            return new CustomUserDetails(user);
        }

        return null;
    }
}
