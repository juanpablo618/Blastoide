-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-07-2017 a las 22:49:34
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
  `TipoCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`ClienteID`, `nombre`, `dni`, `TipoCliente`) VALUES
(1, 'juan pablo', '35054822', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condicionIVA`
--

CREATE TABLE `condicionIVA` (
  `condicionIVAID` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `condicionIVA`
--

INSERT INTO `condicionIVA` (`condicionIVAID`, `nombre`, `descripcion`) VALUES
(1, 'responsable inscripto', 'responsable inscripto'),
(2, 'responsable no categorizado', 'responsable no categorizado');

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
-- Estructura de tabla para la tabla `Depositos`
--

CREATE TABLE `Depositos` (
  `depositoID` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'en dinero en efectivo', 'Efectivo', 21),
(2, 'transferencia bancaria', 'transferencia bancaria', 11),
(3, 'Tarjeta de crédito', 'Tarjeta de crédito', 4),
(4, 'Tarjeta de débito', 'Tarjeta de débito', 27),
(5, 'PayPal', 'PayPal', 2),
(6, 'Western Union\r\n', 'Western Union\r\n', 51),
(7, 'Transferencia bancaria fuera de línea\r\n', 'Transferencia bancaria fuera de línea\r\n', 41);

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
-- Estructura de tabla para la tabla `Inventarios`
--

CREATE TABLE `Inventarios` (
  `inventarioID` int(11) NOT NULL,
  `Cu` int(11) NOT NULL,
  `Cc` int(11) NOT NULL,
  `n` int(11) NOT NULL,
  `q` int(11) NOT NULL,
  `dMin` int(11) NOT NULL,
  `dMax` int(11) NOT NULL,
  `periodoTiempo` int(11) NOT NULL,
  `t` int(11) NOT NULL,
  `m` int(11) NOT NULL,
  `s` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `z` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Inventarios`
--

INSERT INTO `Inventarios` (`inventarioID`, `Cu`, `Cc`, `n`, `q`, `dMin`, `dMax`, `periodoTiempo`, `t`, `m`, `s`, `x`, `z`) VALUES
(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

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
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `fragancia` varchar(100) NOT NULL,
  `caracteristica` varchar(200) NOT NULL,
  `medida` varchar(100) NOT NULL,
  `precioVenta` double NOT NULL,
  `unidadMedidaID` int(11) NOT NULL,
  `tipoProductoID` int(11) NOT NULL,
  `tipoRubroID` int(11) NOT NULL,
  `ultimaActualizacionStock` date NOT NULL,
  `inventarioID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Productos`
--

INSERT INTO `Productos` (`productoID`, `codigo`, `nombre`, `marca`, `fragancia`, `caracteristica`, `medida`, `precioVenta`, `unidadMedidaID`, `tipoProductoID`, `tipoRubroID`, `ultimaActualizacionStock`, `inventarioID`) VALUES
(1, '123456789', 'ayudin', 'marcaprod', 'fragaprod', 'caraprod', '21', 81.9, 1, 2, 1, '2017-05-24', 1),
(2, '1234567891234', 'limpia vidrio', 'marcasa', 'fraganciafra', 'caracaracara', '20', 50.96, 1, 2, 1, '2017-05-31', 1),
(3, '1234567899874', 'alfombra', 'marcasa', 'frada', 'asdasdas', 'CM', 25.96, 1, 2, 1, '2017-05-16', 1),
(4, '1234567899874', 'escoba', 'marcabra', 'fragabra', 'brabrabra', 'ML', 26.98, 1, 2, 1, '2017-05-30', 1),
(5, '1234567899999', 'lavandina', 'marca', 'fragancia', 'caracteristica', 'XXG', 21.86, 1, 2, 1, '2017-05-17', 1);

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
-- Estructura de tabla para la tabla `UserRoles`
--

CREATE TABLE `UserRoles` (
  `UserId` int(20) NOT NULL,
  `RoleId` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Users`
--

CREATE TABLE `Users` (
  `Id` int(11) NOT NULL,
  `Email` int(11) NOT NULL,
  `EmailConfirmed` tinyint(1) NOT NULL,
  `PasswordHash` varchar(300) NOT NULL,
  `SecurityStamp` int(11) NOT NULL,
  `PhoneNumber` int(50) NOT NULL,
  `PhoneNumberConfirmed` tinyint(1) NOT NULL,
  `Username` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indices de la tabla `Depositos`
--
ALTER TABLE `Depositos`
  ADD PRIMARY KEY (`depositoID`);

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
-- Indices de la tabla `Inventarios`
--
ALTER TABLE `Inventarios`
  ADD PRIMARY KEY (`inventarioID`);

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
-- Indices de la tabla `UserRoles`
--
ALTER TABLE `UserRoles`
  ADD PRIMARY KEY (`UserId`),
  ADD KEY `RoleId` (`RoleId`);

--
-- Indices de la tabla `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`Id`);

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
  MODIFY `ClienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `condicionIVA`
--
ALTER TABLE `condicionIVA`
  MODIFY `condicionIVAID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `CuentaCorriente`
--
ALTER TABLE `CuentaCorriente`
  MODIFY `cuentaCorrienteID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Depositos`
--
ALTER TABLE `Depositos`
  MODIFY `depositoID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
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
  MODIFY `formaDePagoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `Imagenes`
--
ALTER TABLE `Imagenes`
  MODIFY `imagenID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Inventarios`
--
ALTER TABLE `Inventarios`
  MODIFY `inventarioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
  MODIFY `productoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `ventaID` int(11) NOT NULL AUTO_INCREMENT;
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
  ADD CONSTRAINT `Productos_ibfk_2` FOREIGN KEY (`inventarioID`) REFERENCES `Inventarios` (`inventarioID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
-- Filtros para la tabla `UserRoles`
--
ALTER TABLE `UserRoles`
  ADD CONSTRAINT `UserRoles_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `Users` (`Id`),
  ADD CONSTRAINT `UserRoles_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `UserRoles` (`UserId`);

--
-- Filtros para la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD CONSTRAINT `Venta_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `Cliente` (`ClienteID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
