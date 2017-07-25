package com.blastoide.jsf;

import com.blastoide.jsf.OrdenDeCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T14:35:21")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> descripcion;
    public static volatile CollectionAttribute<Estado, OrdenDeCompra> ordenDeCompraCollection;
    public static volatile SingularAttribute<Estado, Integer> estadoID;
    public static volatile SingularAttribute<Estado, String> ambito;

}