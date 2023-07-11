package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "book")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookPersistenceEntity extends BasePersistenceEntity {

    @Id
    private Long id;
    private String isbn10;
    private String isbn13;
    private String title;
    private String publisher;
    private Long price;
    private Long salePrice;
    private String status;
    private LocalDateTime publishDatetime;
    private String thumbnail;
    @OneToMany(mappedBy = "bookPersistenceEntity")
    private List<BookAuthorPersistenceEntity> bookAuthorPersistenceEntityList;
    @OneToMany(mappedBy = "bookPersistenceEntity")
    private List<BookTranslatorPersistenceEntity> bookTranslatorPersistenceEntityList;
}
