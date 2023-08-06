package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookPersistenceRepository extends JpaRepository<BookPersistenceEntity, Long>, BookQueryDslRepository {

    List<BookPersistenceEntity> findByIsbn10In(List<String> isbn10List);
    List<BookPersistenceEntity> findByIsbn13In(List<String> isbn13List);
    Optional<BookPersistenceEntity> findOneByTitleAndIsbn10(String title, String isbn10);
    Optional<BookPersistenceEntity> findOneByTitleAndIsbn13(String title, String isbn13);
}
