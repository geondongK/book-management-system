package com.bookManagementSystem.domain.auth.domain;

import com.bookManagementSystem.domain.auth.dto.request.SignUpRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    private Integer userId;
    private String email;
    private String name;
    private String password;
    private String address;
    private String address_detail;
    private String phone_number;

    public Users(SignUpRequestDto dto) {
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.address = dto.getAddress();
        this.address_detail = dto.getAddress_detail();
        this.phone_number = dto.getPhone_number();
    }
}
