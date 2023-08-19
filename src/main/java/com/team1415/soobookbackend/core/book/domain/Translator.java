package com.team1415.soobookbackend.core.book.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Translator {

    private Long id;
    private String name;
    private String introduction;

    public static Translator create(String name, String introduction) {
        return Translator.builder().name(name).introduction(introduction).build();
    }
}
