package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.domain.Users;
import com.bookManagementSystem.domain.auth.dto.request.SignInRequestDto;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.mapper.SignInMapper;
import com.bookManagementSystem.domain.auth.mapper.SignUpMapper;
import com.bookManagementSystem.global.exception.GlobalException;
import com.bookManagementSystem.global.exception.GlobalExceptionResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final SignUpMapper signUpMapper;
    private final SignInMapper signInMapper;

    /* 회원가입  */
    @Override
    public void signUp(SignUpRequestDto dto) {

        /* 이메일 중복 체크 */
        if (signUpMapper.existsByEmail(dto.getEmail())) {
            throw new GlobalException(GlobalExceptionResponseCode.EMAIL_EXISTS_FOUND);
        }
        /* 전화번호 중복 체크 */
        if (signUpMapper.existsByPhoneNumber(dto.getPhone_number())) {
            throw new GlobalException(GlobalExceptionResponseCode.PHONE_NUMBER_EXISTS_FOUND);
        }

        Users users = new Users(dto);
        signUpMapper.signUp(users);
    }

    /* 로그인 */
    @Override
    public void singIn(SignInRequestDto dto) {
        signInMapper.singIn(dto);
    }
}
