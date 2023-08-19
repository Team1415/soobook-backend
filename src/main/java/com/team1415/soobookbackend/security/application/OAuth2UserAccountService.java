package com.team1415.soobookbackend.security.application;


import com.team1415.soobookbackend.account.application.AccountCommandService;
import com.team1415.soobookbackend.account.application.AccountQueryService;
import com.team1415.soobookbackend.account.application.command.AccountCommand;
import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.security.domain.AccountContext;
import com.team1415.soobookbackend.security.domain.OAuth2Account;
import com.team1415.soobookbackend.security.domain.OAuth2Provider;
import com.team1415.soobookbackend.security.domain.OAuth2UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RequiredArgsConstructor
public class OAuth2UserAccountService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final AccountQueryService accountQueryService;
    private final AccountCommandService accountCommandService;
    private final DefaultOAuth2UserService defaultOAuth2UserService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        final var oAuth2User = defaultOAuth2UserService.loadUser(userRequest);
        final var oAuth2Provider = OAuth2Provider.from(
            userRequest.getClientRegistration().getRegistrationId());
        final var oAuth2UserAccount = OAuth2UserAccount.of(oAuth2Provider, oAuth2User);

        final var account = getOrCreateAccount(oAuth2UserAccount);
        return OAuth2Account.of(oAuth2User, AccountContext.from(account));
    }

    private Account getOrCreateAccount(OAuth2UserAccount oAuth2UserAccount) {
        return accountQueryService.load(oAuth2UserAccount.email())
            .orElseGet(() -> createAccount(oAuth2UserAccount));
    }

    private Account createAccount(OAuth2UserAccount oAuth2UserAccount) {
        final var accountCommand = AccountCommand.from(oAuth2UserAccount);
        return accountCommandService.create(accountCommand);
    }
}
