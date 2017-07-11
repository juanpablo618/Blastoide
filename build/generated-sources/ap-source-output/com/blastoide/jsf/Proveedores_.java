package com.blastoide.jsf;

import com.blastoide.jsf.CondicionIVA;
import com.blastoide.jsf.Domicilios;
import com.blastoide.jsf.ProductoXProveedor;
import com.blastoide.jsf.TipoDocumento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T16:11:42")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, TipoDocumento> tipoDocumentoID;
    public static volatile SingularAttribute<Proveedores, Integer> proveedorID;
    public static volatile SingularAttribute<Proveedores, Date> fechaNacimiento;
    public static volatile SingularAttribute<Proveedores, CondicionIVA> condicionIVAID;
    public static volatile SingularAttribute<Proveedores, String> nombre;
    public static volatile SingularAttribute<Proveedores, Domicilios> realdomicilioID;
    public static volatile CollectionAttribute<Proveedores, ProductoXProveedor> productoXProveedorCollection;
    public static volatile SingularAttribute<Proveedores, String> razonSocial;
    public static volatile SingularAttribute<Proveedores, String> cuit;
    public static volatile SingularAttribute<Proveedores, String> web;
    public static volatile SingularAttribute<Proveedores, String> apellido;
    public static volatile SingularAttribute<Proveedores, Domicilios> fiscaldomicilioID;
    public static volatile SingularAttribute<Proveedores, String> celular;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> sexo;
    public static volatile SingularAttribute<Proveedores, Long> nroDocumento;
    public static volatile SingularAttribute<Proveedores, String> email;

}