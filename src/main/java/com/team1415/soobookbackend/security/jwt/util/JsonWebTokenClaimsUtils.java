package com.team1415.soobookbackend.security.jwt.util;

import com.team1415.soobookbackend.security.jwt.domain.JwtClaims;
import com.team1415.soobookbackend.security.jwt.domain.JwtClaimsCustomFields;
import com.team1415.soobookbackend.security.jwt.domain.JwtClaimsCustomFields.CustomClaimsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class JsonWebTokenClaimsUtils {

    public static final String ACCOUNT_ID = "accountId";
    public static final String DISPLAY_NAME = "displayName";
    public static final String EMAIL = "email";
    public static final String ROLES = "roles";
    public static final String PROVIDER = "provider";

    public static Claims claimsFrom(JwtClaims jwtClaims) {
        return Jwts.claims()
            .issuer(jwtClaims.issuer())
            .expiration(dateFrom(jwtClaims.expiration()))
            .issuedAt(dateFrom(jwtClaims.issuedAt()))
            .add(ACCOUNT_ID, jwtClaims.accountId())
            .add(DISPLAY_NAME, jwtClaims.displayName())
            .add(EMAIL, jwtClaims.email())
            .add(ROLES, jwtClaims.roles())
            .add(PROVIDER, jwtClaims.provider())
            .build();
    }

    public static JwtClaims jwtClaimsFrom(Claims claims) {
        final String issuer = claims.getIssuer();
        final ZonedDateTime expiration = zonedDateTimeFrom(claims.getExpiration());
        final ZonedDateTime issuedAt = zonedDateTimeFrom(claims.getIssuedAt());
        final JwtClaimsCustomFields customFields = jwtClaimsCustomFieldsFrom(claims);
        return new JwtClaims(issuer, expiration, issuedAt, customFields.accountId(),
            customFields.displayName(), customFields.email(), customFields.roles(),
            customFields.provider());
    }

    private static Long getAccountId(Claims claims) {
        return claims.get(ACCOUNT_ID, Long.class);
    }

    private static String getDisplayName(Claims claims) {
        return claims.get(DISPLAY_NAME, String.class);
    }

    private static String getEmail(Claims claims) {
        return claims.get(EMAIL, String.class);
    }

    private static List<String> getRoles(Claims claims) {
        //noinspection unchecked
        return (List<String>) claims.get(ROLES, List.class);
    }

    private static String getProvider(Claims claims) {
        return claims.get(PROVIDER, String.class);
    }

    private static ZonedDateTime zonedDateTimeFrom(Date date) {
        return date.toInstant().atZone(ZoneOffset.UTC);
    }

    private static Date dateFrom(ZonedDateTime dateTime) {
        return Date.from(dateTime.toInstant());
    }

    private static JwtClaimsCustomFields.CustomClaimsImpl jwtClaimsCustomFieldsFrom(Claims claims) {
        return new CustomClaimsImpl(
            getAccountId(claims),
            getDisplayName(claims),
            getEmail(claims),
            getRoles(claims),
            getProvider(claims)
        );
    }
}
