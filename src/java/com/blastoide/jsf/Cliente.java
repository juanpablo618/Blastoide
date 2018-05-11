package com.blastoide.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class Cliente {

    private int ClienteID;
    private String nombre;
    private String dni;
    private int tipoCliente;
    private int formaDePagoID;
    private String apellido;
    private String sexo;
    private String telefonoFijo;
    private String telefonoCelular;
    private int condicionIva;
    private String razonSocial;
    private String cuitCuil;
    private String diaDePago;
    private String email;
    private int cuentaCorrienteID;
    
    public int getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(int cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public int getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(int condicionIva) {
        this.condicionIva = condicionIva;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }
    
    public String getDiaDePago() {
        return diaDePago;
    }

    public void setDiaDePago(String diaDePago) {
        this.diaDePago = diaDePago;
    }
    
    public int getFormaDePagoID() {
        return formaDePagoID;
    }

    public void setFormaDePagoID(int formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
    }

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