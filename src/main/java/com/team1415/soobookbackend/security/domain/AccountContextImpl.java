package com.team1415.soobookbackend.security.domain;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.Account.Provider;

public record AccountContextImpl(
    Long id,
    ProviderContextImpl provider,
    String email,
    String displayName

) implements AccountContext {

    public AccountContextImpl(Account account) {
        this(account.id(), new ProviderContextImpl(account.provider()), account.email(),
            account.displayName());
    }

    public record ProviderContextImpl(
        String type
    ) implements ProviderContext {

        public ProviderContextImpl(Provider provider) {
            this(provider.type());
        }
    }
}
