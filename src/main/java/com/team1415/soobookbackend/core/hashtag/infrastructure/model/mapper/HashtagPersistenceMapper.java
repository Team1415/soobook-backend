package com.team1415.soobookbackend.core.hashtag.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.infrastructure.model.HashtagPersistenceEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagPersistenceMapper {

    @Named(value = "hashTag")
    Hashtag fromEntityToDomain(HashtagPersistenceEntity hashtagPersistenceEntity);
    @IterableMapping(qualifiedByName = {"hashTag"})
    List<Hashtag> fromEntityToDomain(List<HashtagPersistenceEntity> hashtagPersistenceEntityList);
}
