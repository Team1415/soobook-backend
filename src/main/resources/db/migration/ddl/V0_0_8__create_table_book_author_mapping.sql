CREATE TABLE `book_author_mapping` (
  id bigint AUTO_INCREMENT PRIMARY KEY COMMENT '저자도서매핑아이디',
  book_id bigint COMMENT '도서아이디',
  author_id bigint COMMENT '저자아이디',
  UNIQUE KEY `book_author_mapping_UN` (`book_id`,`author_id`),
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='도서저자매핑'