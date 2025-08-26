package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookHashtagPersistenceEntity is a Querydsl query type for BookHashtagPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookHashtagPersistenceEntity extends EntityPathBase<BookHashtagPersistenceEntity> {

    private static final long serialVersionUID = 627861856L;

    public static final QBookHashtagPersistenceEntity bookHashtagPersistenceEntity = new QBookHashtagPersistenceEntity("bookHashtagPersistenceEntity");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final NumberPath<Long> hashtagId = createNumber("hashtagId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBookHashtagPersistenceEntity(String variable) {
        super(BookHashtagPersistenceEntity.class, forVariable(variable));
    }

    public QBookHashtagPersistenceEntity(Path<? extends BookHashtagPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookHashtagPersistenceEntity(PathMetadata metadata) {
        super(BookHashtagPersistenceEntity.class, metadata);
    }

}
