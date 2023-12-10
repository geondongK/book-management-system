package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.domain.Users;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;

import java.util.List;

public interface AuthService {
    /* 회원가입 */
    void signUp(SignUpRequestDto dto);

    void singIn();
}
