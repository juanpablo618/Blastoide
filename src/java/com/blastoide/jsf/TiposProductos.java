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
@Table(name = "TiposProductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposProductos.findAll", query = "SELECT t FROM TiposProductos t")
    , @NamedQuery(name = "TiposProductos.findByTipoProductoID", query = "SELECT t FROM TiposProductos t WHERE t.tipoProductoID = :tipoProductoID")
    , @NamedQuery(name = "TiposProductos.findByNombre", query = "SELECT t FROM TiposProductos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposProductos.findByDescripcion", query = "SELECT t FROM TiposProductos t WHERE t.descripcion = :descripcion")})
public class TiposProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoProductoID")
    private Integer tipoProductoID;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProductoID")
    private Collection<Productos> productosCollection;

    public TiposProductos() {
    }

    public TiposProductos(Integer tipoProductoID) {
        this.tipoProductoID = tipoProductoID;
    }

    public TiposProductos(Integer tipoProductoID, String nombre, String descripcion) {
        this.tipoProductoID = tipoProductoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getTipoProductoID() {
        return tipoProductoID;
    }

    public void setTipoProductoID(Integer tipoProductoID) {
        this.tipoProductoID = tipoProductoID;
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
        hash += (tipoProductoID != null ? tipoProductoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposProductos)) {
            return false;
        }
        TiposProductos other = (TiposProductos) object;
        if ((this.tipoProductoID == null && other.tipoProductoID != null) || (this.tipoProductoID != null && !this.tipoProductoID.equals(other.tipoProductoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
