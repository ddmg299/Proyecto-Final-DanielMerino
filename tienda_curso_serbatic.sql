-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-05-2023 a las 21:02:47
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
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Aventuras'),
(2, 'Animación'),
(3, 'Drama'),
(4, 'Ciencia ficción');

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
('Dirección', 'C/Santa clara 2'),
('Localidad', 'Zamora'),
('Nombre', 'Pelis Zamora'),
('Número Factura', '15');

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
(26, 28, 3, 1, 12.5, 0.20999999344348907, 12.5);

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
(1, 1, '2023-04-28 14:30:00', 'Tarjeta de crédito', '03/05/2023/001', 'PE', 42.5),
(2, 2, '2023-04-27 10:00:00', 'PayPal', '03/05/2023/002', 'PE', 18.99),
(3, 3, '2023-04-29 12:45:00', 'Transferencia bancaria', '03/05/2023/003', 'PE', 33),
(11, 6, '2023-05-09 18:12:20', 'paypal', '09/05/23/005', 'PE', 10.989999771118164),
(12, 5, '2023-05-10 14:52:23', 'tarjeta', '10/05/23/006', 'PE', 10.989999771118164),
(13, 4, '2023-05-10 17:12:50', 'paypal', '10/05/23/007', 'PC', 21.489999771118164),
(14, 4, '2023-05-10 18:38:07', 'paypal', '10/05/23/008', 'PC', 110.42999267578125),
(15, 4, '2023-05-11 15:02:04', 'paypal', '11/05/23', 'PC', 37.5),
(16, 4, '2023-05-11 15:03:25', 'tarjeta', '11/05/23', 'PE', 26.969999313354492),
(17, 4, '2023-05-11 15:04:29', 'paypal', '11/05/23', 'PE', 43.959999084472656),
(18, 4, '2023-05-11 15:08:13', 'tarjeta', '11/05/23', 'PE', 9.5),
(19, 4, '2023-05-11 15:09:36', 'tarjeta', '11/05/23', 'PE', 11.989999771118164),
(20, 4, '2023-05-11 15:10:19', 'paypal', '11/05/23', 'PE', 10.989999771118164),
(21, 4, '2023-05-11 15:11:14', 'tarjeta', '11/05/23', 'PE', 8.989999771118164),
(22, 4, '2023-05-11 15:13:28', 'paypal', '11/05/23/008', 'PE', 8.989999771118164),
(23, 4, '2023-05-11 15:24:49', 'tarjeta', '11/05/23/009', 'PE', 8.989999771118164),
(24, 4, '2023-05-11 15:25:23', 'paypal', '11/05/23/10', 'PE', 10.989999771118164),
(25, 4, '2023-05-11 15:28:11', 'paypal', '11/05/23/0011', 'PE', 12.5),
(26, 4, '2023-05-11 16:00:00', 'paypal', '11/05/23/0012', 'PE', 107.90999603271484),
(27, 4, '2023-05-11 16:16:43', 'tarjeta', '11/05/23/0013', 'PE', 12.5),
(28, 4, '2023-05-11 16:19:19', 'paypal', '11/05/23/0014', 'PE', 12.5);

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
(1, 'Piratas del Caribe', 'Película de aventuras en alta mar', 10.989999771118164, 0.20999999344348907, 40, 0, 'pCaribe', 1),
(2, 'Toy Story', 'Película de animación sobre juguetes', 8.989999771118164, 0.20999999344348907, 23, 0, NULL, 2),
(3, 'El Padrino', 'Película de drama criminal', 12.5, 0.20999999344348907, 13, 0, NULL, 3),
(4, 'Star Wars: Episodio IV - Una nueva esperanza', 'Película de ciencia ficción y aventuras', 11.989999771118164, 0.20999999344348907, 0, 0, NULL, 4),
(5, 'Regreso al Futuro', 'Película de ciencia ficción y comedia', 9.5, 0.20999999344348907, 21, 0, NULL, 4);

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
(2, 2, 'usuario2@example.com', 'XGNAVPL+04lGwY4KxQI4Xg==', 'María', 'García', 0),
(3, 1, 'usuario3@example.com', 'clave789', 'Pedro', 'Rodríguez', 0),
(4, 1, 'a@a.es', 'XGNAVPL+04lGwY4KxQI4Xg==', 'a', 'a', 0),
(5, 1, 'aa@aa.es', 'XGNAVPL+04lGwY4KxQI4Xg==', 'a', 'a', 0),
(6, 1, 'da@da.ess', '4dRvlYAJkdUI+u3fB95e4w==', 'da', 'da', 0);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
