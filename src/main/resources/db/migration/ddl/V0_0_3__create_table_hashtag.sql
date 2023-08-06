CREATE TABLE `hashtag` (
  id bigint AUTO_INCREMENT PRIMARY KEY COMMENT '해시태그아이디',
  name varchar(255) NOT NULL COMMENT '해시태그이름',
  category_id bigint COMMENT '카테고리아이디',
  UNIQUE KEY `hashtag_UN` (`name`,`category_id`),
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='해시태그';