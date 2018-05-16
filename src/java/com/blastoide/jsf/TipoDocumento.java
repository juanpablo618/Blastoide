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
@Table(name = "TipoDocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByTipoDocumentoID", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoID = :tipoDocumentoID")
    , @NamedQuery(name = "TipoDocumento.findByNombre", query = "SELECT t FROM TipoDocumento t WHERE t.nombre = :nombre")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoDocumentoID")
    private Integer tipoDocumentoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumentoID")
    private Collection<Proveedores> proveedoresCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer tipoDocumentoID) {
        this.tipoDocumentoID = tipoDocumentoID;
    }

    public TipoDocumento(Integer tipoDocumentoID, String nombre) {
        this.tipoDocumentoID = tipoDocumentoID;
        this.nombre = nombre;
    }

    public Integer getTipoDocumentoID() {
        return tipoDocumentoID;
    }

    public void setTipoDocumentoID(Integer tipoDocumentoID) {
        this.tipoDocumentoID = tipoDocumentoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumentoID != null ? tipoDocumentoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocumentoID == null && other.tipoDocumentoID != null) || (this.tipoDocumentoID != null && !this.tipoDocumentoID.equals(other.tipoDocumentoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
}