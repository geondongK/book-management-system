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
public class SignInRequestDto {
    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(message = "이메일 형식이 올바르지 않습니다", regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
}
