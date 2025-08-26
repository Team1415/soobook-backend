package com.team1415.soobookbackend.core.hashtag.dto.mapper;

import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.dto.HashtagResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagDtoMapper {

    List<HashtagResponseDto> fromDomainToResponse(List<Hashtag> hashtagList);
}
