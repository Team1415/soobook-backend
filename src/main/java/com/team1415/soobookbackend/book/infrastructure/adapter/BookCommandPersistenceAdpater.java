package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.port.BookStorageCommandPort;
import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class BookCommandPersistenceAdpater implements BookStorageCommandPort {

    private final BookPersistenceRepository bookPersistenceRepository;

    @Override
    public void insert(BookInformation bookInformation) {
        bookPersistenceRepository.save(BookPersistenceEntity.create(bookInformation));
    }
}
