package com.team1415.soobookbackend.book.domain.port;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.common.annotation.Port;

import java.util.List;

@Port
public interface BookStorageQueryPort {

    List<Book> retrieveNewestBookList();
}
