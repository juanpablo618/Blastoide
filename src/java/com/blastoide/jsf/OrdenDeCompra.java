/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "OrdenDeCompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompra.findAll", query = "SELECT o FROM OrdenDeCompra o")
    , @NamedQuery(name = "OrdenDeCompra.findByOrdenDeCompraID", query = "SELECT o FROM OrdenDeCompra o WHERE o.ordenDeCompraID = :ordenDeCompraID")
    , @NamedQuery(name = "OrdenDeCompra.findByNumeroOC", query = "SELECT o FROM OrdenDeCompra o WHERE o.numeroOC = :numeroOC")
    , @NamedQuery(name = "OrdenDeCompra.findByFechaCreacion", query = "SELECT o FROM OrdenDeCompra o WHERE o.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "OrdenDeCompra.findByFechaEmision", query = "SELECT o FROM OrdenDeCompra o WHERE o.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "OrdenDeCompra.findByFechaCierre", query = "SELECT o FROM OrdenDeCompra o WHERE o.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "OrdenDeCompra.findByTotal", query = "SELECT o FROM OrdenDeCompra o WHERE o.total = :total")
    , @NamedQuery(name = "OrdenDeCompra.findByRestoTotal", query = "SELECT o FROM OrdenDeCompra o WHERE o.restoTotal = :restoTotal")})
public class OrdenDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ordenDeCompraID")
    private Integer ordenDeCompraID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroOC")
    private int numeroOC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "restoTotal")
    private float restoTotal;
    @JoinColumn(name = "estadoID", referencedColumnName = "estadoID")
    @ManyToOne(optional = false)
    private Estado estadoID;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Integer ordenDeCompraID) {
        this.ordenDeCompraID = ordenDeCompraID;
    }

    public OrdenDeCompra(Integer ordenDeCompraID, int numeroOC, Date fechaCreacion, Date fechaEmision, Date fechaCierre, float total, float restoTotal) {
        this.ordenDeCompraID = ordenDeCompraID;
        this.numeroOC = numeroOC;
        this.fechaCreacion = fechaCreacion;
        this.fechaEmision = fechaEmision;
        this.fechaCierre = fechaCierre;
        this.total = total;
        this.restoTotal = restoTotal;
    }

    public Integer getOrdenDeCompraID() {
        return ordenDeCompraID;
    }

    public void setOrdenDeCompraID(Integer ordenDeCompraID) {
        this.ordenDeCompraID = ordenDeCompraID;
    }

    public int getNumeroOC() {
        return numeroOC;
    }

    public void setNumeroOC(int numeroOC) {
        this.numeroOC = numeroOC;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getRestoTotal() {
        return restoTotal;
    }

    public void setRestoTotal(float restoTotal) {
        this.restoTotal = restoTotal;
    }

    public Estado getEstadoID() {
        return estadoID;
    }

    public void setEstadoID(Estado estadoID) {
        this.estadoID = estadoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenDeCompraID != null ? ordenDeCompraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompra)) {
            return false;
        }
        OrdenDeCompra other = (OrdenDeCompra) object;
        if ((this.ordenDeCompraID == null && other.ordenDeCompraID != null) || (this.ordenDeCompraID != null && !this.ordenDeCompraID.equals(other.ordenDeCompraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jpa.OrdenDeCompra[ ordenDeCompraID=" + ordenDeCompraID + " ]";
    }
    
}
