-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2018 a las 06:44:05
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Blastoide`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Localidades`
--

CREATE TABLE `Localidades` (
  `LocalidadID` int(11) NOT NULL,
  `provinciaID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `codigoPostal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Localidades`
--

INSERT INTO `Localidades` (`LocalidadID`, `provinciaID`, `nombre`, `codigoPostal`) VALUES
(1, 5, 'Anisacate', '54321'),
(2, 5, 'Colonia Caroya', '21312'),
(3, 5, 'Cosquín', '1231'),
(4, 5, '9 De Julio', '5272'),
(5, 5, 'Achiras', '5833'),
(6, 5, 'Adelia Maria', '5843'),
(7, 5, 'Aguada Del Monte', '5209'),
(8, 5, 'Agua De Oro', '5107'),
(9, 5, 'Almafuerte', '5854'),
(10, 5, 'Alpa Corral', '5801'),
(11, 5, 'Alta Gracia', '5186'),
(12, 5, 'Ambul', '5299'),
(13, 5, 'Arroyito', '2434'),
(14, 5, 'Arroyo Cabral', '5917'),
(15, 5, 'Asconchinga', '5117'),
(16, 5, 'Atos Pampa', '5194'),
(17, 5, 'Bajo De Gomez', '5961'),
(18, 5, 'Bajo Grande', '5101'),
(19, 5, 'Ballesteros', '2572'),
(20, 5, 'Barranca Yaco', '2512'),
(21, 5, 'Bella Vista', '5284'),
(22, 5, 'Bell Ville', '2550'),
(23, 5, 'Berrotaran', '5817'),
(24, 5, 'Bialet Masse', '5158'),
(25, 5, 'Bosque Alegre', '5186'),
(26, 5, 'Bouwer', '5119'),
(27, 5, 'Brinkmann', '2419'),
(28, 5, 'Campo Alegre', '5209'),
(29, 5, 'Campo Grande', '5231'),
(30, 5, 'Candonga', '5111'),
(31, 5, 'Capilla De Dolores', '5125'),
(32, 5, 'Capilla Del Monte', '5184'),
(33, 5, 'Capilla De Los Remedios', '511'),
(34, 5, 'Caroya', '5223'),
(35, 5, 'Chilli Corral', '5246'),
(36, 5, 'Colonia Almada', '5987'),
(37, 5, 'Colonia Argentina', '6140'),
(38, 5, 'Colonia Arroyo De Alvarez', '2436'),
(39, 5, 'Colonia Caroya', '5223'),
(40, 5, 'Colonia Dean Funes', '5847'),
(41, 5, 'Colonia Dolores', '5809'),
(42, 5, 'Colonia Tirolesa', '5101'),
(43, 5, 'Cosquin', '5166'),
(44, 5, 'Cruz Del Eje', '5280'),
(45, 5, 'Dean Funes', '5200'),
(46, 5, 'Dos Arroyos', '5189'),
(47, 5, 'El Durazno', '5293'),
(48, 5, 'Etruria', '2681'),
(49, 5, 'Ferreyra', '5925'),
(50, 5, 'Huerta Grande', '5174'),
(51, 5, 'Jesus Maria', '5220'),
(52, 5, 'Jovita', '6127'),
(53, 5, 'La Calera', '5819'),
(54, 5, 'La Francia', '2426'),
(55, 5, 'Las Palmas', '5201'),
(56, 5, 'Oliva', '5980'),
(57, 5, 'Rio Ceballos', '5111'),
(58, 5, 'Rio Cuarto', '5800'),
(59, 5, 'Rio Segundo', '5960'),
(60, 5, 'Rio Tercero', '5850'),
(61, 5, 'Salsipuedes', '5113'),
(62, 5, 'Salsacate', '5295'),
(63, 5, 'Saldan', '5149'),
(64, 5, 'Sampacho', '5829'),
(65, 5, 'San Antonio', '5281'),
(66, 5, 'Santa Rosa De Calamuchita', '5196'),
(67, 5, 'Tanti', '5155'),
(68, 5, 'Unquillo', '5109'),
(69, 5, 'Valle Hermoso', '5168'),
(70, 5, 'Villa Anisacate', '5189');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Localidades`
--
ALTER TABLE `Localidades`
  ADD PRIMARY KEY (`LocalidadID`),
  ADD KEY `provinciaID` (`provinciaID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Localidades`
--
ALTER TABLE `Localidades`
  MODIFY `LocalidadID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Localidades`
--
ALTER TABLE `Localidades`
  ADD CONSTRAINT `Localidades_ibfk_1` FOREIGN KEY (`provinciaID`) REFERENCES `Provincias` (`provinciaID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
