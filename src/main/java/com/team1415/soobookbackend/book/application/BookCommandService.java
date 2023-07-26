package com.team1415.soobookbackend.book.application;

import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookApiQueryPort;
import com.team1415.soobookbackend.book.domain.port.BookStorageCommandPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCommandService {

    private final BookApiQueryPort bookApiQueryPort;
    private final BookStorageCommandPort bookStorageCommandPort;

    public void saveBookInformationList(List<String> queryList) {
        for (String query : queryList) {
            List<BookInformation> bookInformationList =
                    bookApiQueryPort.retrieveBookInformationList(query);

            for (BookInformation bookInformation : bookInformationList) {
                bookStorageCommandPort.insert(bookInformation);
            }
        }
    }
}
