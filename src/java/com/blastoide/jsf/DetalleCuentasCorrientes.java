/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class DetalleCuentasCorrientes {
    
    private int detalleCuentaCorrienteID;
    private float debe;
    private float haber;
    private String descripcion;
    private String fecha;
    private int cuentaCorrienteID;
    private int ventaID;

    public DetalleCuentasCorrientes() {
    }
    
    

    public int getDetalleCuentaCorrienteID() {
        return detalleCuentaCorrienteID;
    }

    public void setDetalleCuentaCorrienteID(int detalleCuentaCorrienteID) {
        this.detalleCuentaCorrienteID = detalleCuentaCorrienteID;
    }

    public float getDebe() {
        return debe;
    }

    public void setDebe(float debe) {
        this.debe = debe;
    }

    public float getHaber() {
        return haber;
    }

    public void setHaber(float haber) {
        this.haber = haber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(int cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.detalleCuentaCorrienteID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleCuentasCorrientes other = (DetalleCuentasCorrientes) obj;
        if (this.detalleCuentaCorrienteID != other.detalleCuentaCorrienteID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCuentasCorrientes{" + "detalleCuentaCorrienteID=" + detalleCuentaCorrienteID + ", debe=" + debe + ", haber=" + haber + ", descripcion=" + descripcion + ", fecha=" + fecha + ", cuentaCorrienteID=" + cuentaCorrienteID + ", ventaID=" + ventaID + '}';
    }
    
    
    

    
    
}
