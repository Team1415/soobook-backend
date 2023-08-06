package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookStorageQueryPort;
import com.team1415.soobookbackend.book.infrastructure.model.mapper.BookPersistenceMapper;
import com.team1415.soobookbackend.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Adapter
@RequiredArgsConstructor
public class BookQueryPersistenceAdapter implements BookStorageQueryPort {

    private final BookPersistenceRepository repository;
    private final BookPersistenceMapper mapper;

    @Override
    public List<Book> retrieveNewestBookList() {

        return mapper.fromEntitysToDomainRoots(
                repository.findAll(
                        Sort.by(
                                Sort.Direction.DESC,
                                "bookPublishPersistenceEntity.publishDatetime")));
    }

    @Override
    public List<BookInformation> retrieveBookInformationListByIsbn10(List<String> isbn10List) {

        return mapper.fromEntitysToDomains(repository.findByIsbn10(isbn10List));
    }

    @Override
    public List<BookInformation> retrieveBookInformationListByIsbn13(List<String> isbn13List) {

        return mapper.fromEntitysToDomains(repository.findByIsbn13(isbn13List));
    }

    @Override
    public Optional<BookInformation> retrieveBookInformationByTitleAndIsbn(String title, String isbn10, String isbn13) {

        return repository.retrieveByTitleAndIsbn(title, isbn10, isbn13);
    }

    @Override
    public Optional<BookDetail> retrieveBookDetailByTitleAndIsbn(String title, String isbn10, String isbn13) {
        return repository.retrieveBookDetailByTitleAndIsbn(title, isbn10, isbn13);
    }

    @Override
    public boolean isExistBook(String title, String isbn10, String isbn13) {
        return Boolean.logicalOr(repository.findOneByTitleAndIsbn10(title, isbn10).isPresent(),
                repository.findOneByTitleAndIsbn13(title, isbn13).isPresent());
    }
}
