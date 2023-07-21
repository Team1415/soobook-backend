package com.team1415.soobookbackend.book.application;

import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookApiQueryPort;
import com.team1415.soobookbackend.book.domain.port.BookStorageCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCommandService {

    private final BookApiQueryPort bookApiQueryPort;
    private final BookStorageCommandPort bookStorageCommandPort;

    public void saveBookInformation(List<String> queryList) {
        for (String query : queryList) {
            BookInformation bookInformation = bookApiQueryPort.retrieveBookInformation(query);
            bookStorageCommandPort.insert(bookInformation);
        }
    }
}
