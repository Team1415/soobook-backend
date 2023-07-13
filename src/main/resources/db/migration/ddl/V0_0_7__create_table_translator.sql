CREATE TABLE translator (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '역자아이디',
  name VARCHAR(255) NOT NULL COMMENT '역자명',
  introduction VARCHAR(255) NOT NULL COMMENT '역자소개',
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '역자';