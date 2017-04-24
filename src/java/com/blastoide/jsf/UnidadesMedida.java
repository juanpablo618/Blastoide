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
@Table(name = "UnidadesMedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadesMedida.findAll", query = "SELECT u FROM UnidadesMedida u")
    , @NamedQuery(name = "UnidadesMedida.findByUnidadMedidaID", query = "SELECT u FROM UnidadesMedida u WHERE u.unidadMedidaID = :unidadMedidaID")
    , @NamedQuery(name = "UnidadesMedida.findByNombre", query = "SELECT u FROM UnidadesMedida u WHERE u.nombre = :nombre")})
public class UnidadesMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unidadMedidaID")
    private Integer unidadMedidaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedidaID")
    private Collection<Productos> productosCollection;

    public UnidadesMedida() {
    }

    public UnidadesMedida(Integer unidadMedidaID) {
        this.unidadMedidaID = unidadMedidaID;
    }

    public UnidadesMedida(Integer unidadMedidaID, String nombre) {
        this.unidadMedidaID = unidadMedidaID;
        this.nombre = nombre;
    }

    public Integer getUnidadMedidaID() {
        return unidadMedidaID;
    }

    public void setUnidadMedidaID(Integer unidadMedidaID) {
        this.unidadMedidaID = unidadMedidaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (unidadMedidaID != null ? unidadMedidaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedida)) {
            return false;
        }
        UnidadesMedida other = (UnidadesMedida) object;
        if ((this.unidadMedidaID == null && other.unidadMedidaID != null) || (this.unidadMedidaID != null && !this.unidadMedidaID.equals(other.unidadMedidaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unidadMedida=" + nombre + " ]";
    }
    
}
