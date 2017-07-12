package com.blastoide.jsf;

import com.blastoide.jsf.Proveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-12T16:10:02")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, Integer> tipoDocumentoID;
    public static volatile CollectionAttribute<TipoDocumento, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<TipoDocumento, String> nombre;

}