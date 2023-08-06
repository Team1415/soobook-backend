package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.port.BookFileQueryPort;
import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.common.infrastructure.adapter.MultipartFileConvertAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Adapter
@RequiredArgsConstructor
public class BookCsvReaderAdapter implements BookFileQueryPort {

    private final MultipartFileConvertAdapter multipartFileConvertAdapter;

    @Override
    public List<BookDetail> retrieveBookDetailList(MultipartFile file) {

        try {
            return multipartFileConvertAdapter.toPojo(file, BookDetail.class);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
