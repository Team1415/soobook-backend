package com.team1415.soobookbackend.common.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public non-sealed class SuccessResponse<T> implements ApiResponse {

    private static final SuccessResponse<?> EMPTY_SUCCESS_RESPONSE = of(null);

    private final String apiVersion;

    private final T result;

    @Override
    public String getDomain() {
        return "";
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    public static <T> SuccessResponse<T> of(final T result) {
        return of(DEFAULT_API_VERSION, result);
    }

    public static <T> SuccessResponse<T> of(final String apiVersion, final T result) {
        return SuccessResponse.<T>builder().apiVersion(apiVersion).result(result).build();
    }

    public static SuccessResponse<?> success() {
        return EMPTY_SUCCESS_RESPONSE;
    }
}
