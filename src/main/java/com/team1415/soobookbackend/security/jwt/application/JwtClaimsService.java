package com.team1415.soobookbackend.security.jwt.application;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
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
        return generateToken(jwtClaims);
    }

    public String generateToken(JwtClaims claims) {
        return jwtTokenPort.generateToken(claims);
    }

    public JwtClaims refresh(JwtClaims claims) {
        return claims.refresh(expireDuration);
    }

    public JwtClaims parse(String token) {
        return jwtTokenPort.parse(token);
    }
}
