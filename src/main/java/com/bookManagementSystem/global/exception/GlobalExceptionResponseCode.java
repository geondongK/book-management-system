package com.bookManagementSystem.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GlobalExceptionResponseCode {
    /* 전역 */
    VALIDATION_FAILED(HttpStatus.UNPROCESSABLE_ENTITY, "유효성 검증에 실패하였습니다"),
    
    /* 유저 */
    EMAIL_EXISTS_FOUND(HttpStatus.CONFLICT, "중복된 이메일입니다"),
    NAME_EXISTS_FOUND(HttpStatus.CONFLICT, "중복된 이름입니다"),
    PHONE_NUMBER_EXISTS_FOUND(HttpStatus.CONFLICT, "가입된 전화번호입니다"),
    USER_NOT_FOUND(HttpStatus.CONFLICT, "이메일 또는 비밀번호가 틀렸습니다"),

    /* 도서 */
    BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, "책 정보가 없습니다");

    private final HttpStatus httpStatus;
    private final String detailMessage;

}
