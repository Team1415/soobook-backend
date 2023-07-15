package com.team1415.soobookbackend.book.controller;

import com.team1415.soobookbackend.book.application.BookQueryService;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookQueryService bookQueryService;

    @GetMapping("/books/newest")
    public List<BookResponseDto> retrieveNewestBookList() {
        return bookQueryService.retrieveNewestBookList();
    }
}
