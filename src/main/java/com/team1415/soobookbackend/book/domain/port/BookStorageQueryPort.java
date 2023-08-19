package com.team1415.soobookbackend.book.domain.port;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.common.annotation.Port;

import java.util.List;
import java.util.Optional;

@Port
public interface BookStorageQueryPort {

    List<Book> retrieveNewestBookList();
    List<BookInformation> retrieveBookInformationListByIsbn10(List<String> isbn10List);
    List<BookInformation> retrieveBookInformationListByIsbn13(List<String> isbn13List);
    Optional<BookInformation> retrieveBookInformationByTitleAndIsbn(String title, String isbn10, String isbn13);
    Optional<BookDetail> retrieveBookDetailByTitleAndIsbnAndUrl(String title, String isbn10, String isbn13, String url);

    boolean isExistBook(String title, String isbn10, String isbn13);
}
