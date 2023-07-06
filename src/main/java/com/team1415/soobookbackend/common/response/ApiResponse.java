package com.team1415.soobookbackend.common.response;

public sealed interface ApiResponse permits SuccessResponse, FailResponse {
    String DEFAULT_API_VERSION = "1.0.0";

    String getApiVersion();

    String getDomain();

    boolean isSuccess();
}
