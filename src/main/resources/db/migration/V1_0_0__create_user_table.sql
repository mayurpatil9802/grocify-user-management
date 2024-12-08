CREATE TABLE `grocify`.`user` (
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `mobile_no` VARCHAR(10) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(10) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `last_login` DATETIME NOT NULL,
  PRIMARY KEY (`email_id`));