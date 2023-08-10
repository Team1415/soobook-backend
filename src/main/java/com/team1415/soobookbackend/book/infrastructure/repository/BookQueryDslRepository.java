package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;

import java.util.Optional;

public interface BookQueryDslRepository {

    Optional<BookInformation> retrieveByTitleAndIsbn(String title, String isbn10, String isbn13);

    Optional<BookDetail> retrieveBookDetailByTitleAndIsbn(String title, String isbn10, String isbn13);
}
