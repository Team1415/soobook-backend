package com.team1415.soobookbackend.security.oauth2.config;

import com.team1415.soobookbackend.security.jwt.application.JwtClaimsService;
import com.team1415.soobookbackend.security.oauth2.domain.JwtAuthenticationToken;
import com.team1415.soobookbackend.security.oauth2.domain.jwt_account.JwtAccount;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Pattern TOKEN_PATTERN = Pattern.compile("^Bearer (.+)$",
        Pattern.CASE_INSENSITIVE);
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String REFRESH_HEADER = "Refresh-Token";

    private final JwtClaimsService jwtClaimsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            return;
        }
        final var authorizationToken = getAuthorizationToken(request);
        try {
            final var claims = jwtClaimsService.parse(authorizationToken);
            final var refreshClaims = jwtClaimsService.refresh(claims);
            response.setHeader(REFRESH_HEADER, jwtClaimsService.generateToken(refreshClaims));
            final var jwtAuthenticationToken = new JwtAuthenticationToken(
                refreshClaims.authorities(), JwtAccount.from(refreshClaims.toContext()));
            SecurityContextHolder.getContext().setAuthentication(jwtAuthenticationToken);
        } catch (Exception e) {
            throw new BadCredentialsException("토큰 검증 오류");
        }

        filterChain.doFilter(request, response);
    }

    private String getAuthorizationToken(HttpServletRequest request) {
        final var token = request.getHeader(AUTHORIZATION_HEADER);
        if (token == null) {
            throw new BadCredentialsException(AUTHORIZATION_HEADER + " 가 존재하지 않음");
        }
        final var decodedHeader = URLDecoder.decode(token, StandardCharsets.UTF_8);
        final var matcher = TOKEN_PATTERN.matcher(decodedHeader);
        if (!matcher.matches()) {
            throw new BadCredentialsException("pattern 이 다름 ");
        }
        return matcher.group(1);
    }
}
