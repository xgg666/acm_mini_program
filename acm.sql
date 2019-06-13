-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: acm
-- ------------------------------------------------------
-- Server version	5.7.21-1

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
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `announceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `announceTitle` varchar(50) DEFAULT NULL,
  `announceBody` text,
  `announceCreateUser` bigint(20) DEFAULT NULL,
  `announceCreateTime` datetime DEFAULT NULL,
  `announceUpdateUser` bigint(20) DEFAULT NULL,
  `announceUpdateTime` datetime DEFAULT NULL,
  `isEffective` int(11) DEFAULT NULL,
  `isFirst` int(11) DEFAULT NULL,
  `isPublic` int(11) DEFAULT NULL,
  PRIMARY KEY (`announceId`)
) ENGINE=InnoDB AUTO_INCREMENT=9000000853939657 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1,'2','2',2,'2019-01-13 17:05:16',2,'2019-01-13 22:17:13',0,0,0),(2,'sdf2','sdf',2,'2019-01-13 17:32:55',2,'2019-01-13 17:32:55',1,0,1),(3,'1','1',2,'2019-01-13 17:34:56',2,'2019-01-13 17:34:56',1,0,1),(4,'gh','<p>fdf</p>',2,'2019-01-13 17:35:45',2,'2019-01-13 17:35:45',1,0,1),(5,'1','<p>fdf<img src=\"http://localhost:9999/image/c4596f9e-a98f-4be3-b19b-8661c796b9fb.png\" style=\"max-width: 100%;\"></p>',2,'2019-01-13 17:40:29',2,'2019-01-13 17:40:29',1,0,1),(6,'','<p><img src=\"http://localhost:9999/image/ae727715-db1e-48c4-84e9-50a3f71ec851.png\" style=\"max-width:100%;\"><br></p>',2,'2019-01-13 17:42:26',2,'2019-01-13 17:42:26',1,0,1),(7,'g','<p><br></p>',2,'2019-01-13 17:45:30',2,'2019-01-13 17:45:30',1,0,1),(8,'g','<p><br></p>',2,'2019-01-13 17:45:32',2,'2019-01-13 17:45:32',1,0,1),(9,'fdg','',2,'2019-01-13 17:47:25',2,'2019-01-13 17:47:25',1,0,0),(10,'fdg','',2,'2019-01-13 17:47:44',2,'2019-01-13 17:47:44',1,0,1),(11,'f','',2,'2019-01-13 17:48:15',2,'2019-01-13 17:48:15',1,0,1),(12,'f','',2,'2019-01-13 17:48:31',2,'2019-01-13 17:48:31',1,0,0),(13,'cv','<p>xcv</p>',2,'2019-01-13 17:49:17',2,'2019-01-13 17:49:17',1,0,1),(14,'sdf','<p>sdf</p>',2,'2019-01-13 17:50:00',2,'2019-01-13 17:50:00',1,0,1),(15,'dg','<p>fgh</p>',2,'2019-01-13 17:50:39',2,'2019-01-13 17:50:39',1,0,1),(16,'ghf','',2,'2019-01-13 17:51:06',2,'2019-01-13 17:51:06',1,0,1),(17,'cxv','<p>xcv</p>',2,'2019-01-13 17:51:39',2,'2019-01-13 17:51:39',1,0,1),(18,'adsf','<p>adsfds</p>',2,'2019-01-13 22:01:14',2,'2019-01-13 22:01:14',1,0,1),(19,'vzcx','<p>zcvxxcv</p>',2,'2019-01-13 22:06:56',2,'2019-01-13 22:06:56',1,0,1),(20,'2','2',2,'2019-01-13 22:16:34',2,'2019-01-13 22:16:34',1,0,0),(21,'fhfgh','<p>dghgfhdgh</p>',2,'2019-01-13 22:17:39',2,'2019-01-13 22:17:39',1,0,1),(22,'sdfgfdsg','<p>sfdgsdf</p>',2,'2019-01-13 22:19:10',2,'2019-01-13 22:19:10',1,0,1),(23,'dghgfsgfety','<p><span style=\"font-weight: bold;\">dsdgety</span></p>',2,'2019-01-13 22:19:51',2,'2019-01-16 20:28:24',1,0,1),(24,'sfgfsd','<p>gsfdgfdsh sgf</p>',2,'2019-01-13 22:20:53',2,'2019-01-13 22:20:56',0,0,1),(25,'西瓜傻逼','<p>如题<img src=\"http://localhost:9999/image/656aa91b-5d10-4b9c-9c56-7190364111c7.png\" style=\"max-width: 100%;\"></p>',2,'2019-01-13 22:21:43',2,'2019-01-13 22:21:54',0,0,1),(26,'test','<p>body</p>',2,'2019-01-16 20:26:12',2,'2019-01-16 20:26:22',0,0,1),(27,'litest','<p>xixi</p><p><span style=\"font-weight: bold;\">zheshiyigeceshi</span></p><p><img src=\"http://localhost:9999/image/2d160e36-bd91-41f9-a1bb-a96c9488f4f3.png\" style=\"max-width:100%;\">rwe<br></p>',2,'2019-01-16 21:54:55',2,'2019-01-16 21:55:09',1,0,1),(28,'测试','<p>嘻嘻<img src=\"http://localhost:9999/image/2dd0720b-1a26-4e4b-910f-07738aee015f.png\" style=\"max-width: 100%;\"></p>',2,'2019-01-17 21:30:41',2,'2019-01-17 21:31:00',1,0,1),(29,'我是西瓜','<p>我是西瓜</p>',3,'2019-01-17 21:41:14',3,'2019-01-17 21:41:14',1,0,1),(30,'西瓜sb','<p>测试<img src=\"http://localhost:9999/image/1b3dbb27-955c-4304-ae9f-e9cc194f6fc4.png\" style=\"max-width: 100%;\"></p>',2,'2019-01-19 21:23:46',2,'2019-01-19 21:24:04',1,0,1),(31,'nbv','<p>nbcnv</p>',2,'2019-01-19 21:24:58',2,'2019-01-19 21:24:58',1,0,0),(32,'1','1',2,'2019-01-19 22:28:22',2,'2019-01-19 22:28:22',1,0,1),(33,'1','1',2,'2019-01-19 22:30:13',2,'2019-01-19 22:30:13',1,0,1),(39,'1','1',2,'2019-01-19 22:41:03',2,'2019-01-19 22:41:03',1,0,1),(40,'1','1',2,'2019-01-19 22:44:26',2,'2019-01-19 22:44:26',1,0,1),(41,'1','1',2,'2019-01-19 22:45:40',2,'2019-01-19 22:45:40',1,0,1),(42,'gsfd','<p>gsfdgfsd</p>',2,'2019-01-19 22:49:01',2,'2019-01-19 22:49:27',0,0,1),(43,'gsfd','<p>gsfdgfsd</p>',2,'2019-01-19 22:49:01',2,'2019-01-19 22:49:01',1,0,1),(44,'gsfd','<p>gsfdgfsd</p>',2,'2019-01-19 22:49:57',2,'2019-01-19 22:49:57',1,0,1),(6126251720999,'请想来参加ACM集训的同学注意','<p>由于本群欲满，请想接下来参加ACM集训的同学加群<br>点击链接加入群聊【CUIT/ACM - ICPC FM 3群】：<a href=\"https://jq.qq.com/?_wv=1027&amp;k=57sSzRQ\" target=\"_blank\">https://jq.qq.com/?_wv=1027&amp;k=57sSzRQ</a><br></p>',2,'2019-05-29 21:15:54',2,'2019-05-29 21:15:54',1,1,1),(476508870399734,'今晚开会','<p>今晚18点半请所有实验室人员到6301A开会！请后面要参加暑假集训的同学也要来！主要讲一下实验室搬迁问题。最好来。不然后面实验室在哪你都不知道－_－<br></p>',2,'2019-05-23 17:26:46',2,'2019-05-30 18:26:48',1,1,1),(952213157827301,'领取CCCC奖状','<p>请参加了CCCC的人员到实验室领取奖状，(进门直走的那张桌子上，然后还有PAT代金券，按照自己获奖的等级领取就行。)<br></p>',2,'2019-01-20 22:48:37',2,'2019-05-30 18:27:27',1,0,1),(1332218935152135,'新生请注意，训练开始啦','<p><img width=\"24\" height=\"24\" src=\"https://s1.url.cn/qqun/web/announce/img/47@2x.gif\">我们放了3套最基础的入门题，你们有足够的时间慢慢做<br>如果没有任何基础的可以重点看第一套上面的链接，你们不懂的上面都有，<br>有基础的，还想训练的可以私聊我,单独布置训练计划<br>有什么问题私聊答疑组(看群名片，基本上都是管理员)<br><a href=\"https://vjudge.net/contest/253497\" target=\"_blank\">https://vjudge.net/contest/253497</a><br><a href=\"https://vjudge.net/contest/253498\" target=\"_blank\">https://vjudge.net/contest/253498</a><br></p>',2,'2019-01-20 23:12:33',2,'2019-05-30 18:26:08',1,0,1),(2271552792347669,'6.10-训练赛','<p>时间: 6月10日(周日) 12:00-17:00<br>链接:&nbsp;<a href=\"http://acm.zju.edu.cn/onlinejudge/contestInfo.do?contestId=379\" target=\"_blank\">http://acm.zju.edu.cn/onlinejudge/contestInfo.do?contestId=379</a>&nbsp;<br>【ZOJ月赛】<br>地点: 实验室6301A<br>可以组队, 可以单刷, 题目英文, 欢迎AK<br></p>',2,'2019-05-23 17:26:22',2,'2019-05-30 18:27:07',1,0,1),(3000001014459809,'1','1',2,'2019-01-19 22:56:50',2,'2019-01-19 22:56:50',1,0,1),(3000001989394877,'1','1',2,'2019-01-19 22:56:43',2,'2019-01-19 22:56:43',1,0,1),(3000002061424000,'saf','<p>adgdfsg</p>',2,'2019-01-19 22:57:12',2,'2019-01-19 22:57:16',1,0,1),(3426715813036022,'fd','<p>fgd</p>',2,'2019-01-19 23:09:47',2,'2019-01-19 23:09:47',1,0,1),(3994966884781117,'组队训练赛3','<p>比赛网址: https://vjudge.net/contest/231802<br>比赛地点: 6301A<br>比赛时间: 明天12:00 - 17:00<br></p>',4,'2019-04-18 22:54:59',4,'2019-04-18 22:55:31',1,1,1),(9000000853939656,'1','1',2,'2019-01-19 22:56:58',2,'2019-01-19 22:56:58',0,0,1);
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applycompetition`
--

