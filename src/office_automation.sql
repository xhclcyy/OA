/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : office_automation

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-11-13 21:30:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accessory
-- ----------------------------
DROP TABLE IF EXISTS `accessory`;
CREATE TABLE `accessory` (
  `accessory_id` int(11) NOT NULL AUTO_INCREMENT,
  `accessory_document_id` int(11) NOT NULL,
  `accessory_name` varchar(30) NOT NULL,
  `accessory_property` varchar(20) NOT NULL,
  `accessory_creater` char(15) DEFAULT NULL,
  `accessory_path` varchar(50) NOT NULL,
  `accessory_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `accessory_status` bit(1) NOT NULL,
  `accessory_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`accessory_id`),
  KEY `fk_accessory_01` (`accessory_document_id`),
  KEY `fk_accessory_02` (`accessory_creater`),
  CONSTRAINT `fk_accessory_01` FOREIGN KEY (`accessory_document_id`) REFERENCES `document` (`document_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_accessory_02` FOREIGN KEY (`accessory_creater`) REFERENCES `user` (`user_no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accessory
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_no` char(15) NOT NULL,
  `department_manager` char(15) DEFAULT NULL,
  `department_population` int(11) NOT NULL,
  `department_name` varchar(30) NOT NULL,
  `department_creat_time` date NOT NULL,
  `department_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `department_no` (`department_no`),
  KEY `fk_department_01` (`department_manager`),
  CONSTRAINT `fk_department_01` FOREIGN KEY (`department_manager`) REFERENCES `user` (`user_no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_property` varchar(20) NOT NULL,
  `document_name` varchar(20) NOT NULL,
  `document_creater` char(15) DEFAULT NULL,
  `document_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `document_department` char(15) DEFAULT NULL,
  `document_parent` int(11) DEFAULT NULL,
  `document_path` varchar(50) NOT NULL,
  `document_status` bit(1) NOT NULL,
  `document_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`document_id`),
  KEY `fk_document_01` (`document_creater`),
  KEY `fk_document_02` (`document_department`),
  KEY `fk_document_03` (`document_parent`),
  CONSTRAINT `fk_document_01` FOREIGN KEY (`document_creater`) REFERENCES `user` (`user_no`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_document_02` FOREIGN KEY (`document_department`) REFERENCES `department` (`department_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_document_03` FOREIGN KEY (`document_parent`) REFERENCES `document` (`document_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `log_ip` char(20) NOT NULL,
  `log_user_no` char(15) NOT NULL,
  `log_content` varchar(255) NOT NULL,
  `log_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `fk_log_01` (`log_user_no`),
  CONSTRAINT `fk_log_01` FOREIGN KEY (`log_user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_user_no` char(15) NOT NULL,
  `login_password` char(20) NOT NULL,
  `login_department_no` char(15) DEFAULT NULL,
  `login_role_no` char(15) DEFAULT NULL,
  `login_recently_ip` char(15) NOT NULL,
  `login_status` bit(1) NOT NULL,
  `login_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  KEY `fk_login_03` (`login_user_no`),
  KEY `fk_login_01` (`login_department_no`),
  KEY `fk_login_02` (`login_role_no`),
  CONSTRAINT `fk_login_01` FOREIGN KEY (`login_department_no`) REFERENCES `department` (`department_no`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_login_02` FOREIGN KEY (`login_role_no`) REFERENCES `role` (`role_no`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_login_03` FOREIGN KEY (`login_user_no`) REFERENCES `user` (`user_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_no` char(15) NOT NULL,
  `role_name` char(30) NOT NULL,
  `role_authority_value` int(11) NOT NULL,
  `role_authority_describe` varchar(255) NOT NULL,
  `role_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `role_no` (`role_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for trash
-- ----------------------------
DROP TABLE IF EXISTS `trash`;
CREATE TABLE `trash` (
  `trash_id` int(11) NOT NULL AUTO_INCREMENT,
  `trash_docOrAcc_id` int(11) NOT NULL,
  `trash_docOrAcc` bit(1) NOT NULL,
  `trash_docOrAcc_name` varchar(30) NOT NULL,
  `trash_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `trash_department_no` char(15) NOT NULL,
  `trash_user_no` char(15) NOT NULL,
  PRIMARY KEY (`trash_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trash
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` char(15) NOT NULL,
  `user_name` char(30) NOT NULL,
  `user_picture` varchar(50) NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_sex` bit(1) NOT NULL,
  `user_address` varchar(50) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_phone` char(15) NOT NULL,
  `user_telphone` char(15) DEFAULT NULL,
  `user_hiredate` date NOT NULL,
  `user_office_address` varchar(30) NOT NULL,
  `user_office_phone` char(15) NOT NULL,
  `user_nation` char(20) NOT NULL,
  `user_native_place` varchar(20) NOT NULL,
  `user_birthday` date NOT NULL,
  `user_politics_status` char(20) NOT NULL,
  `user_marital_status` char(10) NOT NULL,
  `user_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_no` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
