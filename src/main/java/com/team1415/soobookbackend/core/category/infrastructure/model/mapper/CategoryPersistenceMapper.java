package com.team1415.soobookbackend.core.category.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.core.category.infrastructure.model.CategoryPersistenceEntity;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryPersistenceMapper {

    List<Category> fromEntityToDomain(
            List<CategoryPersistenceEntity> categoryPersistenceEntityList);
}
