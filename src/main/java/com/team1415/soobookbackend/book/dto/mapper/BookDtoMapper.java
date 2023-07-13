package com.team1415.soobookbackend.book.dto.mapper;

import com.team1415.soobookbackend.book.domain.Book;
import com.team1415.soobookbackend.book.domain.BookPublish;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface BookDtoMapper {

    @Named(value = "bookResponse")
    default BookResponseDto fromDomainRootToResponse(Book book) {
        return this.fromDomainRootToResponse(book, book.getBookPublish());
    }

    BookResponseDto fromDomainRootToResponse(Book book, BookPublish bookPublish);

    @IterableMapping(qualifiedByName = { "bookResponse" })
    List<BookResponseDto> fromDomainRootsToResponses(List<Book> bookInformationList);
}
