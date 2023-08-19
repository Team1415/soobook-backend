package com.team1415.soobookbackend.core.category.controller;

import com.team1415.soobookbackend.core.category.application.CategoryQueryService;
import com.team1415.soobookbackend.core.category.dto.CategoryResponseDto;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryQueryService categoryQueryService;

    @GetMapping("/categorys")
    public List<CategoryResponseDto> retrieveCategoryList() {
        return categoryQueryService.retrieveCategoryList();
    }
}
