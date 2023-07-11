package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "book_translator_mapping")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookTranslatorPersistenceEntity extends BasePersistenceEntity {

    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookPersistenceEntity bookPersistenceEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "translator_id")
    private TranslatorPersistenceEntity translatorPersistenceEntity;
}
