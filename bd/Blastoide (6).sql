-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-09-2017 a las 22:50:02
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

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
(27, 'juan', '20321031', 4, 5, 'cuello', 'email.com', '2312312', NULL, 20321031, '', 'masculino', '1231231', '123123', NULL, NULL, NULL, NULL, 3, 'Mon Jan 16 18:30:00 CST 8', 44);

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
(4, 'Exento', 'Exento', 0);

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
(44, 20000, 1778.95);

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
(1, 88.752, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 16:05:23', 44, 0, 88.752),
(2, 21.584, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 16:53:11', 44, 0, 110.336),
(3, 101.584, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 16:55:31', 44, 0, 211.92),
(4, 46.4, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 16:57:11', 44, 0, 258.32),
(5, 46.4, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 16:58:19', 44, 0, 304.72),
(6, 21.584, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 17:04:58', 44, 0, 326.304),
(7, 275.04, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 17:05:55', 44, 0, 601.344),
(8, 108.752, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 17:14:41', 44, 0, 710.096),
(9, 209.36, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:10:49', 44, 0, 919.456),
(10, 278.4, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:27:00', 44, 0, 1197.86),
(11, 40.768, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:35:31', 44, 0, 1238.63),
(12, 40.768, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:36:38', 44, 0, 1279.4),
(13, 40.768, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:39:26', 44, 0, 1320.17),
(14, 42.352, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 20:39:53', 44, 0, 1362.52),
(15, 40.768, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 21:01:09', 44, 0, 1403.29),
(16, 81.536, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 21:01:21', 44, 0, 1484.83),
(17, 147.056, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 21:01:41', 44, 0, 1631.89),
(18, 147.056, 0, 'venta a cliente con cta corriente: 44', '2017-09-01 21:02:11', 44, 0, 1778.95);

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
(4, 2, 4, 1),
(5, 3, 1, 1),
(6, 3, 2, 1),
(7, 3, 3, 1),
(8, 3, 4, 1),
(9, 3, 5, 1),
(10, 3, 6, 1),
(11, 4, 2, 1),
(12, 4, 4, 1),
(13, 4, 6, 1),
(14, 5, 1, 1),
(15, 5, 2, 2),
(16, 5, 3, 3),
(17, 6, 2, 2),
(18, 7, 2, 2),
(19, 8, 5, 2),
(20, 9, 5, 2),
(21, 10, 6, 9),
(22, 11, 6, 6),
(23, 12, 2, 1),
(24, 13, 2, 1),
(25, 14, 2, 1),
(26, 15, 3, 1),
(27, 15, 4, 1),
(28, 16, 2, 1),
(29, 17, 2, 2),
(30, 18, 2, 2),
(31, 18, 1, 1),
(32, 19, 2, 2),
(33, 19, 1, 1);

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
(1, 'charcas ', 1636, 'punilla', 2, 1);

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
(2, 'enviado', 'enviado a proveedor');

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
(7, 'Tarjetas de Crédito de 1 a 3 cuotas.', 'Tarjetas de Crédito 1 a 3 Cuotas.', 7),
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
(3, 5, 'Cosquín', '1231');

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
  `numeroOC` int(11) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `fechaEmision` date NOT NULL,
  `fechaCierre` date NOT NULL,
  `total` float NOT NULL,
  `restoTotal` float NOT NULL,
  `estadoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `OrdenDeCompra`
--

INSERT INTO `OrdenDeCompra` (`ordenDeCompraID`, `numeroOC`, `fechaCreacion`, `fechaEmision`, `fechaCierre`, `total`, `restoTotal`, `estadoID`) VALUES
(1, 120, '2017-06-21', '2017-06-16', '2017-06-28', 45.9, 3, 1);

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
(1, '123456789', 'lavandina ayudin doble rendimiento,multisuperficie, por 2 litros', 'marcaprod', 'fragaprod', 'caraprod', '21', 81.9, 1, 2, 1, '2017-05-24', 1, NULL, 48, 5),
(2, '1234567891234', 'Alcohol en gel, 1 litro', 'marcasa', 'fraganciafra', 'caracaracara', '20', 50.96, 1, 2, 1, '2017-05-31', 1, NULL, 10, 5),
(3, '1234567899875', 'Glade en aerosol aromatizante', 'marcasa', 'frada', 'asdasdas', 'CM', 25.96, 1, 2, 1, '2017-05-16', 1, NULL, 39, 4),
(4, '1234567899874', 'Bolsa de basura transparente', 'marcabra', 'fragabra', 'brabrabra', 'ML', 26.98, 1, 2, 1, '2017-05-30', 1, NULL, 29, 20),
(5, '1234567899999', 'Papel higienico doble hoja.', 'marca', 'fragancia', 'caracteristica', 'XXG', 100, 1, 2, 1, '2017-05-17', 1, NULL, 60, 6),
(6, '1231234561231', 'servilletas', 'servimax', 'fragancia', 'seda cara', 'GDE', 58, 1, 2, 1, '2017-08-30', 1, 0, 6, 7);

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
  `ProveedorID` int(11) NOT NULL,
  `ProductoID` int(11) NOT NULL,
  `precioCosto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ProductoXProveedor`
--

INSERT INTO `ProductoXProveedor` (`ProveedorID`, `ProductoID`, `precioCosto`) VALUES
(1, 3, 50);

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
  `Real_domicilioID` int(11) NOT NULL,
  `Fiscal_domicilioID` int(11) NOT NULL,
  `condicionIVAID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Proveedores`
--

INSERT INTO `Proveedores` (`ProveedorID`, `nombre`, `apellido`, `cuit`, `email`, `fechaNacimiento`, `nroDocumento`, `tipoDocumentoID`, `razonSocial`, `telefono`, `celular`, `sexo`, `web`, `Real_domicilioID`, `Fiscal_domicilioID`, `condicionIVAID`) VALUES
(1, 'juan', 'cuello', '20350548220', 'juan@web.com', '2017-05-23', 35054822, 1, 'empresa', '4522524', '3513220999', 'masculino', 'www.web.com', 1, 1, 1),
(2, 'juan cuello', 'cuello', '1234567891111111', 'email@email.cm', '2017-06-14', 35054822, 1, 'empresa222', '4522524', '3519885776', 'Masculino', 'www.web.com', 1, 1, 1);

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
(4, 'Franquicia', 'Franquicia', 25),
(5, 'Cliente común', 'Cliente', 0);

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
(2, 'liquido', 'descripcion de liquido');

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
(1, 'tipoRUbroNombre', 'TipoRubroDescripcion');

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
(1, 'juan', 'juan', 'vendedor'),
(2, 'lucas', 'lucas', 'administrador'),
(3, 'ramiro', 'ramiro', 'administrador');

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
(2, 'juan', 27, NULL, NULL, NULL, '2017-09-01 17:04:58', '22', 5),
(3, 'juan', 27, NULL, NULL, NULL, '2017-09-01 17:05:54', '275', 5),
(4, 'juan', 27, NULL, NULL, NULL, '2017-09-01 17:14:41', '109', 5),
(5, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:10:48', '209', 5),
(6, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:17:30', '82', 5),
(7, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:18:12', '82', 5),
(8, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:21:06', '160', 5),
(9, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:21:40', '160', 5),
(10, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:23:19', '418', 5),
(11, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:27:00', '278', 5),
(12, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:35:30', '41', 5),
(13, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:36:38', '41', 5),
(14, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:39:26', '41', 5),
(15, 'juan', 27, NULL, NULL, NULL, '2017-09-01 20:39:52', '42', 5),
(16, 'juan', 27, NULL, NULL, NULL, '2017-09-01 21:01:08', '41', 5),
(17, 'juan', 27, NULL, NULL, NULL, '2017-09-01 21:01:20', '82', 5),
(18, 'juan', 27, NULL, NULL, NULL, '2017-09-01 21:01:41', '147', 5),
(19, 'juan', 27, NULL, NULL, NULL, '2017-09-01 21:02:11', '147', 5);

--
-- Índices para tablas volcadas
--

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
  ADD PRIMARY KEY (`ProveedorID`,`ProductoID`),
  ADD KEY `ProductoXProveedor_ibfk_1` (`ProductoID`);

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
-- AUTO_INCREMENT de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `ClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `condicionIVA`
--
ALTER TABLE `condicionIVA`
  MODIFY `condicionIVAID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `CuentaCorriente`
--
ALTER TABLE `CuentaCorriente`
  MODIFY `cuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `CuentasCorrientes`
--
ALTER TABLE `CuentasCorrientes`
  MODIFY `cuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT de la tabla `Depositos`
--
ALTER TABLE `Depositos`
  MODIFY `depositoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `DetalleCuentasCorrientes`
--
ALTER TABLE `DetalleCuentasCorrientes`
  MODIFY `detalleCuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT de la tabla `Domicilios`
--
ALTER TABLE `Domicilios`
  MODIFY `DomiciliosID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
  MODIFY `LocalidadID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Ofertas`
--
ALTER TABLE `Ofertas`
  MODIFY `ofertaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `OrdenDeCompra`
--
ALTER TABLE `OrdenDeCompra`
  MODIFY `ordenDeCompraID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Productos`
--
ALTER TABLE `Productos`
  MODIFY `productoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
  MODIFY `tipoClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
  MODIFY `tipoProductoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `TiposRubros`
--
ALTER TABLE `TiposRubros`
  MODIFY `tipoRubroID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
  MODIFY `ventaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
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
-- Filtros para la tabla `Productos`
--
ALTER TABLE `Productos`
  ADD CONSTRAINT `Productos_ibfk_1` FOREIGN KEY (`tipoProductoID`) REFERENCES `TiposProductos` (`tipoProductoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Productos_ibfk_3` FOREIGN KEY (`unidadMedidaID`) REFERENCES `UnidadesMedida` (`unidadMedidaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Productos_ibfk_4` FOREIGN KEY (`tipoRubroID`) REFERENCES `TiposRubros` (`tipoRubroID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
-- Filtros para la tabla `ProductoXProveedor`
--
ALTER TABLE `ProductoXProveedor`
  ADD CONSTRAINT `ProductoXProveedor_ibfk_1` FOREIGN KEY (`ProductoID`) REFERENCES `Productos` (`productoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProductoXProveedor_ibfk_2` FOREIGN KEY (`ProveedorID`) REFERENCES `Proveedores` (`ProveedorID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Proveedores`
--
ALTER TABLE `Proveedores`
  ADD CONSTRAINT `Proveedores_ibfk_1` FOREIGN KEY (`tipoDocumentoID`) REFERENCES `TipoDocumento` (`tipoDocumentoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Proveedores_ibfk_2` FOREIGN KEY (`Real_domicilioID`) REFERENCES `Domicilios` (`DomiciliosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Proveedores_ibfk_3` FOREIGN KEY (`Fiscal_domicilioID`) REFERENCES `Domicilios` (`DomiciliosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Proveedores_ibfk_4` FOREIGN KEY (`condicionIVAID`) REFERENCES `condicionIVA` (`condicionIVAID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD CONSTRAINT `Venta_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `Cliente` (`ClienteID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
