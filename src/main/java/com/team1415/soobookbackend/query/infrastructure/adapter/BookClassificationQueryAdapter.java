package com.team1415.soobookbackend.query.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.query.application.port.BookClassificationQueryPort;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookClassificationRequestDto;
import com.team1415.soobookbackend.query.infrastructure.repository.BookClassificationQueryDslRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class BookClassificationQueryAdapter implements BookClassificationQueryPort {

    private final BookClassificationQueryDslRepository bookClassificationQueryDslRepository;

    @Override
    public List<HashtagInformationResponseDto> retrieveHashtagInformationList(
            RetrieveBookClassificationRequestDto bookClassificationRequestDto) {
        return bookClassificationQueryDslRepository.retrieveHashtagInformationList(bookClassificationRequestDto);
    }
}
