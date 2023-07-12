package com.team1415.soobookbackend.book.infrastructure.adapter;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.port.BookQueryPort;
import com.team1415.soobookbackend.book.infrastructure.entity.mapper.BookPersistenceMapper;
import com.team1415.soobookbackend.book.infrastructure.repository.BookPersistenceRepository;
import com.team1415.soobookbackend.common.annotation.Adapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class BookQueryPersistenceAdapter implements BookQueryPort {

    private final BookPersistenceRepository repository;
    private final BookPersistenceMapper mapper;

    @Override
    public List<Book> retrieveNewestBookList() {

        return mapper.fromEntitysToDomainRoots(repository.findAll(
            Sort.by(Sort.Direction.DESC, "publishDatetime")));
    }
}
