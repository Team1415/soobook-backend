package com.team1415.soobookbackend.account.domain;

public record Account(
    Long id,
    Provider provider,
    String email,
    String displayName,
    String firstName,
    String lastName
) {

    public record Provider(
        String type
    ) {

    }
}
