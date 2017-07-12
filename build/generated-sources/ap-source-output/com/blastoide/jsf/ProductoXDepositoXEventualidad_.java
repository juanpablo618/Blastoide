package com.blastoide.jsf;

import com.blastoide.jsf.Depositos;
import com.blastoide.jsf.Eventualidades;
import com.blastoide.jsf.ProductoXDepositoXEventualidadPK;
import com.blastoide.jsf.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T16:10:02")
@StaticMetamodel(ProductoXDepositoXEventualidad.class)
public class ProductoXDepositoXEventualidad_ { 

    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, ProductoXDepositoXEventualidadPK> productoXDepositoXEventualidadPK;
    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, Integer> stockPrevio;
    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, Depositos> depositos;
    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, Integer> stockPosterior;
    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, Productos> productos;
    public static volatile SingularAttribute<ProductoXDepositoXEventualidad, Eventualidades> eventualidades;

}