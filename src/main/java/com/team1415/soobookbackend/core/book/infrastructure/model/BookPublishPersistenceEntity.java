package com.team1415.soobookbackend.core.book.infrastructure.model;

import com.team1415.soobookbackend.core.book.domain.BookPublish;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookPublishPersistenceEntity {

    private String publisher;
    private Long price;
    private Long salePrice;
    private String status;
    private LocalDateTime publishDatetime;
    private String thumbnail;

    public void update(BookPublish bookPublish) {
        this.publisher = bookPublish.publisher();
        this.price = bookPublish.price();
        this.salePrice = bookPublish.salePrice();
        this.status = bookPublish.status();
        this.publishDatetime = bookPublish.publishDatetime();
        this.thumbnail = bookPublish.thumbnail();
    }
}
