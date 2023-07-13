package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.infrastructure.entity.AuthorPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.entity.BookPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorPersistenceRepository extends JpaRepository<AuthorPersistenceEntity, Long> {
}
