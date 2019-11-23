/*
 Navicat Premium Data Transfer

 Source Server         : Class_Exs
 Source Server Type    : MySQL
 Source Server Version : 50132
 Source Host           : localhost:3306
 Source Schema         : student_management

 Target Server Type    : MySQL
 Target Server Version : 50132
 File Encoding         : 65001

 Date: 18/12/2018 15:26:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for relatives_info
-- ----------------------------
DROP TABLE IF EXISTS `relatives_info`;
CREATE TABLE `relatives_info`  (
  `Parent_Password` varchar(20) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Stu_ID` int(9) NULL DEFAULT NULL,
  `relation` varchar(30) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `relative_name` varchar(50) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  INDEX `sidfkey1`(`Stu_ID`) USING BTREE,
  CONSTRAINT `sidfkey1` FOREIGN KEY (`Stu_ID`) REFERENCES `students_info` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = ascii COLLATE = ascii_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of relatives_info
-- ----------------------------
INSERT INTO `relatives_info` VALUES ('23071993port', 106, '', '');
INSERT INTO `relatives_info` VALUES ('1322307tty', 107, '', '');
INSERT INTO `relatives_info` VALUES ('aaddxx123', 108, '', '');
INSERT INTO `relatives_info` VALUES ('joakim0000', 101, 'Father', 'Masimba');
INSERT INTO `relatives_info` VALUES ('joakim0000', 101, 'Mother', 'Joy');

SET FOREIGN_KEY_CHECKS = 1;
