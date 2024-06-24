package com.team1415.soobookbackend.account.infrafstructure.adapter;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.port.AccountQueryPort;
import com.team1415.soobookbackend.account.infrafstructure.model.AccountPersistenceEntity;
import com.team1415.soobookbackend.account.infrafstructure.repository.AccountPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class AccountQueryAdapter implements AccountQueryPort {

    private final AccountPersistenceRepository accountPersistenceRepository;

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountPersistenceRepository
            .findByEmail(email)
            .map(AccountPersistenceEntity::toDomain);
    }
}
