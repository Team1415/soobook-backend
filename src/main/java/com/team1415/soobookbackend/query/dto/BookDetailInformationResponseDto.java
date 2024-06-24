package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookDetailInformationResponseDto {

    private Long id;
    private String isbn10;
    private String isbn13;
    private String title;
    @JsonProperty(value = "authors")
    private List<String> authorList;
    @JsonProperty(value = "translators")
    private List<String> translatorList;
    private String publisher;
    private Long price;
    private Long salePrice;
    private String status;
    private LocalDateTime publishDate;
    @JsonProperty(value = "thumbnailUrl")
    private String thumbnail;
    @JsonProperty(value = "hashtags")
    private List<HashtagInformationResponseDto> hashtagInformationList;
    private String index;
    private String description;
}
