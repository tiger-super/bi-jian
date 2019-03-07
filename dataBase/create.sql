/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50718
Source Host           : 47.106.244.224:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-03-07 19:03:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `chat_accept_id` varchar(100) NOT NULL COMMENT '聊天接收方的id',
  `chat_time` varchar(100) NOT NULL COMMENT '聊天时间',
  `chat_text_address` varchar(200) DEFAULT NULL COMMENT '聊天内容的地址',
  PRIMARY KEY (`chat_accept_id`,`chat_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectors_id` varchar(200) NOT NULL COMMENT '收藏人的id',
  `collection_house_id` varchar(200) NOT NULL COMMENT '收藏的房源id',
  `collection_time` varchar(200) DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`collection_house_id`,`collectors_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` varchar(200) DEFAULT NULL COMMENT '客户姓名',
  `customer_mailbox` varchar(100) DEFAULT NULL COMMENT '客戶的邮箱',
  `customer_sex` varchar(10) DEFAULT '男' COMMENT '客户性别',
  `customer_age` varchar(10) DEFAULT '0' COMMENT '客户年龄',
  `customer_phone` varchar(200) DEFAULT NULL COMMENT '客户联系方式,客户账号',
  `customer_password` varchar(200) DEFAULT NULL COMMENT '客户的密码',
  `customer_head_image_address` varchar(200) DEFAULT NULL COMMENT '客户头像地址',
  `if_blacklist` varchar(20) DEFAULT '0' COMMENT '是否被列入黑名单',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `house_id` varchar(200) DEFAULT NULL COMMENT '房源id',
  `bed` varchar(10) DEFAULT '0' COMMENT '是否配床，0表示无,1表示有',
  `wardrobe` varchar(10) DEFAULT '0' COMMENT '是否配衣柜，0表示无，1表示有',
  `desk` varchar(10) DEFAULT '0' COMMENT '是否配书桌，0表示无，1表示有',
  `air` varchar(10) DEFAULT '0' COMMENT '是否配空调，0表示无，1表示有',
  `heater` varchar(10) DEFAULT '0' COMMENT '是否配热水，0表示无，1表示有',
  `washer` varchar(10) DEFAULT '0' COMMENT '是否配洗衣机，0表示无，1表示有',
  `refigerator` varchar(10) DEFAULT '0' COMMENT '是否配冰箱，0表示无，1表示有',
  `wifi` varchar(10) DEFAULT '0' COMMENT '是否配wifi,0表示无，1表示有',
  `sofa` varchar(10) DEFAULT '0' COMMENT '是否配沙发，0表示无，1表示有',
  `tv` varchar(10) DEFAULT '0' COMMENT '是否配电视,0表示无，1表示有',
  `toilet` varchar(10) DEFAULT '0' COMMENT '是否配厕所，0表示无，1表示有',
  `balcony` varchar(10) DEFAULT '0' COMMENT '是否配阳台，0表示无，1表示有',
  `cook` varchar(10) DEFAULT '0' COMMENT '是否配厨房，0表示无，1表示有',
  `elevator` varchar(10) DEFAULT '0' COMMENT '是否配电梯，0表示无，1表示有',
  `tube_coal` varchar(10) DEFAULT '0' COMMENT '是否配煤管，0表示无，1表示有',
  `heating` varchar(10) DEFAULT '0' COMMENT '是否配暖气,0表示无，1表示有',
  `escalator` varchar(10) DEFAULT '0' COMMENT '是否配扶梯，0表示无，1表示有',
  `smoke` varchar(10) DEFAULT '0' COMMENT '是否排烟，0表示无，1表示有',
  `sewage_disposal` varchar(10) DEFAULT '0' COMMENT '是否排污，0表示无，1表示有',
  `parking` varchar(10) DEFAULT '0' COMMENT '是否有停车场,0表示无，1表示有'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `employee_name` varchar(100) DEFAULT NULL COMMENT '员工姓名',
  `employee_sex` varchar(10) DEFAULT '男' COMMENT '员工性别',
  `employee_age` varchar(29) DEFAULT '0' COMMENT '员工年龄',
  `employee_phone` varchar(200) DEFAULT NULL COMMENT '员工联系方式',
  `employee_mailbox` varchar(200) DEFAULT NULL COMMENT '员工邮件',
  `employee_password` varchar(200) DEFAULT '8888' COMMENT '员工登录密码',
  `employee_role` varchar(150) DEFAULT NULL COMMENT '员工角色或者说权限',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '房源编号',
  `house_name` varchar(200) DEFAULT NULL COMMENT '房源名称',
  `house_address_province` varchar(50) DEFAULT NULL COMMENT '房源所在的省',
  `house_address_city` varchar(50) DEFAULT NULL COMMENT '房源所在的市',
  `house_address_area` varchar(50) DEFAULT NULL COMMENT '房源所在的区',
  `house_address_info` varchar(200) DEFAULT NULL COMMENT '房源的详细地址',
  `house_publisher_id` varchar(200) DEFAULT NULL COMMENT '房源发布人的id',
  `house_auditing_state` varchar(10) DEFAULT '0' COMMENT '房源的审核情况，0表示待审核，1表示审核通过。-1表示审核失败',
  `house_publisher_state` varchar(10) DEFAULT '0' COMMENT '房源的发布情况，0表示房源未发布，1表示房源正在发布',
  `house_publisher_time` varchar(200) DEFAULT NULL COMMENT '房源的发布时间',
  `follow_number` varchar(200) DEFAULT '0' COMMENT '房源收藏数量',
  `application_time` varchar(200) DEFAULT NULL COMMENT '房源的申请时间',
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house_info
-- ----------------------------
DROP TABLE IF EXISTS `house_info`;
CREATE TABLE `house_info` (
  `house_id` varchar(200) NOT NULL COMMENT '房源id',
  `house_publisher_id` varchar(200) NOT NULL COMMENT '房源发布人的id',
  `house_type` varchar(150) DEFAULT NULL COMMENT '房源类型如：二手房、公寓、别墅、写字楼、仓库、厂房、土地、车位等',
  `house_money` varchar(100) DEFAULT NULL COMMENT '房源价钱',
  `house_size` varchar(100) DEFAULT NULL COMMENT '房源大小或者说房源的面积',
  `house_direction` varchar(100) DEFAULT NULL COMMENT '房源的朝向，如：东、南、西、北、东西、东南等',
  `house_sell_way` varchar(100) DEFAULT NULL COMMENT '房源的出售方式,如出售、租售',
  `house_depoit_way` varchar(100) DEFAULT '无' COMMENT '房源押金方式,如：押二付一',
  `house_descripe` text COMMENT '房源描述',
  `house_image_address` varchar(150) DEFAULT NULL COMMENT '房源的图片地址',
  `house_structure` varchar(100) DEFAULT NULL COMMENT '房源的结构,如：一室一厅0卫',
  PRIMARY KEY (`house_id`,`house_publisher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
