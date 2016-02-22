/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : ljk

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2015-11-24 21:50:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xker_dperation
-- ----------------------------
DROP TABLE IF EXISTS `xker_dperation`;
CREATE TABLE `xker_dperation` (
  `dperation_id` varchar(32) NOT NULL,
  `dperation_name` varchar(16) DEFAULT NULL COMMENT '名称',
  `dperation_code` varchar(16) DEFAULT NULL COMMENT '编码',
  `dperation_url_prefix` varchar(16) DEFAULT NULL COMMENT '拦截url前缀',
  `dperation_parent` varchar(32) DEFAULT NULL COMMENT '上级',
  `dperation_create` varchar(32) DEFAULT NULL COMMENT '创建人',
  `dperation_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dperation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能操作表';

-- ----------------------------
-- Records of xker_dperation
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_authority
-- ----------------------------
DROP TABLE IF EXISTS `xkey_authority`;
CREATE TABLE `xkey_authority` (
  `authority_id` varchar(32) NOT NULL,
  `authority_type` varchar(16) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of xkey_authority
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_authority_dperation
-- ----------------------------
DROP TABLE IF EXISTS `xkey_authority_dperation`;
CREATE TABLE `xkey_authority_dperation` (
  `authority` varchar(32) NOT NULL,
  `dperation` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_authority_dperation
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_element
-- ----------------------------
DROP TABLE IF EXISTS `xkey_element`;
CREATE TABLE `xkey_element` (
  `element_id` varchar(32) NOT NULL,
  `element_code` varchar(32) DEFAULT NULL COMMENT '编码',
  PRIMARY KEY (`element_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面元素表';

-- ----------------------------
-- Records of xkey_element
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_element_authority
-- ----------------------------
DROP TABLE IF EXISTS `xkey_element_authority`;
CREATE TABLE `xkey_element_authority` (
  `element` varchar(32) NOT NULL,
  `authority` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_element_authority
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_menu
-- ----------------------------
DROP TABLE IF EXISTS `xkey_menu`;
CREATE TABLE `xkey_menu` (
  `menu_id` varchar(32) NOT NULL,
  `menu_name` varchar(16) DEFAULT NULL COMMENT '菜单名称',
  `menu_depcit` varchar(64) DEFAULT NULL COMMENT '描述',
  `menu_url` varchar(128) DEFAULT NULL COMMENT '目标地址',
  `menu_parent` varchar(32) DEFAULT NULL COMMENT '上级',
  `menu_sort` int(11) DEFAULT '0' COMMENT '排序',
  `menu_create` varchar(32) DEFAULT NULL COMMENT '创建人',
  `menu_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of xkey_menu
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_menu_authority
-- ----------------------------
DROP TABLE IF EXISTS `xkey_menu_authority`;
CREATE TABLE `xkey_menu_authority` (
  `menu` varchar(32) NOT NULL,
  `authority` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_menu_authority
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_organize
-- ----------------------------
DROP TABLE IF EXISTS `xkey_organize`;
CREATE TABLE `xkey_organize` (
  `organize_id` varchar(32) NOT NULL,
  `organize_name` varchar(16) DEFAULT NULL COMMENT '名称',
  `organize_depcit` varchar(64) DEFAULT NULL COMMENT '描述',
  `organize_parent` varchar(32) DEFAULT NULL COMMENT '上级',
  `organize_create` varchar(32) DEFAULT NULL COMMENT '创建人',
  `organize_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`organize_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of xkey_organize
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_organize_role
-- ----------------------------
DROP TABLE IF EXISTS `xkey_organize_role`;
CREATE TABLE `xkey_organize_role` (
  `organize` varchar(32) NOT NULL,
  `role` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_organize_role
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_role
-- ----------------------------
DROP TABLE IF EXISTS `xkey_role`;
CREATE TABLE `xkey_role` (
  `role_id` varchar(32) NOT NULL,
  `role_name` varchar(16) DEFAULT NULL COMMENT '角色名称',
  `role_depcit` varchar(64) DEFAULT NULL COMMENT '描述',
  `role_create` varchar(32) DEFAULT NULL COMMENT '创建人',
  `role_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of xkey_role
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `xkey_role_authority`;
CREATE TABLE `xkey_role_authority` (
  `role` varchar(32) NOT NULL,
  `authority` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_role_authority
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_user
-- ----------------------------
DROP TABLE IF EXISTS `xkey_user`;
CREATE TABLE `xkey_user` (
  `user_id` varchar(32) NOT NULL,
  `user_account` varchar(16) DEFAULT NULL COMMENT '账号',
  `user_password` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_flag` tinyint(4) DEFAULT NULL COMMENT '标识',
  `user_create` varchar(32) DEFAULT NULL COMMENT '创建人',
  `user_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of xkey_user
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_user_organize
-- ----------------------------
DROP TABLE IF EXISTS `xkey_user_organize`;
CREATE TABLE `xkey_user_organize` (
  `user` varchar(32) NOT NULL,
  `organize` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_user_organize
-- ----------------------------

-- ----------------------------
-- Table structure for xkey_user_role
-- ----------------------------
DROP TABLE IF EXISTS `xkey_user_role`;
CREATE TABLE `xkey_user_role` (
  `user` varchar(32) NOT NULL,
  `role` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xkey_user_role
-- ----------------------------
