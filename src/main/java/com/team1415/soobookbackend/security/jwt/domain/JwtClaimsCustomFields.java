package com.team1415.soobookbackend.security.jwt.domain;

import java.util.List;

public interface JwtClaimsCustomFields {

    Long accountId();

    String displayName();

    String email();

    List<String> roles();

    String provider();

    record CustomClaimsImpl(
        Long accountId,
        String displayName,
        String email,
        List<String> roles,
        String provider
    ) implements JwtClaimsCustomFields {

    }

}
