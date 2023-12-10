package com.bookManagementSystem.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice // 전역 예외 처리
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {GlobalException.class})
    // 특정 에러
    protected ResponseEntity<Object> handleGlobalException(GlobalException e) {
        // GlobalExceptionResponseCode errorCode;
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(new GlobalExceptionResponse(e.getErrorCode()));
    }
}
