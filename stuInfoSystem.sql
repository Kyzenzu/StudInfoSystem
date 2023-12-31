-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: newInfoSystem
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allstudents`
--

DROP TABLE IF EXISTS `allstudents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allstudents` (
  `stu_id` varchar(20) DEFAULT NULL,
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allstudents`
--

LOCK TABLES `allstudents` WRITE;
/*!40000 ALTER TABLE `allstudents` DISABLE KEYS */;
INSERT INTO `allstudents` VALUES ('2022b11000'),('2022b11001'),('2022b11002'),('2022b11003'),('2022b11004'),('2022b11005'),('2022b11006'),('2022b11007'),('2022b11008'),('2022b11009'),('2022b11010'),('2022b11011'),('2022b11012'),('2022b11013'),('2022b11014'),('2022b11015'),('2022b11016'),('2022b11017'),('2022b11018'),('2022b11019'),('2022b11020'),('2022b11021'),('2022b11022'),('2022b11023'),('2022b11024'),('2022b11025'),('2022b11026'),('2022b11027'),('2022b11028'),('2022b11029'),('2022b11030'),('2022b11031'),('2022b11032'),('2022b11034'),('2022b11035'),('2022b11036'),('2022b11037'),('2022b11038'),('2022b11039'),('2022b11040'),('2022b11041'),('2022b11042'),('2022b11043'),('2022b11044'),('2022b11045'),('2022b11046'),('2022b11047'),('2022b11048'),('2022b11049'),('2022b11050'),('2022b11051'),('2022b11052'),('2022b11053'),('2022b11054'),('2022b11055'),('2022b11056'),('2022b11057'),('2022b11058'),('2022b11059'),('2022b11060'),('2022b11061'),('2022b11062'),('2022b11063'),('2022b11064'),('2022b11065'),('2022b11066'),('2022b11067'),('2022b11068'),('2022b11069'),('2022b11070'),('2022b11071'),('2022b11072'),('2022b11073'),('2022b11074'),('2022b11075'),('2022b11076'),('2022b11077'),('2022b11078'),('2022b11079'),('2022b11080'),('2022b11081'),('2022b11082'),('2022b11083'),('2022b11084'),('2022b11085'),('2022b11086'),('2022b11087'),('2022b11088'),('2022b11089'),('2022b11090'),('2022b11091'),('2022b11092'),('2022b11093'),('2022b11094'),('2022b11095'),('2022b11096'),('2022b11097'),('2022b11099'),('2022b11100'),('2022b11101'),('2022b11102'),('2022b11103'),('2022b11104'),('2022b11105'),('2022b11106'),('2022b11107'),('2022b11108'),('2022b11109'),('2022b11110'),('2022b11111'),('2022b11112'),('2022b11113'),('2022b11114'),('2022b11115'),('2022b11116'),('2022b11117'),('2022b11118'),('2022b11119'),('2022b64231'),('2022b65951');
/*!40000 ALTER TABLE `allstudents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class1`
--

DROP TABLE IF EXISTS `class1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class1` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `score` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class1`
--

LOCK TABLES `class1` WRITE;
/*!40000 ALTER TABLE `class1` DISABLE KEYS */;
INSERT INTO `class1` VALUES (1,'2022b11000','娼樻垚涓?,41),(2,'2022b11001','鍐啝鐜?,49),(3,'2022b11002','甯哥珛杈?,84),(4,'2022b11003','娈垫€濇芳',20),(5,'2022b11004','鏉ㄥ摬鍦?,66),(6,'2022b11005','钀ч珮闊?,80),(7,'2022b11006','姹熷悍瀹?,70),(8,'2022b11007','褰儴闇?,63),(9,'2022b11008','椹紭浼?,91),(10,'2022b11009','绉︽槀闆?,37),(11,'2022b11010','鐭冲拰鐣?,83),(12,'2022b11011','绉﹀槈绁?,46),(13,'2022b11012','涓佹櫁鏄?,15),(14,'2022b11013','閭卞瓙杞?,56),(15,'2022b11014','鏂瑰叴淇?,4),(16,'2022b11015','澶忔槦闃?,53),(17,'2022b11016','浠绘槉鐒?,58),(18,'2022b11017','椹畯娣?,32),(19,'2022b11018','鑻忎慨浼?,82),(20,'2022b11019','鏇瑰鑳?,95);
/*!40000 ALTER TABLE `class1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class2`
--

DROP TABLE IF EXISTS `class2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class2` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `score` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class2`
--

LOCK TABLES `class2` WRITE;
/*!40000 ALTER TABLE `class2` DISABLE KEYS */;
INSERT INTO `class2` VALUES (1,'2022b11020','閽熷拰鐠?,87),(2,'2022b11021','椹槦娉?,74),(3,'2022b11022','绉︽垚鑽?,77),(4,'2022b11023','瀛欑珛杞?,62),(5,'2022b11024','鏇规兜鑲?,23),(6,'2022b11025','绋嬪槈寰?,16),(7,'2022b11026','閭撳崕濂?,35),(8,'2022b11027','鍌呭叴鏂?,24),(9,'2022b11028','灏归珮鍘?,90),(10,'2022b11029','寮犳鑽?,10),(11,'2022b11030','寤栨鎬?,98),(12,'2022b11031','璋拰棰?,32),(13,'2022b11032','鍒樻槉鑻?,6),(15,'2022b11034','榛勪箰婀?,6),(16,'2022b11035','闊╂剰鑷?,18),(17,'2022b11036','璐烘壙蹇?,7),(18,'2022b11037','闊╅泤鎯?,97),(19,'2022b11038','鏉ㄦ枃鍏?,39),(20,'2022b11039','绋嬮槼鏇?,50),(21,'2022b65951','寮犱笁',56);
/*!40000 ALTER TABLE `class2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class3`
--

DROP TABLE IF EXISTS `class3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class3` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `score` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class3`
--

LOCK TABLES `class3` WRITE;
/*!40000 ALTER TABLE `class3` DISABLE KEYS */;
INSERT INTO `class3` VALUES (1,'2022b11040','璐惧崕姹?,86),(2,'2022b11041','宕斿痉鏇?,9),(3,'2022b11042','姹熷瓙榛?,41),(4,'2022b11043','閽熶赴缇?,31),(5,'2022b11044','钀ч槼鍢?,27),(6,'2022b11045','钖涗繆鏅?,47),(7,'2022b11046','璋鎬?,64),(8,'2022b11047','鑳′紵鎳?,35),(9,'2022b11048','浜庨珮杈?,89),(10,'2022b11049','閮戞垚鍛?,45),(11,'2022b11050','閲戝潥澹?,2),(12,'2022b11051','璋㈠厓鏄?,60),(13,'2022b11052','閮€氭紶',99),(14,'2022b11053','闃庤嫳閿?,47),(15,'2022b11054','璧甸槼鏂?,34),(16,'2022b11055','鍚存浘鐞?,5),(17,'2022b11056','绉﹂€镐粰',23),(18,'2022b11057','鍚撮珮宄?,72),(19,'2022b11058','姹箯姹?,64),(20,'2022b11059','閭垫壙蹇?,42),(21,'2022b11060','璐惧崕姹?,77),(22,'2022b11061','宕斿痉鏇?,32),(23,'2022b11062','姹熷瓙榛?,31),(24,'2022b11063','閽熶赴缇?,100),(25,'2022b11064','钀ч槼鍢?,68),(26,'2022b11065','钖涗繆鏅?,67),(27,'2022b11066','璋鎬?,14),(28,'2022b11067','鑳′紵鎳?,32),(29,'2022b11068','浜庨珮杈?,76),(30,'2022b11069','閮戞垚鍛?,81),(31,'2022b11070','閲戝潥澹?,1),(32,'2022b11071','璋㈠厓鏄?,31),(33,'2022b11072','閮€氭紶',46),(34,'2022b11073','闃庤嫳閿?,28),(35,'2022b11074','璧甸槼鏂?,30),(36,'2022b11075','鍚存浘鐞?,11),(37,'2022b11076','绉﹂€镐粰',36),(38,'2022b11077','鍚撮珮宄?,70),(39,'2022b11078','姹箯姹?,28),(40,'2022b11079','閭垫壙蹇?,93),(41,'2022b64231','鏉庡洓',60);
/*!40000 ALTER TABLE `class3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class4`
--

DROP TABLE IF EXISTS `class4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class4` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `score` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class4`
--

LOCK TABLES `class4` WRITE;
/*!40000 ALTER TABLE `class4` DISABLE KEYS */;
INSERT INTO `class4` VALUES (1,'2022b11080','钄″厓姝?,5),(2,'2022b11081','榫氬紭鐩?,100),(3,'2022b11082','钂嬫旦鎱?,83),(4,'2022b11083','鏇逛慨杩?,54),(5,'2022b11084','鐢板織鏄?,91),(6,'2022b11085','涔旇嫳鎮?,55),(7,'2022b11086','姹ゆ壙鎮?,92),(8,'2022b11087','鍙叉柊闇?,36),(9,'2022b11088','浜庡厓绾?,21),(10,'2022b11089','绉﹀紑闇?,89),(11,'2022b11090','浣曞畯纭?,6),(12,'2022b11091','鍙叉壙鏁?,73),(13,'2022b11092','閮戝叴鎬€',97),(14,'2022b11093','鏋楅珮閫?,35),(15,'2022b11094','宕斿嚡瀹?,65),(16,'2022b11095','浜庝紵鍏?,57),(17,'2022b11096','钄℃槑鏉?,65),(18,'2022b11097','閭瑰甯?,34),(20,'2022b11099','鍚村厜浜?,93);
/*!40000 ALTER TABLE `class4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class5`
--

DROP TABLE IF EXISTS `class5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class5` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `score` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class5`
--

LOCK TABLES `class5` WRITE;
/*!40000 ALTER TABLE `class5` DISABLE KEYS */;
INSERT INTO `class5` VALUES (1,'2022b11100','閭典繆鍋?,14),(2,'2022b11101','灏规櫙榫?,36),(3,'2022b11102','鏈变箰瀹?,65),(4,'2022b11103','钀ч槼鏅?,84),(5,'2022b11104','钂嬪痉娉?,39),(6,'2022b11105','鍙跺畯鏃?,67),(7,'2022b11106','鍒樺厜浜?,37),(8,'2022b11107','閽遍珮鍏?,23),(9,'2022b11108','閭归楦?,95),(10,'2022b11109','閮戠帀鍫?,52),(11,'2022b11110','鍞愬畨鎬?,1),(12,'2022b11111','浜庨槼杈?,39),(13,'2022b11112','姹柊闇?,33),(14,'2022b11113','澶忓瓙瀹?,52),(15,'2022b11114','閮濆崥娑?,15),(16,'2022b11115','璧栨案瀹?,74),(17,'2022b11116','瀹嬮珮宄?,64),(18,'2022b11117','濮滃悜鑽?,54),(19,'2022b11118','姣涙璞?,1),(20,'2022b11119','楂樼珛杞?,38);
/*!40000 ALTER TABLE `class5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `classes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'admin','admin','杞伐22-2,杞伐22-3'),(2,'root','root','杞伐22-1,杞伐22-3,杞伐22-5'),(3,'zqz','zqz','杞伐22-2,杞伐22-3'),(5,'ysw','ysw','杞伐22-1,杞伐22-3'),(6,'zj','zj','杞伐22-1,杞伐22-2,杞伐22-3'),(7,'x','x',''),(8,'y','y',''),(9,'123','123','杞伐22-2,杞伐22-4');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-17 22:55:39
