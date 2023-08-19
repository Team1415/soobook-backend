package com.team1415.soobookbackend.core.book.infrastructure.repository;

import com.team1415.soobookbackend.core.book.infrastructure.model.AuthorPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorPersistenceRepository extends JpaRepository<AuthorPersistenceEntity, Long> {}
