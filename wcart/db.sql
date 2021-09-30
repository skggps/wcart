CREATE DATABASE  IF NOT EXISTS `wcart`;
USE `wcart`;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_description` varchar(45) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `product_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `product`
--
INSERT INTO `product` VALUES 
	(1,'Himalaya Facewash','Himalaya Facewash',150.50,'Facewash'),
	(2,'Ponds Cream','Ponds Cream',299.00,'Cream'),
	(3,'Pepsodent','Pepsodent',150.99,'Pepsodent');
	
	
---------------------------------------------------------------------------------------------------
--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `login_id` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `phone_no` varchar(12) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

--
-- Data for table `customer`
--
INSERT INTO `customer` VALUES 
	('Tom1','Tom','Curran','tom@gmail.com',123456,'England'),
	('Steve1','Steve','Smith','steve@gmail.com',222222,'Australia'),
	('Kane2','Kane','Williamson','kane@gmail.com',333333,'New Zealand');
	

---------------------------------------------------------------------------------------------------
--
-- Table structure for table `seller`
--
CREATE TABLE `seller` (
  `seller_id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone_no` varchar(12) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `rating` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `seller`
--
INSERT INTO `seller` VALUES 
	('1','CloudTail','cloudtail@gmail.com',123456,'England','Gold'),
	('2','ABC','abc@gmail.com',222222,'Australia','Bronze'),
	('3','XYZ','xyz@gmail.com',333333,'New Zealand','Platinum');