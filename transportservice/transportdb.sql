/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50161
Source Host           : localhost:3306
Source Database       : transportdb

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2015-11-09 16:36:02
*/
DROP DATABASE IF EXISTS `transportdb`;

CREATE DATABASE `transportdb`;

USE `transportdb`;

-- ----------------------------
-- Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `ID` tinyint(4) NOT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `PORT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', '192.168.1.102', '8890');

/*Table structure for table `app_applist` */

DROP TABLE IF EXISTS `app_applist`;

CREATE TABLE `app_applist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `downloadUrl` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `picUrl` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `packageName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `versionCode` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `app_car` */

DROP TABLE IF EXISTS `app_car`;

CREATE TABLE `app_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `carId` int(11) DEFAULT NULL,
  `carName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `app_park` */

DROP TABLE IF EXISTS `app_park`;

CREATE TABLE `app_park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `app_parktrade` */

DROP TABLE IF EXISTS `app_parktrade`;

CREATE TABLE `app_parktrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parkInTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parkOutTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `carId` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `app_user` */

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `regesitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `bs_info` */

DROP TABLE IF EXISTS `bs_info`;

CREATE TABLE `bs_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busStationId` int(4) DEFAULT NULL,
  `busId` int(4) DEFAULT NULL,
  `distance` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=339451 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `bus_capacity` */

DROP TABLE IF EXISTS `bus_capacity`;

CREATE TABLE `bus_capacity` (
  `id` int(11) NOT NULL,
  `busId` int(4) DEFAULT NULL,
  `busCapacity` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `bus_locationaction` */

DROP TABLE IF EXISTS `bus_locationaction`;

CREATE TABLE `bus_locationaction` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `busId` int(4) DEFAULT NULL,
  `busLocation` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `bus_speed` */

DROP TABLE IF EXISTS `bus_speed`;

CREATE TABLE `bus_speed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busId` int(4) DEFAULT NULL,
  `busSpeed` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_accountbalance` */

DROP TABLE IF EXISTS `car_accountbalance`;

CREATE TABLE `car_accountbalance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `balance` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=359008 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_accountrecharge` */

DROP TABLE IF EXISTS `car_accountrecharge`;

CREATE TABLE `car_accountrecharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_accountrecord` */

DROP TABLE IF EXISTS `car_accountrecord`;

CREATE TABLE `car_accountrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `costType` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `cost` int(4) DEFAULT NULL,
  `addr` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_location` */

DROP TABLE IF EXISTS `car_location`;

CREATE TABLE `car_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `carLocation` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=517367 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_movement` */

DROP TABLE IF EXISTS `car_movement`;

CREATE TABLE `car_movement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `carAction` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `car_speed` */

DROP TABLE IF EXISTS `car_speed`;

CREATE TABLE `car_speed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `carSpeed` double DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=647343 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `cyclictime` */

DROP TABLE IF EXISTS `cyclictime`;

CREATE TABLE `cyclictime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interfaceName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `loadTime` int(11) DEFAULT NULL,
  `processTime` int(11) DEFAULT NULL,
  `saveTime` int(11) DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18001 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `env_lightsensevalve` */

DROP TABLE IF EXISTS `env_lightsensevalve`;

CREATE TABLE `env_lightsensevalve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `down` int(4) DEFAULT NULL,
  `up` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `env_sensebyname` */

DROP TABLE IF EXISTS `env_sensebyname`;

CREATE TABLE `env_sensebyname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `senseName` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `value` double DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=1450842 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `env_setlightsensevalve` */

DROP TABLE IF EXISTS `env_setlightsensevalve`;

CREATE TABLE `env_setlightsensevalve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `down` int(4) DEFAULT NULL,
  `up` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `etc_listreport` */

DROP TABLE IF EXISTS `etc_listreport`;

CREATE TABLE `etc_listreport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `etcInTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `etcOutTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `etcOutTime` (`etcOutTime`)
) ENGINE=InnoDB AUTO_INCREMENT=91521 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `etc_rate` */

