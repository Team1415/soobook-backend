package com.team1415.soobookbackend.common.response.code;

public class ApiNoContentsCode implements ApiResponseCode {

    public static final int NO_CONTENTS_CODE = 204;
    public static final String NO_CONTENTS_MESSAGE = "No Contents";

    @Override
    public int getCode() {
        return NO_CONTENTS_CODE;
    }

    @Override
    public String getMessage() {
        return NO_CONTENTS_MESSAGE;
    }
}
