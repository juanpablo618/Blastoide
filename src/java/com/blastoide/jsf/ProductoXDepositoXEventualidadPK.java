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
public class ProductoXDepositoXEventualidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "eventualidadID")
    private int eventualidadID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productoID")
    private int productoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depositoID")
    private int depositoID;

    public ProductoXDepositoXEventualidadPK() {
    }

    public ProductoXDepositoXEventualidadPK(int eventualidadID, int productoID, int depositoID) {
        this.eventualidadID = eventualidadID;
        this.productoID = productoID;
        this.depositoID = depositoID;
    }

    public int getEventualidadID() {
        return eventualidadID;
    }

    public void setEventualidadID(int eventualidadID) {
        this.eventualidadID = eventualidadID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getDepositoID() {
        return depositoID;
    }

    public void setDepositoID(int depositoID) {
        this.depositoID = depositoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventualidadID;
        hash += (int) productoID;
        hash += (int) depositoID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoXDepositoXEventualidadPK)) {
            return false;
        }
        ProductoXDepositoXEventualidadPK other = (ProductoXDepositoXEventualidadPK) object;
        if (this.eventualidadID != other.eventualidadID) {
            return false;
        }
        if (this.productoID != other.productoID) {
            return false;
        }
        if (this.depositoID != other.depositoID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eventualidad=" + eventualidadID + ", producto:" + productoID + ", deposito=" + depositoID + "";
    }
    
}
