-- 해시태그 테이블 DDL
CREATE TABLE hashtag (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '해시태그아이디',
  name VARCHAR(255) NOT NULL COMMENT '해시태그이름',
  book_id BIGINT NOT NULL COMMENT '책아이디'
) COMMENT '해시태그';