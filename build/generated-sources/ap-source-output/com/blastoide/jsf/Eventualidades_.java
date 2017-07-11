package com.blastoide.jsf;

import com.blastoide.jsf.ProductoXDepositoXEventualidad;
import com.blastoide.jsf.TiposEventualidad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(Eventualidades.class)
public class Eventualidades_ { 

    public static volatile SingularAttribute<Eventualidades, Date> fecha;
    public static volatile SingularAttribute<Eventualidades, Integer> eventualidadID;
    public static volatile SingularAttribute<Eventualidades, Integer> totalPerdida;
    public static volatile SingularAttribute<Eventualidades, String> observaciones;
    public static volatile CollectionAttribute<Eventualidades, ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;
    public static volatile SingularAttribute<Eventualidades, TiposEventualidad> tipoEventualidadID;

}