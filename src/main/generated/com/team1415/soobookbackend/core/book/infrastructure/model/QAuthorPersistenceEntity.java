package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthorPersistenceEntity is a Querydsl query type for AuthorPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthorPersistenceEntity extends EntityPathBase<AuthorPersistenceEntity> {

    private static final long serialVersionUID = -1298306026L;

    public static final QAuthorPersistenceEntity authorPersistenceEntity = new QAuthorPersistenceEntity("authorPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    public final SetPath<BookPersistenceEntity, QBookPersistenceEntity> bookPersistenceEntitySet = this.<BookPersistenceEntity, QBookPersistenceEntity>createSet("bookPersistenceEntitySet", BookPersistenceEntity.class, QBookPersistenceEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public QAuthorPersistenceEntity(String variable) {
        super(AuthorPersistenceEntity.class, forVariable(variable));
    }

    public QAuthorPersistenceEntity(Path<? extends AuthorPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthorPersistenceEntity(PathMetadata metadata) {
        super(AuthorPersistenceEntity.class, metadata);
    }

}
