package com.team1415.soobookbackend.query.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.query.application.port.BookInformationQueryPort;
import com.team1415.soobookbackend.query.dto.BookBriefInformationResponseDto;
import com.team1415.soobookbackend.query.dto.BookClassificationResponseDto;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookRequestDto;
import com.team1415.soobookbackend.query.infrastructure.repository.BookClassificationQueryDslRepository;
import com.team1415.soobookbackend.query.infrastructure.repository.BookInformationQueryDslRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class BookInformationAdapter implements BookInformationQueryPort {

    private final BookInformationQueryDslRepository bookInformationQueryDslRepository;
    private final BookClassificationQueryDslRepository bookClassificationQueryDslRepository;

    @Override
    public List<BookBriefInformationResponseDto> retrieveBookBriefInformationList(RetrieveBookRequestDto retrieveBookRequestDto) {

        List<BookPersistenceEntity> bookPersistenceEntityList = bookInformationQueryDslRepository
                .retrieveBookPersistenceEntityList(retrieveBookRequestDto);

        Map<Long, List<HashtagInformationResponseDto>> hashtagInformationResponseDtoMap = bookClassificationQueryDslRepository
                .retrieveBookClassificationInformationListByBookIdList(
                        bookPersistenceEntityList.stream().map(BookPersistenceEntity::getId).toList()).stream()
                .collect(Collectors.groupingBy(BookClassificationResponseDto::getBookId,
                        Collectors.mapping(BookClassificationResponseDto::getHashtagInformationResponseDto,
                                Collectors.toList())));

        return bookPersistenceEntityList.stream().map(book -> BookBriefInformationResponseDto.generateByEntityAndHashtag(book,
                hashtagInformationResponseDtoMap.get(book.getId()))).toList();
    }
}
