CREATE TABLE category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '카테고리아이디',
  name VARCHAR(255) NOT NULL COMMENT '카테고리이름',
  UNIQUE KEY `category_UN` (`name`),
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '카테고리';
