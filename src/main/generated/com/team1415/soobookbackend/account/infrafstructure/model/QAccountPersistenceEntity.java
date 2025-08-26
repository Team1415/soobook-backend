package com.team1415.soobookbackend.account.infrafstructure.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountPersistenceEntity is a Querydsl query type for AccountPersistenceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountPersistenceEntity extends EntityPathBase<AccountPersistenceEntity> {

    private static final long serialVersionUID = 169008101L;

    public static final QAccountPersistenceEntity accountPersistenceEntity = new QAccountPersistenceEntity("accountPersistenceEntity");

    public final com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity _super = new com.team1415.soobookbackend.common.infrastructure.model.QBasePersistenceEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath displayName = createString("displayName");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath providerType = createString("providerType");

    public QAccountPersistenceEntity(String variable) {
        super(AccountPersistenceEntity.class, forVariable(variable));
    }

    public QAccountPersistenceEntity(Path<? extends AccountPersistenceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountPersistenceEntity(PathMetadata metadata) {
        super(AccountPersistenceEntity.class, metadata);
    }

}
