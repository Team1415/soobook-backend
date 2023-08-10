package com.team1415.soobookbackend.book.infrastructure.model;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "book_detail")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDetailPersistenceEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String bookIndex;
    private String url;

    public static BookDetailPersistenceEntity create(BookDetail bookDetail) {
        return BookDetailPersistenceEntity.builder()
                .bookId(bookDetail.getBookId())
                .bookIndex(bookDetail.getBookIndex())
                .url(bookDetail.getUrl())
                .build();
    }

    public void update(BookDetail bookDetail) {
        this.bookId = bookDetail.getBookId();
        this.bookIndex = bookDetail.getBookIndex();
    }
}
