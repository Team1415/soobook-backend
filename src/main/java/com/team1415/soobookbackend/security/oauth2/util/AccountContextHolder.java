package com.team1415.soobookbackend.security.oauth2.util;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccountContextHolder {

    public static AccountContext getOrEmpty() {
        final var context = SecurityContextHolder.getContext();
        final var authentication = context.getAuthentication();
        if (authentication instanceof AccountContext) {
            return (AccountContext) authentication;
        } else {
            return null;
        }
    }

    public static Optional<AccountContext> get() {
        return Optional.ofNullable(getOrEmpty());
    }
}
