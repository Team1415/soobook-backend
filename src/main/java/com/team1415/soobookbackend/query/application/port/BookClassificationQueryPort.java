package com.team1415.soobookbackend.query.application.port;

import com.team1415.soobookbackend.common.annotation.Port;
import com.team1415.soobookbackend.query.dto.HashtagInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookClassificationRequestDto;

import java.util.List;

@Port
public interface BookClassificationQueryPort {

    List<HashtagInformationResponseDto> retrieveHashtagInformationList(
            RetrieveBookClassificationRequestDto bookClassificationRequestDto);
}
