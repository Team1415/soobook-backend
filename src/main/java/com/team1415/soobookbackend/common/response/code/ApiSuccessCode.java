package com.team1415.soobookbackend.common.response.code;

public class ApiSuccessCode implements ApiResponseCode {

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "Success";

    @Override
    public int getCode() {
        return SUCCESS_CODE;
    }

    @Override
    public String getMessage() {
        return SUCCESS_MESSAGE;
    }

}
