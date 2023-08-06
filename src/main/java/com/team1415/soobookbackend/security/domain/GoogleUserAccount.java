package com.team1415.soobookbackend.security.domain;

import static com.team1415.soobookbackend.security.util.OAuth2UserUtils.stringAttributeOrNull;

import org.springframework.security.oauth2.core.user.OAuth2User;

public record GoogleUserAccount(
    OAuth2User oAuth2User
) implements OAuth2UserAccount {

    private static final String ID_ATTRIBUTE = "sub";
    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String FIRST_NAME_ATTRIBUTE = "given_name";
    private static final String LAST_NAME_ATTRIBUTE = "family_name";
    private static final String DISPLAY_NAME_ATTRIBUTE = "name";

    @Override
    public String id() {
        return stringAttributeOrNull(oAuth2User, ID_ATTRIBUTE);
    }

    @Override
    public ProviderType providerType() {
        return ProviderType.GOOGLE;
    }

    @Override
    public String email() {
        return stringAttributeOrNull(oAuth2User, EMAIL_ATTRIBUTE);
    }

    @Override
    public String displayName() {
        return stringAttributeOrNull(oAuth2User, DISPLAY_NAME_ATTRIBUTE);
    }

    @Override
    public String firstName() {
        return stringAttributeOrNull(oAuth2User, FIRST_NAME_ATTRIBUTE);
    }

    @Override
    public String lastName() {
        return stringAttributeOrNull(oAuth2User, LAST_NAME_ATTRIBUTE);
    }
}
