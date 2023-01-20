-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for debian-linux-gnu (aarch64)
--
-- Host: localhost    Database: medical_record
-- ------------------------------------------------------
-- Server version	10.7.3-MariaDB-1:10.7.3+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `medical_record`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `medical_record` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `medical_record`;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime DEFAULT NULL,
  `doctor_id` varchar(36) DEFAULT NULL,
  `patient_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES
(1,'2023-01-05 13:00:00','29f105d4-4982-4234-92c9-572ac649a94c','1ece4941-38f5-4675-84b1-5e027a795271'),
(2,'2023-01-14 15:30:00','29f105d4-4982-4234-92c9-572ac649a94c','1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_patients`
--

DROP TABLE IF EXISTS `doctor_patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_patients` (
  `doctor_id` varchar(36) NOT NULL,
  `patient_id` varchar(36) NOT NULL,
  KEY `FK6pnsy2l758i5qn2q5qdpx29cp` (`doctor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_patients`
--

LOCK TABLES `doctor_patients` WRITE;
/*!40000 ALTER TABLE `doctor_patients` DISABLE KEYS */;
INSERT INTO `doctor_patients` VALUES
('29f105d4-4982-4234-92c9-572ac649a94c','1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `doctor_patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_specialties`
--

DROP TABLE IF EXISTS `doctor_specialties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_specialties` (
  `doctor_id` varchar(36) NOT NULL,
  `specialty_id` bigint(20) NOT NULL,
  KEY `FK3gedig715eyy0nat13uju3nn5` (`specialty_id`),
  KEY `FKas1tsi4uakiu7q90rnvsgvhfv` (`doctor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_specialties`
--

LOCK TABLES `doctor_specialties` WRITE;
/*!40000 ALTER TABLE `doctor_specialties` DISABLE KEYS */;
INSERT INTO `doctor_specialties` VALUES
('29f105d4-4982-4234-92c9-572ac649a94c',1);
/*!40000 ALTER TABLE `doctor_specialties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `is_gp` bit(1) NOT NULL DEFAULT b'1',
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES
('','29f105d4-4982-4234-92c9-572ac649a94c');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_insurances`
--

DROP TABLE IF EXISTS `health_insurances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `health_insurances` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `is_paid` bit(1) NOT NULL,
  `patient_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3n4kkhut0hxvtfilgph1m7irm` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_insurances`
--

LOCK TABLES `health_insurances` WRITE;
/*!40000 ALTER TABLE `health_insurances` DISABLE KEYS */;
INSERT INTO `health_insurances` VALUES
(1,'2022-08-01','2022-08-31','','1ece4941-38f5-4675-84b1-5e027a795271'),
(2,'2022-09-01','2022-09-30','','1ece4941-38f5-4675-84b1-5e027a795271'),
(3,'2022-10-01','2022-10-31','','1ece4941-38f5-4675-84b1-5e027a795271'),
(4,'2022-11-01','2022-11-30','','1ece4941-38f5-4675-84b1-5e027a795271'),
(5,'2022-12-01','2022-12-31','','1ece4941-38f5-4675-84b1-5e027a795271'),
(6,'2023-01-01','2023-01-31','','1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `health_insurances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `illnesses`
--

DROP TABLE IF EXISTS `illnesses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `illnesses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `symptoms` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `illnesses`
--

LOCK TABLES `illnesses` WRITE;
/*!40000 ALTER TABLE `illnesses` DISABLE KEYS */;
INSERT INTO `illnesses` VALUES
(1,'Asthma','The symptoms of asthma can range from mild to severe. Most people will only experience occasional symptoms, although a few people will have problems most of the time.\n\nThe main symptoms of asthma are:\n\nwheezing (a whistling sound when you breathe)\nshortness of breath\na tight chest – which may feel like a band is tightening around it \ncoughing\n'),
(2,'Common cold','A cold is a mild viral infection of the nose, throat, sinuses and upper airways. It\'s very common and usually clears up on its own within a week or two.\n\nThe main symptoms of a cold include:\n\na sore throat\na blocked or runny nose\nsneezing\na cough\n'),
(3,'Cough','A cough is a reflex action to clear your airways of mucus and irritants such as dust or smoke. It\'s rarely a sign of anything serious. '),
(4,'Pneumonia','Pneumonia is swelling (inflammation) of the tissue in one or both lungs. It\'s usually caused by a bacterial infection.');
/*!40000 ALTER TABLE `illnesses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_specialties`
--

DROP TABLE IF EXISTS `medical_specialties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_specialties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lhtvpg16rimsy4mkpmj5qhx2x` (`name`) USING HASH
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_specialties`
--

LOCK TABLES `medical_specialties` WRITE;
/*!40000 ALTER TABLE `medical_specialties` DISABLE KEYS */;
INSERT INTO `medical_specialties` VALUES
(1,'Dermatology'),
(2,'Surgery'),
(3,'Pathology'),
(4,'Neurology'),
(5,'Pediatrics');
/*!40000 ALTER TABLE `medical_specialties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `pin` varchar(255) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES
('123456789','1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`) USING HASH
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES
(1,'ADMIN'),
(2,'DOCTOR'),
(3,'PATIENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sick_leaves`
--

DROP TABLE IF EXISTS `sick_leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sick_leaves` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `patient_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8wjjdvsgh089xqklkvqc4usjp` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sick_leaves`
--

LOCK TABLES `sick_leaves` WRITE;
/*!40000 ALTER TABLE `sick_leaves` DISABLE KEYS */;
INSERT INTO `sick_leaves` VALUES
(1,'2022-10-15','2022-10-20','1ece4941-38f5-4675-84b1-5e027a795271'),
(2,'2023-01-15','2023-01-20','1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `sick_leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatments`
--

DROP TABLE IF EXISTS `treatments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `treatment` text DEFAULT NULL,
  `doctor_id` varchar(36) DEFAULT NULL,
  `illness_id` bigint(20) DEFAULT NULL,
  `patient_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlq26umrqdstnql9v4393155mq` (`doctor_id`),
  KEY `FKiliuuvpu6661bvmt5ewbt3cju` (`illness_id`),
  KEY `FK8djm31y5jedj2s88odydl1mmw` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatments`
--

LOCK TABLES `treatments` WRITE;
/*!40000 ALTER TABLE `treatments` DISABLE KEYS */;
INSERT INTO `treatments` VALUES
(1,'Mild pneumonia can usually be treated at home by:\n\ngetting plenty of rest\ntaking antibiotics\ndrinking plenty of fluids\n','29f105d4-4982-4234-92c9-572ac649a94c',4,'1ece4941-38f5-4675-84b1-5e027a795271'),
(2,'While there is no cure for asthma, there are a number of treatments that can help control the condition.\n\nTreatment is based on two important goals, which are:\n\nrelieving symptoms \npreventing future symptoms and attacks','29f105d4-4982-4234-92c9-572ac649a94c',1,'1ece4941-38f5-4675-84b1-5e027a795271');
/*!40000 ALTER TABLE `treatments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`) USING HASH
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES
('f41070b5-355c-45f0-8db8-f21e27866aec','2023-01-15 17:16:51','kznikov@gmail.com','Krasimir','','Krasimir','$2a$10$ffs2WPKAwG6AHMYP1yNo4uQTRtO0xu9BEDPZDV302UTvlUTwDGSGi','2023-01-15 17:16:51'),
('29f105d4-4982-4234-92c9-572ac649a94c','2023-01-20 20:41:29','doctor@gmail.com','Krasimira','','Nikova','$2a$10$ffs2WPKAwG6AHMYP1yNo4uQTRtO0xu9BEDPZDV302UTvlUTwDGSGi','2023-01-20 20:41:29'),
('1ece4941-38f5-4675-84b1-5e027a795271','2023-01-20 20:40:43','patient@gmail.com','Krasi','','Nikov','$2a$10$ffs2WPKAwG6AHMYP1yNo4uQTRtO0xu9BEDPZDV302UTvlUTwDGSGi','2023-01-20 20:40:43');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES
('f41070b5-355c-45f0-8db8-f21e27866aec',1),
('29f105d4-4982-4234-92c9-572ac649a94c',2),
('1ece4941-38f5-4675-84b1-5e027a795271',3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 19:28:26
