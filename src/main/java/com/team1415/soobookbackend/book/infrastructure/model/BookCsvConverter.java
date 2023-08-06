package com.team1415.soobookbackend.book.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team1415.soobookbackend.common.infrastructure.model.CsvConverter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BookCsvConverter implements CsvConverter {

    public final String[] headers = {"대분류", "중분류", "도서명", "ISBN타입", "ISBN", "목차", "url"};
    public final String type = "text/csv";

    @JsonProperty("도서명")
    private String bookName;
    @JsonProperty("ISBN타입")
    private String isbnType;
    @JsonProperty("ISBN")
    private String isbn;
    @JsonProperty("목차")
    private String bookIndex;
    @JsonProperty("url")
    private String bookDetailUrl;

    @Override
    public boolean equals(Object object) {
        if (object instanceof BookCsvConverter bookCsvConverter) {
            return Boolean.logicalAnd(StringUtils.equals(bookCsvConverter.getIsbnType(), isbnType),
                    StringUtils.equals(bookCsvConverter.getIsbn(), isbn));
        } else {
            return false;
        }
    } // equals 동등성비교

    @Override
    public int hashCode() {
        return isbn.hashCode();
    } // hashCode 재정의
}
