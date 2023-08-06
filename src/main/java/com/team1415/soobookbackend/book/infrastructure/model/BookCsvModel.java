package com.team1415.soobookbackend.book.infrastructure.model;

import com.opencsv.bean.CsvBindByName;
import com.team1415.soobookbackend.common.infrastructure.model.CsvConverter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BookCsvModel implements CsvConverter {

    public final String[] headers = {"대분류", "중분류", "도서명", "ISBN타입", "ISBN", "목차", "url"};
    public final String type = "text/csv";

    @CsvBindByName(column = "도서명")
    private String bookName;
    @CsvBindByName(column = "ISBN타입")
    private String isbnType;
    @CsvBindByName(column = "ISBN")
    private String isbn;
    @CsvBindByName(column = "목차")
    private String bookIndex;
    @CsvBindByName(column = "url")
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
