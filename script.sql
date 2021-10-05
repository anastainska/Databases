-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kainska
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kainska
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kainska` DEFAULT CHARACTER SET utf8 ;
USE `kainska` ;

-- -----------------------------------------------------
-- Table `kainska`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `followers` INT(0) ZEROFILL NULL,
  `followings` INT(0) NULL,
  `description` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `mention` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_numpber_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`security` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  INDEX `fk_security_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_security_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `kainska`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kainska`.`story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reactions` VARCHAR(50) NULL,
  `new_story` VARCHAR(45) NULL,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_story_user1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_story_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `kainska`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `text` VARCHAR(200) NULL,
  `photo` VARCHAR(45) NOT NULL,
  `date_post` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `kainska`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`photo_post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`photo_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `photo_link` VARCHAR(45) NOT NULL,
  `post_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_post1_idx` (`post_id` ASC) VISIBLE,
  UNIQUE INDEX `photo_link_UNIQUE` (`photo_link` ASC) VISIBLE,
  CONSTRAINT `fk_photo_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text_message` VARCHAR(45) NULL,
  `time_creation` DATETIME NOT NULL,
  `time_seen` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `kainska`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`video_post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`video_post` (
  `idvideo` INT NOT NULL AUTO_INCREMENT,
  `video_link` VARCHAR(45) NULL,
  `post_id` INT NOT NULL,
  PRIMARY KEY (`idvideo`),
  INDEX `fk_video_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(50) NULL,
  `like_comment` INT NULL,
  `post_id` INT NOT NULL,
  `date_comment` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`like_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`like_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_like_comment_comment1_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_comment_comment1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `kainska`.`comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`like_post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`like_post` (
  `idlike_post` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `time_creation_like` DATETIME NOT NULL,
  PRIMARY KEY (`idlike_post`),
  INDEX `fk_like_post_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_post_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`video_story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`video_story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `story_id` INT NULL,
  `link_video_story` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_video_story_story1_idx` (`story_id` ASC) VISIBLE,
  UNIQUE INDEX `link_video_story_UNIQUE` (`link_video_story` ASC) VISIBLE,
  CONSTRAINT `fk_video_story_story1`
    FOREIGN KEY (`story_id`)
    REFERENCES `kainska`.`story` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`photo_story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kainska`.`photo_story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `story_id` INT NULL,
  `link_photo_story` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_story_story1_idx` (`story_id` ASC) VISIBLE,
  UNIQUE INDEX `link_photo_story_UNIQUE` (`link_photo_story` ASC) VISIBLE,
  CONSTRAINT `fk_photo_story_story1`
    FOREIGN KEY (`story_id`)
    REFERENCES `kainska`.`story` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
