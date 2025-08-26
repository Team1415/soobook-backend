package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookPersistenceEntity is a Querydsl query type for BookPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookPersistenceEntity extends EntityPathBase<BookPersistenceEntity> {

    private static final long serialVersionUID = -2040123848L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookPersistenceEntity bookPersistenceEntity = new QBookPersistenceEntity("bookPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    public final SetPath<AuthorPersistenceEntity, QAuthorPersistenceEntity> authorPersistenceEntitySet = this.<AuthorPersistenceEntity, QAuthorPersistenceEntity>createSet("authorPersistenceEntitySet", AuthorPersistenceEntity.class, QAuthorPersistenceEntity.class, PathInits.DIRECT2);

    public final QBookPublishPersistenceEntity bookPublishPersistenceEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isbn10 = createString("isbn10");

    public final StringPath isbn13 = createString("isbn13");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath title = createString("title");

    public final SetPath<TranslatorPersistenceEntity, QTranslatorPersistenceEntity> translatorPersistenceEntitySet = this.<TranslatorPersistenceEntity, QTranslatorPersistenceEntity>createSet("translatorPersistenceEntitySet", TranslatorPersistenceEntity.class, QTranslatorPersistenceEntity.class, PathInits.DIRECT2);

    public QBookPersistenceEntity(String variable) {
        this(BookPersistenceEntity.class, forVariable(variable), INITS);
    }

    public QBookPersistenceEntity(Path<? extends BookPersistenceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookPersistenceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookPersistenceEntity(PathMetadata metadata, PathInits inits) {
        this(BookPersistenceEntity.class, metadata, inits);
    }

    public QBookPersistenceEntity(Class<? extends BookPersistenceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bookPublishPersistenceEntity = inits.isInitialized("bookPublishPersistenceEntity") ? new QBookPublishPersistenceEntity(forProperty("bookPublishPersistenceEntity")) : null;
    }

}
