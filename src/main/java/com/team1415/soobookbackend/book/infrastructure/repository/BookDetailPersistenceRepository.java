package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.infrastructure.model.BookDetailPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailPersistenceRepository extends JpaRepository<BookDetailPersistenceEntity, Long> {
}
