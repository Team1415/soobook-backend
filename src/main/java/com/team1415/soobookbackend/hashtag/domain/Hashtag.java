package com.team1415.soobookbackend.hashtag.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Hashtag {

    private Long id;
    private Long category_id;
    private String name;
}
