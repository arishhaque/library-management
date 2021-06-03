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
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'1-399-90070-4','The Bourne Identity','true','Action',3.5,'Robert Ludlum','Richard Marek',7,1,0,'2021-06-03 16:27:22'),(2,'2-214-66814-2','First Blood','true','Action',4,'Rowman & Littlefield','Pearson',7,1,0,'2021-06-03 15:50:20'),(3,'3-038-54946-9','Treasure Island','true','Adventure',3,'Robert Louis Stevenson','Casell & Company',6,9,1,'2021-06-03 16:13:07'),(4,'4-038-34652-1','The Adventures of Sherlock Holmes','true','Adventure',4,'Sir Arthur Conan Doyle','George Newnes',9,9,1,'2021-06-03 16:40:13'),(5,'4-937-54962-7','To Kill a Mockingbird','true','Drama',4.5,'Harper Lee','J.B. Lippincott & Co.',3,4,1,'2021-06-03 16:11:47'),(6,'5-937-54909-6','The Kite Runner','true','Drama',4,'Khaled Hosseini','Riverhead Books',3,4,0,'2021-06-03 16:11:47'),(7,'6-637-43270-8','Bridge to Terabithia','true','Action',3.5,'Katherine Patterson','Thomas Y. Crowell Co.',2,1,1,'2021-06-03 16:11:47'),(8,'7-765-05478-3','The Hitchhiker\'s Guide to the Galaxy','true','Science Fiction',5,'Douglas Adams','Pan Books',4,7,1,'2021-06-03 16:11:47');
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
  `returndate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuebooks`
--

LOCK TABLES `issuebooks` WRITE;
/*!40000 ALTER TABLE `issuebooks` DISABLE KEYS */;
INSERT INTO `issuebooks` VALUES (4,'1-399-90070-4',1001,'Michael','9329929321','2021-06-03 16:14:48',NULL),(7,'3-038-54946-9',1011,'Charles','9329882382','2021-06-03 16:14:48',NULL),(8,'6-637-43270-8',1021,'John','8269882382','2021-06-03 16:14:48',NULL),(9,'4-937-54962-7',1013,'Walter','8269784381','2021-06-03 16:14:48',NULL),(10,'7-765-05478-3',1099,'Turly','6798432109','2021-06-03 16:15:58',NULL),(12,'4-038-34652-1',1081,'Peter','8475980612','2021-06-03 16:40:13','2021-06-02 18:30:00');
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
INSERT INTO `librarian` VALUES (1,'Xavier','user@123','xavier@gmail.com','Bangalore','9998328238','false'),(4,'Bale','bale@123','bale@gmail.com','NYC','93823932823','false'),(6,'John Doe','john@123','john.doe@gmail.com','California','92393282323','false'),(7,'admin','admin@123','admin@gmail.com','Delhi','92393285555','true');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelves`
--

LOCK TABLES `shelves` WRITE;
/*!40000 ALTER TABLE `shelves` DISABLE KEYS */;
INSERT INTO `shelves` VALUES (1,'Shelf A1-0','Action','West Wing Floor 1'),(2,'Shelf A1-1','Tech','West Wing Floor 1'),(3,'Shelf A1-2','Fiction','West Wing Floor 1'),(4,'Shelf B2-1','Drama','West Wing Floor 2'),(5,'Shelf B2-2','Romance','West Wing Floor 2'),(6,'Shelf B2-2','Drama','East Wing Floor 2'),(7,'Shelf B2-3','Tragedy','East Wing Floor 2'),(8,'Shelf C3-0','Science Fiction','East Wing Floor 1'),(9,'Shelf C3-1','Adventure','East Wing Floor 3');
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

-- Dump completed on 2021-06-03 23:51:47
