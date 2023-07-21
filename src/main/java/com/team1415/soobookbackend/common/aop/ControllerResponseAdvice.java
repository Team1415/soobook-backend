package com.team1415.soobookbackend.common.aop;

import com.team1415.soobookbackend.common.response.ApiNoContentCode;
import com.team1415.soobookbackend.common.response.FailResponse;
import com.team1415.soobookbackend.common.response.SuccessResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.team1415")
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        if (ObjectUtils.isEmpty(body)) {
            return FailResponse.of(new ApiNoContentCode(), "");
        } else {
            return SuccessResponse.of(body);
        }
    }
}
