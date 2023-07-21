CREATE TABLE book (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '도서아이디',
  isbn10 VARCHAR(10) NOT NULL COMMENT '국제표준도서번호10자리',
  isbn13 VARCHAR(13) NOT NULL COMMENT '국제표준도서번호13자리',
  title VARCHAR(255) NOT NULL COMMENT '도서명',
  publisher VARCHAR(255) NOT NULL COMMENT '출판사',
  price BIGINT COMMENT '도서정가',
  sale_price BIGINT COMMENT '도서판매가',
  status VARCHAR(255) NOT NULL COMMENT '도서판매상태정보',
  publish_datetime TIMESTAMP NOT NULL COMMENT '도서출판날짜(ISO8601)',
  thumbnail VARCHAR(255) NOT NULL COMMENT '썸네일이미지URL',
  created_by BIGINT NOT NULL COMMENT '생성자',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  created_at TIMESTAMP NOT NULL COMMENT '생성일시',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '도서';