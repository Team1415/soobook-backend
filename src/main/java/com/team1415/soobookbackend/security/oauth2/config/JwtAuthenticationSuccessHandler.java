package com.team1415.soobookbackend.security.oauth2.config;

import com.team1415.soobookbackend.common.utils.ObjectMapperUtils;
import com.team1415.soobookbackend.security.jwt.application.JwtClaimsService;
import com.team1415.soobookbackend.security.oauth2.dto.LoginResponseDto;
import com.team1415.soobookbackend.security.oauth2.util.AccountContextHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtClaimsService jwtClaimsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        final var accountContext = AccountContextHolder.get()
            .orElseThrow(() -> new IllegalStateException("accountContext 정보가 잘못됨"));

        final var token = jwtClaimsService.generateToken(accountContext);
        final var responseDto = LoginResponseDto.of(token, accountContext);

        setHeader(response);
        setResponse(response, responseDto);
    }

    private void setHeader(HttpServletResponse response) {
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
    }

    private void setResponse(HttpServletResponse response, LoginResponseDto responseDto)
        throws IOException {
        final var json = ObjectMapperUtils.toJson(responseDto);
        final var writer = response.getWriter();
        writer.print(json);
    }
}
