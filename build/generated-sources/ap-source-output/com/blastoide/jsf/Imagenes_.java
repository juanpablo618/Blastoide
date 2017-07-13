package com.blastoide.jsf;

import com.blastoide.jsf.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T14:35:21")
@StaticMetamodel(Imagenes.class)
public class Imagenes_ { 

    public static volatile SingularAttribute<Imagenes, String> fileName;
    public static volatile SingularAttribute<Imagenes, Productos> productoID;
    public static volatile SingularAttribute<Imagenes, byte[]> fileImagen;
    public static volatile SingularAttribute<Imagenes, Integer> imagenID;
    public static volatile SingularAttribute<Imagenes, Integer> contentType;
    public static volatile SingularAttribute<Imagenes, Integer> fileType;

}