-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2026 a las 23:10:27
-- Versión del servidor: 10.11.16-MariaDB
-- Versión de PHP: 8.5.12

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
(1, 'AB123CD', 'Mercedes-Benz', 'O500', 32, 'Carlos Rodriguez', 1),
(2, 'AC456EF', 'Scania', 'K360', 32, 'Miguel Fernandez', 1),
(3, 'AD789GH', 'Volvo', 'B290R', 32, 'Roberto Martinez', 1),
(4, 'AE111JK', 'Mercedes-Benz', 'O500', 32, 'Jorge Gonzalez', 1),
(5, 'AF222LM', 'Scania', 'K360', 32, 'Daniel Lopez', 1),
(6, 'AG333NP', 'Volvo', 'B290R', 32, 'Fernando Diaz', 1),
(7, 'AH444QR', 'Mercedes-Benz', 'O500', 32, 'Ricardo Torres', 1),
(8, 'AJ555ST', 'Scania', 'K360', 32, 'Pablo Romero', 1),
(9, 'AK666UV', 'Volvo', 'B290R', 32, 'Sergio Alvarez', 1),
(10, 'AL777WX', 'Mercedes-Benz', 'O500', 32, 'Andres Castro', 1),
(11, 'AM888YZ', 'Scania', 'K360', 32, 'Gabriel Ruiz', 1),
(12, 'AN999BC', 'Volvo', 'B290R', 32, 'Hernan Silva', 1),
(13, 'AP123DE', 'Mercedes-Benz', 'O500', 32, 'Eduardo Molina', 1),
(14, 'AQ456FG', 'Scania', 'K360', 32, 'Martin Herrera', 1),
(15, 'AR789HJ', 'Volvo', 'B290R', 32, 'Esteban Ortiz', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `id_lugar` int(11) NOT NULL,
  `id_ruta` int(11) NOT NULL,
  `numero_asiento` int(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`id_lugar`, `id_ruta`, `numero_asiento`, `estado`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 1, 5, 1),
(4, 2, 1, 1),
(5, 2, 4, 1),
(6, 3, 2, 1),
(7, 4, 1, 1),
(8, 5, 3, 1),
(9, 6, 1, 1),
(10, 7, 2, 1),
(11, 8, 1, 1),
(12, 9, 5, 1),
(13, 10, 3, 1),
(14, 11, 1, 1),
(15, 12, 4, 1);

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
(1, '45123456', 'Juan', 'Perez', 'juan.perez@gmail.com', '2664123456', 1),
(2, '42345678', 'Maria', 'Gomez', 'maria.gomez@gmail.com', '2664234567', 1),
(3, '39876543', 'Lucas', 'Fernandez', 'lucas.fernandez@gmail.com', '2664345678', 1),
(4, '46789123', 'Sofia', 'Martinez', 'sofia.martinez@gmail.com', '2664456789', 1),
(5, '41234567', 'Martin', 'Lopez', 'martin.lopez@gmail.com', '2664567890', 1),
(6, '43567890', 'Camila', 'Rodriguez', 'camila.rodriguez@gmail.com', '2664678901', 1),
(7, '40987654', 'Nicolas', 'Garcia', 'nicolas.garcia@gmail.com', '2664789012', 1),
(8, '45678901', 'Valentina', 'Sanchez', 'valentina.sanchez@gmail.com', '2664890123', 1),
(9, '38765432', 'Mateo', 'Romero', 'mateo.romero@gmail.com', '2664901234', 1),
(10, '47890123', 'Lucia', 'Torres', 'lucia.torres@gmail.com', '2664012345', 1),
(11, '40123456', 'Tomas', 'Diaz', 'tomas.diaz@gmail.com', '2664123457', 1),
(12, '44567890', 'Florencia', 'Alvarez', 'florencia.alvarez@gmail.com', '2664234568', 1),
(13, '39234567', 'Santiago', 'Castro', 'santiago.castro@gmail.com', '2664345679', 1),
(14, '46789012', 'Julieta', 'Ruiz', 'julieta.ruiz@gmail.com', '2664456780', 1),
(15, '42876543', 'Benjamin', 'Molina', 'benjamin.molina@gmail.com', '2664567891', 1);

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

--
-- Volcado de datos para la tabla `pasajes`
--

INSERT INTO `pasajes` (`id_pasaje`, `id_pasajero`, `id_lugar`, `id_ruta`, `fecha_venta`, `hora_venta`, `precio`, `estado`) VALUES
(1, 1, 1, 1, '2026-11-10', '10:30:00', 15000, 1),
(2, 2, 2, 1, '2026-11-10', '11:15:00', 15000, 1),
(3, 3, 3, 1, '2026-11-11', '09:20:00', 15000, 1),
(4, 4, 4, 2, '2026-11-11', '12:00:00', 22000, 1),
(5, 5, 5, 2, '2026-11-11', '14:30:00', 22000, 1),
(6, 6, 6, 3, '2026-11-12', '08:45:00', 45000, 1),
(7, 7, 7, 4, '2026-11-12', '10:00:00', 18000, 1),
(8, 8, 8, 5, '2026-11-12', '16:20:00', 38000, 1),
(9, 9, 9, 6, '2026-11-12', '17:30:00', 15000, 1),
(10, 10, 10, 7, '2026-11-12', '18:00:00', 22000, 1),
(11, 11, 11, 8, '2026-11-12', '19:15:00', 45000, 1),
(12, 12, 12, 9, '2026-11-12', '20:00:00', 18000, 1),
(13, 13, 13, 10, '2026-11-12', '20:30:00', 38000, 1),
(14, 14, 14, 11, '2026-11-12', '21:00:00', 8000, 1),
(15, 15, 15, 12, '2026-11-12', '21:30:00', 26000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `id_ruta` int(11) NOT NULL,
  `origen` varchar(33) NOT NULL,
  `destino` varchar(33) NOT NULL,
  `fecha_viaje` date NOT NULL,
  `hora_salida` time NOT NULL,
  `hora_llegada` time NOT NULL,
  `id_colectivo` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`id_ruta`, `origen`, `destino`, `fecha_viaje`, `hora_salida`, `hora_llegada`, `id_colectivo`, `precio`, `estado`) VALUES
(1, 'San Luis', 'Mendoza', '2026-11-15', '08:00:00', '11:00:00', 1, 15000, 1),
(2, 'San Luis', 'Cordoba', '2026-11-16', '09:00:00', '13:30:00', 2, 22000, 1),
(3, 'San Luis', 'Buenos Aires', '2026-11-17', '20:00:00', '06:00:00', 3, 45000, 1),
(4, 'San Luis', 'San Juan', '2026-11-18', '07:30:00', '10:30:00', 4, 18000, 1),
(5, 'San Luis', 'Rosario', '2026-11-19', '21:00:00', '05:00:00', 5, 38000, 1),
(6, 'Mendoza', 'San Luis', '2026-11-20', '10:00:00', '13:00:00', 6, 15000, 1),
(7, 'Cordoba', 'San Luis', '2026-11-21', '14:00:00', '18:30:00', 7, 22000, 1),
(8, 'Buenos Aires', 'San Luis', '2026-11-22', '19:00:00', '05:00:00', 8, 45000, 1),
(9, 'San Juan', 'San Luis', '2026-11-23', '08:00:00', '11:00:00', 9, 18000, 1),
(10, 'Rosario', 'San Luis', '2026-11-24', '20:00:00', '04:00:00', 10, 38000, 1),
(11, 'San Luis', 'Villa Mercedes', '2026-11-25', '09:00:00', '10:30:00', 11, 8000, 1),
(12, 'San Luis', 'La Rioja', '2026-11-26', '06:00:00', '12:00:00', 12, 26000, 1),
(13, 'San Luis', 'Santa Fe', '2026-11-27', '18:00:00', '02:00:00', 13, 35000, 1),
(14, 'Villa Mercedes', 'San Luis', '2026-11-28', '15:00:00', '16:30:00', 14, 8000, 1),
(15, 'La Rioja', 'San Luis', '2026-11-29', '07:00:00', '13:00:00', 15, 26000, 1);

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
  ADD UNIQUE KEY `uq_lugar_ruta` (`id_ruta`,`numero_asiento`),
  ADD KEY `id_ruta` (`id_ruta`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id_pasajero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `uq_pasajeros_correo` (`correo`);

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
  MODIFY `id_colectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id_pasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `id_pasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `id_ruta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajeros` (`id_pasajero`) ON DELETE CASCADE,
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE,
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
