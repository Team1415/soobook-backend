package com.team1415.soobookbackend.security.oauth2.domain.account_context;

import com.team1415.soobookbackend.account.domain.Account;

public interface AccountContext {

    Long id();

    ProviderContext provider();

    String email();

    String displayName();

    static AccountContext from(Account account) {
        return new AccountContextImpl(account);
    }

    interface ProviderContext {

        String type();
    }
}
