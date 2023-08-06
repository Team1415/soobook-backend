package com.team1415.soobookbackend.book.controller;

import com.team1415.soobookbackend.book.application.BookCommandService;
import com.team1415.soobookbackend.book.application.BookQueryService;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import com.team1415.soobookbackend.book.dto.SaveBookInformationRequestDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookQueryService bookQueryService;
    private final BookCommandService bookCommandService;

    @GetMapping("/books/newest")
    public List<BookResponseDto> retrieveNewestBookList() {
        return bookQueryService.retrieveNewestBookList();
    }

    @PostMapping("/books")
    public void saveBookInformation(
            @RequestBody @Valid SaveBookInformationRequestDto saveBookInformationRequestDto) {
        bookCommandService.saveBookInformationList(saveBookInformationRequestDto.getQueryList());
    }
}
