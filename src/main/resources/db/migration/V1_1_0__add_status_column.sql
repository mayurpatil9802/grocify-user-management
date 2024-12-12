ALTER TABLE `grocify`.`user` 
ADD COLUMN `status` BIT(1) NOT NULL DEFAULT 1 AFTER `last_login`;