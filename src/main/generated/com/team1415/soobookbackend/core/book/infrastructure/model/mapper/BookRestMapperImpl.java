package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.BookPublish;
import com.team1415.soobookbackend.core.book.infrastructure.model.KakaoBookSearchApiResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-25T07:42:53+0000",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.9.jar, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class BookRestMapperImpl implements BookRestMapper {

    @Override
    public BookPublish toValue(KakaoBookSearchApiResponse.Document document) {
        if ( document == null ) {
            return null;
        }

        String publisher = null;
        Long price = null;
        Long salePrice = null;
        String status = null;
        LocalDateTime publishDatetime = null;
        String thumbnail = null;

        publisher = document.getPublisher();
        if ( document.getPrice() != null ) {
            price = document.getPrice().longValue();
        }
        if ( document.getSalePrice() != null ) {
            salePrice = document.getSalePrice().longValue();
        }
        status = document.getStatus();
        publishDatetime = document.getPublishDatetime();
        thumbnail = document.getThumbnail();

        BookPublish bookPublish = new BookPublish( publisher, price, salePrice, status, publishDatetime, thumbnail );

        return bookPublish;
    }
}
