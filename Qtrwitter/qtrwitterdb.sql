-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 10, 2013 at 11:38 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qtrwitterdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tuits`
--

CREATE TABLE IF NOT EXISTS `tuits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `text` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `tuitdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tuits`
--

INSERT INTO `tuits` (`id`, `iduser`, `text`, `tuitdate`) VALUES
(11, 2, 'vamos ', '2012-08-08 00:21:33'),
(10, 3, 'Dolor infinito1', '2012-08-07 01:18:11'),
(4, 3, 'muerte a todos', '2012-08-07 00:47:33'),
(5, 3, 'Dolor infinito2', '2012-08-07 00:47:40'),
(9, 3, 'Dolor infinito3', '2012-08-07 01:18:03'),
(8, 3, 'Dolor infinito4', '2012-08-07 01:12:01'),
(12, 2, 'dalo todo', '2012-08-08 00:31:20');

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `email`) VALUES
(1, 'juan', 'palomo', 'wert@wer.com'),
(2, 'pello', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'pepe@qwer.com'),
(3, 'pepe', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'pepe@wer.com');
