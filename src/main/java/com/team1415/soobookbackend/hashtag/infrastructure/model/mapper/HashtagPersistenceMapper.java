package com.team1415.soobookbackend.hashtag.infrastructure.model.mapper;

import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.infrastructure.model.HashtagPersistenceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HashtagPersistenceMapper {

    List<Hashtag> fromEntityToDomain(List<HashtagPersistenceEntity> hashtagPersistenceEntityList);
}
