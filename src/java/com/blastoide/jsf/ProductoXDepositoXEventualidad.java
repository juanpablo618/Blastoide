package com.blastoide.jsf;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Entity
@Table(name = "ProductoXDepositoXEventualidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoXDepositoXEventualidad.findAll", query = "SELECT p FROM ProductoXDepositoXEventualidad p")
    , @NamedQuery(name = "ProductoXDepositoXEventualidad.findByEventualidadID", query = "SELECT p FROM ProductoXDepositoXEventualidad p WHERE p.productoXDepositoXEventualidadPK.eventualidadID = :eventualidadID")
    , @NamedQuery(name = "ProductoXDepositoXEventualidad.findByProductoID", query = "SELECT p FROM ProductoXDepositoXEventualidad p WHERE p.productoXDepositoXEventualidadPK.productoID = :productoID")
    , @NamedQuery(name = "ProductoXDepositoXEventualidad.findByDepositoID", query = "SELECT p FROM ProductoXDepositoXEventualidad p WHERE p.productoXDepositoXEventualidadPK.depositoID = :depositoID")
    , @NamedQuery(name = "ProductoXDepositoXEventualidad.findByStockPrevio", query = "SELECT p FROM ProductoXDepositoXEventualidad p WHERE p.stockPrevio = :stockPrevio")
    , @NamedQuery(name = "ProductoXDepositoXEventualidad.findByStockPosterior", query = "SELECT p FROM ProductoXDepositoXEventualidad p WHERE p.stockPosterior = :stockPosterior")})
public class ProductoXDepositoXEventualidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoXDepositoXEventualidadPK productoXDepositoXEventualidadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockPrevio")
    private int stockPrevio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockPosterior")
    private int stockPosterior;
    @JoinColumn(name = "productoID", referencedColumnName = "productoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "eventualidadID", referencedColumnName = "eventualidadID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Eventualidades eventualidades;
    @JoinColumn(name = "depositoID", referencedColumnName = "depositoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depositos depositos;

    public ProductoXDepositoXEventualidad() {
    }

    public ProductoXDepositoXEventualidad(ProductoXDepositoXEventualidadPK productoXDepositoXEventualidadPK) {
        this.productoXDepositoXEventualidadPK = productoXDepositoXEventualidadPK;
    }

    public ProductoXDepositoXEventualidad(ProductoXDepositoXEventualidadPK productoXDepositoXEventualidadPK, int stockPrevio, int stockPosterior) {
        this.productoXDepositoXEventualidadPK = productoXDepositoXEventualidadPK;
        this.stockPrevio = stockPrevio;
        this.stockPosterior = stockPosterior;
    }

    public ProductoXDepositoXEventualidad(int eventualidadID, int productoID, int depositoID) {
        this.productoXDepositoXEventualidadPK = new ProductoXDepositoXEventualidadPK(eventualidadID, productoID, depositoID);
    }

    public ProductoXDepositoXEventualidadPK getProductoXDepositoXEventualidadPK() {
        return productoXDepositoXEventualidadPK;
    }

    public void setProductoXDepositoXEventualidadPK(ProductoXDepositoXEventualidadPK productoXDepositoXEventualidadPK) {
        this.productoXDepositoXEventualidadPK = productoXDepositoXEventualidadPK;
    }

    public int getStockPrevio() {
        return stockPrevio;
    }

    public void setStockPrevio(int stockPrevio) {
        this.stockPrevio = stockPrevio;
    }

    public int getStockPosterior() {
        return stockPosterior;
    }

    public void setStockPosterior(int stockPosterior) {
        this.stockPosterior = stockPosterior;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Eventualidades getEventualidades() {
        return eventualidades;
    }

    public void setEventualidades(Eventualidades eventualidades) {
        this.eventualidades = eventualidades;
    }

    public Depositos getDepositos() {
        return depositos;
    }

    public void setDepositos(Depositos depositos) {
        this.depositos = depositos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoXDepositoXEventualidadPK != null ? productoXDepositoXEventualidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXDepositoXEventualidad)) {
            return false;
        }
        ProductoXDepositoXEventualidad other = (ProductoXDepositoXEventualidad) object;
        if ((this.productoXDepositoXEventualidadPK == null && other.productoXDepositoXEventualidadPK != null) || (this.productoXDepositoXEventualidadPK != null && !this.productoXDepositoXEventualidadPK.equals(other.productoXDepositoXEventualidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + productoXDepositoXEventualidadPK + "";
    }
    
}