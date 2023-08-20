package com.team1415.soobookbackend.security.oauth2.dto;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountContextResponseDto {

    private final Long id;
    private final String displayName;
    private final String email;

    public static AccountContextResponseDto from(AccountContext accountContext) {
        return new AccountContextResponseDto(accountContext.id(), accountContext.displayName(),
            accountContext.email());
    }
}
