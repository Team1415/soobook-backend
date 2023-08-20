package com.team1415.soobookbackend.core.hashtag.controller;

import com.team1415.soobookbackend.core.hashtag.application.HashtagQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HashtagController {

    private final HashtagQueryService hashtagQueryService;

}
