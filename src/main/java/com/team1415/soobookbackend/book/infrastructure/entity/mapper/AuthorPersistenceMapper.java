package com.team1415.soobookbackend.book.infrastructure.entity.mapper;

import com.team1415.soobookbackend.book.domain.Author;
import com.team1415.soobookbackend.book.infrastructure.entity.AuthorPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper
public interface AuthorPersistenceMapper {

    @Named(value = "author")
    Author fromEntityToDomain(AuthorPersistenceEntity authorPersistenceEntity);

    @Named(value = "authorList")
    List<Author> fromEntitysToDomains(Set<AuthorPersistenceEntity> authorPersistenceEntityList);
}