DROP TABLE IF EXISTS `etc_rate`;

CREATE TABLE `etc_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=201014 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `etc_setblacklist` */

DROP TABLE IF EXISTS `etc_setblacklist`;

CREATE TABLE `etc_setblacklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `etc_setrate` */

DROP TABLE IF EXISTS `etc_setrate`;

CREATE TABLE `etc_setrate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `park_parkfree` */

DROP TABLE IF EXISTS `park_parkfree`;

CREATE TABLE `park_parkfree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parkFreeId` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=2320887 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `park_parkinglistreport` */

DROP TABLE IF EXISTS `park_parkinglistreport`;

CREATE TABLE `park_parkinglistreport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `parkInTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parkOutTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `park_rate` */

DROP TABLE IF EXISTS `park_rate`;

CREATE TABLE `park_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `park_setblacklist` */

DROP TABLE IF EXISTS `park_setblacklist`;

CREATE TABLE `park_setblacklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carId` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `park_setrate` */

DROP TABLE IF EXISTS `park_setrate`;

CREATE TABLE `park_setrate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `money` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `rl_setcontrolmode` */

DROP TABLE IF EXISTS `rl_setcontrolmode`;

CREATE TABLE `rl_setcontrolmode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roadLightId` int(4) DEFAULT NULL,
  `controlMode` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `rl_setstatusaction` */

DROP TABLE IF EXISTS `rl_setstatusaction`;

CREATE TABLE `rl_setstatusaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roadLightId` int(4) DEFAULT NULL,
  `action` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `rl_status` */

DROP TABLE IF EXISTS `rl_status`;

CREATE TABLE `rl_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roadLightId` int(4) DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=707974 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `road_status` */

DROP TABLE IF EXISTS `road_status`;

CREATE TABLE `road_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roadId` int(4) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=3471361 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `sand_simulated` */

DROP TABLE IF EXISTS `sand_simulated`;

CREATE TABLE `sand_simulated` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `Car1Position_X` int(5) DEFAULT NULL,
  `Car1Position_Y` int(5) DEFAULT NULL,
  `Car1Record` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `Car1RecordTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Car1RecordPosion_X` int(5) DEFAULT NULL,
  `Car1RecordPosion_Y` int(5) DEFAULT NULL,
  `Car2Position_X` int(5) DEFAULT NULL,
  `Car2Position_Y` int(5) DEFAULT NULL,
  `Car2Record` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `Car2RecordTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Car2RecordPosion_X` int(5) DEFAULT NULL,
  `Car2RecordPosion_Y` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=80002 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `tl_configaction` */

DROP TABLE IF EXISTS `tl_configaction`;

CREATE TABLE `tl_configaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trafficLightId` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `redTime` int(4) DEFAULT NULL,
  `greenTime` int(4) DEFAULT NULL,
  `yellowTime` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `tl_nowstatus` */

DROP TABLE IF EXISTS `tl_nowstatus`;

CREATE TABLE `tl_nowstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trafficLightId` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `time` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB AUTO_INCREMENT=797282 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `tl_setconfig` */

DROP TABLE IF EXISTS `tl_setconfig`;

CREATE TABLE `tl_setconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trafficLightId` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `redTime` int(4) DEFAULT NULL,
  `greenTime` int(4) DEFAULT NULL,
  `yellowTime` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `tl_setnowstatus` */

DROP TABLE IF EXISTS `tl_setnowstatus`;

CREATE TABLE `tl_setnowstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trafficLightId` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `time` int(4) DEFAULT NULL,
  `result` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `EVT_TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `EVT_TIMESTAMP` (`EVT_TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

drop table if exists `userInfo`;
create table `userInfo` (
  `userName` varchar(20) primary key ,
  `userPassword` varchar(16) not null,
  `userPhone` varchar(11),
  `userAuthority` bit
)


