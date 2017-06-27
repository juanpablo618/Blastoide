package com.blastoide.jsf;

import com.blastoide.jsf.Estado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-15T15:29:42")
@StaticMetamodel(OrdenDeCompra.class)
public class OrdenDeCompra_ { 

    public static volatile SingularAttribute<OrdenDeCompra, Integer> ordenDeCompraID;
    public static volatile SingularAttribute<OrdenDeCompra, Date> fechaCierre;
    public static volatile SingularAttribute<OrdenDeCompra, Float> total;
    public static volatile SingularAttribute<OrdenDeCompra, Float> restoTotal;
    public static volatile SingularAttribute<OrdenDeCompra, Date> fechaCreacion;
    public static volatile SingularAttribute<OrdenDeCompra, Date> fechaEmision;
    public static volatile SingularAttribute<OrdenDeCompra, Estado> estadoID;
    public static volatile SingularAttribute<OrdenDeCompra, Integer> numeroOC;

}