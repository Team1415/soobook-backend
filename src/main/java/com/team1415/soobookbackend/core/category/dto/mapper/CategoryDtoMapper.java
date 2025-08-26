package com.team1415.soobookbackend.core.category.dto.mapper;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.core.category.dto.CategoryResponseDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Named(value = "category")
    CategoryResponseDto fromDomainToResponse(Category category);
    @IterableMapping(qualifiedByName = {"category"})
    List<CategoryResponseDto> fromDomainToResponse(List<Category> categoryList);
}
