CREATE TABLE book (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '도서아이디',
  isbn10 VARCHAR(255) NOT NULL COMMENT '국제표준도서번호10자리',
  isbn13 VARCHAR(255) NOT NULL COMMENT '국제표준도서번호13자리',
  title VARCHAR(255) NOT NULL COMMENT '도서명'
) COMMENT '도서';