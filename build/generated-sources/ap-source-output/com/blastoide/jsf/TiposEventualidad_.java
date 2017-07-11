package com.blastoide.jsf;

import com.blastoide.jsf.Eventualidades;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(TiposEventualidad.class)
public class TiposEventualidad_ { 

    public static volatile SingularAttribute<TiposEventualidad, String> descripcion;
    public static volatile CollectionAttribute<TiposEventualidad, Eventualidades> eventualidadesCollection;
    public static volatile SingularAttribute<TiposEventualidad, Integer> tipoEventualidadID;
    public static volatile SingularAttribute<TiposEventualidad, String> nombre;

}