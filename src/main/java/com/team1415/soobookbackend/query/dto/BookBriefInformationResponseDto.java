package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookBriefInformationResponseDto {

    private Long id;
    private String title;
    @JsonProperty(value = "authors")
    private List<String> authorList;
    @JsonProperty(value = "translators")
    private List<String> translatorList;
    private String publisher;
    @JsonProperty(value = "thumbnailUrl")
    private String thumbnail;
    @JsonProperty(value = "hashtags")
    private List<HashtagInformationResponseDto> hashtagInformationList;
}
