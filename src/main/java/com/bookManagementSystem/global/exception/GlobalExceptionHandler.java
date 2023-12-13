package com.bookManagementSystem.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.crypto.MarshalException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    /* valid 검증 에러
      @ExceptionHandler에 이미 MethodArgumentNotValidException이 구현되어있기
      때문에 GlobalExceptionHandler에서 동일한 예외 처리를 하게 되면, Ambiguous(모호성) 문제가 발생
      spring boot 3.0 이상 HttpStatus status -> HttpStatusCode status
    */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
        });
        ObjectError objectError = ex.getBindingResult().getAllErrors().stream().findFirst().get();
        String errorMsg = "[errors] field : " + ((FieldError) objectError).getField() + ", errorMessage: " + objectError.getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMsg);

//        Map<String, List<String>> body = new HashMap<>();
//
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}


