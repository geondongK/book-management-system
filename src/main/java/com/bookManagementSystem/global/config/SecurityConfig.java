package com.bookManagementSystem.global.config;

import com.bookManagementSystem.global.jwt.exception.JwtAccessDeniedHandler;
import com.bookManagementSystem.global.jwt.exception.JwtAuthEntryPoint;
import com.bookManagementSystem.global.jwt.filter.JwtFilter;
import com.bookManagementSystem.global.jwt.provider.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    // BCryptPasswordEncoder 암호화 메소드
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // Spring boot 3.0 이상부터 Security 설정 람다식 사용
                // token 사용 방식이기 때문에 csrf disable 적용.
                .csrf((csrf) -> csrf.disable())
                // 시큐리티는 기본적으로 세션을 사용
                // 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 접근 권한 설정
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/api/v1/book").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/api/v1/book").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/api/v1/book").hasRole("ADMIN")
                        .requestMatchers("/api/v1/book/**", "/api/v1/book/return-book/**", "/api/v1/book/check-out/**").hasRole("USER")
                        // 처리 못한 경로는 로그인한 사용자만 접근가능
                        .anyRequest().authenticated()
                )
                .exceptionHandling((exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint).accessDeniedHandler(jwtAccessDeniedHandler)))
                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
