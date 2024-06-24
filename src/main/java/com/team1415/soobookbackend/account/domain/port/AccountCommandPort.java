package com.team1415.soobookbackend.account.domain.port;

import com.team1415.soobookbackend.account.domain.Account;

public interface AccountCommandPort {
    Account create(Account account);
}
