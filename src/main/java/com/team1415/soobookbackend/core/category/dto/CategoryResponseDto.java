package com.team1415.soobookbackend.core.category.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponseDto {

    private Long id;
    private String name;
}
