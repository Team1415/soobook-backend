package com.team1415.soobookbackend.core.book.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Author {

    private Long id;
    private String name;
    private String introduction;

    public static Author create(String name, String introduction) {
        return Author.builder().name(name).introduction(introduction).build();
    }
}
