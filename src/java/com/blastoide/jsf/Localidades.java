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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l")
    , @NamedQuery(name = "Localidades.findByLocalidadID", query = "SELECT l FROM Localidades l WHERE l.localidadID = :localidadID")
    , @NamedQuery(name = "Localidades.findByNombre", query = "SELECT l FROM Localidades l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Localidades.findByCodigoPostal", query = "SELECT l FROM Localidades l WHERE l.codigoPostal = :codigoPostal")})
public class Localidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalidadID")
    private Integer localidadID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidadID")
    private Collection<Domicilios> domiciliosCollection;
    @JoinColumn(name = "provinciaID", referencedColumnName = "provinciaID")
    @ManyToOne(optional = false)
    private Provincias provinciaID;

    public Localidades() {
    }

    public Localidades(Integer localidadID) {
        this.localidadID = localidadID;
    }

    public Localidades(Integer localidadID, String nombre, String codigoPostal) {
        this.localidadID = localidadID;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    public Integer getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Integer localidadID) {
        this.localidadID = localidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @XmlTransient
    public Collection<Domicilios> getDomiciliosCollection() {
        return domiciliosCollection;
    }

    public void setDomiciliosCollection(Collection<Domicilios> domiciliosCollection) {
        this.domiciliosCollection = domiciliosCollection;
    }

    public Provincias getProvinciaID() {
        return provinciaID;
    }

    public void setProvinciaID(Provincias provinciaID) {
        this.provinciaID = provinciaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadID != null ? localidadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.localidadID == null && other.localidadID != null) || (this.localidadID != null && !this.localidadID.equals(other.localidadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Localidad=" + nombre + " ]";
    }
    
}
