package com.blastoide.jsf;

import com.blastoide.jsf.Imagenes;
import com.blastoide.jsf.Inventarios;
import com.blastoide.jsf.ProductoXDeposito;
import com.blastoide.jsf.ProductoXDepositoXEventualidad;
import com.blastoide.jsf.ProductoXProveedor;
import com.blastoide.jsf.TiposProductos;
import com.blastoide.jsf.TiposRubros;
import com.blastoide.jsf.UnidadesMedida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T16:10:02")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Inventarios> inventarioID;
    public static volatile SingularAttribute<Productos, String> codigo;
    public static volatile SingularAttribute<Productos, TiposProductos> tipoProductoID;
    public static volatile CollectionAttribute<Productos, Imagenes> imagenesCollection;
    public static volatile SingularAttribute<Productos, String> caracteristica;
    public static volatile SingularAttribute<Productos, Date> ultimaActualizacionStock;
    public static volatile SingularAttribute<Productos, String> medida;
    public static volatile CollectionAttribute<Productos, ProductoXDeposito> productoXDepositoCollection;
    public static volatile SingularAttribute<Productos, Integer> productoID;
    public static volatile SingularAttribute<Productos, String> fragancia;
    public static volatile CollectionAttribute<Productos, ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile SingularAttribute<Productos, TiposRubros> tipoRubroID;
    public static volatile SingularAttribute<Productos, String> marca;
    public static volatile CollectionAttribute<Productos, ProductoXProveedor> productoXProveedorCollection;
    public static volatile SingularAttribute<Productos, UnidadesMedida> unidadMedidaID;
    public static volatile SingularAttribute<Productos, Double> precioVenta;

}