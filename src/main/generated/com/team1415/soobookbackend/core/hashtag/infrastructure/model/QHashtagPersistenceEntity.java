package com.team1415.soobookbackend.core.hashtag.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHashtagPersistenceEntity is a Querydsl query type for HashtagPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHashtagPersistenceEntity extends EntityPathBase<HashtagPersistenceEntity> {

    private static final long serialVersionUID = 329953614L;

    public static final QHashtagPersistenceEntity hashtagPersistenceEntity = new QHashtagPersistenceEntity("hashtagPersistenceEntity");

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QHashtagPersistenceEntity(String variable) {
        super(HashtagPersistenceEntity.class, forVariable(variable));
    }

    public QHashtagPersistenceEntity(Path<? extends HashtagPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHashtagPersistenceEntity(PathMetadata metadata) {
        super(HashtagPersistenceEntity.class, metadata);
    }

}
