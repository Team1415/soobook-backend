package com.team1415.soobookbackend.category.application;

import com.team1415.soobookbackend.category.domain.port.CategoryQueryPort;
import com.team1415.soobookbackend.category.dto.CategoryResponseDto;
import com.team1415.soobookbackend.category.dto.mapper.CategoryDtoMapper;
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

        return categoryDtoMapper.fromDomainToDto(categoryQueryPort.findAll());
    }
}
