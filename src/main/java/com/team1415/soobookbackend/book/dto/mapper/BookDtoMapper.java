package com.team1415.soobookbackend.book.dto.mapper;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface BookDtoMapper {

    List<BookResponseDto> fromDomainToResponse(List<Book> bookList);
}
