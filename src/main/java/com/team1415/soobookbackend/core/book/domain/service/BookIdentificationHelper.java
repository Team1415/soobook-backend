package com.team1415.soobookbackend.core.book.domain.service;

import com.team1415.soobookbackend.core.book.domain.Book;
import com.team1415.soobookbackend.common.annotation.DomainService;
import org.apache.commons.lang3.StringUtils;

@DomainService
public class BookIdentificationHelper {

    public boolean equalsBooksByTitleAndIsbn(Book book1, Book book2) {
        return Boolean.logicalAnd(StringUtils.equals(book1.getTitle(), book2.getTitle()),
                Boolean.logicalOr(StringUtils.equals(book1.getIsbn10(), book2.getIsbn10()),
                        StringUtils.equals(book1.getIsbn13(), book2.getIsbn13())));
    }
}
