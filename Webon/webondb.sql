-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 10, 2013 at 11:40 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `webondb`
--

-- --------------------------------------------------------

--
-- Table structure for table `file`
--

CREATE TABLE IF NOT EXISTS `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idfather` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `filedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` longblob NOT NULL,
  `idtype` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `file`
--

INSERT INTO `file` (`id`, `idfather`, `iduser`, `name`, `filedate`, `description`, `content`, `idtype`) VALUES
(2, 0, 17, 'pello', '2012-08-11 00:34:31', 'pello home', 0x6e756c6c, 1),
(3, 0, 17, 'muerte', '2012-08-15 00:17:21', 'desc desc', 0x45737465206669636865726f2065206c61206d75656c7465, 2),
(4, 2, 17, 'vamos', '2012-08-17 00:27:47', 'tiki tiki', 0x4573746520746578746f2073efbfbdefbfbd206d6f6c61, 2),
(6, 2, 17, 'Fichero especialers', '2012-08-16 23:44:20', 'Vamos fuertesss', 0x6465206261727269676173732064616c65206475726f, 2),
(7, 2, 17, '111', '2012-08-17 00:05:21', '222', '', 2),
(8, 2, 17, 'newdir', '2012-08-17 00:08:15', 'va', '', 1),
(9, 8, 17, 'va', '2012-08-17 00:14:02', 'va', 0x7661207661, 2),
(10, 8, 17, 'va nuevo', '2012-08-17 00:27:19', '', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`,`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `email`) VALUES
(17, 'pello', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'pello@pello.info');
