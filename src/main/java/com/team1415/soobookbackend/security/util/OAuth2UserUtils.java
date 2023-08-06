package com.team1415.soobookbackend.security.util;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserUtils {

    public static String stringAttributeOrNull(OAuth2User oAuth2User, String key) {
        return (String) oAuth2User.getAttributes().get(key);
    }
}
