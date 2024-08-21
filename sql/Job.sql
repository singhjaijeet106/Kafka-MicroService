CREATE TABLE IF NOT EXISTS `testing`.`job_tbl` (
  `id` VARCHAR(50) NOT NULL,
  `title` VARCHAR(100) NULL,
  `description` VARCHAR(500) NULL,
  `minSalary` INT NULL,
  `maxSalary` INT NULL,
  `location` VARCHAR(45) NULL,
  `companyId` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));