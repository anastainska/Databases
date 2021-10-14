CREATE SCHEMA IF NOT EXISTS `kainska` DEFAULT CHARACTER SET utf8 ;
USE `kainska` ;

-- -----------------------------------------------------
-- Table `kainska`.`user`
-- -----------------------------------------------------
DROP TABLE user;
CREATE TABLE IF NOT EXISTS `kainska`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `followers` INT NULL,
  `followings` INT NULL,
  `description` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `mention` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `email_idx` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_numpber_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`security`
-- -----------------------------------------------------
DROP TABLE security;
CREATE TABLE IF NOT EXISTS `kainska`.`security` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  INDEX `fk_security_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_security_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `kainska`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`story`
-- -----------------------------------------------------
DROP TABLE story;
CREATE TABLE IF NOT EXISTS `kainska`.`story` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reactions` VARCHAR(50) NULL,
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
DROP TABLE IF EXISTS post;
CREATE TABLE IF NOT EXISTS `kainska`.`post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `text` VARCHAR(200) NULL,
  `photo` BLOB(100) NOT NULL,
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
-- Table `kainska`.`photo`
-- -----------------------------------------------------
DROP TABLE photo;
CREATE TABLE IF NOT EXISTS `kainska`.`photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `photo` BLOB(100) NOT NULL,
  `post_id` INT NOT NULL,
  `story_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_photo_story1_idx` (`story_id` ASC) VISIBLE,
  CONSTRAINT `fk_photo_post1_constr`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_photo_story1_constr`
    FOREIGN KEY (`story_id`)
    REFERENCES `kainska`.`story` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`message`
-- -----------------------------------------------------
DROP TABLE message;
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
-- Table `kainska`.`video`
-- -----------------------------------------------------
DROP TABLE video;
CREATE TABLE IF NOT EXISTS `kainska`.`video` (
  `idvideo` INT NOT NULL AUTO_INCREMENT,
  `video` BLOB(100) NULL,
  `post_id` INT NOT NULL,
  `story_id` INT NOT NULL,
  PRIMARY KEY (`idvideo`),
  INDEX `fk_video_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_video_story1_idx` (`story_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_post1_constr`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_video_story1_constr`
    FOREIGN KEY (`story_id`)
    REFERENCES `kainska`.`story` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`comment`
