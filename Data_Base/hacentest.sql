-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2018 a las 13:35:28
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
(4, '2018-05-13 03:44:11', 'Consulta 4 eqweqweqw eqwere rtewtwret ytytyd asda', 'Consulta realizada desde una sesion de administrador', 16),
(5, '2018-05-11 03:25:45', 'Consulta 5', 'Consulta de prueda en una sesion de invitado tras cerrar otra sesion ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enuncian`
--

CREATE TABLE `enuncian` (
  `fk_test` int(11) NOT NULL,
  `fk_pregunta` int(11) NOT NULL,
  `respuesta` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `correcto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `enuncian`
--

INSERT INTO `enuncian` (`fk_test`, `fk_pregunta`, `respuesta`, `correcto`) VALUES
(1, 18, 'a', 1),
(1, 37, 'a', 1),
(1, 8, 'a', 0),
(1, 13, 'a', 0),
(1, 17, 'a', 0),
(1, 12, 'a', 0),
(1, 19, 'a', 1),
(1, 10, 'a', 0),
(1, 30, 'a', 1),
(1, 35, 'a', 1),
(1, 9, 'a', 1),
(1, 16, 'a', 0),
(1, 24, 'a', 0),
(1, 22, 'a', 0),
(1, 26, 'a', 0),
(1, 14, 'a', 0),
(1, 15, 'a', 0),
(1, 23, 'a', 0),
(1, 25, 'a', 0),
(1, 31, 'a', 0),
(1, 21, 'a', 1),
(1, 36, 'a', 1),
(1, 11, 'a', 0),
(1, 34, 'a', 0),
(1, 27, 'a', 1),
(1, 20, 'a', 0),
(1, 33, 'a', 0),
(1, 32, 'a', 0),
(1, 29, 'a', 0),
(1, 28, 'a', 0),
(2, 11, 'a', 0),
(2, 20, 'a', 0),
(2, 16, 'a', 0),
(2, 21, 'a', 1),
(2, 30, 'a', 1),
(2, 26, 'a', 0),
(2, 8, 'a', 0),
(2, 9, 'a', 1),
(2, 34, 'a', 0),
(2, 25, 'a', 0),
(2, 36, 'a', 1),
(2, 27, 'a', 1),
(2, 14, 'a', 0),
(2, 17, 'a', 0),
(2, 12, 'a', 0),
(2, 10, 'a', 0),
(2, 28, 'a', 0),
(2, 19, 'a', 1),
(2, 35, 'a', 1),
(2, 13, 'a', 0),
(2, 23, 'a', 0),
(2, 31, 'a', 0),
(2, 22, 'a', 0),
(2, 37, 'a', 1),
(2, 15, 'a', 0),
(2, 24, 'a', 0),
(2, 32, 'a', 0),
(2, 18, 'a', 1),
(2, 29, 'a', 0),
(2, 33, 'a', 0),
(3, 8, 'a', 0),
(3, 21, 'a', 1),
(3, 25, 'a', 0),
(3, 17, 'a', 0),
(3, 16, 'a', 0),
(3, 11, 'a', 0),
(3, 12, 'a', 0),
(3, 10, 'a', 0),
(3, 33, 'a', 0),
(3, 31, 'a', 0),
(3, 14, 'a', 0),
(3, 24, 'a', 0),
(3, 15, 'a', 0),
(3, 26, 'a', 0),
(3, 30, 'a', 1),
(3, 28, 'a', 0),
(3, 27, 'a', 1),
(3, 32, 'a', 0),
(3, 23, 'a', 0),
(3, 9, 'a', 1),
(3, 29, 'a', 0),
(3, 37, 'a', 1),
(3, 34, 'a', 0),
(3, 19, 'a', 1),
(3, 13, 'a', 0),
(3, 22, 'a', 0),
(3, 20, 'a', 0),
(3, 35, 'a', 1),
(3, 36, 'a', 1),
(3, 18, 'a', 1),
(4, 28, 'a', 0),
(4, 8, 'a', 0),
(4, 10, 'a', 0),
(4, 17, 'a', 0),
(4, 16, 'a', 0),
(4, 25, 'a', 0),
(4, 37, 'a', 1),
(4, 34, 'a', 0),
(4, 22, 'a', 0),
(4, 20, 'a', 0),
(4, 31, 'a', 0),
(4, 15, 'a', 0),
(4, 21, 'a', 1),
(4, 27, 'a', 1),
(4, 33, 'a', 0),
(4, 14, 'a', 0),
(4, 35, 'a', 1),
(4, 23, 'a', 0),
(4, 30, 'a', 1),
(4, 9, 'a', 1),
(4, 24, 'a', 0),
(4, 19, 'a', 1),
(4, 12, 'a', 0),
(4, 18, 'a', 1),
(4, 32, 'a', 0),
(4, 11, 'a', 0),
(4, 13, 'a', 0),
(4, 29, 'a', 0),
(4, 26, 'a', 0),
(4, 36, 'a', 1),
(5, 33, 'b', 1),
(5, 36, 'c', 0),
(5, 11, 'a', 0),
(5, 21, 'c', 0),
(5, 37, 'b', 0),
(5, 19, 'a', 1),
(5, 24, 'b', 1),
(5, 25, 'c', 0),
(5, 16, 'a', 0),
(5, 31, 'b', 1),
(5, 27, 'c', 0),
(5, 18, 'b', 0),
(5, 15, 'a', 0),
(5, 26, 'b', 1),
(5, 22, 'c', 0),
(5, 13, 'a', 0),
(5, 10, 'b', 0),
(5, 29, 'c', 0),
(5, 20, 'a', 0),
(5, 35, 'b', 0),
(5, 9, 'c', 0),
(5, 23, 'c', 1),
(5, 30, 'b', 0),
(5, 28, 'a', 0),
(5, 14, 'b', 0),
(5, 32, 'c', 1),
(5, 17, 'b', 1),
(5, 8, 'a', 0),
(5, 34, 'b', 1),
(5, 12, 'b', 1),
(6, 9, 'a', 1),
(6, 29, 'a', 0),
(6, 10, 'a', 0),
(6, 28, 'a', 0),
(6, 26, 'a', 0),
(6, 13, 'a', 0),
(6, 8, 'a', 0),
(6, 27, 'a', 1),
(6, 19, 'a', 1),
(6, 34, 'a', 0),
(6, 25, 'a', 0),
(6, 15, 'a', 0),
(6, 31, 'a', 0),
(6, 11, 'a', 0),
(6, 12, 'a', 0),
(6, 21, 'a', 1),
(6, 36, 'a', 1),
(6, 16, 'a', 0),
(6, 14, 'a', 0),
(6, 35, 'a', 1),
(6, 30, 'a', 1),
(6, 17, 'a', 0),
(6, 32, 'b', 0),
(6, 23, 'b', 0),
(6, 24, 'b', 1),
(6, 33, 'a', 0),
(6, 22, 'a', 0),
(6, 20, 'a', 0),
(6, 37, 'b', 0),
(6, 18, 'b', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `pk_pregunta` int(11) NOT NULL,
  `enunciado` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `indice_correcto` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_pregunta` varchar(15) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`pk_pregunta`, `enunciado`, `indice_correcto`, `codigo_pregunta`) VALUES
(8, 'El chaleco reflectante. ¿Cuándo es obligatorio ponérselo?', 'c', '#y9u3s8x5m7z5d7'),
(9, 'Los Agentes de la autoridad y el personal de obras, ¿están obligados a utilizar dispositivos retrorreflectantes que permitan distinguirlos a una distancia mínima de 150 metros?', 'a', '#f9s6m1z7u4w1y9'),
(10, 'Cuando un carril está delimitado a ambos lados por doble línea discontinua, ¿qué deben hacer los conductores?', 'c', '#d8s8u6p9r1n8n9'),
(11, 'Ciclo es el vehículo de...', 'c', '#k3s7c4z2z7t5x7'),
(12, '¿Qué pasa cuando se deja el chaleco reflectante expuesto a la luz?', 'b', '#k2c6r4a1c7o1s4'),
(13, 'Al realizar una maniobra que requiere un desplazamiento lateral, ¿cómo debe señalizarse?', 'c', '#f2r9o6s6u5v6z4'),
(14, 'En una parada de autobús señalizada, ¿qué está prohibido?', 'c', '#o4f4a3y1l3i9s7'),
(15, 'Un menor de más de 14 años que circula conduciendo una bicicleta, ¿puede hacerlo por una autovía?', 'c', '#v9k2z5o9s4g6n9'),
(16, '¿Se considera adelantamiento si los vehículos de un carril circulan más rápido que los del otro?', 'c', '#f1l2r1x5h7i3d3'),
(17, 'Si el sistema de navegación del GPS es portátil, ¿qué es recomendable?', 'b', '#d1m9v8f2k1x8l2'),
(18, '¿Está permitido colocar los triángulos de preseñalización de peligro a menos de 50 metros del vehículo averiado?', 'a', '#h8k3s7s5w5s7y8'),
(19, 'En una autovía hay una persona haciendo autostop. ¿Está permitido recogerla?', 'a', '#f7g8c6p4s2l3p6'),
(20, 'El conductor de un vehículo inmovilizado en la calzada o arcén de una vía, entre la puesta y la salida del sol, está obligado a...', 'c', '#c6f4p4i7o5c9f6'),
(21, 'El automóvil destinado al transporte de mercancías cuya cabina está integrada en el resto de la carrocería, con masa máxima autorizada igual o inferior a 3.500 kg., es...', 'a', '#l1x2i5b8p1e4x2'),
(22, 'El conductor de una motocicleta, ¿tiene permitido realizar una parada en un carril reservado para autobuses?', 'b', '#o8g5h2x1s5l6t3'),
(23, 'Si queda detenido en el interior de un túnel más de dos minutos...', 'c', '#b3r4b1b7n8x8d5'),
(24, '¿Puede adelantar por la derecha en una autopista?', 'b', '#z6h1t7x6w6g9v3'),
(25, 'Excepcionalmente, y en condiciones de seguridad, en vías que no sean autopistas o autovías, ¿se permite el arrastre de un vehículo por otro no destinado a este fin?', 'b', '#g1t1g2g3u5t5p1'),
(26, 'Al incorporarse a la autopista por el carril de aceleración, debe...', 'b', '#u6o3h4n9w5g2z5'),
(27, '¿Qué peligro es el más frecuente al usar el teléfono móvil durante la conducción?', 'a', '#i7y6k8i8b2w9t3'),
(28, 'Las señales acústicas deben ser...', 'b', '#k6o5v8p6i9d1y4'),
(29, 'Los conductores de turismos deben utilizar el chaleco reflectante de alta visibilidad...', 'b', '#w6o7u8h9h6s3a9'),
(30, '¿Los ciclomotores pueden circular en columna de a dos?', 'a', '#f5g3d8f7o6c7d2'),
(31, 'Se considera que una parada o estacionamiento obstaculiza gravemente la circulación cuando...', 'b', '#h6x6d2m8o2e7d3'),
(32, '¿Cómo debe realizarse un cambio de carril en una vía saturada?', 'c', '#r8y4p1r2o5u1d2'),
(33, 'En vías de tres calzadas, se utilizará la calzada central...', 'b', '#s2x9b4g5f6v3u7'),
(34, 'Queda prohibido parar en...', 'b', '#w5m3n4n9d2p1k9'),
(35, 'Está prohibido adelantar en...', 'a', '#m2a6r4s9d6p2b3'),
(36, '¿Es obligatorio llevar en un turismo un chaleco reflectante para el acompañante?', 'a', '#m4o6r3h6w5t5a6'),
(37, 'Está prohibido adelantar en...', 'a', '#i5d5l8b8k5c9s2');

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

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`pk_respuesta`, `texto`, `indice`, `fk_pregunta`) VALUES
(16, 'Cuando salgo del vehículo en vías urbanas.', 'a', 8),
(17, 'Cuando salgo del vehículo en autopistas y autovías solamente.', 'b', 8),
(18, 'Cuando salgo del vehículo en vías interurbanas.', 'c', 8),
(19, 'Sí, siempre.', 'a', 9),
(20, 'Sí, pero sólo de noche.', 'b', 9),
(21, 'No.', 'c', 9),
(22, 'Utilizarlo sólo para adelantar a una velocidad máxima de 80 kilómetros por hora.', 'a', 10),
(23, 'No circular por él porque la circulación está prohibida.', 'b', 10),
(24, 'Entre otras normas, si la circulación está regulada por semáforos de carril, obedecer sus indicaciones.', 'c', 10),
(25, 'dos ruedas accionado con un motor.', 'a', 11),
(26, 'dos o más ruedas accionado con un motor o con pedales.', 'b', 11),
(27, 'dos ruedas por lo menos, accionado por su conductor mediante pedales o manivelas.', 'c', 11),
(28, 'Nada, la luz no daña el material.', 'a', 12),
(29, 'Que pierde sus propiedades reflectantes.', 'b', 12),
(30, 'Que cambia de color, aunque mantiene sus propiedades reflectantes.', 'c', 12),
(31, 'Únicamente con las luces intermitentes.', 'a', 13),
(32, 'Únicamente con el brazo.', 'b', 13),
(33, 'Con las luces intermitentes hasta adoptar la nueva trayectoria o con el brazo.', 'c', 13),
(34, 'Adelantar cerca de ella.', 'a', 14),
(35, 'Circular sobre ella.', 'b', 14),
(36, 'Estacionar.', 'c', 14),
(37, 'No, está prohibido.', 'a', 15),
(38, 'Sí, y también pueden circular por las autopistas.', 'b', 15),
(39, 'Sí, excepto que por seguridad, esté prohibido mediante señal.', 'c', 15),
(40, 'Sí.', 'a', 16),
(41, 'Sí, si los vehículos cambian de carril.', 'b', 16),
(42, 'No.', 'c', 16),
(43, 'Intentar colocarlo cerca de un airbag.', 'a', 17),
(44, 'Distribuir los cables de manera que no entorpezcan la conducción.', 'b', 17),
(45, 'Seguir siempre las instrucciones del dispositivo, frente al juicio del conductor.', 'c', 17),
(46, 'No.', 'a', 18),
(47, 'No, deben estar al menos a 100 metros.', 'b', 18),
(48, 'Sí, a esa distancia ya son visibles.', 'c', 18),
(49, 'No.', 'a', 19),
(50, 'Sí.', 'b', 19),
(51, 'Sí, si está transitando por el arcén de la derecha.', 'c', 19),
(52, 'apagar el alumbrado para evitar el desgaste de la batería.', 'a', 20),
(53, 'mantener encendidas siempre las luces de emergencia.', 'b', 20),
(54, 'mantener encendidas las luces de posición.', 'c', 20),
(55, 'una furgoneta.', 'a', 21),
(56, 'un camión.', 'b', 21),
(57, 'un tractocamión.', 'c', 21),
(58, 'Parar sí, estacionar no.', 'a', 22),
(59, 'No, está prohibido', 'b', 22),
(60, 'Sí, si no obstaculiza la circulación de autobuses y taxis.', 'c', 22),
(61, 'debe encender las luces de emergencia.', 'a', 23),
(62, 'debe apagar el motor y las luces.', 'b', 23),
(63, 'debe apagar el motor y dejar el alumbrado de posición encendido.', 'c', 23),
(64, 'Sí, a un vehículo que circula a una velocidad reducida.', 'a', 24),
(65, 'No.', 'b', 24),
(66, 'Sí, si no se supera la velocidad máxima permitida.', 'c', 24),
(67, 'No', 'a', 25),
(68, 'Sí, pero sólo hasta el lugar más próximo donde pueda quedar convenientemente inmovilizado.', 'b', 25),
(69, 'Sí, siempre que no se recorran más de 10 kilómetros.', 'c', 25),
(70, 'disminuir la velocidad y detenerse al final del carril, obligatoriamente.', 'a', 26),
(71, 'acelerar hasta alcanzar la velocidad adecuada al final del carril.', 'b', 26),
(72, 'acelerar hasta alcanzar obligatoriamente 120 km/h al final del carril.', 'c', 26),
(73, 'El desvío de la trayectoria del vehículo.', 'a', 27),
(74, 'Saltarse una salida.', 'b', 27),
(75, 'Equivocarse en el cambio de marchas.', 'c', 27),
(76, 'de sonido muy agudo.', 'a', 28),
(77, 'de sonido no estridente.', 'b', 28),
(78, 'de sonido grave y con la suficiente intensidad para ser escuchadas por todos los usuarios de la vía.', 'c', 28),
(79, 'siempre que salgan del vehículo.', 'a', 29),
(80, 'cuando salgan del vehículo y ocupen la calzada o el arcén de una vía interurbana.', 'b', 29),
(81, 'cuando salgan del vehículo y ocupen la calzada o el arcén en cualquier vía.', 'c', 29),
(82, 'Sí, excepcionalmente, cuando el arcén sea transitable y suficiente.', 'a', 30),
(83, 'No, nunca.', 'b', 30),
(84, 'Sí, siempre.', 'c', 30),
(85, 'se realiza en una vía pública calificada de atención preferente.', 'a', 31),
(86, 'se obstaculiza la utilización normal de los pasos rebajados para disminuidos físicos.', 'b', 31),
(87, 'se efectúa en doble fila.', 'c', 31),
(88, 'Utilizando el arcén.', 'a', 32),
(89, 'Realizando la maniobra rápidamente para no estorbar.', 'b', 32),
(90, 'Advirtiéndolo con suficiente antelación.', 'c', 32),
(91, 'en un único sentido, solamente', 'a', 33),
(92, 'en uno o dos sentidos, según la situación.', 'b', 33),
(93, 'para realizar los adelantamientos precisos.', 'c', 33),
(94, 'las curvas y cambios de rasante.', 'a', 34),
(95, 'los tramos de vías afectados por la señal túnel.', 'b', 34),
(96, 'todas las vías interurbanas.', 'c', 34),
(97, 'todo lugar en que la visibilidad no sea suficiente.', 'a', 35),
(98, 'todas las curvas y cambios de rasante.', 'b', 35),
(99, 'todas las intersecciones.', 'c', 35),
(100, 'No.', 'a', 36),
(101, 'No, el chaleco reflectante no es obligatorio para los turismos.', 'b', 36),
(102, 'Sí, ya que deberá ponérselo si sale del vehículo y ocupa la calzada en una vía interurbana.', 'c', 36),
(103, 'las intersecciones con vías para ciclistas.', 'a', 37),
(104, 'las glorietas.', 'b', 37),
(105, 'todas las intersecciones aunque la señalización lo permita.', 'c', 37);

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
(80, '@n3w1l5y3p9o3x5', '2018-05-11 03:24:19', '2018-05-11 03:25:07', 16),
(81, '@u3d6l9h2t1p8t7', '2018-05-13 03:00:25', '2018-05-13 03:02:45', 19),
(82, '@k5w8i9r2u8z5t8', '2018-05-13 03:02:57', '0000-00-00 00:00:00', 19),
(83, '@i6h2b7x4m7x3p4', '2018-05-13 03:10:57', '2018-05-13 03:11:56', 19),
(84, '@c6m2w8r5h2s8u4', '2018-05-13 03:13:00', '0000-00-00 00:00:00', 19),
(85, '@t9g4r8h6f6k8c7', '2018-05-13 03:19:15', '2018-05-13 03:20:33', 19),
(86, '@o2c8k6u5c4s3y7', '2018-05-13 03:27:33', '2018-05-13 03:27:54', 19),
(87, '@c1a6s6g2e1m9o3', '2018-05-13 03:29:31', '2018-05-13 03:30:04', 19),
(88, '@n1x7c4m2k8f8p5', '2018-05-13 03:32:55', '2018-05-13 03:33:26', 19),
(89, '@x3o9d1x3k6r8u3', '2018-05-13 03:34:17', '2018-05-13 03:35:31', 19),
(90, '@i3v1g7e2f6m4m9', '2018-05-13 03:35:43', '2018-05-13 03:36:16', 19),
(91, '@t6m4k7o8e1a1i8', '2018-05-13 03:36:50', '2018-05-13 03:37:33', 19),
(92, '@i9p4y3v6k9y4s5', '2018-05-13 03:38:23', '2018-05-13 03:39:52', 19),
(93, '@t4x3t8d6o9i2c7', '2018-05-13 03:40:03', '2018-05-13 03:42:13', 19),
(94, '@e9d5i1v8c1g1r5', '2018-05-13 03:42:32', '2018-05-13 03:42:47', 19),
(95, '@m2d7p9y6k1p7a9', '2018-05-13 03:43:07', '2018-05-13 03:46:02', 19),
(96, '@t2z3k9i8a7m9w4', '2018-05-13 03:48:06', '2018-05-13 03:48:56', 19),
(97, '@y3n1z3m2d8i8v2', '2018-05-13 18:19:32', '2018-05-13 18:21:08', 19),
(98, '@y2g6k4b6a8w2n8', '2018-05-13 18:21:18', '2018-05-13 18:38:27', 19),
(99, '@z4k9l3d6r5u8w5', '2018-05-15 03:10:38', '2018-05-15 03:15:53', 19),
(100, '@v2k8k3i2m9n8k1', '2018-05-15 03:16:09', '2018-05-15 03:16:45', 19),
(101, '@t3p1k4s5l2l6k8', '2018-05-15 03:17:47', '2018-05-15 03:18:42', 19),
(102, '@o6x6v8s7l5c5t2', '2018-05-15 03:20:01', '2018-05-15 03:33:27', 19),
(103, '@a4r1c4g2o1g4v2', '2018-05-15 03:33:40', '2018-05-15 03:34:08', 19),
(104, '@p3e9i4i3o1k9p4', '2018-05-15 03:34:33', '2018-05-15 03:34:59', 19),
(105, '@s7m9u9e2p2t5c3', '2018-05-15 15:08:25', '2018-05-15 15:24:30', 19),
(106, '@x5n4l5i2c9h2d8', '2018-05-15 15:25:35', '2018-05-15 15:27:10', 19),
(107, '@i8x7z2z4n7v1b8', '2018-05-15 15:32:31', '2018-05-15 15:36:46', 19),
(108, '@n1s9g8b2m4m5r1', '2018-05-15 15:37:05', '2018-05-15 15:39:20', 19),
(109, '@w8s4k8m2k8o5p7', '2018-05-15 15:39:32', '0000-00-00 00:00:00', 19),
(110, '@s3o7a1h7k1a8t6', '2018-05-15 15:42:31', '2018-05-15 16:41:02', 19),
(111, '@z3z5g1n7l7i3h2', '2018-05-15 21:45:07', '2018-05-15 21:45:25', 19),
(112, '@c4c5o6k4s3x3s2', '2018-05-15 21:46:32', '2018-05-15 21:46:40', 19),
(113, '@o6u2z5u5h9n5v8', '2018-05-15 21:48:18', '2018-05-15 21:49:33', 19),
(114, '@b8a8n8s5f8p8v1', '2018-05-15 21:49:45', '0000-00-00 00:00:00', 19),
(115, '@l9l4e1s2d6i1k5', '2018-05-15 21:51:37', '2018-05-15 21:55:32', 19),
(116, '@d9t4v9b8w5m3b5', '2018-05-15 21:55:51', '2018-05-15 21:56:59', 19),
(117, '@y4o8d6x7k5s7g9', '2018-05-15 21:57:15', '2018-05-15 21:59:01', 19),
(118, '@x1p3f8b3s8v9u8', '2018-05-15 22:00:36', '2018-05-15 22:08:09', 19),
(119, '@c7z7g9c5z1y8z4', '2018-05-15 22:15:34', '2018-05-15 22:16:40', 19),
(120, '@s5a5k6n9b2b1v7', '2018-05-15 22:50:58', '2018-05-15 22:55:32', 19),
(121, '@o4z1x8k3i2p6s4', '2018-05-15 22:55:48', '2018-05-15 22:56:36', 19),
(122, '@w5y7k3r9t2m7w7', '2018-05-15 23:27:56', '2018-05-15 23:30:20', 19),
(123, '@f4d4y7r2n3p2g1', '2018-05-15 23:31:10', '2018-05-15 23:31:56', 19),
(124, '@w6g7g2w5v8k2d8', '2018-05-15 23:32:28', '2018-05-15 23:33:12', 19),
(125, '@l2x9b7n9w2o1h3', '2018-05-15 23:33:52', '2018-05-15 23:35:26', 19),
(126, '@e6y5m8d8y2k1e8', '2018-05-15 23:38:16', '2018-05-15 23:39:40', 19),
(127, '@z7h4m5t1k2a3p6', '2018-05-15 23:42:55', '2018-05-16 00:03:15', 19),
(128, '@a3s5h3k2y4e6u8', '2018-05-16 00:05:17', '0000-00-00 00:00:00', 19),
(129, '@b5d1k7v7d7m4o4', '2018-05-16 00:13:07', '0000-00-00 00:00:00', 19),
(130, '@u9m8z2x9n7k9a7', '2018-05-16 00:27:11', '0000-00-00 00:00:00', 19),
(131, '@n4v4k9k4s3t1e9', '2018-05-16 00:47:07', '2018-05-16 00:48:31', 19),
(132, '@k7e1m1e3v7a2z7', '2018-05-16 00:48:25', '2018-05-16 00:48:29', 16),
(133, '@k8b2h3k9t9h7n3', '2018-05-16 00:57:46', '0000-00-00 00:00:00', 19),
(134, '@t4y1w6t9l9b5b1', '2018-05-17 20:01:17', '2018-05-17 20:01:46', 19),
(135, '@w6x3w8p7a6x7a6', '2018-05-17 20:02:57', '2018-05-17 20:04:26', 19),
(136, '@s6p3f4y2l8m1k7', '2018-05-17 20:04:38', '2018-05-17 20:05:31', 19),
(137, '@y4u6s7u7h9g7n1', '2018-05-17 20:05:43', '2018-05-17 20:07:49', 19),
(138, '@z8g9i7o4v7h7a4', '2018-05-17 20:55:16', '2018-05-17 20:55:56', 19),
(139, '@c2e4v3e6l2c1e5', '2018-05-17 20:57:11', '2018-05-17 21:03:03', 19),
(140, '@o1k6f9w7o9v9v6', '2018-05-18 13:42:06', '2018-05-18 13:42:22', 19),
(141, '@d4v6o8b8u4e9h8', '2018-05-18 13:57:47', '2018-05-18 14:00:46', 19),
(142, '@u7x2x1t1v9p7n3', '2018-05-18 14:00:59', '2018-05-18 14:02:57', 19),
(143, '@w1i3a1x8w9k1s6', '2018-05-18 14:08:37', '2018-05-18 14:09:44', 19),
(144, '@x5s8w4o4s4t3k1', '2018-05-18 16:52:12', '2018-05-18 16:52:19', 16),
(145, '@r8n8x2x5s9h3w6', '2018-05-18 16:56:53', '2018-05-18 16:57:11', 16),
(146, '@k3r8y8l7s6k5r2', '2018-05-18 16:57:23', '2018-05-18 16:58:17', 19),
(147, '@o8w6f9n4a6y4c4', '2018-05-18 17:06:06', '2018-05-18 17:07:14', 16),
(148, '@z1x8l5b2b7n3z5', '2018-05-30 11:04:18', '2018-05-30 11:05:40', 19),
(149, '@x5m1r5t7w6z6o4', '2018-05-30 11:06:30', '2018-05-30 11:31:45', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test`
--

CREATE TABLE `test` (
  `pk_test` int(11) NOT NULL,
  `tiempo_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tiempo_final` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fk_usuario` int(11) NOT NULL,
  `codigo_test` varchar(15) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `test`
--

INSERT INTO `test` (`pk_test`, `tiempo_inicio`, `tiempo_final`, `fk_usuario`, `codigo_test`) VALUES
(1, '2018-05-17 20:03:03', '2018-05-17 20:03:03', 19, '$m6e2g7f9p8a7n6'),
(2, '2018-05-17 20:04:42', '2018-05-17 20:04:42', 19, '$i1h7x7f5c9g8f1'),
(3, '2018-05-17 20:05:50', '2018-05-17 20:05:50', 19, '$i5c8o3e3r2v1t8'),
(4, '2018-05-17 20:55:34', '2018-05-17 20:55:34', 19, '$o8z6h1g1m7o6x2'),
(5, '2018-05-17 20:57:15', '2018-05-17 20:57:15', 19, '$i5h6u5f6u6d8w1'),
(6, '2018-05-17 20:57:37', '2018-05-17 20:57:37', 19, '$k7o7t8z9l3p4c8'),
(7, '2018-05-18 14:01:12', '2018-05-18 14:01:12', 19, '$m3l9y5c5u7y7n3'),
(8, '2018-05-18 14:08:47', '2018-05-18 14:08:47', 19, '$g2b5e9f4z7e1l4'),
(9, '2018-05-30 11:04:25', '2018-05-30 11:04:25', 19, '$u3x9k2x1k1d1h2');

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
  MODIFY `pk_pregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `pk_respuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `pk_sesion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=150;

--
-- AUTO_INCREMENT de la tabla `test`
--
ALTER TABLE `test`
  MODIFY `pk_test` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `pk_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

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
