package com.team1415.soobookbackend.book.infrastructure.entity.mapper;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.infrastructure.entity.BookPersistenceEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface BookPersistenceMapper {

    List<Book> fromEntityToDomain(List<BookPersistenceEntity> bookPersistenceEntityList);
}
