package com.team1415.soobookbackend.core.hashtag.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.infrastructure.model.HashtagPersistenceEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashtagPersistenceMapper {

    List<Hashtag> fromEntityToDomain(List<HashtagPersistenceEntity> hashtagPersistenceEntityList);
}
