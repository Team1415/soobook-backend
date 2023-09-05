package com.team1415.soobookbackend.core.book.infrastructure.repository;

import com.team1415.soobookbackend.core.book.infrastructure.model.BookDetailPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDetailPersistenceRepository extends JpaRepository<BookDetailPersistenceEntity, Long> {

    Optional<BookDetailPersistenceEntity> findOneByBookIdAndSource(Long bookId, String source);
    List<BookDetailPersistenceEntity> findByBookId(Long bookId);
}
