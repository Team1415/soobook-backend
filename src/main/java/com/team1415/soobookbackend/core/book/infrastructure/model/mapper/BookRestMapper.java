package com.team1415.soobookbackend.core.book.infrastructure.model.mapper;

import com.team1415.soobookbackend.core.book.domain.Author;
import com.team1415.soobookbackend.core.book.domain.Book;
import com.team1415.soobookbackend.core.book.domain.BookInformation;
import com.team1415.soobookbackend.core.book.domain.BookPublish;
import com.team1415.soobookbackend.core.book.domain.Translator;
import com.team1415.soobookbackend.core.book.infrastructure.model.KakaoBookSearchApiResponse.Document;
import java.util.List;
import java.util.stream.Stream;

import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface BookRestMapper {

    @Named("book")
    default Book toDomainRoot(Document document) {
        return Book.create(document.getIsbn(), document.getTitle(), this.toValue(document));
    }

    @Name("bookPublish")
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
