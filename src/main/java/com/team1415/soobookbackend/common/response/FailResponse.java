package com.team1415.soobookbackend.common.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed class FailResponse implements ApiResponse {

    private final String apiVersion;
    private final ApiErrorCode errorCode;
    private final String message;

    @Override
    public String getDomain() {
        return "";
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    public static FailResponse of(ApiErrorCode errorCode, String message) {
        return FailResponse.builder()
                .apiVersion(DEFAULT_API_VERSION)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
