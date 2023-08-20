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
        final Claims claims = Jwts.claims()
            .setIssuer(jwtClaims.issuer())
            .setExpiration(dateFrom(jwtClaims.expiration()))
            .setIssuedAt(dateFrom(jwtClaims.issuedAt()));
        setCustomFieldsToClaims(jwtClaims, claims);
        return claims;
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

    private static void setAccountId(Claims claims, Long accountId) {
        claims.put(ACCOUNT_ID, accountId);
    }

    private static String getDisplayName(Claims claims) {
        return claims.get(DISPLAY_NAME, String.class);
    }

    private static void setDisplayName(Claims claims, String displayName) {
        claims.put(DISPLAY_NAME, displayName);
    }

    private static String getEmail(Claims claims) {
        return claims.get(EMAIL, String.class);
    }

    private static void setEmail(Claims claims, String email) {
        claims.put(EMAIL, email);
    }

    private static List<String> getRoles(Claims claims) {
        //noinspection unchecked
        return (List<String>) claims.get(ROLES, List.class);
    }

    private static void setRoles(Claims claims, List<String> roles) {
        claims.put(ROLES, roles);
    }

    private static String getProvider(Claims claims) {
        return claims.get(PROVIDER, String.class);
    }

    private static void setProvider(Claims claims, String provider) {
        claims.put(PROVIDER, provider);
    }


    private static void setCustomFieldsToClaims(JwtClaimsCustomFields customFields, Claims claims) {
        setAccountId(claims, customFields.accountId());
        setDisplayName(claims, customFields.displayName());
        setEmail(claims, customFields.email());
        setRoles(claims, customFields.roles());
        setProvider(claims, customFields.provider());
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
