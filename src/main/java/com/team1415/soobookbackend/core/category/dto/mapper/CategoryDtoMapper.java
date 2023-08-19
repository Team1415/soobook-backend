package com.team1415.soobookbackend.core.category.dto.mapper;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.core.category.dto.CategoryResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    List<CategoryResponseDto> fromDomainToResponse(List<Category> categoryList);
}
