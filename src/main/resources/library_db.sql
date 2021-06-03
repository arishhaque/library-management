-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: library_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `is_available` varchar(45) NOT NULL DEFAULT 'true',
  `genre` varchar(45) NOT NULL DEFAULT 'tech',
  `rating` double DEFAULT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int NOT NULL,
  `shelf_no` int DEFAULT NULL,
  `issued` int NOT NULL DEFAULT '0',
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `callno` (`isbn`),
  UNIQUE KEY `callno_2` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'A24','C In Depth','true','tech',3.5,'Shrivastav','BPB',2,NULL,2,'2021-06-03 08:32:20'),(2,'B91','DBMS','true','tech',4,'Korth','Pearson',3,NULL,0,'2021-06-03 08:32:20'),(3,'G012','Let\'s us c','true','tech',3,'Yashwant Kanetkar','BPB',7,NULL,3,'2021-06-03 08:35:53'),(4,'a123sd','design patterns','true','tech',4,'gof','gof',1,NULL,0,'2021-06-03 08:32:20'),(5,'a32d','gof','true','tech',4.5,'erich','gamma',1,NULL,0,'2021-05-30 20:00:13'),(6,'a123','dbms','true','tech',4,'Paul','orielly',3,NULL,0,'2021-06-03 09:15:32'),(7,'0-399-90070-5','The Bourne Identity','true','Action',3.5,'Robert','Richard',2,1,0,'2021-06-03 09:37:08');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuebooks`
--

DROP TABLE IF EXISTS `issuebooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issuebooks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_isbn` varchar(50) NOT NULL,
  `studentid` int NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  `issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuebooks`
--

LOCK TABLES `issuebooks` WRITE;
/*!40000 ALTER TABLE `issuebooks` DISABLE KEYS */;
INSERT INTO `issuebooks` VALUES (4,'A24',23,'kk','932992932','2021-06-03 08:30:00'),(6,'B91',335,'Sumedh','95676565756','2021-06-03 08:30:00'),(7,'a32d',87,'abhishek','9329882382','2021-06-03 08:30:00'),(8,'G012',123,'John','12435','2021-06-03 08:36:20');
/*!40000 ALTER TABLE `issuebooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarian` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `is_admin` varchar(100) NOT NULL DEFAULT 'false',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'Prabhakar','ppp','prabhakar@gmail.com','Bangalore','9998328238','false'),(4,'sumedh','sumesh','sumesh@gmail.com','NYC','93823932823','false'),(6,'abhi','abhi','abhi@gmail.com','California','92393282323','false'),(7,'admin','admin@123','admin@gmail.com','Delhi','92393285555','true');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shelves`
--

DROP TABLE IF EXISTS `shelves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shelves` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `genre` varchar(45) NOT NULL DEFAULT 'tech',
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelves`
--

LOCK TABLES `shelves` WRITE;
/*!40000 ALTER TABLE `shelves` DISABLE KEYS */;
INSERT INTO `shelves` VALUES (1,'Shelf A1-0','Action','West Block 1'),(2,'Shelf B1-0','Tech','West Block 2'),(3,'Shelf C1-0','Fiction','West Block 3'),(4,'Shelf D1-0','Drama','West Block 4');
/*!40000 ALTER TABLE `shelves` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-03 15:17:57
