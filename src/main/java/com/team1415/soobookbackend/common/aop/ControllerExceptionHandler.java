package com.team1415.soobookbackend.common.aop;

import com.team1415.soobookbackend.common.exception.NoContentsException;
import com.team1415.soobookbackend.common.exception.NoSuchBookException;
import com.team1415.soobookbackend.common.response.FailResponse;
import com.team1415.soobookbackend.common.response.code.ApiNoContentsCode;
import com.team1415.soobookbackend.common.response.code.ApiNoResultCode;
import com.team1415.soobookbackend.common.response.code.CommonErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchBookException.class)
    public ResponseEntity<FailResponse> handleNoSuchBookException(NoSuchBookException e) {
        log.warn("Handling NoSuchBookException: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(FailResponse.of(new ApiNoResultCode(), "검색 조건과 일치하는 도서가 존재하지 않습니다."));
    }

    @ExceptionHandler(NoContentsException.class)
    public ResponseEntity<FailResponse> handleNoContentsException(NoContentsException e) {
        log.warn("Handling NoContentsException: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(FailResponse.of(new ApiNoContentsCode(), "요청하신 목록이 존재하지 않습니다."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FailResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("Handling MethodArgumentNotValidException: {}", e.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(FailResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<FailResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.warn("Handling HttpRequestMethodNotSupportedException: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(FailResponse.of(CommonErrorCode.METHOD_NOT_ALLOWED, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailResponse> handleAllExceptions(Exception e) {
        log.error("Handling unexpected exception", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(FailResponse.of(CommonErrorCode.INTERNAL_SERVER_ERROR, e.getMessage()));
    }
}
