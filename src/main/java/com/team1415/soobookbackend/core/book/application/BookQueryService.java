package com.team1415.soobookbackend.core.book.application;

import com.team1415.soobookbackend.core.book.domain.port.BookStorageQueryPort;
import com.team1415.soobookbackend.core.book.dto.mapper.BookDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookQueryService {

    private final BookStorageQueryPort bookStorageQueryPort;
    private final BookDtoMapper bookDtoMapper;
}
