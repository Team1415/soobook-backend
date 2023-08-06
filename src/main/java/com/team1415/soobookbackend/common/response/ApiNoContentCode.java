package com.team1415.soobookbackend.common.response;

public class ApiNoContentCode implements ApiErrorCode{

    public static final int NO_CONTENT_CODE = 204;
    public static final String NO_CONTENT_MESSAGE = "조회 결과가 존재하지 않습니다.";

    @Override
    public int getCode() {
        return NO_CONTENT_CODE;
    }

    @Override
    public String getMessage() {
        return NO_CONTENT_MESSAGE;
    }
}
