CREATE TABLE category_book_mapping (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '분류도서매핑아이디',
  category_id BIGINT COMMENT '카테고리아이디',
  book_id BIGINT COMMENT '도서',
) COMMENT '분류도서매핑';