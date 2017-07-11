package com.blastoide.jsf;

import com.blastoide.jsf.CuentaCorriente;
import com.blastoide.jsf.Domicilios;
import com.blastoide.jsf.Provincias;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(Localidades.class)
public class Localidades_ { 

    public static volatile CollectionAttribute<Localidades, CuentaCorriente> cuentaCorrienteCollection;
    public static volatile SingularAttribute<Localidades, String> codigoPostal;
    public static volatile SingularAttribute<Localidades, Provincias> provinciaID;
    public static volatile SingularAttribute<Localidades, Integer> localidadID;
    public static volatile SingularAttribute<Localidades, String> nombre;
    public static volatile CollectionAttribute<Localidades, Domicilios> domiciliosCollection;

}