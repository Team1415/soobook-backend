package com.team1415.soobookbackend.core.hashtag.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.infrastructure.model.HashtagPersistenceEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class HashtagPersistenceMapperImpl implements HashtagPersistenceMapper {

    @Override
    public List<Hashtag> fromEntityToDomain(List<HashtagPersistenceEntity> hashtagPersistenceEntityList) {
        if ( hashtagPersistenceEntityList == null ) {
            return null;
        }

        List<Hashtag> list = new ArrayList<Hashtag>( hashtagPersistenceEntityList.size() );
        for ( HashtagPersistenceEntity hashtagPersistenceEntity : hashtagPersistenceEntityList ) {
            list.add( hashtagPersistenceEntityToHashtag( hashtagPersistenceEntity ) );
        }

        return list;
    }

    protected Hashtag hashtagPersistenceEntityToHashtag(HashtagPersistenceEntity hashtagPersistenceEntity) {
        if ( hashtagPersistenceEntity == null ) {
            return null;
        }

        Hashtag.HashtagBuilder hashtag = Hashtag.builder();

        hashtag.id( hashtagPersistenceEntity.getId() );
        hashtag.categoryId( hashtagPersistenceEntity.getCategoryId() );
        hashtag.name( hashtagPersistenceEntity.getName() );

        return hashtag.build();
    }
}
