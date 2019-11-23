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

 Date: 18/12/2018 15:26:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade_info
-- ----------------------------
DROP TABLE IF EXISTS `grade_info`;
CREATE TABLE `grade_info`  (
  `SID` int(9) NOT NULL,
  `CID` varchar(15) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Scores` int(5) NULL DEFAULT NULL,
  INDEX `cidfkey`(`CID`) USING BTREE,
  INDEX `sidfkey`(`SID`) USING BTREE,
  CONSTRAINT `cidfkey` FOREIGN KEY (`CID`) REFERENCES `course_info` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sidfkey` FOREIGN KEY (`SID`) REFERENCES `students_info` (`SID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = ascii COLLATE = ascii_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade_info
-- ----------------------------
INSERT INTO `grade_info` VALUES (101, '1011', 98);
INSERT INTO `grade_info` VALUES (101, '1012', 20);
INSERT INTO `grade_info` VALUES (101, '1013', 0);
INSERT INTO `grade_info` VALUES (101, '1014', 0);
INSERT INTO `grade_info` VALUES (101, '1015', 0);
INSERT INTO `grade_info` VALUES (101, '1016', 0);
INSERT INTO `grade_info` VALUES (101, '1017', 0);
INSERT INTO `grade_info` VALUES (101, '1018', 0);
INSERT INTO `grade_info` VALUES (106, '4014', 79);
INSERT INTO `grade_info` VALUES (106, '4015', 87);
INSERT INTO `grade_info` VALUES (107, '4014', 78);
INSERT INTO `grade_info` VALUES (107, '4015', 86);
INSERT INTO `grade_info` VALUES (108, '5011', 100);
INSERT INTO `grade_info` VALUES (108, '5014', 94);
INSERT INTO `grade_info` VALUES (101, '1019', 0);
INSERT INTO `grade_info` VALUES (101, '1020', 0);
INSERT INTO `grade_info` VALUES (101, '1021', 0);
INSERT INTO `grade_info` VALUES (101, '1022', 0);
INSERT INTO `grade_info` VALUES (101, '1023', 0);
INSERT INTO `grade_info` VALUES (101, '1024', 0);
INSERT INTO `grade_info` VALUES (101, '1025', 0);
INSERT INTO `grade_info` VALUES (101, '1026', 0);
INSERT INTO `grade_info` VALUES (101, '1027', 0);
INSERT INTO `grade_info` VALUES (101, '1028', 0);

SET FOREIGN_KEY_CHECKS = 1;
