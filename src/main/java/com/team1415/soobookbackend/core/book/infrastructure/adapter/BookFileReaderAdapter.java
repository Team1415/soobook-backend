package com.team1415.soobookbackend.core.book.infrastructure.adapter;

import com.team1415.soobookbackend.core.book.domain.BookDetail;
import com.team1415.soobookbackend.core.book.domain.port.BookFileQueryPort;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookExcelModel;
import com.team1415.soobookbackend.common.annotation.Adapter;
import com.team1415.soobookbackend.common.infrastructure.adapter.MultipartFileConvertAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Adapter
@RequiredArgsConstructor
public class BookFileReaderAdapter implements BookFileQueryPort {

    private final MultipartFileConvertAdapter multipartFileConvertAdapter;

    @Override
    public List<BookDetail> retrieveBookDetailList(MultipartFile file) {

        try {
            List<BookExcelModel> bookExcelModelList = multipartFileConvertAdapter.toPojo(file, BookExcelModel.class);

            return bookExcelModelList.stream().map(bookExcelModel ->

                    BookDetail.create(bookExcelModel.getIsbnType(), bookExcelModel.getIsbn(), bookExcelModel.getBookName(),
                        bookExcelModel.getBookIndex(), bookExcelModel.getBookDescription(), bookExcelModel.getBookDetailUrl()
                    )).toList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
