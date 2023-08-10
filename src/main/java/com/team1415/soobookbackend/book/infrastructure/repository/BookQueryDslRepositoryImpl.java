package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookQueryDslRepositoryImpl implements BookQueryDslRepository {

    @Override
    public Optional<BookInformation> retrieveByTitleAndIsbn(String title, String isbn10, String isbn13) {
        return Optional.empty();
    }

    @Override
    public Optional<BookDetail> retrieveBookDetailByTitleAndIsbn(String title, String isbn10, String isbn13) {
        return Optional.empty();
    }
}
