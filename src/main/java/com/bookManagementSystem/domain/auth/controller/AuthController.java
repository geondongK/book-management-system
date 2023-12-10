package com.bookManagementSystem.domain.auth.controller;

import com.bookManagementSystem.domain.auth.domain.Users;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    /* 회원가입 */
    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpRequestDto dto) {
        // log.info("signUp = {}", dto.getEmail());
        authService.signUp(dto);
    }

    /* 로그인 */
    @PostMapping("/login")
    public void signIn() {
        authService.singIn();
    }
    
}
