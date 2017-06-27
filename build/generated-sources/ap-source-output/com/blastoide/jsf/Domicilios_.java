package com.blastoide.jsf;

import com.blastoide.jsf.Localidades;
import com.blastoide.jsf.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-15T15:29:42")
@StaticMetamodel(Domicilios.class)
public class Domicilios_ { 

    public static volatile SingularAttribute<Domicilios, Integer> piso;
    public static volatile SingularAttribute<Domicilios, Integer> numero;
    public static volatile CollectionAttribute<Domicilios, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Domicilios, Integer> domiciliosID;
    public static volatile SingularAttribute<Domicilios, String> calle;
    public static volatile CollectionAttribute<Domicilios, Proveedores> proveedoresCollection1;
    public static volatile SingularAttribute<Domicilios, String> departamento;
    public static volatile SingularAttribute<Domicilios, Localidades> localidadID;

}