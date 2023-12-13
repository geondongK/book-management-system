package com.bookManagementSystem.domain.auth.service;

import com.bookManagementSystem.domain.auth.domain.User;
import com.bookManagementSystem.domain.auth.dto.request.SignInRequestDto;
import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import com.bookManagementSystem.domain.auth.dto.response.SignInResponseDto;
import com.bookManagementSystem.domain.auth.dto.token.TokenDto;
import com.bookManagementSystem.domain.auth.mapper.SignInMapper;
import com.bookManagementSystem.domain.auth.mapper.SignUpMapper;
import com.bookManagementSystem.global.exception.GlobalException;
import com.bookManagementSystem.global.exception.GlobalExceptionResponseCode;

import com.bookManagementSystem.global.jwt.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final SignUpMapper signUpMapper;
    private final SignInMapper signInMapper;

    // 비밀번호 암호화
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    // 토큰 발급
    private final JwtTokenProvider jwtTokenProvider;

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

        // 회원가입
        signUpMapper.signUp(dto.toEntity(bCryptPasswordEncoder));
    }

    /* 로그인 */
    @Override
    public SignInResponseDto singIn(SignInRequestDto dto) {
        // 사용자 존재 유무 체크
        User user = signInMapper.findByEmail(dto.getEmail());
        if (user == null) throw new GlobalException(GlobalExceptionResponseCode.USER_NOT_FOUND);

        // 비밀번호 체크
        if (!bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword()))
            throw new GlobalException(GlobalExceptionResponseCode.USER_NOT_FOUND);

        // 토큰 생성
        TokenDto accessToken = jwtTokenProvider.generateAccessToken(user.getId(), user.getName(), "ROLE_USER");

        // 로그인 완료
        SignInResponseDto response = new SignInResponseDto(user, accessToken.getAccessToken());
        
        return response;
    }
}
