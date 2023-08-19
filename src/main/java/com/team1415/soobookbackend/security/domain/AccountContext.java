package com.team1415.soobookbackend.security.domain;

import com.team1415.soobookbackend.account.domain.Account;

public interface AccountContext {
    Long id();
    ProviderContext provider();
    String email();
    String displayName();
    String firstName();
    String lastName();

    public static AccountContext from(Account account) {
        return new AccountContextImpl(account);
    }

    interface ProviderContext {
        String type();
    }
}
