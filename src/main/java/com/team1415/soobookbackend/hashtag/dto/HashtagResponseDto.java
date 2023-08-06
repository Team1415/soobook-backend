package com.team1415.soobookbackend.hashtag.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HashtagResponseDto {

    private Long id;
    private String name;
}
