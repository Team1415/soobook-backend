package com.team1415.soobookbackend.book.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KakaoBookSearchApiResponse {

    private String title;
    private String contents;

    @JsonProperty("url")
    private String bookDetailurl;

    private String isbn;

    @JsonProperty("datetime")
    private LocalDateTime publishDatetime;

    private String[] authors;
    private String publisher;
    private String[] translators;
    private Integer price;
    private Integer salePrice;
    private String thumbnail;
    private String status;
}
