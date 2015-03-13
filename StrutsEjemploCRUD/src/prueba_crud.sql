-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 28-01-2013 a las 13:38:11
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `pruebas`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `equipo`
-- 

CREATE TABLE `equipo` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(30) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `equipo`
-- 

INSERT INTO `equipo` VALUES (1, 'Juve');
INSERT INTO `equipo` VALUES (2, 'Urroztarra');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `jugador`
-- 

CREATE TABLE `jugador` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(30) collate utf8_unicode_ci NOT NULL,
  `puesto` varchar(20) collate utf8_unicode_ci NOT NULL,
  `dorsal` int(11) NOT NULL,
  `idequipo` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB4D49BC29ADEDE6C` (`idequipo`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `jugador`
-- 

INSERT INTO `jugador` VALUES (1, 'Pardo', 'Delantero Eterno', 0, 1);
INSERT INTO `jugador` VALUES (2, 'Abilio', 'Medio cerebro', 0, 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tarea`
-- 

CREATE TABLE `tarea` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(50) collate utf8_unicode_ci NOT NULL,
  `descripcion` varchar(255) collate utf8_unicode_ci NOT NULL,
  `hecha` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `tarea`
-- 

INSERT INTO `tarea` VALUES (1, 'Muerte y Dolor', 'Destripar y matar lentamente', 0);
INSERT INTO `tarea` VALUES (2, 'Asesinar', 'Hacha de doble filo', 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `user`
-- 

CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL auto_increment,
  `USER_NAME` varchar(40) collate utf8_unicode_ci NOT NULL,
  `USER_GENDER` varchar(20) collate utf8_unicode_ci NOT NULL,
  `USER_COUNTRY` varchar(50) collate utf8_unicode_ci NOT NULL,
  `USER_ABOUT_YOU` varchar(255) collate utf8_unicode_ci NOT NULL,
  `USER_MAILING_LIST` tinyint(1) NOT NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `user`
-- 

INSERT INTO `user` VALUES (1, 'Muerte', 'Dolor', 'Infierno', 'Everlasting Pain', 0);
INSERT INTO `user` VALUES (2, 'Asesinar', 'Matar', 'Destripar', 'Mutilar', 1);
