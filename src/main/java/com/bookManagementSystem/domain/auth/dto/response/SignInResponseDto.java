package com.bookManagementSystem.domain.auth.dto.response;

import com.bookManagementSystem.domain.auth.domain.User;
import lombok.Getter;

@Getter
public class SignInResponseDto {
    private final User user;
    private final String token;


    public SignInResponseDto(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