DROP TABLE IF EXISTS `applycompetition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applycompetition` (
  `applyCompetitionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `competitionId` bigint(20) DEFAULT NULL,
  `joinUser` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `isEffective` int(11) DEFAULT '1',
  PRIMARY KEY (`applyCompetitionId`),
  KEY `competitionId` (`competitionId`),
  CONSTRAINT `competitionId` FOREIGN KEY (`competitionId`) REFERENCES `competition` (`competitionId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applycompetition`
--

LOCK TABLES `applycompetition` WRITE;
/*!40000 ALTER TABLE `applycompetition` DISABLE KEYS */;
INSERT INTO `applycompetition` VALUES (1,2909823860127803,2,'2019-02-19 22:59:34',0),(2,9662649042186971,2,'2019-02-19 23:06:23',0),(3,2909823860127803,2,'2019-02-20 20:43:13',0),(4,9662649042186971,3,'2019-02-20 20:54:28',1),(5,2909823860127803,2,'2019-02-20 21:00:06',1),(6,2909823860127803,2,'2019-02-20 22:11:29',1),(7,2909823860127803,2,'2019-02-20 22:11:29',1),(8,2909823860127803,2,'2019-02-20 22:11:29',1),(9,2909823860127803,2,'2019-02-20 22:11:29',1),(10,2909823860127803,2,'2019-02-20 22:11:29',1),(11,2909823860127803,3,'2019-04-12 13:58:49',1),(12,5561780589593834,3,'2019-04-12 13:59:02',1),(13,3148022006837283,6,'2019-05-27 19:45:49',1),(14,5437456515820607,6,'2019-05-28 22:20:18',1),(15,978471564291,6,'2019-05-29 21:38:12',1),(16,2909823860127803,6,'2019-05-30 16:44:15',1);
/*!40000 ALTER TABLE `applycompetition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `attendenceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createUser` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `sumDay` int(11) DEFAULT '1',
  `isEffective` int(11) DEFAULT '1',
  PRIMARY KEY (`attendenceId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,2,'2019-03-27 17:27:37',1,1),(3,2,'2019-03-28 17:32:44',1,1),(7,2,'2019-03-29 17:35:18',2,1),(8,3,'2019-03-28 17:35:50',1,1),(9,3,'2019-03-29 17:36:07',2,1),(10,3,'2019-03-30 17:30:48',1,1),(11,3,'2019-03-31 17:31:15',2,1),(12,3,'2019-04-01 20:41:46',3,1),(13,13,'2019-04-02 22:35:25',1,1),(14,13,'2019-04-08 23:37:29',1,1),(15,13,'2019-04-09 21:02:31',2,1),(16,13,'2019-04-10 13:52:47',3,1),(17,12,'2019-04-10 17:23:13',1,1),(18,12,'2019-04-11 18:11:17',2,1),(19,3,'2019-04-12 21:45:29',1,1),(20,6,'2019-04-17 19:28:38',1,1),(21,6,'2019-04-18 14:05:41',2,1),(22,6,'2019-04-19 11:01:06',3,1),(23,6,'2019-04-19 11:01:06',3,1),(24,6,'2019-05-10 01:07:31',1,1),(25,6,'2019-05-10 01:07:31',1,1),(26,6,'2019-05-28 21:05:05',1,1),(27,6,'2019-05-28 21:05:05',1,1),(28,6,'2019-05-28 21:05:05',1,1),(29,6,'2019-05-31 09:10:48',1,1),(30,6,'2019-05-31 09:10:48',1,1);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `classId` bigint(20) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  `isEffective` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES (34,'时事新闻',1,'2019-01-22 21:21:21','2019-01-22 21:21:21',2),(35,'竞赛',1,'2019-01-22 21:21:27','2019-01-22 21:21:27',2),(36,'未分类',1,'2019-01-22 23:10:58','2019-01-22 23:10:58',2),(37,'获奖',0,'2019-05-27 15:15:54','2019-05-27 15:15:50',2),(38,'获奖',1,'2019-05-27 15:15:57','2019-05-27 15:15:57',2);
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competition`
--

DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competition` (
  `competitionId` bigint(20) NOT NULL,
  `competitionTitle` varchar(100) NOT NULL,
  `competitionBody` text NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `createUser` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `updateUser` int(11) DEFAULT NULL,
  `isDone` int(11) DEFAULT '1',
  `isEffective` int(11) DEFAULT '1',
  PRIMARY KEY (`competitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition`
--

LOCK TABLES `competition` WRITE;
/*!40000 ALTER TABLE `competition` DISABLE KEYS */;
INSERT INTO `competition` VALUES (978471564291,' CUIT 线段树 ','<ul role=\"tablist\" id=\"contest-tabs\"><li><a href=\"https://vjudge.net/contest/172926#overview\" section=\"overview\" role=\"tab\">Overview</a></li><li><a href=\"https://vjudge.net/contest/172926#problem\" section=\"problem\" role=\"tab\">Problem</a></li><li><a href=\"https://vjudge.net/contest/172926#status\" section=\"status\" role=\"tab\">Status</a></li><li><a href=\"https://vjudge.net/contest/172926#rank\" section=\"rank\" role=\"tab\">Rank (120:00:00)</a></li><li><a href=\"https://vjudge.net/contest/172926#discuss\" section=\"discuss\" role=\"tab\" rel=\"#discuss\">1 Comments</a></li><li><div role=\"group\"><button type=\"button\" id=\"btn-setting\">Setting</button><button type=\"button\" id=\"btn-favorite\"><i></i>Favorite</button><button type=\"button\" id=\"btn-clone\">Clone&nbsp;</button></div></li></ul><div><div id=\"overview\" role=\"tabpanel\"><div id=\"contest_overview\"></div></div></div>','2019-05-31 20:12:30',2,'2019-05-30 20:12:35',2,1,1),(2871813020508812,'校赛初赛通知','<p>第十七届电子科技大学程序设计竞赛暨西南地区高校邀请赛<strong>初赛</strong>将于3月23日（周六）早上9:00开始，本次比赛持续12个小时，欢迎大家积极参加！</p><p>对校赛有任何疑问欢迎加入UESTC－ACM－2019新人交流QQ群（554056561）提问！</p><p>报名链接：<a href=\"https://acm.uestc.edu.cn/contest/2\">戳我</a>，之后点击team</p><p>报名指南：<a href=\"https://acm.uestc.edu.cn/blog/chu-sai-bao-ming-zhi-nan\">戳我</a></p><p>OJ使用指南：<a href=\"https://acm.uestc.edu.cn/blog/ojshi-yong-zhi-nan/\">戳我</a></p><h3>参赛条件</h3><p>每支参赛队伍可由1至3名学生组成，所有电子科技大学在读学生(包括本科生和研究生)均可组队参赛。由全为本科一年生组成的大一队伍或者全为女生组成的队伍都可以适当降低进入决赛的条件。</p><h3>比赛形式</h3><p>初赛采用的是网络赛，比赛采用的平台是电子科技大学在线评测系统，决赛的形式是现场赛，将完全采用ACM国际大学生程序设计竞赛的赛制。</p><h3>参赛语言</h3><p>C/C\\\\、Java</p><h3>日程安排(随时更新)</h3><p>热身赛时间：3月16日 星期六 9:00-21:00; 3月20日 星期三 9:00-21:00</p><p>初赛时间：3月23日 星期六 9:00-21:00</p><p>决赛时间：3月31日 星期日 13:00-18:00 (现场决赛)</p><p>报名截止时间：3月22日 星期五 24:00</p><p><strong>&lt;span class=“font-danger”&gt;务必保证报名填写的个人信息真实，否则不参与评奖。</strong></p><p><strong>在比赛过程中需遵守以下条款：</strong></p><ol><li>在比赛过程中，不得与除队友以外的其他人进行有关比赛的任何交流。</li><li>在比赛过程中，不得索要和使用其他队伍的代码。</li><li>在比赛过程中，不得试图做出对评测系统进行攻击等的危害比赛正常进行的举动。</li></ol><h3>FAQ</h3><p><strong>问</strong>：热身赛必须做吗？</p><p>答：热身赛不是必须做的。只是为了给不熟悉OJ的新人准备的练习性比赛。</p><p><strong>问</strong>：热身赛需要注册吗？</p><p>答：热身赛需要注册。</p><p><br></p>','2019-06-08 19:33:28',2,'2019-05-30 19:34:24',2,1,1),(2909823860127803,'“百词斩”杯成都信息工程大学第五届ACM程序设计大赛','<p><b>1.</b><b>大赛简介</b></p><p><b></b>成都信息工程大学ACM程序设计大赛是一项面向全校注册在校学生的群众性科技活动，目的在于更好地带动学习编程之风，进一步加强学生的动手能力，发掘大学生潜力，促进大学生对计算机行业专业知识的应用能力，激发广大学生对编程的兴趣，发扬勇于创新、刻苦钻研的精神，培养和激励我校大学生的程序设计能力、算法分析、创新意识，营造良好的学习氛围，提高教学质量，促进学生之间的交流。同时为ACM-ICPC国际大学生程序设计竞赛选拔人才。</p><p><b>2</b><b>.参赛说明</b></p><p>大赛仅含决赛阶段，所有报名选手进入决赛。选手以个人为单位，独立完成一定的编程题目，大赛最终奖项仅以现场排名作为参考，有效排名为至少解决一道题。</p><p><b>3</b><b>.参赛对象</b></p><p><b></b>全校注册在校学生，凡对编程对ACM感兴趣都可以报名，同时设最佳女选手奖。</p><p>4<b>.报名方式</b></p><p><b></b>网上报名地址：<a href=\"http://acm.cuit.edu.cn/competition/join/2016\">http://acm.cuit.edu.cn/competition/join/2016</a></p><p>现场报名地址：一二食堂摆点处。</p><p>校队官网报名：<a href=\"http://acm.cuit.edu.cn/\">http://acm.cuit.edu.cn</a></p><p>大赛官方QQ群：196442993</p>','2019-06-07 16:01:25',2,'2019-05-30 16:01:33',2,1,1),(3148022006837283,'CUIT 2019 省赛选拔','<p><b>Begin:</b>&nbsp;2019-05-11 09:00 CST</p><div><h3>CUIT2019省赛选拔</h3></div><div><b>End:</b>&nbsp;2019-05-11 14:00 CST</div>','2019-05-30 15:59:47',2,'2019-05-30 15:59:50',2,1,1),(3279264855112183,'11','22','2019-02-18 21:25:00',2,'2019-02-18 23:00:14',2,1,0),(5437456515820607,'第四届成都信息工程大学程序设计大赛暨ACM校队选拔赛','<p>各学院:</p><p>&nbsp; &nbsp; &nbsp; &nbsp;ACM程序设计大赛是面向全校注册在校学生的群众性科技活动，目的在于更好地带动学习编程之风，进一步加强学生的动手能力，发掘大学生潜力，促进大学生对计算机行业专业知识的应用能力，激发广大学生对编程的兴趣，发扬勇于创新、刻苦钻研的精神，培养和激励我校大学生的程序设计能力、算法分析、创新意识，营造良好的学习氛围，提高教学质量，促进学生之间的交流，同时为ACM-ICPC国际大学生程序设计竞赛选拔人才，特举办本届ACM程序设计大赛。</p><p>&nbsp; 现将有关事宜通知如下:</p><ul><li><p>主办单位：&nbsp;教务处&nbsp;校团委</p></li><li><p>承办单位：&nbsp;软件工程学院</p></li></ul><p>&nbsp;</p><p>比赛规则</p><p>本次大赛分为初赛（个人预选赛）阶段、决赛（个人总决赛）阶段。</p><p>初赛阶段</p><p>1．选手以个人为单位参赛，完成一定编程题目。</p><p>2．命题数量为6道，中文描述。</p><p>3．允许使用的编程语言为C、C\\\\、java。</p><p>4．参赛队员可以携带诸如书、手册、程序清单等纸质参考资料。参赛队员不得携带任何磁盘、光盘、优盘等存储设备。不得使用带有存储功能的计算器。</p><p>5．比赛时长为3个小时，若比赛过程中出现不可预见事件，大赛组委会可能会延长比赛时间。</p><p>6．选手有权向考场监考员针对试题描述中的不明确或错误提出试题解释请求。如果裁判确认试题中确实存在不明确或错误的部分，将会及时通知所有参赛选手。</p><p>7．当参赛选手出现妨碍比赛正常进行的行为时，诸如攻击比赛系统，盗取他人登录密码和源代码、干扰他人比赛等，都将会被大赛组委会剥夺参赛资格。</p><p>初赛结束后，选拔前90名选手，组委会将在大赛官网公布进入决赛名单。</p><p>决赛阶段</p><p>1．选手以个人为单位参赛，完成一定编程题目。</p><p>2．命题数量为6道，中文描述，题目难度较初赛有所提升。允许使用的编程语言为C、C\\\\、java。</p><p>3．参赛选手可以携带诸如书、手册、程序清单等纸质参考资料。参赛选手不得携带任何磁盘、光盘、优盘等存储设备。不得使用带有存储功能的计算器。</p><p>4．竞赛的预定时间为3时，但当竞赛进行一定时间后，大赛组委会可以因为不可预见的事件而调整比赛时长。决赛结束前15分钟停止更新排行榜，最终排名颁奖仪式公布。</p><p>5．参赛选手不能携带任何类型的通讯工具，包括无线电接收器、移动电话等。在竞赛中，参赛选手不得通过网络工具（如e-mail、BBS等）以及任何其他方式与指定工作人员以外的人员交流。比赛中如发现违规行为，将立即取消参赛选手的参赛资格，情况严重时，通报教务处及所属院系。</p><p>6．参赛选手有权向考场监考员针对试题描述中的不明确或错误提出试题解释请求。如果裁判确认试题中确实存在不明确或错误的部分，将会及时通知所有参赛选手。</p><p>7．当参赛选手出现妨碍比赛正常进行的行为时，诸如攻击比赛系统，盗取他人登录密码和源代码、干扰他人比赛等，都将会被大赛组委会剥夺参赛资格。</p>','2019-06-28 16:11:52',2,'2019-05-30 16:11:58',2,1,1),(5561780589593834,'你好','<p>12345678</p>','2019-02-18 21:56:27',2,'2019-02-18 23:03:26',2,1,0),(5631398507761897,'213412','<p>32532562</p>','2019-05-27 18:01:03',2,'2019-05-27 18:27:50',2,1,0),(6236250304831025,'第七届校赛决赛','<p>欢迎大家参加</p>','2019-05-14 16:14:14',2,'2019-05-30 16:14:18',2,0,1),(9311499179934336,'124123','<p>34v23</p>','2019-02-18 22:14:18',2,'2019-02-18 23:02:42',2,1,0),(9662649042186971,'22','<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><th>','2019-02-19 21:55:49',2,'2019-02-19 21:55:49',2,1,0);
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dayduty`
--

DROP TABLE IF EXISTS `dayduty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dayduty` (
  `dayDutyId` int(11) NOT NULL AUTO_INCREMENT,
  `dayName` varchar(50) DEFAULT NULL,
  `dutyUserNames` varchar(200) DEFAULT NULL,
  `createUser` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` int(11) DEFAULT NULL,
  `updateData` datetime DEFAULT NULL,
  `isEffective` int(11) DEFAULT '1',
  PRIMARY KEY (`dayDutyId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dayduty`
--

LOCK TABLES `dayduty` WRITE;
/*!40000 ALTER TABLE `dayduty` DISABLE KEYS */;
INSERT INTO `dayduty` VALUES (1,'星期一','关关关',2,'2019-02-14 21:36:32',2,'2019-05-23 16:01:03',1),(2,'星期二','西瓜',2,'2019-02-14 21:36:56',2,'2019-02-14 21:37:05',1),(3,'星期三','二狗',2,'2019-02-14 21:37:32',2,'2019-02-14 21:37:36',1),(4,'星期四','村花',2,'2019-02-14 21:37:51',2,'2019-02-14 21:37:55',1),(5,'星期五','大哥',2,'2019-02-14 21:38:03',2,'2019-02-14 21:38:00',1),(6,'星期六','富婆',2,'2019-02-14 21:38:45',2,'2019-02-14 21:38:52',1),(7,'星期天','学姐',2,'2019-02-14 21:38:48',2,'2019-02-14 21:38:56',1);
/*!40000 ALTER TABLE `dayduty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impression`
--

DROP TABLE IF EXISTS `impression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impression` (
  `impressionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `impressionTitle` varchar(100) DEFAULT NULL,
  `imUser` int(11) DEFAULT NULL COMMENT '被评论用户',
  `createUser` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `agreeNum` int(11) DEFAULT '0',
  `isEffective` int(11) DEFAULT '0',
  PRIMARY KEY (`impressionId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impression`
--

LOCK TABLES `impression` WRITE;
/*!40000 ALTER TABLE `impression` DISABLE KEYS */;
INSERT INTO `impression` VALUES (1,'可爱',5,2,'2019-04-11 12:23:52',19,1),(2,'善良',5,2,'2019-04-11 12:24:10',24,1),(4,'帅气',3,2,'2019-04-11 12:24:29',108,1),(5,'heng',5,12,'2019-04-11 19:03:51',8,1),(6,'heng',5,12,'2019-04-11 19:04:27',3,1),(7,'111',5,12,'2019-04-11 19:04:52',1,1),(8,'111',5,12,'2019-04-11 19:07:03',1,1),(9,'111',5,12,'2019-04-11 19:07:09',2,1),(10,'wer',5,12,'2019-04-11 19:13:44',2,0),(11,'天才',5,12,'2019-04-11 19:13:55',23,1),(12,'ost真可爱',13,12,'2019-04-11 19:28:50',9,1),(13,'sdf',5,12,'2019-04-11 19:31:40',3,0),(14,'sdfsdfsdf',5,12,'2019-04-11 19:31:44',3,0),(17,'没奖励空间',5,12,'2019-04-11 20:47:57',19,1),(18,'臭东西',6,12,'2019-04-11 20:50:43',13,1),(20,'xiaokeai',5,6,'2019-04-18 16:37:50',9,1),(21,'啦啦啦',6,6,'2019-04-18 22:29:04',13,1),(22,'很棒',2,6,'2019-04-19 09:49:24',24,1),(23,'算法厉害！',6,6,'2019-05-30 16:32:04',16,1),(24,'女生最强',2,6,'2019-05-30 16:32:24',25,1),(25,'厉害！',2,6,'2019-05-30 17:00:55',2,1),(26,'切题超快',2,6,'2019-05-30 20:10:15',2,1),(27,'henlihai',5,6,'2019-05-31 09:07:29',0,1),(28,'数据结构厉害',4,6,'2019-05-31 10:07:48',0,1);
/*!40000 ALTER TABLE `impression` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newclass`
--

DROP TABLE IF EXISTS `newclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newclass` (
  `newClassId` bigint(20) NOT NULL AUTO_INCREMENT,
  `newsId` bigint(20) NOT NULL,
  `classId` bigint(20) NOT NULL,
  `createUser` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` bigint(20) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isEffective` int(11) DEFAULT NULL,
  PRIMARY KEY (`newClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newclass`
--

LOCK TABLES `newclass` WRITE;
/*!40000 ALTER TABLE `newclass` DISABLE KEYS */;
INSERT INTO `newclass` VALUES (1,6799851663161896,35,2,'2019-01-22 23:09:19',2,'2019-01-22 23:09:19',1),(2,6799851663161896,34,2,'2019-01-22 23:09:21',2,'2019-01-22 23:09:21',1),(3,6799851663161896,28,2,'2019-01-22 23:09:22',2,'2019-01-22 23:09:22',1),(4,6799851663161896,27,2,'2019-01-22 23:09:23',2,'2019-01-22 23:09:23',1),(5,6799851663161896,26,2,'2019-01-22 23:09:23',2,'2019-01-22 23:09:23',1),(6,1486280699314100,36,2,'2019-01-22 23:17:07',2,'2019-01-22 23:17:07',1),(7,9983416287760015,36,2,'2019-01-22 23:27:47',2,'2019-01-22 23:27:47',1),(8,58888816835064,35,2,'2019-01-22 23:28:07',2,'2019-01-22 23:28:07',1),(9,58888816835064,34,2,'2019-01-22 23:28:07',2,'2019-01-22 23:28:07',1),(10,7180713708457525,36,2,'2019-01-22 23:42:04',2,'2019-01-22 23:42:04',1),(11,918842042779163,35,2,'2019-01-22 23:44:52',2,'2019-01-22 23:44:52',1),(12,918842042779163,34,2,'2019-01-22 23:45:03',2,'2019-01-22 23:45:03',1),(13,8729990684056559,36,2,'2019-01-22 23:48:43',2,'2019-01-22 23:48:55',0),(14,8729990684056559,35,2,'2019-01-22 23:48:55',2,'2019-01-22 23:49:09',0),(15,8729990684056559,34,2,'2019-01-22 23:49:05',2,'2019-01-22 23:49:05',1),(16,7207239899042788,35,2,'2019-01-23 21:59:55',2,'2019-01-23 22:00:07',0),(17,7207239899042788,34,2,'2019-01-23 22:00:00',2,'2019-01-23 22:00:00',1),(18,3673118662725316,36,2,'2019-02-18 21:26:15',2,'2019-02-18 21:26:15',1),(19,615456943753521,36,2,'2019-02-18 21:28:16',2,'2019-02-18 21:28:16',1),(20,3421118176654855,35,2,'2019-04-18 18:57:51',2,'2019-04-18 18:57:51',1),(21,6036210639757074,35,4,'2019-04-18 21:33:56',4,'2019-04-18 21:33:56',1),(22,2111629352597230,34,4,'2019-04-18 21:36:51',4,'2019-04-18 21:36:51',1),(23,4722741468344091,35,4,'2019-04-18 21:52:26',4,'2019-04-18 21:52:26',1),(24,9428232542528741,35,4,'2019-04-18 22:01:46',4,'2019-04-18 22:01:46',1),(25,7069976714793927,35,4,'2019-04-18 22:06:50',4,'2019-04-18 22:06:50',1),(26,8306185870253192,34,2,'2019-05-22 13:31:02',2,'2019-05-30 16:15:19',0),(27,5190007975145,38,2,'2019-05-29 21:16:58',2,'2019-05-29 21:16:58',1),(28,8306185870253192,36,2,'2019-05-30 16:15:19',2,'2019-05-30 16:15:19',1),(29,1517188452594,38,2,'2019-05-30 21:10:55',2,'2019-05-30 21:10:55',1),(30,2645030820395,34,2,'2019-05-31 12:32:05',2,'2019-05-31 12:32:05',1);
/*!40000 ALTER TABLE `newclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `newsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `newsTitle` varchar(100) DEFAULT NULL,
  `newsBody` text,
  `createUser` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateUser` bigint(20) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isPublic` int(11) DEFAULT NULL,
  `isEffective` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB AUTO_INCREMENT=9983416287760016 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'test','11',2,'2019-01-19 22:14:28',2,'2019-01-21 21:32:41',1,0),(2,'test','11',2,'2019-01-19 22:15:12',2,'2019-01-19 22:15:12',1,1),(3,'test','11',2,'2019-01-19 22:17:20',2,'2019-01-19 22:17:20',1,1),(4,'test','11',2,'2019-01-19 22:17:53',2,'2019-01-19 22:17:53',1,1),(5,'test','11',2,'2019-01-19 22:19:15',2,'2019-01-19 22:19:15',1,1),(6,'test','11',2,'2019-01-19 22:21:15',2,'2019-01-19 22:21:15',1,1),(7,'test','111',2,'2019-01-19 22:24:49',2,'2019-01-19 22:24:49',1,1),(8,'test','111',2,'2019-01-19 22:25:29',2,'2019-01-19 22:25:29',1,1),(9,'test','111',2,'2019-01-19 22:27:53',2,'2019-01-19 22:27:53',1,1),(123,'测试id','<p>xssd</p>',2,'2019-01-21 22:51:30',2,'2019-01-21 22:51:30',1,1),(1517188452594,'学校ACM校队参加中国大学生程序设计竞赛全国邀请赛首战告捷','<p>&nbsp;&nbsp;&nbsp;&nbsp;5月13日，2018年“三盟科技杯”中国大学生程序设计竞赛全国邀请赛（湖南）暨第十届湘潭市大学生程序设计大赛在湘潭大学落下帷幕，来自全国60所高校的177支队伍参加了比赛。我校派出了三支参赛队共9名选手参赛，软件工程学院教师黄健为带队教师，经过5小时的激烈角逐，我校三支参赛队伍获得了两银一铜的优异成绩。</p><p align=\"center\"><img title=\"\" alt=\"\" src=\"https://www.cuit.edu.cn/News/image/2018/05/15/%E6%B9%98%E6%BD%AD%E5%8F%82%E8%B5%9B%E7%85%A7%E7%89%87.jpg\" width=\"500\" height=\"375\"></p><p align=\"center\">获奖团队</p>',2,'2019-05-30 21:10:53',2,'2019-05-30 21:10:53',1,1),(2645030820395,'大犇助阵，萌新来袭——2015年校ACM招新宣讲会成功举行','<p>11月26日，校ACM队招新宣讲会在航空港校区学术报告厅召开，来自各学院的300多名同学参加了宣讲会。宣讲会介绍了ACM国际大学生程序竞赛的竞赛形式，培养方式，以及我校的发展情况。宣讲会还邀请到曾经的四川大学ACM校队成员，现“百词斩”公司的CTO王波为同学们分享当年的竞赛经历和感悟。</p><p>此次招新面向全校同学，以至于会议还未开始，学术报告厅已是座无虚席。校ACM总教练杜晓宇老师以风趣幽默的演讲，为大家简单介绍了ACM作为本校一等竞赛的实力，以及建队之后取得的骄人成绩。“百词斩”CTO王波先生向同学们分享了一些参加ACM竞赛的经历，以及参加工作之后的一些人生经验。之后，由本届ACM校队学生教练文欣以及前队员彭萧同学为大家介绍了新生如何入门以及后续的培训计划。整个宣讲会也落下帷幕。</p><p><br></p><p><img src=\"http://localhost:9999/image/bfcdb483-6007-4ea3-8aa7-c68c1bf7dab5.jpg\" style=\"max-width:100%;\"><br></p><p style=\"text-align: center;\">宣讲会现场<br></p>',2,'2019-05-31 12:32:05',2,'2019-05-31 12:32:05',1,1),(5190007975145,'我校学子ACM-ICPC亚洲区域赛再创佳绩','<p>【本网讯】10月18日，第40届ACM国际大学生程序设计竞赛亚洲区域赛长春站（The 2015 ACM-ICPC Asia Changchun Regional Contest）在东北师范大学举行，从来自亚洲百余所高校的上千支队伍中脱颖而出的220支队伍，参加了该次亚洲区域赛。我校“BreadDog”代表队伍经过激烈的角逐，在该次区域赛上喜获佳绩。<br></p><p><img src=\"https://www.cuit.edu.cn/News/image/2015/10/21/%E5%9B%BE%E4%B8%80.jpg\" width=\"500\" alt=\"\"></p><p>合影</p><p>软件工程学院2013级本科生黄坤，王璨，黄宁桥组成名为“BreadDog”的参赛队伍，在ACM团队总教练杜晓宇老师的带领下，凭借扎实的编程功底、强大的心理素质和精诚合作的团队精神，经过5个小时的激烈角逐，最终代表学校获得我校在ACM-ICPC历史上的第二个亚洲区域赛铜奖，这是我校在ACM竞赛历史上的一次进步，肯定了我校在ACM-ICPC竞赛上的实力。</p><p>ACM团队欢迎对ACM竞赛感兴趣的成信学子加入进来，在来年的ACM竞赛中代表我校再创辉煌！</p><p><br></p><p>ACM-ICPC简介：</p><p>ACM国际大学生程序设计竞赛(英文全称：ACM International Collegiate Programming Contest（ACM-ICPC或ICPC）是由美国计算机协会（ACM）主办的，一项旨在展示大学生创新能力、团队精神和在压力下编写程序、分析和解决问题能力的年度竞赛。</p><p>CUIT ACM团队简介：</p><p>ACM-ICPC竞赛是学校支持的一级竞赛。学校教务处已开始重视ACM团队。2015年学校教务处将ACM-ICPC竞赛定为学校支持的一级竞赛，支持经费也逐年增加。</p><p>校ACM团队在总教练杜晓宇老师的带领下，连获佳绩，曾获亚洲区现场赛铜奖，四川省省赛金奖，以及其他奖项若干。</p><p>加入条件：有兴趣，会自学，能思考，肯坚持！</p><p>团队地点：6301A</p><p>联系方式：</p><p>QQ群：392397904&nbsp;&nbsp;</p><p>邮箱：<a href=\"mailto:acmicpc@cuit.edu.cn\">acmicpc@cuit.edu.cn</a></p><p>官网：<a href=\"http://acm.cuit.edu.cn/\">http://acm.cuit.edu.cn/</a></p><p><br></p>',2,'2019-05-29 21:16:58',2,'2019-05-29 21:16:58',1,1),(23103533601218,'测试所有功能','<p>测试</p>',2,'2019-01-21 22:30:17',2,'2019-01-21 22:30:17',1,1),(58888816835064,'1234567','<p>qwertyu</p>',2,'2019-01-22 23:28:07',2,'2019-01-22 23:28:07',1,1),(288235061461258,'阿萨德','<p>撒的</p>',2,'2019-01-21 23:00:58',2,'2019-01-21 23:00:58',1,1),(466954228002649,'12345678','<p>sdfghjkl</p>',2,'2019-01-21 23:00:00',2,'2019-01-21 23:00:00',1,1),(476745955194897,'测试','<p>框架</p>',2,'2019-01-22 21:21:58',2,'2019-01-22 21:21:58',1,1),(520587737856497,'阿斯蒂芬规划局快乐','<p>沃尔特与欧普同一人v会更好</p>',2,'2019-01-21 23:00:25',2,'2019-01-21 23:00:25',1,1),(574085881622370,'sfgh','<p>fdh</p>',2,'2019-01-19 23:21:41',2,'2019-01-19 23:21:41',0,1),(615456943753521,'我校在第8届四川省ACM大学生程序设计大赛中取得骄人成绩','<p>【本网讯】6月4日，第十届四川省大学生程序设计竞赛在西南科技大学隆重举行，本届大赛由四川省教育厅主办，西南科技大学承办。大赛参赛选手达800余人，分别来自省外的6所高校和省内的41所高校，两所中学，共计214支参赛队伍。</p><p>我校共派出6支队伍参加，经过5小时的激烈角逐，ACM校队继上月在中国大学生程序设计竞赛全国邀请赛（湖南站）首战告捷后，这次省赛中再创佳绩，取得了一金三银一铜的优异成绩，再次体现了我校ACM校队的蓬勃发展。</p><p align=\"center\"><img title=\"\" alt=\"\" src=\"https://www.cuit.edu.cn/News/image/2018/06/04/QQ%E5%9B%BE%E7%89%8720180604142307.jpg\" width=\"500\" height=\"375\"></p><p align=\"center\">参赛合影</p>',2,'2019-02-18 21:28:16',2,'2019-05-30 18:22:03',1,1),(832243484382114,'cnvb，','<p>cnvbvcnbv</p>',2,'2019-01-20 22:48:10',2,'2019-01-21 22:33:34',1,0),(918842042779163,'去问人体与','<p>微软推</p>',2,'2019-01-22 23:44:52',2,'2019-01-22 23:45:03',1,1),(1127463142849624,'gfhf','<p>dghgf</p>',2,'2019-01-19 23:22:36',2,'2019-01-19 23:22:36',0,1),(1486280699314100,'1234567','<p>我是的风格和健康</p>',2,'2019-01-22 23:17:06',2,'2019-01-22 23:17:06',1,1),(1666044887726313,'hkjl','<p>hjkl</p>',2,'2019-01-19 23:20:17',2,'2019-01-21 22:04:54',0,0),(1694761640784318,'dhdgf','<p>dghgfhd</p>',2,'2019-01-19 23:23:18',2,'2019-01-19 23:23:18',0,1),(2003718480108017,'gkgjkhj','<p>gkgkgjkhj12345678复活甲</p>',2,'2019-01-20 22:51:43',2,'2019-01-21 22:33:00',1,0),(2111629352597230,'??','<p>??</p>',4,'2019-04-18 21:36:51',4,'2019-04-18 22:02:45',1,0),(2115709589119289,'sfgh','<p>fdh</p>',2,'2019-01-19 23:21:45',2,'2019-01-19 23:21:45',0,1),(2170351519086310,'test','111',2,'2019-01-19 23:15:59',2,'2019-01-19 23:15:59',1,1),(2524757246249168,'????','<p>???</p>',2,'2019-04-18 19:07:00',4,'2019-04-18 21:33:46',1,0),(2613299761978444,'测试update','<p>测试updatedsfgdh嘻嘻</p>',2,'2019-01-20 22:43:57',2,'2019-01-21 22:25:45',1,1),(2855748976886812,'dgh','<p>dg</p>',2,'2019-01-19 23:26:12',2,'2019-01-19 23:26:12',1,1),(3157925388267298,'hkjl','<p>hjklyuio</p>',2,'2019-01-19 23:20:43',2,'2019-01-19 23:20:43',0,1),(3595350440472641,'额外热吻','<p>刚好</p>',2,'2019-01-21 23:01:22',2,'2019-01-21 23:01:29',1,1),(3609542720551855,'k;;lk;','<p>hjk</p>',2,'2019-01-19 23:23:40',2,'2019-01-19 23:23:40',0,1),(3673118662725316,'成信学子在第十届四川省ACM大学生程序设计竞赛中再创佳绩','<nav role=\"navigation\"><p>&nbsp;&nbsp;&nbsp;&nbsp;6月4日，第十届四川省大学生程序设计竞赛在西南科技大学隆重举行，本届大赛由四川省教育厅主办，西南科技大学承办。大赛参赛选手达800余人，分别来自省外的6所高校和省内的41所高校，两所中学，共计214支参赛队伍。</p><p>我校共派出6支队伍参加，经过5小时的激烈角逐，ACM校队继上月在中国大学生程序设计竞赛全国邀请赛（湖南站）首战告捷后，这次省赛中再创佳绩，取得了一金三银一铜的优异成绩，再次体现了我校ACM校队的蓬勃发展。</p><p align=\"center\"><img title=\"\" alt=\"\" src=\"https://www.cuit.edu.cn/News/image/2018/06/04/QQ%E5%9B%BE%E7%89%8720180604142307.jpg\" width=\"500\" height=\"375\"></p><p align=\"center\">参赛合影</p></nav>',2,'2019-02-18 21:26:15',2,'2019-05-30 16:24:04',1,1),(3740043760300607,'dgh','<p><br></p>',2,'2019-01-19 23:18:31',2,'2019-01-19 23:18:31',0,1),(3790048991184523,'测试add','<p>;jgkfdj你好dsj\'fgfgd</p>',2,'2019-01-20 23:13:15',2,'2019-01-21 22:01:30',1,0),(4084108371974949,'gfhf','<p>dghgf</p>',2,'2019-01-19 23:22:46',2,'2019-01-19 23:22:46',0,1),(4282146827149258,'test','111',2,'2019-01-19 23:04:10',2,'2019-01-19 23:04:10',1,1),(4722741468344091,'???','<p>???</p>',4,'2019-04-18 21:52:26',4,'2019-04-18 22:02:42',1,0),(5000001760903345,'test','111',2,'2019-01-19 22:58:18',2,'2019-01-19 22:58:18',1,1),(5147863460501022,'kl;\'','<p>kl;\'lk;\'<span style=\"text-decoration-line: underline;\"></span></p>',2,'2019-01-19 23:25:41',2,'2019-01-21 22:33:38',0,0),(5587044386368135,'234567','<p>123456789</p>',2,'2019-01-22 23:02:52',2,'2019-01-22 23:02:52',1,1),(5892677681313045,'减肥的','<p>刚发的</p>',2,'2019-01-21 22:58:14',2,'2019-01-21 22:58:14',1,1),(6036210639757074,'??','<p>??</p>',4,'2019-04-18 21:33:56',4,'2019-04-18 22:02:48',1,0),(6087502645468537,'dgh','<p>hfhg</p>',2,'2019-01-19 23:19:27',2,'2019-01-19 23:19:27',0,1),(6799851663161896,'1234567','<p>qwertyui</p>',2,'2019-01-22 23:09:07',2,'2019-01-22 23:09:07',1,1),(7069976714793927,'我校学子ACM-ICPC亚洲区域赛首站再创佳绩','<p>10月14日，第43届ACM—ICPC国际大学生程序设计竞赛亚洲区域赛南京站的比赛在南京航空航天大学举办。来自全国186所高校的共计310支参赛队伍齐聚一堂，参加了该次亚洲区域赛。</p><p>ACM校队学生袁曦焜、林湖龙、谢仁义三人组成的参赛队伍，凭借扎实的编程功底、强大的心理素质和精诚合作的团队精神，经过5个小时的激烈角逐，在该次区域赛上喜获佳绩，最终为我校斩获一枚银奖，再次证明了我校ACM校队在ACM-ICPC竞赛上的实力。这是该赛事的第一站，队员们也将继续努力，在接下来的各赛站中力争取得更好的成绩。</p><p><img src=\"http://localhost:9999/image/314182f0-ecfd-4675-9838-5ced687d9a64.jpg\" style=\"max-width:100%;\"><br></p>',4,'2019-04-18 22:06:50',4,'2019-04-18 22:06:50',1,1),(7086654937396236,'dgh','<p>hfhg</p>',2,'2019-01-19 23:19:38',2,'2019-01-19 23:19:38',0,1),(7180713708457525,'qwertyu','<p>wertyui</p>',2,'2019-01-22 23:41:55',2,'2019-01-22 23:42:35',1,1),(7207239899042788,'这是目录','<p>去微软推</p>',2,'2019-01-23 21:59:55',2,'2019-01-23 22:00:07',1,1),(7897649342249505,'kl;\'','<p>kl;\'lk;\'<span style=\"text-decoration-line: underline;\"></span></p>',2,'2019-01-19 23:25:55',2,'2019-01-19 23:25:55',0,1),(8000001278093941,'test','111',2,'2019-01-19 23:02:43',2,'2019-01-19 23:02:43',1,1),(8306185870253192,'我校团队2017年第42届ACM国际大学生程序设计竞赛亚洲区域赛(青岛站)斩获金牌','<p>【本网讯】11月5日，2017年第42届ACM国际大学生程序设计竞赛亚洲区域赛(青岛站)在中国石油大学（华东）落下帷幕。来自225所高校的365支参赛队伍1095名程序设计精英们齐聚一堂。我校软件工程学院教师张海清带队，学生陈啸宇、寇寅、唐俊组成的“火锅底料”队伍，经过5个小时的激烈角逐，最终从百余所高校中脱颖而出，斩获金牌。由此，我校ACM代表队在2017年ACM-ICPC亚洲区域赛和中国大学生程序设计大赛中已连续获得1枚金牌、2枚银奖和2枚铜奖。&nbsp;&nbsp;</p><p>经过40多年的发展，ACM国际大学生程序设计竞赛已经发展成为较具影响力的大学生计算机竞赛，被誉为计算机软件领域的奥林匹克竞赛。比赛注重创新精神和团队精神，着重考察参赛队员的逻辑分析能力、团队协作能力、策略制定能力。为大学生提供了一个展示和提高自我解题与编程能力的机会，同时也为学生编程爱好者提供了一个交流学术和增进友谊的平台。&nbsp;</p><p align=\"center\"><img alt=\"\" src=\"https://www.cuit.edu.cn/News/image/2017/11/06/11_1_%E5%89%AF%E6%9C%AC_1.jpg\"></p><p align=\"center\">合影</p>',2,'2019-05-22 13:31:02',2,'2019-05-30 16:15:19',1,1),(8507358794497788,'test','111',2,'2019-01-19 23:16:58',2,'2019-01-19 23:16:58',1,1),(8602343863622932,'萨达','<p>萨达</p>',2,'2019-01-21 23:01:55',2,'2019-01-21 23:01:55',1,1),(8729990684056559,'12345678','<p>微软体育</p>',2,'2019-01-22 23:48:43',2,'2019-01-22 23:49:09',1,1),(8749517125875989,'1234567','<p>qwertyui</p>',2,'2019-01-22 23:08:26',2,'2019-01-22 23:08:26',1,1),(9428232542528741,'哈哈哈哈','<p>哈哈哈哈</p>',4,'2019-04-18 22:01:46',4,'2019-04-18 22:01:46',1,0),(9449032646433144,'西瓜瓜皮','<p>嘿嘿 二狗z真可爱</p>',2,'2019-01-21 22:49:15',2,'2019-01-21 22:49:15',1,0),(9657152853485864,'???','<p>???</p>',4,'2019-04-18 21:52:21',4,'2019-04-18 22:02:44',1,0),(9715244296908737,'dhdgf','<p>dghgfhd</p>',2,'2019-01-19 23:23:20',2,'2019-01-19 23:23:20',0,0),(9861521129611960,'如题所示','<p>测试功能<img src=\"http://localhost:9999/image/854fcef4-b26d-432e-9615-4ac43bc86f48.png\" style=\"max-width: 100%;\"></p>',2,'2019-01-21 22:32:01',2,'2019-01-21 22:32:48',1,0),(9983416287760015,'1234567','<p>qwertyu</p>',2,'2019-01-22 23:27:46',2,'2019-01-22 23:27:46',1,0);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` bigint(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `classNum` int(11) DEFAULT '0',
  `grade` int(11) DEFAULT '0',
  `mobile` varchar(20) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `studentId` bigint(20) DEFAULT NULL,
  `createDay` datetime DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `auth` int(11) DEFAULT NULL,
  `isEffective` int(11) DEFAULT NULL,
  `unionid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'olD4e0x14bo2CRMHAJiNgweDKaG4','xgg','123456',4,2015,'17716164149','官怡婷',2015081131,'2019-01-13 15:31:06','https://wx.qlogo.cn/mmopen/vi_32/gGaS4NuTZnOqKMwStcP7qJNc6HClFr3yqnhRicMcs3p8kLGnicQWJfoephcAfmtRlwqzapZDukQiaPEWpbkK9Ls2Q/132',5,1,NULL),(4,NULL,'hushan','123456',4,2045,'17716164149','xgg',2015081147,'2019-01-23 22:55:53','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epz9PwQsOXHtzWibXZxoAtSNz47O96POdP3tg2pkDRHCdDExH8qOIia5QONCfebaENXJLxBlsEVpUfg/132',1,1,NULL),(5,'olD4e0x14bo2CRMHAJiNgweDKaG4','gytt','1234567',4,2016,'17716164896','二狗狗',2015081136,'2019-04-16 17:02:37','http://thirdwx.qlogo.cn/mmopen/vi_32/TVAicR3KQSMfNBX0j4uJibQfZhribgx3sAn7sztUItwDFhmZMdz1NuBW73qR4bjAOxNntxZWQOKm6k2nxo6icHW27A/132',0,1,NULL),(6,'','ost','123456',5,2015,'18783846577','小西瓜',2015081147,'2019-04-17 19:26:37','https://wx.qlogo.cn/mmopen/vi_32/gGaS4NuTZnOqKMwStcP7qJNc6HClFr3yqnhRicMcs3p8kLGnicQWJfoephcAfmtRlwqzapZDukQiaPEWpbkK9Ls2Q/132',0,1,'oecPH5UwkCsG2x9eAMTGecfaX_hw'),(7,NULL,NULL,NULL,0,0,NULL,'哈哈哈',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 15:03:36
