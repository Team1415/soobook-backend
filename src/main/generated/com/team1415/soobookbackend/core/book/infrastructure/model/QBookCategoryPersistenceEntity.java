package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookCategoryPersistenceEntity is a Querydsl query type for BookCategoryPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookCategoryPersistenceEntity extends EntityPathBase<BookCategoryPersistenceEntity> {

    private static final long serialVersionUID = 414996186L;

    public static final QBookCategoryPersistenceEntity bookCategoryPersistenceEntity = new QBookCategoryPersistenceEntity("bookCategoryPersistenceEntity");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBookCategoryPersistenceEntity(String variable) {
        super(BookCategoryPersistenceEntity.class, forVariable(variable));
    }

    public QBookCategoryPersistenceEntity(Path<? extends BookCategoryPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookCategoryPersistenceEntity(PathMetadata metadata) {
        super(BookCategoryPersistenceEntity.class, metadata);
    }

}
