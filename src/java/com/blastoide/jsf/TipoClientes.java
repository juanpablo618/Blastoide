/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

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
@Table(name = "TipoClientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoClientes.findAll", query = "SELECT t FROM TipoClientes t")
    , @NamedQuery(name = "TipoClientes.findByTipoClienteID", query = "SELECT t FROM TipoClientes t WHERE t.tipoClienteID = :tipoCliente")
    , @NamedQuery(name = "TipoClientes.findByDescripcion", query = "SELECT t FROM TipoClientes t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoClientes.findByNombre", query = "SELECT t FROM TipoClientes t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoClientes.findByPorcentajeInteres", query = "SELECT t FROM TipoClientes t WHERE t.porcentajeInteres = :porcentajeInteres")})
public class TipoClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoClienteID")
    private Integer tipoClienteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentajeInteres")
    private Double porcentajeInteres;

    public TipoClientes() {
    }

    public TipoClientes(Integer tipoClienteID) {
        this.tipoClienteID = tipoClienteID;
    }

    public TipoClientes(Integer tipoClienteID, String descripcion, String nombre) {
        this.tipoClienteID = tipoClienteID;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getTipoClienteID() {
        return tipoClienteID;
    }

    public void setTipoClienteID(Integer tipoClienteID) {
        this.tipoClienteID = tipoClienteID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(Double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoClienteID != null ? tipoClienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClientes)) {
            return false;
        }
        TipoClientes other = (TipoClientes) object;
        if ((this.tipoClienteID == null && other.tipoClienteID != null) || (this.tipoClienteID != null && !this.tipoClienteID.equals(other.tipoClienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.TipoClientes[ tipoClienteID=" + tipoClienteID + " ]";
    }
    
}
