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
(1, 'AB123CD', 'Mercedes Benz', 'O500', 33, 'Carlos Gomez', 1),
(2, 'AA987XY', 'Scania', 'K310', 28, 'Juan Perez', 1),
(3, 'AD456EF', 'Volvo', 'B270F', 24, 'Maria Rodriguez', 1),
(4, 'AF654GH', 'Agrale', 'MT15', 18, 'Roberto Fernandez', 1),
(5, 'AC321JK', 'Iveco', '170E28', 30, 'Lucia Fernandez', 1),
(6, 'AE789LM', 'Volkswagen', '18280', 20, 'Esteban Garcia', 1),
(7, 'AG147NO', 'Mercedes Benz', 'OF1621', 32, 'Sofia Lopez', 1),
(8, 'AH258PQ', 'Scania', 'K400', 15, 'Diego Martinez', 1),
(9, 'AI369RS', 'Volvo', 'B340R', 22, 'Ana Romero', 1),
(10, 'AJ951TU', 'Agrale', 'MA10', 12, 'Gonzalo Alvarez', 1);

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
(1, '38123456', 'Juan', 'Perez', 'jperez@mail.com', '2657412345', 1),
(2, '40234567', 'Maria', 'Gomez', 'mgomez@mail.com', '2657423456', 1),
(3, '39345678', 'Carlos', 'Lopez', 'clopez@mail.com', '2657434567', 1),
(4, '41456789', 'Lucia', 'Fernandez', 'lfernandez@mail.com', '2657445678', 1),
(5, '37567890', 'Roberto', 'Rodriguez', 'rrodriguez@mail.com', '2657456789', 1),
(6, '42678901', 'Sofia', 'Garcia', 'sgarcia@mail.com', '2657467890', 1),
(7, '36789012', 'Esteban', 'Martinez', 'emartinez@mail.com', '2657478901', 1),
(8, '43890123', 'Ana', 'Romero', 'aromero@mail.com', '2657489012', 1),
(9, '35901234', 'Diego', 'Alvarez', 'dalvarez@mail.com', '2657490123', 1),
(10, '44012345', 'Gonzalo', 'Torres', 'gtorres@mail.com', '2657401234', 1),
(11, '40785123', 'Nicolás Agustín', 'Costantini', 'nico.cost96@gmail.com', '2665129703 ', 1),
(13, '41095789', 'Francisco', 'Garcia Moretta', 'francisco@gmail.com', '2657505349', 1),
(14, '13521231', 'Cesar Rafael ', 'das Neves Quintero', 'asdasd@hotmail.com', '2665232349', 1),
(15, '38123123', 'Axel Lautaro', 'Vertacnik', 'vertacnikaxellautaro@gmail.com', '2664577660', 1);
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
(31, 'Villa Mercedes', 'San Luis', '08:00:00', '09:30:00', 1, 3500, 1, '2026-11-01'),
(32, 'San Luis', 'Mendoza', '10:00:00', '13:30:00', 2, 8500, 1, '2026-11-01'),
(33, 'Villa Mercedes', 'Cordoba', '06:00:00', '11:00:00', 3, 12000, 1, '2026-11-02'),
(34, 'Cordoba', 'Buenos Aires', '14:00:00', '22:00:00', 4, 25000, 1, '2026-11-02'),
(35, 'San Luis', 'Villa Mercedes', '12:30:00', '14:00:00', 5, 3500, 1, '2026-11-03'),
(36, 'Mendoza', 'San Juan', '07:15:00', '09:45:00', 6, 5000, 1, '2026-11-03'),
(37, 'Villa Mercedes', 'Merlo', '09:00:00', '12:00:00', 7, 6000, 1, '2026-11-04'),
(38, 'Merlo', 'San Luis', '15:00:00', '18:00:00', 8, 6500, 1, '2026-11-04'),
(39, 'Rio Cuarto', 'Villa Mercedes', '17:30:00', '19:30:00', 9, 4500, 1, '2026-11-05'),
(40, 'San Luis', 'Cordoba', '23:00:00', '04:00:00', 10, 13000, 1, '2026-11-05');

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
