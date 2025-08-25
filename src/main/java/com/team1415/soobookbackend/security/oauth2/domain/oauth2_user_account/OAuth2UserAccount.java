package com.team1415.soobookbackend.security.oauth2.domain.oauth2_user_account;

import org.springframework.security.oauth2.core.user.OAuth2User;

public sealed interface OAuth2UserAccount extends BaseOAuth2Account permits GoogleUserAccount {

    OAuth2User oAuth2User();

    static OAuth2UserAccount of(OAuth2Provider provider, OAuth2User oAuth2User) {
        switch (provider) {
            case GOOGLE -> {
                return new GoogleUserAccount(oAuth2User);
            }
        }
        throw new IllegalArgumentException("Invalid OAuth2Provider [provider=" + provider + "]");
    }
}
