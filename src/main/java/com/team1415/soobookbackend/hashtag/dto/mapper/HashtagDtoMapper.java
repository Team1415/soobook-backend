package com.team1415.soobookbackend.hashtag.dto.mapper;

import com.team1415.soobookbackend.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.hashtag.dto.HashtagResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface HashtagDtoMapper {

    List<HashtagResponseDto> fromDomainToResponse(List<Hashtag> hashtagList);
}
