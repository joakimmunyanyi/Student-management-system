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

 Date: 18/12/2018 15:26:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info`  (
  `MID` varchar(20) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `CID` varchar(15) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Course_name` varchar(50) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `Semester` int(1) NOT NULL COMMENT '2 semesters = 1 year',
  `C_Year` int(1) NOT NULL,
  PRIMARY KEY (`CID`) USING BTREE,
  INDEX `midforeignKey 3`(`MID`) USING BTREE,
  INDEX `CID`(`CID`) USING BTREE,
  CONSTRAINT `midforeignKey 3` FOREIGN KEY (`MID`) REFERENCES `majors_info` (`MID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = ascii COLLATE = ascii_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('CS50', '1011', 'Intro to Computers', 1, 2);
INSERT INTO `course_info` VALUES ('CS50', '1012', 'C', 1, 2);
INSERT INTO `course_info` VALUES ('CS50', '1013', 'C++', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1014', 'Java', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1015', 'SQL Databases', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1016', 'Data Structs & Algorithms', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1017', 'Digital Logic', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1018', 'Python', 2, 2);
INSERT INTO `course_info` VALUES ('CS50', '1019', 'linux', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1020', 'Computer Composition Principle', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1021', '3D Max', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1022', 'Operating Systems', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1023', 'Computer Network principles', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1024', 'Web page Design (HTML)', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1025', 'Web Systems and technology', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1026', 'E-commerce', 1, 3);
INSERT INTO `course_info` VALUES ('CS50 ', '1027', 'Computer network course design ', 1, 3);
INSERT INTO `course_info` VALUES ('CS50', '1028', 'Web system and tech course design', 1, 3);
INSERT INTO `course_info` VALUES ('PH48', '3001', 'Inorganic Chemistry', 1, 2);
INSERT INTO `course_info` VALUES ('PH48', '3002', 'Human Anatomy', 1, 2);
INSERT INTO `course_info` VALUES ('PH48', '3003', 'Pathiophysiology', 2, 2);
INSERT INTO `course_info` VALUES ('PH48', '3004', 'Organic Chemistry', 2, 2);
INSERT INTO `course_info` VALUES ('PH48', '3005', 'Bio Chemistry', 2, 2);
INSERT INTO `course_info` VALUES ('PH48', '3006', 'Traditional Chinese Pharmacology', 2, 2);
INSERT INTO `course_info` VALUES ('CE47', '4011', 'Theoratical Mechanics', 2, 2);
INSERT INTO `course_info` VALUES ('CE47', '4012', 'Building Construction', 2, 2);
INSERT INTO `course_info` VALUES ('CE47', '4013', 'Engineering Materials', 2, 2);
INSERT INTO `course_info` VALUES ('CE47', '4014', 'Auto CAD', 1, 2);
INSERT INTO `course_info` VALUES ('CE47', '4015', 'Engineering Graphics', 0, 0);
INSERT INTO `course_info` VALUES ('CE47', '4016', 'Engineering Surveying', 2, 2);
INSERT INTO `course_info` VALUES ('EE46', '5011', 'Mechanical materials', 2, 2);
INSERT INTO `course_info` VALUES ('EE46', '5012', 'C programming', 2, 2);
INSERT INTO `course_info` VALUES ('EE46', '5013', 'Electronics', 2, 2);
INSERT INTO `course_info` VALUES ('EE46', '5014', 'Engineering Drawing', 1, 2);
INSERT INTO `course_info` VALUES ('EE46', '5015', 'Electronics practicals', 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
