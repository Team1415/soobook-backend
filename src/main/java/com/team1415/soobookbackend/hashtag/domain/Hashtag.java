package com.team1415.soobookbackend.hashtag.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Hashtag {

    private Long id;
    private Long categoryId;
    private String name;
}
