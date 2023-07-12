package com.team1415.soobookbackend.book.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BookInformation {

    private Book book;
    private List<Author> authorList;
    private List<Translator> translatorList;
}
