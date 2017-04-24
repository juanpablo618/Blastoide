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
@Table(name = "TiposEventualidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposEventualidad.findAll", query = "SELECT t FROM TiposEventualidad t")
    , @NamedQuery(name = "TiposEventualidad.findByTipoEventualidadID", query = "SELECT t FROM TiposEventualidad t WHERE t.tipoEventualidadID = :tipoEventualidadID")
    , @NamedQuery(name = "TiposEventualidad.findByNombre", query = "SELECT t FROM TiposEventualidad t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposEventualidad.findByDescripcion", query = "SELECT t FROM TiposEventualidad t WHERE t.descripcion = :descripcion")})
public class TiposEventualidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoEventualidadID")
    private Integer tipoEventualidadID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEventualidadID")
    private Collection<Eventualidades> eventualidadesCollection;

    public TiposEventualidad() {
    }

    public TiposEventualidad(Integer tipoEventualidadID) {
        this.tipoEventualidadID = tipoEventualidadID;
    }

    public TiposEventualidad(Integer tipoEventualidadID, String nombre, String descripcion) {
        this.tipoEventualidadID = tipoEventualidadID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getTipoEventualidadID() {
        return tipoEventualidadID;
    }

    public void setTipoEventualidadID(Integer tipoEventualidadID) {
        this.tipoEventualidadID = tipoEventualidadID;
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
    public Collection<Eventualidades> getEventualidadesCollection() {
        return eventualidadesCollection;
    }

    public void setEventualidadesCollection(Collection<Eventualidades> eventualidadesCollection) {
        this.eventualidadesCollection = eventualidadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEventualidadID != null ? tipoEventualidadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposEventualidad)) {
            return false;
        }
        TiposEventualidad other = (TiposEventualidad) object;
        if ((this.tipoEventualidadID == null && other.tipoEventualidadID != null) || (this.tipoEventualidadID != null && !this.tipoEventualidadID.equals(other.tipoEventualidadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tipoEventualidad=" + nombre + " ]";
    }
    
}
