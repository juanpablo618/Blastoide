package com.blastoide.jsf;

import com.blastoide.jsf.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(TiposProductos.class)
public class TiposProductos_ { 

    public static volatile SingularAttribute<TiposProductos, String> descripcion;
    public static volatile SingularAttribute<TiposProductos, Integer> tipoProductoID;
    public static volatile CollectionAttribute<TiposProductos, Productos> productosCollection;
    public static volatile SingularAttribute<TiposProductos, String> nombre;

}