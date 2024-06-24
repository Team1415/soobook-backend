package com.team1415.soobookbackend.core.book.infrastructure.repository;

import com.team1415.soobookbackend.core.book.infrastructure.model.TranslatorPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatorPersistenceRepository
        extends JpaRepository<TranslatorPersistenceEntity, Long> {}
