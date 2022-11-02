CREATE TABLE products (
  id int NOT NULL AUTO_INCREMENT,
  code varchar(255) DEFAULT NULL,
  image varchar(255) DEFAULT NULL,
  price double(10,1) DEFAULT NULL,
  size int DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  variety varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);