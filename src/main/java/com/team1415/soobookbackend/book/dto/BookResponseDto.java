package com.team1415.soobookbackend.book.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BookResponseDto {

    private Long id;
    private Long isbn10;
    private Long isbn13;
    private String title;
    private String publisher;
    private Long price;
    private Long salePrice;
    private String status;
    private LocalDateTime publishDatetime;
    private String thumbnail;
}
