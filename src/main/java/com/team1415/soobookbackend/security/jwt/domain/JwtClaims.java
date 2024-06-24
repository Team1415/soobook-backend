package com.team1415.soobookbackend.security.jwt.domain;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContextImpl;
import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContextImpl.ProviderContextImpl;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

    public List<GrantedAuthority> authorities() {
        if (roles.isEmpty()) {
            return List.of();
        }
        return roles
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
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
