package com.bookManagementSystem.domain.auth.dto.request;

import com.bookManagementSystem.domain.auth.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    // NotBlank : null 빈 문자열 모두 허용하지 않는다.
    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(message = "이메일 형식이 맞지 않습니다", regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$")
    private String email;

    @NotBlank(message = "이름을 입력해주세요")
    @Pattern(message = "이름은 특수문자를 제외한 2~8자리여야 합니다", regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,8}$")
    private String name;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(message = "비밀번호는 최소 8자리 최대 20자리까지 입력 가능합니다", min = 8, max = 20)
    private String password;

    @NotBlank(message = "주소를 입력해주세요")
    private String address;

    @NotBlank(message = "상세주소를 입력해주세요")
    private String address_detail;

    @NotBlank(message = "연락처를 입력해주세요")
    @Pattern(message = "전화번호 형식이 맞지 않습니다", regexp = "^[0-9]{11,13}$")
    private String phone_number;

    private String role;

    public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return User.builder()
                .email(email)
                .name(name)
                .password(bCryptPasswordEncoder.encode(password))
                .address(address)
                .address_detail(address_detail)
                .phone_number(phone_number)
                .role("ROLE_USER")
                .build();
    }
}
