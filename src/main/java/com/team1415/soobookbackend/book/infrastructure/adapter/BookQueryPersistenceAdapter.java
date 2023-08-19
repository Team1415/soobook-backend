package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookStorageQueryPort;
import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.model.mapper.BookPersistenceMapper;
import com.team1415.soobookbackend.book.infrastructure.repository.BookDetailPersistenceRepository;
import com.team1415.soobookbackend.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static com.team1415.soobookbackend.common.constant.BookDetailSource.getMatchedSourceByUrl;

@Adapter
@RequiredArgsConstructor
public class BookQueryPersistenceAdapter implements BookStorageQueryPort {

    private final BookPersistenceRepository bookPersistenceRepository;
    private final BookDetailPersistenceRepository bookDetailPersistenceRepository;
    private final BookPersistenceMapper mapper;

    @Override
    public List<Book> retrieveNewestBookList() {

        return mapper.fromEntitysToDomainRoots(
                bookPersistenceRepository.findAll(
                        Sort.by(
                                Sort.Direction.DESC,
                                "bookPublishPersistenceEntity.publishDatetime")));
    }

    @Override
    public List<BookInformation> retrieveBookInformationListByIsbn10(List<String> isbn10List) {

        return mapper.fromEntitysToDomains(bookPersistenceRepository.findByIsbn10In(isbn10List));
    }

    @Override
    public List<BookInformation> retrieveBookInformationListByIsbn13(List<String> isbn13List) {

        return mapper.fromEntitysToDomains(bookPersistenceRepository.findByIsbn13In(isbn13List));
    }

    @Override
    public Optional<BookInformation> retrieveBookInformationByTitleAndIsbn(String title, String isbn10, String isbn13) {

        return Optional.ofNullable(mapper.fromEntityToDomain(bookPersistenceRepository.findOneByTitleAndIsbn10(title, isbn10)
                        .orElseGet(() -> bookPersistenceRepository.findOneByTitleAndIsbn13(title, isbn13).orElse(null))));
    }

    @Override
    public Optional<BookDetail> retrieveBookDetailByTitleAndIsbnAndUrl(String title, String isbn10, String isbn13, String url) {

        BookPersistenceEntity bookPersistenceEntity = bookPersistenceRepository.findOneByTitleAndIsbn10(title, isbn10)
                .orElseGet(() -> bookPersistenceRepository.findOneByTitleAndIsbn13(title, isbn13)
                        .orElseGet(() -> BookPersistenceEntity.builder().build()));

        if (ObjectUtils.isEmpty(bookPersistenceEntity.getId())) {
            return Optional.empty();
        }

        return Optional.ofNullable(mapper.fromEntityToDomainDetail(bookDetailPersistenceRepository.findOneByBookIdAndSource(
                bookPersistenceEntity.getId(), getMatchedSourceByUrl(url)).orElse(null)));
    }

    @Override
    public boolean isExistBook(String title, String isbn10, String isbn13) {
        return Boolean.logicalOr(bookPersistenceRepository.findOneByTitleAndIsbn10(title, isbn10).isPresent(),
                bookPersistenceRepository.findOneByTitleAndIsbn13(title, isbn13).isPresent());
    }
}
