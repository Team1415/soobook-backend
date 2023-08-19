package com.team1415.soobookbackend.core.book.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BookResponseDto {

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
}
