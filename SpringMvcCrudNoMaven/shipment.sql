-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 27, 2014 at 01:19 AM
-- Server version: 5.5.35
-- PHP Version: 5.4.4-14+deb7u7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `erp`
--

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE IF NOT EXISTS `shipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `shipment_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `origin` varchar(100) NOT NULL,
  `destiny` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `shipment`
--

INSERT INTO `shipment` (`id`, `description`, `shipment_date`, `origin`, `destiny`) VALUES
(3, 'Misterious package', '2014-01-27 00:18:10', 'Iruñea', 'Donostia'),
(4, 'Weapons of Massive Destruction', '2014-01-27 00:18:10', 'Mojave desert', 'Kabul'),
(5, 'The one ring', '2014-01-27 00:19:33', 'The Shire', 'Gorgoroth'),
(6, 'Arya Stark', '2014-01-27 00:19:33', 'King''s Landing', 'Winterfell');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
