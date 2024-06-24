package com.team1415.soobookbackend.query.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class CategoryInfomationResponseDto {

    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Long> bookIdList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<HashtagInformationResponseDto> hashtagInformationResponseDtoList;

}
