CREATE TABLE category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '카테고리아이디',
  name VARCHAR(255) NOT NULL COMMENT '카테고리이름',
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '카테고리';

ALTER TABLE `soobook-database`.category ADD CONSTRAINT category_UN UNIQUE KEY (name);
