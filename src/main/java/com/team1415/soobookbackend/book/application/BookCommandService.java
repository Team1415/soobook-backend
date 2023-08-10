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
import org.apache.commons.collections4.CollectionUtils;
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

    @Transactional
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

    // TODO : 리팩토링 필요
    @Transactional
    public void saveBookInformationListByFile(MultipartFile file) {

        // csv 파일 파싱
        List<BookDetail> bookDetailList = CollectionUtils.emptyIfNull(bookFileQueryPort.retrieveBookDetailList(file))
                .stream().filter(bookDetail -> {
                    if (StringUtils.isNoneEmpty(bookDetail.getExistIsbn(), bookDetail.getTitle())) {
                        return true;
                    } else {
                        log.error("ISBN 데이터가 부정확한 도서가 존재합니다. 도서명 : {}, ISBN : {}", bookDetail.getTitle(), bookDetail.getExistIsbn());
                        return false;
                    }
                })
                .toList();

        // csv파일 파싱결과 돌면서 후단 로직 처리
        for (BookDetail bookDetail : bookDetailList) {
            try {
                BookInformation apiResponseBookInformation = bookApiQueryPort.retrieveBookInformationList(bookDetail.getExistIsbn())
                        .stream().filter(bookInformation -> bookInformation.equalsByTitleAndIsbn(
                                bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13()))
                        .findFirst().orElseThrow(() -> new NoSuchBookException(bookDetail.getTitle()));

                BookInformation storageBookInformation = bookStorageQueryPort.retrieveBookInformationByTitleAndIsbn(
                        bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13())
                        .orElseGet(() -> new BookInformation(apiResponseBookInformation.getBook(),
                                apiResponseBookInformation.getAuthorList(), apiResponseBookInformation.getTranslatorList()));

                if (ObjectUtils.isEmpty(storageBookInformation.getBook().getId())) {
                    storageBookInformation = bookStorageCommandPort.insert(apiResponseBookInformation);
                } else if (Boolean.FALSE.equals(apiResponseBookInformation.getBook().getBookPublish().publishDatetime()
                        .equals(storageBookInformation.getBook().getBookPublish().publishDatetime()))) {
                    storageBookInformation = bookStorageCommandPort.update(apiResponseBookInformation);
                }

                BookDetail storageBookDetail = bookStorageQueryPort.retrieveBookDetailByTitleAndIsbn(
                        bookDetail.getTitle(), bookDetail.getIsbn10(), bookDetail.getIsbn13()).orElse(bookDetail);

                if (ObjectUtils.isEmpty(storageBookDetail.getBookId())) {
                    bookDetail.updateBookId(storageBookInformation.getBook().getId());
                    bookStorageCommandPort.insertDetail(bookDetail);
                } else {
                    if (Boolean.FALSE.equals(StringUtils.equals(bookDetail.getUrl(), storageBookDetail.getUrl()))) {
                        bookStorageCommandPort.insertDetail(bookDetail);
                    } else {
                        bookStorageCommandPort.updateDetail(bookDetail);
                    }
                }
            } catch (NoSuchBookException e) {
                log.error("Kakao Book Search API 조회결과가 존재하지 않습니다. 도서명 : {}", e.getMessage());
            } catch (Exception e) {
                log.error("Book 저장 실패. Causes : {}", e.toString());
            }
        }
    }
}
