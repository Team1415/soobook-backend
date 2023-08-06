package com.team1415.soobookbackend.book.application;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookApiQueryPort;
import com.team1415.soobookbackend.book.domain.port.BookFileQueryPort;
import com.team1415.soobookbackend.book.domain.port.BookStorageCommandPort;
import com.team1415.soobookbackend.book.domain.port.BookStorageQueryPort;
import com.team1415.soobookbackend.common.exception.NoSuchBookException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookCommandService {

    private final BookApiQueryPort bookApiQueryPort;
    private final BookStorageCommandPort bookStorageCommandPort;
    private final BookStorageQueryPort bookStorageQueryPort;
    private final BookFileQueryPort bookFileQueryPort;

    public List<BookInformation> saveBookInformationList(List<String> queryList) {

        List<BookInformation> savedBookInfomationList = new ArrayList<>();

        for (String query : queryList) {
            List<BookInformation> bookInformationList =
                    bookApiQueryPort.retrieveBookInformationList(query);

            for (BookInformation bookInformation : bookInformationList) {
                savedBookInfomationList.add(this.saveBookInformation(bookInformation));
            }
        }

        return savedBookInfomationList;
    }

    private BookInformation saveBookInformation(BookInformation bookInformation) {
        Book book = bookInformation.getBook();

        if (bookStorageQueryPort.isExistBook(book.getTitle(), book.getIsbn10(), book.getIsbn13())) {
            return bookStorageCommandPort.update(bookInformation);
        } else {
            return bookStorageCommandPort.insert(bookInformation);
        }
    }

    @Transactional
    public void saveBookInformationListByFile(MultipartFile file) {

        // csv 파일 파싱
        List<BookDetail> bookDetailList = bookFileQueryPort.retrieveBookDetailList(file);
        log.info("CSV : {}", bookDetailList);
        // csv파일 파싱결과 돌면서 후단 로직 처리
        for (BookDetail bookDetail : bookDetailList) {
            try {
                BookInformation apiResponseBookInformation = bookApiQueryPort.retrieveBookInformationList(bookDetail.getExistIsbn())
                        .stream().filter(bookInformation -> bookInformation.equalsByTitleAndIsbn(bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13()))
                        .findFirst().orElseThrow(() -> new NoSuchBookException(""));

                BookInformation storageBookInformation = bookStorageQueryPort.retrieveBookInformationByTitleAndIsbn(bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13())
                        .orElseGet(() -> new BookInformation(apiResponseBookInformation.getBook(), apiResponseBookInformation.getAuthorList(), apiResponseBookInformation.getTranslatorList()));

                if (ObjectUtils.isEmpty(storageBookInformation.getBook().getId())) {
                        storageBookInformation = bookStorageCommandPort.insert(apiResponseBookInformation);
                } else {
                    if (Boolean.FALSE.equals(apiResponseBookInformation.getBook().getBookPublish().publishDatetime()
                            .equals(storageBookInformation.getBook().getBookPublish().publishDatetime()))) {
                        storageBookInformation = bookStorageCommandPort.update(apiResponseBookInformation);
                    }
                }

                bookDetail.updateBookId(storageBookInformation.getBook().getId());
                if (Boolean.FALSE.equals(bookStorageQueryPort.retrieveBookDetailByTitleAndIsbn(bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13()).isPresent())) {
                    bookStorageCommandPort.insertDetail(bookDetail);
                } else {
                    BookDetail storageBookDetail = bookStorageQueryPort.retrieveBookDetailByTitleAndIsbn(bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13())
                            .get();

                    if (Boolean.FALSE.equals(StringUtils.equals(bookDetail.getUrl(), storageBookDetail.getUrl()))) {
                        bookStorageCommandPort.insertDetail(bookDetail);
                    } else {
                        bookStorageCommandPort.updateDetail(bookDetail);
                    }
                }
            } catch (RuntimeException e) {
                log.error("ISBN 이상함");
            }
        }
    }
}
