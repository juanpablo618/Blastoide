/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "condicionIVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionIVA.findAll", query = "SELECT c FROM CondicionIVA c")
    , @NamedQuery(name = "CondicionIVA.findByCondicionIVAID", query = "SELECT c FROM CondicionIVA c WHERE c.condicionIVAID = :condicionIVAID")
    , @NamedQuery(name = "CondicionIVA.findByNombre", query = "SELECT c FROM CondicionIVA c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CondicionIVA.findByDescripcion", query = "SELECT c FROM CondicionIVA c WHERE c.descripcion = :descripcion")})
public class CondicionIVA implements Serializable {

    @OneToMany(mappedBy = "condicionIVAID")
    private Collection<CuentaCorriente> cuentaCorrienteCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "condicionIVAID")
    private Integer condicionIVAID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condicionIVAID")
    private Collection<Proveedores> proveedoresCollection;

    public CondicionIVA() {
    }

    public CondicionIVA(Integer condicionIVAID) {
        this.condicionIVAID = condicionIVAID;
    }

    public CondicionIVA(Integer condicionIVAID, String nombre, String descripcion) {
        this.condicionIVAID = condicionIVAID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getCondicionIVAID() {
        return condicionIVAID;
    }

    public void setCondicionIVAID(Integer condicionIVAID) {
        this.condicionIVAID = condicionIVAID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condicionIVAID != null ? condicionIVAID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionIVA)) {
            return false;
        }
        CondicionIVA other = (CondicionIVA) object;
        if ((this.condicionIVAID == null && other.condicionIVAID != null) || (this.condicionIVAID != null && !this.condicionIVAID.equals(other.condicionIVAID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @XmlTransient
    public Collection<CuentaCorriente> getCuentaCorrienteCollection() {
        return cuentaCorrienteCollection;
    }

    public void setCuentaCorrienteCollection(Collection<CuentaCorriente> cuentaCorrienteCollection) {
        this.cuentaCorrienteCollection = cuentaCorrienteCollection;
    }
    
}
