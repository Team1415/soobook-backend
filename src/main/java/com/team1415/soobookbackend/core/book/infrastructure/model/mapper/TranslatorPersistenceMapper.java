package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Translator;
import com.team1415.soobookbackend.core.book.infrastructure.model.TranslatorPersistenceEntity;
import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TranslatorPersistenceMapper {

    @Named(value = "translator")
    Translator fromEntityToDomain(TranslatorPersistenceEntity translatorPersistenceEntity);

    @Named(value = "translatorList")
    List<Translator> fromEntitysToDomains(
            Set<TranslatorPersistenceEntity> authorPersistenceEntityList);
}
