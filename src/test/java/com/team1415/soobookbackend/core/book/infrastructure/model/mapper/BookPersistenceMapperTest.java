package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.BookDetail;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookDetailPersistenceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookPersistenceMapperTest {

    private BookPersistenceMapper bookPersistenceMapper;

    @BeforeEach
    public void setup() {
        bookPersistenceMapper = Mappers.getMapper(BookPersistenceMapper.class);
    }

    @Test
    public void testFromEntityToDomainDetailWhenBookDetailPersistenceEntityProvidedThenReturnsCorrectBookDetail() {
        // Arrange
        BookDetailPersistenceEntity entity = BookDetailPersistenceEntity.builder()
                .bookId(1L)
                .source("source")
                .url("url")
                .bookIndex("index")
                .bookDescription("description")
                .build();

        // Act
        BookDetail bookDetail = bookPersistenceMapper.fromEntityToDomainDetail(entity);

        // Assert
        assertThat(bookDetail).isNotNull();
        assertThat(bookDetail.getBookId()).isEqualTo(entity.getBookId());
        assertThat(bookDetail.getSource()).isEqualTo(entity.getSource());
        assertThat(bookDetail.getUrl()).isEqualTo(entity.getUrl());
        assertThat(bookDetail.getBookIndex()).isEqualTo(entity.getBookIndex());
        assertThat(bookDetail.getBookDescription()).isEqualTo(entity.getBookDescription());
    }

    @Test
    public void testFromEntityToDomainDetailWhenNullInputThenReturnsNull() {
        // Act
        BookDetail bookDetail = bookPersistenceMapper.fromEntityToDomainDetail(null);

        // Assert
        assertThat(bookDetail).isNull();
    }
}