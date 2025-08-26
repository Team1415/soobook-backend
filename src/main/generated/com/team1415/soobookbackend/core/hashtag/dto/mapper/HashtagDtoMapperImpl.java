package com.team1415.soobookbackend.core.hashtag.dto.mapper;

import com.team1415.soobookbackend.core.hashtag.domain.Hashtag;
import com.team1415.soobookbackend.core.hashtag.dto.HashtagResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class HashtagDtoMapperImpl implements HashtagDtoMapper {

    @Override
    public List<HashtagResponseDto> fromDomainToResponse(List<Hashtag> hashtagList) {
        if ( hashtagList == null ) {
            return null;
        }

        List<HashtagResponseDto> list = new ArrayList<HashtagResponseDto>( hashtagList.size() );
        for ( Hashtag hashtag : hashtagList ) {
            list.add( hashtagToHashtagResponseDto( hashtag ) );
        }

        return list;
    }

    protected HashtagResponseDto hashtagToHashtagResponseDto(Hashtag hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagResponseDto.HashtagResponseDtoBuilder hashtagResponseDto = HashtagResponseDto.builder();

        hashtagResponseDto.id( hashtag.getId() );
        hashtagResponseDto.name( hashtag.getName() );

        return hashtagResponseDto.build();
    }
}
