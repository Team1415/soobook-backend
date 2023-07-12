package com.team1415.soobookbackend.book.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Book {

    private Long id;
    private String isbn10;
    private String isbn13;
    private String title;
    private BookPublish bookPublish;
}
