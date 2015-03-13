-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2013 at 10:31 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `erp`
--

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) NOT NULL,
  `saledate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idseller` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_07a7b7963e74435995a6a18b346` (`idseller`),
  KEY `FK_6c9bb7acd3984e37a090b44480a` (`idseller`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`id`, `description`, `saledate`, `idseller`) VALUES
(1, 'aaaaaa', '2013-11-15 22:16:17', 1),
(2, 'bbbbb', '2013-11-15 22:16:17', 1),
(3, 'cccccc', '2013-11-15 22:16:17', 1),
(4, 'dddddd', '2013-11-15 22:16:17', 1),
(5, 'epa', '2013-11-15 22:19:36', 3),
(6, 'super', '2013-11-15 22:29:01', 4);

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE IF NOT EXISTS `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `percentage` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`id`, `name`, `percentage`) VALUES
(2, 'Abilio', 66),
(3, 'juanjo', 66);

alter table sale
add constraint fk_seller_id
foreign key (idseller)
references seller(id);