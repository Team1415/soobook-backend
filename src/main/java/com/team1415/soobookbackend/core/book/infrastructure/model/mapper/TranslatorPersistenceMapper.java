package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Translator;
import com.team1415.soobookbackend.core.book.infrastructure.model.TranslatorPersistenceEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TranslatorPersistenceMapper {

    @Named(value = "translator")
    Translator fromEntityToDomain(TranslatorPersistenceEntity translatorPersistenceEntity);

    @Named(value = "translatorList")
    @IterableMapping(qualifiedByName = "translator")
    List<Translator> fromEntitysToDomains(
            Set<TranslatorPersistenceEntity> authorPersistenceEntityList);
}
