package com.blastoide.jsf;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T16:10:02")
@StaticMetamodel(Ofertas.class)
public class Ofertas_ { 

    public static volatile SingularAttribute<Ofertas, String> descripcion;
    public static volatile SingularAttribute<Ofertas, Double> descuentoPesos;
    public static volatile SingularAttribute<Ofertas, Date> fechaHasta;
    public static volatile SingularAttribute<Ofertas, Double> descuentoPorcentaje;
    public static volatile SingularAttribute<Ofertas, Date> fechaDesde;
    public static volatile SingularAttribute<Ofertas, Integer> ofertaID;
    public static volatile SingularAttribute<Ofertas, String> titulo;
    public static volatile SingularAttribute<Ofertas, Integer> cantidad;
    public static volatile SingularAttribute<Ofertas, Float> precioDeOferta;

}