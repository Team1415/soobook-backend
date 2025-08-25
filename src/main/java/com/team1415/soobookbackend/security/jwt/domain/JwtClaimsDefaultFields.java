package com.team1415.soobookbackend.security.jwt.domain;

import java.time.ZonedDateTime;

public interface JwtClaimsDefaultFields {

    String issuer();

    ZonedDateTime expiration();

    ZonedDateTime issuedAt();
}
