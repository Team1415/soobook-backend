package com.team1415.soobookbackend.book.domain.port;

import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.common.annotation.Port;

@Port
public interface BookApiQueryPort {

    BookInformation retrieveBookInformation(String query);
}
