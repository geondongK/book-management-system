package com.bookManagementSystem.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    // NotBlank : null 빈 문자열 모두 허용하지 않는다.
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String address_detail;
    @NotBlank
    @Pattern(regexp = "^[0-9]{11,13}$")
    private String phone_number;
}
