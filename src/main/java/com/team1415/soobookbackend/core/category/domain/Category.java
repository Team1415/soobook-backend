package com.team1415.soobookbackend.core.category.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Category {

    private Long id;
    private String name;
}
