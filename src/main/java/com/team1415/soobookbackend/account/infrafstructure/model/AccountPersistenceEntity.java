package com.team1415.soobookbackend.account.infrafstructure.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.Account.Provider;
import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "account")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerType;
    private String email;
    private String displayName;
    private String firstName;
    private String lastName;

    public Account toDomain() {
        return new Account(id, new Provider(providerType), email, displayName, firstName, lastName);
    }

    public static AccountPersistenceEntity from(Account account) {
        return new AccountPersistenceEntity(account.id(), account.provider().type(),
            account.email(), account.displayName(),
            account.firstName(), account.lastName());
    }
}
