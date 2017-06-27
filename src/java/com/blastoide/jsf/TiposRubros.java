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
@Table(name = "TiposRubros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposRubros.findAll", query = "SELECT t FROM TiposRubros t")
    , @NamedQuery(name = "TiposRubros.findByTipoRubroID", query = "SELECT t FROM TiposRubros t WHERE t.tipoRubroID = :tipoRubroID")
    , @NamedQuery(name = "TiposRubros.findByNombre", query = "SELECT t FROM TiposRubros t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposRubros.findByDescripcion", query = "SELECT t FROM TiposRubros t WHERE t.descripcion = :descripcion")})
public class TiposRubros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoRubroID")
    private Integer tipoRubroID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRubroID")
    private Collection<Productos> productosCollection;

    public TiposRubros() {
    }

    public TiposRubros(Integer tipoRubroID) {
        this.tipoRubroID = tipoRubroID;
    }

    public TiposRubros(Integer tipoRubroID, String nombre, String descripcion) {
        this.tipoRubroID = tipoRubroID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getTipoRubroID() {
        return tipoRubroID;
    }

    public void setTipoRubroID(Integer tipoRubroID) {
        this.tipoRubroID = tipoRubroID;
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
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRubroID != null ? tipoRubroID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposRubros)) {
            return false;
        }
        TiposRubros other = (TiposRubros) object;
        if ((this.tipoRubroID == null && other.tipoRubroID != null) || (this.tipoRubroID != null && !this.tipoRubroID.equals(other.tipoRubroID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