-- -----------------------------------------------------
DROP TABLE comment;
CREATE TABLE IF NOT EXISTS `kainska`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(50) NULL,
  `like_comment` INT NULL,
  `post_id` INT NOT NULL,
  `date_comment` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `post_id` (`post_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `kainska`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kainska`.`like_comment`
-- -----------------------------------------------------
DROP TABLE like_comment;
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
DROP TABLE like_post;
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
 

INSERT INTO user (followers, followings, description, email, phone_number, mention) VALUES
(1134, 3459, "im nastya", "anastasia.kajinska@gmail.com", "+38082344925", "hello @anastainska"),
(114, 3419, "im oleg", "oleg@gmail.com", "+38082784925", "haha look @denys"),
(987, 163, "comedian", "olena@gmail.com", "+38082349938", "@olena haha"),
(11, 98, "i like dogs", "dogslover@gmail.com", "+380987625", "look they are so cute @dogslover"),
(92, 32345, "baby queen", "sasha@gmail.com", "+38082312355", "lol haha @sasha"),
(936, 349, "hello there", "123@gmail.com", "+380823449251", "@povelitel99"),
(0, 0, "lol", "mygmail@gmail.com", "+38082347385", "@333 hi"),
(1, 3, "...", "imnothere@gmail.com", "+38082341125", "@lol hiii"),
(113, 93284, "hahaha", "dzidzo@gmail.com", "+380823449259", "@dzidzo i love you"),
(134, 359, "stepan giga", "stepan.giga@gmail.com", "+38022222222", "@stepangiga im your biggest fan");

SELECT * FROM kainska.security;
INSERT INTO security (nickname, password, user_id) VALUES
("anastainska", "123baby", 1),
("oleg", "olegparol", 2),
("olenababy", "mypassword", 3),
("cheloveck", "password", 4),
("sashathebest", "passwordofsasha", 5),
("table", "miyparol", 6),
("kvitochka", "haha321", 7),
("sonechko", "yasonechkp", 8),
("dzidzo", "dzidzothebest", 9),
("stepangiga", "ilovepizza", 10);

SELECT * FROM kainska.story;
INSERT INTO story (reactions, user_iduser) VALUES
("wow", 1),
("nice", 2),
("cool", 3),
("you look good", 4),
("hooray", 5),
("hahaha thats funny", 6),
("lol", 7),
("ahhaahahah", 8),
("super", 9),
("youre so beautiful", 10);

SELECT * FROM kainska.post;
INSERT INTO post (user_id, text, photo, date_post) VALUES
(1, "thats me", "sdlfkvnsl", "2010-10-01 13:10:00.000"),
(2, "my dog", "sdlfkvl", "2012-10-02 11:00:00.000"),
(3, "i love this weather", "sdllkndgfssl", "2019-10-03 10:00:00.000"),
(4, "i love my friends", "sddfmg ", "2009-10-04 19:10:00.000"),
(5, "haha", "sdlfkng", "2016-10-05 18:00:00.000"),
(6, "my fav meme", "swerinwl", "2013-10-06 16:01:00.000"),
(7, "thats my baby", "wpnglk", "2015-10-07 15:10:10.000"),
(8, "i love him sm", "sdlwenls", "2018-11-08 09:00:00.000"),
(9, "like this book", "sdlxcvb ", "2012-10-09 22:00:00.000"),
(10, "im so tired", "sdl;ewk;nff", "2006-10-10 20:00:00.000");

SELECT * FROM kainska.photo;
INSERT INTO photo (photo, post_id, story_id) VALUES
("sldnsl", 1, 1),
("wekfbjwl", 2, 2),
("sldnssldns", 3, 3),
("alknsfvl", 4, 4),
("alnks", 5, 5),
("sd;k;vns", 6, 6),
("slkvnl", 7, 7),
("avlaslk", 8, 8),
("sqwork", 9, 9),
("x,cvm ,", 10, 10);

SELECT * FROM kainska.message;
INSERT INTO message (text_message, time_creation, time_seen, user_id) VALUES
("hello", "2019-11-10 13:00:00.000", "2019-11-11 14:00:00.000", 1),
("hi", "2017-11-10 13:00:00.000", "2019-11-11 14:19:00.000", 2),
("hey", "2010-11-10 13:00:00.000", "2010-12-11 14:00:00.000", 3),
("hey how are you", "2021-09-10 13:00:00.000", "2021-09-11 14:00:00.000", 4),
("wassup", "2011-11-10 13:00:00.000", "2011-11-11 14:00:00.000", 5),
("are you okay?", "2013-11-10 13:00:00.000", "2014-11-11 14:00:00.000", 6),
("lets see each other", "2012-11-10 13:00:00.000", "2012-11-13 10:00:00.000", 7),
("lol hi", "2011-11-14 13:00:00.000", "2019-11-14 17:10:09.000", 8),
("hello friend", "2017-11-10 13:00:00.000", "2017-11-11 14:00:00.000", 9),
("hi baby", "2018-11-10 13:00:00.000", "2018-11-11 14:00:00.000", 10);

SELECT * FROM kainska.video;
INSERT INTO video (video, post_id, story_id) VALUES
("skdjs", 1, 1),
("sglnls", 2, 2),
("weurewrio", 3, 3),
("sn xcv n", 4, 4),
("q;wlwf", 5, 5),
("df;l;", 6, 6),
("qwkhbef", 7, 7),
("sdlfvlfs", 8, 8),
("ssldnls", 9, 9),
("lqekfnklds", 10, 10);

SELECT * FROM kainska.comment;
INSERT INTO comment (text, like_comment, post_id, date_comment) VALUES
("look nice", 1, 1, "2019-12-10 13:03:10.000"),
("thats good", 5, 2, "2019-12-10 13:53:00.000"),
("yaaas queen", 10, 3, "2019-12-10 17:03:00.000"),
("lol", 2, 4, "2019-12-10 10:03:00.000"),
("hey you look good", 9, 5, "2019-12-10 12:03:00.000"),
("wow queen", 1, 6, "2019-12-10 19:03:00.000"),
("thats my girl", 6, 7, "2018-12-10 13:03:00.000"),
("will you be my sugar baby", 18, 8, "2009-12-10 13:03:00.000"),
("marry me", 19, 9, "2019-10-10 13:03:00.000"),
("that looks awful", 20, 10, "2019-08-10 13:03:00.000");

SELECT * FROM kainska.like_comment;
INSERT INTO like_comment (comment_id) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

SELECT * FROM kainska.like_post;
INSERT INTO like_post (post_id, time_creation_like) VALUES
(1, "2008-12-10 14:03:00.000"),
(1, "2011-11-10 01:03:00.000"),
(1, "2013-10-10 04:03:00.000"),
(1, "2012-01-10 03:03:00.000"),
(1, "2019-03-10 20:03:00.000"),
(1, "2005-08-10 22:03:00.000"),
(1, "2021-10-10 23:03:00.000"),
(1, "2019-06-10 11:22:00.000"),
(1, "2014-05-10 20:06:00.000"),
(1, "2017-01-10 13:05:00.000");

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
