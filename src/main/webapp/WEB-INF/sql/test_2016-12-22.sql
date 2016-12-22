# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: test
# Generation Time: 2016-12-22 09:46:04 +0000
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


# Dump of table city
# ------------------------------------------------------------

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `countryid` int(11) NOT NULL,
  `provinceid` int(11) NOT NULL,
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;

INSERT INTO `city` (`id`, `countryid`, `provinceid`, `name`)
VALUES
	(1,1,1,'海口市'),
	(2,1,1,'文昌市');

/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table country
# ------------------------------------------------------------

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;

INSERT INTO `country` (`id`, `name`)
VALUES
	(1,'中国'),
	(2,'美国');

/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table news
# ------------------------------------------------------------

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `imgsrc` varchar(128) DEFAULT NULL,
  `bigid` int(11) NOT NULL,
  `smallid` int(11) DEFAULT NULL,
  `content` text,
  `desc` varchar(564) NOT NULL DEFAULT '',
  `hit` int(11) NOT NULL,
  `recommend` bit(1) NOT NULL DEFAULT b'0',
  `pdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;

INSERT INTO `news` (`id`, `title`, `imgsrc`, `bigid`, `smallid`, `content`, `desc`, `hit`, `recommend`, `pdate`)
VALUES
	(1,'屎盆子扣头事件！孩子应激障碍的易感因素分析 ','',3,4,'<p>急性应激反应是什么意思呢？在临床上又称为急性应激障碍。以急剧超强的精神创伤作为直接原因，可出现意识障碍、情感障碍等心理反应，通常在一周内缓解。</p>\r\n\r\n<p>回顾事件过程，被一个垃圾筐砸头，擦屎和尿的纸洒满一身，这样的剧烈刺激确实非一个10岁孩童心理所能够承受。</p>\r\n\r\n<p>但作为家长，我们在指责校园欺凌事件的同时，可能也需要反思一下，除了反对校园欺凌，保护孩子免受伤害，还可以做些什么为孩子的心理打一预防针？万一哪天孩子遇到一些非人为的意外刺激，那又该如何避免孩子出现应激障碍？</p>\r\n\r\n<p>事实上，临床心理学研究发现，并非每一个遇到重大创伤刺激的人都会出现应激障碍。创伤性事件发生之后，是否会发展成创伤后应激障碍（PTSD）与个体的认知模式有关系。研究发现，容易造成PTSD的认知模式主要有四种：消极的归因方式、穷思竭虑、焦虑敏感性和隐性认知风格。</p>\r\n\r\n<h1>消极的归因方式</h1>\r\n\r\n<p>归因是指对事件发生原因的解释。把负性事件归因为内部的（是我的错），稳定的（一直都这样），普遍的（在哪里都这样）被称为消极的归因方式。如果一个人长期用消极的归因方式解释发生在自己身上的负性事件，就会形成无望感。当一个人毫无希望便会抑郁。</p>\r\n\r\n<p>所以家长们平时在生活中应该有意识地给孩子进行归因训练，帮助孩子形成积极的归因风格。假如不幸遭遇欺凌事件，家长应该告诉孩子，这不是孩子的错（归因为外部因素）。这个事情是可以改变的，孩子要勇敢地拒绝（归因为不稳定的、可控的）。积极的归因风格能够帮助孩子在遭遇负性事件时不被击垮，成为孩子的&ldquo;护心符&rdquo;。</p>\r\n\r\n<h1>穷思竭虑</h1>\r\n\r\n<p>穷思竭虑也叫反刍心理，是指沉浸在对某件事件过多的思虑当中。穷思竭虑的特点是只关注原因或者后果，而不关注如何应对。就好比一个人生病，整天只想着为什么自己会得这个病以及得了这个病会有什么样的后果，却不思考如何积极地治疗。这种过度的思考和纠结会加深创伤带来的痛苦，还会把痛苦一直延续下去。在低落的情绪之中，当事人越是思考，越想不通，从而陷入恶性循环。</p>\r\n\r\n<p>如果发现孩子陷入了对创伤的反复回忆反复思考，家长就需要用各种事情把孩子的注意力转移出来。给孩子安排一些与创伤无关的事情，最好是需要注意力非常集中的，让孩子把思绪抽回到现实。</p>\r\n\r\n<h1>焦虑敏感性</h1>\r\n\r\n<p>当我们感到焦虑，我们可能会有心跳加速、手心冒汗、喉咙发干等感觉。而有些人对这些感觉特别敏感并且认为这些感觉是危险的，这就是高焦虑敏感性。创伤发生，必然会引起焦虑，如果对焦虑特别敏感，可能会引发更严重的心理反应，导致PTSD。</p>\r\n\r\n<p>如果孩子遭遇创伤，家长就要密切关注孩子的情绪反应。若发现孩子呼吸加快，身体僵硬，说明孩子十分焦虑。家长可以温柔地抱抱孩子，轻缓地拍拍孩子，告诉孩子爸爸妈妈看到你现在有点焦虑，这是正常的反应，不用担心。然后陪伴孩子平复下来。</p>\r\n\r\n<h1>隐性认知风格</h1>\r\n\r\n<p>隐性认知风格是指个体对于环境中潜在危险过分敏感，会夸大危险的程度，从而产生焦虑。简单来说就是杯弓蛇影、草木皆兵。隐性认知风格的形成跟自信程度和过往经历有关。例如，一个孩子在学校里被同学排挤、欺负，他可能走在路上都会很害怕身后晃过的人影，他会担心突然哪个谁会跑出来把他推倒在地。所以像校园欺凌这种长期对个人的打击影响是非常深远，会直接改变人的认知模式。</p>\r\n\r\n<p>最后，孩子遇到创伤，家庭必须保持冷静。孩子对待事情的态度取决于家长的态度，如果家长惊慌失措或是非常愤怒，都会让孩子加重对事情的严重程度的评估，加深孩子的受伤程度。学校是社会的缩影，霸凌是权力压迫的缩影，在现代社会大丛林中，也许谁都很难幸免。如果改变不了外界，不如先锻炼自己。</p>\r\n','2016年12月，就读于中关村二小的斌斌（化名）被同学扔厕所垃圾筐，尿和擦过屎的纸洒了孩子一身。事件中，孩子出现情绪低落、易激惹、失眠、惊醒，导致一个孩子中度焦虑、重度抑郁，诊断急性应激反应——急性心因性抑郁状态。',0,00000001,'2016-12-21 11:28:07'),
	(2,'作为心理老师，我是这样处理校园欺凌事件的','/myweb//uploadfiles/efe-700x389.png',1,2,'<p>&ldquo;有时候，校园比社会更残酷，因为那是一群有破坏力而无容忍度的少年。&rdquo; 最近，一篇北京中关村二小校园欺凌事件的帖子火遍了朋友圈，事件中家长质疑学校不作为，老师把如此恶劣的事件定义为&ldquo;过分的玩笑&rdquo;更是引发热议。事实上，在众多的校园欺凌事件中，我们常常发现作为第一责任的学校多数帮不上忙。有人说，学校怕担责，宁可大事化小。也有人说，老师太忙，对学生之间的纷争很难全部关注到。还有人说，过度惩罚只会惹来施暴学生的报复，不利于解决冲突。<br />\r\nefe<br />\r\n这些声音让我想起了，我在网瘾学校当心理老师的时候跟凌霸学生斗智斗勇的故事。<br />\r\n回忆中的少年<br />\r\n在我们学校，招收的都是家长搞不定的不良少年，他们大多不上学，天天在街上游荡，打架斗殴是他们的家常便饭。而小斌算是一个例外。从读书开始，小斌就一直是老师眼中的好学生，他的成绩永远排在班上的前几名。由于聪明，加上家里对学习的重视，总是请补习老师提前把知识教给他，小斌的好成绩得来相当轻松。于是他以为，自己可以不需要用功而一直优秀下去。然而，高中的到来把小斌的美好算盘全打乱了。学习习惯不好，他的成绩渐渐跟不上。一向自负的小斌无法接受成为差生的现实，他开始借网络逃避。最终，他成了网瘾少年，来到了我们学校。<br />\r\n&ldquo;与众不同&rdquo;后的遭遇<br />\r\n长期的好学生身份，让小斌跟其他同学显得不太一样。他喜欢跟老师交流，经常主动要求做老师的帮手。因此所有老师都很喜欢小斌，把很多重要的班级事务都交给小斌。结果，却惹来其他同学的嫉妒和怨恨，小斌成了同学眼中的马屁精。渐渐，班级里出现了一种敏感的氛围。每当老师表扬小斌的时候，其他同学就会嘲讽、讥笑他。尤其在私下，以阿朗为首的几个男生组成的小团体把欺负小斌当做每日必做之事。阿朗是一个表面阳光，内心阴暗的男孩。他长相帅气，运动出众，谈起话来不表露任何情绪。阿朗很有领导才能，到哪都是个小头头。关键是，他非常聪明，干坏事从不留下什么小尾巴。<br />\r\n&ldquo;炸死&rdquo;他们！ 自己&ldquo;跳下去&rdquo;<br />\r\n班里的对小斌的欺凌事件越演越烈，从孤立、冷落到嘲讽、辱骂，甚至拳打脚踢。有一次，一个同学趁小斌不注意，把一只死蟑螂放进了小斌的茶杯。还有一次，一个同学在小斌洗澡的时候，拿洁厕精对着小斌从头往下浇&hellip;&hellip;这一切，是小斌在心理咨询室里告诉我的。面对欺凌，小斌很愤怒也很痛苦。他告诉我，自己不想违反校规，不想让老师失望，但是他无法忍受这样的侮辱。在欺凌最严重的时候，小斌说，他时常幻想着&ldquo;炸死&rdquo;那些同学，也幻想着从楼上&ldquo;跳下去&rdquo;。作为小斌的心理老师兼班主任，我必须要帮助他。<br />\r\n与学生斗智斗勇<br />\r\n但是，欺凌行为是一个老师很不好处理的问题。首先，它具有隐蔽性。老师即使24小时监管，学生们总是会找到机会使坏。其次，它具有报复性。老师越是去批评欺负人的学生，那些学生就越怨恨被欺负者，从而进行加倍的欺凌。面对如此棘手的问题，作为老师只得跟学生斗智斗勇。<br />\r\n一方面，我帮助小斌宣泄他的情绪，避免激烈冲突发生。我站在受欺负者的角度去理解小斌的痛苦，聆听他诉说他的烦恼。我告诉他，他不是一个人，老师也是过来人，也经历过相似的烦恼，但是最终走过来了，变得更坚强。然后，我请体能老师给小斌做特训，教他擒敌拳。还特意在全班同学都看到的情况下训练，展示小斌的力量。然后，我给小斌防卫的权力，如果是对方无故挑衅，他动手可以不受惩罚。<br />\r\n另一方面，我尝试瓦解挑事的小团体，削弱阿朗的影响力。有一次，那几个男生违反了校规，在秋后算账的时候，我单独找他们谈话。我让他们自己去描述事情的经过，然后在分别谈话中透露他们互相推诿的部分。最后给予他们重罚，唯独对阿朗给了很轻的惩罚。同时，我做了一次班级的心理游戏活动。收集了一些赞美的词语和辱骂的词语，让每个同学轮流站在全班同学面前，接受一次赞美轰炸和辱骂轰炸。让他们自己去体会话语的力量，知道被侮辱是种什么感受。<br />\r\n自信与成长<br />\r\n经过多种努力，班里的欺凌现象终于有所收敛了。小斌也慢慢找回了自己的自信，学会了自己去处理人际交往上的烦恼。作为老师，很庆幸这样的经历没有对他造成心理上的阴影，反而促成了他的成长。<br />\r\n反思<br />\r\n我在处理欺凌问题的时候，有很多做法是&ldquo;违规&rdquo;的。例如我给了受害学生防卫的权利，变相在鼓励他们打架。例如我在惩罚的时候，为了挑拨挑事学生的小团体，没有做到一视同仁。我不知道作为一个老师玩&ldquo;心计&rdquo;对不对。但在处罚无效的情况之下，这是我能做的最有效的选择。</p>\r\n','我在处理欺凌问题的时候，有很多做法是“违规”的。我给了受害学生防卫的权利，变相在鼓励他们打架。我在惩罚的时候，为了挑拨挑事学生的小团体，没有做到一视同仁。我不知道作为一个老师玩“心计”对不对。但这是我能做的最有效的选择。',0,00000000,'2016-12-21 16:20:29');

/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orgtype
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orgtype`;

