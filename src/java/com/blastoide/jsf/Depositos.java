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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Entity
@Table(name = "Depositos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depositos.findAll", query = "SELECT d FROM Depositos d")
    , @NamedQuery(name = "Depositos.findByDepositoID", query = "SELECT d FROM Depositos d WHERE d.depositoID = :depositoID")
    , @NamedQuery(name = "Depositos.findByNombre", query = "SELECT d FROM Depositos d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Depositos.findByDescripcion", query = "SELECT d FROM Depositos d WHERE d.descripcion = :descripcion")})
public class Depositos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depositoID")
    private Integer depositoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depositos")
    private Collection<ProductoXDeposito> productoXDepositoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depositos")
    private Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;

    public Depositos() {
    }

    public Depositos(Integer depositoID) {
        this.depositoID = depositoID;
    }

    public Depositos(Integer depositoID, String nombre, String descripcion) {
        this.depositoID = depositoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getDepositoID() {
        return depositoID;
    }

    public void setDepositoID(Integer depositoID) {
        this.depositoID = depositoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ProductoXDeposito> getProductoXDepositoCollection() {
        return productoXDepositoCollection;
    }

    public void setProductoXDepositoCollection(Collection<ProductoXDeposito> productoXDepositoCollection) {
        this.productoXDepositoCollection = productoXDepositoCollection;
    }

    @XmlTransient
    public Collection<ProductoXDepositoXEventualidad> getProductoXDepositoXEventualidadCollection() {
        return productoXDepositoXEventualidadCollection;
    }

    public void setProductoXDepositoXEventualidadCollection(Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection) {
        this.productoXDepositoXEventualidadCollection = productoXDepositoXEventualidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depositoID != null ? depositoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depositos)) {
            return false;
        }
        Depositos other = (Depositos) object;
        if ((this.depositoID == null && other.depositoID != null) || (this.depositoID != null && !this.depositoID.equals(other.depositoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
}
