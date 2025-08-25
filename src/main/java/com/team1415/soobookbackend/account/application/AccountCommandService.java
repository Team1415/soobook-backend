package com.team1415.soobookbackend.account.application;

import com.team1415.soobookbackend.account.application.command.AccountCommand;
import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.port.AccountCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountCommandService {

    private final AccountCommandPort accountCommandPort;

    public Account create(AccountCommand accountCommand) {
        final var account = accountCommand.toDomain();
        return accountCommandPort.create(account);
    }
}
