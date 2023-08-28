package com.team1415.soobookbackend.account.infrafstructure.adapter;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.port.AccountCommandPort;
import com.team1415.soobookbackend.account.infrafstructure.repository.AccountPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class AccountCommandAdapter implements AccountCommandPort {

    private final AccountPersistenceRepository accountPersistenceRepository;

    @Override
    public Account create(Account account) {
        return null;
    }
}
