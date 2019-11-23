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

 Date: 18/12/2018 15:26:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teachers_info
-- ----------------------------
DROP TABLE IF EXISTS `teachers_info`;
CREATE TABLE `teachers_info`  (
  `TID` int(9) NOT NULL,
  `Teacher_name` varchar(50) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL,
  `MID` varchar(35) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Office No` varchar(100) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TID`) USING BTREE,
  INDEX `midForeignKey2`(`MID`) USING BTREE,
  CONSTRAINT `midForeignKey2` FOREIGN KEY (`MID`) REFERENCES `majors_info` (`MID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = ascii COLLATE = ascii_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teachers_info
-- ----------------------------
INSERT INTO `teachers_info` VALUES (461, 'li', 'EE46', '');
INSERT INTO `teachers_info` VALUES (471, 'Zheng Kai Xuan', 'CE47', NULL);
INSERT INTO `teachers_info` VALUES (472, 'Ou mang', 'CE47', NULL);
INSERT INTO `teachers_info` VALUES (473, 'Xie XiaoJie', 'CE47', NULL);
INSERT INTO `teachers_info` VALUES (474, 'Luo Lin', 'CE47', NULL);
INSERT INTO `teachers_info` VALUES (481, 'li', 'PH48', '');
INSERT INTO `teachers_info` VALUES (491, 'Li Yen', 'ME49', NULL);
INSERT INTO `teachers_info` VALUES (501, 'Ouyang', 'CS50', 'XK 402');
INSERT INTO `teachers_info` VALUES (502, 'Sun Bing', 'CS50', '');
INSERT INTO `teachers_info` VALUES (503, 'Li jing jing', 'CS50', '');
INSERT INTO `teachers_info` VALUES (504, 'Mao jian jing', 'CS50', '');
INSERT INTO `teachers_info` VALUES (505, 'TanTongDe', 'CS50', '');
INSERT INTO `teachers_info` VALUES (506, 'Feng  Nai Qin', 'CS50', NULL);
INSERT INTO `teachers_info` VALUES (507, 'Feng Meng Qing', 'CS50', NULL);
INSERT INTO `teachers_info` VALUES (508, 'Yao Yin le', 'CS50', NULL);

SET FOREIGN_KEY_CHECKS = 1;
