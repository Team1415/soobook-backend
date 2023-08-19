package com.team1415.soobookbackend.hashtag.application;

import com.team1415.soobookbackend.hashtag.domain.port.HashtagQueryPort;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;
import com.team1415.soobookbackend.hashtag.dto.mapper.HashtagDtoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HashtagQueryService {

    private final HashtagQueryPort hashtagQueryPort;
    private final HashtagDtoMapper hashtagDtoMapper;

    public List<HashtagResponseDto> retrieveHashtagListOfCategory(Long categoryId) {

        return hashtagDtoMapper.fromDomainToResponse(hashtagQueryPort.retrieveHashtagListByCategoryId(categoryId));
    }
}
