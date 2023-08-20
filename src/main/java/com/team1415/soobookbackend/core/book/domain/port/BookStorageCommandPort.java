package com.team1415.soobookbackend.core.book.domain.port;

import com.team1415.soobookbackend.core.book.domain.BookDetail;
import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.common.annotation.Port;

@Port
public interface BookStorageCommandPort {

    BookInformation insert(BookInformation bookInformation);
    BookInformation update(BookInformation bookInformation);

    BookDetail insertDetail(BookDetail bookDetail);
    BookDetail updateDetail(BookDetail bookDetail);
}
