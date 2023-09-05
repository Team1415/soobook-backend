package com.team1415.soobookbackend.query.infrastructure.mapper;

import com.team1415.soobookbackend.core.book.infrastructure.model.*;
import com.team1415.soobookbackend.query.dto.BookBriefInformationResponseDto;
import com.team1415.soobookbackend.query.dto.BookClassificationResponseDto;
import com.team1415.soobookbackend.query.dto.BookDetailInformationResponseDto;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookInformationMapper {

    default BookBriefInformationResponseDto toBriefInformationDto(
            BookPersistenceEntity bookPersistenceEntity, List<HashtagInformationResponseDto> hashtagList) {

        BookPublishPersistenceEntity bookPublishPersistenceEntity = bookPersistenceEntity.getBookPublishPersistenceEntity();

        BookBriefInformationResponseDto dto = new BookBriefInformationResponseDto();
        dto.setId(bookPersistenceEntity.getId());
        dto.setTitle(bookPersistenceEntity.getTitle());
        dto.setPublisher(bookPublishPersistenceEntity.getPublisher());
        dto.setThumbnail(bookPublishPersistenceEntity.getThumbnail());
        dto.setAuthorList(bookPersistenceEntity.getAuthorPersistenceEntitySet()
                .stream().map(AuthorPersistenceEntity::getName).toList());
        dto.setTranslatorList(bookPersistenceEntity.getTranslatorPersistenceEntitySet()
                .stream().map(TranslatorPersistenceEntity::getName).toList());
        dto.setHashtagInformationList(hashtagList);

        return dto;
    }

    default BookDetailInformationResponseDto toDetailInformationDto(BookPersistenceEntity bookPersistenceEntity
            , List<BookClassificationResponseDto> bookClassificationResponseDtoList
            , List<BookDetailPersistenceEntity> bookDetailPersistenceEntityList) {

        BookPublishPersistenceEntity bookPublishPersistenceEntity = bookPersistenceEntity.getBookPublishPersistenceEntity();
        BookDetailPersistenceEntity bookDetailPersistenceEntity = bookDetailPersistenceEntityList.stream().findFirst()
                .orElseGet(() -> BookDetailPersistenceEntity.builder().build());

        BookDetailInformationResponseDto dto = new BookDetailInformationResponseDto();
        dto.setId(bookPersistenceEntity.getId());
        dto.setIsbn10(bookPersistenceEntity.getIsbn10());
        dto.setIsbn13(bookPersistenceEntity.getIsbn13());
        dto.setTitle(bookPersistenceEntity.getTitle());
        dto.setAuthorList(bookPersistenceEntity.getAuthorPersistenceEntitySet()
                .stream().map(AuthorPersistenceEntity::getName).toList());
        dto.setTranslatorList(bookPersistenceEntity.getTranslatorPersistenceEntitySet()
                .stream().map(TranslatorPersistenceEntity::getName).toList());
        dto.setHashtagInformationList(bookClassificationResponseDtoList.stream()
                .map(BookClassificationResponseDto::getHashtagInformationResponseDto).toList());
        dto.setPublisher(bookPublishPersistenceEntity.getPublisher());
        dto.setThumbnail(bookPublishPersistenceEntity.getThumbnail());
        dto.setPrice(bookPublishPersistenceEntity.getPrice());
        dto.setSalePrice(bookPublishPersistenceEntity.getSalePrice());
        dto.setStatus(bookPublishPersistenceEntity.getStatus());
        dto.setPublishDate(bookPublishPersistenceEntity.getPublishDatetime());
        dto.setIndex(bookDetailPersistenceEntity.getBookIndex());

        return dto;
    }
}
