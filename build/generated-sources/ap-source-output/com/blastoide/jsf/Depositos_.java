package com.blastoide.jsf;

import com.blastoide.jsf.ProductoXDeposito;
import com.blastoide.jsf.ProductoXDepositoXEventualidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T12:57:05")
@StaticMetamodel(Depositos.class)
public class Depositos_ { 

    public static volatile SingularAttribute<Depositos, String> descripcion;
    public static volatile CollectionAttribute<Depositos, ProductoXDeposito> productoXDepositoCollection;
    public static volatile CollectionAttribute<Depositos, ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;
    public static volatile SingularAttribute<Depositos, String> nombre;
    public static volatile SingularAttribute<Depositos, Integer> depositoID;

}