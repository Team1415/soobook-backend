package com.team1415.soobookbackend.security.oauth2.config;

import com.team1415.soobookbackend.account.application.AccountCommandService;
import com.team1415.soobookbackend.account.application.AccountQueryService;
import com.team1415.soobookbackend.security.jwt.application.JwtClaimsService;
import com.team1415.soobookbackend.security.oauth2.application.OAuth2UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfiguration {

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final JwtClaimsService jwtClaimsService;

    @Bean
    @Order(2)
    SecurityFilterChain apiSecurityFilterChain(HttpSecurity http,
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) throws Exception {
        return http.securityMatchers((matchers) -> matchers
                .requestMatchers("/**")
            )
            .authorizeHttpRequests(authorize ->
                authorize.anyRequest()
                    .permitAll()
            )
//            .addFilterBefore(jwtAuthenticationTokenFilter, OAuth2LoginAuthenticationFilter.class)
            .csrf(CsrfConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(FormLoginConfigurer::disable)
            .logout(LogoutConfigurer::disable)
            .build();
    }

    @Bean
    // 나중에 순서 변경 필요
    @Order(1)
    SecurityFilterChain loginSecurityFilterChain(HttpSecurity http,
        AuthenticationSuccessHandler authenticationSuccessHandler) throws Exception {
        return http.securityMatchers((matchers) -> matchers
                .requestMatchers("/login")
                .requestMatchers("/login/**")
                .requestMatchers("/oauth2/**")
            )
            .csrf(CsrfConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(FormLoginConfigurer::disable)
            .oauth2Login(customizer -> customizer
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler))
            .exceptionHandling(customizer -> customizer.authenticationEntryPoint(
                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
            .logout(Customizer.withDefaults())
            .build();
    }

    @Bean
    OAuth2UserAccountService oAuth2UserAccountService() {
        return new OAuth2UserAccountService(accountQueryService, accountCommandService,
            new DefaultOAuth2UserService());

    }

    @Bean
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter(jwtClaimsService);
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new JwtAuthenticationSuccessHandler(jwtClaimsService);
    }
}