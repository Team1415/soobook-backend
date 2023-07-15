package com.team1415.soobookbackend.category.dto.mapper;

import com.team1415.soobookbackend.category.domain.Category;
import com.team1415.soobookbackend.category.dto.CategoryResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryDtoMapper {

    List<CategoryResponseDto> fromDomainToResponse(List<Category> categoryList);
}
