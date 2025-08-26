package com.team1415.soobookbackend.core.category.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.core.category.infrastructure.model.CategoryPersistenceEntity;
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
public class CategoryPersistenceMapperImpl implements CategoryPersistenceMapper {

    @Override
    public List<Category> fromEntityToDomain(List<CategoryPersistenceEntity> categoryPersistenceEntityList) {
        if ( categoryPersistenceEntityList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryPersistenceEntityList.size() );
        for ( CategoryPersistenceEntity categoryPersistenceEntity : categoryPersistenceEntityList ) {
            list.add( categoryPersistenceEntityToCategory( categoryPersistenceEntity ) );
        }

        return list;
    }

    protected Category categoryPersistenceEntityToCategory(CategoryPersistenceEntity categoryPersistenceEntity) {
        if ( categoryPersistenceEntity == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( categoryPersistenceEntity.getId() );
        category.name( categoryPersistenceEntity.getName() );

        return category.build();
    }
}
