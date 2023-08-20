package com.team1415.soobookbackend.security.oauth2.config;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import com.team1415.soobookbackend.account.application.AccountCommandService;
import com.team1415.soobookbackend.account.application.AccountQueryService;
import com.team1415.soobookbackend.security.jwt.application.JwtClaimsService;
import com.team1415.soobookbackend.security.oauth2.application.OAuth2UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final JwtClaimsService jwtClaimsService;

    @Bean
    @Order(1)
    SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
            .securityMatcher(antMatcher("/api/**"))
            .csrf(CsrfConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(FormLoginConfigurer::disable)
            .logout(LogoutConfigurer::disable)
            .build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain loginSecurityFilterChain(HttpSecurity http,
        AuthenticationSuccessHandler authenticationSuccessHandler)
        throws Exception {
        return http
            .securityMatcher(AntPathRequestMatcher.antMatcher("/**"))
            .csrf(CsrfConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(configurer -> configurer.loginPage("/login"))
            .oauth2Login(customizer -> customizer.successHandler(authenticationSuccessHandler))
            .exceptionHandling(
                customizer -> customizer.authenticationEntryPoint(new HttpStatusEntryPoint(
                    HttpStatus.UNAUTHORIZED)))
            .logout(Customizer.withDefaults())
            .build();
    }

    @Bean
    OAuth2UserAccountService oAuth2UserAccountService() {
        return new OAuth2UserAccountService(
            accountQueryService,
            accountCommandService,
            new DefaultOAuth2UserService()
        );
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new JwtAuthenticationSuccessHandler(jwtClaimsService);
    }
}
