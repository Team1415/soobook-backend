package com.team1415.soobookbackend.security.domain;

public interface BaseOAuth2Account {
    String id();
    ProviderType providerType();
    String email();
    String displayName();
    String firstName();
    String lastName();
}
