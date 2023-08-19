package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.infrastructure.model.BookDetailPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDetailPersistenceRepository extends JpaRepository<BookDetailPersistenceEntity, Long> {

    Optional<BookDetailPersistenceEntity> findOneByBookIdAndSource(Long bookId, String source);
    Optional<BookDetailPersistenceEntity> findOneByTitleAndIsbn10(String title, String isbn10);
    Optional<BookDetailPersistenceEntity> findOneByTitleAndIsbn13(String title, String isbn13);
}
