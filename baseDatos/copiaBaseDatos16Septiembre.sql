-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: teamflash
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `tcategorias`
--

DROP TABLE IF EXISTS `tcategorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcategorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `habilitado` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcategorias`
--

LOCK TABLES `tcategorias` WRITE;
/*!40000 ALTER TABLE `tcategorias` DISABLE KEYS */;
INSERT INTO `tcategorias` VALUES (1,'Aseo personal',1),(15,'Frutas y verduras',1),(20,'Enlatados',1),(22,'Abarrotes',1),(37,'Ofertas',1);
/*!40000 ALTER TABLE `tcategorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tclientes`
--

DROP TABLE IF EXISTS `tclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tclientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identificacion` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `celular` int NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `celular_UNIQUE` (`celular`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tclientes`
--

LOCK TABLES `tclientes` WRITE;
/*!40000 ALTER TABLE `tclientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdetalles`
--

DROP TABLE IF EXISTS `tdetalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tdetalles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `total` int NOT NULL,
  `id_productos` int NOT NULL,
  `id_facturas` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_detalleProductos_idx` (`id_productos`),
  KEY `FK_detallesFacturas_idx` (`id_facturas`),
  CONSTRAINT `FK_detallesFacturas` FOREIGN KEY (`id_facturas`) REFERENCES `tfacturas` (`id`),
  CONSTRAINT `FK_detallesProductos` FOREIGN KEY (`id_productos`) REFERENCES `tproductos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdetalles`
--

LOCK TABLES `tdetalles` WRITE;
/*!40000 ALTER TABLE `tdetalles` DISABLE KEYS */;
/*!40000 ALTER TABLE `tdetalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tfacturas`
--

DROP TABLE IF EXISTS `tfacturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tfacturas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` int NOT NULL,
  `id_clientes` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_clienteFacturas_idx` (`id_clientes`),
  CONSTRAINT `FK_clienteFacturas` FOREIGN KEY (`id_clientes`) REFERENCES `tclientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tfacturas`
--

LOCK TABLES `tfacturas` WRITE;
/*!40000 ALTER TABLE `tfacturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tfacturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tproductos`
--

DROP TABLE IF EXISTS `tproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tproductos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `presentacion` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `existencia` double NOT NULL,
  `precio` double NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_categoriaProductos_idx` (`id_categoria`),
  CONSTRAINT `FK_productosCategorias` FOREIGN KEY (`id_categoria`) REFERENCES `tcategorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tproductos`
--

LOCK TABLES `tproductos` WRITE;
/*!40000 ALTER TABLE `tproductos` DISABLE KEYS */;
INSERT INTO `tproductos` VALUES (1,'Protectores Nosotras','sobre','Nosotras',180,300,1),(4,'Arvejas Respin','Lata','Respin',200,6500,20);
/*!40000 ALTER TABLE `tproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 11:04:09
