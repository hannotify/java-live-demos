CREATE DATABASE  IF NOT EXISTS `pubs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `pubs`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: pubs
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `authors` (
                          `AU_ID` varchar(255) NOT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `AU_FNAME` varchar(255) DEFAULT NULL,
                          `AU_LNAME` varchar(255) DEFAULT NULL,
                          `city` varchar(255) DEFAULT NULL,
                          `contract` decimal(19,2) DEFAULT NULL,
                          `phone` varchar(16) DEFAULT NULL,
                          `state` varchar(2) DEFAULT NULL,
                          `zip` varchar(16) DEFAULT NULL,
                          PRIMARY KEY (`AU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES ('172-32-1176','10932 Bigge Rd.','Johnson','White','Menlo Park',1.00,'408 496-7223','CA','94025'),('213-46-8915','309 63rd St. #411','Marjorie','Green','Oakland',1.00,'415 986-7020','CA','94618'),('238-95-7766','589 Darwin Ln.','Cheryl','Carson','Berkeley',1.00,'415 548-7723','CA','94705'),('267-41-2394','22 Cleveland Av. #14','Michael','O\'Leary','San Jose',1.00,'408 286-2428','CA','95128'),('274-80-9391','5420 College Av.','Dean','Straight','Oakland',1.00,'415 834-2919','CA','94609'),('341-22-1782','10 Mississippi Dr.','Meander','Smith','Lawrence',0.00,'913 843-0462','KS','66044'),('409-56-7008','6223 Bateman St.','Abraham','Bennet','Berkeley',1.00,'415 658-9932','CA','94705'),('427-17-2319','3410 Blonde St.','Ann','Dull','Palo Alto',1.00,'415 836-7128','CA','94301'),('472-27-2349','PO Box 792','Burt','Gringlesby','Covelo',1.00,'707 938-6445','CA','95428'),('486-29-1786','18 Broadway Av.','Charlene','Locksley','San Francisco',1.00,'415 585-4620','CA','94130'),('527-72-3246','22 Graybar House Rd.','Morningstar','Greene','Nashville',0.00,'615 297-2723','TN','37215'),('648-92-1872','55 Hillsdale Bl.','Reginald','Blotchet-Halls','Corvallis',1.00,'503 745-6402','OR','97330'),('672-71-3249','3 Silver Ct.','Akiko','Yokomoto','Walnut Creek',1.00,'415 935-4228','CA','94595'),('712-45-1867','2286 Cram Pl. #86','Innes','del Castillo','Ann Arbor',1.00,'615 996-8275','MI','48105'),('722-51-5454','3 Balding Pl.','Michel','DeFrance','Gary',1.00,'219 547-9982','IN','46403'),('724-08-9931','5420 Telegraph Av.','Dirk','Stringer','Oakland',0.00,'415 843-2991','CA','94609'),('724-80-9391','44 Upland Hts.','Stearns','MacFeather','Oakland',1.00,'415 354-7128','CA','94612'),('756-30-7391','5720 McAuley St.','Livia','Karsen','Oakland',1.00,'415 534-9219','CA','94609'),('807-91-6654','1956 Arlington Pl.','Sylvia','Panteley','Rockville',1.00,'301 946-8853','MD','20853'),('846-92-7186','3410 Blonde St.','Sheryl','Hunter','Palo Alto',1.00,'415 836-7128','CA','94301'),('893-72-1158','301 Putnam','Heather','McBadden','Vacaville',0.00,'707 448-4982','CA','95688'),('899-46-2035','67 Seventh Av.','Anne','Ringer','Salt Lake City',1.00,'801 826-0752','UT','84152'),('998-72-3567','67 Seventh Av.','Albert','Ringer','Salt Lake City',1.00,'801 826-0752','UT','84152');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `discounts` (
                            `DISCOUNT_ID` bigint(20) NOT NULL,
                            `discount` decimal(19,2) DEFAULT NULL,
                            `discounttype` varchar(40) DEFAULT NULL,
                            `highqty` decimal(19,2) DEFAULT NULL,
                            `lowqty` decimal(19,2) DEFAULT NULL,
                            `STOR_ID` varchar(4) DEFAULT NULL,
                            PRIMARY KEY (`DISCOUNT_ID`),
                            KEY `FK1422D961EECFC56` (`STOR_ID`),
                            CONSTRAINT `fk_discount_store` FOREIGN KEY (`STOR_ID`) REFERENCES `stores` (`STOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` VALUES (1,10.50,'Initial Customer',NULL,NULL,NULL),(2,6.70,'Volume Discount',1000.00,100.00,NULL),(3,5.00,'Customer Discount',NULL,NULL,'8042');
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `employees` (
                            `EMP_ID` varchar(9) NOT NULL,
                            `fname` varchar(255) DEFAULT NULL,
                            `HIRE_DATE` date DEFAULT NULL,
                            `JOB_LVL` decimal(19,2) DEFAULT NULL,
                            `lname` varchar(255) DEFAULT NULL,
                            `minit` varchar(1) DEFAULT NULL,
                            `JOB_ID` bigint(20) DEFAULT NULL,
                            `PUB_ID` varchar(4) DEFAULT NULL,
                            PRIMARY KEY (`EMP_ID`),
                            KEY `FK4AFD4ACEDA08B458` (`PUB_ID`),
                            KEY `FK4AFD4ACEDE24899` (`JOB_ID`),
                            CONSTRAINT `fk_employee_job` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`JOB_ID`),
                            CONSTRAINT `fk_employee_publisher` FOREIGN KEY (`PUB_ID`) REFERENCES `publishers` (`PUB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('A-C71970F','Aria','2091-10-26',87.00,'Cruz',NULL,10,'1389'),('A-R89858F','Annette','2090-02-21',152.00,'Roulet',NULL,6,'9999'),('AMD15433F','Ann','2091-07-16',200.00,'Devon','M',3,'9952'),('ARD36773F','Anabela','2093-01-27',100.00,'Domingues','R',8,'0877'),('CFH28514M','Carlos','2089-04-21',211.00,'Hernadez','F',5,'9999'),('CGS88322F','Carine','2092-07-07',64.00,'Schmitt','G',13,'1389'),('DBT39435M','Daniel','2090-01-01',75.00,'Tonini','B',11,'0877'),('DWR65030M','Diego','2091-12-16',192.00,'Roel','W',6,'1389'),('ENL44273F','Elizabeth','2090-07-24',35.00,'Lincoln','N',14,'0877'),('F-C16315M','Francisco','2090-11-03',227.00,'Chang',NULL,4,'9952'),('GHT50241M','Gary','2088-08-09',170.00,'Thomas','H',9,'0736'),('H-B39728F','Helen','2089-09-21',35.00,'Bennett',NULL,12,'0877'),('HAN90777M','Helvetius','2093-03-19',120.00,'Nagy','A',7,'9999'),('HAS54740M','Howard','2088-11-19',100.00,'Snyder','A',12,'0736'),('JYL26161F','Janine','2091-05-26',172.00,'Labrune','Y',5,'9901'),('KFJ64308F','Karin','2092-10-17',100.00,'Josephs','F',14,'0736'),('KJJ92907F','Karla','2094-03-11',170.00,'Jablonski','J',9,'9999'),('L-B31947F','Lesley','2091-02-13',120.00,'Brown',NULL,7,'0877'),('LAL21447M','Laurence','2090-06-03',175.00,'Lebihan','A',5,'0736'),('M-L67958F','Maria','2092-03-27',135.00,'Larsson',NULL,7,'1389'),('M-P91209M','Manuel','2089-01-09',101.00,'Pereira',NULL,8,'9999'),('M-R38834F','Martine','2092-02-05',75.00,'Rance',NULL,9,'0877'),('MAP77183M','Miguel','2092-12-07',112.00,'Paolino','A',11,'1389'),('MAS70474F','Margaret','2088-09-29',78.00,'Smith','A',9,'1389'),('MFS52347M','Martin','2090-04-13',165.00,'Sommer','F',10,'0736'),('MGK44605M','Matti','2094-05-01',220.00,'Karttunen','G',6,'0736'),('MJP25939M','Maria','2089-03-01',246.00,'Pontes','J',5,'1756'),('MMS49649F','Mary','2093-06-29',175.00,'Saveley','M',8,'0736'),('PCM98509F','Patricia','2089-08-01',150.00,'McKenna','C',11,'9999'),('PDI47470M','Palle','2093-05-09',195.00,'Ibsen','D',7,'0736'),('PHF38899M','Peter','2092-05-17',75.00,'Franken','H',10,'0877'),('PMA42628M','Paolo','2092-08-27',35.00,'Accorti','M',13,'0877'),('POK93028M','Pirkko','2093-11-29',80.00,'Koskitalo','O',10,'9999'),('PSA89086M','Pedro','2090-12-24',89.00,'Afonso','S',14,'1389'),('PSP68661F','Paula','2094-01-19',125.00,'Parente','S',8,'1389'),('PTC11962M','Philip','2089-11-11',215.00,'Cramer','T',2,'9952'),('PXH22250M','Paul','2093-08-19',159.00,'Henriot','X',5,'0877'),('R-M53550M','Roland','2091-09-05',150.00,'Mendel',NULL,11,'0736'),('RBM23061F','Rita','2093-10-09',198.00,'Muller','B',5,'1622'),('SKO22412M','Sven','2091-04-05',150.00,'Ottlieb','K',5,'1389'),('TPO55093M','Timothy','2088-06-19',100.00,'O\'Rourke','P',13,'0736'),('VPA30890F','Victoria','2090-09-13',140.00,'Ashworth','P',6,'0877'),('Y-L77953M','Yoshi','2089-06-11',32.00,'Latimer',NULL,12,'1389');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `jobs` (
                       `JOB_ID` bigint(20) NOT NULL,
                       `JOB_DESC` varchar(255) DEFAULT NULL,
                       `MAX_LVL` decimal(19,2) DEFAULT NULL,
                       `MIN_LVL` decimal(19,2) DEFAULT NULL,
                       PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'New Hire - Job not specified',10.00,10.00),(2,'Chief Executive Officer',250.00,200.00),(3,'Business Operations Manager',225.00,175.00),(4,'Chief Financial Officier',250.00,175.00),(5,'Publisher',250.00,150.00),(6,'Managing Editor',225.00,140.00),(7,'Marketing Manager',200.00,120.00),(8,'Public Relations Manager',175.00,100.00),(9,'Acquisitions Manager',175.00,75.00),(10,'Productions Manager',165.00,75.00),(11,'Operations Manager',150.00,75.00),(12,'Editor',100.00,25.00),(13,'Sales Representative',100.00,25.00),(14,'Designer',100.00,25.00);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pub_info`
--

DROP TABLE IF EXISTS `pub_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `pub_info` (
                            `PUB_ID` varchar(4) NOT NULL,
                            `logo` longblob,
                            `PR_INFO` longtext,
                            PRIMARY KEY (`PUB_ID`),
                            CONSTRAINT `fk_pubsinfo_publisher` FOREIGN KEY (`PUB_ID`) REFERENCES `publishers` (`PUB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pub_info`
--

LOCK TABLES `pub_info` WRITE;
/*!40000 ALTER TABLE `pub_info` DISABLE KEYS */;
INSERT INTO `pub_info` VALUES ('0736',NULL,'None yet'),('0877',NULL,'None yet'),('1389',NULL,'None yet'),('1622',NULL,'None yet'),('1756',NULL,'None yet'),('9901',NULL,'None yet'),('9952',NULL,'None yet'),('9999',NULL,'None yet');
/*!40000 ALTER TABLE `pub_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `publishers` (
                             `PUB_ID` varchar(4) NOT NULL,
                             `city` varchar(255) DEFAULT NULL,
                             `country` varchar(255) DEFAULT NULL,
                             `PUB_NAME` varchar(255) DEFAULT NULL,
                             `state` varchar(2) DEFAULT NULL,
                             PRIMARY KEY (`PUB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES ('0736','Boston','USA','New Moon Books','MA'),('0877','Washington','USA','Binnet & Hardley','DC'),('1389','Berkeley','USA','Algodata Infosystems','CA'),('1622','Chicago','USA','Five Lakes Publishing','IL'),('1756','Dallas','USA','Ramona Publishers','TX'),('9901','München','Germany','GGG&G',NULL),('9952','New York','USA','Scootney Books','NY'),('9999','Paris','France','Lucerne Publishing',NULL);
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roysched`
--

DROP TABLE IF EXISTS `roysched`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `roysched` (
                            `ROY_ID` bigint(20) NOT NULL,
                            `hirange` decimal(19,2) DEFAULT NULL,
                            `lorange` decimal(19,2) DEFAULT NULL,
                            `royalty` decimal(19,2) DEFAULT NULL,
                            `TITLE_ID` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`ROY_ID`),
                            KEY `FKAF1967BFCFFAF9` (`TITLE_ID`),
                            CONSTRAINT `fk_roysched_title` FOREIGN KEY (`TITLE_ID`) REFERENCES `titles` (`TITLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roysched`
--

LOCK TABLES `roysched` WRITE;
/*!40000 ALTER TABLE `roysched` DISABLE KEYS */;
INSERT INTO `roysched` VALUES (1,5000.00,0.00,10.00,'BU1032'),(2,50000.00,5001.00,12.00,'BU1032'),(3,2000.00,0.00,10.00,'PC1035'),(4,3000.00,2001.00,12.00,'PC1035'),(5,4000.00,3001.00,14.00,'PC1035'),(6,10000.00,4001.00,16.00,'PC1035'),(7,50000.00,10001.00,18.00,'PC1035'),(8,1000.00,0.00,10.00,'BU2075'),(9,3000.00,1001.00,12.00,'BU2075'),(10,5000.00,3001.00,14.00,'BU2075'),(11,7000.00,5001.00,16.00,'BU2075'),(12,10000.00,7001.00,18.00,'BU2075'),(13,12000.00,10001.00,20.00,'BU2075'),(14,14000.00,12001.00,22.00,'BU2075'),(15,50000.00,14001.00,24.00,'BU2075'),(16,1000.00,0.00,10.00,'PS2091'),(17,5000.00,1001.00,12.00,'PS2091'),(18,10000.00,5001.00,14.00,'PS2091'),(19,50000.00,10001.00,16.00,'PS2091'),(20,2000.00,0.00,10.00,'PS2106'),(21,5000.00,2001.00,12.00,'PS2106'),(22,10000.00,5001.00,14.00,'PS2106'),(23,50000.00,10001.00,16.00,'PS2106'),(24,1000.00,0.00,10.00,'MC3021'),(25,2000.00,1001.00,12.00,'MC3021'),(26,4000.00,2001.00,14.00,'MC3021'),(27,6000.00,4001.00,16.00,'MC3021'),(28,8000.00,6001.00,18.00,'MC3021'),(29,10000.00,8001.00,20.00,'MC3021'),(30,12000.00,10001.00,22.00,'MC3021'),(31,50000.00,12001.00,24.00,'MC3021'),(32,2000.00,0.00,10.00,'TC3218'),(33,4000.00,2001.00,12.00,'TC3218'),(34,6000.00,4001.00,14.00,'TC3218'),(35,8000.00,6001.00,16.00,'TC3218'),(36,10000.00,8001.00,18.00,'TC3218'),(37,12000.00,10001.00,20.00,'TC3218'),(38,14000.00,12001.00,22.00,'TC3218'),(39,50000.00,14001.00,24.00,'TC3218'),(40,5000.00,0.00,10.00,'PC8888'),(41,10000.00,5001.00,12.00,'PC8888'),(42,15000.00,10001.00,14.00,'PC8888'),(43,50000.00,15001.00,16.00,'PC8888'),(44,5000.00,0.00,10.00,'PS7777'),(45,50000.00,5001.00,12.00,'PS7777'),(46,5000.00,0.00,10.00,'PS3333'),(47,10000.00,5001.00,12.00,'PS3333'),(48,15000.00,10001.00,14.00,'PS3333'),(49,50000.00,15001.00,16.00,'PS3333'),(50,4000.00,0.00,10.00,'BU1111'),(51,8000.00,4001.00,12.00,'BU1111'),(52,10000.00,8001.00,14.00,'BU1111'),(53,16000.00,12001.00,16.00,'BU1111'),(54,20000.00,16001.00,18.00,'BU1111'),(55,24000.00,20001.00,20.00,'BU1111'),(56,28000.00,24001.00,22.00,'BU1111'),(57,50000.00,28001.00,24.00,'BU1111'),(58,2000.00,0.00,10.00,'MC2222'),(59,4000.00,2001.00,12.00,'MC2222'),(60,8000.00,4001.00,14.00,'MC2222'),(61,12000.00,8001.00,16.00,'MC2222'),(62,20000.00,12001.00,18.00,'MC2222'),(63,50000.00,20001.00,20.00,'MC2222'),(64,5000.00,0.00,10.00,'TC7777'),(65,15000.00,5001.00,12.00,'TC7777'),(66,50000.00,15001.00,14.00,'TC7777'),(67,2000.00,0.00,10.00,'TC4203'),(68,8000.00,2001.00,12.00,'TC4203'),(69,16000.00,8001.00,14.00,'TC4203'),(70,24000.00,16001.00,16.00,'TC4203'),(71,32000.00,24001.00,18.00,'TC4203'),(72,40000.00,32001.00,20.00,'TC4203'),(73,50000.00,40001.00,22.00,'TC4203'),(74,5000.00,0.00,10.00,'BU7832'),(75,10000.00,5001.00,12.00,'BU7832'),(76,15000.00,10001.00,14.00,'BU7832'),(77,20000.00,15001.00,16.00,'BU7832'),(78,25000.00,20001.00,18.00,'BU7832'),(79,30000.00,25001.00,20.00,'BU7832'),(80,35000.00,30001.00,22.00,'BU7832'),(81,50000.00,35001.00,24.00,'BU7832'),(82,10000.00,0.00,10.00,'PS1372'),(83,20000.00,10001.00,12.00,'PS1372'),(84,30000.00,20001.00,14.00,'PS1372'),(85,40000.00,30001.00,16.00,'PS1372'),(86,50000.00,40001.00,18.00,'PS1372');
/*!40000 ALTER TABLE `roysched` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `sales` (
                        `ORD_NUM` varchar(255) NOT NULL,
                        `STOR_ID` varchar(4) NOT NULL,
                        `TITLE_ID` varchar(255) NOT NULL,
                        `ORD_DATE` date DEFAULT NULL,
                        `payterms` varchar(255) DEFAULT NULL,
                        `qty` decimal(19,2) DEFAULT NULL,
                        PRIMARY KEY (`ORD_NUM`,`STOR_ID`,`TITLE_ID`),
                        KEY `FK273467EECFC56` (`STOR_ID`),
                        KEY `FK273467FCFFAF9` (`TITLE_ID`),
                        CONSTRAINT `fk_sale_store` FOREIGN KEY (`STOR_ID`) REFERENCES `stores` (`STOR_ID`),
                        CONSTRAINT `fk_sale_title` FOREIGN KEY (`TITLE_ID`) REFERENCES `titles` (`TITLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES ('423LL922','8042','MC3021','2094-09-14','ON invoice',15.00),('423LL930','8042','BU1032','2094-09-14','ON invoice',10.00),('6871','6380','BU1032','2094-09-14','Net 60',5.00),('722a','6380','PS2091','2094-09-13','Net 60',3.00),('A2976','7066','PC8888','2093-05-24','Net 30',50.00),('D4482','7067','PS2091','2094-09-14','Net 60',10.00),('N914008','7131','PS2091','2094-09-14','Net 30',20.00),('N914014','7131','MC3021','2094-09-14','Net 30',25.00),('P2121','7067','TC3218','2092-06-15','Net 30',40.00),('P2121','7067','TC4203','2092-06-15','Net 30',20.00),('P2121','7067','TC7777','2092-06-15','Net 30',20.00),('P3087a','7131','PS1372','2093-05-29','Net 60',20.00),('P3087a','7131','PS2106','2093-05-29','Net 60',25.00),('P3087a','7131','PS3333','2093-05-29','Net 60',15.00),('P3087a','7131','PS7777','2093-05-29','Net 60',25.00),('P723','8042','BU1111','2093-03-11','Net 30',25.00),('QA7442.3','7066','PS2091','2094-09-13','ON invoice',75.00),('QA879.1','8042','PC1035','2093-05-22','Net 30',30.00),('QQ2299','7896','BU7832','2093-10-28','Net 60',15.00),('TQ456','7896','MC2222','2093-12-12','Net 60',10.00),('X999','7896','BU2075','2093-02-21','ON invoice',35.00);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `stores` (
                         `STOR_ID` varchar(4) NOT NULL,
                         `city` varchar(255) DEFAULT NULL,
                         `state` varchar(2) DEFAULT NULL,
                         `STOR_ADDRESS` varchar(255) DEFAULT NULL,
                         `STOR_NAME` varchar(255) DEFAULT NULL,
                         `zip` varchar(5) DEFAULT NULL,
                         PRIMARY KEY (`STOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores`
--

LOCK TABLES `stores` WRITE;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
INSERT INTO `stores` VALUES ('6380','Seattle','WA','788 Catamaugus Ave.','Eric the Read Books','98056'),('7066','Tustin','CA','567 Pasadena Ave.','Barnum\'s','92789'),('7067','Los Gatos','CA','577 First St.','News & Brews','96745'),('7131','Remulade','WA','24-A Avogadro Way','Doc-U-Mat: Quality Laundry and Books','98014'),('7896','Fremont','CA','89 Madison St.','Fricative Bookshop','90019'),('8042','Portland','OR','679 Carson St.','Bookbeat','89076');
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titles`
--

DROP TABLE IF EXISTS `titles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `titles` (
                         `TITLE_ID` varchar(255) NOT NULL,
                         `advance` decimal(19,2) DEFAULT NULL,
                         `notes` varchar(255) DEFAULT NULL,
                         `price` decimal(19,2) DEFAULT NULL,
                         `pubdate` date DEFAULT NULL,
                         `royalty` decimal(19,2) DEFAULT NULL,
                         `title` varchar(255) DEFAULT NULL,
                         `type` varchar(12) DEFAULT NULL,
                         `YTD_SALE` decimal(19,2) DEFAULT NULL,
                         `PUB_ID` varchar(4) DEFAULT NULL,
                         PRIMARY KEY (`TITLE_ID`),
                         KEY `FK4D13238DA08B458` (`PUB_ID`),
                         CONSTRAINT `fk_title_publisher` FOREIGN KEY (`PUB_ID`) REFERENCES `publishers` (`PUB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titles`
--

LOCK TABLES `titles` WRITE;
/*!40000 ALTER TABLE `titles` DISABLE KEYS */;
INSERT INTO `titles` VALUES ('BU1032',5000.00,'An overview of available database systems with emphasis on common business applications. Illustrated.',19.99,'2091-06-12',10.00,'The Busy Executive\'s Database Guide','business',4095.00,'1389'),('BU1111',5000.00,'Helpful hints on how to use your electronic resources to the best advantage.',11.95,'2091-06-09',10.00,'Cooking with Computers: Surreptitious Balance Sheets','business',3876.00,'1389'),('BU2075',10125.00,'The latest medical and psychological techniques for living with the electronic office. Easy-to-understand explanations.',2.99,'2091-06-30',24.00,'You Can Combat Computer Stress!','business',18722.00,'0736'),('BU7832',5000.00,'Annotated analysis of what computers can do for you: a no-hype guide for the critical user.',19.99,'2091-06-22',10.00,'Straight Talk About Computers','business',4095.00,'1389'),('MC2222',0.00,'Favorite recipes for quick, easy, and elegant meals.',19.99,'2091-06-09',12.00,'Silicon Valley Gastronomic Treats','mod_cook',2032.00,'0877'),('MC3021',15000.00,'Traditional French gourmet recipes adapted for modern microwave cooking.',2.99,'2091-06-18',24.00,'The Gourmet Microwave','mod_cook',22246.00,'0877'),('MC3026',NULL,NULL,NULL,'2011-01-10',NULL,'The Psychology of Computer Cooking','UNDECIDED',NULL,'0877'),('PC1035',7000.00,'A survey of software for the naive user, focusing on the \'friendliness\' of each.',22.95,'2091-06-30',16.00,'But Is It User Friendly?','popular_comp',8780.00,'1389'),('PC8888',8000.00,'Muckraking reporting on the world\'s largest computer hardware and software manufacturers.',20.00,'2094-06-12',10.00,'Secrets of Silicon Valley','popular_comp',4095.00,'1389'),('PC9999',NULL,'A must-read for computer conferencing.',NULL,'2011-01-10',NULL,'Net Etiquette','popular_comp',NULL,'1389'),('PS1372',7000.00,'A must for the specialist, this book examines the difference between those who hate and fear computers and those who don\'t.',21.59,'2091-10-21',10.00,'Computer Phobic AND Non-Phobic Individuals: Behavior Variations','psychology',375.00,'0877'),('PS2091',2275.00,'Carefully researched study of the effects of strong emotions on the body. Metabolic charts included.',10.95,'2091-06-15',12.00,'Is Anger the Enemy?','psychology',2045.00,'0736'),('PS2106',6000.00,'New exercise, meditation, and nutritional techniques that can reduce the shock of daily interactions. Popular audience. Sample menus included, exercise video available separately.',7.00,'2091-10-05',10.00,'Life Without Fear','psychology',111.00,'0736'),('PS3333',2000.00,'What happens when the data runs dry?  Searching evaluations of information-shortage effects.',19.99,'2091-06-12',10.00,'Prolonged Data Deprivation: Four Case Studies','psychology',4072.00,'0736'),('PS7777',4000.00,'Protecting yourself and your loved ones from undue emotional stress in the modern world. Use of computer and nutritional aids emphasized.',7.99,'2091-06-12',10.00,'Emotional Security: A New Algorithm','psychology',3336.00,'0736'),('TC3218',7000.00,'Profusely illustrated in color, this makes a wonderful gift book for a cuisine-oriented friend.',20.95,'2091-10-21',10.00,'Onions, Leeks, and Garlic: Cooking Secrets of the Mediterranean','trad_cook',375.00,'0877'),('TC4203',4000.00,'More anecdotes from the Queen\'s favorite cook describing life among English royalty. Recipes, techniques, tender vignettes.',11.95,'2091-06-12',14.00,'Fifty Years in Buckingham Palace Kitchens','trad_cook',15096.00,'0877'),('TC7777',8000.00,'Detailed instructions on how to make authentic Japanese sushi in your spare time.',14.99,'2091-06-12',10.00,'Sushi, Anyone?','trad_cook',4095.00,'0877');
/*!40000 ALTER TABLE `titles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titleauthor`
--

DROP TABLE IF EXISTS `titleauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `titleauthor` (
                               `AU_ID` varchar(255) NOT NULL,
                               `TITLE_ID` varchar(255) NOT NULL,
                               `AU_ORD` decimal(19,2) DEFAULT NULL,
                               `royaltyper` decimal(19,2) DEFAULT NULL,
                               PRIMARY KEY (`AU_ID`,`TITLE_ID`),
                               KEY `FK9A2DC9C3FCFFAF9` (`TITLE_ID`),
                               KEY `FK9A2DC9C34F41EA32` (`AU_ID`),
                               CONSTRAINT `fk_ta_author` FOREIGN KEY (`AU_ID`) REFERENCES `authors` (`AU_ID`),
                               CONSTRAINT `fk_ta_title` FOREIGN KEY (`TITLE_ID`) REFERENCES `titles` (`TITLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titleauthor`
--

LOCK TABLES `titleauthor` WRITE;
/*!40000 ALTER TABLE `titleauthor` DISABLE KEYS */;
INSERT INTO `titleauthor` VALUES ('172-32-1176','PS3333',1.00,100.00),('213-46-8915','BU1032',2.00,40.00),('213-46-8915','BU2075',1.00,100.00),('238-95-7766','PC1035',1.00,100.00),('267-41-2394','BU1111',2.00,40.00),('267-41-2394','TC7777',2.00,30.00),('274-80-9391','BU7832',1.00,100.00),('409-56-7008','BU1032',1.00,60.00),('427-17-2319','PC8888',1.00,50.00),('472-27-2349','TC7777',3.00,30.00),('486-29-1786','PC9999',1.00,100.00),('486-29-1786','PS7777',1.00,100.00),('648-92-1872','TC4203',1.00,100.00),('672-71-3249','TC7777',1.00,40.00),('712-45-1867','MC2222',1.00,100.00),('722-51-5454','MC3021',1.00,75.00),('724-80-9391','BU1111',1.00,60.00),('724-80-9391','PS1372',2.00,25.00),('756-30-7391','PS1372',1.00,75.00),('807-91-6654','TC3218',1.00,100.00),('846-92-7186','PC8888',2.00,50.00),('899-46-2035','MC3021',2.00,25.00),('899-46-2035','PS2091',2.00,50.00),('998-72-3567','PS2091',1.00,50.00),('998-72-3567','PS2106',1.00,100.00);
/*!40000 ALTER TABLE `titleauthor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-15 12:12:55
