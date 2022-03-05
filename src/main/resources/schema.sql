CREATE TABLE Usuario (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  user_name VARCHAR(500) NOT NULL,
  email VARCHAR(500) NOT NULL,
  phone VARCHAR(150) NOT NULL,
  enabled bit NOT NULL default 0,
  creation_date datetime NOT NULL,
  created_by VARCHAR(120) NULL,
  update_date datetime NULL,
  updated_by VARCHAR(120) NULL
);

