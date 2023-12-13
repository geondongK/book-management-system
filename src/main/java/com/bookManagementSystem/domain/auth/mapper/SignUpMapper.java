package com.bookManagementSystem.domain.auth.mapper;

import com.bookManagementSystem.domain.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpMapper {
    // 회원가입
    void signUp(User dto);

    // 이메일 중복 체크
    boolean existsByEmail(String email);

    // 이름 중복 체크
    // boolean existsByName(String name);

    // 전화번호 중복 체크
    boolean existsByPhoneNumber(String phoneNumber);
}
