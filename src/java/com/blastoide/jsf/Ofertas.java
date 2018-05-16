package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Entity
@Table(name = "Ofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o")
    , @NamedQuery(name = "Ofertas.findByOfertaID", query = "SELECT o FROM Ofertas o WHERE o.ofertaID = :ofertaID")
    , @NamedQuery(name = "Ofertas.findByTitulo", query = "SELECT o FROM Ofertas o WHERE o.titulo = :titulo")
    , @NamedQuery(name = "Ofertas.findByDescripcion", query = "SELECT o FROM Ofertas o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Ofertas.findByFechaDesde", query = "SELECT o FROM Ofertas o WHERE o.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "Ofertas.findByFechaHasta", query = "SELECT o FROM Ofertas o WHERE o.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "Ofertas.findByPrecioDeOferta", query = "SELECT o FROM Ofertas o WHERE o.precioDeOferta = :precioDeOferta")
    , @NamedQuery(name = "Ofertas.findByCantidad", query = "SELECT o FROM Ofertas o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ofertas.findByDescuentoPesos", query = "SELECT o FROM Ofertas o WHERE o.descuentoPesos = :descuentoPesos")
    , @NamedQuery(name = "Ofertas.findByDescuentoPorcentaje", query = "SELECT o FROM Ofertas o WHERE o.descuentoPorcentaje = :descuentoPorcentaje")})
public class Ofertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ofertaID")
    private Integer ofertaID;
    @Size(max = 500)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDesde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioDeOferta")
    private float precioDeOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuentoPesos")
    private Double descuentoPesos;
    @Column(name = "descuentoPorcentaje")
    private Double descuentoPorcentaje;

    public Ofertas() {
    }

    public Ofertas(Integer ofertaID) {
        this.ofertaID = ofertaID;
    }

    public Ofertas(Integer ofertaID, Date fechaDesde, Date fechaHasta, float precioDeOferta, int cantidad) {
        this.ofertaID = ofertaID;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precioDeOferta = precioDeOferta;
        this.cantidad = cantidad;
    }

    public Integer getOfertaID() {
        return ofertaID;
    }

    public void setOfertaID(Integer ofertaID) {
        this.ofertaID = ofertaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public float getPrecioDeOferta() {
        return precioDeOferta;
    }

    public void setPrecioDeOferta(float precioDeOferta) {
        this.precioDeOferta = precioDeOferta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuentoPesos() {
        return descuentoPesos;
    }

    public void setDescuentoPesos(Double descuentoPesos) {
        this.descuentoPesos = descuentoPesos;
    }

    public Double getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(Double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertaID != null ? ofertaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.ofertaID == null && other.ofertaID != null) || (this.ofertaID != null && !this.ofertaID.equals(other.ofertaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jpa.Ofertas[ ofertaID=" + ofertaID + " ]";
    }
    
}