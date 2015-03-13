-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-07-2013 a las 23:52:28
-- Versión del servidor: 5.1.61
-- Versión de PHP: 5.3.3-7+squeeze15

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `erp`
--

-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Volcar la base de datos para la tabla `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `email`) VALUES
(1, 'John Doe', 'c/ Nowhere to run 45', 'john.doe@gmail.com'),
(2, 'John Snowden', 'Evergreen terrace 24', 'snowden@nsa.gov'),
(3, 'Phil Anselmo', 'Suicide note', 'phil@pantera.com'),
(4, 'Phil Anselmo', 'Suicide note', 'phil@pantera.com'),
(5, 'Dimebag Darrell', 'Suicide note', 'phil@pantera.com'),
(14, 'Manowar', 'Valhalla', '333@man.war'),
(13, 'Paco Roda', 'muerte y dfolor', 'yea@werr.com'),
(15, 'Pepe', 'Potamo', 'Dolor'),
(16, 'aaa', 'bbb', 'ccc'),
(17, 'sadfasdf', 'werewr', 'sdf'),
(20, 'qqq', 'ppp', 'aaa'),
(22, 'sdf', 'sadf', 'asdf'),
(23, 'ttt', 'yyy', 'uuu'),
(24, 'sdf', 'sf', 'sf'),
(25, 'yyy', 'uuu', 'iii'),
(26, 'pantera', 'mola', 'cantidubi'),
(27, 'dale', 'osasuna', 'dale');

