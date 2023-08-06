package com.team1415.soobookbackend.account.domain.port;

import com.team1415.soobookbackend.account.domain.Account;
import java.util.Optional;

public interface AccountQueryPort {
    Optional<Account> findByEmail(String email);
}
