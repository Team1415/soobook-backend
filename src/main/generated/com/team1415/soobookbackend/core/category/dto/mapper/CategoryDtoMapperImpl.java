package com.team1415.soobookbackend.core.category.dto.mapper;

import com.team1415.soobookbackend.core.category.domain.Category;
import com.team1415.soobookbackend.core.category.dto.CategoryResponseDto;
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
public class CategoryDtoMapperImpl implements CategoryDtoMapper {

    @Override
    public List<CategoryResponseDto> fromDomainToResponse(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryResponseDto> list = new ArrayList<CategoryResponseDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( categoryToCategoryResponseDto( category ) );
        }

        return list;
    }

    protected CategoryResponseDto categoryToCategoryResponseDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponseDto.CategoryResponseDtoBuilder categoryResponseDto = CategoryResponseDto.builder();

        categoryResponseDto.id( category.getId() );
        categoryResponseDto.name( category.getName() );

        return categoryResponseDto.build();
    }
}
