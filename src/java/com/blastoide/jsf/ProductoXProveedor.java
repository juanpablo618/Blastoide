package com.blastoide.jsf;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ProductoXProveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoXProveedor.findAll", query = "SELECT p FROM ProductoXProveedor p")
    , @NamedQuery(name = "ProductoXProveedor.findByProductoXProveedorID", query = "SELECT p FROM ProductoXProveedor p WHERE p.productoXProveedorID = :productoXProveedorID")
    , @NamedQuery(name = "ProductoXProveedor.findByProveedorID", query = "SELECT p FROM ProductoXProveedor p WHERE p.proveedorID = :proveedorID")
    , @NamedQuery(name = "ProductoXProveedor.findByProductoID", query = "SELECT p FROM ProductoXProveedor p WHERE p.productoID = :productoID")
    , @NamedQuery(name = "ProductoXProveedor.findByPrecioCosto", query = "SELECT p FROM ProductoXProveedor p WHERE p.precioCosto = :precioCosto")})
public class ProductoXProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductoXProveedorID")
    private Integer productoXProveedorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProveedorID")
    private int proveedorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductoID")
    private int productoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioCosto")
    private int precioCosto;

    public ProductoXProveedor() {
    }

    public ProductoXProveedor(Integer productoXProveedorID) {
        this.productoXProveedorID = productoXProveedorID;
    }

    public ProductoXProveedor(Integer productoXProveedorID, int proveedorID, int productoID, int precioCosto) {
        this.productoXProveedorID = productoXProveedorID;
        this.proveedorID = proveedorID;
        this.productoID = productoID;
        this.precioCosto = precioCosto;
    }

    public Integer getProductoXProveedorID() {
        return productoXProveedorID;
    }

    public void setProductoXProveedorID(Integer productoXProveedorID) {
        this.productoXProveedorID = productoXProveedorID;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoXProveedorID != null ? productoXProveedorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXProveedor)) {
            return false;
        }
        ProductoXProveedor other = (ProductoXProveedor) object;
        if ((this.productoXProveedorID == null && other.productoXProveedorID != null) || (this.productoXProveedorID != null && !this.productoXProveedorID.equals(other.productoXProveedorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.ProductoXProveedor[ productoXProveedorID=" + productoXProveedorID + " ]";
    }
    
}