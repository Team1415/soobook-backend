package com.team1415.soobookbackend.security.domain;

import lombok.experimental.Delegate;
import org.springframework.security.oauth2.core.user.OAuth2User;

public record OAuth2Account(
    @Delegate
    OAuth2User oAuth2User,
    @Delegate
    AccountContext accountContext
) implements OAuth2User, AccountContext {

    public static OAuth2Account of(OAuth2User oAuth2User, AccountContext accountContext) {
        return new OAuth2Account(oAuth2User, accountContext);
    }

}
