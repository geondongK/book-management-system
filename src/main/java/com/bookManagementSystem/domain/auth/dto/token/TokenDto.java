package com.bookManagementSystem.domain.auth.dto.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType; // 토큰타입
    private String accessToken; // 엑세스토큰
    private Long accessTokenExpiresIn; // 토큰 만료시간
}
