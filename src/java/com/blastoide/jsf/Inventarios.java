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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventarios.findAll", query = "SELECT i FROM Inventarios i")
    , @NamedQuery(name = "Inventarios.findByInventarioID", query = "SELECT i FROM Inventarios i WHERE i.inventarioID = :inventarioID")
    , @NamedQuery(name = "Inventarios.findByCu", query = "SELECT i FROM Inventarios i WHERE i.cu = :cu")
    , @NamedQuery(name = "Inventarios.findByCc", query = "SELECT i FROM Inventarios i WHERE i.cc = :cc")
    , @NamedQuery(name = "Inventarios.findByN", query = "SELECT i FROM Inventarios i WHERE i.n = :n")
    , @NamedQuery(name = "Inventarios.findByQ", query = "SELECT i FROM Inventarios i WHERE i.q = :q")
    , @NamedQuery(name = "Inventarios.findByDMin", query = "SELECT i FROM Inventarios i WHERE i.dMin = :dMin")
    , @NamedQuery(name = "Inventarios.findByDMax", query = "SELECT i FROM Inventarios i WHERE i.dMax = :dMax")
    , @NamedQuery(name = "Inventarios.findByPeriodoTiempo", query = "SELECT i FROM Inventarios i WHERE i.periodoTiempo = :periodoTiempo")
    , @NamedQuery(name = "Inventarios.findByT", query = "SELECT i FROM Inventarios i WHERE i.t = :t")
    , @NamedQuery(name = "Inventarios.findByM", query = "SELECT i FROM Inventarios i WHERE i.m = :m")
    , @NamedQuery(name = "Inventarios.findByS", query = "SELECT i FROM Inventarios i WHERE i.s = :s")
    , @NamedQuery(name = "Inventarios.findByX", query = "SELECT i FROM Inventarios i WHERE i.x = :x")
    , @NamedQuery(name = "Inventarios.findByZ", query = "SELECT i FROM Inventarios i WHERE i.z = :z")})
public class Inventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventarioID")
    private Integer inventarioID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cu")
    private int cu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cc")
    private int cc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n")
    private int n;
    @Basic(optional = false)
    @NotNull
    @Column(name = "q")
    private int q;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dMin")
    private int dMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dMax")
    private int dMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodoTiempo")
    private int periodoTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t")
    private int t;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m")
    private int m;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s")
    private int s;
    @Basic(optional = false)
    @NotNull
    @Column(name = "x")
    private int x;
    @Basic(optional = false)
    @NotNull
    @Column(name = "z")
    private int z;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioID")
    private Collection<Productos> productosCollection;

    public Inventarios() {
    }

    public Inventarios(Integer inventarioID) {
        this.inventarioID = inventarioID;
    }

    public Inventarios(Integer inventarioID, int cu, int cc, int n, int q, int dMin, int dMax, int periodoTiempo, int t, int m, int s, int x, int z) {
        this.inventarioID = inventarioID;
        this.cu = cu;
        this.cc = cc;
        this.n = n;
        this.q = q;
        this.dMin = dMin;
        this.dMax = dMax;
        this.periodoTiempo = periodoTiempo;
        this.t = t;
        this.m = m;
        this.s = s;
        this.x = x;
        this.z = z;
    }

    public Integer getInventarioID() {
        return inventarioID;
    }

    public void setInventarioID(Integer inventarioID) {
        this.inventarioID = inventarioID;
    }

    public int getCu() {
        return cu;
    }

    public void setCu(int cu) {
        this.cu = cu;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getDMin() {
        return dMin;
    }

    public void setDMin(int dMin) {
        this.dMin = dMin;
    }

    public int getDMax() {
        return dMax;
    }

    public void setDMax(int dMax) {
        this.dMax = dMax;
    }

    public int getPeriodoTiempo() {
        return periodoTiempo;
    }

    public void setPeriodoTiempo(int periodoTiempo) {
        this.periodoTiempo = periodoTiempo;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioID != null ? inventarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventarios)) {
            return false;
        }
        Inventarios other = (Inventarios) object;
        if ((this.inventarioID == null && other.inventarioID != null) || (this.inventarioID != null && !this.inventarioID.equals(other.inventarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + inventarioID ;
    }
    
}
