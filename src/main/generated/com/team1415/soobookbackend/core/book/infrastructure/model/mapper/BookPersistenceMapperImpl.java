package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Book;
import com.team1415.soobookbackend.core.book.domain.BookDetail;
import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.core.book.domain.BookPublish;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookDetailPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPersistenceEntity;
import com.team1415.soobookbackend.core.book.infrastructure.model.BookPublishPersistenceEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class BookPersistenceMapperImpl implements BookPersistenceMapper {

    @Autowired
    private AuthorPersistenceMapper authorPersistenceMapper;
    @Autowired
    private TranslatorPersistenceMapper translatorPersistenceMapper;

    @Override
    public Book fromEntityToDomainRoot(BookPersistenceEntity bookPersistenceEntity) {
        if ( bookPersistenceEntity == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.bookPublish( fromEntityToValue( bookPersistenceEntity.getBookPublishPersistenceEntity() ) );
        book.id( bookPersistenceEntity.getId() );
        book.isbn10( bookPersistenceEntity.getIsbn10() );
        book.isbn13( bookPersistenceEntity.getIsbn13() );
        book.title( bookPersistenceEntity.getTitle() );

        return book.build();
    }

    @Override
    public BookPublish fromEntityToValue(BookPublishPersistenceEntity bookPublishPersistenceEntity) {
        if ( bookPublishPersistenceEntity == null ) {
            return null;
        }

        String publisher = null;
        Long price = null;
        Long salePrice = null;
        String status = null;
        LocalDateTime publishDatetime = null;
        String thumbnail = null;

        publisher = bookPublishPersistenceEntity.getPublisher();
        price = bookPublishPersistenceEntity.getPrice();
        salePrice = bookPublishPersistenceEntity.getSalePrice();
        status = bookPublishPersistenceEntity.getStatus();
        publishDatetime = bookPublishPersistenceEntity.getPublishDatetime();
        thumbnail = bookPublishPersistenceEntity.getThumbnail();

        BookPublish bookPublish = new BookPublish( publisher, price, salePrice, status, publishDatetime, thumbnail );

        return bookPublish;
    }

    @Override
    public BookInformation fromEntityToDomain(BookPersistenceEntity bookPersistenceEntity) {
        if ( bookPersistenceEntity == null ) {
            return null;
        }

        BookInformation.BookInformationBuilder bookInformation = BookInformation.builder();

        bookInformation.book( fromEntityToDomainRoot( bookPersistenceEntity ) );
        bookInformation.authorList( authorPersistenceMapper.fromEntitysToDomains( bookPersistenceEntity.getAuthorPersistenceEntitySet() ) );
        bookInformation.translatorList( translatorPersistenceMapper.fromEntitysToDomains( bookPersistenceEntity.getTranslatorPersistenceEntitySet() ) );

        return bookInformation.build();
    }

    @Override
    public BookDetail fromEntityToDomainDetail(BookDetailPersistenceEntity bookDetailPersistenceEntity) {
        if ( bookDetailPersistenceEntity == null ) {
            return null;
        }

        BookDetail.BookDetailBuilder bookDetail = BookDetail.builder();

        bookDetail.id( bookDetailPersistenceEntity.getId() );
        bookDetail.bookId( bookDetailPersistenceEntity.getBookId() );
        bookDetail.source( bookDetailPersistenceEntity.getSource() );
        bookDetail.url( bookDetailPersistenceEntity.getUrl() );
        bookDetail.bookIndex( bookDetailPersistenceEntity.getBookIndex() );
        bookDetail.bookDescription( bookDetailPersistenceEntity.getBookDescription() );

        return bookDetail.build();
    }

    @Override
    public List<Book> fromEntitysToDomainRoots(List<BookPersistenceEntity> bookPersistenceEntityList) {
        if ( bookPersistenceEntityList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( bookPersistenceEntityList.size() );
        for ( BookPersistenceEntity bookPersistenceEntity : bookPersistenceEntityList ) {
            list.add( fromEntityToDomainRoot( bookPersistenceEntity ) );
        }

        return list;
    }

    @Override
    public List<BookInformation> fromEntitysToDomains(List<BookPersistenceEntity> bookPersistenceEntityList) {
        if ( bookPersistenceEntityList == null ) {
            return null;
        }

        List<BookInformation> list = new ArrayList<BookInformation>( bookPersistenceEntityList.size() );
        for ( BookPersistenceEntity bookPersistenceEntity : bookPersistenceEntityList ) {
            list.add( fromEntityToDomain( bookPersistenceEntity ) );
        }

        return list;
    }
}
