package com.team1415.soobookbackend.book.infrastructure.entity.mapper;

import com.team1415.soobookbackend.book.domain.Translator;
import com.team1415.soobookbackend.book.infrastructure.entity.TranslatorPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper
public interface TranslatorPersistenceMapper {

    @Named(value = "translator")
    Translator fromEntityToDomain(TranslatorPersistenceEntity translatorPersistenceEntity);

    @Named(value = "translatorList")
    List<Translator> fromEntitysToDomains(Set<TranslatorPersistenceEntity> authorPersistenceEntityList);
}
