package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RetrieveBookClassificationRequestDto {

    private String sort;
    @JsonProperty("category")
    private Long categoryId;
    @JsonProperty("hashtags")
    private Long[] hashtagIds;
}
