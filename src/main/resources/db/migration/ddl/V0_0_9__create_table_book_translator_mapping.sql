CREATE TABLE `book_translator_mapping` (
  id bigint AUTO_INCREMENT PRIMARY KEY COMMENT '역자도서매핑아이디',
  book_id bigint COMMENT '도서아이디',
  translator_id bigint COMMENT '역자아이디',
  UNIQUE KEY `book_translator_mapping_UN` (`book_id`,`translator_id`),
  created_by BIGINT NOT NULL COMMENT '생성자',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='도서역자매핑'