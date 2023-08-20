package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class RetrieveBookClassificationRequestDto {

    private String sort;
    @JsonAlias("category")
    private Long categoryId;
    @JsonAlias("hashtags")
    private Long[] hashtagIds;
}
