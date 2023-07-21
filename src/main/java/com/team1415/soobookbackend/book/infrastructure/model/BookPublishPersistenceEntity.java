package com.team1415.soobookbackend.book.infrastructure.model;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
