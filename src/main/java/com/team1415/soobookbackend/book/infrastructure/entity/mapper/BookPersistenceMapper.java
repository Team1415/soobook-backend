package com.team1415.soobookbackend.book.infrastructure.entity.mapper;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookInformation;
import com.team1415.soobookbackend.book.domain.BookPublish;
import com.team1415.soobookbackend.book.infrastructure.entity.BookPersistenceEntity;
import com.team1415.soobookbackend.book.infrastructure.entity.BookPublishPersistenceEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = { AuthorPersistenceMapper.class, TranslatorPersistenceMapper.class })
public interface BookPersistenceMapper {

    @Named(value = "book")
    @Mapping(source = "bookPublishPersistenceEntity", target = "bookPublish", qualifiedByName = "bookPublish")
    Book fromEntityToDomainRoot(BookPersistenceEntity bookPersistenceEntity);

    @Named(value = "bookPublish")
    BookPublish fromEntityToValue(BookPublishPersistenceEntity bookPublishPersistenceEntity);

    @Named(value = "bookInformation")
    @Mapping(source = "authorPersistenceEntitySet", target = "authorList", qualifiedByName = "authorList")
    @Mapping(source = "translatorPersistenceEntitySet", target = "translatorList", qualifiedByName = "translatorList")
    BookInformation fromEntityToDomain(BookPersistenceEntity bookPersistenceEntity);

    @IterableMapping(qualifiedByName = { "book" })
    List<Book> fromEntitysToDomainRoots(List<BookPersistenceEntity> bookPersistenceEntityList);

    @IterableMapping(qualifiedByName = { "bookInformation" } )
    List<BookInformation> fromEntitysToDomains(List<BookPersistenceEntity> bookPersistenceEntityList);
}
