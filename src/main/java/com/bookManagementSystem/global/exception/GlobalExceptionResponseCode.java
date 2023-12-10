package com.bookManagementSystem.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GlobalExceptionResponseCode {
    /* 유저 */
    EMAIL_EXISTS_FOUND(HttpStatus.CONFLICT, "중복된 이메일입니다"),
    NAME_EXISTS_FOUND(HttpStatus.CONFLICT, "중복된 이름입니다"),
    PHONE_NUMBER_EXISTS_FOUND(HttpStatus.CONFLICT, "가입된 전화번호입니다");

    private final HttpStatus httpStatus;
    private final String detailMessage;

}
