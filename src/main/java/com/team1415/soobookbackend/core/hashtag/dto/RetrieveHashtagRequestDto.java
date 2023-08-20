package com.team1415.soobookbackend.core.hashtag.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RetrieveHashtagRequestDto {

    @JsonProperty("category")
    private Long categoryId;
}
