/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Domicilios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilios.findAll", query = "SELECT d FROM Domicilios d")
    , @NamedQuery(name = "Domicilios.findByDomiciliosID", query = "SELECT d FROM Domicilios d WHERE d.domiciliosID = :domiciliosID")
    , @NamedQuery(name = "Domicilios.findByCalle", query = "SELECT d FROM Domicilios d WHERE d.calle = :calle")
    , @NamedQuery(name = "Domicilios.findByNumero", query = "SELECT d FROM Domicilios d WHERE d.numero = :numero")
    , @NamedQuery(name = "Domicilios.findByDepartamento", query = "SELECT d FROM Domicilios d WHERE d.departamento = :departamento")
    , @NamedQuery(name = "Domicilios.findByPiso", query = "SELECT d FROM Domicilios d WHERE d.piso = :piso")})
public class Domicilios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DomiciliosID")
    private Integer domiciliosID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @JoinColumn(name = "localidadID", referencedColumnName = "LocalidadID")
    @ManyToOne(optional = false)
    private Localidades localidadID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realdomicilioID")
    private Collection<Proveedores> proveedoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fiscaldomicilioID")
    private Collection<Proveedores> proveedoresCollection1;

    public Domicilios() {
    }

    public Domicilios(Integer domiciliosID) {
        this.domiciliosID = domiciliosID;
    }

    public Domicilios(Integer domiciliosID, String calle, int numero, String departamento, int piso) {
        this.domiciliosID = domiciliosID;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.piso = piso;
    }

    public Integer getDomiciliosID() {
        return domiciliosID;
    }

    public void setDomiciliosID(Integer domiciliosID) {
        this.domiciliosID = domiciliosID;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Localidades getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Localidades localidadID) {
        this.localidadID = localidadID;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection1() {
        return proveedoresCollection1;
    }

    public void setProveedoresCollection1(Collection<Proveedores> proveedoresCollection1) {
        this.proveedoresCollection1 = proveedoresCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domiciliosID != null ? domiciliosID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilios)) {
            return false;
        }
        Domicilios other = (Domicilios) object;
        if ((this.domiciliosID == null && other.domiciliosID != null) || (this.domiciliosID != null && !this.domiciliosID.equals(other.domiciliosID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return calle + numero;
    }
    
}
