package com.team1415.soobookbackend.book.infrastructure.entity;

import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    @Embedded
    private BookPublishPersistenceEntity bookPublishPersistenceEntity;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_author_mapping",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private Set<AuthorPersistenceEntity> authorPersistenceEntitySet;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_translator_mapping",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "translator_id") })
    private Set<TranslatorPersistenceEntity> translatorPersistenceEntitySet;

}
