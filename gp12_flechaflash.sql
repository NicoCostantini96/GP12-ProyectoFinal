-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2026 a las 00:52:27
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gp12_flechaflash`
--
CREATE DATABASE IF NOT EXISTS `gp12_flechaflash` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gp12_flechaflash`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivos`
--

CREATE TABLE `colectivos` (
  `id_colectivo` int(11) NOT NULL,
  `matricula` varchar(33) NOT NULL,
  `marca` varchar(33) NOT NULL,
  `modelo` varchar(33) NOT NULL,
  `capacidad` int(100) NOT NULL,
  `chofer` varchar(33) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivos`
--

INSERT INTO `colectivos` (`id_colectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `chofer`, `estado`) VALUES
(1, 'GSAJHAJ', 'L', 'K', 23, 'Carlos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `id_lugar` int(11) NOT NULL,
  `id_colectivo` int(33) NOT NULL,
  `numero_asiento` int(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `id_pasajero` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(33) NOT NULL,
  `apellidos` varchar(33) NOT NULL,
  `correo` varchar(33) NOT NULL,
  `telefono` varchar(33) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`id_pasajero`, `dni`, `nombre`, `apellidos`, `correo`, `telefono`, `estado`) VALUES
(1, '11111111', 'Axel', 'Vertacnik', 'a@gmail.com', '123', 1),
(2, '23423432', 'Alex', 'Montiel', 'b@gmail.com', '9999', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `id_pasaje` int(11) NOT NULL,
  `id_pasajero` int(11) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  `id_ruta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `hora_venta` time NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `id_ruta` int(11) NOT NULL,
  `origen` varchar(33) NOT NULL,
  `destino` varchar(33) NOT NULL,
  `hora_salida` time NOT NULL,
  `hora_llegada` time NOT NULL,
  `id_colectivo` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_viaje` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`id_ruta`, `origen`, `destino`, `hora_salida`, `hora_llegada`, `id_colectivo`, `precio`, `estado`, `fecha_viaje`) VALUES
(1, 's', 's', '04:04:04', '04:04:04', 1, 2, 1, '0004-04-04'),
(2, 's', 'd', '04:04:04', '01:01:01', 1, 6, 1, '2000-05-03');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`id_colectivo`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`id_lugar`),
  ADD KEY `id_colectivo` (`id_colectivo`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id_pasajero`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`id_pasaje`),
  ADD KEY `id_pasajero` (`id_pasajero`),
  ADD KEY `id_lugar` (`id_lugar`),
  ADD KEY `id_ruta` (`id_ruta`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`id_ruta`),
  ADD KEY `id_colectivo` (`id_colectivo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `id_colectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id_pasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `id_pasaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `id_ruta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`id_colectivo`) REFERENCES `colectivos` (`id_colectivo`);

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajeros` (`id_pasajero`),
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`),
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`);

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `rutas_ibfk_1` FOREIGN KEY (`id_colectivo`) REFERENCES `colectivos` (`id_colectivo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
