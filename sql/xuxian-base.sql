/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.147.132
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 192.168.147.132:3306
 Source Schema         : xuxian-base

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 17/07/2020 20:10:51
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_label
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label`
(
    `id`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `label_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `state`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `count`      int(8) NULL DEFAULT NULL,
    `fans`       int(8) NULL DEFAULT NULL,
    `recommend`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_label
-- ----------------------------
INSERT INTO `tb_label`
VALUES ('1283041747022118912', '1', '11', 111, 11111, '');
INSERT INTO `tb_label`
VALUES ('1283041923300327424', '1', '1', 1, 1, '');
INSERT INTO `tb_label`
VALUES ('1283043311904411648', '2', '1', 1, 1, '');

SET
FOREIGN_KEY_CHECKS = 1;
