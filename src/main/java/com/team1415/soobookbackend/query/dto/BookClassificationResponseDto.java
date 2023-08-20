package com.team1415.soobookbackend.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookClassificationResponseDto {

    private Long bookId;
    private HashtagInformationResponseDto hashtagInformationResponseDto;
}
