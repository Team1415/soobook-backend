package com.team1415.soobookbackend.book.infrastructure.entity;

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
}