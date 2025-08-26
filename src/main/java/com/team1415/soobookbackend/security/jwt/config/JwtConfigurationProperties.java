package com.team1415.soobookbackend.security.jwt.config;

import java.time.Duration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@ConfigurationProperties(prefix = "jwt.token")
@RequiredArgsConstructor
public class JwtConfigurationProperties {

    private final String issuer;
    private final Duration expireDuration;
    private final String clientSecret;

}
