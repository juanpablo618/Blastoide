package com.blastoide.jsf;

import com.blastoide.jsf.CuentaCorriente;
import com.blastoide.jsf.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T16:10:02")
@StaticMetamodel(CondicionIVA.class)
public class CondicionIVA_ { 

    public static volatile SingularAttribute<CondicionIVA, String> descripcion;
    public static volatile CollectionAttribute<CondicionIVA, CuentaCorriente> cuentaCorrienteCollection;
    public static volatile SingularAttribute<CondicionIVA, Integer> condicionIVAID;
    public static volatile CollectionAttribute<CondicionIVA, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<CondicionIVA, String> nombre;

}