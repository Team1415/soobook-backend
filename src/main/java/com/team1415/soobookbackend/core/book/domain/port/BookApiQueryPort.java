package com.team1415.soobookbackend.core.book.domain.port;

import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.common.annotation.Port;
import java.util.List;

@Port
public interface BookApiQueryPort {

    List<BookInformation> retrieveBookInformationList(String query);
}
