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

 Date: 18/12/2018 15:26:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for majors_info
-- ----------------------------
DROP TABLE IF EXISTS `majors_info`;
CREATE TABLE `majors_info`  (
  `MID` varchar(30) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Major_name` varchar(30) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE,
  INDEX `MID`(`MID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = ascii COLLATE = ascii_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of majors_info
-- ----------------------------
INSERT INTO `majors_info` VALUES ('CE47', 'Civil Engineering');
INSERT INTO `majors_info` VALUES ('CS50', 'Computer Science');
INSERT INTO `majors_info` VALUES ('EE46', 'Electrical Engineering');
INSERT INTO `majors_info` VALUES ('ME49', 'Mechatronics');
INSERT INTO `majors_info` VALUES ('PH48', 'Pharmacy');

SET FOREIGN_KEY_CHECKS = 1;
