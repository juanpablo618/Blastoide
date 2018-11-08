-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-11-2018 a las 17:56:06
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `id` int(11) NOT NULL,
  `fecha` varchar(250) DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `ingreso` double DEFAULT NULL,
  `egreso` double DEFAULT NULL,
  `CtaCorriente` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`id`, `fecha`, `descripcion`, `ingreso`, `egreso`, `CtaCorriente`) VALUES
(87, '07/09/2018', 'Cliente: pedro  russo F.Pago: Contado efectivo', 82, NULL, NULL),
(88, '26/09/2018', 'Cliente: cliente comun F.Pago: Contado efectivo', 78.5, NULL, NULL),
(89, '26/09/2018', 'Cliente: cliente comun F.Pago: Contado efectivo', 78.5, NULL, NULL),
(90, '26/09/2018', 'Cliente: cliente comun F.Pago: Contado efectivo', 78.5, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `ClienteID` int(11) NOT NULL,
  `nombre` varchar(300) NOT NULL,
  `dni` varchar(100) DEFAULT NULL,
  `tipoClienteID` int(11) DEFAULT NULL,
  `FormaDePagoID` int(20) DEFAULT NULL,
  `apellido` varchar(500) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cuitCuil` varchar(50) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `numeroDocumento` bigint(20) DEFAULT NULL,
  `razonSocial` varchar(1000) DEFAULT NULL,
  `sexo` varchar(500) DEFAULT NULL,
  `telefonoFijo` varchar(250) DEFAULT NULL,
  `telefonoCelular` varchar(250) DEFAULT NULL,
  `fiadoMaximo` int(11) DEFAULT NULL,
  `tipoDocumentoID` int(11) DEFAULT NULL,
  `Real_domicilioID` int(11) DEFAULT NULL,
  `Fiscal_domicilioID` int(11) DEFAULT NULL,
  `condicionIvaID` int(11) DEFAULT NULL,
  `diaDePago` varchar(250) DEFAULT NULL,
  `cuentaCorrienteID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`ClienteID`, `nombre`, `dni`, `tipoClienteID`, `FormaDePagoID`, `apellido`, `email`, `cuitCuil`, `fechaNacimiento`, `numeroDocumento`, `razonSocial`, `sexo`, `telefonoFijo`, `telefonoCelular`, `fiadoMaximo`, `tipoDocumentoID`, `Real_domicilioID`, `Fiscal_domicilioID`, `condicionIvaID`, `diaDePago`, `cuentaCorrienteID`) VALUES
(32, 'cliente', '35054821', 3, 1, 'comun', 'cuello.juanpablo@gmail.com', '20350548220', NULL, 35054822, 'razon cuello', 'masculino', '4522524', '3513220999', NULL, NULL, NULL, NULL, 1, 'Wed Jan 17 21:22:00 ART 3', 49),
(33, 'juan', '45965833', 5, 10, 'cliente comun', 'cuello.@clientecomun.com', '2045943200', NULL, 45965833, 'clienteComunacho', 'masculino', '5432854', '292910', NULL, NULL, NULL, NULL, 3, 'Thu Jan 17 21:27:00 ART 4', 50),
(34, 'mayorista', '89654833', 2, 2, 'mayorista', 'mayorista@mayorista.com', '76985347559', NULL, 89654833, 'mayorista srl', 'masculino', '4530302', '3432042340', NULL, NULL, NULL, NULL, 2, 'Thu Jan 17 21:27:00 ART 4', 51),
(35, 'distribuidor', '847272821', 3, 1, 'distribuidor apellido', 'distribuye@hotmail.com', '2039383838', NULL, 847272821, 'distribuye todo RS', 'femenino', '3828382', '382383282', NULL, NULL, NULL, NULL, 4, 'Sun Jan 17 21:20:00 ART 12', 52),
(36, 'franquicia', '291219129', 4, 4, 'franquicia apellido', 'franquicia@hotmail.com', '29129219', NULL, 291219129, 'franquicia RS', 'femenino', '12913291239', '31293129', NULL, NULL, NULL, NULL, 1, 'Fri Jan 17 21:26:00 ART 10', 53),
(37, 'juan paulo', '20291919', 5, 4, 'maquina', 'maquina@maquina.com', '203505482222', NULL, 20291919, 'maquina pc', 'masculino', '281321812', '123812381', NULL, NULL, NULL, NULL, 3, 'Sun Jan 17 21:19:00 ART 6', 54),
(38, 'pedro ', '34956744', 1, 1, 'russo', 'pedro.russo@pedro.com', '20350548220', NULL, 34956744, 'pedro russo', 'masculino', '4757373', '473737373', NULL, NULL, NULL, NULL, 3, 'Sat Jan 08 18:20:00 CST 18', 55),
(39, 'juan cuenta', '35084521', 1, 6, ' corriente 3', 'ctaCorriente3@ctaCorriente3.com', '2049287662', NULL, 35084521, 'ctaCorriente3', 'masculino', '4656456', '5645656', NULL, NULL, NULL, NULL, 1, 'Sat Jan 08 18:26:00 CST 18', 56);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condicionIVA`
--

CREATE TABLE `condicionIVA` (
  `condicionIVAID` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `porcentajeInteres` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `condicionIVA`
--

INSERT INTO `condicionIVA` (`condicionIVAID`, `nombre`, `descripcion`, `porcentajeInteres`) VALUES
(1, 'responsable inscripto', 'responsable inscripto', 0),
(2, 'Consumidor Final', 'Consumidor Final', 0),
(3, 'Monotributista', 'Monotributista', 0),
(5, 'Exento', 'Exento', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ConfiguracionesGenerales`
--

