package com.blastoide.jsf;

import com.blastoide.jsf.Depositos;
import com.blastoide.jsf.ProductoXDepositoPK;
import com.blastoide.jsf.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T12:57:05")
@StaticMetamodel(ProductoXDeposito.class)
public class ProductoXDeposito_ { 

    public static volatile SingularAttribute<ProductoXDeposito, ProductoXDepositoPK> productoXDepositoPK;
    public static volatile SingularAttribute<ProductoXDeposito, Integer> stockParcial;
    public static volatile SingularAttribute<ProductoXDeposito, Depositos> depositos;
    public static volatile SingularAttribute<ProductoXDeposito, Productos> productos;

}