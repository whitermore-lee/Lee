/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 50636
 Source Host           : localhost:3306
 Source Schema         : stumgr

 Target Server Type    : MySQL
 Target Server Version : 50636
 File Encoding         : 65001

 Date: 14/04/2022 10:43:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `empno` int(4) NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mgr` int(4) NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `sal` double(7, 2) NULL DEFAULT NULL,
  `comm` double(7, 2) NULL DEFAULT NULL,
  `deptno` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`empno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '李四', '后端工程师', 102, '2022-06-07', 15000.00, 3000.00, 1001);
INSERT INTO `employee` VALUES (2, 'l', 'li', 1, '1010-10-10', 23.00, 100.00, 1001);
INSERT INTO `employee` VALUES (3, 'liji', '前端', 2001, '2019-12-29', 8000.00, 7000.00, 2001);

SET FOREIGN_KEY_CHECKS = 1;