CREATE TABLE `orgtype` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `orgtype` WRITE;
/*!40000 ALTER TABLE `orgtype` DISABLE KEYS */;

INSERT INTO `orgtype` (`id`, `name`)
VALUES
	(1,'启蒙'),
	(2,'益智'),
	(3,'情商'),
	(4,'运动'),
	(5,'才艺'),
	(6,'语言'),
	(7,'父母教育'),
	(8,'幼儿园');

/*!40000 ALTER TABLE `orgtype` ENABLE KEYS */;
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


# Dump of table province
# ------------------------------------------------------------

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `countryid` int(11) NOT NULL,
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;

INSERT INTO `province` (`id`, `countryid`, `name`)
VALUES
	(1,1,'海南省');

/*!40000 ALTER TABLE `province` ENABLE KEYS */;
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
	(54,53,'news','add','添加',00000000,0),
	(55,53,'news','list','列表',00000001,0),
	(56,0,'category','','XX2管理',00000000,0),
	(57,56,'category','list','列表',00000001,0),
	(58,56,'category','add','添加',00000000,0),
	(59,56,'category','json','json',00000000,0),
	(60,0,'country','','国家管理',00000000,0),
	(61,60,'country','list','列表',00000001,0),
	(62,60,'country','add','添加',00000000,0),
	(63,60,'country','edit','修改',00000000,0),
	(64,0,'province','','省份管理',00000000,0),
	(65,64,'province','list','列表',00000001,0),
	(66,64,'province','add','添加',00000000,0),
	(67,64,'province','edit','修改',00000000,0),
	(68,0,'city','','城市管理',00000000,0),
	(69,68,'city','list','列表',00000001,0),
	(70,68,'city','add','添加',00000000,0),
	(71,68,'city','edit','修改',00000000,0),
	(72,64,'province','json','ajax_json',00000000,0),
	(73,0,'orgtype','','机构类型',00000000,0),
	(74,73,'orgtype','list','列表',00000001,0),
	(75,73,'orgtype','add','添加',00000000,0),
	(76,73,'orgtype','edit','修改',00000000,0),
	(77,0,'organization','','机构管理',00000000,0),
	(78,77,'organization','list','列表',00000001,0),
	(79,77,'organization','add','添加',00000000,0),
	(80,77,'organization','edit','编辑',00000000,0);

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
	(1,1,1,'3,12,13,14,5,6,15,22,23,24,26,54,55,57,58,59,61,62,63,65,66,67,72,69,70,71,74,75,76,78,79,80'),
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




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
