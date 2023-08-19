package com.team1415.soobookbackend.core.book.infrastructure.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class BookCsvModel {

    @CsvBindByName(column = "BookName")
    private String bookName;
    @CsvBindByName(column = "IsbnType")
    private String isbnType;
    @CsvBindByName(column = "Isbn")
    private String isbn;
    @CsvBindByName(column = "Index")
    private String bookIndex;
    @CsvBindByName(column = "Url")
    private String bookDetailUrl;

    @Override
    public boolean equals(Object object) {
        if (object instanceof BookCsvModel bookCsvModel) {
            return Boolean.logicalAnd(StringUtils.equals(bookCsvModel.getIsbnType(), isbnType),
                    StringUtils.equals(bookCsvModel.getIsbn(), isbn));
        } else {
            return false;
        }
    } // equals 동등성비교

    @Override
    public int hashCode() {
        return isbn.hashCode();
    } // hashCode 재정의
}
