package com.team1415.soobookbackend.security.oauth2.dto;

import com.team1415.soobookbackend.security.oauth2.domain.account_context.AccountContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginResponseDto {

    private final String apiToken;
    private final AccountContextResponseDto account;

    public static LoginResponseDto of(String token, AccountContext accountContext) {
        return new LoginResponseDto(token, AccountContextResponseDto.from(accountContext));
    }
}
