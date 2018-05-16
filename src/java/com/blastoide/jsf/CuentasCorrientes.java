package com.blastoide.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class CuentasCorrientes {
    
    private int cuentaCorrienteID;
    private float limite;

    public int getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(int cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.cuentaCorrienteID;
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
        final CuentasCorrientes other = (CuentasCorrientes) obj;
        if (this.cuentaCorrienteID != other.cuentaCorrienteID) {
            return false;
        }
        return true;
    }
}