package com.team1415.soobookbackend.core.book.application;

import com.team1415.soobookbackend.core.book.domain.port.BookStorageQueryPort;
import com.team1415.soobookbackend.core.book.dto.BookInformationResponseDto;
import com.team1415.soobookbackend.core.book.dto.BookResponseDto;
import com.team1415.soobookbackend.core.book.dto.RetrieveBookRequestDto;
import com.team1415.soobookbackend.core.book.dto.mapper.BookDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookQueryService {

    private final BookStorageQueryPort bookStorageQueryPort;
    private final BookDtoMapper bookDtoMapper;

    public List<BookInformationResponseDto> retrieveBookList(RetrieveBookRequestDto retrieveBookRequestDto) {

        return bookDtoMapper.fromDomainsToResponses(
                bookStorageQueryPort.retrieveBookList(retrieveBookRequestDto));
    }
}
