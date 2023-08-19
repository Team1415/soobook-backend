package com.team1415.soobookbackend.core.book.infrastructure.repository;

import com.team1415.soobookbackend.core.book.dto.RetrieveBookRequestDto;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;

import java.util.List;

public interface BookQueryDslRepository {

    List<BookPersistenceEntity> retrieveBookInformationList(RetrieveBookRequestDto retrieveBookRequestDto);
}
