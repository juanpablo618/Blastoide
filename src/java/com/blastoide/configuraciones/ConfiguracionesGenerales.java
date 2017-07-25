/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.configuraciones;

/**
 *
 * @author developer
 */
public abstract class ConfiguracionesGenerales {
    
    
    private static final String URL_DE_LOGO_MUNDO_LIMPIEZA = "http://localhost:8080/Blastoide_v2/faces/resources/images/MundoLimpieza2.jpg";
    
    
    private static final String CARPETA_DE_PRESUPUESTOS = "/home/developer/Desktop/Presupuesto";

    public static String getURL_DE_LOGO_MUNDO_LIMPIEZA() {
        return URL_DE_LOGO_MUNDO_LIMPIEZA;
    }

    public static String getCARPETA_DE_PRESUPUESTOS() {
        return CARPETA_DE_PRESUPUESTOS;
    }
    
    
    
    
    
}
