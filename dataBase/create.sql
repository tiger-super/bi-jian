/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50718
Source Host           : 47.106.244.224:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-03-23 20:01:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auditing_fail
-- ----------------------------
DROP TABLE IF EXISTS `auditing_fail`;
CREATE TABLE `auditing_fail` (
  `house_id` varchar(200) NOT NULL COMMENT '审核失败的房源id',
  `house_auditing_reason` text COMMENT '房源审核失败原因',
  `house_auditing_time` varchar(200) NOT NULL COMMENT '房源审核时间',
  PRIMARY KEY (`house_id`,`house_auditing_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auditing_fail
-- ----------------------------
INSERT INTO `auditing_fail` VALUES ('10016', '信息有误', '2019-03-16 09:05:46');
INSERT INTO `auditing_fail` VALUES ('10024', '信息不完善', '2019-03-22 17:22:07');

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
-- Records of chat
-- ----------------------------

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
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('2', '10002', '2019-03-20 12:46:14');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '钟泰文', '347177277@qq.com', '男', '23', '17875511746', '12345', '11551888507809.jpg', '0');
INSERT INTO `customer` VALUES ('2', '索隆', '347177277@qq.com', '男', '20', '17875511747', '123', '21548812244887.jpg', '0');
INSERT INTO `customer` VALUES ('3', '123', '1604767373@qq.com', '男', '0', '12345678901', '123', null, '0');

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
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('10000', '1', '1', '1', '1', '1', null, null, '1', null, null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10001', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10002', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10003', '1', null, null, null, null, null, null, null, '1', null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10004', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, '1', '1', '1');
INSERT INTO `device` VALUES ('10005', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, '1', '1', '1');
INSERT INTO `device` VALUES ('10006', '1', null, null, '1', '1', null, null, '1', null, null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10007', '1', null, '1', '1', '1', null, null, '1', null, null, '1', '1', null, '1', null, null, null, null, null, '1');
INSERT INTO `device` VALUES ('10008', '1', null, null, null, null, '1', null, '1', null, null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10009', '1', null, null, null, null, null, null, '1', null, null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10010', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, '1', '1', '1');
INSERT INTO `device` VALUES ('10011', '1', '1', null, '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', null, null, null, null, null);
INSERT INTO `device` VALUES ('10012', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, '1', '1', '1');
INSERT INTO `device` VALUES ('10013', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, '1', '1', null);
INSERT INTO `device` VALUES ('10014', '1', '1', null, '1', '1', null, null, '1', '1', '1', '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10015', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', null, null, null, null, '1');
INSERT INTO `device` VALUES ('10017', '1', '1', '1', '1', '1', null, null, null, '1', null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10018', '1', '1', '1', '1', '1', '1', '1', '1', null, null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10019', '1', '1', null, '1', '1', null, null, '1', null, null, '1', '1', null, null, null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10020', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null, null, null, null);
INSERT INTO `device` VALUES ('10021', '1', '1', '1', '1', '1', null, null, '1', null, null, '1', '1', null, null, null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10022', '1', '1', '1', '1', null, null, null, '1', '1', null, '1', '1', null, '1', null, null, null, null, null, null);
INSERT INTO `device` VALUES ('10024', '1', '1', '1', '1', null, null, '1', '1', '1', '1', '1', '1', null, '1', '1', null, null, null, null, '1');
INSERT INTO `device` VALUES ('10025', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', '1', null, null, null, null, '1');
INSERT INTO `device` VALUES ('10026', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', null, '1', null, null, null, null, null, '1');
INSERT INTO `device` VALUES ('10027', '1', null, null, '1', null, '1', '1', '1', null, null, '1', '1', null, '1', null, null, null, null, null, '1');
INSERT INTO `device` VALUES ('10030', '1', null, '1', null, '1', null, null, '1', null, null, '1', '1', null, null, null, null, null, null, null, null);

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
  `employee_address` varchar(200) DEFAULT NULL,
  `employee_img_address` varchar(200) DEFAULT NULL,
  `entry_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('10000', '钟泰文', '男', '24', '17875511746', '347177277@qq.com', '123', '超级管理员', '广东省梅州市五华县', '1553316476935.jpg', '2019-3-13');
INSERT INTO `employee` VALUES ('10004', '张三', '男', '33', '17875511750', '547376282@qq.com', '8888', '超级管理员', '广东省梅州市梅江区嘉应学院', '15524618141971.jpg', '2019-03-13');

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
) ENGINE=InnoDB AUTO_INCREMENT=10031 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('10000', '贝塔青年社区 · 桂城店', '广东省', '佛山市', '南海区', '格沙工业区E9座101号', '1', '1', '0', '2019-03-22 17:17:38', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10001', '万科泊寓 · 石啃店', '广东省', '佛山市', '南海区', '南海区教育路与桂业路交汇处', '1', '1', '0', '2019-03-22 17:17:39', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10002', '尔必公寓 · 桂城夏西罗芳西便公安横巷1号', '广东省', '佛山市', '南海区', '桂城夏西罗芳西便公安横巷1号', '1', '1', '1', '2019-03-22 17:17:41', '2', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10003', '微乐寓 · 明珠店', '广东省', '佛山市', '禅城区', '文华北路河边街64号', '1', '1', '0', '2019-03-22 17:17:42', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10004', '嘉信城市花园 家私家电齐 精装修', '广东省', '佛山市', '顺德区', '佛山市顺德区呈祥路6号', '1', '1', '1', '2019-03-22 17:17:43', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10005', '江南名居 方正三房', '广东省', '佛山市', '南海区', '广东省佛山市南海区南一路39', '1', '1', '1', '2019-03-22 17:17:45', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10006', '瑞东公寓 · 泌冲店', '广东省', '佛山市', '南海区', '南海区黄岐金沙洲泌冲泌一新村七巷8号', '1', '1', '1', '2019-03-22 17:17:47', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10007', '世联红璞公寓 · 佛山红璞公寓（天安店）', '广东省', '佛山市', '南海区', '佛山市南海区桂城街道东二南约村南约大街一号楼', '2', '1', '0', null, '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10008', '金融高新区、电梯房、交通便利，购物方便。', '广东省', '佛山市', '南海区', '龙溪大道西海八路立交东南侧(近龙溪地铁站C出口)', '1', '1', '1', '2019-03-22 17:17:49', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10009', '优客公寓', '广东省', '佛山市', '南海区', '水岸街与状元路交叉口西北100米', '1', '1', '1', '2019-03-22 17:20:03', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10010', '罗湖花园 实用3房 户型方正。', '广东省', '佛山市', '南海区', '罗湖中路2号', '1', '1', '1', '2019-03-22 17:20:07', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10011', '金湖花园，两房，通透户型，配套成熟，交通便利', '广东省', '佛山市', '南海区', '桂丹路11号', '1', '1', '1', '2019-03-22 17:20:08', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10012', '南海颐景园 4室2厅', '广东省', '佛山市', '南海区', '桂城华翠南路6号', '1', '1', '1', '2019-03-22 17:17:51', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10013', '中海寰宇天下 3室2厅', '广东省', '佛山市', '南海区', '桂澜中路18号', '1', '1', '1', '2019-03-22 17:17:53', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10014', '百年汇国际公寓 · 怡翠世嘉店', '广东省', '佛山市', '南海区', '怡翠世嘉花园16栋', '1', '1', '1', '2019-03-22 17:17:55', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10015', '经典温馨舒适大二房，南望怡翠公园', '广东省', '佛山市', '南海区', '华翠南路与桂平西路交汇处', '1', '1', '1', '2019-03-22 17:20:09', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10017', '有家公寓-狮山广场店', '广东省', '佛山市', '南海区', '狮山镇政协路旁边', '1', '1', '1', '2019-03-22 17:18:03', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10018', '河畔雅苑公寓 · 里水河村店', '广东省', '佛山市', '南海区', '里水镇河村月池村墨园街六巷11号', '1', '1', '1', '2019-03-22 17:18:04', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10019', '爱加公寓 · 里水店', '广东省', '佛山市', '南海区', '里水镇新联桥一旧村37号', '1', '1', '1', '2019-03-22 17:20:11', '1', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10020', '尚观嘉园 装修新净三房', '广东省', '佛山市', '南海区', '罗村大道南3号', '1', '1', '1', '2019-03-22 17:17:59', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10021', '美邦公寓33方单间', '省份', '城市', '区域', '天佑3路11号美邦公寓1008室', '1', '1', '1', '2019-03-22 17:18:02', '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10022', '盈嘉居公寓 · 海伦堡店', '广东省', '佛山市', '南海区', '佛平四路与聚元北路南延线交汇处', '1', '0', '0', null, '0', '2019-2-19 11:39:49');
INSERT INTO `house` VALUES ('10023', '银滩万泉城', '广东省', '梅州市', '五华县', '水寨镇园新路爱民巷013', '1', '0', '0', null, '0', '2019-2-27 11:39:49');
INSERT INTO `house` VALUES ('10024', '珠江半岛花园 3室2厅', '广东省', '佛山市', '南海区', '黄歧北村大桥', '1', '-1', '0', null, '0', '2019-3-01 11:39:49');
INSERT INTO `house` VALUES ('10025', '寓米公寓 · 碧桂园华府店', '广东省', '佛山市', '三水区', '贤兴一街2号', '2', '0', '0', null, '0', '2019-3-02 11:39:49');
INSERT INTO `house` VALUES ('10026', '岭南天地复式4房 采光通透 安静舒适 复式', '广东省', '佛山市', '禅城区', '禅城兆祥路33号', '2', '0', '0', null, '0', '2019-3-03 11:39:49');
INSERT INTO `house` VALUES ('10027', '碧水湾', '广东省', '佛山市', '南海区', '黄岐北村大桥西侧', '1', '0', '0', null, '0', '2019-03-18 10:30:08');
INSERT INTO `house` VALUES ('10030', '蓝万公寓 · 金色领域', '广东省', '佛山市', '南海区', '南湾大道与香基路交叉口东北50米', '1', '0', '0', null, '0', '2019-03-21 17:12:35');

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

-- ----------------------------
-- Records of house_info
-- ----------------------------
INSERT INTO `house_info` VALUES ('10000', '1', '公寓', '950', '30', '西', '租售', '押一付一', '你想过吗？在需要租房的岁月里正是我们生命中最精华的时候，有着花不完的青春。生命中最美好的日子本不应该只是一个人的孤军奋战。或许我们可以重新定义：“租房”。不单止是用来睡觉的冰冷房间，而是当你无论何时何地回来，把背包电脑随手在大厅一放，都能安心坐下来结识新的朋友、共进晚餐和分享彼此的“家”。希望每位在城市发展又怀揣着梦想与目标的孤独灵魂，少不了来自贝塔青年社区锁带给你的那份归属感与安全感。<br/><br/>“房子能租来，但生活不能。”', '11549690311179', '1室0厅1卫');
INSERT INTO `house_info` VALUES ('10001', '1', '公寓', '950', '31', '南北', '租售', '押一付一', '长租公寓品牌旗舰店，城市青年家，月租800起，拎包入住，现实版爱情公寓，朋友走一波，狗粮来一把？众多丰富社群活动，免费桌球台及免费健身房，空中花园ins风拍照圣地。天台厨房露天烧烤了解一下？不敢相信的话，现场看一看呗，风里雨里，泊寓·石啃店等你~', '11549941595613', '1室0厅1卫');
INSERT INTO `house_info` VALUES ('10002', '1', '公寓', '1000', '31', '东南', '租售', '押一付一', '【公寓特色】电子门禁卡进出，高清监控，定期打扫卫生，24小时专人管理<br/><br/>【室内装修】房子内部装修采取温馨风设计，色彩跟家具配置相得益彰，让住客以极实惠的价格，拥有温馨舒适环境优的家<br/><br/>【室内配置】床，床垫，桌椅，茶几，油烟机，衣柜，空调，热水器，独立厨卫，可以配置冰箱，洗衣机<br/><br/>【治安安全】全天候监控覆盖，专人管理，安全有保证<br/><br/>【周边配置】肉菜市场，便利店，美食店，吃穿喝样样俱全，房子周边三min内就有小超市，便利店，夜宵档，早餐档<br/><br/>【注意】1.不同房间家电家私配置不同，价格相对浮动 2.除房租水电外，另外需要收取管理卫生费20-40元/月不等（根据门店实际收取），网费50元/月，电梯房需收取30元/月电梯费 3.配置冰箱洗衣机需另收取每件家电50元/月 4.每间房配置设施和户型都是不一样的，上架房型图片仅为其中一个户型的！看房可以直接致电管家，可以带看其他户型！', '11549941868358', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10003', '1', '公寓', '1500', '35', '南', '租售', '押二付一', '文华北路河边街64号年轻有为，生活不将就【微家乐寓】城市创新4W长租青年公寓1、全新整套家具+休息、办公、娱乐各有各空间2、酷帅狂拽炸天的Metal金属风；成熟商务的Blues蓝调；时尚带小清新的POP流行；色块碰撞的Rock摇滚；色调饱和的R&B；原植搭配的Vocal合声……十大主题房间各具特色！3、5楼大露台岭南明珠观景瞭望城市日与夜，共享空间有n+1种玩法，左邻右舍吃瓜乘凉开趴嗨唱夜夜观星象4、商圈包围，交通便捷祖庙/季华/桂城三大繁华商圈包围，城市的中心步行可达，满足衣食住行、吃喝玩乐——5min明珠体育馆/亚艺公园10min文华荟产业园/文华里美食城15min九鼎国际购物中心/印象城购物中心', '11550039921685', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10004', '1', '商品房', '3300', '133', '东', '租售', '押一付一', '【房源亮点】装修保养比较新，采光通风透气。2.户型方正，家私家电齐。3.交通便利，生活配套完善。【交通出行】嘉信城市花园站：316路、318路、319路、902路、904路、905路、918路、923路、928路、佛308路【周边配套】：购物娱乐：嘉信城市广场（配有大型超市、商场、食街、邮政、银行、信用社、电影院等娱乐设施）新天地高尔夫练习场、史努比主题公园、河滨公园、德胜广场、顺德新城区', '11550044464576', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10005', '1', '商品房', '3000', '110', '东', '租售', '押一付一', '【户型介绍】此房为江南名居高层三房格局方正合理白色墙体精美地板铺设干净舒适【交通出行】江南名居位于南海大道和海八路交界处,广佛RBD位置，配套成熟，小区门口有5路14路公交到保利水城万达广场生活环境方便【周边配套】江南名居配套有游泳池，篮球场.健身公园等娱乐设施，西门外便是好好多超市和超益肉菜市场，购物方便桂江二中等而且区内还设有幼儿园', '11550044745684', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10006', '1', '公寓', '600', '37', '东南', '租售', '押一付一', '基本配置：床，衣柜，电脑桌椅，沙发，茶几等。电器配置：品牌空调，热水器，冰箱，电视，洗衣机等，拎包即可入住。（24*无死角，公共区域，全程*，电子大门门禁，专人管理，安全可靠，居住无忧）公寓周边环境：公交车、停车场、菜市场、医院，超市，饭店，幼儿园，公园等等', '11550047360190', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10007', '2', '公寓', '1740', '55', '北', '租售', '押一付一', '佛山红璞公寓南海天安店位于南海区桂澜中路旁，横穿季华金融商业街，地理位置优越，交通便利。10***生活圈：天安数码城、万科广场、城市广场、千灯湖、中海环宇城等大型商业综合体，吃喝玩乐一条龙服务到位。15***生活圈：进入千年文化之都禅城、普君（普君新城广场）、（文华里美食广场）、祖庙（岭南站）（百花广场）（铂顿城）（岭南新天地）。闹中取静，享成熟配套，公寓式管理，配备家私家电，拎包入住，配备娱乐公区', '21550047972487', '2室1厅1卫');
INSERT INTO `house_info` VALUES ('10008', '1', '商品房', '3000', '68', '南', '租售', '押一付一', '【房源亮点】金融高新区，电梯房，视野开阔，采光充足，通风好，交通便利,购物方便【交通出行】小区门口交通便利，包含多条交通线路，如：172、G8、279，地铁站为龙溪站和金融高新区站。【周边配套】万达广场天河城百货滨江公园沙仔湾公园嗨八蔬果恒大大药房聚美鲜君宏医药绿青洲农产品绿之真天添鲜美宜佳喜洋洋夏北社区卫生服务站', '11550152183060', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10009', '1', '公寓', '900', '45', '东南', '租售', '押一付一', '恋家公寓，坐落于佛山地区较繁荣地段，周边生活配套设施齐全，交通便利，人流多的路段。门店精装修。临近生活区，商业区/银行/医院/等餐饮、休闲、娱乐、购物商业配套一应俱全，白领公寓。设计精致，布局合理，配套齐全，咫尺之间尽享生活品味和品质。', '11550152428580', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10010', '1', '商品房', '2200', '131', '南北', '租售', '押一付一', '【房源亮点】交通便利配套完善实用3房户型方正，，，，，，，，，，，，，，【交通出行】公交线路有：219路，南高32A路、南高32B路、107路、116路、165路等线路【周边配套】配套:中国农业银行佛山南海罗村支行、交通银行(罗村支行)、中国建设银行佛山罗村支行、中国信合罗村寨边分社、中国信合罗村信用社', '11550152598034', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10011', '1', '商品房', '2000', '86', '南', '租售', '押一付一', '【房源亮点】罗村繁华地段，配套完善，生活方便，平时的肉菜和生活用品都可以在楼下买到。。。。。。【交通出行】方圆几百米有几个公车站点，距离地铁规划站口近，去高铁站和佛山市区公车出行都很便利【周边配套】小区楼下是罗村广场休闲娱乐场所，五百米是大润发，购物娱乐场所尽有', '11550152959321', '3室2厅1卫');
INSERT INTO `house_info` VALUES ('10012', '1', '别墅', '5000', '193', '北', '租售', '押一付一', '家电齐全配置豪华度假不二之选', '11550153253239', '4室2厅2卫');
INSERT INTO `house_info` VALUES ('10013', '1', '商品房', '4500', '135', '东南', '租售', '押一付一', '', '11550153429013', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10014', '1', '公寓', '1800', '44', '东北', '租售', '押一付一', '广东百年汇资产经营管理有限公司是经省工商管理局于1997年依法批准成立的专业投资管理公司，总部位于广州，主要业务涵盖项目投资、资产管理、物业租赁货，物业管理四大板块。公司乗承“以卓越服务，让资产增值”的理念，在资产的经营理和服务上得到客户的一致信赖。经过近20年的发展，公司已形成专业化的资产运营团队和创新管理模式。我们将一如既往致力于提供资产优化和增值服务，为客户资产增值创造丰愉的效益。', '11550153595631', '1室0厅1卫');
INSERT INTO `house_info` VALUES ('10015', '1', '商品房', '3000', '100', '东南', '租售', '押一付一', '【房源亮点】装修温馨舒适大2房，有效规划布局，合理使用空间庄重不俗，现代风格与简欧家私！【户型介绍】有效规划布局，合理使用空间，以小博大，画龙点睛，创造美味家居生活！【装修描述】一个愉悦的空间、一种尊贵的生活、一方独享的天地，都在这里寻求最合适的表达！【交通出行】公共自行车、电瓶车定点骑车，定点停车，随用随停，方便快捷，不用等候；滴滴打车随叫随到，快速便利，真的是出行无忧。【周边配套】佳盛广场，城市广场，百花时代广场，顺联国际广场，卜蜂莲花银行：中国工商银行，中国建设银行，中国银行。医院：南海妇幼保健院。', '11550153779076', '2室1厅1卫');
INSERT INTO `house_info` VALUES ('10017', '1', '公寓', '1400', '80', '东', '租售', '押一付一', '', '11550154009584', '2室1厅1卫');
INSERT INTO `house_info` VALUES ('10018', '1', '公寓', '1200', '75', '北', '租售', '押一付一', '河畔雅苑公寓，河畔公寓里水店位于：佛山市里水镇河村月池村墨园街6巷11号（双德食品附近），超舒适，新装修，家具配备冰箱洗衣机可配置！为你提供全方位租住服务，提供精致装修，高效管理，品牌化家电配置，建立一整套现代化的酒店式管理体系和管家服务，为您提供温馨、舒适、奢华的居住环境和空间。', '11550154159752', '2室1厅1卫');
INSERT INTO `house_info` VALUES ('10019', '1', '公寓', '900', '45', '东南', '租售', '押一付一', '新建公寓房：新房（待租中）独立厨卫，大阳台，大采光周边大小超市，大小市场，大小购物商场皆有，生活便利第一：公寓（1）环境优美，宁静和谐，好环境总会给人带来好心情。（2）房干净整洁，温馨舒适，窗明几净，就等着您的拎包入住。第二：家电齐全精装修，宽敞明亮，布局大方，采光非常好。第三：（１）家私配置：床（席梦丝），热水器，沙发，茶几，窗帘，电脑桌椅，独立厨卫，大阳台，采光好（２）家电配置：（品牌购置）空调，冰箱，洗衣机，宽带：配置不同价格也有些许变动；第四：地址：广东省佛山市南海区里水镇新联桥一旧村37号房东直接出租，免费看房，随时拔打电话，随时接送你“看房”', '11550154254205', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10020', '1', '商品房', '2800', '120', '南', '租售', '押一付一', '【装修描述】装修新净比较现代化简约风格家电新净拎包就入住三房采光好【交通出行】近罗村大道可以直达丹灶西樵张婵禅城区与公交路线众多出行方便【小区介绍】小区环境好绿化成熟有假山鱼池休闲凉亭游泳池等等。。。。', '11550154409824', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10021', '1', '公寓', '900', '35', '东南', '租售', '押一付一', '美邦公寓在凯德广场旁边，桂城地铁站D1出口即是，交通便利，侧边还有万达影院、越秀广场，购物休闲超级方便。地址：桂城天佑3路11号美邦公寓1008室（桂城地铁站D出口旁楼上有一个大型的LED广告牌，楼下是建设银行和诚美整容从建行后面坐电梯）', '11550154512595', '1室0厅1卫');
INSERT INTO `house_info` VALUES ('10022', '1', '公寓', '2200', '65', '东南', '租售', '押一付一', '盈嘉居公寓为您提供舒适的居住环境。', '11550154618456', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10024', '1', '商品房', '1700', '100', '南', '租售', '押一付一', '交通方便，环境优美', '11551893097839', '3室2厅1卫');
INSERT INTO `house_info` VALUES ('10025', '2', '公寓', '1500', '', '南北', '租售', '押一付一', '三水寓米酒店公寓为您提供舒适安全的居住环境。', '21551948625520', '1室1厅1卫');
INSERT INTO `house_info` VALUES ('10026', '2', '商品房', '8000', '200', '南', '租售', '押一付一', '【交通出行】楼下普君北路公交站，市十中公交站，普君北路地铁站。北向是东方广场，南向是普君市场，西向是祖庙，东向是桂城，交通十分便利。【周边配套】普君市场，百佳超市，普君北路地铁站，兆祥公园，普君步行街，市二医院，佛山远大医院，佛山第十中学，佛山第十一中学，佛山第九小学，兴业银行，农业银行，建设银行等【小区介绍】小区位于普君北路地铁站，小区楼下就是地铁C出口。小区共为3栋5座楼，在兆祥路和市东下路交汇处。停车位充足，物管处月租800元，含管理费。', '21551950152763', '4室2厅3卫');
INSERT INTO `house_info` VALUES ('10027', '1', '商品房', '3300', '132', '东南', '租售', '押一付一', '环境好，交通便利', '11552876208608', '3室2厅2卫');
INSERT INTO `house_info` VALUES ('10030', '1', '公寓', '1450', '39', '东南', '租售', '押一付一', '品质租房，时尚白领，写意生活', '11553159555713', '1室0厅1卫');

-- ----------------------------
-- Table structure for website_count
-- ----------------------------
DROP TABLE IF EXISTS `website_count`;
CREATE TABLE `website_count` (
  `time` varchar(200) NOT NULL COMMENT '当天时间',
  `visit_number_today` int(11) DEFAULT '0' COMMENT '今天的访问次数',
  `house_publish_number_today` int(11) DEFAULT '0' COMMENT '今天的房源发布量',
  `house_lower_shelf_number_today` int(11) DEFAULT '0' COMMENT '今天的新增用户量',
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of website_count
-- ----------------------------
INSERT INTO `website_count` VALUES ('2019-03-08', '55', '15', '2');
INSERT INTO `website_count` VALUES ('2019-03-09', '50', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-10', '33', '15', '2');
INSERT INTO `website_count` VALUES ('2019-03-11', '40', '14', '3');
INSERT INTO `website_count` VALUES ('2019-03-12', '30', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-13', '60', '15', '1');
INSERT INTO `website_count` VALUES ('2019-03-14', '44', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-15', '61', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-16', '48', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-17', '34', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-18', '43', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-19', '30', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-20', '25', '16', '1');
INSERT INTO `website_count` VALUES ('2019-03-21', '18', '18', '3');
INSERT INTO `website_count` VALUES ('2019-03-22', '47', '17', '4');
INSERT INTO `website_count` VALUES ('2019-03-23', '2', '0', '0');
