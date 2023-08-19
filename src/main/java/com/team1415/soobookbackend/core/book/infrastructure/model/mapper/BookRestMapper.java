package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.*;
import com.team1415.soobookbackend.core.book.infrastructure.model.KakaoBookSearchApiResponse.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface BookRestMapper {

    @Named("book")
    default Book toDomainRoot(Document document) {
        return Book.create(document.getIsbn(), document.getTitle(), this.toValue(document));
    }

    @Named("bookPublish")
    BookPublish toValue(Document document);

    default BookInformation toDomain(Document document) {
        Book book = this.toDomainRoot(document);

        List<Author> authorList =
                Stream.of(document.getAuthors()).map(name -> Author.create(name, "")).toList();

        List<Translator> translatorList =
                Stream.of(document.getTranslators())
                        .map(name -> Translator.create(name, ""))
                        .toList();

        return new BookInformation(book, authorList, translatorList);
    }

    default List<BookInformation> toDomainList(List<Document> documentList) {
        return documentList.stream().map(this::toDomain).toList();
    }
}
