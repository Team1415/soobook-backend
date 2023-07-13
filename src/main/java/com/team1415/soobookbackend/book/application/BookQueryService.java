package com.team1415.soobookbackend.book.application;

import com.team1415.soobookbackend.book.domain.port.BookQueryPort;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import com.team1415.soobookbackend.book.dto.mapper.BookDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookQueryService {

    private final BookQueryPort bookQueryPort;
    private final BookDtoMapper bookDtoMapper;

    public List<BookResponseDto> retrieveNewestBookList() {

        return bookDtoMapper.fromDomainRootsToResponses(bookQueryPort.retrieveNewestBookList());
    }
}