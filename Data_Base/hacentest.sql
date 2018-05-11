-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2018 a las 05:32:08
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hacentest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `pk_consulta` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `asunto` varchar(60) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(300) COLLATE latin1_spanish_ci NOT NULL,
  `fk_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`pk_consulta`, `fecha`, `asunto`, `descripcion`, `fk_usuario`) VALUES
(1, '2018-05-11 03:12:49', 'Consulta 1', 'Esta es una consulta de prueba desde una sesion de invitado', 1),
(2, '2018-05-11 03:16:51', 'Consulta 2', 'Esta es una consulta de prueba desde una sesion de administrador', 16),
(3, '2018-05-11 03:18:09', 'Consulta 3', 'Esta es una consulta de prueba desde una sesion de invitado tras cerrar una sesion anterior', 1),
(4, '2018-05-11 03:25:02', 'Consulta 4', 'Consulta realizada desde una sesion de administrador', 16),
(5, '2018-05-11 03:25:45', 'Consulta 5', 'Consulta de prueda en una sesion de invitado tras cerrar otra sesion ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enuncian`
--

CREATE TABLE `enuncian` (
  `fk_test` int(11) NOT NULL,
  `fk_pregunta` int(11) NOT NULL,
  `respuesta` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `resultado` varchar(20) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `pk_pregunta` int(11) NOT NULL,
  `enunciado` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `indice_correcto` char(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `pk_respuesta` int(11) NOT NULL,
  `texto` varchar(300) COLLATE latin1_spanish_ci NOT NULL,
  `indice` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `fk_pregunta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `pk_sesion` int(11) NOT NULL,
  `codigo` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `tiempo_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tiempo_final` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `fk_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`pk_sesion`, `codigo`, `tiempo_inicio`, `tiempo_final`, `fk_usuario`) VALUES
(1, '@m3f7c2m8t5p6x8', '2018-04-20 15:28:49', '2018-04-20 15:28:49', 16),
(2, '@k7x4e4y1w3y4n7', '2018-04-25 02:47:24', '0000-00-00 00:00:00', 16),
(3, '@i2p8e6r9f4n5s1', '2018-04-25 02:57:34', '2018-04-25 02:57:54', 16),
(4, '@o5p4t4k5z9p5b7', '2018-04-25 03:04:09', '2018-04-25 03:04:18', 16),
(5, '@t2a8o2s2f2o8x7', '2018-04-27 00:35:16', '0000-00-00 00:00:00', 16),
(6, '@c2w1s3k8m8f2t8', '2018-04-27 00:44:12', '2018-04-27 00:44:39', 16),
(7, '@u1g7b3b3v1b4z7', '2018-04-27 00:45:01', '2018-04-27 00:55:49', 16),
(8, '@i5x2m7h2r5m9m8', '2018-04-29 17:54:57', '2018-04-29 17:56:39', 17),
(9, '@n8v6a9b8k7p6h7', '2018-04-29 17:57:02', '2018-04-29 17:58:25', 17),
(10, '@f8f5o8n1y2k7f6', '2018-04-29 18:16:51', '2018-04-29 18:17:48', 18),
(11, '@o1k9e1f8v6a1k7', '2018-04-29 18:37:49', '2018-04-29 18:38:40', 19),
(12, '@x4g3c4d9e3x2p4', '2018-04-29 18:38:52', '2018-04-29 18:46:24', 19),
(13, '@o5c5k7p7a8x9t7', '2018-04-30 02:24:35', '2018-04-30 02:24:56', 16),
(14, '@c6k3n6i4a3e4k5', '2018-04-30 03:01:03', '2018-04-30 03:02:04', 16),
(15, '@f3i6t8u8f6o7p2', '2018-04-30 03:02:16', '2018-04-30 03:08:26', 16),
(16, '@l1z3d8s2h2h8w1', '2018-04-30 03:08:38', '2018-04-30 03:15:28', 16),
(17, '@o9p1d3l5w3a7d6', '2018-04-30 03:15:40', '2018-04-30 03:16:27', 16),
(18, '@k3e1b4k7w7r3g4', '2018-04-30 03:17:01', '2018-04-30 03:17:17', 16),
(19, '@o1k5s6c9h7h7h3', '2018-04-30 03:19:07', '2018-04-30 03:19:39', 16),
(20, '@l5n2x1z1g9b5d3', '2018-04-30 03:25:24', '2018-04-30 03:25:53', 16),
(21, '@a9r8k7z6l5g8b3', '2018-04-30 03:27:22', '2018-04-30 03:27:52', 16),
(22, '@i8o4h8i7v4o9l9', '2018-04-30 03:28:05', '2018-04-30 03:28:18', 16),
(23, '@f7g7f2y9r7c1h8', '2018-04-30 03:31:09', '2018-04-30 03:31:23', 16),
(24, '@x7w5p6e1f3m2e8', '2018-04-30 03:32:09', '2018-04-30 03:32:50', 16),
(25, '@w3g8t4b7e8w9k8', '2018-04-30 03:33:07', '2018-04-30 03:33:29', 16),
(26, '@p8t7h5u8y1k2n4', '2018-04-30 03:33:41', '2018-04-30 03:34:50', 16),
(27, '@i3a6l5o1b9g5k6', '2018-04-30 03:35:02', '2018-04-30 03:35:47', 16),
(28, '@k2s7v5k9x1a5l6', '2018-04-30 03:36:44', '2018-04-30 03:37:26', 16),
(29, '@u4n9a7e4s3k6a8', '2018-04-30 03:37:37', '2018-04-30 03:37:52', 16),
(30, '@c2d5o8a8s9u3i7', '2018-04-30 03:48:13', '2018-04-30 03:48:20', 16),
(31, '@f7o6a3u3a8a5a4', '2018-04-30 04:07:13', '2018-04-30 04:07:45', 16),
(32, '@p2k4d6k7p4d7k1', '2018-04-30 04:09:43', '2018-04-30 04:10:05', 16),
(33, '@y1o3s6k8m3f3v9', '2018-04-30 04:10:59', '2018-04-30 04:11:33', 16),
(34, '@d5i3y5i3i6y4d6', '2018-04-30 04:14:41', '2018-04-30 04:16:50', 16),
(35, '@k1t6l1b4v1x2a8', '2018-04-30 16:30:57', '2018-04-30 16:36:12', 16),
(36, '@g8k9x6k7a6g3x5', '2018-04-30 16:39:21', '2018-04-30 16:40:35', 16),
(37, '@b3u6u3a6k8n1y2', '2018-04-30 16:40:19', '2018-04-30 16:40:27', 19),
(38, '@w7b4e9e3d5b6f4', '2018-04-30 17:10:57', '2018-04-30 17:11:19', 16),
(39, '@d2y6i6l3d1b3k9', '2018-04-30 19:29:24', '2018-04-30 19:33:17', 16),
(40, '@s1k6r5g3p3h4n2', '2018-04-30 19:46:21', '2018-04-30 19:47:37', 16),
(41, '@p9h5i4d3d5k6h2', '2018-04-30 19:48:32', '2018-04-30 20:15:42', 16),
(42, '@a7l3r6c3n9k8x7', '2018-05-08 00:02:51', '2018-05-08 00:04:02', 16),
(43, '@n6l2m3x8m9l6m7', '2018-05-08 00:09:42', '2018-05-08 00:24:32', 16),
(44, '@h4p5v1x8k6l8d6', '2018-05-08 00:28:25', '2018-05-08 00:28:51', 16),
(45, '@c1w3f1y7k2l8u6', '2018-05-08 00:29:26', '2018-05-08 00:30:22', 16),
(46, '@p9w3v9h4s2p4n8', '2018-05-08 00:32:25', '2018-05-08 00:32:51', 16),
(47, '@o8t2c3z6l6x5s7', '2018-05-08 00:33:11', '2018-05-08 00:33:20', 16),
(48, '@s3h3r5v6d4d2f8', '2018-05-08 00:36:47', '2018-05-08 00:37:57', 16),
(49, '@f8d2f2n2v9f7b1', '2018-05-08 00:39:23', '2018-05-08 00:42:32', 16),
(50, '@r3c2k4p4b3r3f1', '2018-05-08 01:17:31', '2018-05-08 01:18:58', 16),
(51, '@n9z6o7f7s4t6g5', '2018-05-08 01:19:10', '2018-05-08 01:26:01', 16),
(52, '@p6n9x9n4w9p6g1', '2018-05-09 20:59:50', '2018-05-09 20:59:57', 16),
(53, '@c8t8x6v3d1k5l7', '2018-05-09 21:29:58', '2018-05-09 21:46:34', 16),
(54, '@e9f9i6r1y6d8r2', '2018-05-09 21:47:10', '2018-05-09 21:47:17', 16),
(55, '@z3g9d6v2d1s4h3', '2018-05-09 21:49:52', '2018-05-09 21:51:29', 16),
(56, '@o5p4f4i3p3u9a3', '2018-05-09 22:06:29', '2018-05-09 22:07:08', 16),
(57, '@m3c8r9m1n7e3d6', '2018-05-09 22:08:13', '2018-05-09 22:11:00', 16),
(58, '@v1e4r5o3h1y9b4', '2018-05-09 22:12:04', '2018-05-09 22:12:38', 16),
(59, '@l6s2w1g9o4c3r9', '2018-05-09 22:14:40', '2018-05-09 22:14:43', 16),
(60, '@s1t1p3m2u7i5v3', '2018-05-09 22:23:22', '2018-05-09 22:23:39', 16),
(61, '@f6p5y2w1e2m6z4', '2018-05-09 22:30:37', '2018-05-09 22:30:42', 16),
(62, '@p9t2r5g3d5m9e1', '2018-05-09 22:31:11', '2018-05-09 22:31:15', 16),
(63, '@i4x7n3d7x2d2i5', '2018-05-09 23:00:59', '2018-05-09 23:01:08', 16),
(64, '@c6k1a4r6h9n2p7', '2018-05-09 23:01:28', '2018-05-09 23:01:36', 16),
(65, '@h1c2n2l7b4c7x6', '2018-05-09 23:03:01', '2018-05-09 23:03:07', 16),
(66, '@r1m4u8i6p7z5z4', '2018-05-09 23:04:35', '2018-05-09 23:04:37', 16),
(67, '@e2k4y9x2b9r5r6', '2018-05-09 23:06:32', '2018-05-09 23:06:37', 16),
(68, '@g6n6s9h1x1g4p1', '2018-05-10 00:05:05', '2018-05-10 00:05:12', 16),
(69, '@f3k9p8f8z2z4b3', '2018-05-10 00:06:29', '2018-05-10 00:06:33', 16),
(70, '@m6c4c7t4w8y6m8', '2018-05-10 00:09:06', '2018-05-10 00:09:12', 16),
(71, '@f7x7d2t3r5s8f5', '2018-05-10 00:15:01', '2018-05-10 00:15:04', 16),
(72, '@k2y2o6p8d4b7v6', '2018-05-10 00:22:03', '2018-05-10 00:22:39', 16),
(73, '@l6z3c3e4c8n4s9', '2018-05-10 00:24:42', '2018-05-10 00:24:44', 18),
(74, '@b1w1c8p3a2z7b7', '2018-05-10 00:25:11', '2018-05-10 00:25:17', 19),
(75, '@u8w1r7w5i3k5r1', '2018-05-10 00:25:49', '2018-05-10 00:26:04', 16),
(76, '@a3h6h3l2z7n1y2', '2018-05-10 00:28:31', '2018-05-10 00:29:09', 16),
(77, '@f9g9y5s2r3b9v9', '2018-05-10 01:01:27', '2018-05-10 01:03:04', 19),
(78, '@s9t3u5n1s4a2y3', '2018-05-11 03:14:12', '2018-05-11 03:14:16', 16),
(79, '@g3g1y1u9p7d9n3', '2018-05-11 03:15:57', '2018-05-11 03:17:35', 16),
(80, '@n3w1l5y3p9o3x5', '2018-05-11 03:24:19', '2018-05-11 03:25:07', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test`
--

CREATE TABLE `test` (
  `pk_test` int(11) NOT NULL,
  `tiempo_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tiempo_final` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `fk_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `pk_usuario` int(11) NOT NULL,
  `nick` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `pass` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `acceso` varchar(20) COLLATE latin1_spanish_ci NOT NULL DEFAULT 'alumno',
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_registro` date NOT NULL,
  `estado` varchar(20) COLLATE latin1_spanish_ci NOT NULL DEFAULT 'offline'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`pk_usuario`, `nick`, `pass`, `acceso`, `nombre`, `apellidos`, `dni`, `email`, `fecha_registro`, `estado`) VALUES
(1, 'GUEST', 'guest_password', 'GUEST', 'GUEST', 'GUEST', 'GUEST', 'GUEST', '2018-05-11', 'inaccesible'),
(16, 'Adan77', '3488e28acfe4abe097e1f4d501d4b49a', 'administrador', 'Adan', 'Jarillo Merida', '51512452l', 'adan@adan.com', '2018-04-20', 'offline'),
(17, 'Joselito', '3488e28acfe4abe097e1f4d501d4b49a', 'alumno', 'Adan', 'Jarillo Merida', '00000001r', 'fuck@gmail.com', '2018-04-24', 'offline'),
(18, 'Test', '3488e28acfe4abe097e1f4d501d4b49a', 'profesor', 'Adan', 'Jarillo Merida', '54341263Z', 'fuck@fuck.lol', '2018-04-25', 'offline'),
(19, 'Dev1', '3488e28acfe4abe097e1f4d501d4b49a', 'desarrollador', 'Adan', 'Tojeiro Jarillo', '99999999r', 'dev@dev.dev', '2018-04-29', 'offline');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`pk_consulta`),
  ADD KEY `fk_usuario` (`fk_usuario`);

--
-- Indices de la tabla `enuncian`
--
ALTER TABLE `enuncian`
  ADD KEY `fk_pregunta` (`fk_pregunta`),
  ADD KEY `fk_test` (`fk_test`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`pk_pregunta`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`pk_respuesta`),
  ADD KEY `fk_pregunta` (`fk_pregunta`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`pk_sesion`),
  ADD KEY `fk_usuario` (`fk_usuario`);

--
-- Indices de la tabla `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`pk_test`),
  ADD KEY `fk_sesion` (`fk_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`pk_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consulta`
--
ALTER TABLE `consulta`
  MODIFY `pk_consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `pk_pregunta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `pk_respuesta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `pk_sesion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de la tabla `test`
--
ALTER TABLE `test`
  MODIFY `pk_test` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `pk_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`pk_usuario`);

--
-- Filtros para la tabla `enuncian`
--
ALTER TABLE `enuncian`
  ADD CONSTRAINT `enuncian_ibfk_1` FOREIGN KEY (`fk_pregunta`) REFERENCES `pregunta` (`pk_pregunta`),
  ADD CONSTRAINT `enuncian_ibfk_2` FOREIGN KEY (`fk_test`) REFERENCES `test` (`pk_test`);

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`fk_pregunta`) REFERENCES `pregunta` (`pk_pregunta`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `sesion_ibfk_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`pk_usuario`);

--
-- Filtros para la tabla `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`pk_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
