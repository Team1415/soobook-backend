CREATE TABLE `account`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT COMMENT 'account id',
    `provider_type` VARCHAR(255) NOT NULL COMMENT 'provider type',
    `email`         VARCHAR(255) NOT NULL COMMENT 'email',
    `display_name`  VARCHAR(255) NOT NULL COMMENT 'display name',
    `first_name`    VARCHAR(255) NOT NULL COMMENT 'first name',
    `last_name`     VARCHAR(255) NOT NULL COMMENT 'last name',
    PRIMARY KEY (`id`),
    created_at      TIMESTAMP    NOT NULL COMMENT '작성일시',
    modified_at     TIMESTAMP    NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='account';