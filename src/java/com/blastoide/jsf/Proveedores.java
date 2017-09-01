/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByProveedorID", query = "SELECT p FROM Proveedores p WHERE p.proveedorID = :proveedorID")
    , @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedores.findByApellido", query = "SELECT p FROM Proveedores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Proveedores.findByCuit", query = "SELECT p FROM Proveedores p WHERE p.cuit = :cuit")
    , @NamedQuery(name = "Proveedores.findByEmail", query = "SELECT p FROM Proveedores p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedores.findByFechaNacimiento", query = "SELECT p FROM Proveedores p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Proveedores.findByNroDocumento", query = "SELECT p FROM Proveedores p WHERE p.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Proveedores.findByRazonSocial", query = "SELECT p FROM Proveedores p WHERE p.razonSocial = :razonSocial")
    , @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedores.findByCelular", query = "SELECT p FROM Proveedores p WHERE p.celular = :celular")
    , @NamedQuery(name = "Proveedores.findBySexo", query = "SELECT p FROM Proveedores p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Proveedores.findByWeb", query = "SELECT p FROM Proveedores p WHERE p.web = :web")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProveedorID")
    private Integer proveedorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuit")
    private String cuit;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroDocumento")
    private long nroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "web")
    private String web;
    @JoinColumn(name = "tipoDocumentoID", referencedColumnName = "tipoDocumentoID")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumentoID;
    @JoinColumn(name = "Real_domicilioID", referencedColumnName = "DomiciliosID")
    @ManyToOne(optional = false)
    private Domicilios realdomicilioID;
    @JoinColumn(name = "Fiscal_domicilioID", referencedColumnName = "DomiciliosID")
    @ManyToOne(optional = false)
    private Domicilios fiscaldomicilioID;
    @JoinColumn(name = "condicionIVAID", referencedColumnName = "condicionIVAID")
    @ManyToOne(optional = false)
    private CondicionIVA condicionIVAID;
    
    public Proveedores() {
    }

    public Proveedores(Integer proveedorID) {
        this.proveedorID = proveedorID;
    }

    public Proveedores(Integer proveedorID, String nombre, String apellido, String cuit, String email, Date fechaNacimiento, long nroDocumento, String razonSocial, String telefono, String celular, String sexo, String web) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuit = cuit;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.celular = celular;
        this.sexo = sexo;
        this.web = web;
    }

    public Integer getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(Integer proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public TipoDocumento getTipoDocumentoID() {
        return tipoDocumentoID;
    }

    public void setTipoDocumentoID(TipoDocumento tipoDocumentoID) {
        this.tipoDocumentoID = tipoDocumentoID;
    }

    public Domicilios getRealdomicilioID() {
        return realdomicilioID;
    }

    public void setRealdomicilioID(Domicilios realdomicilioID) {
        this.realdomicilioID = realdomicilioID;
    }

    public Domicilios getFiscaldomicilioID() {
        return fiscaldomicilioID;
    }

    public void setFiscaldomicilioID(Domicilios fiscaldomicilioID) {
        this.fiscaldomicilioID = fiscaldomicilioID;
    }

    public CondicionIVA getCondicionIVAID() {
        return condicionIVAID;
    }

    public void setCondicionIVAID(CondicionIVA condicionIVAID) {
        this.condicionIVAID = condicionIVAID;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorID != null ? proveedorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.proveedorID == null && other.proveedorID != null) || (this.proveedorID != null && !this.proveedorID.equals(other.proveedorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
