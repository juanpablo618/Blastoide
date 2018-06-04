package com.blastoide.configuraciones;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public abstract class ConfiguracionesGenerales {
        
    private static final String URL_DE_LOGO_MUNDO_LIMPIEZA = "http://localhost:8080/Blastoide_v2/faces/resources/images/MundoLimpieza2.jpg";
    
    //configuracion para mi linux = /home/juan/Documents
    //ANDA EN PC DE LUCAS NO BORRAR
    //private static final String CARPETA_DE_PRESUPUESTOS = "C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\";

  private static final String CARPETA_DE_PRESUPUESTOS = "/home/juan/Documents";
    
/////////////////////////////////////////////////////////////////////////////DOWNLOAD BEAN ////////////////////////////////////////////////////

//configuracion para mi linux = file:///home/juan/Documents
//configuracion q anda para lucas file:///C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\
//private static final String PDF_URL = "file:///C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\";
   
private static final String PDF_URL = "file:///home/juan/Documents";

    public static String getPDF_URL() {
        return PDF_URL;
    }
    public static String getURL_DE_LOGO_MUNDO_LIMPIEZA() {
        return URL_DE_LOGO_MUNDO_LIMPIEZA;
    }

    public static String getCARPETA_DE_PRESUPUESTOS() {
        return CARPETA_DE_PRESUPUESTOS;
    }
}