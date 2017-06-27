/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author developer
 */
@Entity
@Table(name = "ProductoXDeposito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoXDeposito.findAll", query = "SELECT p FROM ProductoXDeposito p")
    , @NamedQuery(name = "ProductoXDeposito.findByDepositoID", query = "SELECT p FROM ProductoXDeposito p WHERE p.productoXDepositoPK.depositoID = :depositoID")
    , @NamedQuery(name = "ProductoXDeposito.findByProductoID", query = "SELECT p FROM ProductoXDeposito p WHERE p.productoXDepositoPK.productoID = :productoID")
    , @NamedQuery(name = "ProductoXDeposito.findByStockParcial", query = "SELECT p FROM ProductoXDeposito p WHERE p.stockParcial = :stockParcial")})
public class ProductoXDeposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoXDepositoPK productoXDepositoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockParcial")
    private int stockParcial;
    @JoinColumn(name = "depositoID", referencedColumnName = "depositoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depositos depositos;
    @JoinColumn(name = "productoID", referencedColumnName = "productoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public ProductoXDeposito() {
    }

    public ProductoXDeposito(ProductoXDepositoPK productoXDepositoPK) {
        this.productoXDepositoPK = productoXDepositoPK;
    }

    public ProductoXDeposito(ProductoXDepositoPK productoXDepositoPK, int stockParcial) {
        this.productoXDepositoPK = productoXDepositoPK;
        this.stockParcial = stockParcial;
    }

    public ProductoXDeposito(int depositoID, int productoID) {
        this.productoXDepositoPK = new ProductoXDepositoPK(depositoID, productoID);
    }

    public ProductoXDepositoPK getProductoXDepositoPK() {
        return productoXDepositoPK;
    }

    public void setProductoXDepositoPK(ProductoXDepositoPK productoXDepositoPK) {
        this.productoXDepositoPK = productoXDepositoPK;
    }

    public int getStockParcial() {
        return stockParcial;
    }

    public void setStockParcial(int stockParcial) {
        this.stockParcial = stockParcial;
    }

    public Depositos getDepositos() {
        return depositos;
    }

    public void setDepositos(Depositos depositos) {
        this.depositos = depositos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoXDepositoPK != null ? productoXDepositoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXDeposito)) {
            return false;
        }
        ProductoXDeposito other = (ProductoXDeposito) object;
        if ((this.productoXDepositoPK == null && other.productoXDepositoPK != null) || (this.productoXDepositoPK != null && !this.productoXDepositoPK.equals(other.productoXDepositoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + productoXDepositoPK ;
    }
    
}
