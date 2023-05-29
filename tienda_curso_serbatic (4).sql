-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2023 a las 18:06:33
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_curso_serbatic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `baja` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `baja`) VALUES
(1, 'Aventuras', 0),
(2, 'Animación', 0),
(3, 'Drama', 0),
(4, 'Ciencia ficción', 0),
(5, 'Acción', 0),
(6, 'Aviación', 1),
(7, 'Fantasia', 1),
(8, 'fantasia 2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
  `clave` varchar(255) NOT NULL,
  `valor` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`clave`, `valor`) VALUES
('CIF', 'A12345678'),
('Código Postal', '49001'),
('Dirección', 'C/Santa Clara 2'),
('Localidad', 'Zamora, España'),
('Nombre', 'Pelis Zamora'),
('Número Factura', '68');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `producto_id` int(11) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `preciounidad` double DEFAULT NULL,
  `impuesto` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id`, `pedido_id`, `producto_id`, `unidades`, `preciounidad`, `impuesto`, `total`) VALUES
(1, 1, 1, 2, 12.99, 0.21, 27.23),
(2, 1, 2, 1, 9.99, 0.21, 10.2),
(3, 2, 3, 3, 15.5, 0.21, 48.15),
(4, 3, 1, 1, 12.99, 0.21, 13.52),
(5, 3, 2, 2, 9.99, 0.21, 20.38),
(6, 11, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(7, 12, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(8, 13, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(9, 13, 3, 1, 12.5, 0.20999999344348907, 12.5),
(10, 14, 1, 2, 10.989999771118164, 0.20999999344348907, 21.979999542236328),
(11, 14, 4, 5, 11.989999771118164, 0.20999999344348907, 59.94999885559082),
(12, 14, 5, 3, 9.5, 0.20999999344348907, 28.5),
(13, 15, 3, 3, 12.5, 0.20999999344348907, 37.5),
(14, 16, 2, 3, 8.989999771118164, 0.20999999344348907, 26.969999313354492),
(15, 17, 1, 4, 10.989999771118164, 0.20999999344348907, 43.959999084472656),
(16, 18, 5, 1, 9.5, 0.20999999344348907, 9.5),
(17, 19, 4, 1, 11.989999771118164, 0.20999999344348907, 11.989999771118164),
(18, 20, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(19, 21, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(20, 22, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(21, 23, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(22, 24, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(23, 25, 3, 1, 12.5, 0.20999999344348907, 12.5),
(24, 26, 4, 9, 11.989999771118164, 0.20999999344348907, 107.90999794006348),
(25, 27, 3, 1, 12.5, 0.20999999344348907, 12.5),
(26, 28, 3, 1, 12.5, 0.20999999344348907, 12.5),
(27, 29, 3, 1, 12.5, 0.20999999344348907, 12.5),
(28, 30, 3, 1, 12.5, 0.20999999344348907, 12.5),
(29, 31, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(30, 32, 1, 2, 10.989999771118164, 0.20999999344348907, 21.979999542236328),
(31, 32, 2, 3, 8.989999771118164, 0.20999999344348907, 26.969999313354492),
(32, 32, 3, 1, 12.5, 0.20999999344348907, 12.5),
(33, 32, 5, 3, 9.5, 0.20999999344348907, 28.5),
(34, 33, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(35, 33, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(36, 33, 3, 1, 12.5, 0.20999999344348907, 12.5),
(37, 34, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(38, 35, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(39, 36, 3, 1, 12.5, 0.20999999344348907, 12.5),
(40, 37, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(41, 38, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164),
(42, 39, 1, 1, 10.989999771118164, 0.20999999344348907, 10.989999771118164),
(43, 40, 3, 1, 12.5, 0.20999999344348907, 12.5),
(44, 41, 2, 1, 8.989999771118164, 0.20999999344348907, 8.989999771118164);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `metodopago` varchar(255) DEFAULT NULL,
  `numfactura` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `usuario_id`, `fecha`, `metodopago`, `numfactura`, `estado`, `total`) VALUES
(1, 1, '2023-04-28 14:30:00', 'Tarjeta de crédito', '03/05/2023/001', 'E', 42.5),
(2, 2, '2023-04-27 10:00:00', 'PayPal', '03/05/2023/002', 'E', 18.99),
(3, 3, '2023-04-29 12:45:00', 'Transferencia bancaria', '03/05/2023/003', 'E', 33),
(11, 6, '2023-05-09 18:12:20', 'paypal', '20/05/23/0018', 'E', 10.989999771118164),
(12, 5, '2023-05-10 14:52:23', 'tarjeta', '20/05/23/0019', 'E', 10.989999771118164),
(13, 4, '2023-05-10 17:12:50', 'paypal', '10/05/23/007', 'C', 21.489999771118164),
(14, 4, '2023-05-10 18:38:07', 'paypal', '20/05/23/0043', 'E', 110.42999267578125),
(15, 4, '2023-05-11 15:02:04', 'paypal', '11/05/23', 'C', 37.5),
(16, 4, '2023-05-11 15:03:25', 'tarjeta', '20/05/23/0020', 'E', 26.969999313354492),
(17, 4, '2023-05-11 15:04:29', 'paypal', '20/05/23/0021', 'E', 43.959999084472656),
(18, 4, '2023-05-11 15:08:13', 'tarjeta', '20/05/23/0022', 'E', 9.5),
(19, 4, '2023-05-11 15:09:36', 'tarjeta', '20/05/23/0023', 'E', 11.989999771118164),
(20, 4, '2023-05-11 15:10:19', 'paypal', '20/05/23/0024', 'E', 10.989999771118164),
(21, 4, '2023-05-11 15:11:14', 'tarjeta', '20/05/23/0038', 'E', 8.989999771118164),
(22, 4, '2023-05-11 15:13:28', 'paypal', '20/05/23/0040', 'E', 8.989999771118164),
(23, 4, '2023-05-11 15:24:49', 'tarjeta', '20/05/23/0041', 'E', 8.989999771118164),
(24, 4, '2023-05-11 15:25:23', 'paypal', '20/05/23/0044', 'E', 10.989999771118164),
(25, 4, '2023-05-11 15:28:11', 'paypal', '20/05/23/0046', 'E', 12.5),
(26, 4, '2023-05-11 16:00:00', 'paypal', '20/05/23/0047', 'E', 107.90999603271484),
(27, 4, '2023-05-11 16:16:43', 'tarjeta', '20/05/23/0048', 'E', 12.5),
(28, 4, '2023-05-11 16:19:19', 'paypal', '20/05/23/0049', 'E', 12.5),
(29, 4, '2023-05-16 18:52:13', 'tarjeta', '20/05/23/0045', 'E', 12.5),
(30, 4, '2023-05-18 11:02:17', 'paypal', '20/05/23/0042', 'E', 12.5),
(31, 4, '2023-05-18 11:03:58', 'tarjeta', '20/05/23/0039', 'E', 10.989999771118164),
(32, 8, '2023-05-20 19:33:10', 'tarjeta', '21/05/23/0060', 'E', 89.94999694824219),
(33, 8, '2023-05-20 20:39:09', 'tarjeta', '20/05/23/0057', 'E', 32.47999954223633),
(34, 8, '2023-05-20 20:39:14', 'tarjeta', '20/05/23/0058', 'E', 10.989999771118164),
(35, 8, '2023-05-21 12:02:16', 'tarjeta', '22/05/23/0064', 'E', 8.989999771118164),
(36, 8, '2023-05-21 12:13:37', 'paypal', '22/05/23/0065', 'E', 12.5),
(37, 8, '2023-05-21 12:17:36', 'paypal', '22/05/23/0066', 'E', 10.989999771118164),
(38, 8, '2023-05-21 12:31:15', 'tarjeta', '22/05/23/0067', 'E', 8.989999771118164),
(39, 8, '2023-05-21 12:49:33', 'tarjeta', '21/05/23/0061', 'E', 10.989999771118164),
(40, 8, '2023-05-21 15:58:53', 'paypal', '22/05/23/0063', 'E', 12.5),
(41, 8, '2023-05-21 16:14:23', 'paypal', '21/05/23/0062', 'PC', 8.989999771118164);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `impuesto` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `baja` tinyint(1) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `precio`, `impuesto`, `stock`, `baja`, `foto`, `categoria_id`) VALUES
(1, 'Sipderman 2', 'Película de marvel', 3.99, 0.21, 33, 0, 'p1', 1),
(2, 'Godzilla vs Kong', 'Película de ciencia ficción sobre monstruos', 8.989999771118164, 0.20999999344348907, 16, 0, 'p2', 4),
(3, 'V de Vendetta', 'Película sobre un enmascarado que lucha por la libertad de Inglaterra', 12.5, 0.20999999344348907, 7, 0, 'p3', 3),
(4, 'Star Wars: Episodio IV - Una nueva esperanza', 'Película de ciencia ficción y aventuras', 11.989999771118164, 0.20999999344348907, 0, 1, NULL, 4),
(5, 'Misión Imposible VI', 'Película de espias protagonizada por Tom Cruise', 9.5, 0.20999999344348907, 18, 0, 'p4', 5),
(6, 'El gato con botas', 'un gato con botas', 2, 0.21, 2, 1, NULL, 2),
(7, 'El gato con botas', 'un gato con botas', 2, 0.21, 2, 1, NULL, 2),
(8, 'Tres gatos con botas', 'Tres gatos que llevan botas', 12.5, 0.21, 20, 1, NULL, 6),
(9, 'transformers', 'a', 4, 0.21, 2, 1, NULL, 4),
(10, 'transformers 2', 'transformers 2', 12, 0.21, 1, 1, NULL, 1),
(11, 'transformers 3', 'transformers 3', 10.2, 0.21, 2, 1, NULL, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol`) VALUES
(1, 'usuario'),
(2, 'empleado'),
(3, 'Admin'),
(4, 'Anónimo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `baja` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `rol_id`, `email`, `clave`, `nombre`, `apellidos`, `baja`) VALUES
(1, 1, 'usuario1@example.com', 'clave123', 'Juan', 'Pérez', 0),
(2, 2, 'emp@emp.es', 'XGNAVPL+04lGwY4KxQI4Xg==', 'María', 'García', 0),
(3, 1, 'usuario3@example.com', 'clave789', 'Pedro', 'Rodríguez', 0),
(4, 1, 'a@a.es', 'XGNAVPL+04lGwY4KxQI4Xg==', 'a', 'a', 0),
(5, 1, 'aa@aa.es', 'XGNAVPL+04lGwY4KxQI4Xg==', 'a', 'a', 0),
(6, 1, 'daaa@daa.ess', 'xjXSRjwFHPddcDtRNplMjg==', 'daaaaaaa', 'daaaaaaaa', 0),
(7, 3, 'admin@admin.es', 'mVhFRorGWEhbyUpkRFdchw==', 'adminn', 'admin', 0),
(8, 2, 'danielmeringar@gmail.com', 'd', 'Daniela', 'Merino García', 0),
(9, 2, 'prueba1@prueba1.asd', '4mXippMX/8byMj2ofN8ESg==', 'prueba1', 'prueba1', 0),
(10, 2, 'a@a.es', 'ygfKMiH9B2RKVGc0cKqKUA==', 'a', 'a', 0),
(11, 2, 'asd@a.a', 'tRIj3L6TVUvEQFDuedCp3A==', 'asd', 'asd', 0),
(12, 2, '', 'lyORz/nmPJSMd+uk0FcJhA==', '', '', 0),
(13, 2, 'prueba4@g.es', 'RvXAPAKbC4vK3yrYbqUfbQ==', 'prueba', 'prueba2', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`clave`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pedido_id` (`pedido_id`),
  ADD KEY `producto_id` (`producto_id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria_id` (`categoria_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_rol` (`rol_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  ADD CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
