package com.team1415.soobookbackend.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
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
        Book book = Book.builder().title(title).bookPublish(bookPublish).build();
        book.updateIsbn(isbn);
        return book;
    }

    public void updateIsbn(String isbn) {
        if (StringUtils.contains(isbn, " ")
                && ArrayUtils.getLength(StringUtils.split(isbn, " ")) == 2) {
            String[] splitedIsbn = StringUtils.split(isbn, " ");
            this.isbn10 = splitedIsbn[0];
            this.isbn13 = splitedIsbn[1];
            return;
        }

        if (StringUtils.length(isbn) == 10) {
            this.isbn10 = isbn;
        } else if (StringUtils.length(isbn) == 13) {
            this.isbn13 = isbn;
        }
    }
}
