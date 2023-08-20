package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team1415.soobookbackend.core.book.infrastructure.model.AuthorPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPublishPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.TranslatorPersistenceEntity;
import lombok.Data;

import java.util.List;

@Data
public class BookBriefInformationResponseDto {

    private Long id;
    private String title;
    private List<String> authorList;
    private List<String> translatorList;
    private String publisher;
    private String thumbnail;
    @JsonProperty("hashtags")
    private List<HashtagInformationResponseDto> hashtagInformationList;

    public static BookBriefInformationResponseDto generateByEntityAndHashtag(
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
}
