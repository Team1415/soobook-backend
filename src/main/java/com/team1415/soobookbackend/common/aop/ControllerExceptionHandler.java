package com.team1415.soobookbackend.common.aop;

import com.team1415.soobookbackend.common.exception.NoContentsException;
import com.team1415.soobookbackend.common.exception.NoSuchBookException;
import com.team1415.soobookbackend.common.response.code.ApiNoContentsCode;
import com.team1415.soobookbackend.common.response.code.ApiNoResultCode;
import com.team1415.soobookbackend.common.response.FailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchBookException.class)
    public ResponseEntity<FailResponse> handleNoSuchBookException(FailResponse failResponse) {

        return ResponseEntity.ok(FailResponse.of(new ApiNoResultCode(), "검색 조건과 일치하는 도서가 존재하지 않습니다."));
    }

    @ExceptionHandler(NoContentsException.class)
    public ResponseEntity<FailResponse> handleNoContentsException(FailResponse failResponse) {

        return ResponseEntity.ok(FailResponse.of(new ApiNoContentsCode(), "요청하신 목록이 존재하지 않습니다."));
    }



}
