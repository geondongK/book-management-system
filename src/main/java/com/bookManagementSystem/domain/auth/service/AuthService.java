package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.dto.request.SignInRequestDto;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.dto.response.SignInResponseDto;

public interface AuthService {
    /* 회원가입 */
    void signUp(SignUpRequestDto dto);

    /* 로그인 */
    SignInResponseDto singIn(SignInRequestDto dto);
}
