package com.team1415.soobookbackend.common.response;

import com.team1415.soobookbackend.common.response.code.ApiResponseCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed class FailResponse implements ApiResponse {

    private final String apiVersion;
    private final ApiResponseCode errorCode;
    private final String message;

    @Override
    public String getDomain() {
        return "";
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    public static FailResponse of(ApiResponseCode errorCode, String message) {
        return FailResponse.builder()
                .apiVersion(DEFAULT_API_VERSION)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
