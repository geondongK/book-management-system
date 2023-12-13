package com.bookManagementSystem.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Integer id; // 기본키
    private String email; // 이메일
    private String name; // 이름
    private String password; // 비밀번호
    private String address; // 주소
    private String address_detail; // 상세주소
    private String phone_number; // 전화번호
    private String role; // 역할
    private final LocalDateTime create_date = LocalDateTime.now(); // 생성일
    private LocalDateTime update_date; // 수정일

    @Builder
    public User(String email, String name, String password, String address, String address_detail, String phone_number, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.address_detail = address_detail;
        this.phone_number = phone_number;
        this.role = role;
    }
}
