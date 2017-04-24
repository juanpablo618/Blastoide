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
@Table(name = "ProductoXProveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoXProveedor.findAll", query = "SELECT p FROM ProductoXProveedor p")
    , @NamedQuery(name = "ProductoXProveedor.findByProveedorID", query = "SELECT p FROM ProductoXProveedor p WHERE p.productoXProveedorPK.proveedorID = :proveedorID")
    , @NamedQuery(name = "ProductoXProveedor.findByProductoID", query = "SELECT p FROM ProductoXProveedor p WHERE p.productoXProveedorPK.productoID = :productoID")
    , @NamedQuery(name = "ProductoXProveedor.findByPrecioCosto", query = "SELECT p FROM ProductoXProveedor p WHERE p.precioCosto = :precioCosto")})
public class ProductoXProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoXProveedorPK productoXProveedorPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioCosto")
    private int precioCosto;
    @JoinColumn(name = "ProductoID", referencedColumnName = "productoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "ProveedorID", referencedColumnName = "ProveedorID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedores proveedores;

    public ProductoXProveedor() {
    }

    public ProductoXProveedor(ProductoXProveedorPK productoXProveedorPK) {
        this.productoXProveedorPK = productoXProveedorPK;
    }

    public ProductoXProveedor(ProductoXProveedorPK productoXProveedorPK, int precioCosto) {
        this.productoXProveedorPK = productoXProveedorPK;
        this.precioCosto = precioCosto;
    }

    public ProductoXProveedor(int proveedorID, int productoID) {
        this.productoXProveedorPK = new ProductoXProveedorPK(proveedorID, productoID);
    }

    public ProductoXProveedorPK getProductoXProveedorPK() {
        return productoXProveedorPK;
    }

    public void setProductoXProveedorPK(ProductoXProveedorPK productoXProveedorPK) {
        this.productoXProveedorPK = productoXProveedorPK;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoXProveedorPK != null ? productoXProveedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXProveedor)) {
            return false;
        }
        ProductoXProveedor other = (ProductoXProveedor) object;
        if ((this.productoXProveedorPK == null && other.productoXProveedorPK != null) || (this.productoXProveedorPK != null && !this.productoXProveedorPK.equals(other.productoXProveedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.ProductoXProveedor[ productoXProveedorPK=" + productoXProveedorPK + " ]";
    }
    
}
