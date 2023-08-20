package com.team1415.soobookbackend.core.category.application;

import com.team1415.soobookbackend.core.category.domain.port.CategoryQueryPort;
import com.team1415.soobookbackend.core.category.dto.CategoryResponseDto;
import com.team1415.soobookbackend.core.category.dto.mapper.CategoryDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryQueryService {

    private final CategoryQueryPort categoryQueryPort;
    private final CategoryDtoMapper categoryDtoMapper;

    public List<CategoryResponseDto> retrieveCategoryList() {

        return categoryDtoMapper.fromDomainToResponse(categoryQueryPort.findAll());
    }
}
