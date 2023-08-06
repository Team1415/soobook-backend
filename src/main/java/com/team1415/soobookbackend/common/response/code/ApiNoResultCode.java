package com.team1415.soobookbackend.common.response.code;

public class ApiNoResultCode implements ApiResponseCode {

    public static final int NO_RESULT_CODE = 203;
    public static final String NO_RESULT_MESSAGE = "No Single Result";

    @Override
    public int getCode() {
        return NO_RESULT_CODE;
    }

    @Override
    public String getMessage() {
        return NO_RESULT_MESSAGE;
    }
}
