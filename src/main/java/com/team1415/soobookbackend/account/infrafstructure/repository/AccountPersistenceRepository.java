package com.team1415.soobookbackend.account.infrafstructure.repository;

import com.team1415.soobookbackend.account.infrafstructure.model.AccountPersistenceEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountPersistenceRepository extends
    JpaRepository<AccountPersistenceEntity, Long> {

    Optional<AccountPersistenceEntity> findByEmail(String email);
}
