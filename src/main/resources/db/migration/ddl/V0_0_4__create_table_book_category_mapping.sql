CREATE TABLE `book_category_mapping` (
  id bigint AUTO_INCREMENT PRIMARY KEY COMMENT '분류도서매핑아이디',
  book_id bigint COMMENT '도서아이디',
  category_id bigint COMMENT '카테고리아이디',
  UNIQUE KEY `category_book_mapping_UN` (`book_id`, `category_id`),
  INDEX book_id (book_id),
  INDEX category_id (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='분류도서매핑'