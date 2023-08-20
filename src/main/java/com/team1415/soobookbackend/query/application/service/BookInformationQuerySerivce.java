package com.team1415.soobookbackend.query.application.service;

import com.team1415.soobookbackend.query.application.port.BookInformationQueryPort;
import com.team1415.soobookbackend.query.dto.BookBriefInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookInformationQuerySerivce {

    private final BookInformationQueryPort bookInformationQueryPort;

    public List<BookBriefInformationResponseDto> retrieveBookBriefInformationList(
            RetrieveBookRequestDto retrieveBookRequestDto) {

        return bookInformationQueryPort.retrieveBookBriefInformationList(retrieveBookRequestDto);
    }
}
