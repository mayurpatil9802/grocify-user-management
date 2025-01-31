CREATE TABLE `grocify`.`grocery_store` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(50) NULL,
  `address` VARCHAR(50) NULL,
  `gst_no` VARCHAR(20) NOT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_id` VARCHAR(30) NULL,
  `description` VARCHAR(100) NULL,
  `status` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `gst_no_UNIQUE` (`gst_no` ASC) VISIBLE);
