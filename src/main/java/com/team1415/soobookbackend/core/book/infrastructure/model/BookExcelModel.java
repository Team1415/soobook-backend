package com.team1415.soobookbackend.core.book.infrastructure.model;

import com.poiji.annotation.ExcelCellName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class BookExcelModel {

    @ExcelCellName("BookName")
    private String bookName;
    @ExcelCellName("IsbnType")
    private String isbnType;
    @ExcelCellName("Isbn")
    private String isbn;
    @ExcelCellName("Index")
    private String bookIndex;
    @ExcelCellName("Url")
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
