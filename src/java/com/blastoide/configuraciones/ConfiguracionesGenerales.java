package com.blastoide.configuraciones;

import com.blastoide.jpa.ConfiguracionesGeneralesController;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public abstract class ConfiguracionesGenerales {
        
           FacesContext context = FacesContext.getCurrentInstance();
            ConfiguracionesGeneralesController configuracionesGeneralesController = context.getApplication().evaluateExpressionGet(context, "#{configuracionesGeneralesController}", ConfiguracionesGeneralesController.class);
      
    
    //private static final String URL_DE_LOGO_MUNDO_LIMPIEZA = "http://localhost:8080/Blastoide_v2/faces/resources/images/MundoLimpieza2.jpg";
    private final String URL_DE_LOGO_MUNDO_LIMPIEZA = configuracionesGeneralesController.getConfiguracionesGenerales(1).getUrlDeLogoMundoLimpieza();
    
            
    //configuracion para mi linux = /home/juan/Documents
    //ANDA EN PC DE LUCAS NO BORRAR
    //private static final String CARPETA_DE_PRESUPUESTOS = "C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\";

//  private static final String CARPETA_DE_PRESUPUESTOS = "/home/juan/Documents";
  
    private final String CARPETA_DE_PRESUPUESTOS = configuracionesGeneralesController.getConfiguracionesGenerales(1).getCarpetaDePresupuestos();
    
/////////////////////////////////////////////////////////////////////////////DOWNLOAD BEAN ////////////////////////////////////////////////////

//configuracion para mi linux = file:///home/juan/Documents
//configuracion q anda para lucas file:///C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\
//private static final String PDF_URL = "file:///C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\";
   
//private static final String PDF_URL = "file:///home/juan/Documents";

    /////////////////////////////////////////////////////////////////////////////////
    //configuraciones para el server de jelastic:
    
    /*

        carpeta donde se guardan los presupuestos:	/opt/glassfish/glassfish/domains/domain1/applications/ROOT/resources/facturas/
        url donde se leen los presupuestos:	http://node22837-env-0799796.jelastic.saveincloud.net/faces/resources/facturas/
            node23606-env-2761534    
    url del logo principal del sistema:	/opt/glassfish/glassfish/domains/domain1/applications/ROOT/resources/images/MundoLimpieza2.jpg
    
    */
    
    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    
    
private final String PDF_URL = configuracionesGeneralesController.getConfiguracionesGenerales(1).getPdfUrl();

    public String getPDF_URL() {
        return PDF_URL;
    }
    public  String getURL_DE_LOGO_MUNDO_LIMPIEZA() {
        return URL_DE_LOGO_MUNDO_LIMPIEZA;
    }

    public String getCARPETA_DE_PRESUPUESTOS() {
        return CARPETA_DE_PRESUPUESTOS;
    }
}