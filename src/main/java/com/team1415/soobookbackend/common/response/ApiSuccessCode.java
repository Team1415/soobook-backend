package com.team1415.soobookbackend.common.response;

public class ApiSuccessCode implements ApiErrorCode {

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "성공적으로 처리하였습니다.";

    @Override
    public int getCode() {
        return SUCCESS_CODE;
    }

    @Override
    public String getMessage() {
        return SUCCESS_MESSAGE;
    }

}
