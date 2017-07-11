/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.util.List;

/**
 *
 * @author developer
 */
public class Cliente {
    
    private int ClienteID;
    private String nombre;
    private String dni;
    private int tipoCliente;

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return String.format("%s[ClienteID=%d]", getClass().getSimpleName(), getClienteID());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.ClienteID;
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
        final Cliente other = (Cliente) obj;
        if (this.ClienteID != other.ClienteID) {
            return false;
        }
        return true;
    }
    
    
    
    
}
