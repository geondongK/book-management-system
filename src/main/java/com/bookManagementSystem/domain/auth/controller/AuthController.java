package com.bookManagementSystem.domain.auth.controller;

import com.bookManagementSystem.domain.auth.dto.request.SignInRequestDto;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.dto.response.SignInResponseDto;
import com.bookManagementSystem.domain.auth.service.AuthService;
import com.bookManagementSystem.global.common.response.CommonResponse;
import com.bookManagementSystem.global.common.response.ResponseService;
import com.bookManagementSystem.global.common.response.SingleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final ResponseService responseService; // 응답 Response

    /* Test */
    @GetMapping("/test")
    public String docker() {
        return "hello docker";
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public CommonResponse signUp(@RequestBody @Valid SignUpRequestDto dto) {
        authService.signUp(dto);
        return responseService.getSuccessResponse();
    }

    /* 로그인 */
    @PostMapping("/login")
    public SingleResponse<SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto dto) {
        SignInResponseDto response = authService.singIn(dto);
        return responseService.getSingResponse(response);
    }

}
