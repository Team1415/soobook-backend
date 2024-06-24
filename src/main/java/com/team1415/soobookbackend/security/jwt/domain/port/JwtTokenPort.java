package com.team1415.soobookbackend.security.jwt.domain.port;

import com.team1415.soobookbackend.security.jwt.domain.JwtClaims;

public interface JwtTokenPort {

    String generateToken(JwtClaims jwtClaims);

    JwtClaims parse(String token);
}
