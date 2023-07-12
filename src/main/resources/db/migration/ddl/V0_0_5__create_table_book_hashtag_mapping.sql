CREATE TABLE `book_hashtag_mapping` (
  id bigint AUTO_INCREMENT PRIMARY KEY COMMENT '해시태그도서매핑아이디',
  book_id bigint COMMENT '도서아이디',
  hashtag_id bigint COMMENT '해시태그아이디',
  UNIQUE KEY `hashtag_book_mapping_UN` (`book_id`, `hashtag_id`),
  created_by BIGINT NOT NULL COMMENT '생성자',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='해시태그도서매핑';