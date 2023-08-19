package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Author;
import com.team1415.soobookbackend.core.book.infrastructure.model.AuthorPersistenceEntity;
import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface AuthorPersistenceMapper {

    @Named(value = "author")
    Author fromEntityToDomain(AuthorPersistenceEntity authorPersistenceEntity);

    @Named(value = "authorList")
    List<Author> fromEntitysToDomains(Set<AuthorPersistenceEntity> authorPersistenceEntityList);
}
