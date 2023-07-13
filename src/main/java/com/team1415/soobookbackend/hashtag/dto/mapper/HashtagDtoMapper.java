package com.team1415.soobookbackend.hashtag.dto.mapper;

import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HashtagDtoMapper {

    List<HashtagResponseDto> fromDomainToResponse(List<Hashtag> hashtagList);
}
