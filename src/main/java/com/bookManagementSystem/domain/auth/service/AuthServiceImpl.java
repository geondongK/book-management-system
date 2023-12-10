package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.domain.Users;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.mapper.SignInMapper;
import com.bookManagementSystem.domain.auth.mapper.SignUpMapper;
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
        Users users = new Users(dto);
        signUpMapper.signUp(users);
    }

    /* 로그인 */
    @Override
    public void singIn() {
        signInMapper.singIn();
    }
}
