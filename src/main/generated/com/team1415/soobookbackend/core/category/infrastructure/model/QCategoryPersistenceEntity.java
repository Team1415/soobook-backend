package com.team1415.soobookbackend.core.category.infrastructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCategoryPersistenceEntity is a Querydsl query type for CategoryPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategoryPersistenceEntity extends EntityPathBase<CategoryPersistenceEntity> {

    private static final long serialVersionUID = 1813852558L;

    public static final QCategoryPersistenceEntity categoryPersistenceEntity = new QCategoryPersistenceEntity("categoryPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public QCategoryPersistenceEntity(String variable) {
        super(CategoryPersistenceEntity.class, forVariable(variable));
    }

    public QCategoryPersistenceEntity(Path<? extends CategoryPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryPersistenceEntity(PathMetadata metadata) {
        super(CategoryPersistenceEntity.class, metadata);
    }

}
