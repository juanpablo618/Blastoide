package com.blastoide.jsf;

import com.blastoide.jsf.CondicionIVA;
import com.blastoide.jsf.Localidades;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T12:57:05")
@StaticMetamodel(CuentaCorriente.class)
public class CuentaCorriente_ { 

    public static volatile SingularAttribute<CuentaCorriente, String> nombreDeFantasia;
    public static volatile SingularAttribute<CuentaCorriente, Integer> codigoPostal;
    public static volatile SingularAttribute<CuentaCorriente, String> formaDePagoID;
    public static volatile SingularAttribute<CuentaCorriente, Integer> nroDeComprobante;
    public static volatile SingularAttribute<CuentaCorriente, String> nombreyApellido;
    public static volatile SingularAttribute<CuentaCorriente, CondicionIVA> condicionIVAID;
    public static volatile SingularAttribute<CuentaCorriente, Float> descuento;
    public static volatile SingularAttribute<CuentaCorriente, String> conducta;
    public static volatile SingularAttribute<CuentaCorriente, Float> debe;
    public static volatile SingularAttribute<CuentaCorriente, String> nombreDeFacturacion;
    public static volatile SingularAttribute<CuentaCorriente, Integer> cuentaCorrienteID;
    public static volatile SingularAttribute<CuentaCorriente, Date> fecha;
    public static volatile SingularAttribute<CuentaCorriente, Float> haber;
    public static volatile SingularAttribute<CuentaCorriente, Date> fechaDePago;
    public static volatile SingularAttribute<CuentaCorriente, String> cuit;
    public static volatile SingularAttribute<CuentaCorriente, String> concepto;
    public static volatile SingularAttribute<CuentaCorriente, String> observaciones;
    public static volatile SingularAttribute<CuentaCorriente, Integer> credito;
    public static volatile SingularAttribute<CuentaCorriente, String> direccionFacturacion;
    public static volatile SingularAttribute<CuentaCorriente, String> direccionReal;
    public static volatile SingularAttribute<CuentaCorriente, String> telefono;
    public static volatile SingularAttribute<CuentaCorriente, Localidades> localidadID;

}