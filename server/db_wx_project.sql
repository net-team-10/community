/*
Navicat MySQL Data Transfer

Source Server         : 数据库连接
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db_wx_project

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-16 12:09:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `hide` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`),
  KEY `FK68tbcw6bunvfjaoscaj851xpb` (`user_id`),
  CONSTRAINT `FK68tbcw6bunvfjaoscaj851xpb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '不会，滚，下一个', '0', '0', '2018-12-19', '1', '13');
INSERT INTO `answer` VALUES ('2', '都说了不会了，不要担心！！', '0', '0', '2018-12-20', '2', '13');
INSERT INTO `answer` VALUES ('3', '你会变胖的，兄弟。', '1', '0', '2018-12-18', '3', '12');
INSERT INTO `answer` VALUES ('4', '不会的。', '0', '0', '2018-12-18', '1', '12');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdqc83j2n6hemidegfkim17d3l` (`answer_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKdqc83j2n6hemidegfkim17d3l` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '你有点凶哦！怕怕！', '2018-12-19', '1', '9');
INSERT INTO `comment` VALUES ('2', '就该这样！', '2018-12-19', '1', '12');
INSERT INTO `comment` VALUES ('3', '哈哈哈哈哈哈哈', '2018-12-19', '1', '14');
INSERT INTO `comment` VALUES ('4', 'QAQ', '2018-12-20', '1', '9');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('2');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `hide` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ekrlbqiybwk8abhgclfjwnmc` (`user_id`),
  CONSTRAINT `FK4ekrlbqiybwk8abhgclfjwnmc` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '我是一个程序员，我的头被烫了，我会秃头吗？', '0', '0', '2018-12-16', '请问我会秃头吗？', '9');
INSERT INTO `question` VALUES ('2', '我是一个程序员，我的头又被烫了，我真的不会秃头吗？我有点担心。', '0', '0', '2018-12-17', '再一次请问我会秃头吗？', '9');
INSERT INTO `question` VALUES ('3', '我每天晚上都要吃好多东西，我有点担心我会变胖。', '0', '0', '2018-12-14', '请问我会变胖吗？', '9');
INSERT INTO `question` VALUES ('4', '这个问题如果有人回答不漂亮，我就要把问题关闭掉。', '1', '0', '2018-12-13', '请问我漂亮吗？', '13');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tell` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'nanjing', '18', 'admin', '15888');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', 'new_test.jgp', '1', 'zxs');
INSERT INTO `user` VALUES ('12', 'plw_img.jpg', '1', 'plw');
INSERT INTO `user` VALUES ('13', 'nff_img.jpg', '2', 'nff');
INSERT INTO `user` VALUES ('14', 'llz_img.jpg', '2', 'llz');

-- ----------------------------
-- Table structure for `user_map`
-- ----------------------------
DROP TABLE IF EXISTS `user_map`;
CREATE TABLE `user_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `focused_user_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2thpunovaxmdfssb80jtnflj` (`focused_user_id`),
  KEY `FKfhiwt9igiru75odneq9p5fk27` (`user_id`),
  CONSTRAINT `FK2thpunovaxmdfssb80jtnflj` FOREIGN KEY (`focused_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKfhiwt9igiru75odneq9p5fk27` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_map
-- ----------------------------
INSERT INTO `user_map` VALUES ('1', '13', '9');

-- ----------------------------
-- Table structure for `user_question_map`
-- ----------------------------
DROP TABLE IF EXISTS `user_question_map`;
CREATE TABLE `user_question_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqaavgqn4ndt259t5empcoyvju` (`question_id`),
  KEY `FKky2apv76lcgb0xjcu65m4ofss` (`user_id`),
  CONSTRAINT `FKky2apv76lcgb0xjcu65m4ofss` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqaavgqn4ndt259t5empcoyvju` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_question_map
-- ----------------------------
INSERT INTO `user_question_map` VALUES ('1', '1', '9');
