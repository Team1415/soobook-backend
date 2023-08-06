package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.port.BookFileQueryPort;
import com.team1415.soobookbackend.book.infrastructure.model.BookCsvModel;
import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.common.infrastructure.adapter.MultipartFileConvertAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Adapter
@RequiredArgsConstructor
public class BookCsvReaderAdapter implements BookFileQueryPort {

    private final MultipartFileConvertAdapter multipartFileConvertAdapter;

    @Override
    public List<BookDetail> retrieveBookDetailList(MultipartFile file) {

        try {
            List<BookCsvModel> bookCsvModelList = multipartFileConvertAdapter.toPojo(file, BookCsvModel.class);
            return bookCsvModelList.stream().map(bookCsvModel ->
                BookDetail.create(bookCsvModel.getIsbnType(), bookCsvModel.getIsbn(), bookCsvModel.getBookName(),
                        bookCsvModel.getBookIndex(), bookCsvModel.getBookDetailUrl())).toList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
