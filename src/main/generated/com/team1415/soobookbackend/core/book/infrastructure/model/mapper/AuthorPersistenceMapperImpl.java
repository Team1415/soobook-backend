package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Author;
import com.team1415.soobookbackend.core.book.infrastructure.model.AuthorPersistenceEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class AuthorPersistenceMapperImpl implements AuthorPersistenceMapper {

    @Override
    public Author fromEntityToDomain(AuthorPersistenceEntity authorPersistenceEntity) {
        if ( authorPersistenceEntity == null ) {
            return null;
        }

        Author.AuthorBuilder author = Author.builder();

        author.id( authorPersistenceEntity.getId() );
        author.name( authorPersistenceEntity.getName() );
        author.introduction( authorPersistenceEntity.getIntroduction() );

        return author.build();
    }

    @Override
    public List<Author> fromEntitysToDomains(Set<AuthorPersistenceEntity> authorPersistenceEntityList) {
        if ( authorPersistenceEntityList == null ) {
            return null;
        }

        List<Author> list = new ArrayList<Author>( authorPersistenceEntityList.size() );
        for ( AuthorPersistenceEntity authorPersistenceEntity : authorPersistenceEntityList ) {
            list.add( authorPersistenceEntityToAuthor( authorPersistenceEntity ) );
        }

        return list;
    }

    protected Author authorPersistenceEntityToAuthor(AuthorPersistenceEntity authorPersistenceEntity) {
        if ( authorPersistenceEntity == null ) {
            return null;
        }

        Author.AuthorBuilder author = Author.builder();

        author.id( authorPersistenceEntity.getId() );
        author.name( authorPersistenceEntity.getName() );
        author.introduction( authorPersistenceEntity.getIntroduction() );

        return author.build();
    }
}
