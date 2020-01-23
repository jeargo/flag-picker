-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: fpicker.caaaq9n1x2uc.us-east-1.rds.amazonaws.com    Database: fpicker
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED='';

--
-- Table structure for table `continent`
--

DROP TABLE IF EXISTS `continent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `continent` (
  `id_continent` int(11) NOT NULL,
  `continent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_continent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `continent`
--

LOCK TABLES `continent` WRITE;
/*!40000 ALTER TABLE `continent` DISABLE KEYS */;
INSERT INTO `continent` VALUES (1,'Africa'),(2,'America'),(3,'Asia'),(4,'Europe'),(5,'Oceania');
/*!40000 ALTER TABLE `continent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `count_continent`
--

DROP TABLE IF EXISTS `count_continent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `count_continent` (
  `id_continent` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_continent`),
  CONSTRAINT `FK_CONTINENT` FOREIGN KEY (`id_continent`) REFERENCES `continent` (`id_continent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `count_continent`
--

LOCK TABLES `count_continent` WRITE;
/*!40000 ALTER TABLE `count_continent` DISABLE KEYS */;
/*!40000 ALTER TABLE `count_continent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `count_country`
--

DROP TABLE IF EXISTS `count_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `count_country` (
  `id_country` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_country`),
  CONSTRAINT `FK_COUNTRY_ID` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `count_country`
--

LOCK TABLES `count_country` WRITE;
/*!40000 ALTER TABLE `count_country` DISABLE KEYS */;
/*!40000 ALTER TABLE `count_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id_country` int(11) NOT NULL,
  `country` varchar(45) DEFAULT NULL,
  `flag` varchar(3) DEFAULT NULL,
  `id_continent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_country`),
  KEY `FK_ID_CONTINENT_idx` (`id_continent`),
  CONSTRAINT `FK_ID_CONTINENT` FOREIGN KEY (`id_continent`) REFERENCES `continent` (`id_continent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Nigeria','NG',1),(2,'Ethiopia','ET',1),(3,'Egypt','EG',1),(4,'DR Congo','CD',1),(5,'South Africa','ZA',1),(6,'USA','US',2),(7,'Brazil','BR',2),(8,'Mexico','MX',2),(9,'Colombia','CO',2),(10,'Argentina','AR',2),(11,'China','CN',3),(12,'India','IN',3),(13,'Indonesia','ID',3),(14,'Pakistan','PK',3),(15,'Bangladesh','BD',3),(16,'Russia','RU',4),(17,'Germany','DE',4),(18,'UK','GB',4),(19,'France','FR',4),(20,'Italy','IT',4),(21,'Australia','AU',5),(22,'Papua New Guinea','PG',5),(23,'New Zealand','NZ',5),(24,'Fiji','FJ',5),(25,'Solomon Islands','SB',5);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fpicker'
--

--
-- Dumping routines for database 'fpicker'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-23  3:41:58
