package com.bookManagementSystem.global.jwt.filter;

import com.bookManagementSystem.global.jwt.provider.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            // Request Header 에서 토큰 정보 꺼냄
            String token = resolveToken(request);

            // 트콘이 null 이 아니거나 잘못된 토큰이 아니거나 기간이 만료가 되지 않았을 경우
            // 정상 토큰이면 해당 토큰으로 Authentication 을 가져와서 SecurityContext 에 저장
            if (token != null && jwtTokenProvider.validationToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            // 다음 필터 넘기기
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Exception::Err_Msg = {}", e.getStackTrace()[0]);
            throw new RuntimeException(e);
        }
    }

    // Request Header 에서 토큰 정보 꺼내오기
    private String resolveToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        // StringUtils.hasText() 문자열이 진정한 Text형태인지 확인합니다. 즉, null을 포함해서 공백만 존재한다면 False를 반환합니다
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        }
        return null;
    }


}
