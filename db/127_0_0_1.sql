-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2022 a las 01:37:33
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `angelito`
--
CREATE DATABASE IF NOT EXISTS `angelito` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `angelito`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--
-- Creación: 09-05-2022 a las 04:08:37
-- Última actualización: 22-06-2022 a las 23:18:27
--

CREATE TABLE `inventario` (
  `idinventario` int(11) NOT NULL,
  `codigo_barras` int(22) NOT NULL,
  `cantidad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idinventario`, `codigo_barras`, `cantidad`) VALUES
(1, 1, 90),
(2, 2, 129),
(3, 3, 200),
(4, 4, 187),
(5, 5, 299),
(6, 6, 37),
(7, 7, 520),
(8, 8, 100),
(9, 9, 710),
(10, 10, 233),
(11, 11, 72),
(12, 12, 30),
(13, 13, 98),
(14, 14, 51),
(15, 15, 180),
(16, 16, 61),
(17, 17, 116),
(18, 18, 90),
(19, 19, 81),
(20, 20, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--
-- Creación: 09-05-2022 a las 04:08:23
--

CREATE TABLE `producto` (
  `codigo_barras` int(22) NOT NULL,
  `producto` varchar(35) NOT NULL,
  `precio` int(6) NOT NULL,
  `marca` varchar(35) NOT NULL,
  `idproveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo_barras`, `producto`, `precio`, `marca`, `idproveedor`) VALUES
(1, 'Reloj G-Shock', 599, 'Casio', 4),
(2, 'Calculadora', 199, 'Casio', 5),
(3, 'Muñeca', 199, 'Barbie', 6),
(4, 'Figura de Accion', 250, 'Max Steel', 6),
(5, 'playera', 299, 'Aeropostale', 2),
(6, 'Boxer Brief', 299, 'Calvin Klein', 1),
(7, 'Pulsera', 99, 'Swarovski', 4),
(8, 'Libro Pasta Dura', 149, 'De Bolsillo', 10),
(9, 'Llavero', 49, 'Tropical', 8),
(10, 'Funda Para Celular', 99, 'Mobo', 7),
(11, 'Balon Futbol', 119, 'Void', 9),
(12, 'Balon Bascketball', 179, 'Wilson', 9),
(13, 'Pato de Goma', 49, 'DuckDuck', 6),
(14, 'Control de Videojuegos', 499, 'PlayStation', 7),
(15, 'Audifonos', 129, 'Sony', 7),
(16, 'Marcapaginas', 49, 'De Bolsillo', 10),
(17, 'Rompecabezas', 79, 'Hasbro', 2),
(18, 'Perfume', 699, 'Dior', 3),
(19, 'Body Mist', 399, 'Victoria Secret', 3),
(20, 'Tarjeta de Regalo Apple', 199, 'Apple', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--
-- Creación: 09-05-2022 a las 01:36:04
--

CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `proveedor` varchar(40) NOT NULL,
  `direccion` varchar(70) NOT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idproveedor`, `proveedor`, `direccion`, `telefono`) VALUES
(1, 'Costco', 'Bv. Adolfo Ruíz Cortines 1228, Sutsem, 91384, Veracruz, Ver', '2299236591'),
(2, 'Sam\'s Club', 'Av. las Palmas 100, Rancho Alegre II, 96538 Coatzacoalcos, Ver.', '9212183421'),
(3, 'The Fragrance', 'Av Universidad 1503, El Tesoro, 96579, Coatzacoalcos, Ver', '9212349200'),
(4, 'Joyeria El Diamante', 'Juan Escutia 1400, 96578, Coatzacoalcos, Ver', '9213209183'),
(5, 'Office Depot', 'Malecon Costero 1910, 961522 Maria de la Piedad, Coatzacoalcos, Ver', '9218276189'),
(6, 'Jugueteria El Castillo', 'Revolución 120, 94322, Constituyentes, Minatitlán, Ver', '9221689652'),
(7, 'TecnoMundo', 'Guadalajara 1300, 96577, Petrolera, Coatzacoalcos, Ver', '9211110033'),
(8, 'Palacio de Hierro', 'Bv. Adolfo Ruíz Cortines 4300, Zona Hotelera, 94299 Veracruz, Ver.', '2290609218'),
(9, 'Deportes Joga Bonito', 'Av Miguel Hidalgo #321, Centro, 96400 Coatzacoalcos, Ver.', '9211014185'),
(10, 'Libreria Gandhi', 'Av Miguel Hidalgo #321, Centro, 96400 Coatzacoalcos, Ver.', '9212347791');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--
-- Creación: 19-03-2022 a las 21:32:33
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `contraseña`) VALUES
(2, 'garduza', 'UV'),
(3, 'JavierChapa', 'coatza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--
-- Creación: 09-05-2022 a las 04:42:40
-- Última actualización: 22-06-2022 a las 23:18:27
--

CREATE TABLE `venta` (
  `num_venta` int(11) NOT NULL,
  `fecha_venta` timestamp NOT NULL DEFAULT current_timestamp(),
  `idinventario` int(11) NOT NULL,
  `cantidad` int(3) NOT NULL,
  `importe` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`num_venta`, `fecha_venta`, `idinventario`, `cantidad`, `importe`) VALUES
(1, '2022-05-09 17:37:45', 9, 1, 49),
(2, '2022-06-04 15:00:53', 9, 1, 49),
(3, '2022-06-04 15:16:19', 13, 1, 49),
(4, '2022-06-04 15:23:18', 3, 1, 199),
(5, '2022-06-04 15:28:52', 7, 3, 297),
(6, '2022-06-04 17:12:22', 3, 2, 398),
(7, '2022-06-04 17:42:26', 2, 1, 199),
(8, '2022-06-22 06:11:43', 20, 2, 398),
(9, '2022-06-22 06:15:07', 5, 1, 299),
(10, '2022-06-22 23:17:05', 6, 3, 897),
(11, '2022-06-22 23:18:26', 17, 1, 79);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idinventario`),
  ADD KEY `codigo_barras` (`codigo_barras`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo_barras`),
  ADD KEY `idproveedor` (`idproveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idproveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`num_venta`),
  ADD KEY `idinventario` (`idinventario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `idinventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `codigo_barras` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `num_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`codigo_barras`) REFERENCES `producto` (`codigo_barras`) ON DELETE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idinventario`) REFERENCES `inventario` (`idinventario`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
