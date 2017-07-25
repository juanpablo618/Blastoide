/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author developer
 */
@Embeddable
public class ProductoXDepositoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "depositoID")
    private int depositoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productoID")
    private int productoID;

    public ProductoXDepositoPK() {
    }

    public ProductoXDepositoPK(int depositoID, int productoID) {
        this.depositoID = depositoID;
        this.productoID = productoID;
    }

    public int getDepositoID() {
        return depositoID;
    }

    public void setDepositoID(int depositoID) {
        this.depositoID = depositoID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) depositoID;
        hash += (int) productoID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXDepositoPK)) {
            return false;
        }
        ProductoXDepositoPK other = (ProductoXDepositoPK) object;
        if (this.depositoID != other.depositoID) {
            return false;
        }
        if (this.productoID != other.productoID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "deposito=" + depositoID + ", producto:" + productoID + " ";
    }
    
}
