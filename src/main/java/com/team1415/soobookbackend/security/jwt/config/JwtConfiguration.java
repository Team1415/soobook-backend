package com.team1415.soobookbackend.security.jwt.config;

import com.team1415.soobookbackend.security.jwt.application.JwtClaimsService;
import com.team1415.soobookbackend.security.jwt.domain.port.JwtTokenPort;
import com.team1415.soobookbackend.security.jwt.infrastructure.adapter.JsonWebTokenJwtTokenAdapter;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(JwtConfigurationProperties.class)
public class JwtConfiguration {

    private final JwtConfigurationProperties properties;

    @Bean
    JwtClaimsService jwtClaimsService() {
        return new JwtClaimsService(properties.getIssuer(), properties.getExpireDuration(),
            jwtTokenPort());
    }

    @Bean
    JwtTokenPort jwtTokenPort() {
        return new JsonWebTokenJwtTokenAdapter(properties.getClientSecret(),
            SignatureAlgorithm.HS512);
    }

}
