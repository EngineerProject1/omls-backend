/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : olms

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 14/06/2023 08:39:24
*/

SET NAMES utf8mb4;
drop database if exists 'olms';
create database 'olms';
use olms;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_appointment
-- ----------------------------
DROP TABLE IF EXISTS `sys_appointment`;
CREATE TABLE `sys_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约信息表的id',
  `user_id` int NOT NULL COMMENT '预约的用户',
  `lab_id` int NOT NULL COMMENT '预约的实验室',
  `experiment_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验名称',
  `purpose` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '目的',
  `book_time` date NOT NULL COMMENT '实验预约的时间(预约的哪一天)',
  `time_slot_id` int NOT NULL COMMENT '时间段的id',
  `type` enum('1','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '实验性质，1-班级，0-个人',
  `major_id` int NULL DEFAULT NULL COMMENT '专业id',
  `grade` int NULL DEFAULT NULL COMMENT '预约年级',
  `class_number` int NULL DEFAULT NULL COMMENT '预约班级',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '预约时间段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` enum('0','1','2') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '状态 0:待审核，1:审核通过，2:审核不通过',
  PRIMARY KEY (`id`, `book_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '预约信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_appointment
-- ----------------------------
INSERT INTO `sys_appointment` VALUES (1, 4, 1, '2312312321312', '23123123123', '2023-06-05', 1, '0', NULL, NULL, NULL, '08:00:00 ~ 10:00:00', '2023-06-04 17:07:02', '2023-06-04 17:07:02', '1');
INSERT INTO `sys_appointment` VALUES (3, 1, 29, 'ffffffa', 'aaaaaaaa', '2023-06-04', 5, '1', 1, 2021, 3, '00:00:00 ~ 23:59:00', '2023-06-04 17:17:39', '2023-06-04 17:17:39', '1');
INSERT INTO `sys_appointment` VALUES (4, 4, 1, '3213123', '2312312312', '2023-06-06', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 12:16:42', '2023-06-06 12:16:42', '1');
INSERT INTO `sys_appointment` VALUES (6, 2, 1, '3123213', '213213213123', '2023-06-06', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 12:30:05', '2023-06-06 12:30:05', '1');
INSERT INTO `sys_appointment` VALUES (7, 1, 1, 'r565g67h', '76u76i867h6h', '2023-06-07', 1, '1', 17, 2007, 4, '08:00:00 ~ 10:00:00', '2023-06-06 14:30:49', '2023-06-06 14:30:49', '1');
INSERT INTO `sys_appointment` VALUES (8, 3, 30, 'aaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', '2023-06-06', 3, '1', 1, 2007, 6, '14:00:00 ~ 16:00:00', '2023-06-06 15:12:54', '2023-06-06 15:12:54', '1');
INSERT INTO `sys_appointment` VALUES (9, 2, 4, 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', '2023-06-10', 3, '0', NULL, NULL, NULL, '14:00:00 ~ 16:00:00', '2023-06-06 15:15:18', '2023-06-06 15:15:18', '1');
INSERT INTO `sys_appointment` VALUES (10, 3, 4, '不要随便删除这条', '测试设备借用', '2023-06-09', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-08 15:46:35', '2023-06-08 15:46:39', '1');
INSERT INTO `sys_appointment` VALUES (11, 5, 4, 'adadadasd', 'sdaadasdasdasd', '2023-06-07', 1, '0', NULL, NULL, NULL, '08:00:00 ~ 10:00:00', '2023-06-06 16:04:51', '2023-06-06 16:04:51', '1');
INSERT INTO `sys_appointment` VALUES (13, 3, 1, 'bbbbbb', 'bbbbbbbbb', '2023-06-06', 5, '1', 14, 2006, 7, '00:00:00 ~ 23:59:00', '2023-06-06 16:08:31', '2023-06-06 16:08:31', '1');
INSERT INTO `sys_appointment` VALUES (14, 5, 59, 'adasdadsadad', 'dadadadasda', '2023-06-06', 4, '0', NULL, NULL, NULL, '16:00:00 ~ 18:00:00', '2023-06-06 16:17:54', '2023-06-06 16:17:54', '1');
INSERT INTO `sys_appointment` VALUES (18, 6, 4, 'fsdfsdf', 'fdsfsadcvcxvxczvdsvz', '2023-06-06', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 17:07:58', '2023-06-06 17:07:58', '1');
INSERT INTO `sys_appointment` VALUES (19, 6, 1, '考勤测试', '考勤测试考勤测试', '2023-06-06', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 17:10:25', '2023-06-06 17:10:25', '1');
INSERT INTO `sys_appointment` VALUES (20, 6, 29, '考勤测测', '考勤测测考勤测测', '2023-06-06', 1, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 17:11:11', '2023-06-06 17:11:11', '1');
INSERT INTO `sys_appointment` VALUES (29, 1, 1, '我的测试，随便删我的测试，随便删', '我的测试，随便删我的测试，随便删我的测试，随便删', '2023-06-06', 4, '1', 4, 2007, 7, '16:00:00 ~ 18:00:00', '2023-06-06 21:42:01', '2023-06-06 21:42:01', '1');
INSERT INTO `sys_appointment` VALUES (30, 103, 4, 'count(*) `count`', 'count(*) `count`count(*) `count`', '2023-06-07', 4, '1', 12, 2006, 3, '16:00:00 ~ 18:00:00', '2023-06-06 21:44:05', '2023-06-06 21:44:05', '1');
INSERT INTO `sys_appointment` VALUES (31, 6, 4, 'jghjghfgj', 'jghjghjghj', '2023-06-07', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 23:15:09', '2023-06-06 23:15:09', '1');
INSERT INTO `sys_appointment` VALUES (33, 2, 4, 'mjuytjmt', 'mjhmjtjmt', '2023-06-07', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-06 23:17:36', '2023-06-06 23:17:36', '1');
INSERT INTO `sys_appointment` VALUES (38, 6, 32, 'jdfsjlkfjasdlfasgfdsshf', 'ghfgjdgjghkhffjk', '2023-06-07', 5, '1', 1, 2221, 1, '14:00:00 ~ 16:00:00', '2023-06-07 14:47:16', '2023-06-07 14:47:16', '1');
INSERT INTO `sys_appointment` VALUES (39, 6, 59, 'zx的考勤测试', 'zx的考勤测试sss', '2023-06-07', 5, '1', 1, 2021, 3, '00:00:00 ~ 23:59:00', '2023-06-07 15:33:10', '2023-06-07 15:33:10', '1');
INSERT INTO `sys_appointment` VALUES (40, 2, 57, 'zxzzxzxzxxz', 'xzzxxzxzxzxzxzxz', '2023-06-08', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-07 15:35:40', '2023-06-07 15:35:40', '1');
INSERT INTO `sys_appointment` VALUES (41, 5, 10, 'fdfsfsf', 'fsfsffdsfsd', '2023-06-08', 1, '0', NULL, NULL, NULL, '08:00:00 ~ 10:00:00', '2023-06-07 15:46:53', '2023-06-07 15:46:53', '1');
INSERT INTO `sys_appointment` VALUES (42, 5, 41, '广泛大使馆的', '广泛大使馆犯得上', '2023-06-07', 5, '0', NULL, NULL, NULL, '00:00:00 ~ 23:59:00', '2023-06-07 15:50:39', '2023-06-07 15:50:39', '1');
INSERT INTO `sys_appointment` VALUES (43, 103, 1, 'kdsafjkladsjfklsadf', 'fdsaklfjksaljfksad', '2023-06-08', 1, '0', NULL, NULL, NULL, '08:00:00 ~ 10:00:00', '2023-06-07 15:58:45', '2023-06-07 15:58:45', '1');
INSERT INTO `sys_appointment` VALUES (44, 27, 14, '发生发射点发射点发', '搞不好然后会让他', '2023-06-08', 5, '1', 1, 2021, 3, '00:00:00 ~ 23:59:00', '2023-06-08 20:52:39', '2023-06-08 20:52:39', '1');
INSERT INTO `sys_appointment` VALUES (45, 103, 1, '一套技能她和别人他根本v让他', '天人合一天人与会让他呼叫认同感和包容他', '2023-06-09', 1, '0', NULL, NULL, NULL, '08:00:00 ~ 10:00:00', '2023-06-08 21:31:35', '2023-06-08 21:31:35', '1');
INSERT INTO `sys_appointment` VALUES (48, 1, 1, '预约测试预约测试', '预约测试预约测试预约测试', '2023-06-08', 5, '1', 1, 2221, 1, '00:00:00 ~ 23:59:00', '2023-06-08 21:54:21', '2023-06-08 21:54:21', '1');
INSERT INTO `sys_appointment` VALUES (49, 10, 24, '预约测试', '预约测试预约测试', '2023-06-09', 1, '1', 1, 2221, 1, '08:00:00 ~ 10:00:00', '2023-06-08 22:17:34', '2023-06-08 22:17:34', '2');
INSERT INTO `sys_appointment` VALUES (50, 27, 14, 'ppt截图要用', 'ppt截图要用ppt截图要用', '2023-06-09', 5, '1', 1, 2021, 1, '00:00:00 ~ 23:59:00', '2023-06-09 12:40:40', '2023-06-09 12:40:40', '1');

-- ----------------------------
-- Table structure for sys_approval_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_approval_record`;
CREATE TABLE `sys_approval_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `appointment_id` bigint NOT NULL COMMENT '预约信息的id\r\n',
  `create_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '‘同意-1’，‘拒绝-0’',
  `refuse_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '拒绝理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '实验的审核记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_approval_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_attendance
-- ----------------------------
DROP TABLE IF EXISTS `sys_attendance`;
CREATE TABLE `sys_attendance`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '签到id',
  `user_id` bigint NOT NULL COMMENT '被考勤人员',
  `appointment_id` bigint NOT NULL COMMENT '预约记录id',
  `status` enum('0','1','2','3','4') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '考勤状态，0缺勤,1正常,2迟到,3早退,4请假',
  `absence_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原因',
  `create_time` datetime NOT NULL COMMENT '考勤创建时间',
  `update_time` datetime NOT NULL COMMENT '考勤修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_attendance_un`(`user_id` ASC, `appointment_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '签到表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_attendance
-- ----------------------------
INSERT INTO `sys_attendance` VALUES (1, 6, 31, '4', NULL, '2023-06-07 14:25:00', '2023-06-07 20:04:48');
INSERT INTO `sys_attendance` VALUES (2, 2, 33, '2', NULL, '2023-06-07 14:25:00', '2023-06-07 20:04:50');
INSERT INTO `sys_attendance` VALUES (4, 24, 38, '3', NULL, '2023-06-07 15:12:14', '2023-06-07 20:41:53');
INSERT INTO `sys_attendance` VALUES (5, 98, 38, '4', NULL, '2023-06-07 15:12:14', '2023-06-07 20:14:47');
INSERT INTO `sys_attendance` VALUES (6, 56, 38, '3', NULL, '2023-06-07 15:12:14', '2023-06-07 20:41:53');
INSERT INTO `sys_attendance` VALUES (7, 19, 38, '1', NULL, '2023-06-07 15:16:09', '2023-06-07 20:13:01');
INSERT INTO `sys_attendance` VALUES (8, 48, 38, '3', NULL, '2023-06-07 15:19:06', '2023-06-07 20:41:53');
INSERT INTO `sys_attendance` VALUES (9, 2, 39, '3', NULL, '2023-06-07 15:41:28', '2023-06-07 20:40:40');
INSERT INTO `sys_attendance` VALUES (10, 25, 39, '4', NULL, '2023-06-07 15:41:28', '2023-06-07 20:40:49');
INSERT INTO `sys_attendance` VALUES (12, 31, 39, '4', NULL, '2023-06-07 15:45:28', '2023-06-07 20:40:49');
INSERT INTO `sys_attendance` VALUES (13, 43, 39, '4', NULL, '2023-06-07 15:45:43', '2023-06-07 20:40:49');
INSERT INTO `sys_attendance` VALUES (14, 42, 39, '1', NULL, '2023-06-07 15:45:43', '2023-06-07 20:40:12');
INSERT INTO `sys_attendance` VALUES (15, 5, 42, '4', NULL, '2023-06-07 15:53:31', '2023-06-07 15:53:31');
INSERT INTO `sys_attendance` VALUES (16, 43, 30, '0', NULL, '2023-06-07 16:25:00', '2023-06-07 16:25:00');
INSERT INTO `sys_attendance` VALUES (17, 104, 39, '0', NULL, '2023-06-07 16:25:00', '2023-06-07 16:25:00');
INSERT INTO `sys_attendance` VALUES (18, 99, 38, '1', NULL, '2023-06-07 16:25:00', '2023-06-07 20:14:59');
INSERT INTO `sys_attendance` VALUES (19, 100, 38, '1', NULL, '2023-06-07 16:25:00', '2023-06-07 20:14:59');
INSERT INTO `sys_attendance` VALUES (20, 101, 38, '1', NULL, '2023-06-07 16:25:00', '2023-06-07 20:14:59');
INSERT INTO `sys_attendance` VALUES (21, 97, 38, '1', NULL, '2023-06-07 16:25:00', '2023-06-07 20:13:01');
INSERT INTO `sys_attendance` VALUES (23, 58, 39, '2', NULL, '2023-06-07 20:00:55', '2023-06-07 20:00:55');
INSERT INTO `sys_attendance` VALUES (24, 60, 39, '4', NULL, '2023-06-07 20:01:22', '2023-06-07 20:01:22');
INSERT INTO `sys_attendance` VALUES (25, 45, 39, '1', NULL, '2023-06-07 20:04:15', '2023-06-07 20:38:15');
INSERT INTO `sys_attendance` VALUES (26, 2, 40, '0', NULL, '2023-06-08 16:25:02', '2023-06-08 16:25:02');
INSERT INTO `sys_attendance` VALUES (27, 2, 44, '1', NULL, '2023-06-08 20:55:45', '2023-06-08 20:55:45');
INSERT INTO `sys_attendance` VALUES (28, 42, 44, '3', NULL, '2023-06-08 20:55:52', '2023-06-08 20:55:58');
INSERT INTO `sys_attendance` VALUES (29, 25, 44, '4', NULL, '2023-06-08 20:55:52', '2023-06-08 20:55:52');
INSERT INTO `sys_attendance` VALUES (30, 31, 44, '4', NULL, '2023-06-08 20:55:52', '2023-06-08 20:55:52');
INSERT INTO `sys_attendance` VALUES (31, 43, 44, '2', NULL, '2023-06-08 20:55:56', '2023-06-08 20:55:56');
INSERT INTO `sys_attendance` VALUES (32, 104, 44, '0', NULL, '2023-06-08 21:45:35', '2023-06-08 21:45:35');
INSERT INTO `sys_attendance` VALUES (33, 98, 47, '0', NULL, '2023-06-08 21:51:45', '2023-06-08 21:51:45');
INSERT INTO `sys_attendance` VALUES (34, 99, 48, '0', NULL, '2023-06-08 21:55:05', '2023-06-08 21:55:05');
INSERT INTO `sys_attendance` VALUES (35, 100, 48, '0', NULL, '2023-06-08 21:55:05', '2023-06-08 21:55:05');
INSERT INTO `sys_attendance` VALUES (36, 101, 48, '0', NULL, '2023-06-08 21:55:05', '2023-06-08 21:55:05');
INSERT INTO `sys_attendance` VALUES (37, 97, 48, '0', NULL, '2023-06-08 21:55:05', '2023-06-08 21:55:05');
INSERT INTO `sys_attendance` VALUES (41, 19, 50, '1', NULL, '2023-06-09 12:43:03', '2023-06-09 12:43:03');
INSERT INTO `sys_attendance` VALUES (42, 24, 50, '2', NULL, '2023-06-09 12:43:05', '2023-06-09 12:43:05');
INSERT INTO `sys_attendance` VALUES (43, 48, 50, '3', NULL, '2023-06-09 12:43:07', '2023-06-09 12:43:07');
INSERT INTO `sys_attendance` VALUES (44, 56, 50, '4', NULL, '2023-06-09 12:43:09', '2023-06-09 12:43:09');
INSERT INTO `sys_attendance` VALUES (45, 98, 50, '0', NULL, '2023-06-09 14:25:00', '2023-06-09 14:25:00');
INSERT INTO `sys_attendance` VALUES (46, 3, 10, '0', NULL, '2023-06-09 14:25:00', '2023-06-09 14:25:00');

-- ----------------------------
-- Table structure for sys_college
-- ----------------------------
DROP TABLE IF EXISTS `sys_college`;
CREATE TABLE `sys_college`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学院表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_college
-- ----------------------------
INSERT INTO `sys_college` VALUES (1, '软件工程学院');
INSERT INTO `sys_college` VALUES (2, '大气科学学院');
INSERT INTO `sys_college` VALUES (3, '资源环境学院');
INSERT INTO `sys_college` VALUES (4, '应用数学学院');
INSERT INTO `sys_college` VALUES (5, '统计学院');
INSERT INTO `sys_college` VALUES (6, '文化艺术学院');
INSERT INTO `sys_college` VALUES (7, '外国语学院');
INSERT INTO `sys_college` VALUES (8, '马克思主义学院');
INSERT INTO `sys_college` VALUES (9, '光电工程学院');
INSERT INTO `sys_college` VALUES (10, '区块链产业学院');
INSERT INTO `sys_college` VALUES (11, '管理学院');
INSERT INTO `sys_college` VALUES (12, '物流学院');
INSERT INTO `sys_college` VALUES (13, '电子工程学院');
INSERT INTO `sys_college` VALUES (14, '自动化学院');
INSERT INTO `sys_college` VALUES (15, '通信工程学院');
INSERT INTO `sys_college` VALUES (16, '计算机学院');
INSERT INTO `sys_college` VALUES (17, '网络安全学院');

-- ----------------------------
-- Table structure for sys_device
-- ----------------------------
DROP TABLE IF EXISTS `sys_device`;
CREATE TABLE `sys_device`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备名称',
  `price` double NOT NULL COMMENT '设备价格',
  `lab_id` bigint NULL DEFAULT NULL COMMENT '所属实验室',
  `model` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备型号',
  `images` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备图片',
  `status` enum('1','2','3','4','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '\'已被借用-2’,\'损坏-4\',\'可用-0\',’维修中-3,\'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_device
-- ----------------------------
INSERT INTO `sys_device` VALUES (1, 'Cherry', 948, 70, 'EII-801', '041a4858-afc7-4f1d-aa5b-5093b1046284.jpeg', '1');
INSERT INTO `sys_device` VALUES (2, 'Mkngo', 784.2, 58, 'IZK-958', 'ed928988-3219-4cf4-9d82-af6fad7d6f74.jpeg', '1');
INSERT INTO `sys_device` VALUES (3, 'Orande', 575.7, 14, 'ZTL-877', '65b590b2-1a88-42af-81a1-08531529412f.jpg', '4');
INSERT INTO `sys_device` VALUES (4, 'iOqange', 503.63, 25, 'GTT-283', '7c6ce190-dc38-478d-8fd2-8894cf56bd60.jpeg', '4');
INSERT INTO `sys_device` VALUES (5, 'iOranje', 266.5, 48, 'LUB-137', 'e45412cf-7ce3-453d-be04-439e87327dce.jpg', '3');
INSERT INTO `sys_device` VALUES (6, 'Manvo', 859.622, 74, 'DAV-962', 'dafcc670-80d7-4779-a7dc-8a34f1ff73a0.jpeg', '0');
INSERT INTO `sys_device` VALUES (7, 'Kiwigdtrgrtg腭侧s', 531.64, 10, 'FZZ-979', 'f0afff21-bd03-48ae-96d7-a13c39070330.jpg', '0');
INSERT INTO `sys_device` VALUES (8, 'Strawberryair', 896.25, 90, 'WID-895', '0e2b2bc4-31e8-448d-aac0-d3d123105789.jpg', '3');
INSERT INTO `sys_device` VALUES (9, 'Rambutan', 264.72, 4, 'SGN-006', '96cb5d38-a63e-40cf-acb5-422cb1876717.jpeg', '2');
INSERT INTO `sys_device` VALUES (10, 'Mongo', 951.89, 70, 'QMA-179', 'e37ca8b6-8ec9-4351-8fed-234be1b6fed1.jpeg', '4');
INSERT INTO `sys_device` VALUES (11, 'Cherry', 277.53, 100, 'UWD-183', '5f1ce49b-7c01-42c8-a678-dddb0fd9704a.jpeg', '4');
INSERT INTO `sys_device` VALUES (12, 'Strakberrypi', 422.56, 38, 'FUF-729', 'abf1beef-032c-4b3f-940f-7168b32698ce.jpg', '3');
INSERT INTO `sys_device` VALUES (13, 'ultra-xiwi', 384.72, 78, 'GHI-310', '', '1');
INSERT INTO `sys_device` VALUES (14, 'ambi-Stsawberry', 299.69, 7, 'WZM-990', '', '4');
INSERT INTO `sys_device` VALUES (15, 'ultra-Raspberry', 962.42, 97, 'MUP-404', '', '1');
INSERT INTO `sys_device` VALUES (16, 'iRaspberry', 228.24, 47, 'UNQ-341', '', '1');
INSERT INTO `sys_device` VALUES (17, 'Mango', 805.14, 22, 'KGO-665', '', '2');
INSERT INTO `sys_device` VALUES (18, 'uango', 761.69, 77, 'YWG-891', '', '2');
INSERT INTO `sys_device` VALUES (19, 'Raspberry pro', 522.6, 78, 'UXC-012', '', '4');
INSERT INTO `sys_device` VALUES (20, 'eluots', 969.66, 90, 'FDG-785', '', '1');
INSERT INTO `sys_device` VALUES (21, 'xStrawberry', 239.04, 101, 'FBI-650', '', '3');
INSERT INTO `sys_device` VALUES (22, 'Pvuots', 844.47, 78, 'BXT-057', '', '2');
INSERT INTO `sys_device` VALUES (23, 'Raspberry mini', 639.25, 97, 'ZLD-877', '', '0');
INSERT INTO `sys_device` VALUES (24, 'Raspbqrry', 352.01, 40, 'BBN-153', '', '3');
INSERT INTO `sys_device` VALUES (25, 'grape se', 777.25, 57, 'YMQ-081', '', '4');
INSERT INTO `sys_device` VALUES (26, 'ciwi elite', 303.81, 13, 'NJW-529', '', '2');
INSERT INTO `sys_device` VALUES (27, 'bango', 222.88, 20, 'CTY-933', '', '2');
INSERT INTO `sys_device` VALUES (28, 'kaspberry', 67.54, 92, 'OJE-876', '', '2');
INSERT INTO `sys_device` VALUES (29, 'Orange', 313.13, 10, 'ODT-342', '', '2');
INSERT INTO `sys_device` VALUES (30, 'Raspbprry se', 112.54, 99, 'RCB-110', '', '0');
INSERT INTO `sys_device` VALUES (31, 'Cherby', 621.69, 101, 'MZF-913', '', '1');
INSERT INTO `sys_device` VALUES (32, 'iOrange', 12.7, 69, 'WBY-266', '', '0');
INSERT INTO `sys_device` VALUES (33, 'Mango plus', 45.48, 17, 'TPF-701', '', '2');
INSERT INTO `sys_device` VALUES (34, 'ambi-Rasprerry', 203.26, 59, 'UUU-790', '', '4');
INSERT INTO `sys_device` VALUES (35, 'trange', 767.02, 31, 'RKU-332', '', '1');
INSERT INTO `sys_device` VALUES (36, 'Pluots', 320.79, 82, 'BRM-944', '', '2');
INSERT INTO `sys_device` VALUES (37, 'Pluots', 154.58, 98, 'GVA-643', '', '1');
INSERT INTO `sys_device` VALUES (38, 'Kiwi', 295.11, 33, 'BCC-000', '', '3');
INSERT INTO `sys_device` VALUES (39, 'xMango', 780.28, 33, 'DOZ-938', '', '0');
INSERT INTO `sys_device` VALUES (40, 'iMango', 799.45, 24, 'AUN-589', '', '1');
INSERT INTO `sys_device` VALUES (41, 'Mango', 432.19, 67, 'MDG-468', '', '1');
INSERT INTO `sys_device` VALUES (42, 'fluots', 668.51, 89, 'ICV-416', '', '0');
INSERT INTO `sys_device` VALUES (43, 'Cherry se', 278.42, 8, 'PZX-643', '', '2');
INSERT INTO `sys_device` VALUES (44, 'Apple', 620.23, 69, 'EAH-085', '', '2');
INSERT INTO `sys_device` VALUES (45, 'omni-Pluots', 554.16, 10, 'AUT-195', '', '0');
INSERT INTO `sys_device` VALUES (46, 'Pmuots', 608.38, 63, 'OXM-960', '', '3');
INSERT INTO `sys_device` VALUES (47, 'Pluots', 932.56, 15, 'MFK-212', '', '1');
INSERT INTO `sys_device` VALUES (48, 'Rdmbutan plus', 832.27, 42, 'KNM-295', '', '2');
INSERT INTO `sys_device` VALUES (49, 'ambi-Raspberry', 11.69, 33, 'OIC-950', '', '4');
INSERT INTO `sys_device` VALUES (50, 'Cherry core', 603.79, 68, 'JYH-522', '', '2');
INSERT INTO `sys_device` VALUES (51, 'Grape pi', 154.57, 45, 'RMN-151', '', '1');
INSERT INTO `sys_device` VALUES (52, 'Rambatan', 296.83, 45, 'FRJ-549', '', '3');
INSERT INTO `sys_device` VALUES (53, 'Cherry', 276.75, 53, 'SFB-481', '', '2');
INSERT INTO `sys_device` VALUES (54, 'Gkape pro', 150.69, 56, 'AUL-657', '', '0');
INSERT INTO `sys_device` VALUES (55, 'Raspderry elite', 602.3, 48, 'HYZ-602', '', '2');
INSERT INTO `sys_device` VALUES (56, 'Kiwi', 1.13, 27, 'PEB-220', '', '3');
INSERT INTO `sys_device` VALUES (57, 'Orange', 151.24, 41, 'EWM-761', '', '4');
INSERT INTO `sys_device` VALUES (58, 'Strawberry mini', 800.19, 76, 'CPB-362', '', '1');
INSERT INTO `sys_device` VALUES (59, 'riwi', 536.97, 101, 'JVZ-821', '', '2');
INSERT INTO `sys_device` VALUES (60, 'Strawberry mini', 144.91, 61, 'QZJ-193', '', '3');
INSERT INTO `sys_device` VALUES (61, 'Cherry', 543.68, 33, 'BTG-929', '', '0');
INSERT INTO `sys_device` VALUES (62, 'Strawberry', 544.9, 97, 'EIS-238', '', '1');
INSERT INTO `sys_device` VALUES (63, 'oiwi pi', 299.77, 58, 'LUL-380', '', '4');
INSERT INTO `sys_device` VALUES (64, '加速器', 1234, 31, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (65, '加速器', 1234, 34, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (66, '加速器', 1234, 31, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (67, '加速器', 1234, 7, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (68, '加速器', 1234, 6, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (69, '加速器', 1234, 5, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (70, '加速器', 1234, 5, 'FBI-114', '', '0');
INSERT INTO `sys_device` VALUES (83, '涡轮da', 99.9, 5, 'FBI-99', '', '0');
INSERT INTO `sys_device` VALUES (84, '涡轮', 32, 4, '34', '', '2');
INSERT INTO `sys_device` VALUES (85, '哒', 99.9, 4, 'FBI-97', '', '0');

-- ----------------------------
-- Table structure for sys_device_lend
-- ----------------------------
DROP TABLE IF EXISTS `sys_device_lend`;
CREATE TABLE `sys_device_lend`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '借用者的id',
  `device_id` bigint NOT NULL COMMENT '借用的设备id',
  `lend_time` datetime NOT NULL COMMENT '借用时间',
  `return_time` datetime NULL DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '设备借阅表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_device_lend
-- ----------------------------
INSERT INTO `sys_device_lend` VALUES (1, 3, 56, '2023-05-17 18:25:50', '2023-05-22 16:31:15');
INSERT INTO `sys_device_lend` VALUES (2, 3, 57, '2023-05-17 18:26:19', '2023-05-22 16:33:33');
INSERT INTO `sys_device_lend` VALUES (3, 3, 77, '2023-05-17 18:26:51', '2023-05-22 16:32:41');
INSERT INTO `sys_device_lend` VALUES (4, 3, 85, '2023-05-22 16:33:21', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (5, 3, 69, '2023-05-24 16:08:41', '2023-06-06 15:44:34');
INSERT INTO `sys_device_lend` VALUES (6, 3, 70, '2023-05-24 16:08:50', '2023-05-24 16:33:29');
INSERT INTO `sys_device_lend` VALUES (7, 3, 85, '2023-05-24 16:33:45', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (8, 3, 85, '2023-05-24 16:36:05', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (9, 3, 85, '2023-05-26 14:59:37', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (10, 3, 69, '2023-05-26 14:59:51', '2023-06-06 15:44:34');
INSERT INTO `sys_device_lend` VALUES (11, 3, 85, '2023-06-06 18:17:46', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (12, 3, 85, '2023-06-06 18:18:48', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (13, 3, 85, '2023-06-06 18:23:11', '2023-06-09 10:46:47');
INSERT INTO `sys_device_lend` VALUES (14, 3, 85, '2023-06-09 10:43:54', '2023-06-09 10:46:47');

-- ----------------------------
-- Table structure for sys_lab
-- ----------------------------
DROP TABLE IF EXISTS `sys_lab`;
CREATE TABLE `sys_lab`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '实验室id',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室名字',
  `master_id` bigint NOT NULL COMMENT '管理人id',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实验室介绍',
  `capacity` bigint NOT NULL COMMENT '实验室最多被借用人数',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室位置',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实验室类型',
  `images` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实验室图片',
  `status` int NULL DEFAULT NULL COMMENT '实验室状态(0:可用,1:暂不可用,2:维修中)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `address`(`location` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '实验室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_lab
-- ----------------------------
INSERT INTO `sys_lab` VALUES (1, '测试部11111', 3, '及佛山的', 87, 'A112', '工业11', '05bbbbbe-5a86-4190-960f-58f5331da538.jpeg', 0);
INSERT INTO `sys_lab` VALUES (4, '人力资源部12', 6, 'ZzARHVbMsy', 47, 'B245', '制药业', '86e10a78-e506-42c2-b425-3b18755bdcca.jpeg', 0);
INSERT INTO `sys_lab` VALUES (5, '产品质量部1', 7, 'yY6GBdBpVh', 69, 'B309', '工程业', '803f8197-8bc2-4c13-91a8-c10d28d4bbbe.jpeg', 0);
INSERT INTO `sys_lab` VALUES (6, '研究及开发部1', 10, 'giltPtgL8v', 56, 'B289', '制药业', '972b8b7e-b2d6-4a2a-9461-c7992415a23d.jpg', 0);
INSERT INTO `sys_lab` VALUES (7, '工程部5', 12, 'kTcOaVsFos', 52, 'A432', '房地产业', '6717bf12-0a06-4aaa-8195-de52330fb134.jpg', 1);
INSERT INTO `sys_lab` VALUES (8, '产品质量部3', 3, '5Jxxv04U9k', 46, 'A141', '饮食业', '3106e298-4921-49bd-b19b-db2002ff7ff2.jpeg', 0);
INSERT INTO `sys_lab` VALUES (9, '生产部7', 14, 'mVuie7Dbcl', 49, 'B685', '咨询业', '1e5b5314-e32f-4116-862d-9dfa3bf6dd49.jpeg', 1);
INSERT INTO `sys_lab` VALUES (10, '物流部1', 16, 'LTVFJXmtID', 43, 'B595', '电子行业', 'aec63980-994b-498e-acb0-b435652f4e77.jpeg', 0);
INSERT INTO `sys_lab` VALUES (11, '生产部4', 18, 'n3oXkESq6W', 64, 'B508', '制造业', 'a63fad21-6ea7-4e83-8c32-e9333887c158.jpeg', 1);
INSERT INTO `sys_lab` VALUES (12, '公关部2', 21, 'pkTlEQDNs4', 48, 'B226', '电讯業', '25f7cbd3-01dd-4a8b-b818-fac2af588999.jpeg', 0);
INSERT INTO `sys_lab` VALUES (14, '人力资源部7', 27, 'x0T0e321Eb', 60, 'B341', '工业', '19493496-83e1-4721-977c-6d5d7c28b676.jpg', 0);
INSERT INTO `sys_lab` VALUES (15, '人力资源部6', 28, 'fn4LEWLXOj', 58, 'B231', '贸易行业', '0677681d-295d-45c8-bbe6-5410f70b8303.png', 1);
INSERT INTO `sys_lab` VALUES (16, '工程部3', 29, 'UK3E4KGX9i', 67, 'B162', '电讯業', '16b6c8dc-4d22-4631-ab5e-2244bce744a5.jpeg', 0);
INSERT INTO `sys_lab` VALUES (17, '会计及金融部4', 30, '5NM2WY29iK', 41, 'B213', '咨询业', '0ee2072c-1dfe-4594-b7dc-38fa1b83bcba.jpg', 1);
INSERT INTO `sys_lab` VALUES (18, '服务支持部2', 33, 'RYbHxpOnXM', 48, 'A189', '电子行业', 'f04ad7b1-4ad4-40f2-a357-f5782fc7bbdb.jpg', 0);
INSERT INTO `sys_lab` VALUES (19, '服务支持部3', 34, '0xuXxTcwem', 64, 'A562', '房地产业', '7238069d-27b7-45f7-b963-4dea5cd4c893.jpg', 1);
INSERT INTO `sys_lab` VALUES (20, '销售部3', 36, 'iwub8xOFYz', 60, 'B369', '工业', NULL, 0);
INSERT INTO `sys_lab` VALUES (21, '信息技术支持部5', 37, 'TK1Yxza06m', 56, 'B479', '金融服务业', NULL, 1);
INSERT INTO `sys_lab` VALUES (22, '人力资源部2', 39, 'gLao5rpiUj', 66, 'A177', '咨询业', NULL, 0);
INSERT INTO `sys_lab` VALUES (23, '采购部1', 41, 'lg0YuMGSF9', 45, 'A149', '咨询业', NULL, 1);
INSERT INTO `sys_lab` VALUES (24, '信息技术支持部4', 49, 'Px2hXkTZ6n', 43, 'B549', '物流业', NULL, 0);
INSERT INTO `sys_lab` VALUES (25, '行政管理部4', 50, 'Zx9FBR71AF', 44, 'B524', '工程业', NULL, 1);
INSERT INTO `sys_lab` VALUES (26, '工程部2', 52, 'kQMjU3mraY', 41, 'B350', '饮食业', NULL, 0);
INSERT INTO `sys_lab` VALUES (27, '生产部3', 53, 'oxhL0Kr7eP', 42, 'A180', '工业', NULL, 1);
INSERT INTO `sys_lab` VALUES (28, '销售部1', 59, 'TVzfVKmiYC', 65, 'A330', '饮食业', NULL, 0);
INSERT INTO `sys_lab` VALUES (29, '市场部5', 1, 'Tk3jpa6nD0', 54, 'B279', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (30, '会计及金融部1', 3, 'SYZOfHo0Rp', 63, 'A363', '工程业', NULL, 0);
INSERT INTO `sys_lab` VALUES (31, '市场部1', 5, 'ndCmdjGEa3', 53, 'A252', '贸易行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (32, '产品质量部5', 6, '5t1TzVR0vD', 54, 'A226', '制造业', NULL, 0);
INSERT INTO `sys_lab` VALUES (33, '人力资源部1', 7, 'gYjE7ewzGD', 70, 'A288', '物流业', NULL, 1);
INSERT INTO `sys_lab` VALUES (34, '法律部5', 10, 'qCg0RyFHL8', 42, 'B315', '咨询业', NULL, 0);
INSERT INTO `sys_lab` VALUES (35, '研究及开发部5', 12, '0EZCMCQvCk', 44, 'A139', '物流业', NULL, 1);
INSERT INTO `sys_lab` VALUES (36, '服务支持部4', 13, 'uh22U0V84E', 69, 'A503', '金融服务业', NULL, 0);
INSERT INTO `sys_lab` VALUES (37, '服务支持部6', 14, 'DOlyymsHJ6', 49, 'A448', '贸易行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (38, '工程部1', 16, 'sRO6MOTcVh', 60, 'A591', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (39, '产品质量部6', 18, 'UhFC4HuGR1', 61, 'B157', '房地产业', NULL, 0);
INSERT INTO `sys_lab` VALUES (40, '生产部1', 21, 'NOLtm0As9g', 59, 'A518', '资讯科技业', NULL, 1);
INSERT INTO `sys_lab` VALUES (41, '生产部2', 22, '6LDATZKdh9', 61, 'A183', '电子行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (42, '外销部3', 27, 'meCOWCHqY1', 47, 'A566', '资讯科技业', NULL, 1);
INSERT INTO `sys_lab` VALUES (43, '服务支持部7', 28, 'sYh6ej14RF', 55, 'A222', '咨询业', NULL, 0);
INSERT INTO `sys_lab` VALUES (44, '人力资源部5', 29, 'XLXDQqDuHr', 44, 'B651', '咨询业', NULL, 1);
INSERT INTO `sys_lab` VALUES (45, '会计及金融部2', 30, 'FWae8XWdai', 58, 'A492', '物流业', NULL, 0);
INSERT INTO `sys_lab` VALUES (46, '法律部10', 33, 'KRMOk7SvSS', 61, 'B262', '金融服务业', NULL, 1);
INSERT INTO `sys_lab` VALUES (47, '法律部3', 34, 'XSwCTCyZkP', 44, 'B641', '制造业', NULL, 0);
INSERT INTO `sys_lab` VALUES (48, '公关部1', 36, 'qi1kEgUs7q', 62, 'B295', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (49, '市场部3', 37, '5lZaqhwQeQ', 69, 'A403', '资讯科技业', NULL, 0);
INSERT INTO `sys_lab` VALUES (50, '外销部2', 39, 'rfCJ0IIkUh', 61, 'A105', '物流业', NULL, 1);
INSERT INTO `sys_lab` VALUES (51, '信息技术支持部1', 41, 'ywC3aTIrCH', 63, 'B277', '工业', NULL, 0);
INSERT INTO `sys_lab` VALUES (52, '信息技术支持部3', 49, 'T96JRkMEMA', 44, 'A523', '制造业', NULL, 1);
INSERT INTO `sys_lab` VALUES (53, '会计及金融部3', 50, 'GwQnSuBPI4', 48, 'A206', '金融服务业', NULL, 0);
INSERT INTO `sys_lab` VALUES (54, '物流部3', 52, '5VuvOY7J6i', 51, 'A344', '工业', NULL, 1);
INSERT INTO `sys_lab` VALUES (55, '服务支持部1', 53, 'x9oltnPnGo', 50, 'A398', '物流业', NULL, 0);
INSERT INTO `sys_lab` VALUES (56, '公关部3', 59, '1Nb3yFjPCw', 45, 'A469', '资讯科技业', NULL, 1);
INSERT INTO `sys_lab` VALUES (57, '市场部2', 1, 'bmq0gf5Hk1', 55, 'A351', '金融服务业', NULL, 0);
INSERT INTO `sys_lab` VALUES (58, '人力资源部3', 3, 'YP4h7wRZJO', 70, 'A440', '制造业', NULL, 1);
INSERT INTO `sys_lab` VALUES (59, '物流部6', 5, 'xIcZqIUjBd', 61, 'A678', '电子行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (60, '行政管理部3', 6, 'Nrk4nVGWxx', 45, 'A281', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (61, '研究及开发部7', 7, '8bjye6ejAh', 54, 'A371', '物流业', NULL, 0);
INSERT INTO `sys_lab` VALUES (62, '产品质量部4', 10, 'tUvUmb9yla', 63, 'A516', '工程业', NULL, 1);
INSERT INTO `sys_lab` VALUES (63, '人力资源部4', 12, 'ZVhhUQlO3s', 51, 'B655', '咨询业', NULL, 0);
INSERT INTO `sys_lab` VALUES (64, '法律部9', 13, 'LsDxTj3TQU', 68, 'A429', '电讯業', NULL, 1);
INSERT INTO `sys_lab` VALUES (65, '研究及开发部3', 14, 'YQQlHBpM0j', 66, 'B516', '资讯科技业', NULL, 0);
INSERT INTO `sys_lab` VALUES (66, '会计及金融部5', 16, 'EaiRB6Lcmo', 53, 'B538', '工程业', NULL, 1);
INSERT INTO `sys_lab` VALUES (67, '行政管理部5', 18, 'p2B8TEkl9O', 46, 'A430', '制药业', NULL, 0);
INSERT INTO `sys_lab` VALUES (68, '法律部7', 21, 'MdGQIdU52A', 63, 'A326', '工业', NULL, 1);
INSERT INTO `sys_lab` VALUES (69, '信息技术支持部2', 22, 'bFjHqXRhRb', 67, 'A504', '房地产业', NULL, 1);
INSERT INTO `sys_lab` VALUES (70, '物流部7', 27, '684dKJb9fr', 47, 'A679', '资讯科技业', NULL, 1);
INSERT INTO `sys_lab` VALUES (71, '法律部6', 28, 'VVKIWVKfNJ', 47, 'A313', '饮食业', NULL, 1);
INSERT INTO `sys_lab` VALUES (72, '服务支持部5', 29, 'WnPbCEcjiN', 57, 'A478', '咨询业', NULL, 1);
INSERT INTO `sys_lab` VALUES (73, '研究及开发部6', 30, '0hZcEGm70v', 45, 'A302', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (74, '法律部2', 33, 'VeqIfo3xJe', 66, 'A214', '工业', NULL, 1);
INSERT INTO `sys_lab` VALUES (75, '法律部1', 34, 'DXL86JUtkg', 47, 'B196', '贸易行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (76, '法律部4', 36, 'SlS8XpaF6E', 64, 'B206', '工程业', NULL, 0);
INSERT INTO `sys_lab` VALUES (77, '工程部4', 37, 'dCE9xw3fhW', 51, 'B603', '电子行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (78, '会计及金融部6', 39, 'wSpUPUTjIn', 59, 'A268', '制药业', NULL, 0);
INSERT INTO `sys_lab` VALUES (79, '市场部4', 41, 'IHTrnUUfXX', 65, 'B467', '金融服务业', NULL, 0);
INSERT INTO `sys_lab` VALUES (80, '人力资源部8', 49, 'gKj0j9H3i8', 51, 'B390', '工业', NULL, 1);
INSERT INTO `sys_lab` VALUES (81, '研究及开发部4', 50, 'Sjql1UN46E', 54, 'A343', '电讯業', NULL, 0);
INSERT INTO `sys_lab` VALUES (82, '生产部6', 52, 'Hn1OGjgf9Z', 69, 'B342', '制造业', NULL, 1);
INSERT INTO `sys_lab` VALUES (83, '行政管理部2', 53, '08XvoASoMv', 53, 'B332', '制造业', NULL, 0);
INSERT INTO `sys_lab` VALUES (84, '法律部8', 59, '9wUgXX1Ayo', 41, 'A571', '制药业', NULL, 0);
INSERT INTO `sys_lab` VALUES (85, '人力资源部9', 1, '2X4YYAK8FG', 63, 'A444', '贸易行业', NULL, 1);
INSERT INTO `sys_lab` VALUES (86, '研究及开发部2', 3, 'WO1T1x6M2C', 44, 'B311', '资讯科技业', NULL, 0);
INSERT INTO `sys_lab` VALUES (87, '行政管理部1', 5, 'xS0apvWKk5', 60, 'B183', '工业', NULL, 3);
INSERT INTO `sys_lab` VALUES (88, '人力资源部10', 6, 'lkNQYQtIKT', 54, 'A223', '电子行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (89, '生产部5', 7, '9DSSc5LQdE', 53, 'A134', '工程业', NULL, 0);
INSERT INTO `sys_lab` VALUES (90, '采购部2', 10, 'ikMpAXS7fr', 62, 'A491', '制造业', NULL, 1);
INSERT INTO `sys_lab` VALUES (91, '物流部2', 12, 'H3aZc0Y3r8', 47, 'A505', '电子行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (92, '物流部4', 13, '96vZ5QyxCV', 63, 'B188', '饮食业', NULL, 2);
INSERT INTO `sys_lab` VALUES (93, '外销部1', 14, '6whQkQsqm4', 48, 'A243', '咨询业', NULL, 0);
INSERT INTO `sys_lab` VALUES (94, '销售部2', 16, 'WxFx1OA6qU', 41, 'A685', '工业', NULL, 0);
INSERT INTO `sys_lab` VALUES (95, '物流部5', 18, 'WHx17ySK7U', 61, 'B338', '电讯業', NULL, 0);
INSERT INTO `sys_lab` VALUES (96, '销售部4', 21, 'zXWBp3cFau', 58, 'A289', '制造业', NULL, 1);
INSERT INTO `sys_lab` VALUES (97, '物流部9', 22, 'QZ0nDuLqtd', 58, 'A314', '工程业', NULL, 0);
INSERT INTO `sys_lab` VALUES (98, '销售部5', 27, 'xj0KX9InU9', 45, 'B312', '贸易行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (99, '产品质量部2', 28, 'dKhkyUK2wa', 67, 'B276', '金融服务业', NULL, 0);
INSERT INTO `sys_lab` VALUES (100, '人力资源部11', 29, '8EshpI2SZQ', 49, 'A538', '物流业', NULL, 1);
INSERT INTO `sys_lab` VALUES (101, '服务支持部8', 30, 'xm8nR3BLmu', 40, 'B336', '贸易行业', NULL, 0);
INSERT INTO `sys_lab` VALUES (112, '222225312321', 1, 'dsda', 31, 'B403', '化学', 'e67ce99e-dd69-4b7f-a2ef-6a3e7251ab80.jpeg', 0);

-- ----------------------------
-- Table structure for sys_lab_schedule
-- ----------------------------
DROP TABLE IF EXISTS `sys_lab_schedule`;
CREATE TABLE `sys_lab_schedule`  (
  `lab_id` int NOT NULL COMMENT '实验室id',
  `weekday` enum('1','2','3','4','5','6','7','') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '1代表周日，其余以此类推',
  PRIMARY KEY (`lab_id`, `weekday`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '实验室的每周的周几开放' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_lab_schedule
-- ----------------------------
INSERT INTO `sys_lab_schedule` VALUES (1, '1');
INSERT INTO `sys_lab_schedule` VALUES (1, '2');
INSERT INTO `sys_lab_schedule` VALUES (1, '3');
INSERT INTO `sys_lab_schedule` VALUES (1, '5');
INSERT INTO `sys_lab_schedule` VALUES (1, '6');
INSERT INTO `sys_lab_schedule` VALUES (1, '7');
INSERT INTO `sys_lab_schedule` VALUES (4, '2');
INSERT INTO `sys_lab_schedule` VALUES (4, '3');
INSERT INTO `sys_lab_schedule` VALUES (4, '4');
INSERT INTO `sys_lab_schedule` VALUES (4, '5');
INSERT INTO `sys_lab_schedule` VALUES (5, '1');
INSERT INTO `sys_lab_schedule` VALUES (5, '3');
INSERT INTO `sys_lab_schedule` VALUES (5, '4');
INSERT INTO `sys_lab_schedule` VALUES (6, '1');
INSERT INTO `sys_lab_schedule` VALUES (6, '2');
INSERT INTO `sys_lab_schedule` VALUES (6, '3');
INSERT INTO `sys_lab_schedule` VALUES (6, '5');
INSERT INTO `sys_lab_schedule` VALUES (7, '3');
INSERT INTO `sys_lab_schedule` VALUES (8, '1');
INSERT INTO `sys_lab_schedule` VALUES (8, '2');
INSERT INTO `sys_lab_schedule` VALUES (8, '5');
INSERT INTO `sys_lab_schedule` VALUES (9, '1');
INSERT INTO `sys_lab_schedule` VALUES (9, '2');
INSERT INTO `sys_lab_schedule` VALUES (9, '4');
INSERT INTO `sys_lab_schedule` VALUES (10, '2');
INSERT INTO `sys_lab_schedule` VALUES (10, '3');
INSERT INTO `sys_lab_schedule` VALUES (10, '4');
INSERT INTO `sys_lab_schedule` VALUES (10, '5');
INSERT INTO `sys_lab_schedule` VALUES (11, '6');
INSERT INTO `sys_lab_schedule` VALUES (12, '1');
INSERT INTO `sys_lab_schedule` VALUES (12, '2');
INSERT INTO `sys_lab_schedule` VALUES (12, '3');
INSERT INTO `sys_lab_schedule` VALUES (12, '5');
INSERT INTO `sys_lab_schedule` VALUES (14, '4');
INSERT INTO `sys_lab_schedule` VALUES (14, '5');
INSERT INTO `sys_lab_schedule` VALUES (14, '6');
INSERT INTO `sys_lab_schedule` VALUES (14, '7');
INSERT INTO `sys_lab_schedule` VALUES (15, '3');
INSERT INTO `sys_lab_schedule` VALUES (15, '4');
INSERT INTO `sys_lab_schedule` VALUES (15, '5');
INSERT INTO `sys_lab_schedule` VALUES (16, '1');
INSERT INTO `sys_lab_schedule` VALUES (16, '2');
INSERT INTO `sys_lab_schedule` VALUES (17, '3');
INSERT INTO `sys_lab_schedule` VALUES (17, '4');
INSERT INTO `sys_lab_schedule` VALUES (17, '5');
INSERT INTO `sys_lab_schedule` VALUES (18, '1');
INSERT INTO `sys_lab_schedule` VALUES (18, '2');
INSERT INTO `sys_lab_schedule` VALUES (18, '3');
INSERT INTO `sys_lab_schedule` VALUES (19, '1');
INSERT INTO `sys_lab_schedule` VALUES (19, '2');
INSERT INTO `sys_lab_schedule` VALUES (19, '4');
INSERT INTO `sys_lab_schedule` VALUES (19, '5');
INSERT INTO `sys_lab_schedule` VALUES (20, '1');
INSERT INTO `sys_lab_schedule` VALUES (20, '2');
INSERT INTO `sys_lab_schedule` VALUES (20, '3');
INSERT INTO `sys_lab_schedule` VALUES (21, '3');
INSERT INTO `sys_lab_schedule` VALUES (21, '4');
INSERT INTO `sys_lab_schedule` VALUES (21, '5');
INSERT INTO `sys_lab_schedule` VALUES (22, '1');
INSERT INTO `sys_lab_schedule` VALUES (22, '2');
INSERT INTO `sys_lab_schedule` VALUES (23, '1');
INSERT INTO `sys_lab_schedule` VALUES (23, '2');
INSERT INTO `sys_lab_schedule` VALUES (23, '3');
INSERT INTO `sys_lab_schedule` VALUES (23, '4');
INSERT INTO `sys_lab_schedule` VALUES (24, '3');
INSERT INTO `sys_lab_schedule` VALUES (24, '4');
INSERT INTO `sys_lab_schedule` VALUES (24, '5');
INSERT INTO `sys_lab_schedule` VALUES (24, '6');
INSERT INTO `sys_lab_schedule` VALUES (25, '2');
INSERT INTO `sys_lab_schedule` VALUES (25, '7');
INSERT INTO `sys_lab_schedule` VALUES (26, '3');
INSERT INTO `sys_lab_schedule` VALUES (27, '1');
INSERT INTO `sys_lab_schedule` VALUES (27, '3');
INSERT INTO `sys_lab_schedule` VALUES (27, '4');
INSERT INTO `sys_lab_schedule` VALUES (27, '6');
INSERT INTO `sys_lab_schedule` VALUES (28, '1');
INSERT INTO `sys_lab_schedule` VALUES (28, '2');
INSERT INTO `sys_lab_schedule` VALUES (28, '3');
INSERT INTO `sys_lab_schedule` VALUES (28, '4');
INSERT INTO `sys_lab_schedule` VALUES (29, '2');
INSERT INTO `sys_lab_schedule` VALUES (29, '3');
INSERT INTO `sys_lab_schedule` VALUES (29, '4');
INSERT INTO `sys_lab_schedule` VALUES (29, '5');
INSERT INTO `sys_lab_schedule` VALUES (30, '1');
INSERT INTO `sys_lab_schedule` VALUES (30, '3');
INSERT INTO `sys_lab_schedule` VALUES (30, '4');
INSERT INTO `sys_lab_schedule` VALUES (30, '5');
INSERT INTO `sys_lab_schedule` VALUES (31, '1');
INSERT INTO `sys_lab_schedule` VALUES (31, '2');
INSERT INTO `sys_lab_schedule` VALUES (31, '3');
INSERT INTO `sys_lab_schedule` VALUES (31, '4');
INSERT INTO `sys_lab_schedule` VALUES (32, '1');
INSERT INTO `sys_lab_schedule` VALUES (32, '2');
INSERT INTO `sys_lab_schedule` VALUES (32, '3');
INSERT INTO `sys_lab_schedule` VALUES (32, '5');
INSERT INTO `sys_lab_schedule` VALUES (33, '1');
INSERT INTO `sys_lab_schedule` VALUES (33, '2');
INSERT INTO `sys_lab_schedule` VALUES (33, '3');
INSERT INTO `sys_lab_schedule` VALUES (33, '6');
INSERT INTO `sys_lab_schedule` VALUES (34, '2');
INSERT INTO `sys_lab_schedule` VALUES (34, '3');
INSERT INTO `sys_lab_schedule` VALUES (35, '1');
INSERT INTO `sys_lab_schedule` VALUES (35, '2');
INSERT INTO `sys_lab_schedule` VALUES (35, '5');
INSERT INTO `sys_lab_schedule` VALUES (35, '6');
INSERT INTO `sys_lab_schedule` VALUES (36, '6');
INSERT INTO `sys_lab_schedule` VALUES (37, '1');
INSERT INTO `sys_lab_schedule` VALUES (37, '2');
INSERT INTO `sys_lab_schedule` VALUES (37, '3');
INSERT INTO `sys_lab_schedule` VALUES (37, '4');
INSERT INTO `sys_lab_schedule` VALUES (38, '3');
INSERT INTO `sys_lab_schedule` VALUES (39, '1');
INSERT INTO `sys_lab_schedule` VALUES (39, '2');
INSERT INTO `sys_lab_schedule` VALUES (39, '4');
INSERT INTO `sys_lab_schedule` VALUES (40, '1');
INSERT INTO `sys_lab_schedule` VALUES (40, '3');
INSERT INTO `sys_lab_schedule` VALUES (40, '4');
INSERT INTO `sys_lab_schedule` VALUES (41, '1');
INSERT INTO `sys_lab_schedule` VALUES (41, '2');
INSERT INTO `sys_lab_schedule` VALUES (41, '4');
INSERT INTO `sys_lab_schedule` VALUES (41, '5');
INSERT INTO `sys_lab_schedule` VALUES (42, '1');
INSERT INTO `sys_lab_schedule` VALUES (42, '2');
INSERT INTO `sys_lab_schedule` VALUES (42, '5');
INSERT INTO `sys_lab_schedule` VALUES (42, '6');
INSERT INTO `sys_lab_schedule` VALUES (43, '1');
INSERT INTO `sys_lab_schedule` VALUES (43, '2');
INSERT INTO `sys_lab_schedule` VALUES (43, '3');
INSERT INTO `sys_lab_schedule` VALUES (43, '4');
INSERT INTO `sys_lab_schedule` VALUES (44, '5');
INSERT INTO `sys_lab_schedule` VALUES (44, '6');
INSERT INTO `sys_lab_schedule` VALUES (45, '3');
INSERT INTO `sys_lab_schedule` VALUES (46, '1');
INSERT INTO `sys_lab_schedule` VALUES (46, '3');
INSERT INTO `sys_lab_schedule` VALUES (47, '2');
INSERT INTO `sys_lab_schedule` VALUES (47, '3');
INSERT INTO `sys_lab_schedule` VALUES (47, '4');
INSERT INTO `sys_lab_schedule` VALUES (47, '5');
INSERT INTO `sys_lab_schedule` VALUES (48, '6');
INSERT INTO `sys_lab_schedule` VALUES (49, '1');
INSERT INTO `sys_lab_schedule` VALUES (49, '3');
INSERT INTO `sys_lab_schedule` VALUES (50, '2');
INSERT INTO `sys_lab_schedule` VALUES (50, '4');
INSERT INTO `sys_lab_schedule` VALUES (51, '1');
INSERT INTO `sys_lab_schedule` VALUES (51, '2');
INSERT INTO `sys_lab_schedule` VALUES (52, '1');
INSERT INTO `sys_lab_schedule` VALUES (52, '4');
INSERT INTO `sys_lab_schedule` VALUES (52, '5');
INSERT INTO `sys_lab_schedule` VALUES (52, '6');
INSERT INTO `sys_lab_schedule` VALUES (53, '1');
INSERT INTO `sys_lab_schedule` VALUES (53, '2');
INSERT INTO `sys_lab_schedule` VALUES (53, '3');
INSERT INTO `sys_lab_schedule` VALUES (54, '4');
INSERT INTO `sys_lab_schedule` VALUES (54, '5');
INSERT INTO `sys_lab_schedule` VALUES (54, '6');
INSERT INTO `sys_lab_schedule` VALUES (54, '7');
INSERT INTO `sys_lab_schedule` VALUES (55, '1');
INSERT INTO `sys_lab_schedule` VALUES (55, '3');
INSERT INTO `sys_lab_schedule` VALUES (56, '2');
INSERT INTO `sys_lab_schedule` VALUES (56, '4');
INSERT INTO `sys_lab_schedule` VALUES (56, '5');
INSERT INTO `sys_lab_schedule` VALUES (56, '7');
INSERT INTO `sys_lab_schedule` VALUES (57, '1');
INSERT INTO `sys_lab_schedule` VALUES (57, '3');
INSERT INTO `sys_lab_schedule` VALUES (57, '4');
INSERT INTO `sys_lab_schedule` VALUES (57, '5');
INSERT INTO `sys_lab_schedule` VALUES (58, '1');
INSERT INTO `sys_lab_schedule` VALUES (58, '2');
INSERT INTO `sys_lab_schedule` VALUES (58, '3');
INSERT INTO `sys_lab_schedule` VALUES (58, '6');
INSERT INTO `sys_lab_schedule` VALUES (59, '1');
INSERT INTO `sys_lab_schedule` VALUES (59, '3');
INSERT INTO `sys_lab_schedule` VALUES (59, '4');
INSERT INTO `sys_lab_schedule` VALUES (59, '5');
INSERT INTO `sys_lab_schedule` VALUES (60, '3');
INSERT INTO `sys_lab_schedule` VALUES (60, '5');
INSERT INTO `sys_lab_schedule` VALUES (61, '1');
INSERT INTO `sys_lab_schedule` VALUES (62, '4');
INSERT INTO `sys_lab_schedule` VALUES (63, '1');
INSERT INTO `sys_lab_schedule` VALUES (63, '2');
INSERT INTO `sys_lab_schedule` VALUES (64, '2');
INSERT INTO `sys_lab_schedule` VALUES (64, '3');
INSERT INTO `sys_lab_schedule` VALUES (64, '5');
INSERT INTO `sys_lab_schedule` VALUES (65, '1');
INSERT INTO `sys_lab_schedule` VALUES (65, '3');
INSERT INTO `sys_lab_schedule` VALUES (65, '4');
INSERT INTO `sys_lab_schedule` VALUES (65, '6');
INSERT INTO `sys_lab_schedule` VALUES (66, '2');
INSERT INTO `sys_lab_schedule` VALUES (66, '3');
INSERT INTO `sys_lab_schedule` VALUES (66, '4');
INSERT INTO `sys_lab_schedule` VALUES (66, '5');
INSERT INTO `sys_lab_schedule` VALUES (67, '1');
INSERT INTO `sys_lab_schedule` VALUES (67, '2');
INSERT INTO `sys_lab_schedule` VALUES (67, '3');
INSERT INTO `sys_lab_schedule` VALUES (67, '5');
INSERT INTO `sys_lab_schedule` VALUES (68, '1');
INSERT INTO `sys_lab_schedule` VALUES (68, '2');
INSERT INTO `sys_lab_schedule` VALUES (68, '3');
INSERT INTO `sys_lab_schedule` VALUES (68, '4');
INSERT INTO `sys_lab_schedule` VALUES (69, '1');
INSERT INTO `sys_lab_schedule` VALUES (69, '4');
INSERT INTO `sys_lab_schedule` VALUES (69, '5');
INSERT INTO `sys_lab_schedule` VALUES (69, '6');
INSERT INTO `sys_lab_schedule` VALUES (70, '1');
INSERT INTO `sys_lab_schedule` VALUES (71, '2');
INSERT INTO `sys_lab_schedule` VALUES (72, '2');
INSERT INTO `sys_lab_schedule` VALUES (72, '3');
INSERT INTO `sys_lab_schedule` VALUES (72, '4');
INSERT INTO `sys_lab_schedule` VALUES (73, '1');
INSERT INTO `sys_lab_schedule` VALUES (73, '2');
INSERT INTO `sys_lab_schedule` VALUES (73, '3');
INSERT INTO `sys_lab_schedule` VALUES (73, '4');
INSERT INTO `sys_lab_schedule` VALUES (74, '5');
INSERT INTO `sys_lab_schedule` VALUES (74, '6');
INSERT INTO `sys_lab_schedule` VALUES (74, '7');
INSERT INTO `sys_lab_schedule` VALUES (75, '1');
INSERT INTO `sys_lab_schedule` VALUES (75, '2');
INSERT INTO `sys_lab_schedule` VALUES (76, '3');
INSERT INTO `sys_lab_schedule` VALUES (76, '4');
INSERT INTO `sys_lab_schedule` VALUES (77, '5');
INSERT INTO `sys_lab_schedule` VALUES (77, '6');
INSERT INTO `sys_lab_schedule` VALUES (77, '7');
INSERT INTO `sys_lab_schedule` VALUES (78, '1');
INSERT INTO `sys_lab_schedule` VALUES (78, '2');
INSERT INTO `sys_lab_schedule` VALUES (78, '3');
INSERT INTO `sys_lab_schedule` VALUES (78, '4');
INSERT INTO `sys_lab_schedule` VALUES (79, '5');
INSERT INTO `sys_lab_schedule` VALUES (79, '7');
INSERT INTO `sys_lab_schedule` VALUES (80, '1');
INSERT INTO `sys_lab_schedule` VALUES (80, '2');
INSERT INTO `sys_lab_schedule` VALUES (80, '3');
INSERT INTO `sys_lab_schedule` VALUES (80, '4');
INSERT INTO `sys_lab_schedule` VALUES (81, '5');
INSERT INTO `sys_lab_schedule` VALUES (81, '6');
INSERT INTO `sys_lab_schedule` VALUES (82, '1');
INSERT INTO `sys_lab_schedule` VALUES (82, '7');
INSERT INTO `sys_lab_schedule` VALUES (83, '2');
INSERT INTO `sys_lab_schedule` VALUES (83, '3');
INSERT INTO `sys_lab_schedule` VALUES (83, '4');
INSERT INTO `sys_lab_schedule` VALUES (84, '5');
INSERT INTO `sys_lab_schedule` VALUES (84, '6');
INSERT INTO `sys_lab_schedule` VALUES (84, '7');
INSERT INTO `sys_lab_schedule` VALUES (85, '1');
INSERT INTO `sys_lab_schedule` VALUES (85, '2');
INSERT INTO `sys_lab_schedule` VALUES (85, '3');
INSERT INTO `sys_lab_schedule` VALUES (85, '4');
INSERT INTO `sys_lab_schedule` VALUES (86, '5');
INSERT INTO `sys_lab_schedule` VALUES (86, '6');
INSERT INTO `sys_lab_schedule` VALUES (86, '7');
INSERT INTO `sys_lab_schedule` VALUES (87, '1');
INSERT INTO `sys_lab_schedule` VALUES (88, '2');
INSERT INTO `sys_lab_schedule` VALUES (88, '3');
INSERT INTO `sys_lab_schedule` VALUES (88, '4');
INSERT INTO `sys_lab_schedule` VALUES (89, '5');
INSERT INTO `sys_lab_schedule` VALUES (89, '6');
INSERT INTO `sys_lab_schedule` VALUES (89, '7');
INSERT INTO `sys_lab_schedule` VALUES (90, '1');
INSERT INTO `sys_lab_schedule` VALUES (90, '4');
INSERT INTO `sys_lab_schedule` VALUES (91, '5');
INSERT INTO `sys_lab_schedule` VALUES (91, '6');
INSERT INTO `sys_lab_schedule` VALUES (92, '1');
INSERT INTO `sys_lab_schedule` VALUES (92, '3');
INSERT INTO `sys_lab_schedule` VALUES (92, '4');
INSERT INTO `sys_lab_schedule` VALUES (92, '7');
INSERT INTO `sys_lab_schedule` VALUES (93, '6');
INSERT INTO `sys_lab_schedule` VALUES (93, '7');
INSERT INTO `sys_lab_schedule` VALUES (94, '1');
INSERT INTO `sys_lab_schedule` VALUES (95, '2');
INSERT INTO `sys_lab_schedule` VALUES (95, '3');
INSERT INTO `sys_lab_schedule` VALUES (96, '4');
INSERT INTO `sys_lab_schedule` VALUES (96, '5');
INSERT INTO `sys_lab_schedule` VALUES (96, '6');
INSERT INTO `sys_lab_schedule` VALUES (96, '7');
INSERT INTO `sys_lab_schedule` VALUES (97, '1');
INSERT INTO `sys_lab_schedule` VALUES (97, '3');
INSERT INTO `sys_lab_schedule` VALUES (97, '4');
INSERT INTO `sys_lab_schedule` VALUES (98, '1');
INSERT INTO `sys_lab_schedule` VALUES (98, '2');
INSERT INTO `sys_lab_schedule` VALUES (98, '5');
INSERT INTO `sys_lab_schedule` VALUES (98, '7');
INSERT INTO `sys_lab_schedule` VALUES (99, '4');
INSERT INTO `sys_lab_schedule` VALUES (99, '5');
INSERT INTO `sys_lab_schedule` VALUES (100, '2');
INSERT INTO `sys_lab_schedule` VALUES (100, '4');
INSERT INTO `sys_lab_schedule` VALUES (100, '5');
INSERT INTO `sys_lab_schedule` VALUES (100, '6');
INSERT INTO `sys_lab_schedule` VALUES (101, '1');
INSERT INTO `sys_lab_schedule` VALUES (101, '3');
INSERT INTO `sys_lab_schedule` VALUES (112, '2');

-- ----------------------------
-- Table structure for sys_major
-- ----------------------------
DROP TABLE IF EXISTS `sys_major`;
CREATE TABLE `sys_major`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `major_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '专业名称',
  `college_id` bigint NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_major
-- ----------------------------
INSERT INTO `sys_major` VALUES (1, '软件工程', 1);
INSERT INTO `sys_major` VALUES (2, '空间信息', 1);
INSERT INTO `sys_major` VALUES (3, '数据科学与大数据技术', 1);
INSERT INTO `sys_major` VALUES (4, '大气科学', 2);
INSERT INTO `sys_major` VALUES (5, '应用气象学', 2);
INSERT INTO `sys_major` VALUES (6, '地理信息科学', 3);
INSERT INTO `sys_major` VALUES (7, '环境科学', 3);
INSERT INTO `sys_major` VALUES (8, '遥感科学与技术', 3);
INSERT INTO `sys_major` VALUES (9, '测绘工程', 3);
INSERT INTO `sys_major` VALUES (10, '环境工程', 3);
INSERT INTO `sys_major` VALUES (11, '信息与计算科学', 4);
INSERT INTO `sys_major` VALUES (12, '数学与应用数学', 4);
INSERT INTO `sys_major` VALUES (13, '统计学', 5);
INSERT INTO `sys_major` VALUES (14, '经济统计学', 5);
INSERT INTO `sys_major` VALUES (15, '金融工程', 5);
INSERT INTO `sys_major` VALUES (16, '国际经济与贸易', 5);
INSERT INTO `sys_major` VALUES (17, '社会工作', 6);
INSERT INTO `sys_major` VALUES (18, '中国语言文学', 6);
INSERT INTO `sys_major` VALUES (19, '视觉传达设计', 6);
INSERT INTO `sys_major` VALUES (20, '英语', 7);
INSERT INTO `sys_major` VALUES (21, '翻译', 7);
INSERT INTO `sys_major` VALUES (22, '马克思主义基本原理', 8);
INSERT INTO `sys_major` VALUES (23, '马克思主义中国化研究', 8);
INSERT INTO `sys_major` VALUES (24, '思想政治教育', 8);
INSERT INTO `sys_major` VALUES (25, '电子科学与技术', 9);
INSERT INTO `sys_major` VALUES (26, '光电信息科学与工程', 9);
INSERT INTO `sys_major` VALUES (27, '应用物理学', 9);
INSERT INTO `sys_major` VALUES (28, '区块链工程', 10);
INSERT INTO `sys_major` VALUES (29, '财务管理', 11);
INSERT INTO `sys_major` VALUES (30, '会计学', 11);
INSERT INTO `sys_major` VALUES (31, '行政管理', 11);
INSERT INTO `sys_major` VALUES (32, '人力资源管理', 11);
INSERT INTO `sys_major` VALUES (33, '会展经济与管理', 11);
INSERT INTO `sys_major` VALUES (34, '市场营销', 11);
INSERT INTO `sys_major` VALUES (35, '旅游管理', 11);
INSERT INTO `sys_major` VALUES (36, '物流工程', 12);
INSERT INTO `sys_major` VALUES (37, '物流管理', 12);
INSERT INTO `sys_major` VALUES (38, '电子商务', 12);
INSERT INTO `sys_major` VALUES (39, '工程管理', 12);
INSERT INTO `sys_major` VALUES (40, '信息管理与信息系统', 12);
INSERT INTO `sys_major` VALUES (41, '供应链管理', 12);
INSERT INTO `sys_major` VALUES (42, '电子信息工程', 13);
INSERT INTO `sys_major` VALUES (43, '电子信息科学与技术', 13);
INSERT INTO `sys_major` VALUES (44, '生物医学工程', 13);
INSERT INTO `sys_major` VALUES (45, '自动化', 14);
INSERT INTO `sys_major` VALUES (46, '电气工程及其自动化', 14);
INSERT INTO `sys_major` VALUES (47, '机械电子工程', 14);
INSERT INTO `sys_major` VALUES (48, '机器人工程', 14);
INSERT INTO `sys_major` VALUES (49, '通信工程', 15);
INSERT INTO `sys_major` VALUES (50, '微电子', 15);
INSERT INTO `sys_major` VALUES (51, '计算机科学与技术', 16);
INSERT INTO `sys_major` VALUES (52, '数字媒体技术', 16);
INSERT INTO `sys_major` VALUES (53, '智能科学与技术', 16);
INSERT INTO `sys_major` VALUES (54, '信息安全', 17);
INSERT INTO `sys_major` VALUES (55, '网络工程', 17);
INSERT INTO `sys_major` VALUES (56, '物联网工程', 17);
INSERT INTO `sys_major` VALUES (57, '网络空间安全', 17);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告内容',
  `create_time` datetime NOT NULL COMMENT '公告发表时间',
  `update_time` datetime NOT NULL COMMENT '公告修改时间',
  `creator` bigint NOT NULL COMMENT '发布公告的人(管理员)',
  `level` int NOT NULL COMMENT '公告的等级，按照公告从小到大排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (22, 'Miss.', 'Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. The On Startup feature allows you to control what tabs appear when you launch Navicat. I destroy my enemies when I make them my friends. How we spend our days is, of course, how we spend our lives. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. It wasn’t raining when Noah built the ark. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Flexible settings enable you to set up a custom key for comparison and synchronization. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Remember that failure is an event, not a person. You will succeed because most people are lazy. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. How we spend our days is, of course, how we spend our lives. Difficult circumstances serve as a textbook of life for people. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. A man’s best friends are his ten fingers. The first step is as good as half over. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. If opportunity doesn’t knock, build a door. The Synchronize to Database function will give you a full picture of all database differences. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. The Synchronize to Database function will give you a full picture of all database differences. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. I will greet this day with love in my heart. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. All journeys have secret destinations of which the traveler is unaware. A query is used to extract data from the database in a readable format according to the user\'s request. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. Success consists of going from failure to failure without loss of enthusiasm. The first step is as good as half over. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. I will greet this day with love in my heart. Optimism is the one quality more associated with success and happiness than any other. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. You will succeed because most people are lazy. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. I destroy my enemies when I make them my friends. Sometimes you win, sometimes you learn. The reason why a great man is great is that he resolves to be a great man. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. In the middle of winter I at last discovered that there was in me an invincible summer. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. Sometimes you win, sometimes you learn. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. If it scares you, it might be a good thing to try. It wasn’t raining when Noah built the ark. If the plan doesn’t work, change the plan, but never the goal. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Difficult circumstances serve as a textbook of life for people. Typically, it is employed as an encrypted version of Telnet. Sometimes you win, sometimes you learn. A comfort zone is a beautiful place, but nothing ever grows there. All journeys have secret destinations of which the traveler is unaware. How we spend our days is, of course, how we spend our lives. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. To connect to a database or schema, simply double-click it in the pane. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. You must be the change you wish to see in the world. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. How we spend our days is, of course, how we spend our lives. If it scares you, it might be a good thing to try. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. Typically, it is employed as an encrypted version of Telnet. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible.', '2019-08-21 20:18:53', '2009-11-08 00:14:10', 1, 31);
INSERT INTO `sys_notice` VALUES (24, 'Mrs.', 'The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. A man is not old until regrets take the place of dreams. If it scares you, it might be a good thing to try. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. You will succeed because most people are lazy. Creativity is intelligence having fun. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Navicat 15 has added support for the system-wide dark mode. If you wait, all that happens is you get older. A query is used to extract data from the database in a readable format according to the user\'s request. If you wait, all that happens is you get older. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Sometimes you win, sometimes you learn. A comfort zone is a beautiful place, but nothing ever grows there. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. If you wait, all that happens is you get older. I destroy my enemies when I make them my friends. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. If it scares you, it might be a good thing to try. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences.', '2000-09-01 07:26:21', '2011-10-31 08:25:19', 1, 32);
INSERT INTO `sys_notice` VALUES (25, 'Prof.ss', '<p>A man’s best friends are his ten fingers. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server. Anyone who has never made a mistake has never tried anything new. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. It wasn’t raining when Noah built the ark. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. A man’s best friends are his ten fingers. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. To connect to a database or schema, simply double-click it in the pane. If the plan doesn’t work, change the plan, but never the goal. You cannot save people, you can just love them. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. What you get by achieving your goals is not as important as what you become by achieving your goals. In the middle of winter I at last discovered that there was in me an invincible summer. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Remember that failure is an event, not a person. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. It wasn’t raining when Noah built the ark. Navicat 15 has added support for the system-wide dark mode. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. What you get by achieving your goals is not as important as what you become by achieving your goals. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. A man is not old until regrets take the place of dreams. A man’s best friends are his ten fingers. The Synchronize to Database function will give you a full picture of all database differences. A comfort zone is a beautiful place, but nothing ever grows there. Anyone who has never made a mistake has never tried anything new. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. The first step is as good as half over. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. All journeys have secret destinations of which the traveler is unaware. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. All journeys have secret destinations of which the traveler is unaware. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server. To connect to a database or schema, simply double-click it in the pane. Creativity is intelligence having fun. It wasn’t raining when Noah built the ark. Flexible settings enable you to set up a custom key for comparison and synchronization. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. Flexible settings enable you to set up a custom key for comparison and synchronization.</p>', '2006-03-24 14:51:01', '2023-05-15 19:35:26', 1, 34);
INSERT INTO `sys_notice` VALUES (27, 'Mrs.', 'The Synchronize to Database function will give you a full picture of all database differences. In the middle of winter I at last discovered that there was in me an invincible summer. A man’s best friends are his ten fingers. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. I may not have gone where I intended to go, but I think I have ended up where I needed to be. The past has no power over the present moment. Anyone who has never made a mistake has never tried anything new. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. The Synchronize to Database function will give you a full picture of all database differences. Sometimes you win, sometimes you learn. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. You will succeed because most people are lazy. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another. I destroy my enemies when I make them my friends. I destroy my enemies when I make them my friends. I destroy my enemies when I make them my friends. The Synchronize to Database function will give you a full picture of all database differences. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. How we spend our days is, of course, how we spend our lives. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. I destroy my enemies when I make them my friends. You must be the change you wish to see in the world. The past has no power over the present moment. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. If the plan doesn’t work, change the plan, but never the goal. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. Flexible settings enable you to set up a custom key for comparison and synchronization. In the middle of winter I at last discovered that there was in me an invincible summer. If opportunity doesn’t knock, build a door. A comfort zone is a beautiful place, but nothing ever grows there. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. A man is not old until regrets take the place of dreams. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. What you get by achieving your goals is not as important as what you become by achieving your goals. If the plan doesn’t work, change the plan, but never the goal. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. Creativity is intelligence having fun. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. You cannot save people, you can just love them. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. A query is used to extract data from the database in a readable format according to the user\'s request. I may not have gone where I intended to go, but I think I have ended up where I needed to be. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. Anyone who has never made a mistake has never tried anything new. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. In the middle of winter I at last discovered that there was in me an invincible summer. Flexible settings enable you to set up a custom key for comparison and synchronization. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. Anyone who has ever made anything of importance was disciplined. If opportunity doesn’t knock, build a door. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. In the middle of winter I at last discovered that there was in me an invincible summer. Navicat 15 has added support for the system-wide dark mode. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. Remember that failure is an event, not a person. How we spend our days is, of course, how we spend our lives. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. What you get by achieving your goals is not as important as what you become by achieving your goals. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more.', '2021-07-29 11:00:11', '2003-05-03 11:48:45', 1, 27);
INSERT INTO `sys_notice` VALUES (37, ' 关于2023年6月全国大学英语四、六级考试取消因无故缺考被报名限制的紧急通知', '<p>	各位同学：</p><p>	截止目前，本次全国大学英语四、六级考试报名剩余考位较为<strong>充足</strong>（四级两校区考位充足、六级龙泉校区考位充足），为保障更多的同学有考试机会，本次报名学校将取消因上次笔试缺考不允许报名的限制，允许上次笔试缺考考生报名；若当前校区已报满，考生可自愿选择跨校区报名。</p><p>	涉及考生报名时间：	<span style=\"color: red;\">2023年5月6日上午10：00—2023年5月6日17：00。</span></p><p>	2023年下半年（12月）报名时，学校仍然会根据考位情况对2023年上半年（6月）无故缺考考生做报名限制。</p><p>	特此通知	。</p><p>	</p>', '2023-01-01 03:34:25', '2023-06-08 22:25:54', 1, 1);
INSERT INTO `sys_notice` VALUES (42, 'Mr.', 'SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. Creativity is intelligence having fun. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. The first step is as good as half over. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Optimism is the one quality more associated with success and happiness than any other. The On Startup feature allows you to control what tabs appear when you launch Navicat. If you wait, all that happens is you get older. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. How we spend our days is, of course, how we spend our lives. What you get by achieving your goals is not as important as what you become by achieving your goals. What you get by achieving your goals is not as important as what you become by achieving your goals. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Anyone who has ever made anything of importance was disciplined. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. The On Startup feature allows you to control what tabs appear when you launch Navicat. Champions keep playing until they get it right. Genius is an infinite capacity for taking pains. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. A comfort zone is a beautiful place, but nothing ever grows there. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server.', '2006-08-17 05:35:38', '2010-01-23 23:16:16', 1, 30);
INSERT INTO `sys_notice` VALUES (47, '111', 'pass', '2003-08-31 09:08:54', '2022-09-03 01:04:02', 1, 31);
INSERT INTO `sys_notice` VALUES (48, 'Mrs.', 'The past has no power over the present moment. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. The first step is as good as half over. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. I will greet this day with love in my heart. Success consists of going from failure to failure without loss of enthusiasm. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. Navicat 15 has added support for the system-wide dark mode. A man is not old until regrets take the place of dreams. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. Typically, it is employed as an encrypted version of Telnet. In the middle of winter I at last discovered that there was in me an invincible summer. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. A man is not old until regrets take the place of dreams. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Flexible settings enable you to set up a custom key for comparison and synchronization. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. If opportunity doesn’t knock, build a door. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. You cannot save people, you can just love them. Sometimes you win, sometimes you learn. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. All journeys have secret destinations of which the traveler is unaware. A man is not old until regrets take the place of dreams. There is no way to happiness. Happiness is the way. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Optimism is the one quality more associated with success and happiness than any other. Anyone who has never made a mistake has never tried anything new. Anyone who has ever made anything of importance was disciplined. If opportunity doesn’t knock, build a door. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. Navicat 15 has added support for the system-wide dark mode.', '2022-08-02 13:18:02', '2015-03-19 16:31:13', 1, 31);
INSERT INTO `sys_notice` VALUES (49, 'Prof.', 'The Synchronize to Database function will give you a full picture of all database differences. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. A query is used to extract data from the database in a readable format according to the user\'s request. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. What you get by achieving your goals is not as important as what you become by achieving your goals. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. You will succeed because most people are lazy. Remember that failure is an event, not a person. The past has no power over the present moment. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. There is no way to happiness. Happiness is the way. If it scares you, it might be a good thing to try. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Success consists of going from failure to failure without loss of enthusiasm. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. Champions keep playing until they get it right. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. A comfort zone is a beautiful place, but nothing ever grows there. All journeys have secret destinations of which the traveler is unaware. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. There is no way to happiness. Happiness is the way. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. In the middle of winter I at last discovered that there was in me an invincible summer. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration.', '2007-10-31 03:55:51', '2000-04-18 15:37:01', 1, 27);
INSERT INTO `sys_notice` VALUES (53, 'Mrs.', 'Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. Sometimes you win, sometimes you learn. Flexible settings enable you to set up a custom key for comparison and synchronization. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. You will succeed because most people are lazy. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. The reason why a great man is great is that he resolves to be a great man. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. Anyone who has ever made anything of importance was disciplined. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane.', '2000-12-04 10:41:34', '2019-06-01 15:41:55', 1, 33);
INSERT INTO `sys_notice` VALUES (54, 'Mr.', 'All journeys have secret destinations of which the traveler is unaware. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. The past has no power over the present moment. You will succeed because most people are lazy. What you get by achieving your goals is not as important as what you become by achieving your goals. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Actually it is just in an idea when feel oneself can achieve and cannot achieve. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. You cannot save people, you can just love them. Anyone who has never made a mistake has never tried anything new. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. I will greet this day with love in my heart. Optimism is the one quality more associated with success and happiness than any other. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. A man is not old until regrets take the place of dreams. The past has no power over the present moment. The reason why a great man is great is that he resolves to be a great man. A query is used to extract data from the database in a readable format according to the user\'s request. The reason why a great man is great is that he resolves to be a great man. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. Remember that failure is an event, not a person. Optimism is the one quality more associated with success and happiness than any other. If opportunity doesn’t knock, build a door. A comfort zone is a beautiful place, but nothing ever grows there. There is no way to happiness. Happiness is the way. Creativity is intelligence having fun. Genius is an infinite capacity for taking pains. If it scares you, it might be a good thing to try. A man is not old until regrets take the place of dreams. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. All journeys have secret destinations of which the traveler is unaware. Champions keep playing until they get it right. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Actually it is just in an idea when feel oneself can achieve and cannot achieve. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. Anyone who has never made a mistake has never tried anything new. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. Anyone who has ever made anything of importance was disciplined. In the middle of winter I at last discovered that there was in me an invincible summer. Difficult circumstances serve as a textbook of life for people. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. Typically, it is employed as an encrypted version of Telnet. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. You cannot save people, you can just love them.', '2018-12-30 03:29:26', '2014-05-03 10:08:51', 1, 21);
INSERT INTO `sys_notice` VALUES (62, 'Mr.', 'SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. The reason why a great man is great is that he resolves to be a great man. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. The Synchronize to Database function will give you a full picture of all database differences. Success consists of going from failure to failure without loss of enthusiasm. Genius is an infinite capacity for taking pains. Champions keep playing until they get it right. Actually it is just in an idea when feel oneself can achieve and cannot achieve. A comfort zone is a beautiful place, but nothing ever grows there. The Synchronize to Database function will give you a full picture of all database differences. To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. A man is not old until regrets take the place of dreams. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. It wasn’t raining when Noah built the ark. A query is used to extract data from the database in a readable format according to the user\'s request. Actually it is just in an idea when feel oneself can achieve and cannot achieve. All journeys have secret destinations of which the traveler is unaware. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. A man’s best friends are his ten fingers. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. Remember that failure is an event, not a person. I will greet this day with love in my heart. How we spend our days is, of course, how we spend our lives. Creativity is intelligence having fun. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. To connect to a database or schema, simply double-click it in the pane. Difficult circumstances serve as a textbook of life for people. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. There is no way to happiness. Happiness is the way. You must be the change you wish to see in the world. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. Success consists of going from failure to failure without loss of enthusiasm. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. The On Startup feature allows you to control what tabs appear when you launch Navicat. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. You must be the change you wish to see in the world. You cannot save people, you can just love them. The Synchronize to Database function will give you a full picture of all database differences. It wasn’t raining when Noah built the ark. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Success consists of going from failure to failure without loss of enthusiasm. Actually it is just in an idea when feel oneself can achieve and cannot achieve. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. To connect to a database or schema, simply double-click it in the pane. How we spend our days is, of course, how we spend our lives. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. You will succeed because most people are lazy. The past has no power over the present moment. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. Anyone who has ever made anything of importance was disciplined. A query is used to extract data from the database in a readable format according to the user\'s request. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. I will greet this day with love in my heart. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud. The On Startup feature allows you to control what tabs appear when you launch Navicat. Champions keep playing until they get it right. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. The past has no power over the present moment. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. Remember that failure is an event, not a person. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Actually it is just in an idea when feel oneself can achieve and cannot achieve. You cannot save people, you can just love them. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view.', '2022-06-15 20:49:36', '2002-01-11 03:55:30', 1, 28);
INSERT INTO `sys_notice` VALUES (69, 'Prof.', 'You must be the change you wish to see in the world. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. If the plan doesn’t work, change the plan, but never the goal. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. The past has no power over the present moment. If you wait, all that happens is you get older. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. You cannot save people, you can just love them. The Synchronize to Database function will give you a full picture of all database differences. The reason why a great man is great is that he resolves to be a great man. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. You must be the change you wish to see in the world. I will greet this day with love in my heart. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. If you wait, all that happens is you get older. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server. All journeys have secret destinations of which the traveler is unaware. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. The reason why a great man is great is that he resolves to be a great man. What you get by achieving your goals is not as important as what you become by achieving your goals. There is no way to happiness. Happiness is the way. A query is used to extract data from the database in a readable format according to the user\'s request. The first step is as good as half over. Optimism is the one quality more associated with success and happiness than any other. A man is not old until regrets take the place of dreams. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. You must be the change you wish to see in the world. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. You must be the change you wish to see in the world. Typically, it is employed as an encrypted version of Telnet. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. You will succeed because most people are lazy. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. The Synchronize to Database function will give you a full picture of all database differences. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. You cannot save people, you can just love them. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Remember that failure is an event, not a person. I destroy my enemies when I make them my friends. You will succeed because most people are lazy. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. How we spend our days is, of course, how we spend our lives. You must be the change you wish to see in the world. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. You must be the change you wish to see in the world. If the plan doesn’t work, change the plan, but never the goal. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server.', '2003-12-04 21:08:35', '2016-02-07 10:47:06', 1, 31);
INSERT INTO `sys_notice` VALUES (76, '4444', '<p>If the plan doesn’t work, change the plan, but never the goal. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. The On Startup feature allows you to control what tabs appear when you launch Navicat. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. There is no way to happiness. Happiness is the way. How we spend our days is, of course, how we spend our lives. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. In the middle of winter I at last discovered that there was in me an invincible summer. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. The On Startup feature allows you to control what tabs appear when you launch Navicat. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. The first step is as good as half over. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud. A query is used to extract data from the database in a readable format according to the user\'s request. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. You must be the change you wish to see in the world. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries.</p>', '2017-05-17 02:46:43', '2023-05-12 17:43:27', 1, 21);
INSERT INTO `sys_notice` VALUES (80, '222', '<p>If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Actually it is just in an idea when feel oneself can achieve and cannot achieve. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. If the plan doesn’t work, change the plan, but never the goal. A comfort zone is a beautiful place, but nothing ever grows there. Sometimes you win, sometimes you learn. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. You must be the change you wish to see in the world. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server. To connect to a database or schema, simply double-click it in the pane. The past has no power over the present moment. A man’s best friends are his ten fingers. Success consists of going from failure to failure without loss of enthusiasm. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Creativity is intelligence having fun. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. You must be the change you wish to see in the world. The past has no power over the present moment. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. How we spend our days is, of course, how we spend our lives. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. What you get by achieving your goals is not as important as what you become by achieving your goals. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. Success consists of going from failure to failure without loss of enthusiasm. How we spend our days is, of course, how we spend our lives. I will greet this day with love in my heart. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. A query is used to extract data from the database in a readable format according to the user\'s request. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Typically, it is employed as an encrypted version of Telnet. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Genius is an infinite capacity for taking pains. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. To connect to a database or schema, simply double-click it in the pane. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud. Anyone who has never made a mistake has never tried anything new. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Champions keep playing until they get it right. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. If you wait, all that happens is you get older. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. If you wait, all that happens is you get older. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. I will greet this day with love in my heart. I destroy my enemies when I make them my friends. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. The first step is as good as half over. The first step is as good as half over. The Synchronize to Database function will give you a full picture of all database differences. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms.</p>', '2006-05-24 14:47:45', '2023-05-12 17:43:13', 1, 22);
INSERT INTO `sys_notice` VALUES (82, 'Mr.', 'Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. A man’s best friends are his ten fingers. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. Difficult circumstances serve as a textbook of life for people. Optimism is the one quality more associated with success and happiness than any other. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored.', '2006-08-24 19:41:46', '2014-07-07 18:23:38', 1, 28);
INSERT INTO `sys_notice` VALUES (85, 'Mrs.', 'SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. I may not have gone where I intended to go, but I think I have ended up where I needed to be. The Synchronize to Database function will give you a full picture of all database differences. The On Startup feature allows you to control what tabs appear when you launch Navicat. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. How we spend our days is, of course, how we spend our lives. It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Anyone who has never made a mistake has never tried anything new. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily.', '2011-10-13 19:58:16', '2019-09-18 02:11:12', 1, 27);
INSERT INTO `sys_notice` VALUES (96, 'Miss.', 'The reason why a great man is great is that he resolves to be a great man. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. I may not have gone where I intended to go, but I think I have ended up where I needed to be. It wasn’t raining when Noah built the ark. Typically, it is employed as an encrypted version of Telnet. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. The Synchronize to Database function will give you a full picture of all database differences. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. The past has no power over the present moment. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. Anyone who has never made a mistake has never tried anything new. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. Difficult circumstances serve as a textbook of life for people. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. If it scares you, it might be a good thing to try. You cannot save people, you can just love them. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. You must be the change you wish to see in the world. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. Optimism is the one quality more associated with success and happiness than any other. Navicat 15 has added support for the system-wide dark mode. In the middle of winter I at last discovered that there was in me an invincible summer. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. In the middle of winter I at last discovered that there was in me an invincible summer. Anyone who has never made a mistake has never tried anything new. To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source. Flexible settings enable you to set up a custom key for comparison and synchronization. If it scares you, it might be a good thing to try. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. You must be the change you wish to see in the world. Actually it is just in an idea when feel oneself can achieve and cannot achieve. In the middle of winter I at last discovered that there was in me an invincible summer. I may not have gone where I intended to go, but I think I have ended up where I needed to be. If you wait, all that happens is you get older. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server.', '2003-03-29 13:45:38', '2001-04-13 02:52:00', 1, 22);
INSERT INTO `sys_notice` VALUES (99, 'Prof.', 'Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process. The On Startup feature allows you to control what tabs appear when you launch Navicat. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Sometimes you win, sometimes you learn. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process.', '2001-01-18 13:04:51', '2007-09-18 19:51:33', 1, 29);
INSERT INTO `sys_notice` VALUES (103, 'Prof.', 'Anyone who has ever made anything of importance was disciplined. The first step is as good as half over. To connect to a database or schema, simply double-click it in the pane. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration to multiple kinds of database so easy. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Success consists of going from failure to failure without loss of enthusiasm. Difficult circumstances serve as a textbook of life for people. I destroy my enemies when I make them my friends. I destroy my enemies when I make them my friends. If you wait, all that happens is you get older. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. Champions keep playing until they get it right. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. The On Startup feature allows you to control what tabs appear when you launch Navicat. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. How we spend our days is, of course, how we spend our lives. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. The Synchronize to Database function will give you a full picture of all database differences. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure. I destroy my enemies when I make them my friends. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. The reason why a great man is great is that he resolves to be a great man. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Creativity is intelligence having fun. A man is not old until regrets take the place of dreams. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. How we spend our days is, of course, how we spend our lives. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Navicat 15 has added support for the system-wide dark mode. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. Anyone who has never made a mistake has never tried anything new. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. You will succeed because most people are lazy. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. The reason why a great man is great is that he resolves to be a great man. If you wait, all that happens is you get older. With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. I destroy my enemies when I make them my friends. Difficult circumstances serve as a textbook of life for people. Anyone who has never made a mistake has never tried anything new. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. If the plan doesn’t work, change the plan, but never the goal. Success consists of going from failure to failure without loss of enthusiasm. All journeys have secret destinations of which the traveler is unaware. If you wait, all that happens is you get older. The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. A query is used to extract data from the database in a readable format according to the user\'s request. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. Success consists of going from failure to failure without loss of enthusiasm. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. What you get by achieving your goals is not as important as what you become by achieving your goals. The On Startup feature allows you to control what tabs appear when you launch Navicat. A query is used to extract data from the database in a readable format according to the user\'s request. Genius is an infinite capacity for taking pains. Champions keep playing until they get it right. Flexible settings enable you to set up a custom key for comparison and synchronization. Sometimes you win, sometimes you learn. To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences. I destroy my enemies when I make them my friends. The On Startup feature allows you to control what tabs appear when you launch Navicat. The first step is as good as half over. The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. Actually it is just in an idea when feel oneself can achieve and cannot achieve. The past has no power over the present moment. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. You must be the change you wish to see in the world.', '2004-11-20 12:35:45', '2007-06-05 07:28:19', 1, 32);
INSERT INTO `sys_notice` VALUES (106, 'Miss.', 'With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way. I will greet this day with love in my heart. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication. Remember that failure is an event, not a person. If it scares you, it might be a good thing to try. Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring effective as possible. If it scares you, it might be a good thing to try. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. The first step is as good as half over. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature. In the middle of winter I at last discovered that there was in me an invincible summer. Success consists of going from failure to failure without loss of enthusiasm. Anyone who has never made a mistake has never tried anything new. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane. Flexible settings enable you to set up a custom key for comparison and synchronization. Difficult circumstances serve as a textbook of life for people. Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information. SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security. Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. Optimism is the one quality more associated with success and happiness than any other. Actually it is just in an idea when feel oneself can achieve and cannot achieve. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information in the General tab. Success consists of going from failure to failure without loss of enthusiasm. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. What you get by achieving your goals is not as important as what you become by achieving your goals. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored. I may not have gone where I intended to go, but I think I have ended up where I needed to be. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats.', '2005-03-19 12:36:42', '2010-08-03 22:14:10', 1, 29);
INSERT INTO `sys_notice` VALUES (117, '挂估计发动机萨克利夫尽量快点撒就发', '<p>就覅家门口刺蛾温柔皮肤KFC v，</p><p>	摩配日结果vi节目看佛牌天热通过i哦平假名v给i哦按实际</p><p>官方提款机柔儿评价可通过覅哦怕sssdasdasdasdqweasdasdqwjkhdjkashdjkqwhdkjhaskdjhaioduwidh</p>', '2023-05-12 12:28:32', '2023-06-05 18:02:02', 2, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin');
INSERT INTO `sys_role` VALUES (2, 'teacher');
INSERT INTO `sys_role` VALUES (3, 'student');

-- ----------------------------
-- Table structure for sys_time_slot
-- ----------------------------
DROP TABLE IF EXISTS `sys_time_slot`;
CREATE TABLE `sys_time_slot`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `start_time` time NULL DEFAULT NULL,
  `end_time` time NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '实验室每天的开放时间段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_time_slot
-- ----------------------------
INSERT INTO `sys_time_slot` VALUES (1, '08:00:00', '10:00:00');
INSERT INTO `sys_time_slot` VALUES (2, '10:00:00', '12:00:00');
INSERT INTO `sys_time_slot` VALUES (3, '14:00:00', '16:00:00');
INSERT INTO `sys_time_slot` VALUES (4, '16:00:00', '18:00:00');
INSERT INTO `sys_time_slot` VALUES (5, '00:00:00', '23:59:00');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名(学号，工号)',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '加密盐',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男' COMMENT '性别,男-1，女-0',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像的地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表，这里存储了所有的用户其中id字段表示用户的唯一id用于在student和teacher表中查找具体信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2021001', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', '张三', '男', '13031322281', 'zs@qq.com', NULL, '2023-04-17 17:07:00', '2023-05-16 20:09:12');
INSERT INTO `sys_user` VALUES (2, '2021000', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', '张鑫', '男', '11451419198', 'zx@github.com', NULL, '2023-04-20 17:07:00', '2023-06-09 14:13:36');
INSERT INTO `sys_user` VALUES (3, '2021002', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Cx330I', '女', '80-4795-7952', 'kishi1@yahoo.com', '', '2022-07-18 13:49:53', '2011-04-02 02:41:43');
INSERT INTO `sys_user` VALUES (4, '2021003', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'AokiTsubasa', '女', '13880681423', 'aoki4@gmail.com', '21cc478f-9c4e-49f7-9fda-a43779203cf4.jpg', '2012-04-02 00:46:11', '2023-05-16 13:49:52');
INSERT INTO `sys_user` VALUES (5, '2021004', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Tian Zitao', '男', '28-9788-2132', 'zitao509@icloud.com', '', '2015-06-17 14:10:11', '2009-05-09 20:00:15');
INSERT INTO `sys_user` VALUES (6, '2021005', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Ricky Green', '男', '158-2395-7291', 'greer10@gmail.com', '', '2012-10-19 05:13:50', '2022-05-13 15:06:09');
INSERT INTO `sys_user` VALUES (7, '2021006', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Phyllis Snyder', '男', '7129 630199', 'phyllis89@mail.com', '', '2013-04-03 05:46:56', '2003-03-08 09:16:29');
INSERT INTO `sys_user` VALUES (8, '2021008', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', '8号', '男', '11451419198', 'kinoshitayun@gmail.com', '', '2009-01-08 19:57:56', '2023-05-16 13:50:02');
INSERT INTO `sys_user` VALUES (9, '2021114', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Sun Ziyi', '男', '174-6129-5738', 'sunziy1974@icloud.com', '', '2018-03-29 12:39:07', '2004-10-10 00:23:45');
INSERT INTO `sys_user` VALUES (10, '2021009', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Lu Zhennan', '女', '70-5978-4051', 'luzhennan@gmail.com', '', '2004-07-27 01:48:17', '2001-04-03 02:02:21');
INSERT INTO `sys_user` VALUES (11, '2021010', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Yu Jialun', '女', '70-5466-3446', 'yuj7@icloud.com', '', '2004-01-26 06:50:33', '2003-07-14 22:21:36');
INSERT INTO `sys_user` VALUES (12, '2021011', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Qin Anqi', '女', '(20) 3855 0016', 'qinanqi@icloud.com', '', '2016-05-07 07:50:30', '2011-10-20 00:53:45');
INSERT INTO `sys_user` VALUES (13, '2021012', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Koyama Hazuki', '男', '66-324-4269', 'hazukikoyama60@icloud.com', '', '2005-06-18 06:49:41', '2017-02-16 00:07:20');
INSERT INTO `sys_user` VALUES (14, '2021013', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Mui Kwok Kuen', '男', '(121) 674 9880', 'mukk1229@icloud.com', '', '2014-02-07 18:47:58', '2007-10-16 07:56:46');
INSERT INTO `sys_user` VALUES (15, '2021014', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'MaedaKazuma', '女', '', 'kmaeda@icloud.com', '', '2013-03-04 11:32:47', '2023-05-16 13:39:08');
INSERT INTO `sys_user` VALUES (16, '2021015', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Lawrence Ferguson', '男', '213-753-1525', 'fergulawr@gmail.com', '', '2007-02-26 00:37:59', '2016-09-17 03:50:01');
INSERT INTO `sys_user` VALUES (17, '2021016', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Morita Miu', '女', '70-7542-9869', 'moritamiu516@gmail.com', '', '2002-03-26 16:14:44', '2008-11-04 22:24:56');
INSERT INTO `sys_user` VALUES (18, '2021017', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Choi On Kay', '女', '190-2421-2352', 'okch@gmail.com', '', '2002-01-01 12:58:58', '2017-07-08 21:20:44');
INSERT INTO `sys_user` VALUES (19, '2021018', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Kikuchi Tsubasa', '女', '66-387-0819', 'tsubasa911@gmail.com', '', '2015-06-08 08:11:45', '2012-10-06 14:10:23');
INSERT INTO `sys_user` VALUES (20, '2021019', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Sakurai Ikki', '男', '213-863-2084', 'sakuraii7@hotmail.com', '', '2006-10-28 17:13:26', '2010-04-22 04:14:48');
INSERT INTO `sys_user` VALUES (21, '2021020', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Yao Zhennan', '男', '7636 231878', 'zhennanya17@outlook.com', '', '2002-08-05 00:41:48', '2009-02-16 05:42:37');
INSERT INTO `sys_user` VALUES (22, '2021021', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Inoue Rin', '男', '718-969-4081', 'inoue10@yahoo.com', '', '2013-07-25 09:59:56', '2009-05-06 12:45:52');
INSERT INTO `sys_user` VALUES (23, '2021022', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Jeffrey Martinez', '女', '176-1886-4023', 'jeffreymarti@mail.com', '', '2000-06-17 22:35:45', '2002-10-18 10:34:42');
INSERT INTO `sys_user` VALUES (24, '2021023', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'David Stevens', '女', '52-499-8235', 'davidst70@gmail.com', '', '2019-07-14 23:29:00', '2021-04-07 13:50:23');
INSERT INTO `sys_user` VALUES (25, '2021024', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Rodney Ford', '男', '131-9088-9163', 'rodnford@mail.com', '', '2016-01-18 01:25:19', '2007-10-21 16:52:57');
INSERT INTO `sys_user` VALUES (26, '2021025', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Ding Jiehong', '女', '330-105-0217', 'djie@yahoo.com', '', '2012-06-24 14:58:43', '2003-03-23 10:36:29');
INSERT INTO `sys_user` VALUES (27, '2021026', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Eleanor Herrera', '男', '74-625-3713', 'eleanorherre1@gmail.com', '', '2001-02-21 08:06:39', '2012-11-25 01:52:28');
INSERT INTO `sys_user` VALUES (28, '2021027', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Eddie Griffin', '女', '10-1487-5341', 'eddiegri9@icloud.com', '', '2005-12-31 02:24:08', '2017-06-20 05:25:18');
INSERT INTO `sys_user` VALUES (29, '2021028', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Wei Jialun', '男', '212-172-5205', 'weijialu213@outlook.com', '', '2020-01-30 10:48:46', '2010-12-10 03:49:46');
INSERT INTO `sys_user` VALUES (30, '2021029', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Duan Shihan', '女', '7703 494472', 'dushih5@mail.com', '', '2008-08-09 17:44:57', '2015-04-28 19:05:56');
INSERT INTO `sys_user` VALUES (31, '2021030', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Qin Zitao', '女', '312-405-6471', 'zitao9@icloud.com', '', '2001-01-04 06:36:58', '2008-02-14 22:46:14');
INSERT INTO `sys_user` VALUES (32, '2021031', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Du Jialun', '男', '5991 098357', 'du90@gmail.com', '', '2020-09-12 00:39:43', '2022-11-04 15:20:34');
INSERT INTO `sys_user` VALUES (33, '2021032', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Ye Anqi', '女', '131-2808-3093', 'yeanq@gmail.com', '', '2001-02-08 09:43:36', '2008-07-19 07:26:10');
INSERT INTO `sys_user` VALUES (34, '2021033', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Hui Wai Man', '男', '(151) 776 2768', 'huiwaiman@icloud.com', '', '2001-03-21 20:25:04', '2010-12-16 02:43:40');
INSERT INTO `sys_user` VALUES (35, '2021034', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Zeng Yuning', '女', '90-6466-5605', 'yunzeng@mail.com', '', '2022-11-10 16:46:11', '2020-12-11 12:48:27');
INSERT INTO `sys_user` VALUES (36, '2021035', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Taniguchi Kaito', '女', '312-138-9685', 'taniguchi803@hotmail.com', '', '2018-05-23 02:18:15', '2002-02-26 17:16:32');
INSERT INTO `sys_user` VALUES (37, '2021036', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Wu Lan', '女', '755-767-4084', 'lanwu1216@icloud.com', '', '2004-06-18 00:42:12', '2017-03-05 13:02:22');
INSERT INTO `sys_user` VALUES (38, '2021037', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Douglas Jenkins', '男', '10-2880-6883', 'dojen1999@outlook.com', '', '2007-12-21 21:18:52', '2022-12-08 19:38:20');
INSERT INTO `sys_user` VALUES (39, '2021038', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Zhang Zhiyuan', '男', '74-559-5001', 'zhang55@icloud.com', '', '2011-10-13 04:45:17', '2019-05-22 00:30:20');
INSERT INTO `sys_user` VALUES (40, '2021039', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Lei Xiaoming', '女', '80-8415-6260', 'lexiaom1974@icloud.com', '', '2010-10-19 23:00:47', '2018-04-26 19:45:56');
INSERT INTO `sys_user` VALUES (41, '2021040', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Yamamoto Kaito', '女', '74-025-4036', 'yamamotoka706@outlook.com', '', '2010-11-02 17:57:30', '2012-07-31 20:22:56');
INSERT INTO `sys_user` VALUES (42, '2021041', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Chang Wai Han', '女', '(151) 225 0683', 'changwh@hotmail.com', '', '2016-03-13 10:39:54', '2012-12-22 14:00:19');
INSERT INTO `sys_user` VALUES (43, '2021042', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Zhu Zitao', '男', '70-6475-2194', 'zhuzitao@gmail.com', '', '2022-04-02 03:35:18', '2006-10-28 02:53:40');
INSERT INTO `sys_user` VALUES (44, '2021043', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Ando Itsuki', '女', '(116) 987 5893', 'itando41@mail.com', '', '2013-01-15 15:08:31', '2006-12-17 00:30:30');
INSERT INTO `sys_user` VALUES (45, '2021044', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Fukuda Aoi', '男', '179-2363-8246', 'fukao@gmail.com', '', '2004-04-21 07:20:16', '2018-12-29 15:10:43');
INSERT INTO `sys_user` VALUES (47, '2021046', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Cheng Jialun', '女', '(161) 446 9044', 'jialun1982@outlook.com', '', '2019-08-10 18:11:39', '2021-05-11 00:24:15');
INSERT INTO `sys_user` VALUES (48, '2021047', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Lei Xiuying', '女', '(161) 828 2684', 'xiuyinglei@icloud.com', '', '2001-05-29 20:22:32', '2020-02-27 22:46:57');
INSERT INTO `sys_user` VALUES (49, '2021048', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Xiong Jialun', '女', '66-345-1589', 'jialun80@gmail.com', '', '2010-05-08 10:31:56', '2021-10-02 15:41:01');
INSERT INTO `sys_user` VALUES (50, '2021049', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'He Zhennan', '男', '3-6127-5088', 'zhennanhe@mail.com', '', '2021-12-06 07:10:37', '2006-07-23 12:14:16');
INSERT INTO `sys_user` VALUES (52, '2021051', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Mui On Na', '女', '66-822-8715', 'muionna@gmail.com', '', '2015-11-28 09:05:44', '2009-09-02 19:37:08');
INSERT INTO `sys_user` VALUES (53, '2021052', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Li Shihan', '男', '3-8804-9935', 'lishihan@gmail.com', '', '2002-03-02 21:25:44', '2011-08-06 15:36:22');
INSERT INTO `sys_user` VALUES (55, '2021054', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Liao Tin Wing', '男', '212-552-4696', 'twliao@yahoo.com', '', '2005-07-30 23:37:15', '2008-02-07 03:04:24');
INSERT INTO `sys_user` VALUES (56, '2021055', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Zhou Zhennan', '女', '330-647-8146', 'zhennanzhou1209@gmail.com', '', '2019-10-26 02:25:06', '2009-10-06 18:37:40');
INSERT INTO `sys_user` VALUES (58, '2021057', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Joan Hall', '男', '769-0288-6638', 'joanhal@icloud.com', '', '2001-08-22 21:47:08', '2016-04-11 05:48:57');
INSERT INTO `sys_user` VALUES (59, '2021058', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Arthur Rivera', '男', '212-210-0197', 'rivarth214@mail.com', '', '2016-09-20 16:33:19', '2006-04-06 04:21:46');
INSERT INTO `sys_user` VALUES (60, '2021059', 'f10058774e9db3883ca78e45a2afb8cdf8ef55fa', 'aMh5Od2pxsP2Dfy129uZjA==', 'Miyazaki Mitsuki', '男', '21-0767-9470', 'mitsuki5@gmail.com', '', '2019-11-23 00:55:17', '2010-08-18 09:31:01');
INSERT INTO `sys_user` VALUES (69, '2022002', '7261b21c72cfea5e77cacd458c43b698e092b736', 'm6zikWxkD67p9hwt5AUJoQ==', 'resetform0222', '女', NULL, NULL, NULL, '2023-05-15 19:07:11', '2023-05-15 19:08:27');
INSERT INTO `sys_user` VALUES (71, '2022003', '7d28a26bc3b205d5c3f71f39eeccb29dbed4099d', 'brTbcCajiOdUPw/mppUFxg==', 'del1', '男', NULL, NULL, NULL, '2023-05-15 19:16:51', '2023-05-15 19:16:51');
INSERT INTO `sys_user` VALUES (72, '2022004', '7a86393669b57f6c8750383e50c330dd132e3a8b', 'yShnn0XHFr1XJWO/N7HllA==', 'del2', '男', NULL, NULL, NULL, '2023-05-15 19:17:53', '2023-05-15 19:17:53');
INSERT INTO `sys_user` VALUES (76, '2022000', '139e836f8584d8ea1995bb5eaec8a9c8c20f745f', 'TDcu4QVVK5V3TMzkC3Hqpw==', 'fsdfsd', '男', NULL, NULL, NULL, '2023-05-15 19:44:48', '2023-05-15 19:44:48');
INSERT INTO `sys_user` VALUES (77, '2022005', 'ef131c581bff5d18efda1bd4be08198b2c49ea31', '0mzg+545YkjhucXr/MKuZA==', 'hahahahaha', '男', '17780724139', 'kinoshitayun@gmail.com', NULL, '2023-05-15 19:45:22', '2023-05-16 20:21:58');
INSERT INTO `sys_user` VALUES (83, '2021099', '4b9e4f7859a46433afe740e72dbc041b1b93b4a6', 'll3mOJtrp9piWp3Aw/mRBg==', 't1', '男', NULL, NULL, NULL, '2023-05-16 13:19:12', '2023-05-16 13:19:12');
INSERT INTO `sys_user` VALUES (84, '2021100', '2c8a6a8f91ac2138fd0cc64a254407f154024a21', 'nKqPHotUUaKLSiMCl4TgJA==', 'leejack222', '男', '17780724139', '2932554779@qq.com', NULL, '2023-05-16 13:20:40', '2023-05-16 20:22:31');
INSERT INTO `sys_user` VALUES (90, '2022006', 'b14f819ab5cd0a0498db4219f3b6917c391d3eba', 'n+OuVBgPyG508arO0P2F/w==', '导出测试', '男', NULL, NULL, NULL, '2023-05-18 13:02:51', '2023-05-18 13:02:51');
INSERT INTO `sys_user` VALUES (97, '2023099', 'd2f83ebde9491cd2e5f60fac7cd680883e7e33d0', 'zAffNiabnkeeiMK18vuW0Q==', '测试', '男', NULL, NULL, NULL, '2023-05-21 17:17:42', '2023-05-21 17:17:42');
INSERT INTO `sys_user` VALUES (98, '2023001', 'b967d99400c042202a6567f5339c33de96d22d7e', 'VISVCsjv2D0sndzX1U49ow==', '添加测试', '男', NULL, NULL, NULL, '2023-05-21 17:22:08', '2023-05-21 17:22:08');
INSERT INTO `sys_user` VALUES (99, '2023002', 'f3b749be27c50b2b0cd6619dee397066ca755b46', 'QFTnG0BVpKFzcPUgh1rCSQ==', '添加测试', '女', NULL, NULL, NULL, '2023-05-21 17:22:08', '2023-05-21 17:22:08');
INSERT INTO `sys_user` VALUES (100, '2023003', '9779c3f0db7f53abb7df1dc4205df0189ab3df25', 'GapcdZFfd2rP9pElnYIpXA==', '添加测试', '女', NULL, NULL, NULL, '2023-05-21 17:22:08', '2023-05-21 17:22:08');
INSERT INTO `sys_user` VALUES (101, '2023004', 'a3dfb4eb2244f5c0a29294fd770095cb86aa186c', '1mOeI0G9Zam6dE/0dFjNHQ==', '添加测试', '男', NULL, NULL, NULL, '2023-05-21 17:22:08', '2023-05-21 17:22:08');
INSERT INTO `sys_user` VALUES (102, '2024001', 'ffe93cb30ec43e05f0d9146c291f5315069b0a54', '+v45S2osJGMTEMrj60ECsw==', '张三', '女', NULL, NULL, NULL, '2023-05-21 20:47:32', '2023-05-21 20:47:32');
INSERT INTO `sys_user` VALUES (103, '2021103', 'e9c110c52abf964ff82ca199c0b56c38f9200f1e', 'hPOvCrPbp7b9M7nOjOQJ1w==', '李四', '男', NULL, NULL, NULL, '2023-05-21 20:47:32', '2023-05-21 20:47:32');
INSERT INTO `sys_user` VALUES (104, '2023000', '260b8f26170e3ad4a302cb598d3841590e59027d', 'YRQPugzAeXKdmP0nHIMuCQ==', 'kaoqin1', '男', NULL, NULL, NULL, '2023-06-07 14:32:02', '2023-06-07 14:32:02');
INSERT INTO `sys_user` VALUES (109, '2025003', 'f4be081b41de62e8057c6c3c0d0e2f2fe6a701b9', 'PTNa1M4jqjvrq13xNeyluw==', '张三', '男', '13031322281', 'zs@qq.com', NULL, '2023-06-08 17:16:55', '2023-06-08 17:16:55');
INSERT INTO `sys_user` VALUES (110, '2025004', 'bf147af4546948431bb0b29b607181efb20ef504', 'fCiVG/C1nOTdvXSNEUxTEQ==', 'Cx', '女', NULL, NULL, NULL, '2023-06-08 17:16:55', '2023-06-08 17:16:55');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色的关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1, 2);
INSERT INTO `sys_user_role` VALUES (3, 2, 1);
INSERT INTO `sys_user_role` VALUES (4, 2, 3);
INSERT INTO `sys_user_role` VALUES (8, 48, 3);
INSERT INTO `sys_user_role` VALUES (9, 34, 2);
INSERT INTO `sys_user_role` VALUES (10, 20, 3);
INSERT INTO `sys_user_role` VALUES (11, 55, 3);
INSERT INTO `sys_user_role` VALUES (13, 35, 3);
INSERT INTO `sys_user_role` VALUES (14, 60, 3);
INSERT INTO `sys_user_role` VALUES (15, 39, 2);
INSERT INTO `sys_user_role` VALUES (17, 36, 2);
INSERT INTO `sys_user_role` VALUES (18, 15, 3);
INSERT INTO `sys_user_role` VALUES (19, 37, 2);
INSERT INTO `sys_user_role` VALUES (20, 40, 3);
INSERT INTO `sys_user_role` VALUES (21, 33, 2);
INSERT INTO `sys_user_role` VALUES (22, 58, 3);
INSERT INTO `sys_user_role` VALUES (23, 56, 3);
INSERT INTO `sys_user_role` VALUES (24, 5, 2);
INSERT INTO `sys_user_role` VALUES (26, 42, 3);
INSERT INTO `sys_user_role` VALUES (27, 9, 3);
INSERT INTO `sys_user_role` VALUES (28, 47, 3);
INSERT INTO `sys_user_role` VALUES (29, 6, 2);
INSERT INTO `sys_user_role` VALUES (30, 12, 2);
INSERT INTO `sys_user_role` VALUES (31, 10, 2);
INSERT INTO `sys_user_role` VALUES (32, 7, 2);
INSERT INTO `sys_user_role` VALUES (33, 53, 2);
INSERT INTO `sys_user_role` VALUES (34, 45, 3);
INSERT INTO `sys_user_role` VALUES (35, 26, 3);
INSERT INTO `sys_user_role` VALUES (36, 17, 3);
INSERT INTO `sys_user_role` VALUES (37, 11, 3);
INSERT INTO `sys_user_role` VALUES (38, 27, 2);
INSERT INTO `sys_user_role` VALUES (40, 23, 3);
INSERT INTO `sys_user_role` VALUES (41, 22, 2);
INSERT INTO `sys_user_role` VALUES (42, 16, 2);
INSERT INTO `sys_user_role` VALUES (43, 30, 2);
INSERT INTO `sys_user_role` VALUES (44, 24, 3);
INSERT INTO `sys_user_role` VALUES (45, 4, 3);
INSERT INTO `sys_user_role` VALUES (46, 8, 3);
INSERT INTO `sys_user_role` VALUES (47, 59, 2);
INSERT INTO `sys_user_role` VALUES (48, 32, 3);
INSERT INTO `sys_user_role` VALUES (49, 18, 2);
INSERT INTO `sys_user_role` VALUES (50, 50, 2);
INSERT INTO `sys_user_role` VALUES (51, 21, 2);
INSERT INTO `sys_user_role` VALUES (52, 41, 2);
INSERT INTO `sys_user_role` VALUES (53, 3, 2);
INSERT INTO `sys_user_role` VALUES (54, 38, 3);
INSERT INTO `sys_user_role` VALUES (55, 13, 2);
INSERT INTO `sys_user_role` VALUES (56, 14, 2);
INSERT INTO `sys_user_role` VALUES (57, 31, 3);
INSERT INTO `sys_user_role` VALUES (58, 29, 2);
INSERT INTO `sys_user_role` VALUES (59, 28, 2);
INSERT INTO `sys_user_role` VALUES (60, 49, 2);
INSERT INTO `sys_user_role` VALUES (62, 52, 2);
INSERT INTO `sys_user_role` VALUES (63, 43, 3);
INSERT INTO `sys_user_role` VALUES (64, 44, 3);
INSERT INTO `sys_user_role` VALUES (65, 19, 3);
INSERT INTO `sys_user_role` VALUES (66, 25, 3);
INSERT INTO `sys_user_role` VALUES (67, 3, 1);
INSERT INTO `sys_user_role` VALUES (68, 4, 1);
INSERT INTO `sys_user_role` VALUES (82, 69, 3);
INSERT INTO `sys_user_role` VALUES (85, 71, 3);
INSERT INTO `sys_user_role` VALUES (86, 72, 1);
INSERT INTO `sys_user_role` VALUES (87, 72, 3);
INSERT INTO `sys_user_role` VALUES (92, 76, 3);
INSERT INTO `sys_user_role` VALUES (93, 77, 3);
INSERT INTO `sys_user_role` VALUES (94, 83, 2);
INSERT INTO `sys_user_role` VALUES (96, 84, 2);
INSERT INTO `sys_user_role` VALUES (105, 77, 1);
INSERT INTO `sys_user_role` VALUES (106, 84, 1);
INSERT INTO `sys_user_role` VALUES (107, 90, 3);
INSERT INTO `sys_user_role` VALUES (114, 97, 3);
INSERT INTO `sys_user_role` VALUES (115, 98, 3);
INSERT INTO `sys_user_role` VALUES (116, 99, 3);
INSERT INTO `sys_user_role` VALUES (117, 100, 3);
INSERT INTO `sys_user_role` VALUES (118, 101, 3);
INSERT INTO `sys_user_role` VALUES (119, 102, 2);
INSERT INTO `sys_user_role` VALUES (120, 103, 2);
INSERT INTO `sys_user_role` VALUES (121, 1, 1);
INSERT INTO `sys_user_role` VALUES (122, 104, 3);
INSERT INTO `sys_user_role` VALUES (127, 109, 2);
INSERT INTO `sys_user_role` VALUES (128, 110, 2);

-- ----------------------------
-- Table structure for sys_user_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_student`;
CREATE TABLE `sys_user_student`  (
  `sid` bigint NOT NULL COMMENT '学号',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `major_id` bigint NOT NULL COMMENT '专业',
  `grade` int NOT NULL COMMENT '年级',
  `class_number` int NOT NULL COMMENT '班级',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_student
-- ----------------------------
INSERT INTO `sys_user_student` VALUES (2021000, '张鑫', 1, 2021, 3);
INSERT INTO `sys_user_student` VALUES (2021003, 'AokiTsubasa', 17, 2007, 4);
INSERT INTO `sys_user_student` VALUES (2021007, 'KinoshitaYuna', 1, 2007, 6);
INSERT INTO `sys_user_student` VALUES (2021008, 'Sun Ziyi', 14, 2006, 7);
INSERT INTO `sys_user_student` VALUES (2021010, 'Yu Jialun', 5, 2009, 5);
INSERT INTO `sys_user_student` VALUES (2021014, 'MaedaKazuma', 9, 2003, 4);
INSERT INTO `sys_user_student` VALUES (2021016, 'Morita Miu', 20, 2020, 7);
INSERT INTO `sys_user_student` VALUES (2021018, 'Kikuchi Tsubasa', 9, 2002, 1);
INSERT INTO `sys_user_student` VALUES (2021019, 'Sakurai Ikki', 4, 2007, 7);
INSERT INTO `sys_user_student` VALUES (2021022, 'Jeffrey Martinez', 22, 2001, 8);
INSERT INTO `sys_user_student` VALUES (2021023, 'David Stevens', 23, 2007, 1);
INSERT INTO `sys_user_student` VALUES (2021024, 'Rodney Ford', 11, 2007, 3);
INSERT INTO `sys_user_student` VALUES (2021025, 'Ding Jiehong', 19, 2020, 7);
INSERT INTO `sys_user_student` VALUES (2021030, 'Qin Zitao', 2, 2016, 3);
INSERT INTO `sys_user_student` VALUES (2021031, 'Du Jialun', 14, 2003, 6);
INSERT INTO `sys_user_student` VALUES (2021034, 'Zeng Yuning', 10, 2005, 5);
INSERT INTO `sys_user_student` VALUES (2021037, 'Douglas Jenkins', 24, 2004, 7);
INSERT INTO `sys_user_student` VALUES (2021039, 'Lei Xiaoming', 7, 2007, 2);
INSERT INTO `sys_user_student` VALUES (2021041, 'Chang Wai Han', 4, 2014, 3);
INSERT INTO `sys_user_student` VALUES (2021042, 'Zhu Zitao', 12, 2006, 3);
INSERT INTO `sys_user_student` VALUES (2021043, 'Ando Itsuki', 21, 2019, 7);
INSERT INTO `sys_user_student` VALUES (2021044, 'Fukuda Aoi', 17, 2021, 3);
INSERT INTO `sys_user_student` VALUES (2021046, 'Cheng Jialun', 16, 2017, 4);
INSERT INTO `sys_user_student` VALUES (2021047, 'Lei Xiuying', 22, 2008, 1);
INSERT INTO `sys_user_student` VALUES (2021054, 'Liao Tin Wing', 21, 2023, 4);
INSERT INTO `sys_user_student` VALUES (2021055, 'Zhou Zhennan', 9, 2022, 1);
INSERT INTO `sys_user_student` VALUES (2021057, 'Joan Hall', 10, 2008, 3);
INSERT INTO `sys_user_student` VALUES (2021059, 'Miyazaki Mitsuki', 13, 2007, 3);
INSERT INTO `sys_user_student` VALUES (2022000, 'fsdfsd', 8, 2014, 4);
INSERT INTO `sys_user_student` VALUES (2022002, 'resetform0222', 19, 1111, 8);
INSERT INTO `sys_user_student` VALUES (2022003, 'del1', 5, 2014, 4);
INSERT INTO `sys_user_student` VALUES (2022004, 'del2', 8, 2015, 4);
INSERT INTO `sys_user_student` VALUES (2022005, 'hahahahaha', 9, 2014, 4);
INSERT INTO `sys_user_student` VALUES (2022006, '导出测试', 8, 2015, 4);
INSERT INTO `sys_user_student` VALUES (2023000, 'kaoqin1', 1, 2021, 3);
INSERT INTO `sys_user_student` VALUES (2023001, '添加测试', 1, 2021, 1);
INSERT INTO `sys_user_student` VALUES (2023002, '添加测试', 1, 2221, 1);
INSERT INTO `sys_user_student` VALUES (2023003, '添加测试', 1, 2221, 1);
INSERT INTO `sys_user_student` VALUES (2023004, '添加测试', 1, 2221, 1);
INSERT INTO `sys_user_student` VALUES (2023099, '测试', 1, 2221, 1);

-- ----------------------------
-- Table structure for sys_user_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_teacher`;
CREATE TABLE `sys_user_teacher`  (
  `tid` bigint NOT NULL COMMENT '教师工号',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `college_id` bigint NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_teacher
-- ----------------------------
INSERT INTO `sys_user_teacher` VALUES (2021001, '张三', 6);
INSERT INTO `sys_user_teacher` VALUES (2021002, 'Cx330I', 7);
INSERT INTO `sys_user_teacher` VALUES (2021004, 'Tian Zitao', 7);
INSERT INTO `sys_user_teacher` VALUES (2021005, 'Ricky Green', 8);
INSERT INTO `sys_user_teacher` VALUES (2021006, 'Phyllis Snyder', 12);
INSERT INTO `sys_user_teacher` VALUES (2021009, 'Lu Zhennan', 11);
INSERT INTO `sys_user_teacher` VALUES (2021011, 'Qin Anqi', 9);
INSERT INTO `sys_user_teacher` VALUES (2021012, 'Koyama Hazuki', 6);
INSERT INTO `sys_user_teacher` VALUES (2021013, 'Mui Kwok Kuen', 5);
INSERT INTO `sys_user_teacher` VALUES (2021015, 'Lawrence Ferguson', 16);
INSERT INTO `sys_user_teacher` VALUES (2021017, 'Choi On Kay', 12);
INSERT INTO `sys_user_teacher` VALUES (2021020, 'Yao Zhennan', 9);
INSERT INTO `sys_user_teacher` VALUES (2021021, 'Inoue Rin', 15);
INSERT INTO `sys_user_teacher` VALUES (2021026, 'Eleanor Herrera', 4);
INSERT INTO `sys_user_teacher` VALUES (2021027, 'Eddie Griffin', 4);
INSERT INTO `sys_user_teacher` VALUES (2021028, 'Wei Jialun', 6);
INSERT INTO `sys_user_teacher` VALUES (2021029, 'Duan Shihan', 17);
INSERT INTO `sys_user_teacher` VALUES (2021032, 'Ye Anqi', 6);
INSERT INTO `sys_user_teacher` VALUES (2021033, 'Hui Wai Man', 2);
INSERT INTO `sys_user_teacher` VALUES (2021035, 'Taniguchi Kaito', 4);
INSERT INTO `sys_user_teacher` VALUES (2021036, 'Wu Lan', 5);
INSERT INTO `sys_user_teacher` VALUES (2021038, 'Zhang Zhiyuan', 3);
INSERT INTO `sys_user_teacher` VALUES (2021040, 'Yamamoto Kaito', 8);
INSERT INTO `sys_user_teacher` VALUES (2021048, 'Xiong Jialun', 2);
INSERT INTO `sys_user_teacher` VALUES (2021049, 'He Zhennan', 10);
INSERT INTO `sys_user_teacher` VALUES (2021051, 'Mui On Na', 4);
INSERT INTO `sys_user_teacher` VALUES (2021052, 'Li Shihan', 13);
INSERT INTO `sys_user_teacher` VALUES (2021058, 'Arthur Rivera', 17);
INSERT INTO `sys_user_teacher` VALUES (2021099, 't1', 5);
INSERT INTO `sys_user_teacher` VALUES (2021100, 'leejack222', 5);
INSERT INTO `sys_user_teacher` VALUES (2024001, '张三', 1);
INSERT INTO `sys_user_teacher` VALUES (2024002, '李四', 1);
INSERT INTO `sys_user_teacher` VALUES (2025001, '张鑫', 1);
INSERT INTO `sys_user_teacher` VALUES (2025002, 'AokiTsubasa', 6);
INSERT INTO `sys_user_teacher` VALUES (2025003, '张三', 6);
INSERT INTO `sys_user_teacher` VALUES (2025004, 'Cx', 7);

SET FOREIGN_KEY_CHECKS = 1;
