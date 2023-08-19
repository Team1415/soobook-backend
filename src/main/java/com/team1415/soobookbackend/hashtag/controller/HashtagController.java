package com.team1415.soobookbackend.hashtag.controller;

import com.team1415.soobookbackend.hashtag.application.HashtagQueryService;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;

import java.util.ArrayList;
import java.util.List;

import com.team1415.soobookbackend.hashtag.dto.RetrieveHashtagRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HashtagController {

    private final HashtagQueryService hashtagQueryService;

    @GetMapping("/hashtags")
    public List<HashtagResponseDto> retrieveHashtagList(@ModelAttribute RetrieveHashtagRequestDto hashtagRequestDto) {
        if (ObjectUtils.isNotEmpty(hashtagRequestDto.getCategoryId())) {
            return hashtagQueryService.retrieveHashtagListOfCategory(hashtagRequestDto.getCategoryId());
        }
        return new ArrayList<>();
    }
}
