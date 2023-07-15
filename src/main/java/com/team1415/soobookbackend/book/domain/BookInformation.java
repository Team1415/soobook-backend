package com.team1415.soobookbackend.book.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookInformation {

    private Book book;
    private List<Author> authorList;
    private List<Translator> translatorList;
}
