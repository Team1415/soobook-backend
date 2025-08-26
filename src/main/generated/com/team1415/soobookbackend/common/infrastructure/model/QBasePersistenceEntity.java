package com.team1415.soobookbackend.common.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasePersistenceEntity is a Querydsl query type for BasePersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBasePersistenceEntity extends EntityPathBase<BasePersistenceEntity> {

    private static final long serialVersionUID = -1917963701L;

    public static final QBasePersistenceEntity basePersistenceEntity = new QBasePersistenceEntity("basePersistenceEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public QBasePersistenceEntity(String variable) {
        super(BasePersistenceEntity.class, forVariable(variable));
    }

    public QBasePersistenceEntity(Path<? extends BasePersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasePersistenceEntity(PathMetadata metadata) {
        super(BasePersistenceEntity.class, metadata);
    }

}
