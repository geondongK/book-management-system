package com.bookManagementSystem.domain.auth.mapper;

import com.bookManagementSystem.domain.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignInMapper {
    // 이메일 중복 체크
    User findByEmail(String email);

    // Spring boot security CustomUserDetailsService 인증 처리
    User findById(int id);
}
