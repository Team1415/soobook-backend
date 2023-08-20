package com.team1415.soobookbackend.security.jwt.domain;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContextImpl;
import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContextImpl.ProviderContextImpl;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public record JwtClaims(
    String issuer,
    ZonedDateTime expiration,
    ZonedDateTime issuedAt,
    Long accountId,
    String displayName,
    String email,
    List<String> roles,
    String provider

) implements JwtClaimsDefaultFields, JwtClaimsCustomFields {

    public JwtClaims refresh(Duration expireTime) {
        final ZonedDateTime issuedAt = ZonedDateTime.now();
        final ZonedDateTime expiration = issuedAt.plus(expireTime);
        return new JwtClaims(issuer, expiration, issuedAt, accountId, displayName, email,
            roles, provider);
    }

    public AccountContext toContext() {
        return new AccountContextImpl(accountId, new ProviderContextImpl(provider), email,
            displayName);
    }

    public static JwtClaims of(AccountContext accountContext, String issuer,
        Duration expireTime, List<String> roles) {
        final ZonedDateTime issuedAt = ZonedDateTime.now();
        final ZonedDateTime expiration = issuedAt.plus(expireTime);
        return new JwtClaims(issuer, expiration, issuedAt, accountContext.id(),
            accountContext.displayName(), accountContext.email(), roles,
            accountContext.provider().type());
    }
}
