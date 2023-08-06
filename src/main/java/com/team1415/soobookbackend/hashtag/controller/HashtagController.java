package com.team1415.soobookbackend.hashtag.controller;

import com.team1415.soobookbackend.hashtag.application.HashtagQueryService;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HashtagController {

    private final HashtagQueryService hashtagQueryService;

    @GetMapping("/hashtags")
    public List<HashtagResponseDto> retrieveHashtagList() {
        return hashtagQueryService.retrieveHashtagList();
    }
}
