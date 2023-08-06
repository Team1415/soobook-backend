package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookDetail;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookStorageCommandPort;
import com.team1415.soobookbackend.book.infrastructure.model.BookDetailPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.model.mapper.BookPersistenceMapper;
import com.team1415.soobookbackend.book.infrastructure.repository.BookDetailPersistenceRepository;
import com.team1415.soobookbackend.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class BookCommandPersistenceAdpater implements BookStorageCommandPort {

    private final BookPersistenceRepository bookPersistenceRepository;
    private final BookDetailPersistenceRepository bookDetailPersistenceRepository;
    private final BookPersistenceMapper bookPersistenceMapper;

    @Override
    public BookInformation insert(BookInformation bookInformation) {
        return bookPersistenceMapper.fromEntityToDomain(
                bookPersistenceRepository.save(BookPersistenceEntity.create(bookInformation)));
    }

    @Override
    public BookInformation update(BookInformation bookInformation) {
        BookPersistenceEntity bookPersistenceEntity = bookPersistenceRepository.findById(bookInformation.getBook().getId())
                .orElseThrow(NoResultException::new);

        bookPersistenceEntity.update(bookInformation);
        return bookPersistenceMapper.fromEntityToDomain(bookPersistenceEntity);
    }

    @Override
    public BookDetail insertDetail(BookDetail bookDetail) {
        return bookPersistenceMapper.fromEntityToDomainDetail(
                bookDetailPersistenceRepository.save(BookDetailPersistenceEntity.create(bookDetail)));
    }

    @Override
    public BookDetail updateDetail(BookDetail bookDetail) {
        BookDetailPersistenceEntity bookDetailPersistenceEntity = bookDetailPersistenceRepository.findById(bookDetail.getId())
                .orElseThrow(NoResultException::new);

        bookDetailPersistenceEntity.update(bookDetail);
        return bookPersistenceMapper.fromEntityToDomainDetail(bookDetailPersistenceEntity);
    }
}
