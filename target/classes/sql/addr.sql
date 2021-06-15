/*
 Navicat Premium Data Transfer

 Source Server         : LeeSQL
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : liushuang

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 05/06/2021 14:34:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for addr
-- ----------------------------
DROP TABLE IF EXISTS `addr`;
CREATE TABLE `addr`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `encode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mid` int(8) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
