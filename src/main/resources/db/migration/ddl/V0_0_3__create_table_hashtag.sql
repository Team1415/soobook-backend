CREATE TABLE `hashtag` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '해시태그아이디',
  `name` varchar(255) NOT NULL COMMENT '해시태그이름',
  `category_id` bigint DEFAULT NULL COMMENT '카테고리아이디',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hashtag_UN` (`name`,`category_id`),
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='해시태그';