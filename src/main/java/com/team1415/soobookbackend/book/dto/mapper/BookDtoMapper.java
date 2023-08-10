package com.team1415.soobookbackend.book.dto.mapper;

import com.team1415.soobookbackend.book.domain.*;
import com.team1415.soobookbackend.book.dto.BookInformationResponseDto;
import com.team1415.soobookbackend.book.dto.BookResponseDto;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface BookDtoMapper {

    @Named(value = "bookResponse")
    default BookResponseDto fromDomainRootToResponse(Book book) {
        return this.fromDomainRootToResponse(book, book.getBookPublish());
    }

    BookResponseDto fromDomainRootToResponse(Book book, BookPublish bookPublish);

    @IterableMapping(qualifiedByName = {"bookResponse"})
    List<BookResponseDto> fromDomainRootsToResponses(List<Book> bookList);

    @Named(value = "bookInformationResponse")
    default BookInformationResponseDto fromDomainToResponse(BookInformation bookInformation) {
        return this.fromDomainToResponse(bookInformation.getBook(), bookInformation.getBook().getBookPublish(),
                bookInformation.getAuthorList().stream().map(Author::getName).toList(),
                bookInformation.getTranslatorList().stream().map(Translator::getName).toList());
    }

    BookInformationResponseDto fromDomainToResponse(Book book, BookPublish bookPublish,
                                                    List<String> authorList, List<String> translatorList);

    @IterableMapping(qualifiedByName = {"bookInformationResponse"})
    List<BookInformationResponseDto> fromDomainsToResponses(List<BookInformation> bookInformationList);
}