CREATE TABLE `ConfiguracionesGenerales` (
  `IdConfiguracionsGenerales` int(11) NOT NULL,
  `telefonoSucursal` varchar(500) DEFAULT NULL,
  `carpetaDePresupuestos` varchar(500) DEFAULT NULL,
  `pdfUrl` varchar(500) DEFAULT NULL,
  `urlDeLogoMundoLimpieza` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ConfiguracionesGenerales`
--

INSERT INTO `ConfiguracionesGenerales` (`IdConfiguracionsGenerales`, `telefonoSucursal`, `carpetaDePresupuestos`, `pdfUrl`, `urlDeLogoMundoLimpieza`) VALUES
(1, '99999999', '/home/developer/Documents', 'file:///home/developer/Documents', 'http://localhost:8080/Blastoide_v2/faces/resources/images/MundoLimpieza2.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CuentaCorriente`
--

CREATE TABLE `CuentaCorriente` (
  `cuentaCorrienteID` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `concepto` varchar(500) DEFAULT NULL,
  `nroDeComprobante` int(11) DEFAULT NULL,
  `debe` float DEFAULT NULL,
  `haber` float DEFAULT NULL,
  `nombreyApellido` varchar(250) DEFAULT NULL,
  `direccionReal` varchar(1000) DEFAULT NULL,
  `direccionFacturacion` varchar(1000) DEFAULT NULL,
  `nombreDeFantasia` varchar(1000) DEFAULT NULL,
  `nombreDeFacturacion` varchar(1000) DEFAULT NULL,
  `localidadID` int(11) DEFAULT NULL,
  `CodigoPostal` int(11) DEFAULT NULL,
  `telefono` varchar(1000) DEFAULT NULL,
  `credito` int(11) DEFAULT NULL,
  `formaDePagoID` varchar(1000) DEFAULT NULL,
  `descuento` float DEFAULT NULL,
  `fechaDePago` date DEFAULT NULL,
  `Conducta` varchar(1000) DEFAULT NULL,
  `CUIT` varchar(50) DEFAULT NULL,
  `condicionIVAID` int(11) DEFAULT NULL,
  `observaciones` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CuentasCorrientes`
--

CREATE TABLE `CuentasCorrientes` (
  `cuentaCorrienteID` int(11) NOT NULL,
  `limite` float DEFAULT '50000',
  `saldo` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CuentasCorrientes`
--

INSERT INTO `CuentasCorrientes` (`cuentaCorrienteID`, `limite`, `saldo`) VALUES
(44, 20000, 7614.06),
(45, 0, 0),
(46, 1000, 0),
(47, 20000, 0),
(48, 50000, 0),
(49, 10000, 0),
(50, 10000, 0),
(51, 20000, 0),
(52, 2000000, 0),
(53, 30000, 0),
(54, 50000, 0),
(55, 10000, 0),
(56, 100000, 1909.2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Depositos`
--

CREATE TABLE `Depositos` (
  `depositoID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Depositos`
--

INSERT INTO `Depositos` (`depositoID`, `nombre`, `descripcion`) VALUES
(1, 'deposito 1', 'casa de lucas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleCuentasCorrientes`
--

CREATE TABLE `DetalleCuentasCorrientes` (
  `detalleCuentaCorrienteID` int(11) NOT NULL,
  `debe` float DEFAULT NULL,
  `haber` float DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cuentaCorrienteID` int(11) DEFAULT NULL,
  `ventaID` int(11) DEFAULT NULL,
  `saldoHistorico` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `DetalleCuentasCorrientes`
--

INSERT INTO `DetalleCuentasCorrientes` (`detalleCuentaCorrienteID`, `debe`, `haber`, `descripcion`, `fecha`, `cuentaCorrienteID`, `ventaID`, `saldoHistorico`) VALUES
(16, 79, 0, 'venta a cliente con cta corriente: 53', '2018-04-16 22:53:39', 53, 0, 237),
(17, 94.8, 0, 'FAC-0', '2018-04-16 23:07:38', 53, 0, 331.8),
(18, 94.8, 0, 'FAC-0', '2018-04-16 23:08:51', 53, 0, 426.6),
(19, 79, 0, 'FAC-0', '2018-04-16 23:22:27', 53, 0, 505.6),
(20, 79, 0, 'FAC-25', '2018-04-16 23:32:27', 53, 0, 584.6),
(21, NULL, 584, 'pago por deuda linda', '2018-05-16 00:11:58', 53, NULL, 0.599976),
(22, 104, 0, 'FAC-53', '2018-06-14 00:36:05', 54, 0, 104),
(23, 79, 0, 'FAC-55', '2018-06-14 02:16:50', 53, 0, 79.6),
(24, 78, 0, 'FAC-60', '2018-06-14 17:55:00', 53, 0, 157.6),
(25, 79, 0, 'FAC-61', '2018-06-14 17:58:59', 53, 0, 236.6),
(26, 86.9, 0, 'FAC-66', '2018-06-14 18:41:37', 53, 0, 323.5),
(27, 79, 0, 'FAC-68', '2018-06-14 18:51:55', 53, 0, 402.5),
(28, 79, 0, 'FAC-70', '2018-06-15 01:24:31', 53, 0, 481.5),
(29, 948, 0, 'FAC-90', '2018-09-03 16:04:48', 53, 0, 1429.5),
(30, NULL, 1420, 'pago de todo lo que debe', '2018-09-03 16:05:48', 53, NULL, 9.5),
(31, NULL, 9.5, 'pago 10 pesos q debia', '2018-09-03 16:17:26', 0, NULL, -9.5),
(32, NULL, 9.5, 'pago los 9 pesos q debe', '2018-09-03 16:21:35', 0, NULL, -9.5),
(33, NULL, 9.5, 'pago de 10 pesos q debe', '2018-09-03 16:54:35', 53, NULL, 0),
(34, 774, 0, 'FAC-91', '2018-09-03 18:27:39', 56, 0, 774),
(35, 94.6, 0, 'FAC-93', '2018-09-04 17:57:56', 56, 0, 868.6),
(36, 868.6, 0, 'FAC-94', '2018-09-06 16:59:41', 56, 0, 1737.2),
(37, 172, 0, 'FAC-95', '2018-09-06 17:04:15', 56, 0, 1909.2),
(38, NULL, 104, 'pago los 104 pesos', '2018-09-07 15:47:41', 54, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleVenta`
--

CREATE TABLE `DetalleVenta` (
  `codigo` int(11) NOT NULL,
  `codVenta` int(11) NOT NULL,
  `productoID` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `DetalleVenta`
--

INSERT INTO `DetalleVenta` (`codigo`, `codVenta`, `productoID`, `cantidad`) VALUES
(78, 69, 1617, 1),
(79, 70, 1617, 1),
(80, 71, 1617, 1),
(81, 72, 1617, 2),
(82, 73, 1618, 2),
(83, 73, 1623, 1),
(84, 73, 1617, 1),
(85, 74, 1617, 1),
(86, 74, 1623, 1),
(87, 74, 1618, 1),
(88, 75, 1624, 1),
(89, 75, 1617, 1),
(90, 75, 1618, 1),
(91, 76, 1617, 1),
(92, 76, 1626, 1),
(93, 76, 1623, 1),
(94, 77, 1618, 1),
(95, 77, 1623, 1),
(96, 77, 1617, 1),
(97, 78, 1620, 1),
(98, 78, 1623, 1),
(99, 78, 1617, 1),
(100, 79, 1624, 1),
(101, 79, 1618, 1),
(102, 79, 1617, 1),
(103, 80, 1624, 1),
(104, 80, 1618, 1),
(105, 80, 1617, 1),
(106, 81, 1626, 4),
(107, 81, 1618, 5),
(108, 81, 1617, 1),
(109, 82, 1624, 1),
(110, 82, 1626, 5),
(111, 82, 1623, 1),
(112, 82, 1618, 6),
(113, 82, 1617, 1),
(114, 83, 1620, 1),
(115, 84, 1617, 1),
(116, 85, 1623, 1),
(117, 86, 1623, 1),
(118, 87, 1623, 1),
(119, 88, 1617, 1),
(120, 88, 1618, 1),
(121, 88, 1624, 1),
(122, 88, 1626, 2),
(123, 88, 1623, 3),
(124, 89, 1640, 5),
(125, 90, 1635, 12),
(126, 91, 1760, 4),
(127, 91, 1740, 5),
(128, 92, 1620, 1),
(129, 93, 1618, 1),
(130, 94, 1620, 3),
(131, 94, 2093, 3),
(132, 94, 1624, 1),
(133, 94, 1617, 1),
(134, 94, 2115, 1),
(135, 94, 1618, 1),
(136, 95, 1624, 1),
(137, 95, 2093, 1),
(138, 96, 1620, 2),
(139, 96, 1618, 1),
(140, 97, 1620, 2),
(141, 97, 1618, 1),
(142, 98, 1620, 150),
(143, 99, 2093, 2),
(144, 100, 1617, 4),
(145, 100, 1624, 1),
(146, 100, 1618, 1),
(147, 100, 2093, 1),
(148, 101, 1624, 20),
(149, 101, 1617, 1),
(150, 102, 1618, 3),
(151, 102, 1624, 2),
(152, 103, 1617, 1),
(153, 103, 1624, 1),
(154, 104, 1624, 1),
(155, 104, 1617, 1),
(156, 105, 1618, 2),
(157, 106, 1617, 3),
(158, 106, 1620, 1),
(159, 108, 1620, 1),
(160, 109, 2093, 1),
(161, 109, 2115, 2),
(162, 110, 2115, 2),
(163, 110, 1617, 1),
(164, 110, 1624, 1),
(165, 113, 1620, 2),
(166, 113, 2115, 2),
(167, 114, 2115, 2),
(168, 115, 1617, 1),
(169, 115, 2093, 1),
(170, 116, 1620, 1),
(171, 117, 1618, 1),
(172, 118, 1620, 1),
(173, 122, 1617, 2),
(174, 123, 1620, 1),
(175, 124, 1620, 1),
(176, 125, 2093, 1),
(177, 126, 1624, 1),
(178, 127, 1617, 1),
(179, 128, 2093, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Domicilios`
--

CREATE TABLE `Domicilios` (
  `DomiciliosID` int(11) NOT NULL,
  `calle` varchar(100) NOT NULL,
  `numero` int(50) NOT NULL,
  `departamento` varchar(20) NOT NULL,
  `piso` int(30) NOT NULL,
  `localidadID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Domicilios`
--

INSERT INTO `Domicilios` (`DomiciliosID`, `calle`, `numero`, `departamento`, `piso`, `localidadID`) VALUES
(1, 'charcas ', 1636, 'punilla', 2, 1),
(2, 'roma', 1021, 'capital', 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Estado`
--

CREATE TABLE `Estado` (
  `estadoID` int(11) NOT NULL,
  `ambito` varchar(1000) NOT NULL,
  `descripcion` varchar(2500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Estado`
--

INSERT INTO `Estado` (`estadoID`, `ambito`, `descripcion`) VALUES
(1, 'entregado', 'entregado por proveedor'),
(2, 'Enviado', 'enviado a proveedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Eventualidades`
--

CREATE TABLE `Eventualidades` (
  `eventualidadID` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `observaciones` varchar(250) NOT NULL,
  `totalPerdida` int(11) NOT NULL,
  `tipoEventualidadID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FormaDePago`
--

CREATE TABLE `FormaDePago` (
  `formaDePagoID` int(11) NOT NULL,
  `descripcion` varchar(2500) DEFAULT NULL,
  `nombre` varchar(500) DEFAULT NULL,
  `porcentaje` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `FormaDePago`
--

INSERT INTO `FormaDePago` (`formaDePagoID`, `descripcion`, `nombre`, `porcentaje`) VALUES
(1, 'Contado efectivo', 'Contado efectivo', 2),
(2, 'Contado', 'Contado', 3),
(3, 'Cuenta Corriente(-)(negativa)', 'Cta Cte (-)', 3),
(4, 'Cuenta Corriente con 1 *', 'Cta Cte *', 4),
(5, 'Cuenta Corriente con 2 *', 'Cta Cte **', 5),
(6, 'Cuenta Corriente con 3 ***', 'Cta Cte ***', 6),
(7, 'Tarjetas de Credito de 1 a 3 cuotas.', 'Tarjetas de Credito 1 a 3 Cuotas.', 7),
(8, 'Tarjetas de Crédito de 4 a 6 cuotas.', 'Tarjetas de Crédito (4 a 6 Cuotas) ', 8),
(9, 'Tarjetas de Crédito de 7 a 12 cuotas.', 'Tarjetas de Creito (7 a 12 Cuotas) ', 9),
(10, 'Tarjetas de Crédito ahora 12 Jueves a domingos.', 'T. Ahora 12 ', 10),
(11, 'Tarjetas de Débito.', 'Tarjetas de Débito.', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Imagenes`
--

CREATE TABLE `Imagenes` (
  `imagenID` int(11) NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `contentType` int(11) NOT NULL,
  `fileType` int(11) NOT NULL,
  `productoID` int(11) NOT NULL,
  `file_Imagen` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='TIENE IMAGEN MODIFICAR MAS ADELANTE';

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
(69, 5, 'Valle Hermoso', '5168'),
(70, 5, 'Villa Anisacate', '5189'),
(71, 5, 'Unquillo', '5109');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Ofertas`
--

CREATE TABLE `Ofertas` (
  `ofertaID` int(11) NOT NULL,
  `titulo` varchar(500) DEFAULT NULL,
  `descripcion` varchar(2500) DEFAULT NULL,
  `fechaDesde` date NOT NULL,
  `fechaHasta` date NOT NULL,
  `precioDeOferta` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descuentoPesos` double DEFAULT NULL,
  `descuentoPorcentaje` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Ofertas`
--

INSERT INTO `Ofertas` (`ofertaID`, `titulo`, `descripcion`, `fechaDesde`, `fechaHasta`, `precioDeOferta`, `cantidad`, `descuentoPesos`, `descuentoPorcentaje`) VALUES
(1, 'oferta del día del madre', 'llevando 2 ayudin ganas 4', '2017-06-13', '2017-06-30', 54.3, 10, 60, 70);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `OrdenDeCompra`
--

CREATE TABLE `OrdenDeCompra` (
  `ordenDeCompraID` int(11) NOT NULL,
  `numeroOC` double DEFAULT NULL,
  `fechaCreacion` date NOT NULL,
  `fechaEmision` date NOT NULL,
  `fechaCierre` date NOT NULL,
  `total` double DEFAULT NULL,
  `restoTotal` double DEFAULT NULL,
  `estadoID` int(11) DEFAULT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `OrdenDeCompra`
--

INSERT INTO `OrdenDeCompra` (`ordenDeCompraID`, `numeroOC`, `fechaCreacion`, `fechaEmision`, `fechaCierre`, `total`, `restoTotal`, `estadoID`, `estado`) VALUES
(2, 23, '2018-04-26', '2018-04-21', '2018-04-26', 65, 65, NULL, 'entregado editado'),
(3, 100, '2018-04-24', '2018-04-26', '2018-04-25', 80, 80, NULL, 'facturado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Productos`
--

CREATE TABLE `Productos` (
  `productoID` int(11) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `fragancia` varchar(100) DEFAULT NULL,
  `caracteristica` varchar(200) DEFAULT NULL,
  `medida` varchar(100) DEFAULT NULL,
  `precioVenta` double NOT NULL,
  `unidadMedidaID` int(11) DEFAULT NULL,
  `tipoProductoID` int(11) DEFAULT NULL,
  `tipoRubroID` int(11) DEFAULT NULL,
  `ultimaActualizacionStock` date DEFAULT NULL,
  `inventarioID` int(11) NOT NULL,
  `precioFinalAFacturar` double DEFAULT NULL,
  `stockactual` int(11) DEFAULT '0',
  `stockMinimo` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Productos`
--

INSERT INTO `Productos` (`productoID`, `codigo`, `nombre`, `marca`, `fragancia`, `caracteristica`, `medida`, `precioVenta`, `unidadMedidaID`, `tipoProductoID`, `tipoRubroID`, `ultimaActualizacionStock`, `inventarioID`, `precioFinalAFacturar`, `stockactual`, `stockMinimo`) VALUES
(1617, '7506339305609', 'JABON LIQUIDO PARA ROPA	', 'ACE	', 'C/SUAVIZANTE	', '', '3', 0, NULL, NULL, 2, NULL, 0, 100, -70, 4),
(1618, '7798181180101', '	ROLLO DE COCINA	', '	ACQUA	', '	X40PAÑOS C/U	', '', '300', 60, NULL, NULL, NULL, NULL, 0, 110, -39, 32),
(1619, '7790520012807', 'LIMPIADOR LIQUIDO	', 'MR. MUSCULO - GLADE	', 'EXPLOSION FLORAL	', '', '901.00', 70, NULL, NULL, NULL, NULL, 0, 120, -6, 12),
(1620, '7790520009609', 'DESINFECTANTE	', 'LYSOFORM	', 'LAVANDA', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, -172, 6),
(1621, '7790520009944', '	INSECTICIDA	', '	RAID	', '	CASA Y JARDIN	', NULL, '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1622, '7798184680806', 'DIFUSOR CAÑA DE BAMBOO', 'SAPHIRUS', 'VAINILLA', '', '125.00', 50, NULL, NULL, NULL, '2017-12-12', 0, 100, 0, 5),
(1623, '7798184681001', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	TROPICAL	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, -55, 5),
(1624, '7798184680738', 'DIFUSOR CAÑA DE BAMBOO', 'SAPHIRUS', 'CONY', '', '125.00', 0, NULL, NULL, NULL, '2018-09-20', 0, 100, -39, 5),
(1625, '7798184680707', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	CITRUS	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1626, '7798184680745', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	UVA	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, -13, 5),
(1627, '7798184680769', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	FLORES BLANCAS	', '', '125.00', 50, NULL, NULL, 3, NULL, 0, 100, 0, 5),
(1628, '7798184680790', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	HAWAI	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1629, '7798184680721', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	ORIENTE	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, -1, 5),
(1630, '7798184680950', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	BAMBOO	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1631, '7798184680981', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	LAVANDA	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1632, '7798184680943', '	DIFUSOR CAÑA DE BAMBOO	', '	SAPHIRUS	', '	AMOR	', NULL, '125.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1633, '7793253411701', '	POETT INTENSE	', '	POETT	', '	PRIMAVERA	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1634, '7790520008299', '	GLADE TOQUE	', '	GLADE	', '	FLORAL PERFECTION	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1635, '7790520008329', 'GLADE TOQUE	', '	GLADE	', '	HARMONY	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, -12, 2),
(1636, '7793253041656', 'POETT INTENSE	', '	POETT	', '	BEBE	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1637, '7793253041007', 'POETT INTENSE	', '	POETT	', '	LAVANDA	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1638, '7790520008336', 'GLADE TOQUE	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1639, '7790520985163', '	GLADE TOQUE	', '	GLADE	', '	COCINA CITRICA	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1640, '7793253041274', '	POETT INTENSE	', '	POETT	', '	BOSQUE DE BAMBU	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, -5, 2),
(1641, '7793253041335', '	POETT INTENSE	', '	POETT	', '	DULCES MOMENTOS	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1642, '7793253041328', '	POETT INTENSE	', '	POETT	', '	ESPIRITU JOVEN	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1643, '7793253411602', '	POETT INTENSE	', '	POETT	', '	SUAVIDAD DE ALGODON	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1644, '7790520008121', '	GLADE TOQUE	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1645, '7790520008206', '	GLADE TOQUE	', '	GLADE	', '	HARMONY	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1646, '7790520008145', '	GLADE TOQUE	', '	GLADE	', '	CARICIAS DE BEBE	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1647, '7790520008138', '	GLADE TOQUE	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1648, '7790520008190', '	GLADE TOQUE	', '	GLADE	', '	POTPURRI	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1649, '7790520008152', '	GLADE TOQUE	', '	GLADE	', '	COCINA CITRICA	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1650, '7790520005939', '	ADHESIVO PARA INODORO	', '	MR. MUSCULO - GLADE	', '	MAÑANA DE CAMPO	', NULL, '3.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1651, '7790520005915', '	ADHESIVO PARA INODORO	', '	MR. MUSCULO - GLADE	', '	CAMPOS DE LAVANDA	', NULL, '3.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1652, '7790520005922', '	ADHESIVO PARA INODORO	', '	MR. MUSCULO - GLADE	', '	MARINA	', NULL, '3.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1653, '7790520008718', '	SENSATIONS ELECTRIC	', '	GLADE	', '	NECTAR DE FLORES	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1654, '7790520008695', '	SENSATIONS GLASS	', '	GLADE	', '	FLORAL PERFECTION	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1655, '7790520008688', '	SENSATIONS GLASS	', '	GLADE	', '	HARMONY	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1656, '7790520005984', '	DISCOS ACTIVO	', '	MR. MUSCULO - GLADE	', '	CAMPOS DE LAVANDA	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1657, '7790520005953', '	DISCOS ACTIVO	', '	MR. MUSCULO _ GLADE	', '	MARINA	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1658, '7790520005960', '	DISCOS ACTIVO	', '	MR. MUSCULO - GLADE	', '	MAÑANA DE CAMPO	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1659, '7790520005977', '	DISCOS ACTIVO	', '	MR. MUSCULO - GLADE	', '	CAMPOS DE LAVANDA	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1660, '7790520010438', '	DISCOS ACTIVO	', '	MR. MUSCULO - GLADE	', '	MARINA	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1661, '779325330081', '	CANASTA	', '	AYUDIN	', '	NULL	', NULL, '16.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1662, '7790520985736', '	BLOQUE MOCHILA	', '	LYSOFORM	', '	NULL	', NULL, '35.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1663, '7790520987748', '	BLOQUE MOCHILA	', '	MR. MUSCULO	', '	MARINA	', NULL, '48.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1664, '7791130000840', '	BLOQUE MOCHILA	', '	HARPIC	', '	MARINA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1665, '7790520008909', '	CANASTA LIQUIDA	', '	MR. MUSCULO	', '	MARINA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1666, '7790520008916', '	CANASTA LIQUIDA	', '	MR. MUSCULO	', '	MARINA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1667, '7790520009029', '	CANASTA LIQUIDA	', '	MR. MUSCULO	', '	PINO	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1668, '7790520008886', '	CANASTA LIQUIDA	', '	GLADE	', '	I LOVE YOU	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1669, '7790520008831', '	CANASTA LIQUIDA	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1670, '7790520988232', '	CANASTA LIQUIDA	', '	LYSOFORM	', '	ELIMINADOR DE OLORES	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1671, '7790520008879', '	CANASTA LIQUIDA	', '	GLADE	', '	BRISA DE LAS CUMBRES	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1672, '7790520988249', '	CANASTA LIQUIDA	', '	LYSOFORM	', '	ELIMINADOR DE OLORES	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1673, '7790520009449', '	PASTILLA	', '	GLADE	', '	BOSQUE DE PINOS - BRISA DE LAS CUMBRES	', NULL, '25.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1674, '7790520009432', '	PASTILLA	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '25.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1675, '7790520011879', '	CANASTA	', '	GLADE	', '	BRISA DE MAR - CAMPOS DE LAVANDA	', NULL, '27.50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1676, '7790520987112', '	CANASTA	', '	GLADE	', '	ROCIO FRUTAL	', NULL, '27.50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1677, '7793253300258', '	PASTILLA	', '	PINO LUZ	', '	PINO - LAVANDA	', NULL, '20.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1678, '7793253300272', '	PASTILLA	', '	POETT	', '	BRISA POLAR - PRIMAVERA	', NULL, '25.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1679, '7790520008671', '	SENSATIONS REPUESTO	', '	GLADE	', '	PARAISO AZUL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1680, '7790520008633', '	SENSATIONS REPUESTO	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1681, '7790520008626', '	SENSATIONS REPUESTO	', '	GLADE	', '	NECTAR DE FLORES	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1682, '7790520008664', '	SENSATIONS REPUESTO	', '	GLADE	', '	LAVANDA	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1683, '7790520008602', '	SENSATIONS REPUESTO	', '	GLADE	', '	HARMONY	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1684, '7790520008619', '	SENSATIONS REPUESTO	', '	GLADE	', '	I LOVE YOU	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1685, '7790520008657', '	SENSATIONS REPUESTO	', '	GLADE	', '	FLORAL PERFECTION	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1686, '7790520011862', '	CANASTA	', '	GLADE	', '	BRISA DE MAR - CAMPOS DE LAVANDA	', NULL, '27.50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1687, '7793253300180', '	PASTILLA	', '	POETT	', '	LAVANDA	', NULL, '25.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1688, '7790900015114', '	ANTIHUMEDAD MINI	', '	AIRE PUR	', '	LAVANDA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1689, '7790900015138', '	ANTIHUMEDAD MINI	', '	AIRE PUR	', '	LIMON	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1690, '7790900015176', '	ANTIHUMEDAD MINI + ANTIPOLILLAS	', '	AIRE PUR	', '	CEDRO	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1691, '7790900015152', '	ANTIHUMEDAD MINI	', '	AIRE PUR	', '	PINO	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1692, '7790900015169', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	PINO	', NULL, '350.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1693, '7790900015121', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	LAVANDA	', NULL, '350.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1694, '7790900015145', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	LIMON	', NULL, '350.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1695, '7790900015183', '	ANTIHUMEDAD MAX + ANTIPOLILLAS	', '	AIRE PUR	', '	CEDRO	', NULL, '350.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1696, '7790900016067', '	ANTIHUMEDAD MAX + ABSORVE OLORES	', '	AIRE PUR	', '	NEUTRO	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1697, '7790900016661', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	LAVANDA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1698, '7790900016876', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	VAINILLA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1699, '7790900016869', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	LAVANDA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1700, '4894095614411', 'GUANTES DE LATEX	', 'HOUSEHOLD	', 'NULL	', '', '', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1701, '7797390494979', '	GUANTES DE LATEX	', '	LIMPI	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1702, '7794321006096', '	GUANTES DE LATEX	', '	TASK NARANJA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1703, '7794321006119', '	GUANTES DE LATEX	', '	TASK NARANJA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1704, '7794321006102', '	GUANTES DE LATEX	', '	TASK NARANJA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1705, '7794321006065', '	GUANTES DE LATEX	', '	TASK AMARILLO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1706, '7794321006072', '	GUANTES DE LATEX	', '	TASK AMARILLO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1707, '7794321006089', '	GUANTES DE LATEX	', '	TASK AMARILLO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1708, '7794440045914', '	GUANTES DE LATEX	', '	PLUMITA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1709, '7794440045921', '	GUANTES DE LATEX	', '	PLUMITA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1710, '7794440045938', '	GUANTES DE LATEX	', '	PLUMITA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1711, '779808381506', '	GUANTES DE LATEX	', '	PATITO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1712, '7798008381513', '	GUANTES DE LATEX	', '	PATITO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1713, '7798008381520', '	GUANTES DE LATEX	', '	PATITO	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1714, '7798014060051', '	GUANTES DE LATEX	', '	DISMAR	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1715, '7798014060068', '	GUANTES DE LATEX	', '	DISMAR	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1716, '7798014060044', '	GUANTES DE LATEX	', '	DISMAR	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1717, '7794440045419', '	GUANTES DE LATEX	', '	VIRULANA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1718, '7794440045426', '	GUANTES DE LATEX	', '	VIRULANA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1719, '7794440045433', '	GUANTES DE LATEX	', '	VIRULANA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1720, '8004200128702', '	GUANTES DE LATEX	', '	MAPA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1721, '8004200128801', '	GUANTES DE LATEX	', '	MAPA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1722, '8004200128900', '	GUANTES DE LATEX	', '	MAPA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1723, '8004200129006', '	GUANTES DE LATEX	', '	MAPA	', '	NULL	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1724, '7790520009135', '	ACEITES NATURALES	', '	GLADE	', '	VAINILLA - HARMONY - MAÑANA	', NULL, '21', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1725, '7790520009081', '	ACEITES NATURALES	', '	GLADE	', '	EXPLOSION FLORAL	', NULL, '21.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1726, '7790520009180', '	ACEITES NATURALES	', '	GLADE	', '	VAINILLA	', NULL, '21.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1727, '7790520009197', '	ACEITES NATURALES	', '	GLADE	', '	LAVANDA	', NULL, '21.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1728, '7790520009159', '	ACEITES NATURALES	', '	GLADE	', '	MANZANA Y CANELA	', NULL, '21.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1729, '7790900015909', '	HUEVO CARBON P/HELADERA	', '	AIRE PUR	', '	SIN OLOR	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1730, '7790900035792', '	ANTIHUMEDAD PERCHA + ANTIPOLILLA	', '	AIRE PUR	', '	CEDRO	', NULL, '350.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1731, '7790900025656', '	ANTIHUMEDAD PLACARD FRESH	', '	AIRE PUR	', '	ROSAS	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1732, '7790900025755', '	ANTIHUMEDAD TECNO GEL	', '	AIRE PUR	', '	LAVANDA	', NULL, '36.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1733, '7790900004996', '	DISCO ANTIPOLILLA	', '	AIRE PUR	', '	LAVANDA	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1734, '7790900004903', 'DESODORANTE P/ HELADERA	', 'AIRE PUR	', 'MANZANA - LIMON	', '', '11.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1735, '7790900004989', '	PERCHA ANTIPOLILLA	', '	IBERIA	', '	LAVANDA	', NULL, '40.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1736, '7790520005816', '	INSECTICIDA	', '	FUYI	', '	MMM	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 18),
(1737, '7793253001315', '	INSECTICIDA	', '	SELTON	', '	MMM	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(1738, '7793253292553', '	INSECTICIDA	', '	SELTON	', '	CUCARACHAS Y HORMIGAS	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1739, '7790520009661', '	INSECTICIDA	', '	RAID	', '	MMM	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 36),
(1740, '7790520009906', '	INSECTICIDA	', '	RAID	', '	PULGAS Y GARRAPATAS	', NULL, '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, -5, 2),
(1741, '7790520009630', 'DESINFECTANTE	', 'LYSOFORM	', 'CITRICA	', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1742, '7790520009593', 'DESINFECTANTE', 'LYSOFORM	', 'ORIGINAL	', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1743, '7790520009647', 'DESINFECTANTE	', 'LYSOFORM	', 'AIRE DE MONTAÑA	', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1744, '7790520009623', 'DESINFECTANTE	', 'LYSOFORM	', 'FLORAL	', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1745, '7790520009616', 'DESINFECTANTE	', 'LYSOFORM	', 'BEBE	', '', '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1746, '7793253000967', 'DESINFECTANTE	', 'AYUDIN	', 'BEBE	', '', '332.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1747, '7793253000943', 'DESINFECTANTE	', 'AYUDIN	', 'ORIGINAL	', '', '332.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1748, '7793253000950', 'DESINFECTANTE', 'AYUDIN', 'FRESCURA MATINAL', '', '332.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1749, '7790520014382', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1750, '7790520011084', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	TROPICAL TWIST	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1751, '7790520008060', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	POTPOURRI	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1752, '7790520014337', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	ANTITABACO	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1753, '7790520014344', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	CAMPOS DE JAZMIN	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1754, '7790520014450', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	PARAISO AZUL	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1755, '7790520014467', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	VAINILLA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1756, '7790520014368', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	SPA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1757, '7790520014436', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	HARMONY	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1758, '7790520008077', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	BRISA DE LAS CUMBRES	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1759, '7790520014351', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	I LOVE YOU	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1760, '7790520014405', '	DESODORANTE DE AMBIENTE	', '	GLADE	', '	CARICIAS DE ALGODON	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, -4, 3),
(1761, '7790520009920', '	INSECTICIDA	', '	RAID	', '	HORMIGAS	', NULL, '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1762, '7790520007711', '	INSECTICIDA	', '	RAID	', '	DOBLE ACCION	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1763, '7790520010124', '	INSECTICIDA	', '	RAID	', '	CUCARACHAS	', NULL, '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1764, '7790520009715', '	INSECTICIDA	', '	RAID	', '	CUCARACHAS Y ARAÑAS S/OLOR	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1765, '7790520009890', '	INSECTICIDA	', '	RAID	', '	POLILLAS Y LARVAS	', NULL, '390.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1766, '7790520007360', '	LUSTRAMUEBLES	', '	BLEM	', '	LAVANDA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1767, '7790520007353', '	LUSTRAMUEBLES	', '	BLEM	', '	ORIGINAL	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1768, '7790520007377', '	LUSTRAMUEBLES	', '	BLEM	', '	NARANJA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1769, '7790520004307', '	LUSTRAMUEBLES	', '	BLEM	', '	SUPERFICIES ELECTRONICAS	', NULL, '235.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1770, '7790520981974', '	LUSTRAMUEBLES	', '	CERAMICOL	', '	C/ SILICONAS	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(1771, '7796679000511', '	LUSTRAMUEBLES	', '	FACILLIM	', '	ORIGINAL	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1772, '7790520981967', '	LIMPIAHORNOS	', '	MR. MUSCULO	', '	NULL	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1773, '7798057867778', '	ESPUMA LIMPIADORA	', '	LEM	', '	NULL	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1774, '7793253011062', '	DESODORANTE DE AMBIENTE	', '	POETT	', '	BOSQUE DE BAMBU	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1775, '7793253011024', '	DESODORANTE DE AMBIENTE	', '	POETT	', '	PRIMAVERA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1776, '7793253043216', '	DESODORANTE DE AMBIENTE	', '	POETT	', '	VAINILLA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1777, '7791293027739', '	DESODORANTE	', '	PATRICHS	', '	TERRA	', NULL, '164.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1778, '7791293027715', '	DESODORANTE	', '	PATRICHS	', '	NOIR	', NULL, '164.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1779, '7791293027746', '	DESODORANTE	', '	PATRICHS	', '	AIR	', NULL, '164.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1780, '7791293027722', '	DESODORANTE	', '	PATRICHS	', '	L`UOMO	', NULL, '164.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1781, '7791600571535', '	DESODORANTE	', '	COLBERT	', '	PINO	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1782, '7791600174651', '	DESODORANTE	', '	COLBERT	', '	NOIR	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1783, '7791600742478', '	DESODORANTE	', '	COLBERT	', '	SPACE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1784, '7791600087128', '	DESODORANTE	', '	COLBERT	', '	US	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1785, '7791600192372', '	DESODORANTE	', '	COLBERT	', '	ORIGINAL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1786, '7791600037239', '	DESODORANTE	', '	KEVIN	', '	ROJO	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1787, '7791600018344', '	DESODORANTE	', '	KEVIN	', '	BLACK	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1788, '7791600060473', '	DESODORANTE	', '	CHESTER ICE	', '	NULL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1789, '7791293022567', '	DESODORANTE	', '	REXONA	', '	MEN V8	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1790, '7791293022581', '	DESODORANTE	', '	REXONA	', '	MEN XTRACOOL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1791, '7795646108052', '	DESODORANTE	', '	ADIDAS	', '	ICE DIVE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1792, '7795646145415', '	DESODORANTE	', '	ADIDAS	', '	SPECIAL EDITION	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1793, '7795646561055', '	DESODORANTE	', '	ADIDAS	', '	DYNAMIC PULSE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1794, '7795646381202', '	DESODORANTE	', '	ADIDAS	', '	PURE GAME	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1795, '7795646561208', '	DESODORANTE	', '	ADIDAS	', '	DYNAMIC PULSE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1796, '7795646145446', '	DESODORANTE	', '	ADIDAS	', '	GET READY	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1797, '7791293022437', '	DESODORANTE	', '	AXE	', '	MARINE	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1798, '7791293023335', '	DESODORANTE	', '	AXE	', '	PEACE	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1799, '7791293029436', '	DESODORANTE	', '	AXE	', '	BLACK	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1800, '7791293020365', '	DESODORANTE	', '	AXE	', '	EXCITE	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1801, '7791293149202', '	DESODORANTE	', '	AXE SECO	', '	ULTRA FOCUS	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1802, '7899089408738', '	DESODORANTE	', '	AVON	', '	AROMADISIAC	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1803, '7899089402330', '	DESODORANTE	', '	AVON	', '	TREKKING	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1804, '7899089408721', '	DESODORANTE	', '	AVON	', '	TRUE FORCE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1805, '7899089448840', '	DESODORANTE	', '	AVON	', '	TREKKING	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1806, '7899089447508', '	DESODORANTE	', '	AVON	', '	BLUE BLAZER	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1807, '7899089448802', '	DESODORANTE	', '	AVON	', '	WILD COUNTRY	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1808, '7899089447058', '	DESODORANTE	', '	AVON	', '	SWEET HONESTY	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1809, '7899089451697', '	DESODORANTE	', '	AVON	', '	TIMELESS	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1810, '7899089448666', '	DESODORANTE	', '	AVON	', '	TOQUE DE AMOR	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1811, '7899089448390', '	DESODORANTE	', '	AVON	', '	FAR AWAY	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1812, '7899089447492', '	DESODORANTE	', '	AVON	', '	PASION GITANA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1813, '7899089448383', '	DESODORANTE	', '	AVON	', '	MILLENNIA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1814, '7899089448468', '	DESODORANTE	', '	AVON	', '	IMARI	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1815, '7899089447485', '	DESODORANTE	', '	AVON	', '	TRESELLE	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1816, '7899089448413', '	DESODORANTE	', '	AVON	', '	PUR BLANCA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1817, '7798045214119', '	DESODORANTE	', '	KOSIUKO	', '	TITANIUM	', NULL, '168.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1818, '7798045214096', '	DESODORANTE	', '	KOSIUKO	', '	BLACKS	', NULL, '168.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1819, '7798045214102', '	DESODORANTE	', '	KOSIUKO	', '	BLUES	', NULL, '168.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1820, '7798045214089', '	DESODORANTE	', '	KOSIUKO	', '	ORIGINAL	', NULL, '168.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1821, '7798045214126', '	DESODORANTE	', '	KOSIUKO	', '	MUSK	', NULL, '168.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1822, '7899089408745', '	DESODORANTE	', '	AVON	', '	AROMADISIAC	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1823, '7791293021287', '	GEL P/ CABELLO	', '	LORD CHESELINE	', '	NULL	', NULL, '280.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1824, '7791293021270', '	GEL P/ CABELLO	', '	LORD CHESELINE	', '	NULL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1825, '7791293021706', '	GEL P/ CABELLO	', '	EXPLOIT	', '	NULL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1826, '7791293001586', '	DESODORANTE	', '	IMPULSE	', '	TRUE LOVE	', NULL, '81.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1827, '7791293016658', '	DESODORANTE	', '	IMPULSE	', '	VERY PINK	', NULL, '81.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1828, '7791293013084', '	DESODORANTE	', '	IMPULSE	', '	INTO GLAMOUR	', NULL, '81.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1829, '7791293001067', '	DESODORANTE	', '	IMPULSE	', '	MUSK	', NULL, '81.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1830, '7791293022642', '	DESODORANTE	', '	IMPULSE	', '	SWEET SMILE	', NULL, '81.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1831, '7791293998619', '	DESODORANTE	', '	DOVE	', '	DERMOACLARANT	', NULL, '169.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1832, '7791293008141', '	DESODORANTE	', '	DOVE	', '	ORIGINAL	', NULL, '169.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1833, '7791293014012', '	DESODORANTE	', '	DOVE	', '	BEAUTY FINISH	', NULL, '169.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1834, '7791293991276', '	DESODORANTE	', '	DOVE	', '	GO FRESH	', NULL, '169.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1835, '7791293020198', '	DESODORANTE	', '	DOVE	', '	PURE	', NULL, '169.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1836, '7791293026732', '	DESODORANTE	', '	REXONA	', '	COTTON	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1837, '7791293026831', '	DESODORANTE	', '	REXONA	', '	ACTIVE EMOTION	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1838, '7791293999470', '	DESODORANTE	', '	REXONA	', '	POWDER	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1839, '7791293026800', '	DESODORANTE	', '	REXONA	', '	BAMBOO	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1840, '7791293026923', '	DESODORANTE	', '	REXONA	', '	EXTRA FRESH	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1841, '7791293026978', '	DESODORANTE	', '	REXONA	', '	CRYSTAL	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1842, '7791600595340', '	DESODORANTE	', '	MUJERCITAS	', '	NULL	', NULL, '123.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1843, '7791600620240', '	DESODORANTE	', '	PACO	', '	FUTBOL VERDE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1844, '7793100141294', '	ENJUAGUE BUCAL	', '	COLGATE	', '	PLAX ICE	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1845, '78924468', '	DESODORANTE	', '	DOVE	', '	ORIGINAL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1846, '78931596', '	DESODORANTE	', '	DOVE	', '	PURE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1847, '77928566', '	DESODORANTE	', '	REXONA	', '	NUTRITIVE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1848, '77941909', '	DESODORANTE	', '	REXONA	', '	MEN SENSITIVE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1849, '77941923', '	DESODORANTE	', '	REXONA	', '	MEN INVISIBLE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1850, '5808307326', '	DESODORANTE	', '	NIVEA	', '	SILVER PROTECT	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1851, '7790829005609', '	DESODORANTE	', '	AVON	', '	LEGACY NOIR	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1852, '7790416066532', '	QUITAESMALTE	', '	CUTEX	', '	FORTALECEDOR	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1853, '7790416066730', '	QUITAESMALTE	', '	CUTEX	', '	TEENS	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1854, '7790416066839', '	QUITAESMALTE	', '	CUTEX	', '	REPARADOR	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1855, '7790416066624', '	QUITAESMALTE	', '	CUTEX	', '	HIPOALERGENICO	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1856, '7790416066525', '	QUITAESMALTE	', '	CUTEX	', '	FORTALECEDOR	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1857, '7790829006194', '	DESODORANTE	', '	AVON	', '	PASION GITANA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1858, '7899089427951', '	DESODORANTE	', '	AVON	', '	ON DUTY FRESH	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1859, '7899089453196', '	DESODORANTE	', '	AVON	', '	IMARI BLOSSON	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1860, '77924841', '	DESODORANTE	', '	REXONA	', '	CRYSTAL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1861, '77940704', '	DESODORANTE	', '	REXONA	', '	ODORONO	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1862, '7798021991393', '	CREMA OXIDANTE	', '	TABLADA LABORATORIO	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1863, '7798021991003', '	AGUA OXIGENADA	', '	TABLADA LABORATORIO	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1864, '7790940801067', '	HISOPOS	', '	DONCELLA	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1865, '7793100111556', '	DENTIFRICO	', '	COLGATE	', '	NULL	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1866, '7793100111594', '	DENTIFRICO	', '	COLGATE	', '	LIMON/EUCALIPTO	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1867, '7793100111143', '	DENTIFRICO	', '	COLGATE	', '	CLEAN MINT	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1868, '7793100123375', '	DENTIFRICO	', '	COLGATE	', '	NULL	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1869, '7891024123027', '	DENTIFRICO	', '	COLGATE	', '	BRILLIANT MINT	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1870, '7891024135020', '	DENTIFRICO	', '	COLGATE	', '	GEL WHITENING	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1871, '7891024137802', '	DENTIFRICO	', '	COLGATE	', '	NULL	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1872, '7509546039145', '	DENTIFRICO	', '	COLGATE	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1873, '7793100111570', '	DENTIFRICO	', '	COLGATE	', '	MENTA	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1874, '7501006710410', '	DENTIFRICO	', '	ORAL B	', '	MENTA SUAVE	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1875, '7891024139165', '	DENTIFRICO	', '	ODOLITO	', '	FRUTILLA DELICIOSA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1876, '7793100130083', '	DENTIFRICO	', '	ODOL	', '	ORIGINAL	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(1877, '7793100120206', '	DENTIFRICO	', '	KOLYNOS	', '	NULL	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1878, '7702003469237', '	TELA ELASTICA	', '	CURITAS	', '	NULL	', NULL, '10.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1879, '7790940003065', '	ALGODON HIDROFILO	', '	DONCELLA	', '	NULL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1880, '7790064000261', '	ALGODON HIDROFILO	', '	ESTRELLA	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1881, '7790940003034', '	ALGODON HIDROFILO	', '	DONCELLA	', '	NULL	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1882, '7796613002809', '	PAÑUELOS DESCARTABLES	', '	M&K	', '	NULL	', NULL, '10.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 36),
(1883, '7790250054726', '	PAÑUELOS DESCARTABLES	', '	ELITE	', '	SIN PERFUME	', NULL, '6x1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1884, '7798062050066', '	TOALLITAS HUMEDAS P/BEBES	', '	SAPO PEPE	', '	CON MANZANILLA	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1885, '7796613004445', '	TOALLITAS HUMEDAS P/BEBES	', '	M&K	', '	NULL	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1886, '7790940215079', '	TOALLITAS HUMEDAS P/BEBES	', '	BABYLOOK	', '	ALOE	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1887, '773090295529', '	TOALLITAS HUMEDAS P/BEBES	', '	BELABIN	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1888, '7790770001552', '	PROTECTOR DIARIO	', '	CALIPSO	', '	ALOE VERA	', NULL, '20.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1889, '7790250096481', '	PROTECTOR DIARIO	', '	LADYSOFT	', '	GEL ABSORVENTE	', NULL, '20.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1890, '7790770000517', '	TOALLA FEMENINA	', '	CALIPSO	', '	ALOE VERA	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1891, '7790940235084', '	PROTECTOR DIARIO	', '	DONCELLA	', '	CON DESODORANTE	', NULL, '20.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1892, '7790940233264', 'PROTECTOR DIARIO	', 'DONCELLA	', 'CON DESODORANTE', '', '20.00', 0, NULL, NULL, 3, NULL, 0, 100, 0, 8),
(1893, '7790010570343', '	TOALLA FEMENINA	', '	SIEMPRE LIBRE	', '	NULL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1894, '7794626004414', '	TOALLA FEMENINA	', '	LINA	', '	NULL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1895, '7790770000531', '	TOALLA FEMENINA	', '	CALIPSO	', '	ALOE VERA	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1896, '7790940235077', '	PROTECTOR DIARIO	', '	DONCELLA	', '	SIN DESODORANTE	', NULL, '20.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1897, '7790770001231', '	TOALLA FEMENINA	', '	CALIPSO	', '	MANZANILLA	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1898, '7506309860503', '	TOALLA FEMENINA	', '	ALWAYS	', '	NULL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1899, '7506339301595', '	TOALLA FEMENINA	', '	ALWAYS	', '	NULL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1900, '7790250098027', '	TOALLA FEMENINA	', '	LADYSOFT	', '	NULL	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1901, '7798057860045', '	ESPUMA LIMPIADORA	', '	LEM	', '	NULL	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1902, '7791290008496', '	LIMPIADOR CREMOSO	', '	CIF	', '	ORIGINAL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1903, '7791290008007', '	LIMPIADOR CREMOSO	', '	CIF	', '	ORIGINAL	', NULL, '375.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(1904, '7791290008472', '	LIMPIADOR CREMOSO	', '	CIF	', '	LIMON	', NULL, '375.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1905, '7791290004078', '	LIMPIADOR CREMOSO	', '	CIF	', '	C/LAVANDINA	', NULL, '375.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1906, '7791290008465', '	LIMPIADOR CREMOSO	', '	CIF	', '	FLORES DE NARANJO	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1907, '7791290008458', '	LIMPIADOR CREMOSO	', '	CIF	', '	LIMON	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1908, '7791290008441', '	LIMPIADOR CREMOSO	', '	CIF	', '	ORIGINAL	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1909, '7791290000407', '	LIMPIADOR CREMOSO	', '	CIF	', '	C/CLORO ACTIVO	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1910, '7791290004061', '	LIMPIADOR CREMOSO	', '	CIF	', '	C/LAVANDINA	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1911, '7791290010208', '	LIMPIADOR CREMOSO	', '	CIF	', '	ULTRA BLANCO	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1912, '7791290010215', '	LIMPIADOR CREMOSO	', '	CIF	', '	NO DEJA RESIDUOS	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1913, '7791290005723', '	LAVANDINA EN GEL	', '	VIM	', '	ORIGINAL	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1914, '7791290677586', '	LIMPIADOR CREMOSO	', '	CIF	', '	ORIGINAL	', NULL, '3.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1915, '7791290677609', '	LIMPIADOR CREMOSO	', '	CIF	', '	C/LAVANDINA	', NULL, '2.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1916, '7791290010222', '	ANTIGRASA	', '	CIF	', '	NULL	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(1917, '7791290007505', '	VIDRIOS	', '	CIF	', '	NULL	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, -2, 10),
(1918, '7791290007406', '	BAÑO	', '	CIF	', '	NULL	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1919, '7790520012463', '	VIDRIOS Y MULTIUSO	', '	MR. MUSCULO	', '	NULL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1920, '7790520552501', '	ANTIGRASA	', '	MR. MUSCULO	', '	NULL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1921, '7790520155245', '	ANTIGRASA	', '	MR. MUSCULO	', '	NULL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1922, '7790520012432', '	COCINA	', '	MR. MUSCULO	', '	NARANJA	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1923, '7790520010599', '	DESINFECTANTE P/PISOS	', '	LYSOFORM	', '	ORIGINAL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1924, '7790520006769', '	VIDRIOS Y MULTIUSO	', '	MR. MUSCULO	', '	FRUTOS ROJOS	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1925, '7790520005571', '	CERA PARA PISOS FLOTANTES	', '	BLEM	', '	ALMENDRAS	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1926, '7790520009050', '	CERA PARA PISOS FLOTANTES	', '	BLEM	', '	FLORAL	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1927, '7790520012166', '	CERA PARA PISOS	', '	CERAMICOL	', '	INCOLORA	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1928, '7790520007964', '	CERA PARA PISOS	', '	BLEM	', '	ROJO	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1929, '7790520007957', '	CERA PARA PISOS	', '	BLEM	', '	INCOLORA FLORAL	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1930, '7790520010353', '	LIMPIADOR LIQUIDO CON BRILLO	', '	ECHO	', '	CLASICO	', NULL, '450.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1931, '7790520007841', '	CERA P/PISOS	', '	BLEM	', '	NEGRO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1932, '7790520007872', '	CERA P/PISOS	', '	BLEM	', '	INCOLORA FLORAL	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1933, '7790520007865', '	CERA P/PISOS	', '	BLEM	', '	ROJO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1934, '7790520010377', '	LIMPIADOR LIQUIDO C/BRILLO	', '	ECHO	', '	LAVANDA	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1935, '7790520010360', '	LIMPIADOR LIQUIDO C/BRILLO	', '	ECHO	', '	CLASICO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1936, '7791290007260', '	LIMPIADOR LIQUIDO GEL	', '	CIF	', '	OCEAN	', NULL, '750.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1937, '7791130148351', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	FLORES DEL JARDIN	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1938, '7791130148627', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	TROPICAL	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1939, '7791130148092', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	PINO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1940, '7791130148245', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	LAVANDA	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1941, '7791130148009', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	MARINA	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1942, '7791130002004', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	FRUTOS ROJOS	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1943, '7791130146029', '	LIMPIADOR LIQUIDO	', '	PROCENEX	', '	ORIGINAL	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1944, '7793699045720', '	LIMPIADOR LIQUIDO	', '	SEDILEE	', '	CITRICO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1945, '7793699045713', '	LIMPIADOR LIQUIDO	', '	SEDILEE	', '	LAVANDA	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1946, '7793699000309', '	LIMPIADOR LIQUIDO	', '	SEDILEE	', '	MARINA	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1947, '7793699045737', '	LIMPIADOR LIQUIDO	', '	SEDILEE	', '	CHERRY	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1948, '7793699045706', '	LIMPIADOR LIQUIDO	', '	SEDILEE	', '	PINO	', NULL, '900.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1949, '7791293027777', '	TALCO PARA PIES	', '	REXONA EFFICIENT	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(1950, '7791293027760', '	TALCO PARA PIES	', '	REXONA EFFICIENT	', '	NULL	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1951, '7791293895062', '	TALCO PARA PIES	', '	REXONA EFFICIENT	', '	NULL	', NULL, '177.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1952, '7791274009532', '	TALCO PARA PIES	', '	ALGABO	', '	NULL	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1953, '7791274187742', '	TALCO PARA PIES	', '	ALGABO	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(1954, '7791520009705', '	TALCO CORPORAL	', '	VERITAS	', '	FRESCO	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1955, '7791520009682', '	TALCO CORPORAL	', '	VERITAS	', '	MUJER	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1956, '7791520009675', '	TALCO CORPORAL	', '	VERITAS	', '	CLASICO	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1957, '7791520009699', '	TALCO CORPORAL	', '	VERITAS	', '	HOMBRE	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1958, '7506309895437', '	SHAMPOO/ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	2 EN 1 SUAVE Y MANEJABLE	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1959, '7506309895284', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	RELAX	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1960, '7501007496498', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	HUMECTA	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1961, '7506309895246', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	MANZANA FRESH	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1962, '7506309897578', '	SHAMPOO	', '	HEAD & SHOULDERS	', '	MANZANA FRESH	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1963, '7506309878096', '	SHAMPOO	', '	PANTENE	', '	CUIDADO CLASICO	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1964, '7506309878140', '	SHAMPOO	', '	PANTENE	', '	CONTROL CAIDA	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(1965, '7791293025001', '	DESODORANTE	', '	AXE	', '	GOLDTEMPATION	', NULL, '160.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1966, '7506309895390', '	SHAMPOO	', '	HEAD & SHOULDERS	', '	RELAX	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1967, '7506309895291', '	SHAMPOO	', '	HEAD & SHOULDERS	', '	MEN PREVENCION CAIDA	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1968, '7506309894485', '	SHAMPOO	', '	HEAD & SHOULDERS	', '	MEN OLD SPICE	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1969, '7506195143339', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	PROTECCION CAIDA	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1970, '7506309895253', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	HUMECTA	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1971, '7506195120330', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	MANZANA FRESH	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1972, '7506195143346', '	ACONDICIONADOR	', '	HEAD & SHOULDERS	', '	RELAX	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1973, '7506309845258', '	SHAMPOO	', '	PANTENE	', '	LISO EXTREMO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1974, '7506309845227', '	SHAMPOO	', '	PANTENE	', '	BRILLO EXTREMO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1975, '7506309845012', '	SHAMPOO	', '	PANTENE	', '	REPARACION REJUVENECEDORA	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1976, '7506309877914', '	SHAMPOO/ACONDICIONADOR	', '	PANTENE	', '	2 EN 1 CUIDADO CLASICO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1977, '7506309877648', '	ACONDICIONADOR	', '	PANTENE	', '	BRILLO EXTREMO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1978, '7506309877778', '	ACONDICIONADOR	', '	PANTENE	', '	RESTAURACION	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1979, '7506309877723', '	ACONDICIONADOR	', '	PANTENE	', '	HIDRATACION	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1980, '8760134', '	COLONIA	', '	AVON	', '	WILD COUNTRY	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1981, '8760137', '	COLONIA	', '	AVON	', '	LEGACY NOIR	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1982, '8760133', '	COLONIA	', '	AVON	', '	BLACK SUEDE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1983, '8760135', '	COLONIA	', '	AVON	', '	BLUE BLAZER	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1984, '8760128', '	COLONIA	', '	AVON	', '	MILLENNIA	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1985, '7790829004930', '	COLONIA	', '	AVON	', '	IMARI	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1986, '7790829009256', '	COLONIA	', '	AVON	', '	PASION GITANA	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1987, '7899089480130', '	COLONIA	', '	AVON	', '	TOQUE DE AMOR	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1988, '7899089480109', '	COLONIA	', '	AVON	', '	SURREAL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1989, '789908940161', '	COLONIA	', '	AVON	', '	PUR BLANCA	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1990, '7899089480123', '	COLONIA	', '	AVON	', '	FAR AWAY	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1991, '7898587761901', '	ACONDICIONADOR	', '	ELVIVE	', '	RE-NUTRICION	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1992, '7898587774925', '	ACONDICIONADOR	', '	ELVIVE	', '	OLEO EXTRAORDINARIO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1993, '7898587762106', '	ACONDICIONADOR	', '	ELVIVE	', '	CAIDA RESIST	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1994, '7898587761888', '	ACONDICIONADOR	', '	ELVIVE	', '	COLOR-VIVE	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(1995, '7898587761925', '	ACONDICIONADOR	', '	ELVIVE	', '	REPARACION TOTAL 5+	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1996, '7899026487055', '	ACONDICIONADOR	', '	ELVIVE	', '	KERA-LISO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1997, '7899026469136', '	SHAMPOO	', '	ELVIVE	', '	LISS-INTENSE	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1998, '7899026469297', '	SHAMPOO	', '	ELVIVE	', '	VOLUME-CONTROL	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(1999, '7899026469051', '	SHAMPOO	', '	ELVIVE	', '	NUTRI-GLOSS	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2000, '7899026421813', '	SHAMPOO	', '	ELVIVE	', '	RE-NUTRICION	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2001, '7791293027623', '	SHAMPOO	', '	DOVE	', '	OLEO NUTRICION	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2002, '7891150022645', '	SHAMPOO	', '	DOVE	', '	POST ALISADO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2003, '7791293027524', '	SHAMPOO	', '	DOVE	', '	RECONSTRUCCION COMPLETA	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4);
INSERT INTO `Productos` (`productoID`, `codigo`, `nombre`, `marca`, `fragancia`, `caracteristica`, `medida`, `precioVenta`, `unidadMedidaID`, `tipoProductoID`, `tipoRubroID`, `ultimaActualizacionStock`, `inventarioID`, `precioFinalAFacturar`, `stockactual`, `stockMinimo`) VALUES
(2004, '7791293027081', '	SHAMPOO	', '	SEDAL	', '	CREMA BALANCE	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2005, '7791293020785', '	SHAMPOO	', '	SEDAL	', '	COLOR VITAL	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2006, '7791293027258', '	SHAMPOO	', '	SEDAL	', '	CERAMIDAS	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2007, '7791293027395', '	SHAMPOO	', '	SEDAL	', '	LISO PERFECTO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2008, '7791293027456', '	SHAMPOO	', '	SEDAL	', '	RIZOS OBEDIENTES	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2009, '7791293022963', '	SHAMPOO	', '	SEDAL	', '	POST ALISADO QUIMICO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2010, '7791293020792', '	ACONDICIONADOR	', '	SEDAL	', '	COLOR VITAL	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2011, '7791293027296', '	ACONDICIONADOR	', '	SEDAL	', '	CERAMIDAS	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2012, '7791293027425', '	ACONDICIONADOR	', '	SEDAL	', '	LISO PERFECTO	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2013, '7506309845036', '	SHAMPOO	', '	PANTENE	', '	REPARACION REJUVENECEDORA	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2014, '7506309877983', '	SHAMPOO/ACONDICIONADOR	', '	PANTENE	', '	2 EN 1 HIDRATACION	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2015, '7506309845272', '	SHAMPOO	', '	PANTENE	', '	LISO EXTREMO	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2016, '7506309899084', '	ACONDICIONADOR	', '	PANTENE	', '	LISO EXTREMO	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2017, '7506309863306', '	ACONDICIONADOR	', '	PANTENE	', '	REPARACION REJUVENECEDORA	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2018, '7506309877617', '	ACONDICIONADOR	', '	PANTENE	', '	RIZOS DEFINIDOS	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2019, '7506309877655', '	ACONDICIONADOR	', '	PANTENE	', '	BRILLO EXTREMO	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2020, '7506309877549', '	ACONDICIONADOR	', '	PANTENE	', '	CUIDADO CLASICO	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2021, '7506309877693', '	ACONDICIONADOR	', '	PANTENE	', '	CONTROL CAIDA	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2022, '7506309840581', '	ACONDICIONADOR	', '	PANTENE	', '	HIDRO-CAUTERIZACION	', NULL, '400.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2023, '7798129700323', '	AROMATIZADOR AUTOMATICO	', '	NEW SCENT	', '	DOBLE PROGRAMACION	', NULL, '1.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2024, '7798129700200', '	AROMATIZADOR AUTOMATICO	', '	NEW SCENT	', '	SIMPLE PROGRAMACION	', NULL, '1.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2025, '7798129700316', '	AROMATIZADOR AUTOMATICO	', '	NEW SCENT	', '	C/TOQUE	', NULL, '1.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2026, '7790829008204', '	SHAMPOO	', '	AVON	', '	RESTAURACION INTENSIVA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2027, '7790829008594', '	SHAMPOO	', '	AVON	', '	RIZOS DEFINIDOS	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2028, '7899089436281', '	SHAMPOO	', '	AVON	', '	NUTRICION COMPLETA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2029, '7899089448444', '	SHAMPOO	', '	AVON	', '	CONTROL CAIDA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2030, '8757645', '	SHAMPOO	', '	AVON	', '	CONTROL DEL VOLUMEN	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2031, '7790829008471', '	SHAMPOO	', '	AVON	', '	RESULTADOS DIARIOS	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2032, '7899089436519', '	SHAMPOO/ACONDICIONADOR	', '	AVON	', '	2 EN 1 KEEP CLEAR	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2033, '8757640', '	ACONDICIONADOR	', '	AVON	', '	RESTAURACION INTENSIVA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2034, '7790829008587', '	ACONDICIONADOR	', '	AVON	', '	RIZOS DEFINIDOS	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2035, '7899089436274', '	ACONDICIONADOR	', '	AVON	', '	NUTRICION COMPLETA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2036, '7899089448536', '	ACONDICIONADOR	', '	AVON	', '	CONTROL CAIDA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2037, '7790829008273', '	ACONDICIONADOR	', '	AVON	', '	CONTROL DEL VOLUMEN	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2038, '8757676', '	ACONDICIONADOR	', '	AVON	', '	RESULTADOS DIARIOS	', NULL, '250', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2039, '7899089431613', '	CREMA TRATAMIENTO PELO	', '	AVON	', '	RESTAURACION INTENSIVA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2040, '8740944', '	EMULSION P/DESPUES DE AFEITARSE	', '	AVON	', '	WILD COUNTRY	', NULL, '85.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2041, '7790829001199', '	EMULSION P/DESPUES DE AFEITARSE	', '	AVON	', '	BLACK SUEDE	', NULL, '85.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2042, '7790139000318', '	ALCOHOL DE QUEMAR	', '	FORMULA HOGAR	', '	NULL	', NULL, '1.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2043, '7790139003623', '	ALCOHOL ETILICO	', '	PORTA	', '	NULL	', NULL, '1.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2044, '7790139003630', '	ALCOHOL ETILICO	', '	PORTA	', '	NULL	', NULL, '500.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2045, '7790139003616', '	ALCOHOL ETILICO	', '	PORTA	', '	NULL	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(2046, '3014260273903', '	ESPUMA DE AFEITAR	', '	GILLETTE	', '	REGULAR	', NULL, '312.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2047, '7702018013333', '	ESPUMA DE AFEITAR	', '	GILLETTE	', '	CITRICO	', NULL, '312.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2048, '7702018013326', '	ESPUMA DE AFEITAR	', '	GILLETTE	', '	PIEL SENSIBLE	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2049, '7702018053483', '	ESPUMA DE AFEITAR	', '	GILLETTE	', '	REGULAR	', NULL, '175.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2050, '7794490610322', '	CREMA CORPORAL	', '	HINDS	', '	ROSA	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2051, '7794640610318', '	CREMA CORPORAL	', '	HINDS	', '	ROSA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2052, '7791293026275', '	SHAMPOO	', '	SUAVE	', '	MIEL Y ALMENDRAS	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2053, '7791293026428', '	SHAMPOO	', '	SUAVE	', '	CITRICOS Y TE VERDE	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2054, '7791293026404', '	SHAMPOO	', '	SUAVE	', '	LAVANDA Y BAMBU	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2055, '7791293026442', '	SHAMPOO	', '	SUAVE	', '	CREMA Y PERA	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2056, '7791293026244', '	SHAMPOO	', '	SUAVE	', '	MANZANA VERDE	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2057, '7791293026305', '	SHAMPOO	', '	SUAVE	', '	COCO Y LECHE	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2058, '7791293026459', '	ACONDICIONADOR	', '	SUAVE	', '	CREMA Y PERA	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2059, '7791293026329', '	ACONDICIONADOR	', '	SUAVE	', '	COCO Y LECHE	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2060, '7791293026411', '	ACONDICIONADOR	', '	SUAVE	', '	LAVANDA Y BAMBU	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2061, '7791293026251', '	ACONDICIONADOR	', '	SUAVE	', '	MANZANA VERDE	', NULL, '930.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2062, '7790740528942', '	SHAMPOO	', '	PLUSBELLE	', '	ORQUIDEA Y ARGAN	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2063, '7790740505547', '	SHAMPOO	', '	PLUSBELLE	', '	ALMENDRAS Y VITAMINA A	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2064, '7790740505554', '	SHAMPOO	', '	PLUSBELLE	', '	LECHE DE COCO Y QUINOA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2065, '7790740505516', '	SHAMPOO	', '	PLUSBELLE	', '	MICROALGAS Y MENTA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2066, '7790740505509', '	SHAMPOO	', '	PLUSBELLE	', '	CERAMIDAS ACTIVAS	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2067, '7790740502430', '	ACONDICIONADOR	', '	PLUSBELLE	', '	ALMENDRAS Y VITAMINA A	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2068, '7790740502485', '	ACONDICIONADOR	', '	PLUSBELLE	', '	TE Y ACIDO HIALURONICO	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2069, '7790740502423', '	ACONDICIONADOR	', '	PLUSBELLE	', '	ACEITE DE PALTA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2070, '7790740502416', '	ACONDICIONADOR	', '	PLUSBELLE	', '	MANZANA Y PERA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2071, '7790740502409', '	ACONDICIONADOR	', '	PLUSBELLE	', '	MICROALGAS Y MENTA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2072, '7790740502393', '	ACONDICIONADOR	', '	PLUSBELLE	', '	CERAMIDAS ACTIVAS	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2073, '7790740502478', '	ACONDICIONADOR	', '	PLUSBELLE	', '	POMELO Y VERBENA	', NULL, '1000.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2074, '7798092967334', '	AROMATIZANTE	', '	MAKE	', '	KONI	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2075, '7798092966351', '	AROMATIZANTE	', '	MAKE	', '	NATURAL CELEBRITY	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2076, '7798092965927', '	AROMATIZANTE	', '	MAKE	', '	HAPPY BABY	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2077, '7798092964999', '	AROMATIZANTE	', '	MAKE	', '	ANTITABACO	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2078, '7798092965354', '	AROMATIZANTE	', '	MAKE	', '	CITRICO	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2079, '7798092967341', '	AROMATIZANTE	', '	MAKE	', '	LIMON	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2080, '7798092965422', '	AROMATIZANTE	', '	MAKE	', '	MISTERIO	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2081, '7798092965446', '	AROMATIZANTE	', '	MAKE	', '	KIWI	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2082, '7798092967365', '	AROMATIZANTE	', '	MAKE	', '	ROSAS	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2083, '7798092965439', '	AROMATIZANTE	', '	MAKE	', '	UVA - NARANJA	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2084, '7798092965330', '	AROMATIZANTE	', '	MAKE	', '	PAPAYA	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2085, '7798092965347', '	AROMATIZANTE	', '	MAKE	', '	VAINILLA	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2086, '7798092965361', '	AROMATIZANTE	', '	MAKE	', '	NEW STYLE	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2087, '7798092967372', '	AROMATIZANTE	', '	MAKE	', '	GOLDEN COIN	', NULL, '270.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2088, '7798129700804', '	AROMATIZANTE	', '	ODORITE	', '	DAMA BLANCA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2089, '7798129700798', '	AROMATIZANTE	', '	ODORITE	', '	LEMON GREEN	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2090, '7798129700750', '	AROMATIZANTE	', '	ODORITE	', '	COCO VAINILLA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2091, '7798129700743', '	AROMATIZANTE	', '	ODORITE	', '	CITRUS FRESHENER	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2092, '7798129700392', '	AROMATIZANTE	', '	NEW SCENT	', '	ONIRO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2093, '7798129700057', '	AROMATIZANTE	', '	NEW SCENT	', '	VAINILLA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, -11, 6),
(2094, '7798129700255', '	AROMATIZANTE	', '	NEW SCENT	', '	UVA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(2095, '7798129700248', '	AROMATIZANTE	', '	NEW SCENT	', '	VERBENA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2096, '7798129700019', '	AROMATIZANTE	', '	NEW SCENT	', '	LAVANDA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2097, '7798129700026', '	AROMATIZANTE	', '	NEW SCENT	', '	CHERRY	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2098, '7798129700736', '	AROMATIZANTE	', '	NEW SCENT	', '	NISSA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2099, '7798129700439', '	AROMATIZANTE	', '	NEW SCENT	', '	ZONA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2100, '7798129700415', '	AROMATIZANTE	', '	NEW SCENT	', '	PETRA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2101, '7798129700118', '	AROMATIZANTE	', '	NEW SCENT	', '	GARBO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2102, '7798129700132', '	AROMATIZANTE	', '	NEW SCENT	', '	MIKA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2103, '7798129700156', '	AROMATIZANTE	', '	NEW SCENT	', '	MANZANA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2104, '7798129700385', '	AROMATIZANTE	', '	NEW SCENT	', '	LUNA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2105, '7798129700361', '	AROMATIZANTE	', '	NEW SCENT	', '	HARAS	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2106, '7798129700163', '	AROMATIZANTE	', '	NEW SCENT	', '	ORANGE	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2107, '7798129700125', '	AROMATIZANTE	', '	NEW SCENT	', '	PAPAYA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2108, '7798129700040', '	AROMATIZANTE	', '	NEW SCENT	', '	FRUTAL	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2109, '7798129700378', '	AROMATIZANTE	', '	NEW SCENT	', '	ROCIO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2110, '7798129700262', '	AROMATIZANTE	', '	NEW SCENT	', '	SERENA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2111, '7798129700217', '	AROMATIZANTE	', '	NEW SCENT	', '	BAHIA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2112, '7798129700149', '	AROMATIZANTE	', '	NEW SCENT	', '	COCO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2113, '7798129700101', '	AROMATIZANTE	', '	NEW SCENT	', '	FAREN-H	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2114, '7798129700729', '	AROMATIZANTE	', '	NEW SCENT	', '	MINTAGE	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2115, '7798129700286', '	AROMATIZANTE	', '	NEW SCENT	', '	NOAH	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, -9, 2),
(2116, '7798129700293', '	AROMATIZANTE	', '	NEW SCENT	', '	SATOMI	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2117, '7798129700064', '	AROMATIZANTE	', '	NEW SCENT	', '	EXOTIC	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2118, '7798129700279', '	AROMATIZANTE	', '	NEW SCENT	', '	CHIA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2119, '7798129700408', '	AROMATIZANTE	', '	NEW SCENT	', '	DELIRIO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2120, '7798129700354', '	AROMATIZANTE	', '	NEW SCENT	', '	CARAMELO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2121, '7798129700187', '	AROMATIZANTE	', '	NEW SCENT	', '	CITRONELLA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2122, '7798129700828', '	AROMATIZANTE	', '	NEW SCENT	', '	CHARO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(2123, '7798129700224', '	AROMATIZANTE	', '	NEW SCENT	', '	BRISA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2124, '7798129700422', '	AROMATIZANTE	', '	NEW SCENT	', '	BUBBLEGUM	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2125, '7798129700095', '	AROMATIZANTE	', '	NEW SCENT	', '	CAPUCCINO	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2126, '7798129700033', '	AROMATIZANTE	', '	NEW SCENT	', '	CITRUS	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2127, '7798129700309', '	AROMATIZANTE	', '	NEW SCENT	', '	AYELEN	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2128, '7798129700682', '	AROMATIZANTE	', '	NEW SCENT	', '	PAMPA	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2129, '7798129700088', '	AROMATIZANTE	', '	NEW SCENT	', '	AMARYL	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2130, '7798129700170', '	AROMATIZANTE	', '	NEW SCENT	', '	ALEPH	', NULL, '276.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2131, '7899089438162', '	PERFUME	', '	AVON	', '	AIR SPEED	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2132, '7790829000536', '	PERFUME	', '	AVON	', '	INTENSE	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2133, '8736811', '	PERFUME	', '	AVON	', '	NOIR	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2134, '8760572', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2135, '7899089425223', '	PERFUME	', '	AVON	', '	FRESH	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2136, '8762290', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2137, '7899089423779', '	PERFUME	', '	AVON	', '	MARINE	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2138, '7899089448420', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2139, '7790829003711', '	PERFUME	', '	AVON	', '	NULL	', NULL, '120.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2140, '8760053', '	PERFUME	', '	AVON	', '	TOUCH	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2141, '7899089431477', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2142, '7899089453448', '	PERFUME	', '	AVON	', '	HOT	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2143, '7899089425919', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2144, '8760511', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2145, '7790829005326', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2146, '7899089427890', '	PERFUME	', '	AVON	', '	GRAFFITI	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2147, '8759587', '	PERFUME	', '	AVON	', '	TRANCE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2148, '8759233', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2149, '8761781', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2150, '8756777', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2151, '8760154', '	PERFUME	', '	AVON	', '	NULL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2152, '7899089433938', '	PERFUME	', '	AVON	', '	EXTREME	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2153, '8756543', '	PERFUME	', '	AVON	', '	GLORY	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2154, '7790829003339', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2155, '87761674', '	PERFUME	', '	AVON	', '	NULL	', NULL, '90.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2156, '8757600', '	PERFUME	', '	AVON	', '	LEGACY	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2157, '7790829004381', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2158, '8760468', '	PERFUME	', '	AVON	', '	ABSYNTHE	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2159, '7791600037017', '	PERFUME	', '	KEVIN	', '	NULL	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2160, '7791600173135', '	PERFUME	', '	PACO	', '	ROJO	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2161, '7899089441490', '	PERFUME	', '	AVON	', '	ESSENTIAL	', NULL, '100.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2162, '8758250', '	COLONIA	', '	AVON	', '	CENICIENTA	', NULL, '70.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2163, '7791600595234', '	PERFUME	', '	MUJERCITAS	', '	NULL	', NULL, '40.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2164, '7791600047030', '	PERFUME	', '	COQUETERIAS	', '	NULL	', NULL, '40.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2165, '7899089487337', '	LOCION PERFUMADA	', '	AVON	', '	NULL	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2166, '8722328', '	PERFUME	', '	AVON	', '	LOVES GLITTER	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2167, '7899089494700', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2168, '8759433', '	COLONIA	', '	AVON	', '	SWEET HONESTY	', NULL, '115.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2169, '8758749', '	PERFUME	', '	AVON	', '	LUSCIOUS	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2170, '7899089450492', '	COLONIA	', '	AVON	', '	GRAPE CAKE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2171, '7899089450485', '	COLONIA	', '	AVON	', '	CHERRY`S MOUSSE	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2172, '7899089424103', '	PERFUME	', '	AVON	', '	ROSE FIZZ	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2173, '7899089424097', '	PERFUME	', '	AVON	', '	PLUM TWIST	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2174, '7899089424080', '	PERFUME	', '	AVON	', '	CITRUS CHILL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2175, '7899089472401', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2176, '7790829006262', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2177, '8717200', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2178, '7899089486514', '	PERFUME	', '	AVON	', '	NULL	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2179, '7899089427876', '	PERFUME	', '	AVON	', '	KISS	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2180, '7899089422154', '	PERFUME	', '	AVON	', '	STAR	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2181, '8759735', '	PERFUME	', '	AVON	', '	LOVE TO THE FULLEST	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2182, '8759734', '	PERFUME	', '	AVON	', '	LAUGH AFTEN	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2183, '8735404', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2184, '7899089425926', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2185, '7899089443968', '	PERFUME	', '	AVON	', '	BLOSSOM	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2186, '7790829007610', '	PERFUME	', '	AVON	', '	GARDEN	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2187, '8732415', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2188, '7790829007818', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2189, '8756776', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2190, '7899089423755', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2191, '7899089447447', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2192, '8760148', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2193, '8733127', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2194, '8761062', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2195, '7899089459624', '	PERFUME	', '	AVON	', '	AMOUR	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2196, '7899089434843', '	PERFUME	', '	AVON	', '	BELLA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2197, '7899089487665', '	PERFUME	', '	AVON	', '	GOLD	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2198, '8759465', '	PERFUME	', '	AVON	', '	INTENSE	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2199, '8756566', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2200, '7899089436694', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2201, '7899089470810', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2202, '7899089431583', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2203, '8761488', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2204, '7899089437301', '	PERFUME	', '	AVON	', '	NULL	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2205, '7899089422185', '	PERFUME	', '	AVON	', '	NUIT	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2206, '7790520011589', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2207, '7790520009500', '	REPELENTE	', '	OFF!	', '	EXTRA DURACION (VERDE)	', NULL, '165.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2208, '7790520009524', '	REPELENTE	', '	OFF!	', '	EXTRA DURACION (VERDE)	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2209, '7790520012173', '	REPELENTE	', '	OFF!	', '	FAMILY	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2210, '7798053620469', '	PERFUME P/AUTO	', '	WALKER	', '	KENZO	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2211, '7798053620537', '	PERFUME P/AUTO	', '	WALKER	', '	MARINO	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2212, '7798053627512', '	PERFUME P/AUTO	', '	WALKER	', '	BLACK	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2213, '7798053626676', '	PERFUME P/AUTO	', '	WALKER	', '	UVA	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2214, '7798053627192', '	PERFUME P/AUTO	', '	WALKER	', '	POWER BY KENZO	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2215, '7798053620445', '	PERFUME P/AUTO	', '	WALKER	', '	PACO RABANNE	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2216, '7798053626409', '	PERFUME P/AUTO	', '	WALKER	', '	LAVANDA	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2217, '7798053627185', '	PERFUME P/AUTO	', '	WALKER	', '	AQCUA	', NULL, '60.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2218, '7790520009425', '	PASTILLA	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '25.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2219, '7790520010278', '	CANASTA LIQUIDA	', '	LYSOFORM	', '	PINO	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2220, '7790520988225', '	CANASTA LIQUIDA	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2221, '7790520010193', '	CANASTA LIQUIDA	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2222, '7790520010209', '	CANASTA LIQUIDA	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '50.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2223, '7791130584128', '	BLOQUE MOCHILA	', '	HARPIC	', '	PINO	', NULL, '45.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2224, '7791600028589', '	DESODORANTE	', '	COLBERT	', '	ACQUA DI COLBERT	', NULL, '150.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2225, '7798053626683', '	GAMUZA SINTETICA	', '	WALKER	', '	NULL	', NULL, '4332.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2226, '8002030138250', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	CITRICO	', NULL, '3.15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2227, '8002030138281', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	VAINILLA	', NULL, '3.15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2228, '7798053626201', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	NARANJA	', NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2229, '7798053626355', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	AQCUA	', NULL, '80.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2230, '7798053626805', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	LIMON	', NULL, '80.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2231, '7798053628021', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	SENSUAL	', NULL, '80.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2232, '7798053626751', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	VAINILLA PRIDE	', NULL, '80.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(2233, '7798053628014', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	BLACK	', NULL, '80.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2234, '7798053629073', '	PAÑO LIMPIADOR	', '	WALKER	', '	NULL	', NULL, '4752.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2235, '7790520008732', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	NECTAR DE FLORES	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2236, '7790520008725', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	MAÑANA DE CAMPO	', NULL, '8.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2237, '7790520011572', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	NEUTRALIZADOR	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2238, '7790520001771', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	ATRACTTION	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2239, '7790520011626', '	AROMATIZANTE P/AUTO	', '	GLADE	', '	ACQUA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2240, '7790900016449', '	AROMATIZANTE P/AUTO	', '	AIRE PUR	', '	MELON/AQUA	', NULL, '5.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2241, '7798053626287', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	LAVANDA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2242, '7798053626232', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	ACQUA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2243, '7798053626249', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	VAINILLA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2244, '7798053626270', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	CITRICO	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2245, '7798053626263', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	TROPICAL	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2246, '7798053626010', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	TROPICAL	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2247, '7798053626034', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	VAINILLA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2248, '7798053626041', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	LAVANDA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2249, '7798053626065', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	ACQUA	', NULL, '7.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2250, '7790900015305', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	LAVANDA	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2251, '7790900015329', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	LIMON	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2252, '7790900015312', '	ANTIHUMEDAD MAX	', '	AIRE PUR	', '	PINO	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2253, '7790900016685', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	AQUA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2254, '7790900016678', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	VAINILLA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2255, '7790900016883', '	ANTIHUMEDAD TABLET	', '	AIRE PUR	', '	AQUA	', NULL, '75.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2256, '7790900016074', '	ANTIHUMEDAD MAX + ABSORVE OLORES	', '	AIRE PUR	', '	NEUTRO	', NULL, '250.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2257, '7793253180546', '	POETT INTENSE	', '	POETT	', '	SOLO PARA TI	', NULL, '13.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2258, '7790520008282', '	GLADE TOQUE	', '	GLADE	', '	CAMPOS DE LAVANDA	', NULL, '12.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2259, '7790520002402', '	REPELENTE	', '	OFF!	', '	FAMILY	', NULL, '200.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2260, '7796679005127', '	LUSTRAMUEBLES	', '	FACILLIM	', '	NARANJA	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 5),
(2261, '7793253238957', '	INSECTICIDA	', '	SELTON	', '	MMM	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(2262, '7790520508607', '	INSECTICIDA	', '	RAID	', '	SIN OLOR	', NULL, '360.00', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2263, '7798354500521', '	MOPA	', '	DURAMAS	', '	BLANCO	', NULL, '165', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2264, '7797390131010', '	MOPA	', '	SCHEZ	', '	BLANCO	', NULL, '180', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2265, '7794440006564', '	MOPA	', '	VIRULANA	', '	BLANCO	', NULL, '145', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2266, '7798055050219', '	LAMPAZO	', '	PANDY	', '	AZUL	', NULL, '425', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2267, '7797390132017', '	MOPA	', '	SCHEZ	', '	AMARILLO	', NULL, '110', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2268, '7790339000460', '	SECADOR DE VIDRIOS	', '	FIORENTINA	', '	C/CABO CORTO	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2269, '7790339000323', '	SECADOR DE VIDRIOS	', '	FIORENTINA	', '	C/CABO CORTO	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2270, '7798061894005', '	SECADOR DE VIDRIOS	', '	PIRAGUA	', '	C/CABO CORTO	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2271, '7793424000338', '	SECADOR DE VIDRIOS	', '	BUSGRAN	', '	C/CABO CORTO MADERA	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2272, '7794297010707', '	SECADOR DE VIDRIOS	', '	DESES PLAST	', '	PUNTA DE GOMA	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2273, '7798055050202', '	LAMPAZO	', '	PANDY	', '	AZUL	', NULL, '340', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2274, '7798055050066', '	LAMPAZO	', '	PANDY	', '	BLANCO	', NULL, '350', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2275, '20153292531', '	MOPA	', '	ECOLOGICOS	', '	BLANCO	', NULL, '250', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2276, '7798053629073', '	PAÑO LIMPIADOR	', '	WALKER	', '	NULL	', NULL, '47x52', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2277, '7791310028824', '	CESTO PARA ROPA	', '	NEW!	', '	NULL	', NULL, '40x40x70', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2278, '7790345163005', '	CEPILLO P/CALZADO	', '	SAMANTHA	', '	CHICO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2279, '7798053621558', '	DESENGRASANTE P/MOTORES	', '	WALKER	', '	NULL	', NULL, '500', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2280, '7798053622067', '	LIMPIATAPIZADOS	', '	WALKER	', '	ESPUMA MULTIPROPOSITO	', NULL, '400', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2281, '7798053621145', '	SILICONA PERFUMADA	', '	WALKER	', '	TODAS	', NULL, '400', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2282, '7501058743503', '	CERA LIQUIDA P/CALZADO	', '	COBRA	', '	GAMUZA Y NOBUCK	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2283, '7791130001687', '	CERA LIQUIDA P/CALZADO	', '	COBRA	', '	NEGRO	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2284, '7791130001694', '	CERA LIQUIDA P/CALZADO	', '	COBRA	', '	CAFE	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2285, '7501058743107', '	CERA LIQUIDA P/CALZADO	', '	COBRA	', '	BLANCO	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2286, '7793350000471', '	POMADA P/CALZADO	', '	WASSINGTON	', '	MARRON	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2287, '7702626103167', '	CREMA PULE METALES	', '	BRASSO	', '	NULL	', NULL, '70', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2288, '7791190003430', '	FOSFOROS DE MADERA	', '	BUENOS DIAS	', '	NULL	', NULL, '220', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2289, '7790590000599', '	FOSFOROS DE MADERA	', '	TRES PATITOS	', '	NULL	', NULL, '222', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2290, '7793462000031', '	BROCHES P/ROPA	', '	PINCILISTO	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(2291, '7793462000017', '	BROCHES P/ROPA	', '	PINCILISTO	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2292, '7797390191014', '	ESTROPAJO DE ACERO	', '	SCHEZ	', '	NULL	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2293, '7798059387212', '	ESTROPAJO DE ACERO	', '	CLEAN	', '	NULL	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2294, '7798022225640', '	ESTROPAJO DE ACERO	', '	MY HOGAR	', '	NULL	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2295, '7791625000140', '	ESTROPAJO DE ACERO	', '	ECOOOOO	', '	NULL	', NULL, '15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2296, '7798092962261', '	ESPONJA ACERO BOLLITO	', '	MAKE	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2297, '7791625004056', '	ESPONJA ACERO BOLLITO	', '	O.K	', '	NULL	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2298, '7791625000423', '	ESPONJA ACERO BOLLITO	', '	ECOOOOO	', '	NULL	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2299, '7798092962254', '	ESPONJA ACERO	', '	MAKE	', '	NULL	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2300, '7790207000158', '	ESPONJA ACERO	', '	STEFF	', '	NULL	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2301, '7798061890250', '	ESPONJA ACERO	', '	ROMYL	', '	NULL	', NULL, '13', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2302, '7798092962278', '	ESPONJA ACERO	', '	MAKE	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2303, '7791625001420', '	ESPONJA FIBRA	', '	O.K	', '	CUADRICULADA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(2304, '7798092964036', '	ESPONJA FIBRA	', '	MAKE	', '	CUADRICULADA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(2305, '7798092962476', '	ESPONJA FIBRA	', '	MAKE	', '	LISITA	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2306, '7793253038106', '	ESPONJA FIBRA	', '	MORTIMER	', '	CUADRICULADA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2307, '7794440003310', '	ESPONJA FIBRA	', '	VIRULANA	', '	LISITA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 24),
(2308, '7791625001215', '	ESPONJA FIBRA	', '	ECOOOOO	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2309, '7793253038526', '	ESPONJA DOBLE CARA	', '	MORTIMER	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2310, '7795815050229', '	ANILINA	', '	COLIBRI	', '	ROJO FUERTE	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2311, '7795815050281', '	ANILINA	', '	COLIBRI	', '	VERDE OSCURO	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2312, '7795815030016', '	ANILINA	', '	COLIBRI	', '	NEGRO AZABACHE	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2313, '7795815050175', '	ANILINA	', '	COLIBRI	', '	AZUL MARINO	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2314, '7795815050106', '	ANILINA	', '	COLIBRI	', '	GERIS OSCURO	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2315, '7795815050083', '	ANILINA	', '	COLIBRI	', '	MARRON OSCURO	', NULL, '20', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2316, '7793350992950', '	POMADA P/CALZADO	', '	WASSINGTON	', '	BLANCA	', NULL, '39', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2317, '7793350993049', '	POMADA P/CALZADO	', '	WASSINGTON	', '	INCOLORA	', NULL, '32', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2318, '7791130002721', '	POMADA P/CALZADO	', '	COBRA	', '	INCOLORA	', NULL, '32', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2319, '7793350993018', '	POMADA P/CALZADO	', '	WASSINGTON	', '	MARRON CLARO	', NULL, '32', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2320, '7793350000464', '	POMADA P/CALZADO	', '	WASSINGTON	', '	NEGRO	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2321, '7791625004155', '	LANA DE ACERO	', '	ECOOOOO	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2322, '7791625004018', '	LANA DE ACERO	', '	O.K	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2323, '7792877000803', '	VELA	', '	MS	', '	NULL	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2324, '7796259010060', '	VELA	', '	RELIEVE	', '	NULL	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2325, '7798120900074', '	VELA	', '	LUZ DEL NORTE	', '	PARAFINA	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2326, '7798161649475', '	VELA	', '	ILUMINARTE	', '	PARAFINA	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2327, '7792877001305', '	VELA	', '	MS	', '	NULL	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2328, '7790590000308', '	VELA	', '	VICTORIA	', '	NULL	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2329, '7790207019624', '	NAFTALINA	', '	VIANCE	', '	S/PERFUME	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2330, '7792459004083', '	CEPILLO	', '	LA GAUCHITA	', '	MANO ROPA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2331, '7798092963053', '	CEPILLO	', '	MAKE	', '	GOTA JEAN	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2332, '7798092966481', '	CEPILLO	', '	MAKE	', '	M-16	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2333, '7794297074242', '	CEPILLO DE UÑAS	', '	APOLO	', '	DOBLE	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2334, '7794297074259', '	CEPILLO DE UÑAS	', '	DESES PLAST	', '	GRANDE	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2335, '7791625008085', '	CEPILLO DE UÑAS	', '	OK	', '	CHICO FLUOR	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2336, '7798092964944', '	CEPILLO LAVAZAPATILLAS	', '	MAKE	', '	C/MANGO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2337, '2015330576', '	CEPILLO PLANCHITA	', '	ECONOMICO	', '	C/MANGO CERRADO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2338, '2015330581', '	CEPILLO PLANCHITA	', '	ECONOMICO	', '	C/MANGO ABIERTO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2339, '2015330042', '	CEPILLO P/CALZADO	', '	ECONOMICO	', '	CHICO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2340, '2015330117', '	CEPILLO P/CALZADO	', '	ECONOMICO	', '	GRANDE	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2341, '7790911000239', '	ACEITE MULTIUSO	', '	REVIGAL	', '	NULL	', NULL, '110', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2342, '75027513', '	DESODORANTE	', '	DOVE	', '	ORIGINAL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2343, '75026455', '	DESODORANTE	', '	REXONA	', '	NUTRITIVE	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2344, '7790900004675', '	LAVA ZAPATILLAS	', '	IBERIA	', '	C/PERFUME	', NULL, '300', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2345, '7793424000130', '	PALA RESIDUOS	', '	BUSGRAN	', '	C/CABO CORTO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2346, '7790064002203', '	HISOPOS	', '	ESTRELLA	', '	SUAVIDAD NATURAL (AMARILLOS)	', NULL, '75', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2347, '7702018084821', '	CARTUCHO P/AFEITAR	', '	GILLETTE	', '	REPUESTO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2348, '7798104661052', '	CESTO PARA ROPA	', '	MULTIENVASE	', '	MINI DE LUJO	', NULL, '7', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2349, '7793424000581', '	PALA RESIDUOS	', '	BUSGRAN	', '	C/CABO LARGO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2350, '7791231312002', '	RESIDUO	', '	STAR	', '	A PEDAL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2351, '7790828001947', '	JABON LIQUIDO P/ROPA	', '	GIGANTE	', '	C/SUAVIZANTE	', NULL, '730', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2352, '8711700045902', '	ABRILLANTADOR	', '	SUN	', '	NULL	', NULL, '500', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2353, '7896009419324', '	DENTIFRICO	', '	SENSODINE	', '	NULL	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2354, '7804900671109', '	DENTIFRICO	', '	AQUAFRESH	', '	ORIGINAL	', NULL, '116', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2355, '7790520003430', '	PAPEL INSECTICIDA	', '	RAID	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 13),
(2356, '4005808257584', '	DESODORANTE	', '	NIVEA	', '	DRY COMFORT	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2357, '4005808257577', '	DESODORANTE	', '	NIVEA	', '	FRESH ACTIVE	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2358, '7791600050092', '	PERFUME	', '	PIBE`S	', '	NULL	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2359, '7791600189235', '	PERFUME	', '	CIEL	', '	NUIT	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2360, '7791600189679', '	PERFUME	', '	ACQUA	', '	DE ETIENNE	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2361, '7791600128562', '	PERFUME	', '	COLBERT	', '	SPACE	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2362, '7791600128890', '	PERFUME	', '	CHESTER ICE	', '	NULL	', NULL, '170', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2363, '7791600128234', '	PERFUME	', '	KEVIN	', '	SPIRIT	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2364, '7791600128012', '	PERFUME	', '	KEVIN	', '	ROJO	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2365, '7791600128128', '	PERFUME	', '	KEVIN	', '	BLACK	', NULL, '60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2366, '7798052800084', '	VELAS DE NOCHE	', '	S/MARCA	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2367, '7798081510503', '	VELAS DE NOCHE	', '	ILUMINARTE	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2368, '7798161647549', '	VELAS DE NOCHE	', '	NISHDALI	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2369, '7792877004085', '	VELAS DE NOCHE	', '	MS	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2370, '7796135000413', '	VELAS DE NOCHE	', '	FINALUZ	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2371, '7798053626003', '	AROMATIZANTE P/AUTO	', '	WALKER	', '	TODAS	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 48),
(2372, '7899089455855', '	PERFUME P/ROPA	', '	AVON	', '	LILAS Y ORQUIDEAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2373, '7899089455879', '	PERFUME P/ROPA	', '	AVON	', '	BABY	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2374, '7899089455862', '	PERFUME P/ROPA	', '	AVON	', '	FLORES BLANCAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2375, '7899089455886', '	PERFUME P/ROPA	', '	AVON	', '	MAGNOLIAS Y CAMELIAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2376, '8715937', '	PERFUME P/ROPA	', '	AVON	', '	FLORES BLANCAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2377, '7899089455831', '	PERFUME P/ROPA	', '	AVON	', '	JAZMINES Y FRESIAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2378, '7899089456036', '	PERFUME P/ROPA	', '	AVON	', '	FLORES BLANCAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2379, '7899089456029', '	PERFUME P/ROPA	', '	AVON	', '	LILAS Y ORQUIDEAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2380, '7899089456005', '	PERFUME P/ROPA	', '	AVON	', '	JAZMINES Y FRESIAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2381, '7899089456012', '	PERFUME P/ROPA	', '	AVON	', '	ROSAS Y VIOLETAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2382, '7899089456050', '	PERFUME P/ROPA	', '	AVON	', '	MAGNOLIAS Y CAMELIAS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2383, '7899089456043', '	PERFUME P/ROPA	', '	AVON	', '	BABY	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2384, '7899089427685', '	ALCOHOL EN GEL	', '	AVON	', '	MANZANILLA Y AVENA	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2385, '9900377500497', '	HORNITO	', '	S/MARCA	', '	CUADRADO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2386, '2015431230', '	MATE	', '	PP	', '	C/BASE	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2387, '2015431447', '	BOMBILLA	', '	CIMARRON	', '	CURVA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2388, '2015431836', '	BOMBILLA	', '	BOMBILLAS DEL CAMPO	', '	RECTA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2389, '7798030840026', '	BOMBILLA	', '	SEBILLE	', '	CURVA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2390, '7798030840842', '	BOMBILLA	', '	SEBILLE	', '	CURVA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2391, '7798024452389', '	MICROFIBRA	', '	MR. TRAPO	', '	MULTIUSO	', NULL, '40x40', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2392, '7790927814165', '	MICROFIBRA	', '	1/2 NARANJA	', '	VIDRIOS	', NULL, '40x40', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 10),
(2393, '7798024452518', '	MICROFIBRA	', '	MR. TRAPO	', '	COCINA	', NULL, '40x40', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2394, '7798024452396', '	MICROFIBRA	', '	MR. TRAPO	', '	MUEBLES	', NULL, '40x40', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2395, '7790927814219', '	MICROFIBRA	', '	1/2 NARANJA	', '	PISOS	', NULL, '48x60', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2396, '7798024452419', '	MICROFIBRA	', '	MR. TRAPO	', '	PISOS	', NULL, '62x48', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2397, '7899089438056', '	CREMA P/MANOS	', '	AVON	', '	JALEA REAL	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2398, '8757273', '	CREMA P/MANOS	', '	AVON	', '	RENOVARE	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2399, '7899089439435', '	CREMA P/MANOS	', '	AVON	', '	PARAFINA	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2400, '7899089421676', '	LOCION FACIAL	', '	AVON	', '	3 IN 1 LOTION	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2401, '7899089421683', '	GEL FACIAL	', '	AVON	', '	PEPINO GEL	', NULL, '90', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2402, '8760568', '	CREMA P/AFEITARSE	', '	AVON	', '	BLUE BLAZER	', NULL, '85', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2403, '8740944', '	CREMA P/AFEITARSE	', '	AVON	', '	WILD COUNTRY	', NULL, '85', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2404, '7899089444316', '	CREMA P/MANOS	', '	AVON	', '	DAMASCO	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2405, '7899089429047', '	CREMA P/MANOS	', '	AVON	', '	FRESA Y CHOC BCO	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2);
INSERT INTO `Productos` (`productoID`, `codigo`, `nombre`, `marca`, `fragancia`, `caracteristica`, `medida`, `precioVenta`, `unidadMedidaID`, `tipoProductoID`, `tipoRubroID`, `ultimaActualizacionStock`, `inventarioID`, `precioFinalAFacturar`, `stockactual`, `stockMinimo`) VALUES
(2406, '8758705', '	LOCION P/CUERPO	', '	AVON	', '	MINERALS GEMS	', NULL, '250', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2407, '7790829004886', '	COLONIA	', '	AVON	', '	ROSAS ROJAS Y DURAZNOS	', NULL, '200', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2408, '7899089442879', '	ACONDICIONADOR	', '	AVON	', '	FRAMBUESA	', NULL, '300', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2409, '8767306', '	LOCION P/CUERPO EN CREMA	', '	AVON	', '	GUARANA Y MIEL	', NULL, '220', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2410, '7899089478267', '	PUNTITA	', '	AVON	', '	MOROCCAN ARGAN OIL	', NULL, '15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2411, '7899089426060', '	MASCARA PESTAÑAS	', '	AVON	', '	NEGRO	', NULL, '9', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2412, '8757637', '	PUNTITA	', '	AVON	', '	CONC. HIDRO-ACTIVO	', NULL, '15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2413, '7899089440424', '	DELINEADOR P/OJOS	', '	AVON	', '	VIOLETA	', NULL, '1.2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2414, '7899089448000', '	DELINEADOR P/OJOS	', '	AVON	', '	MARRON	', NULL, '1.2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2415, '7899089447997', '	DELINEADOR P/OJOS	', '	AVON	', '	AZUL	', NULL, '1.2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2416, '7899089435611', '	DELINEADOR P/OJOS	', '	AVON	', '	VERDE	', NULL, '1.2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2417, '7899089448062', '	DELINEADOR P/OJOS	', '	AVON	', '	NEGRO	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2418, '7899089448253', '	DELINEADOR P/OJOS	', '	AVON	', '	CHOCOLATE	', NULL, '1.3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2419, '8763450', '	BRILLO LABIAL	', '	AVON	', '	FUCSIA QUEEN	', NULL, '7', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2420, '8757656', '	PUNTITA	', '	AVON	', '	CONC. REST. C/CREATINA	', NULL, '15', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2421, '8743991', '	BRILLO LABIAL	', '	AVON	', '	GRAPE JELLY	', NULL, '4.5', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2422, '7899089475235', '	DELINEADOR P/OJOS	', '	AVON	', '	NEGRO	', NULL, '0.28', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2423, '7899089475266', '	DELINEADOR P/OJOS	', '	AVON	', '	CAFE	', NULL, '0.28', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2424, '7899089475242', '	DELINEADOR P/OJOS	', '	AVON	', '	AGUAMARINA	', NULL, '0.28', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2425, '6902004095218', '	ENCENDEDOR	', '	CANDELA	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 26),
(2426, '6910021007206', '	CEPILLO DE DIENTES	', '	COLGATE	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 16),
(2427, '7891024183120', '	HILO DENTAL	', '	COLGATE	', '	NULL	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2428, '7798092961356', '	BOMBILLA	', '	MAKE	', '	CURVA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2429, '7794321242159', '	BOMBILLA	', '	ILKO	', '	CURVA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2430, '7790250000358', '	PAÑUELOS DESCARTABLES	', '	ELITE	', '	SIN PERFUME	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2431, '4891305182081', '	ENCENDEDOR	', '	MAGICLICK	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2432, '7798092961325', '	TOSTADOR ESTAÑADO	', '	MAKE	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2433, '7794297020997', '	PISAPAPA	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2434, '7794297040384', '	ESPATULA NYLON	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2435, '7794297040414', '	CUCHARON SUIZA	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2436, '7794297040353', '	CUCHARA CALADA	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2437, '7794297040360', '	CUCHARA FIDEO PULPO	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2438, '7794297040339', '	CUCHARON	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2439, '201544918', '	BOLITAS INFLABLES	', '	O.K	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 20),
(2440, '7790520010179', '	APARATO P/TABLETAS	', '	RAID	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2441, '7896009760044', '	PILAS	', '	VARTA	', '	CARBON	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 50),
(2442, '7896009760068', '	PILAS	', '	VARTA	', '	CARBON	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 40),
(2443, '201544153', '	DISPENSER P/JABON LIQUIDO	', '	DOUBLET	', '	DOBLE	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2444, '2015441649', '	DISPENSER P/JABON LIQUIDO	', '	MUNDO LIMPIEZA	', '	BLANCO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2445, '2015441733', '	DISPENSER P/JABON LIQUIDO	', '	MUNDO LIMPIEZA	', '	HUMO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2446, '6935606600344', '	DISPENSER P/JABON LIQUIDO	', '	BUSGRAN	', '	BLANCO - GRIS PLATA - ROSA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2447, '7792280307124', '	ESCURRIDOR DE CUBIERTOS	', '	GOURMET	', '	C/MANGO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2448, '7794297010271', '	JARRA MEDIDORA	', '	DESES PLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2449, '7793762004043', '	JARRA MEDIDORA	', '	GEMPLAST	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2450, '7793762006177', '	JARRA JUGUERA	', '	GEMPLAST	', '	TRANSPARENTE C/TAPA COLOR	', NULL, '2.7', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2451, '7798092961950', '	PAPEL ALUMINIO	', '	MAKE	', '	5MX28CM	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2452, '7798092961967', '	FILM ADHERENTE	', '	MAKE	', '	30MX28CM	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2453, '7790773034090', '	PALILLEROS DE MESA	', '	DESAFIO	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2454, '7796613018558', '	PALILLEROS DE MESA	', '	M&K	', '	NULL	', NULL, '50', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2455, '7790927814196', '	MICROFIBRA	', '	1/2 NARANJA	', '	NULL	', NULL, '35x25', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2456, '7790520009739', '	APARATO ELECTRICO	', '	RAID	', '	DOBLE ACCION	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2457, '7790520009746', '	LIQUIDO ELECTRICO	', '	RAID	', '	DOBLE ACCION	', NULL, '32.9', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2458, '7793344000203', '	ROLLO DE COCINA	', '	DICHA	', '	X50PAÑOS C/U	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 32),
(2459, '7798086932706', '	SERVILLETAS DE PAPEL	', '	PETALO	', '	X40U	', NULL, '33x33', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2460, '7790250057505', '	SERVILLETAS DE PAPEL	', '	SUSSEX	', '	X50U	', NULL, '33x30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2461, '7793344904631', '	ROLLO DE COCINA	', '	ELEGANTE	', '	X100PAÑOS C/U	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 16),
(2462, '7791828000138', '	ROLLO DE COCINA	', '	FELPITA	', '	X40PAÑOS C/U	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2463, '7790250056775', '	ROLLO DE COCINA	', '	SUSSEX	', '	X50PAÑOS C/U	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 28),
(2464, '7793344904150', '	PAPEL HIGIENICO	', '	ELEGANTE	', '	X30M	', NULL, '6', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 20),
(2465, '2015444054', '	ROLLO DE COCINA	', '	S/MARCA	', '	X200PAÑOS	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 13),
(2466, '201544429', '	PAPEL HIGIENICO	', '	S/MARCA	', '	X30M	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2467, '7798181180125', '	PAPEL HIGIENICO	', '	ACQUA	', '	X30M	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 40),
(2468, '7798038152282', '	PAPEL HIGIENICO	', '	SCOTT	', '	X20M	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2469, '7798038152626', '	PAPEL HIGIENICO	', '	SCOTT	', '	X20M	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2470, '7793344904143', '	PAPEL HIGIENICO	', '	ELEGANTE	', '	X30M	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 38),
(2471, '7793344904228', '	PAPEL HIGIENICO	', '	ELEGANTE	', '	X80M	', NULL, '4', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 26),
(2472, '7794626005435', '	PAÑAL	', '	HUGGIES	', '	G	', NULL, '9', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2473, '7794626003776', '	PAÑAL	', '	HUGGIES	', '	XXG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2474, '7794626004964', '	PAÑAL	', '	HUGGIES	', '	XG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2475, '7794626004957', '	PAÑAL	', '	HUGGIES	', '	G	', NULL, '9', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2476, '7506339310733', '	PAÑAL	', '	PAMPERS	', '	M	', NULL, '11', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2477, '7506339306040', '	PAÑAL	', '	PAMPERS	', '	XXG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2478, '7506339310740', '	PAÑAL	', '	PAMPERS	', '	G	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2479, '7506339306033', '	PAÑAL	', '	PAMPERS	', '	XG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2480, '7506309850160', '	PAÑAL	', '	PAMPERS	', '	XG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2481, '7506339326840', '	PAÑAL	', '	PAMPERS	', '	G	', NULL, '9', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2482, '7501006720334', '	PAÑAL	', '	PAMPERS	', '	M	', NULL, '10', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2483, '7506339326680', '	PAÑAL	', '	PAMPERS	', '	XXG	', NULL, '8', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2484, '7794122013071', '	PEGAMENTO	', '	POXIRAN	', '	NULL	', NULL, '23', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 7),
(2485, '7501009225027', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	(ROSA)	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2486, '7790400018585', '	PEGAMENTO	', '	UNIPOX	', '	NULL	', NULL, '25', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 7),
(2487, '77906731', '	PEGAMENTO	', '	LA GOTITA	', '	NULL	', NULL, '3', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2488, '77917188', '	PEGAMENTO	', '	LA GOTITA	', '	NULL	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2489, '7790400005721', '	PARCHES ADHESIVOS	', '	POXITAS	', '	NULL	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2490, '7790400014532', '	PEGAMENTO	', '	POXIPOL	', '	NULL	', NULL, '16', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2491, '7794122001870', '	PEGAMENTO	', '	POXILINA	', '	NULL	', NULL, '70', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2492, '3014260275143', '	CARTUCHO P/AFEITAR	', '	GILLETTE	', '	TURBO	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2493, '7506195153574', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	BODYSENSE (VERDE Y NEGRO)	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2494, '7702018325795', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	(GRIS)	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2495, '7506309873343', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	FUTBOL (VERDE Y AZUL)	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2496, '3014260328597', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	(ROSA)	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 9),
(2497, '7702018323074', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	ULTRAGRIP (AZUL)	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 40),
(2498, '7506295398066', '	MAQUINA P/AFEITAR	', '	GILLETTE	', '	(GRIS)	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 14),
(2499, '7702018316694', '	MAQUINA P/AFEITAR	', '	MINORA	', '	(AMARILLA)	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 52),
(2500, '4891228530181', '	MAQUINA P/AFEITAR	', '	SCHICK	', '	(AMARILLA)	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 28),
(2501, '12800489640', '	PILAS	', '	RAYOVAC	', '	ALCALINAS	', NULL, '6', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 30),
(2502, '12800180936', '	PILAS	', '	RAYOVAC	', '	ALCALINAS	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 18),
(2503, '12800198443', '	PILAS	', '	RAYOVAC	', '	ALCALINAS	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 18),
(2504, '12800183173', '	PILAS	', '	RAYOVAC	', '	ALCALINAS	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 23),
(2505, '39800011626', '	PILAS	', '	EVEREADY	', '	CARBON	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2506, '4006584671427', '	LAMPARA BAJO CONSUMO	', '	LA BUENA LUZ	', '	14W=50W	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2507, '4008321633897', '	LAMPARA BAJO CONSUMO	', '	OSRAM	', '	20W=75W	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2508, '7798147730852', '	SAHUMERIOS	', '	VIRAT	', '	TODAS	', NULL, '100', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 8),
(2509, '7798170910740', '	SAHUMERIOS	', '	BANGLADESH	', '	SURTIDOS	', NULL, '100', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2510, '2015445341', '	SAHUMERIOS	', '	VALINOTTI	', '	SURTIDOS	', NULL, '30', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 12),
(2511, '2015445439', '	SAHUMERIOS	', '	VALINOTTI	', '	SURTIDOS	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 25),
(2512, '7798028910038', '	FILTRO P/BOMBILLA	', '	FILTROMAT	', '	NULL	', NULL, '2', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 13),
(2513, '7798136492693', '	LIMA	', '	EURO	', '	Nº11	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2514, '7798136492716', '	LIMA	', '	EURO	', '	Nº17	', NULL, '12', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2515, '7798136492754', '	LIMA	', '	EURO	', '	ACOLCHADA BANANA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2516, '7798136492730', '	LIMA	', '	EURO	', '	ACOLCHADA RECTA	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2517, '7798092961318', '	PELAPAPAS	', '	MAKE	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2518, '7798092961295', '	ABRELATAS UÑA	', '	MAKE	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2519, '9900320600021', '	DESTAPADOR	', '	S/MARCA	', '	C/MANGO PLASTICO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2520, '7798092961417', '	SACACORCHOS	', '	MAKE	', '	C/MANGO PLASTICO	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2521, '7794297050031', '	COLADOR	', '	DESES PLAST	', '	Nº7	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2522, '7794297050048', '	COLADOR	', '	DESES PLAST	', '	Nº10	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2523, '7798092961387', '	COLADOR	', '	MAKE	', '	Nº8	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2524, '7798092961394', '	COLADOR	', '	MAKE	', '	Nº10	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2525, '7798092962018', '	COLADOR	', '	MAKE	', '	Nº16	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2526, '7793015202615', '	TAPON MATERO	', '	LUMILAGRO	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2527, '201544171', '	TAPON MATERO	', '	S/MARCA	', '	NULL	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2528, '2015441832', '	ESPEJO	', '	S/MARCA	', '	Nº1	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2529, '2015441944', '	ESPEJO	', '	S/MARCA	', '	Nº2	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2530, '2015442022', '	ESPEJO	', '	S/MARCA	', '	Nº3	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2531, '2015442059', '	ESPEJO	', '	S/MARCA	', '	Nº4	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 2),
(2532, '2015442215', '	PINCEL	', '	TUCSON USA	', '	Nº1	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2533, '2015442253', '	PINCEL	', '	TUCSON USA	', '	Nº2	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2534, '2015442326', '	PINCEL	', '	TUCSON USA	', '	Nº3	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 1),
(2535, '2015442520', '	EMBUDO	', '	S/MARCA	', '	Nº5	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2536, '2015442549', '	EMBUDO	', '	S/MARCA	', '	Nº7	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2537, '2015442617', '	EMBUDO	', '	S/MARCA	', '	Nº9	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2538, '2015442659', '	EMBUDO	', '	S/MARCA	', '	Nº11	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2539, '2015442833', '	EMBUDO	', '	S/MARCA	', '	Nº13	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2540, '2015442924', '	EMBUDO	', '	S/MARCA	', '	Nº15	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 6),
(2541, '2015443022', '	EMBUDO	', '	S/MARCA	', '	Nº17	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 4),
(2542, '2015443059', '	EMBUDO	', '	S/MARCA	', '	Nº20	', NULL, '1', 50, NULL, NULL, NULL, NULL, 0, 100, 0, 3),
(2543, '2015443144', '	EMBUDO	', '	S/MARCA	', '	Nº30	', '', '1', 50, NULL, 2, NULL, NULL, 0, 100, 0, 3),
(2544, '7790520011596', 'AROMATIZANTE P/AUTO	', 'GLADE	', 'FLORAL PERFECTION	', '', '7', 50, NULL, NULL, NULL, '2017-12-12', 0, 100, 0, 2),
(2545, NULL, NULL, NULL, NULL, NULL, NULL, 50, NULL, NULL, NULL, NULL, 0, 100, 0, 0),
(2546, '7798181180199', 'celular', 'samsung', 'fragancia', 'pantalla de led.', '45x60', 0, NULL, NULL, 3, '2018-06-07', 0, 100, 99, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ProductoXDeposito`
--

CREATE TABLE `ProductoXDeposito` (
  `depositoID` int(11) NOT NULL,
  `productoID` int(11) NOT NULL,
  `stockParcial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ProductoXDepositoXEventualidad`
--

CREATE TABLE `ProductoXDepositoXEventualidad` (
  `eventualidadID` int(11) NOT NULL,
  `productoID` int(11) NOT NULL,
  `depositoID` int(11) NOT NULL,
  `stockPrevio` int(11) NOT NULL,
  `stockPosterior` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ProductoXProveedor`
--

CREATE TABLE `ProductoXProveedor` (
  `ProductoXProveedorID` int(11) NOT NULL,
  `ProveedorID` int(11) NOT NULL,
  `ProductoID` int(11) NOT NULL,
  `precioCosto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ProductoXProveedor`
--

INSERT INTO `ProductoXProveedor` (`ProductoXProveedorID`, `ProveedorID`, `ProductoID`, `precioCosto`) VALUES
(4, 1, 1620, 140),
(5, 2, 1620, 100),
(6, 1, 1618, 56),
(7, 2, 1619, 90),
(8, 2, 1700, 67);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedores`
--

CREATE TABLE `Proveedores` (
  `ProveedorID` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cuit` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nroDocumento` bigint(20) NOT NULL,
  `tipoDocumentoID` int(11) NOT NULL,
  `razonSocial` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `celular` varchar(50) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `web` varchar(40) NOT NULL,
  `Real_domicilioID` varchar(500) DEFAULT NULL,
  `Fiscal_domicilioID` varchar(500) DEFAULT NULL,
  `condicionIVAID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Proveedores`
--

INSERT INTO `Proveedores` (`ProveedorID`, `nombre`, `apellido`, `cuit`, `email`, `fechaNacimiento`, `nroDocumento`, `tipoDocumentoID`, `razonSocial`, `telefono`, `celular`, `sexo`, `web`, `Real_domicilioID`, `Fiscal_domicilioID`, `condicionIVAID`) VALUES
(1, 'ricardo alfonso', 'ramirez', '20-35054822-0', 'juan@web.com', '2017-05-23', 35054822, 1, 'empresa', '4522524', '3513220999', 'masculino', 'www.web.com', '1', '1', 1),
(2, 'matias', 'suarez', '12-34567891-1', 'email@email.cm', '2017-06-14', 35054822, 1, 'empresa222', '4522524', '3519885776', 'Masculino', 'www.web.com', '1', '1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Provincias`
--

CREATE TABLE `Provincias` (
  `provinciaID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Provincias`
--

INSERT INTO `Provincias` (`provinciaID`, `nombre`) VALUES
(1, 'Buenos Aires'),
(2, 'Catamarca'),
(3, 'Chaco'),
(4, 'Chubut'),
(5, 'Córdoba'),
(6, 'Corrientes'),
(7, 'Entre Ríos'),
(8, 'Formosa'),
(9, 'Jujuy'),
(10, 'La Pampa'),
(11, 'La Rioja'),
(12, 'Mendoza'),
(13, 'Misiones'),
(14, 'Neuquén'),
(15, 'Río Negro'),
(16, 'Salta'),
(17, 'San Juan'),
(18, 'San Luis'),
(19, 'Santa Cruz'),
(20, 'Santa Fe'),
(21, ' Santiago del Estero'),
(22, 'Tierra del Fuego');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Roles`
--

CREATE TABLE `Roles` (
  `Id` int(11) NOT NULL,
  `Name` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoClientes`
--

CREATE TABLE `TipoClientes` (
  `tipoClienteID` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `nombre` varchar(500) NOT NULL,
  `porcentajeInteres` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TipoClientes`
--

INSERT INTO `TipoClientes` (`tipoClienteID`, `descripcion`, `nombre`, `porcentajeInteres`) VALUES
(1, 'Revendedor', 'Revendedor', 20),
(2, 'Mayorista', 'Mayorista', 22),
(3, 'Distribuidor', 'Distribuidor', 23.5),
(4, 'Franquicia', 'Franquicia', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoDocumento`
--

CREATE TABLE `TipoDocumento` (
  `tipoDocumentoID` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TipoDocumento`
--

INSERT INTO `TipoDocumento` (`tipoDocumentoID`, `nombre`) VALUES
(1, 'dni'),
(2, 'libreta civil'),
(3, 'pasaporte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TiposEventualidad`
--

CREATE TABLE `TiposEventualidad` (
  `tipoEventualidadID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TiposEventualidad`
--

INSERT INTO `TiposEventualidad` (`tipoEventualidadID`, `nombre`, `descripcion`) VALUES
(1, 'ROBO', 'robo en el local'),
(2, 'destrucción', 'destruccíon de material'),
(3, 'sunami', 'sunami ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TiposProductos`
--

CREATE TABLE `TiposProductos` (
  `tipoProductoID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TiposProductos`
--

INSERT INTO `TiposProductos` (`tipoProductoID`, `nombre`, `descripcion`) VALUES
(2, 'liquido', 'descripcion de liquido'),
(3, 'aerosol', 'aerosol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TiposRubros`
--

CREATE TABLE `TiposRubros` (
  `tipoRubroID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TiposRubros`
--

INSERT INTO `TiposRubros` (`tipoRubroID`, `nombre`, `descripcion`) VALUES
(2, 'limpieza', 'articulos de limpieza'),
(3, 'cosmeticos', 'cosmeticos para damas'),
(4, 'Alfombras', 'Alfombras'),
(5, 'Aromatizacion', 'Aromatizacion'),
(6, 'Articulos de Jardín', 'Articulos de Jardin'),
(7, 'Articulos de piscina', 'Articulos de piscina'),
(8, 'Bolsas', 'Bolsas'),
(9, 'cestos y canastos', 'cestos y canastos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UnidadesMedida`
--

CREATE TABLE `UnidadesMedida` (
  `unidadMedidaID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `UnidadesMedida`
--

INSERT INTO `UnidadesMedida` (`unidadMedidaID`, `nombre`) VALUES
(1, 'Metros'),
(2, 'litro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Users`
--

CREATE TABLE `Users` (
  `uid` int(20) NOT NULL,
  `uname` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `rol` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Users`
--

INSERT INTO `Users` (`uid`, `uname`, `password`, `rol`) VALUES
(2, 'lucas', 'lucas', 'administrador'),
(3, 'juanPablo', 'juanPablo', 'repositor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta`
--

CREATE TABLE `Venta` (
  `ventaID` int(11) NOT NULL,
  `empleado` varchar(500) DEFAULT NULL,
  `ClienteID` int(11) NOT NULL,
  `comentario` varchar(1000) DEFAULT NULL,
  `nroInterno` int(11) DEFAULT NULL,
  `estadoDeVenta` varchar(250) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `monto` decimal(10,0) DEFAULT NULL,
  `formaDePagoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Venta`
--

INSERT INTO `Venta` (`ventaID`, `empleado`, `ClienteID`, `comentario`, `nroInterno`, `estadoDeVenta`, `fecha`, `monto`, `formaDePagoID`) VALUES
(69, 'lucas', 32, NULL, NULL, NULL, '2018-06-15 01:23:33', '102', 1),
(70, 'lucas', 36, NULL, NULL, NULL, '2018-06-15 01:24:31', '79', 4),
(71, 'lucas', 32, NULL, NULL, NULL, '2018-06-15 01:25:27', '103', 2),
(72, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 00:47:40', '204', 1),
(73, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 01:10:29', '428', 1),
(74, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 01:17:31', '316', 1),
(75, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 01:23:30', '316', 1),
(76, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 01:25:07', '306', 1),
(77, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:24:18', '316', 1),
(78, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:29:48', '306', 1),
(79, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:40:32', '316', 1),
(80, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:40:58', '316', 1),
(81, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:50:02', '1071', 1),
(82, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 03:57:30', '1489', 1),
(83, 'lucas', 32, NULL, NULL, NULL, '2018-06-19 05:13:08', '102', 1),
(84, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-06-20 04:02:18', '102', 1),
(85, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-06-20 04:12:42', '102', 1),
(86, 'lucas', 32, 'PRESUPUESTO', NULL, NULL, '2018-06-20 04:13:00', '102', 1),
(87, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-06-20 04:13:34', '102', 1),
(88, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-06-20 14:57:26', '826', 1),
(89, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-03 15:49:33', '510', 1),
(90, 'lucas', 36, 'FACTURA', NULL, NULL, '2018-09-03 16:04:48', '948', 4),
(91, 'lucas', 39, 'FACTURA', NULL, NULL, '2018-09-03 18:27:39', '774', 6),
(92, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-04 17:57:21', '102', 1),
(93, 'lucas', 39, 'FACTURA', NULL, NULL, '2018-09-04 17:57:56', '95', 6),
(94, 'lucas', 39, 'FACTURA', NULL, NULL, '2018-09-06 16:59:41', '869', 6),
(95, 'lucas', 39, 'FACTURA', NULL, NULL, '2018-09-06 17:04:15', '172', 6),
(96, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-06 19:28:53', '254', 1),
(97, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-06 19:29:22', '254', 1),
(98, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 10:54:29', '16350', 9),
(99, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 11:23:45', '204', 1),
(100, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 12:15:36', '753', 6),
(101, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-07 12:25:16', '1890', 10),
(102, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 12:35:03', '541', 1),
(103, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 12:38:41', '204', 1),
(104, 'lucas', 32, 'PRESUPUESTO', NULL, NULL, '2018-09-07 12:53:48', '204', 1),
(105, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 12:59:22', '224', 1),
(106, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 13:14:57', '408', 1),
(107, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 13:15:03', '0', 1),
(108, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 13:16:02', '102', 1),
(109, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 13:16:56', '306', 1),
(110, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:04:37', '408', 1),
(111, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:09:40', '0', 1),
(112, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:10:05', '0', 1),
(113, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:11:50', '408', 1),
(114, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:18:28', '204', 1),
(115, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:21:19', '204', 1),
(116, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:21:40', '102', 1),
(117, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:22:34', '112', 1),
(118, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:26:22', '102', 1),
(119, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:52:11', '0', 1),
(120, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:52:56', '0', 1),
(121, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-07 14:54:30', '0', 1),
(122, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-07 18:45:50', '164', 1),
(123, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-07 18:48:43', '82', 1),
(124, 'lucas', 34, 'FACTURA', NULL, NULL, '2018-09-07 18:49:57', '81', 2),
(125, 'lucas', 38, 'FACTURA', NULL, NULL, '2018-09-07 18:54:39', '82', 1),
(126, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-26 19:12:30', '79', 1),
(127, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-26 19:16:19', '79', 1),
(128, 'lucas', 32, 'FACTURA', NULL, NULL, '2018-09-26 19:16:46', '79', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`ClienteID`);

--
-- Indices de la tabla `condicionIVA`
--
ALTER TABLE `condicionIVA`
  ADD PRIMARY KEY (`condicionIVAID`);

--
-- Indices de la tabla `ConfiguracionesGenerales`
--
ALTER TABLE `ConfiguracionesGenerales`
  ADD PRIMARY KEY (`IdConfiguracionsGenerales`);

--
-- Indices de la tabla `CuentaCorriente`
--
ALTER TABLE `CuentaCorriente`
  ADD PRIMARY KEY (`cuentaCorrienteID`),
  ADD KEY `localidadID` (`localidadID`),
  ADD KEY `formaDePagoID` (`formaDePagoID`(767)),
  ADD KEY `condicionIVAID` (`condicionIVAID`);

--
-- Indices de la tabla `CuentasCorrientes`
--
ALTER TABLE `CuentasCorrientes`
  ADD PRIMARY KEY (`cuentaCorrienteID`);

--
-- Indices de la tabla `Depositos`
--
ALTER TABLE `Depositos`
  ADD PRIMARY KEY (`depositoID`);

--
-- Indices de la tabla `DetalleCuentasCorrientes`
--
ALTER TABLE `DetalleCuentasCorrientes`
  ADD PRIMARY KEY (`detalleCuentaCorrienteID`);

--
-- Indices de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codProducto` (`productoID`),
  ADD KEY `codVenta` (`codVenta`);

--
-- Indices de la tabla `Domicilios`
--
ALTER TABLE `Domicilios`
  ADD PRIMARY KEY (`DomiciliosID`),
  ADD KEY `localidadID` (`localidadID`);

--
-- Indices de la tabla `Estado`
--
ALTER TABLE `Estado`
  ADD PRIMARY KEY (`estadoID`);

--
-- Indices de la tabla `Eventualidades`
--
ALTER TABLE `Eventualidades`
  ADD PRIMARY KEY (`eventualidadID`),
  ADD KEY `tipoEventualidadID` (`tipoEventualidadID`);

--
-- Indices de la tabla `FormaDePago`
--
ALTER TABLE `FormaDePago`
  ADD PRIMARY KEY (`formaDePagoID`);

--
-- Indices de la tabla `Imagenes`
--
ALTER TABLE `Imagenes`
  ADD PRIMARY KEY (`imagenID`),
  ADD KEY `productoID` (`productoID`);

--
-- Indices de la tabla `Localidades`
--
ALTER TABLE `Localidades`
  ADD PRIMARY KEY (`LocalidadID`),
  ADD KEY `provinciaID` (`provinciaID`);

--
-- Indices de la tabla `Ofertas`
--
ALTER TABLE `Ofertas`
  ADD PRIMARY KEY (`ofertaID`);

--
-- Indices de la tabla `OrdenDeCompra`
--
ALTER TABLE `OrdenDeCompra`
  ADD PRIMARY KEY (`ordenDeCompraID`),
  ADD KEY `estadoID` (`estadoID`);

--
-- Indices de la tabla `Productos`
--
ALTER TABLE `Productos`
  ADD PRIMARY KEY (`productoID`),
  ADD KEY `tipoProductoID` (`tipoProductoID`),
  ADD KEY `inventarioID` (`inventarioID`),
  ADD KEY `unidadMedidaID` (`unidadMedidaID`),
  ADD KEY `tipoRubroID` (`tipoRubroID`);

--
-- Indices de la tabla `ProductoXDeposito`
--
ALTER TABLE `ProductoXDeposito`
  ADD PRIMARY KEY (`depositoID`,`productoID`),
  ADD KEY `ProductoXDeposito_ibfk_2` (`productoID`);

--
-- Indices de la tabla `ProductoXDepositoXEventualidad`
--
ALTER TABLE `ProductoXDepositoXEventualidad`
  ADD PRIMARY KEY (`eventualidadID`,`productoID`,`depositoID`),
  ADD KEY `depositoID` (`depositoID`),
  ADD KEY `productoID` (`productoID`);

--
-- Indices de la tabla `ProductoXProveedor`
--
ALTER TABLE `ProductoXProveedor`
  ADD PRIMARY KEY (`ProductoXProveedorID`);

--
-- Indices de la tabla `Proveedores`
--
ALTER TABLE `Proveedores`
  ADD PRIMARY KEY (`ProveedorID`),
  ADD KEY `tipoDocumentoID` (`tipoDocumentoID`),
  ADD KEY `Real_domicilioID` (`Real_domicilioID`),
  ADD KEY `Fiscal_domicilioID` (`Fiscal_domicilioID`),
  ADD KEY `condicionIVAID` (`condicionIVAID`);

--
-- Indices de la tabla `Provincias`
--
ALTER TABLE `Provincias`
  ADD PRIMARY KEY (`provinciaID`);

--
-- Indices de la tabla `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `TipoClientes`
--
ALTER TABLE `TipoClientes`
  ADD PRIMARY KEY (`tipoClienteID`);

--
-- Indices de la tabla `TipoDocumento`
--
ALTER TABLE `TipoDocumento`
  ADD PRIMARY KEY (`tipoDocumentoID`);

--
-- Indices de la tabla `TiposEventualidad`
--
ALTER TABLE `TiposEventualidad`
  ADD PRIMARY KEY (`tipoEventualidadID`);

--
-- Indices de la tabla `TiposProductos`
--
ALTER TABLE `TiposProductos`
  ADD PRIMARY KEY (`tipoProductoID`);

--
-- Indices de la tabla `TiposRubros`
--
ALTER TABLE `TiposRubros`
  ADD PRIMARY KEY (`tipoRubroID`);

--
-- Indices de la tabla `UnidadesMedida`
--
ALTER TABLE `UnidadesMedida`
  ADD PRIMARY KEY (`unidadMedidaID`);

--
-- Indices de la tabla `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`uid`);

--
-- Indices de la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD PRIMARY KEY (`ventaID`),
  ADD KEY `ClienteID` (`ClienteID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
--
-- AUTO_INCREMENT de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `ClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT de la tabla `condicionIVA`
--
ALTER TABLE `condicionIVA`
  MODIFY `condicionIVAID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `ConfiguracionesGenerales`
--
ALTER TABLE `ConfiguracionesGenerales`
  MODIFY `IdConfiguracionsGenerales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `CuentaCorriente`
--
ALTER TABLE `CuentaCorriente`
  MODIFY `cuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `CuentasCorrientes`
--
ALTER TABLE `CuentasCorrientes`
  MODIFY `cuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT de la tabla `Depositos`
--
ALTER TABLE `Depositos`
  MODIFY `depositoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `DetalleCuentasCorrientes`
--
ALTER TABLE `DetalleCuentasCorrientes`
  MODIFY `detalleCuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=180;
--
-- AUTO_INCREMENT de la tabla `Domicilios`
--
ALTER TABLE `Domicilios`
  MODIFY `DomiciliosID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Estado`
--
ALTER TABLE `Estado`
  MODIFY `estadoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Eventualidades`
--
ALTER TABLE `Eventualidades`
  MODIFY `eventualidadID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `FormaDePago`
--
ALTER TABLE `FormaDePago`
  MODIFY `formaDePagoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `Imagenes`
--
ALTER TABLE `Imagenes`
  MODIFY `imagenID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Localidades`
--
ALTER TABLE `Localidades`
  MODIFY `LocalidadID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT de la tabla `Ofertas`
--
ALTER TABLE `Ofertas`
  MODIFY `ofertaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `OrdenDeCompra`
--
ALTER TABLE `OrdenDeCompra`
  MODIFY `ordenDeCompraID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Productos`
--
ALTER TABLE `Productos`
  MODIFY `productoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2547;
--
-- AUTO_INCREMENT de la tabla `ProductoXProveedor`
--
ALTER TABLE `ProductoXProveedor`
  MODIFY `ProductoXProveedorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `Proveedores`
--
ALTER TABLE `Proveedores`
  MODIFY `ProveedorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Provincias`
--
ALTER TABLE `Provincias`
  MODIFY `provinciaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `Roles`
--
ALTER TABLE `Roles`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `TipoClientes`
--
ALTER TABLE `TipoClientes`
  MODIFY `tipoClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `TipoDocumento`
--
ALTER TABLE `TipoDocumento`
  MODIFY `tipoDocumentoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TiposEventualidad`
--
ALTER TABLE `TiposEventualidad`
  MODIFY `tipoEventualidadID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TiposProductos`
--
ALTER TABLE `TiposProductos`
  MODIFY `tipoProductoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `TiposRubros`
--
ALTER TABLE `TiposRubros`
  MODIFY `tipoRubroID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `UnidadesMedida`
--
ALTER TABLE `UnidadesMedida`
  MODIFY `unidadMedidaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Users`
--
ALTER TABLE `Users`
  MODIFY `uid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `ventaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `CuentaCorriente`
--
ALTER TABLE `CuentaCorriente`
  ADD CONSTRAINT `CuentaCorriente_ibfk_1` FOREIGN KEY (`localidadID`) REFERENCES `Localidades` (`LocalidadID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CuentaCorriente_ibfk_3` FOREIGN KEY (`condicionIVAID`) REFERENCES `condicionIVA` (`condicionIVAID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  ADD CONSTRAINT `DetalleVenta_ibfk_1` FOREIGN KEY (`productoID`) REFERENCES `Productos` (`productoID`),
  ADD CONSTRAINT `DetalleVenta_ibfk_2` FOREIGN KEY (`codVenta`) REFERENCES `Venta` (`ventaID`);

--
-- Filtros para la tabla `Domicilios`
--
ALTER TABLE `Domicilios`
  ADD CONSTRAINT `Domicilios_ibfk_1` FOREIGN KEY (`localidadID`) REFERENCES `Localidades` (`LocalidadID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Eventualidades`
--
ALTER TABLE `Eventualidades`
  ADD CONSTRAINT `Eventualidades_ibfk_1` FOREIGN KEY (`tipoEventualidadID`) REFERENCES `TiposEventualidad` (`tipoEventualidadID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Imagenes`
--
ALTER TABLE `Imagenes`
  ADD CONSTRAINT `Imagenes_ibfk_1` FOREIGN KEY (`productoID`) REFERENCES `Productos` (`productoID`);

--
-- Filtros para la tabla `Localidades`
--
ALTER TABLE `Localidades`
  ADD CONSTRAINT `Localidades_ibfk_1` FOREIGN KEY (`provinciaID`) REFERENCES `Provincias` (`provinciaID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `OrdenDeCompra`
--
ALTER TABLE `OrdenDeCompra`
  ADD CONSTRAINT `OrdenDeCompra_ibfk_1` FOREIGN KEY (`estadoID`) REFERENCES `Estado` (`estadoID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ProductoXDeposito`
--
ALTER TABLE `ProductoXDeposito`
  ADD CONSTRAINT `ProductoXDeposito_ibfk_1` FOREIGN KEY (`depositoID`) REFERENCES `Depositos` (`depositoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProductoXDeposito_ibfk_2` FOREIGN KEY (`productoID`) REFERENCES `Productos` (`productoID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ProductoXDepositoXEventualidad`
--
ALTER TABLE `ProductoXDepositoXEventualidad`
  ADD CONSTRAINT `ProductoXDepositoXEventualidad_ibfk_1` FOREIGN KEY (`productoID`) REFERENCES `Productos` (`productoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProductoXDepositoXEventualidad_ibfk_2` FOREIGN KEY (`eventualidadID`) REFERENCES `Eventualidades` (`eventualidadID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProductoXDepositoXEventualidad_ibfk_3` FOREIGN KEY (`depositoID`) REFERENCES `Depositos` (`depositoID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Proveedores`
--
ALTER TABLE `Proveedores`
  ADD CONSTRAINT `Proveedores_ibfk_1` FOREIGN KEY (`tipoDocumentoID`) REFERENCES `TipoDocumento` (`tipoDocumentoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Proveedores_ibfk_4` FOREIGN KEY (`condicionIVAID`) REFERENCES `condicionIVA` (`condicionIVAID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
