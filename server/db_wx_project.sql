-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_wx_project
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'https://wx.qlogo.cn/mmopen/vi_32/kowFWmbQ1b8dvHA0C9AgO0eWHgKHiaiaEhYHxNnowNa0oWh33avgrDibgicdibjPpxpn0sfhCNGDLK7hKBfHseS6bvg/132','小胖子');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'待尔长发及腰，吾妻归来可好？看遍天下依依草，皆无吾妻飘渺。几经繁华依旧，却无留恋今宵。行遍天下亦逍遥，惟愿与卿同老。',0,0,'2018-12-19 14:35',1,13),(2,'都说了不会了，不要担心！！',0,0,'2018-12-20 14:35',2,13),(3,'你会变胖的，兄弟。',1,0,'2018-12-18 14:35',3,12),(4,'不会的。都说了不会了，不要担心！！ 我给你念首诗吧！',1,0,'2018-12-18 14:35',1,12),(5,'不会的。\n床前明月光，疑是地上霜。\n举头望明月，低头思故乡。',0,1,'2018-12-16 15:27',1,9),(6,'不会的。\n床前明月光，疑是地上霜。\n举头望明月，低头思故乡。',0,0,'2018-12-16 15:30',1,9),(7,'用全局变量控制域名成功了！',0,0,'2018-12-16 15:59',11,9),(8,'我来试一下匿名回答的效果',0,1,'2018-12-16 15:59',11,9),(9,'云想衣裳花想容，\n春风拂槛露华浓。\n若非群玉山头见，\n会向瑶台月下逢。\n一枝红艳露凝香，\n云雨巫山枉断肠。\n借问汉宫谁得似，\n可怜飞燕倚新妆。\n名花倾国两相欢，\n长得君王带笑看。\n解释春风无限恨，\n沉香亭北倚阑干。',0,0,'2018-12-16 21:06',4,9),(10,'【原诗】\n待我长发及腰，将军归来可好？\n此身君子意逍遥，怎料山河萧萧。\n天光乍破遇，暮雪白头老。\n寒剑默听奔雷，长枪独守空壕。\n醉卧沙场君莫笑，一夜吹彻画角。\n江南晚来客，红绳结发梢。',0,1,'2018-12-16 21:13',2,9),(11,'【回信】\n待卿长发及腰，我必凯旋回朝。\n昔日纵马任逍遥，俱是少年英豪。\n东都霞色好，西湖烟波渺。\n执枪血战八方，誓守山河多娇。\n应有得胜归来日，与卿共度良宵。\n盼携手终老，愿与子同袍。',0,0,'2018-12-16 21:15',1,9),(12,'待尔长发及腰，吾妻归来可好？看遍天下依依草，皆无吾妻飘渺。几经繁华依旧，却无留恋今宵。行遍天下亦逍遥，惟愿与卿同老。\n\n待我长发及腰，尔来寻吾可好？观遍人间君子遥，皆无尔之逍遥。几经世间仍枉，却话虚度今宵。何处明了意凌霄，永愿与君偕老。',0,1,'2018-12-16 23:13',4,9),(13,'试了一下下，效果还可以。',0,0,'2018-12-19 09:43',14,15);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'你有点凶哦！怕怕！','2018-12-19 14:35',11,9),(2,'就该这样！','2018-12-19 14:35',11,12),(3,'哈哈哈哈哈哈哈','2018-12-19 14:35',11,14),(4,'QAQ','2018-12-20 14:35',11,9),(5,'真有文化, 待你长发及腰时,剪掉可好？没想到还是不够长','2018-12-16 22:36',1,9),(6,'再评论一下','2018-12-16 22:37',1,9),(7,'最后一下','2018-12-16 22:38',1,9),(8,'真美','2018-12-16 23:39',12,9),(9,'你说的是真的吗，我读书少，你不要骗我！','2018-12-17 16:39',2,9);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'我是一个程序员，我的头被烫了，我会秃头吗？我真的不会秃头吗？我有点担心。',0,1,'2018-12-16 14:35','请问我会秃头吗？',9),(2,'我是一个程序员，我的头又被烫了，我真的不会秃头吗？我有点担心。',0,1,'2018-12-17 14:35','再一次请问我会秃头吗？',9),(3,'我每天晚上都要吃好多东西，我有点担心我会变胖。',0,1,'2018-12-14 14:35','请问我会变胖吗？',9),(4,'这个问题如果有人回答不漂亮，我就要把问题关闭掉。',0,1,'2018-12-13 14:35','请问我漂亮吗？',13),(7,'我现在好饿，好像吃东西，可是明明才吃过午饭啊T^T\n晚上吃啥呢？',0,1,'2018-12-16 13:32','今天晚上吃啥呢？',9),(8,'调试好麻烦啊，不知道今天能不能调试好欸。。',0,1,'2018-12-16 13:36','今天能调试好吗？',9),(9,'这次应该能成功了吧，不希望有下一次',0,1,'2018-12-16 13:38','这次能成功吗？',9),(10,'设置页面刷新后看看效果',0,1,'2018-12-16 13:39','这样能行吗?',9),(11,'如果不用全局变量，每处域名都要手动修改，好烦(-。-)',0,1,'2018-12-16 15:58','用全局变量控制域名成功了吗？',9),(13,'把所有的接口中用户名都改成了用户ID',0,1,'2018-12-16 20:52','更改接口后可以提问吗？',9),(14,'看一下管理员界面没有tabBar之后的效果',0,1,'2018-12-19 09:40','提一个问题试试看',15),(15,'让管理员界面的scrollbar起效果',0,1,'2018-12-19 09:41','再来一个问题',15);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'../../images/avatar/3.png',1,'zxs'),(12,'../../images/avatar/4.png',1,'plw'),(13,'../../images/avatar/3.png',2,'nff'),(14,'../../images/avatar/5.png',2,'llz'),(15,'https://wx.qlogo.cn/mmopen/vi_32/kowFWmbQ1b8dvHA0C9AgO0eWHgKHiaiaEhYHxNnowNa0oWh33avgrDibgicdibjPpxpn0sfhCNGDLK7hKBfHseS6bvg/132',1,'小胖子');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_map`
--

DROP TABLE IF EXISTS `user_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `focused_user_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2thpunovaxmdfssb80jtnflj` (`focused_user_id`),
  KEY `FKfhiwt9igiru75odneq9p5fk27` (`user_id`),
  CONSTRAINT `FK2thpunovaxmdfssb80jtnflj` FOREIGN KEY (`focused_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKfhiwt9igiru75odneq9p5fk27` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_map`
--

LOCK TABLES `user_map` WRITE;
/*!40000 ALTER TABLE `user_map` DISABLE KEYS */;
INSERT INTO `user_map` VALUES (8,13,9),(9,12,15);
/*!40000 ALTER TABLE `user_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_question_map`
--

DROP TABLE IF EXISTS `user_question_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_question_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqaavgqn4ndt259t5empcoyvju` (`question_id`),
  KEY `FKky2apv76lcgb0xjcu65m4ofss` (`user_id`),
  CONSTRAINT `FKky2apv76lcgb0xjcu65m4ofss` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqaavgqn4ndt259t5empcoyvju` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_question_map`
--

LOCK TABLES `user_question_map` WRITE;
/*!40000 ALTER TABLE `user_question_map` DISABLE KEYS */;
INSERT INTO `user_question_map` VALUES (1,1,9);
/*!40000 ALTER TABLE `user_question_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-19 11:03:24
