package com.team1415.soobookbackend.security.oauth2.domain.oauth2_user_account;

public interface BaseOAuth2Account {
    String id();
    ProviderType providerType();
    String email();
    String displayName();
    String firstName();
    String lastName();
}
