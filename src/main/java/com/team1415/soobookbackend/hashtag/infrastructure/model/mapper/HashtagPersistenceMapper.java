package com.team1415.soobookbackend.hashtag.infrastructure.model.mapper;

import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.infrastructure.model.HashtagPersistenceEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface HashtagPersistenceMapper {

    List<Hashtag> fromEntityToDomain(List<HashtagPersistenceEntity> hashtagPersistenceEntityList);
}
