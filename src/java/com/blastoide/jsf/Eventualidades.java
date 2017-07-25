/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Eventualidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventualidades.findAll", query = "SELECT e FROM Eventualidades e")
    , @NamedQuery(name = "Eventualidades.findByEventualidadID", query = "SELECT e FROM Eventualidades e WHERE e.eventualidadID = :eventualidadID")
    , @NamedQuery(name = "Eventualidades.findByFecha", query = "SELECT e FROM Eventualidades e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Eventualidades.findByObservaciones", query = "SELECT e FROM Eventualidades e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Eventualidades.findByTotalPerdida", query = "SELECT e FROM Eventualidades e WHERE e.totalPerdida = :totalPerdida")})
public class Eventualidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventualidadID")
    private Integer eventualidadID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPerdida")
    private int totalPerdida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventualidades")
    private Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;
    @JoinColumn(name = "tipoEventualidadID", referencedColumnName = "tipoEventualidadID")
    @ManyToOne(optional = false)
    private TiposEventualidad tipoEventualidadID;

    public Eventualidades() {
    }

    public Eventualidades(Integer eventualidadID) {
        this.eventualidadID = eventualidadID;
    }

    public Eventualidades(Integer eventualidadID, Date fecha, String observaciones, int totalPerdida) {
        this.eventualidadID = eventualidadID;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.totalPerdida = totalPerdida;
    }

    public Integer getEventualidadID() {
        return eventualidadID;
    }

    public void setEventualidadID(Integer eventualidadID) {
        this.eventualidadID = eventualidadID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getTotalPerdida() {
        return totalPerdida;
    }

    public void setTotalPerdida(int totalPerdida) {
        this.totalPerdida = totalPerdida;
    }

    @XmlTransient
    public Collection<ProductoXDepositoXEventualidad> getProductoXDepositoXEventualidadCollection() {
        return productoXDepositoXEventualidadCollection;
    }

    public void setProductoXDepositoXEventualidadCollection(Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection) {
        this.productoXDepositoXEventualidadCollection = productoXDepositoXEventualidadCollection;
    }

    public TiposEventualidad getTipoEventualidadID() {
        return tipoEventualidadID;
    }

    public void setTipoEventualidadID(TiposEventualidad tipoEventualidadID) {
        this.tipoEventualidadID = tipoEventualidadID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventualidadID != null ? eventualidadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventualidades)) {
            return false;
        }
        Eventualidades other = (Eventualidades) object;
        if ((this.eventualidadID == null && other.eventualidadID != null) || (this.eventualidadID != null && !this.eventualidadID.equals(other.eventualidadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  observaciones ;
    }
    
}
