package com.team1415.soobookbackend.query.controller;

import com.team1415.soobookbackend.query.application.service.BookInformationQuerySerivce;
import com.team1415.soobookbackend.query.dto.BookBriefInformationResponseDto;
import com.team1415.soobookbackend.query.dto.RetrieveBookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookInformationController {

    private final BookInformationQuerySerivce bookInformationQuerySerivce;

    @GetMapping("/books")
    public List<BookBriefInformationResponseDto> retrieveBookBriefInformationList(
            RetrieveBookRequestDto retrieveBookRequestDto) {
        return bookInformationQuerySerivce.retrieveBookBriefInformationList(retrieveBookRequestDto);
    }

}
