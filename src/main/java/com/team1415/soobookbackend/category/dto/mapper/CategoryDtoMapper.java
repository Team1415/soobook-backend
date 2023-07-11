package com.team1415.soobookbackend.category.dto.mapper;

import com.team1415.soobookbackend.category.domain.Category;
import com.team1415.soobookbackend.category.dto.CategoryResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryDtoMapper {

    List<CategoryResponseDto> fromDomainToResponse(List<Category> categoryList);
}
