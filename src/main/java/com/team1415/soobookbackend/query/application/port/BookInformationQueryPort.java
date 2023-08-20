package com.team1415.soobookbackend.query.application.port;

import com.team1415.soobookbackend.common.annotation.Port;
import com.team1415.soobookbackend.query.dto.BookBriefInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookRequestDto;

import java.util.List;

@Port
public interface BookInformationQueryPort {

    List<BookBriefInformationResponseDto> retrieveBookBriefInformationList(RetrieveBookRequestDto retrieveBookRequestDto);
}
