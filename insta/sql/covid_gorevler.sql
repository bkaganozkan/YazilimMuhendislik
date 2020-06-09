-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: covid
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gorevler`
--

DROP TABLE IF EXISTS `gorevler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gorevler` (
  `id` int NOT NULL AUTO_INCREMENT,
  `baslik` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gorevtext` mediumtext COLLATE utf8mb4_unicode_ci,
  `guser` int DEFAULT NULL,
  `gusername` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `guser` (`guser`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gorevler`
--

LOCK TABLES `gorevler` WRITE;
/*!40000 ALTER TABLE `gorevler` DISABLE KEYS */;
INSERT INTO `gorevler` VALUES (1,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL),(7,NULL,'Deneme',NULL,NULL),(8,NULL,'DenemeÃ¼',NULL,NULL),(18,NULL,'ü feenerrr üüüü\r\n',NULL,NULL),(19,NULL,'algoritma ödev yap\r\n',NULL,NULL),(20,NULL,'otomata ödev yap',NULL,NULL),(21,NULL,'Deneme 19',NULL,NULL),(22,NULL,'Deneme 20\r\n',NULL,NULL),(23,NULL,'Deneme 21',NULL,NULL),(24,NULL,'Deneme 21',NULL,NULL),(25,NULL,'Deneme 22\r\n',NULL,NULL),(26,NULL,'Deneme 23',NULL,NULL),(27,NULL,'Deneme 24\r\n',NULL,'emre'),(28,'','BadoSocial Web sitesi düzenle\r\n',NULL,'emre'),(29,'','Elektronik dersleri çalış',NULL,'onur'),(30,'','yarın 10 da kalk\r\n',NULL,'sibel'),(31,'','Onurun görevi\r\n',NULL,'onur'),(32,'','Onurun görevi 2',NULL,'onur'),(33,'','Dedem',NULL,'emre'),(34,'','futbolcu ol\r\n',NULL,'karahan'),(35,'Deneme123','Deneme2',NULL,'onur'),(36,'YazÄ±lÄ±m mÃ¼h','YazÄ±lÄ±m mÃ¼hendisligi\r\n',NULL,'onur'),(37,'sdfsf','\r\nsdfsf',NULL,'emre'),(38,'deneme','deneme\r\n\r\n',NULL,'emre'),(39,'deneme','deneme\r\n',NULL,'emre'),(40,'emredeneme','emredeneme\r\n\r\n',NULL,'emre'),(41,'editÃ¶Ã¶rrr','EditÃ¶rrr',NULL,'onur1'),(42,'Ãdev yap','Ödev yap',NULL,'emre'),(43,'Odevini yap onur','Ã¶devini yap',NULL,'onur1');
/*!40000 ALTER TABLE `gorevler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-09 17:01:37
