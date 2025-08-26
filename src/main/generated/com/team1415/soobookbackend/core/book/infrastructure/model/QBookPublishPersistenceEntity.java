package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookPublishPersistenceEntity is a Querydsl query type for BookPublishPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBookPublishPersistenceEntity extends BeanPath<BookPublishPersistenceEntity> {

    private static final long serialVersionUID = 1534318205L;

    public static final QBookPublishPersistenceEntity bookPublishPersistenceEntity = new QBookPublishPersistenceEntity("bookPublishPersistenceEntity");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final DateTimePath<java.time.LocalDateTime> publishDatetime = createDateTime("publishDatetime", java.time.LocalDateTime.class);

    public final StringPath publisher = createString("publisher");

    public final NumberPath<Long> salePrice = createNumber("salePrice", Long.class);

    public final StringPath status = createString("status");

    public final StringPath thumbnail = createString("thumbnail");

    public QBookPublishPersistenceEntity(String variable) {
        super(BookPublishPersistenceEntity.class, forVariable(variable));
    }

    public QBookPublishPersistenceEntity(Path<? extends BookPublishPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookPublishPersistenceEntity(PathMetadata metadata) {
        super(BookPublishPersistenceEntity.class, metadata);
    }

}
