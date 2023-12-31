package com.team1415.soobookbackend.query.controller;

import com.team1415.soobookbackend.query.application.service.ClassificationQueryService;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookClassificationRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClassificationController {

    private final ClassificationQueryService classificationQueryService;

    @GetMapping("/hashtags")
    public List<HashtagInformationResponseDto> retrieveHashtagInformationList(
            RetrieveBookClassificationRequestDto retrieveBookClassificationRequestDto) {

        return classificationQueryService.retrieveHashtagInformationList(retrieveBookClassificationRequestDto);
    }
}
