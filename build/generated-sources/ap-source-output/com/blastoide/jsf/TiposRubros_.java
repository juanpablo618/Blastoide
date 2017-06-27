package com.blastoide.jsf;

import com.blastoide.jsf.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-15T15:29:42")
@StaticMetamodel(TiposRubros.class)
public class TiposRubros_ { 

    public static volatile SingularAttribute<TiposRubros, Integer> tipoRubroID;
    public static volatile SingularAttribute<TiposRubros, String> descripcion;
    public static volatile CollectionAttribute<TiposRubros, Productos> productosCollection;
    public static volatile SingularAttribute<TiposRubros, String> nombre;

}