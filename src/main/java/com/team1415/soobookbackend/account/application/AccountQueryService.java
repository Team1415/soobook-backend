package com.team1415.soobookbackend.account.application;

import com.team1415.soobookbackend.account.domain.Account;
import com.team1415.soobookbackend.account.domain.port.AccountQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountQueryService {
    private final AccountQueryPort accountQueryPort;

    public Account load(String email) {
        // TODO: 2023/08/06 예외 고도화 필요
        return accountQueryPort.findByEmail(email).orElseThrow(() -> new IllegalStateException(
            "찾을 수 없음"));
    }
}
