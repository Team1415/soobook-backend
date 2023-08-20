package com.team1415.soobookbackend.security.jwt.application;

import com.team1415.soobookbackend.security.domain.AccountContext;
import com.team1415.soobookbackend.security.jwt.domain.JwtClaims;
import com.team1415.soobookbackend.security.jwt.domain.port.JwtTokenPort;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtClaimsService {

    private final String issuer;
    private final Duration expireDuration;
    private final JwtTokenPort jwtTokenPort;

    public String generateToken(AccountContext accountContext) {
        final JwtClaims jwtClaims = JwtClaims.of(accountContext, issuer, expireDuration, List.of());
        return jwtTokenPort.generateToken(jwtClaims);
    }

    public String refreashToken(String token) {
        final JwtClaims jwtClaims = jwtTokenPort.parse(token);
        final JwtClaims refreshed = jwtClaims.refresh(expireDuration);
        return jwtTokenPort.generateToken(refreshed);
    }

    public AccountContext parse(String token) {
        final JwtClaims jwtClaims = jwtTokenPort.parse(token);
        return jwtClaims.toContext();
    }
}
