package com.team1415.soobookbackend.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Book {

    private Long id;
    private Long isbn10;
    private Long isbn13;
    private String title;
    private BookPublish bookPublish;
}
