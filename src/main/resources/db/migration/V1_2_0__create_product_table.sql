CREATE TABLE `grocify`.`product_detail` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  `price` INT NULL,
  `unit` VARCHAR(10) NULL,
  `available_unit` INT NULL,
  `store_id` INT NULL,
  `metadata` JSON NULL,
  `product_image` VARCHAR(200) NULL,
  `status` BIT NULL DEFAULT 1,
  PRIMARY KEY (`id`));