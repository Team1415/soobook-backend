package com.team1415.soobookbackend.account.application.command;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.security.oauth2.domain.oauth2_user_account.OAuth2UserAccount;
import com.team1415.soobookbackend.security.oauth2.domain.oauth2_user_account.ProviderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountCommand {

    private ProviderCommand provider;

    private String email;
    private String displayName;
    private String firstName;
    private String lastName;

    public Account toDomain() {
        return new Account(
            null,
            provider.toDomain(),
            email,
            displayName,
            firstName,
            lastName
        );
    }

    public static AccountCommand from(OAuth2UserAccount oAuth2UserAccount) {
        return new AccountCommand(
            ProviderCommand.from(oAuth2UserAccount.providerType()),
            oAuth2UserAccount.email(),
            oAuth2UserAccount.displayName(),
            oAuth2UserAccount.firstName(),
            oAuth2UserAccount.lastName()
        );
    }

    public record ProviderCommand(
        String type
    ) {

        public static ProviderCommand from(ProviderType providerType) {
            return new ProviderCommand(providerType.name());
        }

        public Account.Provider toDomain() {
            return new Account.Provider(type);
        }
    }
}