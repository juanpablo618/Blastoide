/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "CuentasCorrientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasCorrientes_1.findAll", query = "SELECT c FROM CuentasCorrientes_1 c")
    , @NamedQuery(name = "CuentasCorrientes_1.findByCuentaCorrienteID", query = "SELECT c FROM CuentasCorrientes_1 c WHERE c.cuentaCorrienteID = :cuentaCorrienteID")
    , @NamedQuery(name = "CuentasCorrientes_1.findByLimite", query = "SELECT c FROM CuentasCorrientes_1 c WHERE c.limite = :limite")})
public class CuentasCorrientes_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuentaCorrienteID")
    private Integer cuentaCorrienteID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite")
    private Float limite;

    public CuentasCorrientes_1() {
    }

    public CuentasCorrientes_1(Integer cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public Integer getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(Integer cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public Float getLimite() {
        return limite;
    }

    public void setLimite(Float limite) {
        this.limite = limite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaCorrienteID != null ? cuentaCorrienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasCorrientes_1)) {
            return false;
        }
        CuentasCorrientes_1 other = (CuentasCorrientes_1) object;
        if ((this.cuentaCorrienteID == null && other.cuentaCorrienteID != null) || (this.cuentaCorrienteID != null && !this.cuentaCorrienteID.equals(other.cuentaCorrienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.CuentasCorrientes_1[ cuentaCorrienteID=" + cuentaCorrienteID + " ]";
    }
    
}
