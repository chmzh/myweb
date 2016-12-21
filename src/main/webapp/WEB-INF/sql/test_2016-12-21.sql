# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: test
# Generation Time: 2016-12-21 03:55:04 +0000
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

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;

INSERT INTO `category` (`id`, `parentid`, `name`)
VALUES
	(1,0,'xx'),
	(2,1,'xx1'),
	(3,0,'xx1'),
	(4,3,'xx11');

/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table news
# ------------------------------------------------------------

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `bigid` int(11) NOT NULL,
  `smallid` int(11) DEFAULT NULL,
  `content` text,
  `desc` varchar(564) NOT NULL DEFAULT '',
  `hit` int(11) NOT NULL,
  `pdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;

INSERT INTO `news` (`id`, `title`, `bigid`, `smallid`, `content`, `desc`, `hit`, `pdate`)
VALUES
	(1,'屎盆子扣头事件！孩子应激障碍的易感因素分析 ',3,4,'<p>急性应激反应是什么意思呢？在临床上又称为急性应激障碍。以急剧超强的精神创伤作为直接原因，可出现意识障碍、情感障碍等心理反应，通常在一周内缓解。</p>\r\n\r\n<p>回顾事件过程，被一个垃圾筐砸头，擦屎和尿的纸洒满一身，这样的剧烈刺激确实非一个10岁孩童心理所能够承受。</p>\r\n\r\n<p>但作为家长，我们在指责校园欺凌事件的同时，可能也需要反思一下，除了反对校园欺凌，保护孩子免受伤害，还可以做些什么为孩子的心理打一预防针？万一哪天孩子遇到一些非人为的意外刺激，那又该如何避免孩子出现应激障碍？</p>\r\n\r\n<p>事实上，临床心理学研究发现，并非每一个遇到重大创伤刺激的人都会出现应激障碍。创伤性事件发生之后，是否会发展成创伤后应激障碍（PTSD）与个体的认知模式有关系。研究发现，容易造成PTSD的认知模式主要有四种：消极的归因方式、穷思竭虑、焦虑敏感性和隐性认知风格。</p>\r\n\r\n<h1>消极的归因方式</h1>\r\n\r\n<p>归因是指对事件发生原因的解释。把负性事件归因为内部的（是我的错），稳定的（一直都这样），普遍的（在哪里都这样）被称为消极的归因方式。如果一个人长期用消极的归因方式解释发生在自己身上的负性事件，就会形成无望感。当一个人毫无希望便会抑郁。</p>\r\n\r\n<p>所以家长们平时在生活中应该有意识地给孩子进行归因训练，帮助孩子形成积极的归因风格。假如不幸遭遇欺凌事件，家长应该告诉孩子，这不是孩子的错（归因为外部因素）。这个事情是可以改变的，孩子要勇敢地拒绝（归因为不稳定的、可控的）。积极的归因风格能够帮助孩子在遭遇负性事件时不被击垮，成为孩子的&ldquo;护心符&rdquo;。</p>\r\n\r\n<h1>穷思竭虑</h1>\r\n\r\n<p>穷思竭虑也叫反刍心理，是指沉浸在对某件事件过多的思虑当中。穷思竭虑的特点是只关注原因或者后果，而不关注如何应对。就好比一个人生病，整天只想着为什么自己会得这个病以及得了这个病会有什么样的后果，却不思考如何积极地治疗。这种过度的思考和纠结会加深创伤带来的痛苦，还会把痛苦一直延续下去。在低落的情绪之中，当事人越是思考，越想不通，从而陷入恶性循环。</p>\r\n\r\n<p>如果发现孩子陷入了对创伤的反复回忆反复思考，家长就需要用各种事情把孩子的注意力转移出来。给孩子安排一些与创伤无关的事情，最好是需要注意力非常集中的，让孩子把思绪抽回到现实。</p>\r\n\r\n<h1>焦虑敏感性</h1>\r\n\r\n<p>当我们感到焦虑，我们可能会有心跳加速、手心冒汗、喉咙发干等感觉。而有些人对这些感觉特别敏感并且认为这些感觉是危险的，这就是高焦虑敏感性。创伤发生，必然会引起焦虑，如果对焦虑特别敏感，可能会引发更严重的心理反应，导致PTSD。</p>\r\n\r\n<p>如果孩子遭遇创伤，家长就要密切关注孩子的情绪反应。若发现孩子呼吸加快，身体僵硬，说明孩子十分焦虑。家长可以温柔地抱抱孩子，轻缓地拍拍孩子，告诉孩子爸爸妈妈看到你现在有点焦虑，这是正常的反应，不用担心。然后陪伴孩子平复下来。</p>\r\n\r\n<h1>隐性认知风格</h1>\r\n\r\n<p>隐性认知风格是指个体对于环境中潜在危险过分敏感，会夸大危险的程度，从而产生焦虑。简单来说就是杯弓蛇影、草木皆兵。隐性认知风格的形成跟自信程度和过往经历有关。例如，一个孩子在学校里被同学排挤、欺负，他可能走在路上都会很害怕身后晃过的人影，他会担心突然哪个谁会跑出来把他推倒在地。所以像校园欺凌这种长期对个人的打击影响是非常深远，会直接改变人的认知模式。</p>\r\n\r\n<p>最后，孩子遇到创伤，家庭必须保持冷静。孩子对待事情的态度取决于家长的态度，如果家长惊慌失措或是非常愤怒，都会让孩子加重对事情的严重程度的评估，加深孩子的受伤程度。学校是社会的缩影，霸凌是权力压迫的缩影，在现代社会大丛林中，也许谁都很难幸免。如果改变不了外界，不如先锻炼自己。</p>\r\n','2016年12月，就读于中关村二小的斌斌（化名）被同学扔厕所垃圾筐，尿和擦过屎的纸洒了孩子一身。事件中，孩子出现情绪低落、易激惹、失眠、惊醒，导致一个孩子中度焦虑、重度抑郁，诊断急性应激反应——急性心因性抑郁状态。',0,'2016-12-21 11:28:07');

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
	(55,53,'news','list','列表',00000001,0),
	(56,0,'category','','XX2管理',00000000,0),
	(57,56,'category','list','列表',00000001,0),
	(58,56,'category','add','添加',00000000,0),
	(59,56,'category','json','json',00000000,0);

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
	(1,1,1,'3,12,13,14,5,6,15,22,23,24,26,28,29,30,32,33,34,35,37,38,39,41,42,43,45,46,47,48,54,57,58,59'),
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
