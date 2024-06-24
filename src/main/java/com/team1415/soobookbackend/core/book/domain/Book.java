package com.team1415.soobookbackend.core.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Getter
@Builder
public class Book {

    private Long id;
    private String isbn10;
    private String isbn13;
    private String title;
    private BookPublish bookPublish;

    public static Book create(String isbn, String title, BookPublish bookPublish) {
        Book book = Book.builder().isbn10("").isbn13("").title(title).bookPublish(bookPublish).build();
        book.updateIsbn(isbn);
        return book;
    }

    private void updateIsbn(String isbn) {
        if (Boolean.FALSE.equals(StringUtils.contains(isbn, " "))) {
            return;
        }

        String[] splitedIsbns = StringUtils.split(isbn, " ");

        for (String splitedIsbn : splitedIsbns) {
            if (StringUtils.length(splitedIsbn) == 10) {
                this.isbn10 = splitedIsbn;
            } else if (StringUtils.length(splitedIsbn) == 13) {
                this.isbn13 = splitedIsbn;
            }
        }
    }
}
