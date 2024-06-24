package com.team1415.soobookbackend.security.oauth2.domain.jwt_account;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import lombok.experimental.Delegate;
import org.springframework.security.core.AuthenticatedPrincipal;

public record JwtAccount(
    @Delegate
    AccountContext accountContext
) implements AccountContext, AuthenticatedPrincipal {

    @Override
    public String getName() {
        return this.displayName();
    }

    public static JwtAccount from(AccountContext accountContext) {
        return new JwtAccount(accountContext);
    }
}
