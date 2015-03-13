-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-12-2013 a las 23:55:05
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

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcar la base de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`, `description`) VALUES
(1, 'Normal', 'Normal user with no priveleges at all'),
(2, 'Superadmin', 'Super administrator user, the gift ot the absolute power'),
(6, 'default', 'Another role'),
(7, 'default', 'Another role');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `email`, `roleid`) VALUES
(1, 'john_doe', '20eabe5d64b0e216796e834f52d61fd0b70332fc', 'john_doe@erp.com', 0),
(2, 'juan_nadie', '20eabe5d64b0e216796e834f52d61fd0b70332fc', 'juan_nadie@erp.com', 0),
(3, 'bruce_wayne', '20eabe5d64b0e216796e834f52d61fd0b70332fc', 'batman@wayne.co', 0),
(4, 'joker', 'cd3f0c85b158c08a2b113464991810cf2cdfc387', 'hahaha@haha.com', 0),
(8, 'changed', '1234567', 'newuser@gmail.com', 0),
(9, 'newuser', '1234567', 'newuser@gmail.com', 0);
