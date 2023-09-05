package com.team1415.soobookbackend.core.book.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team1415.soobookbackend.common.constant.BookDetailSource;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Builder
public class BookDetail {

    private Long id;
    private Long bookId;
    @JsonIgnore
    private String isbn10;
    @JsonIgnore
    private String isbn13;
    @JsonIgnore
    private String title;
    private String source;
    private String url;
    private String bookIndex;
    private String bookDescription;


    public static BookDetail create(String isbnType, String isbn, String title, String bookIndex,
                                    String bookDescription, String url) {

        BookDetail bookDetail = BookDetail.builder().title(title).source(BookDetailSource.getMatchedSourceByUrl(url))
                .bookIndex(bookIndex).bookDescription(bookDescription).url(url).build();
        bookDetail.updateIsbn(isbnType, isbn);
        return bookDetail;
    }

    public void updateBookId(Long bookId) {
        this.bookId = bookId;
    }
    public void update(BookDetail bookDetail) {

        this.isbn10 = bookDetail.getIsbn10();
        this.isbn13 = bookDetail.getIsbn13();
        this.title = bookDetail.getTitle();
        this.source = bookDetail.getSource();
        this.url = bookDetail.getUrl();
        this.bookIndex = bookDetail.getBookIndex();
        this.bookDescription = bookDetail.getBookDescription();
    }

    private void updateIsbn(String isbnType, String isbn) {
        if (Boolean.FALSE.equals(StringUtils.equalsAny(isbnType, "ISBN10", "ISBN13"))) {
            return;
        }

        if (StringUtils.equals(isbnType, "ISBN10")) {
            this.isbn10 = isbn;
        } else if (StringUtils.equals(isbnType, "ISBN13")) {
            this.isbn13 = isbn;
        }
    }

    public String getExistIsbn() {
        if (StringUtils.isNotEmpty(isbn10)) {
            return isbn10;
        } else if (StringUtils.isNotEmpty(isbn13)) {
            return isbn13;
        } else {
            return null;
        }
    }

    public boolean equalsByTitleAndIsbn(String title, String isbn10, String isbn13) {
        if (StringUtils.isNotEmpty(isbn10)) {
            return Boolean.logicalAnd(StringUtils.equals(title, this.title), StringUtils.equals(isbn10, this.isbn10));
        } else if (StringUtils.isNotEmpty(isbn13)) {
            return Boolean.logicalAnd(StringUtils.equals(title, this.title), StringUtils.equals(isbn13, this.isbn13));
        } else {
            return false;
        }
    }
}
