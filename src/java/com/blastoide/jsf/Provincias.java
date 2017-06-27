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
@Table(name = "Provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")
    , @NamedQuery(name = "Provincias.findByProvinciaID", query = "SELECT p FROM Provincias p WHERE p.provinciaID = :provinciaID")
    , @NamedQuery(name = "Provincias.findByNombre", query = "SELECT p FROM Provincias p WHERE p.nombre = :nombre")})
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provinciaID")
    private Integer provinciaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinciaID")
    private Collection<Localidades> localidadesCollection;

    public Provincias() {
    }

    public Provincias(Integer provinciaID) {
        this.provinciaID = provinciaID;
    }

    public Provincias(Integer provinciaID, String nombre) {
        this.provinciaID = provinciaID;
        this.nombre = nombre;
    }

    public Integer getProvinciaID() {
        return provinciaID;
    }

    public void setProvinciaID(Integer provinciaID) {
        this.provinciaID = provinciaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Localidades> getLocalidadesCollection() {
        return localidadesCollection;
    }

    public void setLocalidadesCollection(Collection<Localidades> localidadesCollection) {
        this.localidadesCollection = localidadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaID != null ? provinciaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.provinciaID == null && other.provinciaID != null) || (this.provinciaID != null && !this.provinciaID.equals(other.provinciaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
