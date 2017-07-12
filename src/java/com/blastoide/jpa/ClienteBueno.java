/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteBueno.findAll", query = "SELECT c FROM ClienteBueno c")
    , @NamedQuery(name = "ClienteBueno.findByClienteID", query = "SELECT c FROM ClienteBueno c WHERE c.clienteID = :clienteID")
    , @NamedQuery(name = "ClienteBueno.findByNombre", query = "SELECT c FROM ClienteBueno c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClienteBueno.findByDni", query = "SELECT c FROM ClienteBueno c WHERE c.dni = :dni")
    , @NamedQuery(name = "ClienteBueno.findByTipoCliente", query = "SELECT c FROM ClienteBueno c WHERE c.tipoCliente = :tipoCliente")})
public class ClienteBueno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClienteID")
    private Integer clienteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "dni")
    private String dni;
    @Column(name = "TipoCliente")
    private Integer tipoCliente;

    public ClienteBueno() {
    }

    public ClienteBueno(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public ClienteBueno(Integer clienteID, String nombre) {
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteID != null ? clienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteBueno)) {
            return false;
        }
        ClienteBueno other = (ClienteBueno) object;
        if ((this.clienteID == null && other.clienteID != null) || (this.clienteID != null && !this.clienteID.equals(other.clienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jpa.ClienteBueno[ clienteID=" + clienteID + " ]";
    }
    
}
