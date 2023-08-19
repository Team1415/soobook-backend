package com.team1415.soobookbackend.book.infrastructure.repository;

import com.team1415.soobookbackend.book.dto.RetrieveBookRequestDto;
import com.team1415.soobookbackend.book.infrastructure.model.BookPersistenceEntity;

import java.util.List;

public interface BookQueryDslRepository {

    List<BookPersistenceEntity> retrieveBookInformationList(RetrieveBookRequestDto retrieveBookRequestDto);
}
