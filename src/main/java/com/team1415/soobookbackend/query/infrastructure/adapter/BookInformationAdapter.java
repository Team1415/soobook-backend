package com.team1415.soobookbackend.query.infrastructure.adapter;

import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.common.exception.NoSuchBookException;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookDetailPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.repository.BookDetailPersistenceRepository;
import com.team1415.soobookbackend.core.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.query.application.port.BookInformationQueryPort;
import com.team1415.soobookbackend.query.dto.*;
import com.team1415.soobookbackend.query.infrastructure.mapper.BookInformationMapper;
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
    private final BookPersistenceRepository bookPersistenceRepository;
    private final BookDetailPersistenceRepository bookDetailPersistenceRepository;
    private final BookInformationMapper bookInformationMapper;

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

        return bookPersistenceEntityList.stream().map(book -> bookInformationMapper.toBriefInformationDto(book,
                hashtagInformationResponseDtoMap.get(book.getId()))).toList();
    }

    @Override
    public BookDetailInformationResponseDto retrieveBookDetailInformation(Long bookId) {

        BookPersistenceEntity bookPersistenceEntity = bookPersistenceRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchBookException(""));

        List<BookClassificationResponseDto> bookClassificationResponseDtoList = bookClassificationQueryDslRepository
                .retrieveBookClassificationInformationListByBookId(bookId);

        List<BookDetailPersistenceEntity> bookDetailPersistenceEntityList = bookDetailPersistenceRepository
                .findByBookId(bookId);

        return bookInformationMapper.toDetailInformationDto(bookPersistenceEntity, bookClassificationResponseDtoList,
                bookDetailPersistenceEntityList);
    }
}
