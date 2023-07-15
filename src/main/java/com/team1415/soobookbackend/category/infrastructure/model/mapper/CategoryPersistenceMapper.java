package com.team1415.soobookbackend.category.infrastructure.model.mapper;

import com.team1415.soobookbackend.category.domain.Category;
import com.team1415.soobookbackend.category.infrastructure.model.CategoryPersistenceEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {

    List<Category> fromEntityToDomain(
            List<CategoryPersistenceEntity> categoryPersistenceEntityList);
}
