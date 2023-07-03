CREATE TABLE hashtag_book_mapping (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '해시태그도서매핑아이디',
  hashtag_id BIGINT COMMENT '해시태그아이디',
  book_id BIGINT COMMENT '도서',
) COMMENT '해시태그도서매핑';