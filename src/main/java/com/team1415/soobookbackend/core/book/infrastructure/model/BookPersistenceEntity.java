package com.team1415.soobookbackend.core.book.infrastructure.model;

import com.team1415.soobookbackend.core.book.domain.Author;
import com.team1415.soobookbackend.core.book.domain.Book;
import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.core.book.domain.Translator;
import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@SuperBuilder
@Table(name = "book")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn10;
    private String isbn13;
    private String title;
    @Embedded private BookPublishPersistenceEntity bookPublishPersistenceEntity;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author_mapping",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<AuthorPersistenceEntity> authorPersistenceEntitySet;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_translator_mapping",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "translator_id")})
    private Set<TranslatorPersistenceEntity> translatorPersistenceEntitySet;

    @SuppressWarnings(value = "java:S3252")
    public static BookPersistenceEntity create(BookInformation bookInformation) {
        Book book = bookInformation.getBook();
        List<Author> authorList = bookInformation.getAuthorList();
        List<Translator> translatorList = bookInformation.getTranslatorList();

        return BookPersistenceEntity.builder()
                .isbn10(bookInformation.getBook().getIsbn10())
                .isbn13(bookInformation.getBook().getIsbn13())
                .title(bookInformation.getBook().getTitle())
                .bookPublishPersistenceEntity(
                        BookPublishPersistenceEntity.builder()
                                .publisher(book.getBookPublish().publisher())
                                .price(book.getBookPublish().price())
                                .salePrice(book.getBookPublish().salePrice())
                                .status(book.getBookPublish().status())
                                .publishDatetime(book.getBookPublish().publishDatetime())
                                .thumbnail(book.getBookPublish().thumbnail())
                                .build())
                .authorPersistenceEntitySet(
                        authorList.stream()
                                .map(
                                        author ->
                                                AuthorPersistenceEntity.createByBook(
                                                        author.getName(), author.getIntroduction()))
                                .collect(Collectors.toSet()))
                .translatorPersistenceEntitySet(
                        translatorList.stream()
                                .map(
                                        translator ->
                                                TranslatorPersistenceEntity.createByBook(
                                                        translator.getName(),
                                                        translator.getIntroduction()))
                                .collect(Collectors.toSet()))
                .build();
    }

    public void update(BookInformation bookInformation) {

        Book book = bookInformation.getBook();

        this.isbn10 = book.getIsbn10();
        this.isbn13 = book.getIsbn13();
        this.title = book.getTitle();
        this.bookPublishPersistenceEntity.update(book.getBookPublish());
    }
}
