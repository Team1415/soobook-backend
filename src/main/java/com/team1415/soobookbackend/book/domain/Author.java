package com.team1415.soobookbackend.book.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Author {

    private Long id;
    private String name;
    private String introduction;
}
