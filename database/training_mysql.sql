/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : training

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 11/04/2018 16:46:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_organization
-- ----------------------------
DROP TABLE IF EXISTS `tbl_organization`;
CREATE TABLE `tbl_organization` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '组织名',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `code` varchar(64) NOT NULL COMMENT '编号',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级主键',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='组织机构';

-- ----------------------------
-- Records of tbl_organization
-- ----------------------------
BEGIN;
INSERT INTO `tbl_organization` VALUES (1, '总经办', '王家桥', '01', 'glyphicon-lock ', NULL, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_organization` VALUES (3, '技术部', '', '02', 'glyphicon-wrench ', NULL, 1, '2015-10-01 13:10:42');
INSERT INTO `tbl_organization` VALUES (5, '产品部', '', '03', 'glyphicon-send ', NULL, 2, '2015-12-06 12:15:30');
INSERT INTO `tbl_organization` VALUES (6, '测试组', '', '04', 'glyphicon-headphones ', 3, 0, '2015-12-06 13:12:18');
COMMIT;

-- ----------------------------
-- Table structure for tbl_resource
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resource`;
CREATE TABLE `tbl_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` varchar(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级资源id',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `opened` tinyint(2) NOT NULL DEFAULT '1' COMMENT '打开状态',
  `resource_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of tbl_resource
-- ----------------------------
BEGIN;
INSERT INTO `tbl_resource` VALUES (1, '权限管理', '', '', '系统管理', 'glyphicon-folder-open ', NULL, 0, 0, 1, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (11, '资源管理', '/resource/manager', 'ajax', '资源管理', 'glyphicon-th ', 1, 1, 0, 1, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (12, '角色管理', '/role/manager', 'ajax', '角色管理', 'glyphicon-eye-open ', 1, 2, 0, 1, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (13, '用户管理', '/user/manager', 'ajax', '用户管理', 'glyphicon-user ', 1, 3, 0, 1, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (14, '部门管理', '/organization/manager', 'ajax', '部门管理', 'glyphicon-lock ', 1, 4, 0, 1, 0, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (111, '列表', '/resource/treeGrid', 'ajax', '资源列表', 'glyphicon-list ', 11, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (112, '添加', '/resource/add', 'ajax', '资源添加', 'glyphicon-plus icon-green', 11, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (113, '编辑', '/resource/edit', 'ajax', '资源编辑', 'glyphicon-pencil icon-blue', 11, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (114, '删除', '/resource/delete', 'ajax', '资源删除', 'glyphicon-trash icon-red', 11, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (121, '列表', '/role/dataGrid', 'ajax', '角色列表', 'glyphicon-list ', 12, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (122, '添加', '/role/add', 'ajax', '角色添加', 'glyphicon-plus icon-green', 12, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (123, '编辑', '/role/edit', 'ajax', '角色编辑', 'glyphicon-pencil icon-blue', 12, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (124, '删除', '/role/delete', 'ajax', '角色删除', 'glyphicon-trash icon-red', 12, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (125, '授权', '/role/grant', 'ajax', '角色授权', 'glyphicon-ok icon-green', 12, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (131, '列表', '/user/dataGrid', 'ajax', '用户列表', 'glyphicon-list ', 13, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (132, '添加', '/user/add', 'ajax', '用户添加', 'glyphicon-plus icon-green', 13, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (133, '编辑', '/user/edit', 'ajax', '用户编辑', 'glyphicon-pencil icon-blue', 13, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (134, '删除', '/user/delete', 'ajax', '用户删除', 'glyphicon-trash icon-red', 13, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (141, '列表', '/organization/treeGrid', 'ajax', '用户列表', 'glyphicon-list ', 14, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (142, '添加', '/organization/add', 'ajax', '部门添加', 'glyphicon-plus icon-green', 14, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (143, '编辑', '/organization/edit', 'ajax', '部门编辑', 'glyphicon-pencil icon-blue', 14, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (144, '删除', '/organization/delete', 'ajax', '部门删除', 'glyphicon-trash icon-red', 14, 0, 0, 1, 1, '2014-02-19 01:00:00');
INSERT INTO `tbl_resource` VALUES (221, '日志监控', '', '', NULL, 'glyphicon-dashboard ', NULL, 3, 0, 0, 0, '2015-12-01 11:44:20');
INSERT INTO `tbl_resource` VALUES (222, '视频教程', '', '', NULL, 'glyphicon-film ', NULL, 2, 0, 0, 0, '2015-12-06 12:40:42');
INSERT INTO `tbl_resource` VALUES (223, '官方网站', 'https://www.dreamlu.net', 'iframe', NULL, 'glyphicon-globe ', 222, 0, 0, 1, 0, '2015-12-06 12:42:42');
INSERT INTO `tbl_resource` VALUES (224, 'jfinal视频', 'http://blog.dreamlu.net/blog/79', 'iframe', NULL, 'glyphicon-blackboard ', 222, 1, 0, 1, 0, '2015-12-06 12:45:28');
INSERT INTO `tbl_resource` VALUES (226, '修改密码', '/user/editPwdPage', 'ajax', NULL, 'glyphicon-eye-close ', NULL, 4, 0, 1, 1, '2015-12-07 20:23:06');
INSERT INTO `tbl_resource` VALUES (227, '登录日志', '/sysLog/manager', 'ajax', NULL, 'glyphicon-exclamation-sign ', 221, 0, 0, 1, 0, '2016-09-30 22:10:53');
INSERT INTO `tbl_resource` VALUES (228, 'Druid监控', '/druid', 'iframe', NULL, 'glyphicon-sunglasses ', 221, 0, 0, 1, 0, '2016-09-30 22:12:50');
INSERT INTO `tbl_resource` VALUES (229, '系统图标', '/icons.html', 'ajax', NULL, 'glyphicon-picture ', 221, 0, 0, 1, 0, '2016-12-24 15:53:47');
INSERT INTO `tbl_resource` VALUES (230, '文章管理', '', 'ajax', NULL, 'glyphicon-duplicate ', NULL, 1, 0, 0, 0, '2016-12-24 15:53:47');
INSERT INTO `tbl_resource` VALUES (231, '新建文章', '/article/create', 'ajax', NULL, 'glyphicon-open-file ', 230, 0, 0, 1, 0, '2016-12-24 15:53:47');
COMMIT;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role` VALUES (1, 'admin', 0, '超级管理员', 0);
INSERT INTO `tbl_role` VALUES (2, 'de', 0, '技术部经理', 0);
INSERT INTO `tbl_role` VALUES (7, 'pm', 0, '产品部经理', 0);
INSERT INTO `tbl_role` VALUES (8, 'test', 0, '测试账户', 0);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_resource`;
CREATE TABLE `tbl_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`),
  KEY `idx_role_resource_ids` (`role_id`,`resource_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=481 DEFAULT CHARSET=utf8 COMMENT='角色资源';

-- ----------------------------
-- Records of tbl_role_resource
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role_resource` VALUES (409, 1, 1);
INSERT INTO `tbl_role_resource` VALUES (410, 1, 11);
INSERT INTO `tbl_role_resource` VALUES (415, 1, 12);
INSERT INTO `tbl_role_resource` VALUES (421, 1, 13);
INSERT INTO `tbl_role_resource` VALUES (426, 1, 14);
INSERT INTO `tbl_role_resource` VALUES (411, 1, 111);
INSERT INTO `tbl_role_resource` VALUES (412, 1, 112);
INSERT INTO `tbl_role_resource` VALUES (413, 1, 113);
INSERT INTO `tbl_role_resource` VALUES (414, 1, 114);
INSERT INTO `tbl_role_resource` VALUES (416, 1, 121);
INSERT INTO `tbl_role_resource` VALUES (417, 1, 122);
INSERT INTO `tbl_role_resource` VALUES (418, 1, 123);
INSERT INTO `tbl_role_resource` VALUES (419, 1, 124);
INSERT INTO `tbl_role_resource` VALUES (420, 1, 125);
INSERT INTO `tbl_role_resource` VALUES (422, 1, 131);
INSERT INTO `tbl_role_resource` VALUES (423, 1, 132);
INSERT INTO `tbl_role_resource` VALUES (424, 1, 133);
INSERT INTO `tbl_role_resource` VALUES (425, 1, 134);
INSERT INTO `tbl_role_resource` VALUES (427, 1, 141);
INSERT INTO `tbl_role_resource` VALUES (428, 1, 142);
INSERT INTO `tbl_role_resource` VALUES (429, 1, 143);
INSERT INTO `tbl_role_resource` VALUES (430, 1, 144);
INSERT INTO `tbl_role_resource` VALUES (434, 1, 221);
INSERT INTO `tbl_role_resource` VALUES (431, 1, 222);
INSERT INTO `tbl_role_resource` VALUES (432, 1, 223);
INSERT INTO `tbl_role_resource` VALUES (433, 1, 224);
INSERT INTO `tbl_role_resource` VALUES (435, 1, 227);
INSERT INTO `tbl_role_resource` VALUES (436, 1, 228);
INSERT INTO `tbl_role_resource` VALUES (437, 2, 1);
INSERT INTO `tbl_role_resource` VALUES (438, 2, 13);
INSERT INTO `tbl_role_resource` VALUES (439, 2, 131);
INSERT INTO `tbl_role_resource` VALUES (440, 2, 132);
INSERT INTO `tbl_role_resource` VALUES (441, 2, 133);
INSERT INTO `tbl_role_resource` VALUES (445, 2, 221);
INSERT INTO `tbl_role_resource` VALUES (442, 2, 222);
INSERT INTO `tbl_role_resource` VALUES (443, 2, 223);
INSERT INTO `tbl_role_resource` VALUES (444, 2, 224);
INSERT INTO `tbl_role_resource` VALUES (446, 2, 227);
INSERT INTO `tbl_role_resource` VALUES (447, 2, 228);
INSERT INTO `tbl_role_resource` VALUES (158, 3, 1);
INSERT INTO `tbl_role_resource` VALUES (159, 3, 11);
INSERT INTO `tbl_role_resource` VALUES (164, 3, 12);
INSERT INTO `tbl_role_resource` VALUES (170, 3, 13);
INSERT INTO `tbl_role_resource` VALUES (175, 3, 14);
INSERT INTO `tbl_role_resource` VALUES (160, 3, 111);
INSERT INTO `tbl_role_resource` VALUES (161, 3, 112);
INSERT INTO `tbl_role_resource` VALUES (162, 3, 113);
INSERT INTO `tbl_role_resource` VALUES (163, 3, 114);
INSERT INTO `tbl_role_resource` VALUES (165, 3, 121);
INSERT INTO `tbl_role_resource` VALUES (166, 3, 122);
INSERT INTO `tbl_role_resource` VALUES (167, 3, 123);
INSERT INTO `tbl_role_resource` VALUES (168, 3, 124);
INSERT INTO `tbl_role_resource` VALUES (169, 3, 125);
INSERT INTO `tbl_role_resource` VALUES (171, 3, 131);
INSERT INTO `tbl_role_resource` VALUES (172, 3, 132);
INSERT INTO `tbl_role_resource` VALUES (173, 3, 133);
INSERT INTO `tbl_role_resource` VALUES (174, 3, 134);
INSERT INTO `tbl_role_resource` VALUES (176, 3, 141);
INSERT INTO `tbl_role_resource` VALUES (177, 3, 142);
INSERT INTO `tbl_role_resource` VALUES (178, 3, 143);
INSERT INTO `tbl_role_resource` VALUES (179, 3, 144);
INSERT INTO `tbl_role_resource` VALUES (359, 7, 1);
INSERT INTO `tbl_role_resource` VALUES (360, 7, 14);
INSERT INTO `tbl_role_resource` VALUES (361, 7, 141);
INSERT INTO `tbl_role_resource` VALUES (362, 7, 142);
INSERT INTO `tbl_role_resource` VALUES (363, 7, 143);
INSERT INTO `tbl_role_resource` VALUES (367, 7, 221);
INSERT INTO `tbl_role_resource` VALUES (364, 7, 222);
INSERT INTO `tbl_role_resource` VALUES (365, 7, 223);
INSERT INTO `tbl_role_resource` VALUES (366, 7, 224);
INSERT INTO `tbl_role_resource` VALUES (368, 7, 226);
INSERT INTO `tbl_role_resource` VALUES (448, 8, 1);
INSERT INTO `tbl_role_resource` VALUES (449, 8, 11);
INSERT INTO `tbl_role_resource` VALUES (451, 8, 12);
INSERT INTO `tbl_role_resource` VALUES (453, 8, 13);
INSERT INTO `tbl_role_resource` VALUES (455, 8, 14);
INSERT INTO `tbl_role_resource` VALUES (450, 8, 111);
INSERT INTO `tbl_role_resource` VALUES (452, 8, 121);
INSERT INTO `tbl_role_resource` VALUES (454, 8, 131);
INSERT INTO `tbl_role_resource` VALUES (456, 8, 141);
INSERT INTO `tbl_role_resource` VALUES (460, 8, 221);
INSERT INTO `tbl_role_resource` VALUES (457, 8, 222);
INSERT INTO `tbl_role_resource` VALUES (458, 8, 223);
INSERT INTO `tbl_role_resource` VALUES (459, 8, 224);
INSERT INTO `tbl_role_resource` VALUES (461, 8, 227);
INSERT INTO `tbl_role_resource` VALUES (462, 8, 228);
INSERT INTO `tbl_role_resource` VALUES (478, 8, 229);
INSERT INTO `tbl_role_resource` VALUES (479, 8, 230);
INSERT INTO `tbl_role_resource` VALUES (480, 8, 231);
COMMIT;

-- ----------------------------
-- Table structure for tbl_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_log`;
CREATE TABLE `tbl_sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `opt_content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(64) NOT NULL COMMENT '登陆名',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(36) DEFAULT NULL COMMENT '密码加密盐',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` tinyint(2) DEFAULT '0' COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户类别',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `organization_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属机构',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDx_user_login_name` (`login_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES (1, 'admin', 'admin', '05a671c66aefea124cc08b76ea6d30bb', 'test', 0, 25, '18707173376', 0, 0, 1, '2015-12-06 13:14:05');
INSERT INTO `tbl_user` VALUES (13, 'snoopy', 'snoopy', '05a671c66aefea124cc08b76ea6d30bb', 'test', 0, 25, '18707173376', 1, 0, 3, '2015-10-01 13:12:07');
INSERT INTO `tbl_user` VALUES (14, 'dreamlu', 'dreamlu', '05a671c66aefea124cc08b76ea6d30bb', 'test', 0, 25, '18707173376', 1, 0, 5, '2015-10-11 23:12:58');
INSERT INTO `tbl_user` VALUES (15, 'test', 'test', '05a671c66aefea124cc08b76ea6d30bb', 'test', 0, 25, '18707173376', 1, 0, 6, '2015-12-06 13:13:03');
COMMIT;

-- ----------------------------
-- Table structure for tbl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(19) NOT NULL COMMENT '用户id',
  `role_id` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `idx_user_role_ids` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of tbl_user_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user_role` VALUES (60, 1, 1);
INSERT INTO `tbl_user_role` VALUES (61, 1, 2);
INSERT INTO `tbl_user_role` VALUES (62, 1, 7);
INSERT INTO `tbl_user_role` VALUES (65, 1, 8);
INSERT INTO `tbl_user_role` VALUES (63, 13, 2);
INSERT INTO `tbl_user_role` VALUES (64, 14, 7);
INSERT INTO `tbl_user_role` VALUES (53, 15, 8);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
