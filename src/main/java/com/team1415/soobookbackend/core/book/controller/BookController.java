package com.team1415.soobookbackend.core.book.controller;

import com.team1415.soobookbackend.core.book.application.BookCommandService;
import com.team1415.soobookbackend.core.book.application.BookQueryService;
import com.team1415.soobookbackend.core.book.dto.BookInformationResponseDto;
import com.team1415.soobookbackend.core.book.dto.SaveBookInformationRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookQueryService bookQueryService;
    private final BookCommandService bookCommandService;

    @PostMapping("/books")
    public List<BookInformationResponseDto> saveBookInformation(
            @RequestBody @Valid SaveBookInformationRequestDto saveBookInformationRequestDto) {
        return bookCommandService.saveBookInformationList(saveBookInformationRequestDto.getQueryList());
    }

    @PostMapping(value = "/books/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void saveBookInformationListByCsvFile(@RequestParam("file") MultipartFile file) {
        bookCommandService.saveBookInformationListByFile(file);
    }
}
