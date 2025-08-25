package com.team1415.soobookbackend.account.application;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.port.AccountQueryPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountQueryService {

    private final AccountQueryPort accountQueryPort;

    public Optional<Account> load(String email) {
        return accountQueryPort.findByEmail(email);
    }
}
