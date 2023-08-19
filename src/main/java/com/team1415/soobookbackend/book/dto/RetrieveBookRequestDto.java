package com.team1415.soobookbackend.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveBookRequestDto {

    private String type;
    private String sort;
    @JsonProperty("category")
    private Long categoryId;
    @JsonProperty("hashtags")
    private Long[] hashtagIds;
    private Long bookId;
}
