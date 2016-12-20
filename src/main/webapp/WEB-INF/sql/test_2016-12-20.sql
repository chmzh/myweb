# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: test
# Generation Time: 2016-12-20 08:54:51 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table news
# ------------------------------------------------------------

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `content` text,
  `pdate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;

INSERT INTO `news` (`id`, `title`, `content`, `pdate`)
VALUES
	(2,'标题1','<p>内容1<img alt=\"laugh\" src=\"http://localhost:8080/myweb/assets/ckeditor/plugins/smiley/images/teeth_smile.png\" style=\"height:23px; width:23px\" title=\"laugh\" /></p>\r\n','0000-00-00 00:00:00'),
	(3,'标题1','<p>内容1<img alt=\"laugh\" src=\"http://localhost:8080/myweb/assets/ckeditor/plugins/smiley/images/teeth_smile.png\" style=\"height:23px; width:23px\" title=\"laugh\" /></p>\r\n\r\n<p><img alt=\"\" src=\"/myweb//uploadfiles/common_btn_ok_3.png\" style=\"height:33px; width:99px\" /></p>\r\n\r\n<p>完成！</p>\r\n','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table produce
# ------------------------------------------------------------

DROP TABLE IF EXISTS `produce`;

CREATE TABLE `produce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `produce` WRITE;
/*!40000 ALTER TABLE `produce` DISABLE KEYS */;

INSERT INTO `produce` (`id`, `name`)
VALUES
	(1,'测试12'),
	(2,'测试2');

/*!40000 ALTER TABLE `produce` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table schema
# ------------------------------------------------------------

DROP TABLE IF EXISTS `schema`;

CREATE TABLE `schema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `produceid` int(11) NOT NULL,
  `power` text NOT NULL,
  `des` varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `schema` WRITE;
/*!40000 ALTER TABLE `schema` DISABLE KEYS */;

INSERT INTO `schema` (`id`, `name`, `produceid`, `power`, `des`)
VALUES
	(4,'用户组1',1,'50','用户组1');

/*!40000 ALTER TABLE `schema` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NOT NULL DEFAULT '0',
  `model` varchar(64) NOT NULL DEFAULT '',
  `action` varchar(64) NOT NULL DEFAULT '',
  `name` varchar(64) NOT NULL DEFAULT '',
  `visible` bit(1) NOT NULL DEFAULT b'0',
  `ctype` tinyint(3) NOT NULL COMMENT '0:系统相关，1:游戏相关',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;

INSERT INTO `sys_menu` (`id`, `parentid`, `model`, `action`, `name`, `visible`, `ctype`)
VALUES
	(2,0,'user','','用户管理',00000000,0),
	(3,2,'','list','用户列表',00000001,0),
	(4,0,'sysmenu','','菜单管理',00000000,0),
	(5,4,'','list','菜单列表',00000001,0),
	(6,4,'','edit','修改菜单',00000000,0),
	(7,0,'game','','游戏管理',00000000,0),
	(8,0,'log','','日志管理',00000000,0),
	(9,0,'resource','','资源管理',00000000,0),
	(12,2,'','add','添加用户',00000000,0),
	(13,2,'','edit','编辑用户',00000000,0),
	(14,2,'','power','权限管理',00000000,0),
	(15,4,'','add','添加菜单',00000000,0),
	(16,0,'group','','组管理',00000000,0),
	(17,16,'','list','组列表',00000001,0),
	(18,16,'','add','添加组',00000000,0),
	(19,16,'','edit','编辑组',00000000,0),
	(20,16,'','power','组权限管理',00000000,0),
	(21,0,'schema','','架构管理',00000000,0),
	(22,21,'schema','list','架构列表',00000001,0),
	(23,21,'schema','add','添加架构',00000000,0),
	(24,21,'schema','edit','编辑架构',00000000,0),
	(26,21,'schema','binduser','绑定用户',00000000,0),
	(27,0,'log','','日志管理',00000000,0),
	(28,27,'log','list','日志列表',00000001,0),
	(29,27,'log','add','添加日志',00000000,0),
	(30,27,'log','edit','编辑日志',00000000,0),
	(31,0,'game','','游戏管理',00000000,0),
	(32,31,'game','list','游戏列表',00000001,0),
	(33,31,'game','add','添加游戏',00000000,0),
	(34,31,'game','edit','编辑游戏',00000000,0),
	(35,31,'game','hive','生成hive映射',00000000,0),
	(36,0,'gamepartner','','运营商管理',00000000,0),
	(37,36,'gamepartner','list','运营商列表',00000001,0),
	(38,36,'gamepartner','add','添加运营商',00000000,0),
	(39,36,'gamepartner','edit','编辑运营商',00000000,0),
	(40,0,'gameserver','','游戏服管理',00000000,0),
	(41,40,'gameserver','list','游戏服列表',00000001,0),
	(42,40,'gameserver','add','添加游戏服',00000000,0),
	(43,40,'gameserver','edit','编辑游戏服',00000000,0),
	(44,0,'statistic','','统计任务',00000000,0),
	(45,44,'statistic','list','任务列表',00000001,0),
	(46,44,'statistic','add','添加任务',00000000,0),
	(47,44,'statistic','edit','编辑任务',00000000,0),
	(48,44,'statistic','selgid','选择游戏',00000000,0),
	(49,0,'statpay','','充值统计',00000000,0),
	(50,49,'statpay','info','充值收入',00000001,0),
	(51,0,'userlogin','','用户存留',00000000,0),
	(52,51,'userlogin','list','90天存留',00000001,0),
	(53,0,'news','','XX1管理',00000000,0),
	(54,53,'news','add','添加',00000001,0),
	(55,53,'news','list','列表',00000001,0);

/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(128) NOT NULL DEFAULT '',
  `pwd` char(32) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL,
  `qq` varchar(64) NOT NULL DEFAULT '',
  `lastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `groupid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `iuname` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `uname`, `pwd`, `enabled`, `qq`, `lastTime`, `groupid`)
VALUES
	(1,'cndw','e10adc3949ba59abbe56e057f20f883e',0,'','2016-12-08 10:49:26',0);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_power
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_power`;

CREATE TABLE `user_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `produceid` int(11) NOT NULL,
  `powers` text,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_power` WRITE;
/*!40000 ALTER TABLE `user_power` DISABLE KEYS */;

INSERT INTO `user_power` (`id`, `userid`, `produceid`, `powers`)
VALUES
	(1,1,1,'3,12,13,14,5,6,15,22,23,24,26,28,29,30,32,33,34,35,37,38,39,41,42,43,45,46,47,48,54'),
	(2,1,0,'3,12,13,14,5,6,15,22,23,24,26,28,29,30,32,33,34,35,37,38,39,41,42,43,45,46,47,48,50');

/*!40000 ALTER TABLE `user_power` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_schema
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_schema`;

CREATE TABLE `user_schema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `schemaid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_schema` WRITE;
/*!40000 ALTER TABLE `user_schema` DISABLE KEYS */;

INSERT INTO `user_schema` (`id`, `userid`, `schemaid`)
VALUES
	(1,1,4);

/*!40000 ALTER TABLE `user_schema` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
