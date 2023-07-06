CREATE TABLE `category_book_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '분류도서매핑아이디',
  `category_id` bigint DEFAULT NULL COMMENT '카테고리아이디',
  `book_id` bigint DEFAULT NULL COMMENT '도서',
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_book_mapping_UN` (`category_id`,`book_id`),
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='분류도서매핑'