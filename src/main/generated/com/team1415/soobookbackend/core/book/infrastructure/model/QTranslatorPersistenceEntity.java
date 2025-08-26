package com.team1415.soobookbackend.core.book.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslatorPersistenceEntity is a Querydsl query type for TranslatorPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslatorPersistenceEntity extends EntityPathBase<TranslatorPersistenceEntity> {

    private static final long serialVersionUID = 448007143L;

    public static final QTranslatorPersistenceEntity translatorPersistenceEntity = new QTranslatorPersistenceEntity("translatorPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    public final SetPath<BookPersistenceEntity, QBookPersistenceEntity> bookPersistenceEntitySet = this.<BookPersistenceEntity, QBookPersistenceEntity>createSet("bookPersistenceEntitySet", BookPersistenceEntity.class, QBookPersistenceEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public QTranslatorPersistenceEntity(String variable) {
        super(TranslatorPersistenceEntity.class, forVariable(variable));
    }

    public QTranslatorPersistenceEntity(Path<? extends TranslatorPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTranslatorPersistenceEntity(PathMetadata metadata) {
        super(TranslatorPersistenceEntity.class, metadata);
    }

}
