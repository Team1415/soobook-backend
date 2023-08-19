package com.team1415.soobookbackend.core.book.domain;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
@Builder
public class BookInformation {

    private Book book;
    private List<Author> authorList;
    private List<Translator> translatorList;

    public BookInformation(Book book, List<Author> authorList, List<Translator> translatorList) {
        this.book = book;
        this.authorList = authorList;
        this.translatorList = translatorList;
    }

    public boolean equalsByTitleAndIsbn(String title, String isbn10, String isbn13) {
        if (StringUtils.isNotEmpty(isbn10)) {
            return Boolean.logicalAnd(StringUtils.equals(title, this.book.getTitle()), StringUtils.equals(isbn10, this.book.getIsbn10()));
        } else if (StringUtils.isNotEmpty(isbn13)) {
            return Boolean.logicalAnd(StringUtils.equals(title, this.book.getTitle()), StringUtils.equals(isbn13, this.book.getIsbn13()));
        } else {
            return false;
        }
    }
}
