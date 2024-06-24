package com.team1415.soobookbackend.common.response.code;


public class ApiServerErrorCode implements ApiResponseCode {

    public static final int SERVER_ERROR_CODE = 500;
    public static final String SERVER_ERROR_MESSAGE = "Internal Server Error";

    @Override
    public int getCode() {
        return SERVER_ERROR_CODE;
    }

    @Override
    public String getMessage() {
        return SERVER_ERROR_MESSAGE;
    }

}
