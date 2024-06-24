package com.team1415.soobookbackend.query.application.service;

import com.team1415.soobookbackend.query.application.port.BookClassificationQueryPort;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookClassificationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassificationQueryService {

    private final BookClassificationQueryPort bookClassificationQueryPort;

    public List<HashtagInformationResponseDto> retrieveHashtagInformationList(
            RetrieveBookClassificationRequestDto bookClassificationRequestDto) {
        return bookClassificationQueryPort.retrieveHashtagInformationList(bookClassificationRequestDto);
    }
}
