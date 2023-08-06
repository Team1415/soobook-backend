package com.team1415.soobookbackend.security.domain;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum OAuth2Provider {
    GOOGLE("google", ProviderType.GOOGLE);

    private final String registrationId;
    private final ProviderType providerType;

    public static OAuth2Provider from(String registrationId) {
        return Arrays.stream(values())
            .filter(provider -> provider.registrationId.equals(registrationId))
            .findFirst().orElseThrow(
                () -> new IllegalArgumentException(
                    "Not found OAuth2Provider[" + registrationId + "]"));
    }
}
