package com.team1415.soobookbackend.hashtag.dto.mapper;

import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagDtoMapper {

    List<HashtagResponseDto> fromDomainToDto(List<Hashtag> hashtagList);
}
