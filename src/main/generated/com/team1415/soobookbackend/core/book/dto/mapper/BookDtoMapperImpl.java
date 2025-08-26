package com.team1415.soobookbackend.core.book.dto.mapper;

import com.team1415.soobookbackend.core.book.domain.Book;
import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.core.book.domain.BookPublish;
import com.team1415.soobookbackend.core.book.dto.BookInformationResponseDto;
import com.team1415.soobookbackend.core.book.dto.BookResponseDto;
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
public class BookDtoMapperImpl implements BookDtoMapper {

    @Override
    public BookResponseDto fromDomainRootToResponse(Book book, BookPublish bookPublish) {
        if ( book == null && bookPublish == null ) {
            return null;
        }

        BookResponseDto.BookResponseDtoBuilder bookResponseDto = BookResponseDto.builder();

        if ( book != null ) {
            bookResponseDto.id( book.getId() );
            bookResponseDto.isbn10( book.getIsbn10() );
            bookResponseDto.isbn13( book.getIsbn13() );
            bookResponseDto.title( book.getTitle() );
        }
        if ( bookPublish != null ) {
            bookResponseDto.publisher( bookPublish.publisher() );
            bookResponseDto.price( bookPublish.price() );
            bookResponseDto.salePrice( bookPublish.salePrice() );
            bookResponseDto.status( bookPublish.status() );
            bookResponseDto.publishDatetime( bookPublish.publishDatetime() );
            bookResponseDto.thumbnail( bookPublish.thumbnail() );
        }

        return bookResponseDto.build();
    }

    @Override
    public List<BookResponseDto> fromDomainRootsToResponses(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookResponseDto> list = new ArrayList<BookResponseDto>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( fromDomainRootToResponse( book ) );
        }

        return list;
    }

    @Override
    public BookInformationResponseDto fromDomainToResponse(Book book, BookPublish bookPublish, List<String> authorList, List<String> translatorList) {
        if ( book == null && bookPublish == null && authorList == null && translatorList == null ) {
            return null;
        }

        BookInformationResponseDto.BookInformationResponseDtoBuilder bookInformationResponseDto = BookInformationResponseDto.builder();

        if ( book != null ) {
            bookInformationResponseDto.id( book.getId() );
            bookInformationResponseDto.isbn10( book.getIsbn10() );
            bookInformationResponseDto.isbn13( book.getIsbn13() );
            bookInformationResponseDto.title( book.getTitle() );
        }
        if ( bookPublish != null ) {
            bookInformationResponseDto.publisher( bookPublish.publisher() );
            bookInformationResponseDto.price( bookPublish.price() );
            bookInformationResponseDto.salePrice( bookPublish.salePrice() );
            bookInformationResponseDto.status( bookPublish.status() );
            bookInformationResponseDto.publishDatetime( bookPublish.publishDatetime() );
            bookInformationResponseDto.thumbnail( bookPublish.thumbnail() );
        }
        List<String> list = authorList;
        if ( list != null ) {
            bookInformationResponseDto.authorList( new ArrayList<String>( list ) );
        }
        List<String> list1 = translatorList;
        if ( list1 != null ) {
            bookInformationResponseDto.translatorList( new ArrayList<String>( list1 ) );
        }

        return bookInformationResponseDto.build();
    }

    @Override
    public List<BookInformationResponseDto> fromDomainsToResponses(List<BookInformation> bookInformationList) {
        if ( bookInformationList == null ) {
            return null;
        }

        List<BookInformationResponseDto> list = new ArrayList<BookInformationResponseDto>( bookInformationList.size() );
        for ( BookInformation bookInformation : bookInformationList ) {
            list.add( fromDomainToResponse( bookInformation ) );
        }

        return list;
    }
}
