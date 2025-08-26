package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookDetailPersistenceEntity is a Querydsl query type for BookDetailPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookDetailPersistenceEntity extends EntityPathBase<BookDetailPersistenceEntity> {

    private static final long serialVersionUID = 1480517991L;

    public static final QBookDetailPersistenceEntity bookDetailPersistenceEntity = new QBookDetailPersistenceEntity("bookDetailPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    public final StringPath bookDescription = createString("bookDescription");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final StringPath bookIndex = createString("bookIndex");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath source = createString("source");

    public final StringPath url = createString("url");

    public QBookDetailPersistenceEntity(String variable) {
        super(BookDetailPersistenceEntity.class, forVariable(variable));
    }

    public QBookDetailPersistenceEntity(Path<? extends BookDetailPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookDetailPersistenceEntity(PathMetadata metadata) {
        super(BookDetailPersistenceEntity.class, metadata);
    }

}
