package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.port.BookFileQueryPort;
import com.team1415.soobookbackend.book.infrastructure.model.BookCsvConverter;
import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.common.infrastructure.adapter.CsvReader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Adapter
@RequiredArgsConstructor
public class BookCsvReaderAdapter implements BookFileQueryPort {

    @Override
    public List<BookDetail> retrieveBookDetailList(MultipartFile file) {

        CsvReader csvReader = new CsvReader(new BookCsvConverter());
        if (Boolean.FALSE.equals(csvReader.hasCSVFormat(file))) {
            return new ArrayList<>();
        }

        try {
            return Stream.of((BookCsvConverter)csvReader.readCSVtoList(file)).map(bookCsvConverter ->
                    BookDetail.create(bookCsvConverter.getIsbnType(), bookCsvConverter.getIsbn(),
                            bookCsvConverter.getBookName(), bookCsvConverter.getBookIndex(),
                            bookCsvConverter.getBookDetailUrl())).toList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
