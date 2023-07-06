CREATE TABLE `hashtag_book_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '해시태그도서매핑아이디',
  `hashtag_id` bigint DEFAULT NULL COMMENT '해시태그아이디',
  `book_id` bigint DEFAULT NULL COMMENT '도서',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hashtag_book_mapping_UN` (`hashtag_id`,`book_id`),
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='해시태그도서매핑';