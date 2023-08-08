CREATE TABLE book_detail (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '책상세정보아이디',
  book_id BIGINT COMMENT '도서아이디',
  book_index TEXT COMMENT '도서목차',
  url VARCHAR(255) NOT NULL COMMENT '상세정보URL',
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '저자';