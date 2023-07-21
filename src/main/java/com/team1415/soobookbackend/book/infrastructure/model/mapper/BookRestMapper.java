package com.team1415.soobookbackend.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.book.domain.*;
import com.team1415.soobookbackend.book.infrastructure.model.KakaoBookSearchApiResponse;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Stream;

@Mapper
public interface BookRestMapper {

    @Named("book")
    default Book toDomainRoot(KakaoBookSearchApiResponse kakaoBookSearchApiResponse) {
        return Book.create(
                kakaoBookSearchApiResponse.getIsbn(),
                kakaoBookSearchApiResponse.getTitle(),
                this.toValue(kakaoBookSearchApiResponse));
    }

    @Name("bookPublish")
    BookPublish toValue(KakaoBookSearchApiResponse kakaoBookSearchApiResponse);

    default BookInformation toDomain(KakaoBookSearchApiResponse kakaoBookSearchApiResponse) {
        Book book = this.toDomainRoot(kakaoBookSearchApiResponse);

        List<Author> authorList =
                Stream.of(kakaoBookSearchApiResponse.getAuthors())
                        .map(name -> Author.create(name, ""))
                        .toList();

        List<Translator> translatorList =
                Stream.of(kakaoBookSearchApiResponse.getTranslators())
                        .map(name -> Translator.create(name, ""))
                        .toList();

        return new BookInformation(book, authorList, translatorList);
    }
}
