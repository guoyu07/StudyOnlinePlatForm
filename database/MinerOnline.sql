/*
Navicat MySQL Data Transfer

Source Server         : jack2
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : mineronline

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-04-26 10:06:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_info`
-- ----------------------------
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info` (
  `Account_Info_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(30) DEFAULT NULL,
  `Gender` enum('保密','女','男') DEFAULT NULL,
  `PhoneNum` varchar(20) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `SchoolName` varchar(30) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Profile` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `Avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`Account_Info_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_info
-- ----------------------------
INSERT INTO `account_info` VALUES ('85', '胡上杰', null, null, null, null, null, '江西赣州', null, null);
INSERT INTO `account_info` VALUES ('86', '张百磊', null, null, null, null, null, '江西吉安', null, null);
INSERT INTO `account_info` VALUES ('87', '葛炳生', null, null, null, null, null, 'jxufe', null, null);
INSERT INTO `account_info` VALUES ('88', '张杰', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('89', '蒋含明', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('90', '周义明', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('91', '周义明', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('92', '张小俊', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('93', '梁红', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('94', '梁红', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('95', '超鸿燕', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('96', '王善论', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('97', '周义明', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('98', '周义明', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('99', '刘春兰', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('100', '刘春兰', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('101', '刘春兰', null, '458984949', null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('102', '刘春兰', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('103', '哦品牌', null, '12346894', null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('104', 'utah', null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('105', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('106', null, null, null, null, '2017-04-26', null, null, null, null);
INSERT INTO `account_info` VALUES ('107', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('108', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('109', null, null, null, null, '2017-04-05', null, null, null, null);
INSERT INTO `account_info` VALUES ('110', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('111', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('112', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('113', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('114', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('115', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('116', null, null, null, null, null, null, null, null, null);
INSERT INTO `account_info` VALUES ('117', '胡上杰', '男', '4989756516', '9797856546@qq.com', '3895-06-30', '财经大学', '云南大理', '我是葛炳生', '葛炳生的头像');
INSERT INTO `account_info` VALUES ('118', '胡上杰', '男', '4989756516', '9797856546@qq.com', '3895-06-30', '财经大学', '云南大理', '我是葛炳生', '葛炳生的头像');
INSERT INTO `account_info` VALUES ('119', '', '男', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('120', '', '男', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('121', '', '男', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('122', '', '男', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('123', '', '男', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('124', '测试1', '保密', '155798649596', null, null, '江西财经大学', '江西南昌', null, null);
INSERT INTO `account_info` VALUES ('125', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('126', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('127', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('128', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('129', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('130', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('131', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('132', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('133', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('134', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('135', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('136', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('137', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('138', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('139', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('140', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('141', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('142', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('143', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('144', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('145', '', '保密', '', null, null, '', '', null, null);
INSERT INTO `account_info` VALUES ('146', '测试姓名', '女', '110', '648684@qq.com', '2017-04-18', 'jxufe', 'fwe', 'aihao', 'touxiang');

-- ----------------------------
-- Table structure for `authors`
-- ----------------------------
DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `AuthorId` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `AuthorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AuthorId`),
  KEY `Authors_Names` (`AuthorName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authors
-- ----------------------------

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Books_ISBNs` (`isbn`),
  KEY `Books_Titles` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------

-- ----------------------------
-- Table structure for `chapter_test`
-- ----------------------------
DROP TABLE IF EXISTS `chapter_test`;
CREATE TABLE `chapter_test` (
  `Chapter_Test_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Chapter_Test_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter_test
-- ----------------------------

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `Class_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Teacher_Id` bigint(20) NOT NULL,
  `Course_Id` int(11) unsigned zerofill NOT NULL,
  `Class_Poster` varchar(500) NOT NULL COMMENT '班级海报',
  `Class_Present` blob NOT NULL COMMENT '班级简介',
  `Teach_Over` tinyint(1) NOT NULL DEFAULT '0' COMMENT '课程结束',
  `class_Info_Id` int(11) NOT NULL,
  PRIMARY KEY (`Class_Id`),
  KEY `Teacher_Id` (`Teacher_Id`),
  KEY `Course_Id` (`Course_Id`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`Teacher_Id`) REFERENCES `user_principal` (`User_Principal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`Course_Id`) REFERENCES `course` (`Course_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for `class_disscussion`
-- ----------------------------
DROP TABLE IF EXISTS `class_disscussion`;
CREATE TABLE `class_disscussion` (
  `Class_Discussion_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Topic_Title` varchar(250) NOT NULL,
  `Topic_Content` blob NOT NULL,
  `Created_Time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `voted` bigint(20) DEFAULT NULL,
  `Class_Id` int(11) NOT NULL,
  PRIMARY KEY (`Class_Discussion_Id`),
  KEY `Class_Id` (`Class_Id`),
  CONSTRAINT `class_disscussion_ibfk_1` FOREIGN KEY (`Class_Id`) REFERENCES `class` (`Class_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_disscussion
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Course_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Course_Name` varchar(50) NOT NULL,
  `Course_Type_Id` int(11) unsigned zerofill NOT NULL,
  `Course_Creator` bigint(20) NOT NULL COMMENT '课程创建者',
  `Course_Category` smallint(6) unsigned zerofill NOT NULL,
  `Course_Intro` varchar(500) DEFAULT NULL,
  `Course_Period` int(11) NOT NULL,
  `Target_User` varchar(250) NOT NULL,
  PRIMARY KEY (`Course_Id`),
  KEY `Course_Type_Id` (`Course_Type_Id`),
  KEY `Course_Creator` (`Course_Creator`),
  KEY `Course_Category` (`Course_Category`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Course_Type_Id`) REFERENCES `course_type` (`Course_Type_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`Course_Creator`) REFERENCES `user_principal` (`User_Principal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_ibfk_3` FOREIGN KEY (`Course_Category`) REFERENCES `course_category` (`Course_Category_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `course_category`
-- ----------------------------
DROP TABLE IF EXISTS `course_category`;
CREATE TABLE `course_category` (
  `Course_Category_Id` smallint(6) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '课程类目自增主键',
  `Category_Name` varchar(20) NOT NULL COMMENT '课程类目名称',
  `Category_Desc` varchar(250) NOT NULL COMMENT '类目描述',
  PRIMARY KEY (`Course_Category_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_category
-- ----------------------------
INSERT INTO `course_category` VALUES ('000001', 'IT技术', '包括软件，程序语言');
INSERT INTO `course_category` VALUES ('000002', '金融会计', '金融类课程教学');

-- ----------------------------
-- Table structure for `course_tree`
-- ----------------------------
DROP TABLE IF EXISTS `course_tree`;
CREATE TABLE `course_tree` (
  `Course_Tree_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `P_Node_Id` bigint(20) DEFAULT NULL,
  `Width` smallint(6) NOT NULL,
  `Deepth` smallint(6) NOT NULL,
  `Node_Desc` varchar(50) NOT NULL COMMENT '章节标题',
  `Chapter_Abstract` blob NOT NULL COMMENT '章节内容摘要',
  `Chapter_Test` bigint(20) NOT NULL COMMENT '章节测验（和课程作业不同,章节测验一般是选择题等等，而课程作业一般是上传压缩文件下发作业）',
  `Class_Id` int(11) NOT NULL,
  PRIMARY KEY (`Course_Tree_Id`),
  KEY `Class_Id` (`Class_Id`),
  KEY `Chapter_Test` (`Chapter_Test`),
  CONSTRAINT `course_tree_ibfk_1` FOREIGN KEY (`Class_Id`) REFERENCES `class` (`Class_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_tree_ibfk_2` FOREIGN KEY (`Chapter_Test`) REFERENCES `chapter_test` (`Chapter_Test_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_tree
-- ----------------------------

-- ----------------------------
-- Table structure for `course_type`
-- ----------------------------
DROP TABLE IF EXISTS `course_type`;
CREATE TABLE `course_type` (
  `Course_Type_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Course_Type_Name` varchar(25) NOT NULL COMMENT '课程类别名称',
  `Description` varchar(100) NOT NULL COMMENT '课程类别描述',
  PRIMARY KEY (`Course_Type_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_type
-- ----------------------------
INSERT INTO `course_type` VALUES ('0000000001', '自主课', '老师或者个人开设，可收取费用');
INSERT INTO `course_type` VALUES ('0000000002', '必修课', '学校规定必修课');
INSERT INTO `course_type` VALUES ('0000000003', '选修课', '学校规定选修课');

-- ----------------------------
-- Table structure for `disscussion_reply`
-- ----------------------------
DROP TABLE IF EXISTS `disscussion_reply`;
CREATE TABLE `disscussion_reply` (
  `Disscussion_Reply_Id` bigint(20) NOT NULL,
  `Reply_Content` blob NOT NULL,
  `Reply_User_Id` bigint(20) NOT NULL,
  `Reply_Time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `P_Id` bigint(20) DEFAULT NULL COMMENT '讨论回复的对象',
  `Course_Disscussion_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Disscussion_Reply_Id`),
  KEY `Reply_User_Id` (`Reply_User_Id`),
  KEY `Course_Disscussion_Id` (`Course_Disscussion_Id`),
  CONSTRAINT `disscussion_reply_ibfk_1` FOREIGN KEY (`Reply_User_Id`) REFERENCES `user_principal` (`User_Principal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `disscussion_reply_ibfk_2` FOREIGN KEY (`Course_Disscussion_Id`) REFERENCES `class_disscussion` (`Class_Discussion_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disscussion_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `homework`
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `Homework_Id` bigint(20) NOT NULL,
  `Homework_Details_Id` bigint(20) NOT NULL,
  `Created_Date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `Deadline` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Class_Id` int(11) NOT NULL,
  `StartDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `Homework_Title` varchar(120) NOT NULL,
  PRIMARY KEY (`Homework_Id`),
  KEY `Class_Id` (`Class_Id`),
  KEY `Homework_Details_Id` (`Homework_Details_Id`),
  CONSTRAINT `homework_ibfk_1` FOREIGN KEY (`Class_Id`) REFERENCES `class` (`Class_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `homework_ibfk_2` FOREIGN KEY (`Homework_Details_Id`) REFERENCES `homework_details` (`Homework_Details_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework
-- ----------------------------

-- ----------------------------
-- Table structure for `homework_details`
-- ----------------------------
DROP TABLE IF EXISTS `homework_details`;
CREATE TABLE `homework_details` (
  `Homework_Details_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Homework_Details_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework_details
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `Permission_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(50) NOT NULL,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`Permission_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '下载ppt资源', 'DOWNLOAD_PPT');
INSERT INTO `permission` VALUES ('2', '删除ppt', 'DELETE_PPT');
INSERT INTO `permission` VALUES ('3', '分配角色和权限', 'ASSIGN_AUTHORITY');
INSERT INTO `permission` VALUES ('4', ' 炜炜', '啊和我');
INSERT INTO `permission` VALUES ('5', 'tega', 'test');

-- ----------------------------
-- Table structure for `publishers`
-- ----------------------------
DROP TABLE IF EXISTS `publishers`;
CREATE TABLE `publishers` (
  `PublisherId` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `dateFounded` date DEFAULT NULL,
  `PublisherName` varchar(255) NOT NULL,
  PRIMARY KEY (`PublisherId`),
  KEY `Publishers_Names` (`PublisherName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publishers
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Role_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_Name` varchar(20) DEFAULT NULL COMMENT '该字段必须唯一，因为用作其他表的外键',
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Role_Id`),
  UNIQUE KEY `Role_Name_2` (`Role_Name`),
  KEY `Role_Name` (`Role_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'TEACHER', '教师');
INSERT INTO `role` VALUES ('2', 'SCHOOL_ADMIN', '负责网站和学校的数据交换');
INSERT INTO `role` VALUES ('3', 'SITE_ADMIN', '站点管理员');
INSERT INTO `role` VALUES ('4', 'STUDENT', '在校学生');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `Role_Permission_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role_Id` int(11) NOT NULL,
  `Permission_Id` int(11) NOT NULL,
  PRIMARY KEY (`Role_Permission_Id`),
  UNIQUE KEY `R_P_index` (`Role_Id`,`Permission_Id`) USING BTREE,
  KEY `Permission_Id` (`Permission_Id`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`Role_Id`) REFERENCES `role` (`Role_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`Permission_Id`) REFERENCES `permission` (`Permission_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('15', '1', '1');
INSERT INTO `role_permission` VALUES ('13', '1', '2');
INSERT INTO `role_permission` VALUES ('28', '1', '4');
INSERT INTO `role_permission` VALUES ('29', '1', '5');
INSERT INTO `role_permission` VALUES ('19', '2', '1');
INSERT INTO `role_permission` VALUES ('20', '2', '2');
INSERT INTO `role_permission` VALUES ('18', '2', '3');

-- ----------------------------
-- Table structure for `student_class`
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
  `Stu_Class_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Student_Id` bigint(20) NOT NULL,
  `Teacher_Id` bigint(20) NOT NULL,
  `Course_Id` int(11) unsigned zerofill NOT NULL,
  `Class_Id` int(11) NOT NULL,
  PRIMARY KEY (`Stu_Class_Id`),
  KEY `Student_Id` (`Student_Id`),
  KEY `Teacher_Id` (`Teacher_Id`),
  KEY `Course_Id` (`Course_Id`),
  KEY `Class_Id` (`Class_Id`),
  CONSTRAINT `student_class_ibfk_1` FOREIGN KEY (`Student_Id`) REFERENCES `user_principal` (`User_Principal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_class_ibfk_2` FOREIGN KEY (`Teacher_Id`) REFERENCES `user_principal` (`User_Principal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_class_ibfk_3` FOREIGN KEY (`Course_Id`) REFERENCES `course` (`Course_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_class_ibfk_4` FOREIGN KEY (`Class_Id`) REFERENCES `class` (`Class_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_class
-- ----------------------------

-- ----------------------------
-- Table structure for `surrogatekeys`
-- ----------------------------
DROP TABLE IF EXISTS `surrogatekeys`;
CREATE TABLE `surrogatekeys` (
  `TableName` varchar(255) DEFAULT NULL,
  `KeyValue` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of surrogatekeys
-- ----------------------------

-- ----------------------------
-- Table structure for `teach_resource`
-- ----------------------------
DROP TABLE IF EXISTS `teach_resource`;
CREATE TABLE `teach_resource` (
  `Teach_Resource_Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `Resource_Type` varchar(255) NOT NULL COMMENT '资源类型（课件（ppt,word,pdf）,视频(mp4,mpeg),压缩资源文件(rar,zip))',
  `Resource_Path` varchar(250) NOT NULL COMMENT '资源路径',
  `Course_Tree_Node_Id` bigint(20) DEFAULT NULL,
  `Resource_Name` varchar(255) NOT NULL COMMENT '资源名称用来搜索资源',
  `Resource_Creator` bigint(20) NOT NULL COMMENT '资源创建者,资源所有权',
  `Class_Id` int(11) NOT NULL,
  PRIMARY KEY (`Teach_Resource_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teach_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `user_principal`
-- ----------------------------
DROP TABLE IF EXISTS `user_principal`;
CREATE TABLE `user_principal` (
  `User_Principal_Id` bigint(20) NOT NULL,
  `Password` binary(60) NOT NULL,
  `Role_Id` int(11) NOT NULL,
  `AccountNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `AccountNonLocked` tinyint(1) NOT NULL DEFAULT '1',
  `CredentialsNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `Enabled` tinyint(1) NOT NULL DEFAULT '1',
  `Online_State` tinyint(1) NOT NULL DEFAULT '0',
  `Last_logged_Time` datetime DEFAULT NULL,
  `Last_loggedout_Time` datetime DEFAULT NULL,
  `Register_Time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Account_Info_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`User_Principal_Id`),
  KEY `User_Principal_Role_Id` (`Role_Id`),
  KEY `User_Principal_Acc_Id` (`Account_Info_Id`),
  CONSTRAINT `User_Principal_Acc_Id` FOREIGN KEY (`Account_Info_Id`) REFERENCES `account_info` (`Account_Info_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `User_Principal_Role_Id` FOREIGN KEY (`Role_Id`) REFERENCES `role` (`Role_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_principal
-- ----------------------------
INSERT INTO `user_principal` VALUES ('111', 0x243261243130244C5958624C57517A6D6F57746758416D5846706247653978526C56556E6F7765326C7259584C5055584A4B68394969614F6D31614B, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:49:51', '138');
INSERT INTO `user_principal` VALUES ('123', 0x2432612431302455634E7453716C2F79436B746A456F4C534166614665387146743478745932624F6D586A685A35625A455757334C52704164324965, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:50:15', '139');
INSERT INTO `user_principal` VALUES ('22313', 0x24326124313024412E4C306D56456439706856584F424777746A46587571324570517176334455486A65395235586A5462754A733271613756577732, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:54:56', '141');
INSERT INTO `user_principal` VALUES ('23123', 0x243261243130245244552F6574386B5732364876564F316C65494A32656A332F33394A6D4631516648476149726153386D4876695039707249725469, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:50:29', '140');
INSERT INTO `user_principal` VALUES ('123456', 0x243261243130243663764648784F6533615255614763664751634A362E7778366D7533684F742E503765624A31444A69644D3351513430364D344361, '3', '1', '1', '1', '1', '1', '2017-04-19 16:33:32', null, '2017-04-19 11:16:36', null);
INSERT INTO `user_principal` VALUES ('231212', 0x2432612431302461534C2F386F615273545632466844542F50596D722E586454562E76746371612F446A7578426F6444334C4134416E454A42584A4F, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:19:42', '126');
INSERT INTO `user_principal` VALUES ('232323', 0x243261243130242E3777705462466E495757795345504E774B5342644F7031502E316D6279737278536A4F55706B5465364371654B4A554C52774353, '1', '1', '1', '1', '1', '1', '2017-04-16 11:43:53', null, '2017-04-16 11:43:43', null);
INSERT INTO `user_principal` VALUES ('333333', 0x2432612431302479525146637A4D565537424A6A7968325076707A424F366A396A352F2E456A4571466564526B2E5A47796644366E6A70696A516761, '4', '1', '1', '1', '1', '1', '2017-04-19 11:08:17', null, '2017-04-19 11:04:58', null);
INSERT INTO `user_principal` VALUES ('342323', 0x2432612431302453623731537856445068596F6E5A785A784A6B5A3065697949546842346153513345495768673031796F666A6A3630436836717332, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:48:30', '137');
INSERT INTO `user_principal` VALUES ('545534', 0x243261243130244D52686A627548707354553778656C62323661444C4F4D68396F6378487656356A734D7664553446304B68346C7144626346506B79, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:47:51', '136');
INSERT INTO `user_principal` VALUES ('666666', 0x2432612431302461635277715266554835325266445377464B7372692E5A4158366E556C562F4D76736D6C564B4D704575394F436179577557706369, '1', '1', '1', '1', '1', '1', '2017-04-26 09:09:33', null, '2017-04-25 12:00:27', '146');
INSERT INTO `user_principal` VALUES ('676767', 0x2432612431302469634C496C6F32646134526671775954356D6B6B634F5A73774B45584F5268563435414234667238544D2E415A6355776748432F65, '4', '1', '1', '1', '1', '0', null, null, '2017-04-24 17:06:00', null);
INSERT INTO `user_principal` VALUES ('787878', 0x24326124313024623979394A6B325842577A354B49664642644862374F317438717271656F7A63712F34675973396E704248582F697A7A6362324969, '4', '1', '1', '1', '1', '1', '2017-04-19 15:42:59', null, '2017-04-19 15:42:52', null);
INSERT INTO `user_principal` VALUES ('894531', 0x2432612431302471634E75592E682E424F4D4D446C5377452F7131572E7174397541552F4E53744A614658505A517574744665782F39586F59526336, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:49:06', '131');
INSERT INTO `user_principal` VALUES ('979797', 0x243261243130246E4E2F6E7964596C584C52374D666B46334F504F4165783877714B43497A6D792F55577474784B46574E6D345A52463443674E3447, '3', '1', '1', '1', '1', '1', '2017-04-19 16:34:14', null, '2017-04-19 13:15:43', null);
INSERT INTO `user_principal` VALUES ('1561565', 0x243261243130244534356B464C4B556175532F6D704231374530654C65616E4D416E52654A6F6978416E4973416D53615274524E774E6F6464434975, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:31:38', '128');
INSERT INTO `user_principal` VALUES ('2312123', 0x24326124313024327A2E37346A37764F5A41434E31736E34786D51737554423044684B5364745A5A76434F626E5A664C7358636A78524D757169352E, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:30:27', '127');
INSERT INTO `user_principal` VALUES ('2333333', 0x2432612431302441444F372E663056335778565248726163637649414F4F614837796F493349415253427A6A6938576F70625865764143663167414B, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 12:17:56', null);
INSERT INTO `user_principal` VALUES ('3343424', 0x243261243130243052437450462F6C524F4B34315355676A4D426259654E387171794C7532464D465A5947516C364C786E394E716B58696857313936, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '94');
INSERT INTO `user_principal` VALUES ('4512121', 0x243261243130246E623745384F57486B413276647139315A583666752E4968766A37727A2F5775537A706A7830394F397A416F42786348484170616D, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '112');
INSERT INTO `user_principal` VALUES ('4545454', 0x243261243130244A7056502F54564F4C59366E56485A674542376A71656B374B5858793970642F4357732E6A3438772F4C614C4257356771724F744B, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '103');
INSERT INTO `user_principal` VALUES ('4646446', 0x243261243130242E4A57786D75316830666845467175366A4F796541655A486932755A594356717179476D58385535386E4D7A7A746A2E776E494332, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '116');
INSERT INTO `user_principal` VALUES ('7784545', 0x2432612431302476655469684548526F39354F4C445A54554533353475794C68426D474A643164442F5256505277304375744C5A484846496B343753, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '111');
INSERT INTO `user_principal` VALUES ('7845454', 0x24326124313024336D707851776E52526C457A6F466D5855776E4D4A75473754587A484F375933506667456945476F456C38384854464A664E563869, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:37:52', '129');
INSERT INTO `user_principal` VALUES ('12145796', 0x243261243130244351567050495A686630775933704931346E5467582E7344504F53484863537470354C38727569673253637644576D385856434E57, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '115');
INSERT INTO `user_principal` VALUES ('12232121', 0x243261243130243433526B747A6A723245654E3149566F334174756275764B2F2E335867494465416633304D6656663670473032366D48714C696E36, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 16:45:33', '122');
INSERT INTO `user_principal` VALUES ('12454511', 0x2432612431302444303675696146795774566435705759346672665A7568764F38584E37447357563965675A697362674142617732496179526C4743, '2', '1', '1', '1', '1', '0', null, null, '2017-04-15 16:46:14', '123');
INSERT INTO `user_principal` VALUES ('12487887', 0x2432612431302456396B477141314D4250726C2E6D634765595546467565317A38367A445146734355336F724978414E4B4E457878662E324D356A47, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '108');
INSERT INTO `user_principal` VALUES ('12981458', 0x243261243130245A39436C49473836682E4A654F693939357047343475706D754E72534E534570536A49386E416C616F6F324632597153646D356147, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '104');
INSERT INTO `user_principal` VALUES ('13231511', 0x243261243130247633457669717679524238756D57472E6F4B3548472E7A6B63747A6B5055613565696D42784173492F4A6677593658456A565A3447, '2', '1', '1', '1', '1', '0', null, null, '2017-04-17 21:31:45', '145');
INSERT INTO `user_principal` VALUES ('20598959', 0x2432612431302436384D46346845666E6E573879443250634D4E393465493762455649382F636D6642554D564633774F52762F5477426645334A7575, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '86');
INSERT INTO `user_principal` VALUES ('33333553', 0x6F696F6F6F00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, '1', '1', '1', '1', '1', '0', '2017-04-14 15:17:36', null, '2017-04-14 15:17:36', '118');
INSERT INTO `user_principal` VALUES ('41214678', 0x243261243130244D50304F66682F3769754E696D4F523678493333634F5641397147616F6D334D4948356246764265534377796C5246726E6432752E, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:49:42', '132');
INSERT INTO `user_principal` VALUES ('41772787', 0x243261243130245173614A42447869744D75332E35376B675A7747554F5938354A6B50393442427064366C67377965614379756F7A644A7250377761, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '99');
INSERT INTO `user_principal` VALUES ('43131312', 0x24326124313024492E4B34712E44692F4769637A7052436A3555714165334C502F3771575651546832696E41534B314E643561384F744E4358426469, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '110');
INSERT INTO `user_principal` VALUES ('54587878', 0x243261243130246E597A645334634267686A4776466978334F664B302E4D6D68704D4561654F38642F474E6F666D65552E3633433948693153443836, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '105');
INSERT INTO `user_principal` VALUES ('75454545', 0x243261243130244E71354A616E5A546E6C443239446D5832645553564F7442534442333237615835747A63596A2F58712F4744783048564165325769, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 12:56:51', '120');
INSERT INTO `user_principal` VALUES ('76484545', 0x243261243130244F6F316671566870455257306C59503557387674702E773636557A68536437726D596E42376D542E665657464A6E572F48774E4D36, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '113');
INSERT INTO `user_principal` VALUES ('78454541', 0x24326124313024456E2E4A58306E582F4661416D6A736554696F4A637535614D45716E7474386635614F6F67324639656F76443175305942396A6F6D, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:39:31', '130');
INSERT INTO `user_principal` VALUES ('78784212', 0x24326124313024786E49425A44706C3263782F584967663748466B634F4B4635695A78533464464D6D4871674C49476A336231774573305741554F69, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '109');
INSERT INTO `user_principal` VALUES ('78787845', 0x243261243130245338376A6558425166486473722F483161373366724F58416F705033637543506F36414752474B41546A41416C4B5A463471715357, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '106');
INSERT INTO `user_principal` VALUES ('231212323', 0x2432612431302458794456516F78756B546A364B4E55385674666A5A75784C646C7656746A7A336B64586A38575941426A51415A7A5A4B3042704D71, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:55:23', '142');
INSERT INTO `user_principal` VALUES ('233332233', 0x2432612431302446452F4931366430716750583373363841556679494F36577564656D753837557A79796D75523942532E7956534A725A435944356D, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 12:19:00', '119');
INSERT INTO `user_principal` VALUES ('298985626', 0x243261243130244967734C594E53432E336B74426F6468777568504E754561543477464A7669702F3774456157527A4E7856544D6C646E6853597669, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '87');
INSERT INTO `user_principal` VALUES ('411222323', 0x243261243130246D7459387469484C51544C5A4D304F394A636B565175693657446950544850764F702F4166786947645753565A6477436C397A6975, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '89');
INSERT INTO `user_principal` VALUES ('414323434', 0x24326124313024456D764B336F6F6535637079714C637056307478797548525655307A42455863747363742F2F68425243636473456E54344B474361, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '92');
INSERT INTO `user_principal` VALUES ('415623434', 0x24326124313024446E4B567841744E6545302F45585939383567797A2E7A6A5845754152714B66714D544161685243447450316F39443863544C4743, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '96');
INSERT INTO `user_principal` VALUES ('416823434', 0x243261243130247062493973426C6D595A55485A596E446C484679702E6A413669594A466E61744B4D4F7161336867766B4B702E6B72345079657336, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '97');
INSERT INTO `user_principal` VALUES ('416824457', 0x243261243130244D4162784751653742706D6662754677324B3453517574334E306C4C50556964714376442F547049596752506439705A4B47395132, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '98');
INSERT INTO `user_principal` VALUES ('454121212', 0x243261243130243538615A723453644A71723745564D4A46354F56326568686A68506A5A535265726737544739526A61754F51534769447770307679, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '114');
INSERT INTO `user_principal` VALUES ('454212121', 0x243261243130245538776E386D35546932557A6A6A50694D564438664F4D4552696D346746772F617143302E7670633130797A38682E5637597A7365, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '107');
INSERT INTO `user_principal` VALUES ('457875454', 0x24326124313024464C5348344847505236484631514572704C4A6A342E3761423754626464424945414C7934326B6836464B466E785A4B7456624D36, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:47:02', '134');
INSERT INTO `user_principal` VALUES ('979783618', 0x24326124313024536838764B78355275543450363437796F58364A76655672624F4866672E39316F6D64506E333555583837587A3336476248314C36, '4', '1', '1', '1', '1', '1', '2017-04-26 09:11:03', null, '2017-04-19 16:34:43', null);
INSERT INTO `user_principal` VALUES ('1221245457', 0x2432612431302456514C506B2F693432472E506D524E6A536C59697975527057334A68694A3748796854732F33312F617A322F674B5173582F68772E, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:18:38', '125');
INSERT INTO `user_principal` VALUES ('2201403953', 0x24326124313024556F4F2F6C414C4A62744E5A506F616D417856474D2E4F77494E4571314F6F6E39536130374B6A4431707A484D3450525348655453, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '85');
INSERT INTO `user_principal` VALUES ('2201403954', 0x243261243130246364774C56767851526B317552766F5945477A7070652E33434E63557652676B764B6D3445534741455374326739746161305A5071, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '88');
INSERT INTO `user_principal` VALUES ('2312123323', 0x24326124313024757A2E53695441734B646A694D51355A4F61724E45757731504A2F497A41375561714A5A6A3537397133686E782E424D70366A4A47, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:55:40', '143');
INSERT INTO `user_principal` VALUES ('2324343434', 0x243261243130244C58336535624C6F5A2F4B6F4F34516B512E6D49586568592F72315531623936314E4C63624633667872377456376E454D47577279, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 17:51:20', '133');
INSERT INTO `user_principal` VALUES ('3423232323', 0x2432612431302439694B476E6F652E5472627679684579544F676A534F7559794C41467465596F3833533353354E6558726C6A6F706E3935575A634F, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 16:49:10', '124');
INSERT INTO `user_principal` VALUES ('4136234343', 0x2432612431302461353065452F48504C64626F36324A63564F76774665657255364E77426B5A6134555030576161456B517A6E72315267576C744F2E, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '90');
INSERT INTO `user_principal` VALUES ('4136243434', 0x243261243130244E4C373255304838665747574C664569526C6C6F6C657779384D2E4F48454974686E70792E677138554D72774E345A4E7555623236, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '91');
INSERT INTO `user_principal` VALUES ('4145234343', 0x243261243130246539304F6977304E4F6539334D312F6C59677A4D692E515A637154615173323650556769557752504E2E36385451726254626B4575, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '93');
INSERT INTO `user_principal` VALUES ('4146234343', 0x24326124313024324B536F50416D464E59527A4D6E617748384735462E4E5959354C707879524841683842794B32437362447A644D5034446E6E6936, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '95');
INSERT INTO `user_principal` VALUES ('4177245787', 0x2432612431302453434B513568657731547A5770444F3165767370334F63586A78386E5756714C5559447235356C3463326C7633335556413251566D, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '100');
INSERT INTO `user_principal` VALUES ('4177278654', 0x24326124313024546F312E532F78713772745968432F53357A4F375375725446664A314A47576D2F7952613645304858583245534237365A7057534F, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '101');
INSERT INTO `user_principal` VALUES ('4578754544', 0x243261243130246F51597A685A66326369424D70647163734A4A44624F494569663462355544344C5049347275464E52383337636F396B4331724947, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:47:34', '135');
INSERT INTO `user_principal` VALUES ('7545454533', 0x24326124313024577A657A726A5A6537366B704C7A5538414631414C2E44486F63627842304E476C2E487736715A7A475A79317130552E6C70467761, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 12:57:24', '121');
INSERT INTO `user_principal` VALUES ('41772467787', 0x243261243130242F77354D516F5A6467355575466F6375392E427033753970776132786B557A76774F4657334A32527A7671473554375546654D6836, '1', '1', '1', '1', '1', '0', null, null, '2017-04-13 08:43:42', '102');
INSERT INTO `user_principal` VALUES ('23121233233434233', 0x243261243130244541646977525A3747324352616F4C725272424C47656B506162447534306A4F4E38596D435A4A72666E66744465504B5777493432, '1', '1', '1', '1', '1', '0', null, null, '2017-04-15 18:55:45', '144');
