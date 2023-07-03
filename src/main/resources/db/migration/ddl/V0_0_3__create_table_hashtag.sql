CREATE TABLE hashtag (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '해시태그아이디',
  name VARCHAR(255) NOT NULL COMMENT '해시태그이름',
  category_id BIGINT COMMENT '카테고리아이디'
) COMMENT '해시태그';