package com.blastoide.jsf;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Entity
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteBueno.findAll", query = "SELECT c FROM ClienteBueno c")
    , @NamedQuery(name = "ClienteBueno.findByClienteID", query = "SELECT c FROM ClienteBueno c WHERE c.clienteID = :clienteID")
    , @NamedQuery(name = "ClienteBueno.findByNombre", query = "SELECT c FROM ClienteBueno c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClienteBueno.findByDni", query = "SELECT c FROM ClienteBueno c WHERE c.dni = :dni")
    , @NamedQuery(name = "ClienteBueno.findByTipoClienteID", query = "SELECT c FROM ClienteBueno c WHERE c.tipoClienteID = :tipoClienteID")
    , @NamedQuery(name = "ClienteBueno.findByFormaDePagoID", query = "SELECT c FROM ClienteBueno c WHERE c.formaDePagoID = :formaDePagoID")
    , @NamedQuery(name = "ClienteBueno.findByApellido", query = "SELECT c FROM ClienteBueno c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ClienteBueno.findByEmail", query = "SELECT c FROM ClienteBueno c WHERE c.email = :email")
    , @NamedQuery(name = "ClienteBueno.findByCuitCuil", query = "SELECT c FROM ClienteBueno c WHERE c.cuitCuil = :cuitCuil")
    , @NamedQuery(name = "ClienteBueno.findByFechaNacimiento", query = "SELECT c FROM ClienteBueno c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "ClienteBueno.findByNumeroDocumento", query = "SELECT c FROM ClienteBueno c WHERE c.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "ClienteBueno.findByRazonSocial", query = "SELECT c FROM ClienteBueno c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "ClienteBueno.findBySexo", query = "SELECT c FROM ClienteBueno c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "ClienteBueno.findByTelefonoFijo", query = "SELECT c FROM ClienteBueno c WHERE c.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "ClienteBueno.findByTelefonoCelular", query = "SELECT c FROM ClienteBueno c WHERE c.telefonoCelular = :telefonoCelular")
    , @NamedQuery(name = "ClienteBueno.findByFiadoMaximo", query = "SELECT c FROM ClienteBueno c WHERE c.fiadoMaximo = :fiadoMaximo")
    , @NamedQuery(name = "ClienteBueno.findByTipoDocumentoID", query = "SELECT c FROM ClienteBueno c WHERE c.tipoDocumentoID = :tipoDocumentoID")
    , @NamedQuery(name = "ClienteBueno.findByRealdomicilioID", query = "SELECT c FROM ClienteBueno c WHERE c.realdomicilioID = :realdomicilioID")
    , @NamedQuery(name = "ClienteBueno.findByFiscaldomicilioID", query = "SELECT c FROM ClienteBueno c WHERE c.fiscaldomicilioID = :fiscaldomicilioID")
    , @NamedQuery(name = "ClienteBueno.findByCondicionIvaID", query = "SELECT c FROM ClienteBueno c WHERE c.condicionIvaID = :condicionIvaID")
    , @NamedQuery(name = "ClienteBueno.findByDiaDePago", query = "SELECT c FROM ClienteBueno c WHERE c.diaDePago = :diaDePago")
    , @NamedQuery(name = "ClienteBueno.findByCuentaCorrienteID", query = "SELECT c FROM ClienteBueno c WHERE c.cuentaCorrienteID = :cuentaCorrienteID")})
public class ClienteBueno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClienteID")
    private Integer clienteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "dni")
    private String dni;
    @Column(name = "tipoClienteID")
    private Integer tipoClienteID;
    @Column(name = "FormaDePagoID")
    private Integer formaDePagoID;
    @Size(max = 500)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "cuitCuil")
    private String cuitCuil;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;
    @Size(max = 1000)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Size(max = 500)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 250)
    @Column(name = "telefonoFijo")
    private String telefonoFijo;
    @Size(max = 250)
    @Column(name = "telefonoCelular")
    private String telefonoCelular;
    @Column(name = "fiadoMaximo")
    private Integer fiadoMaximo;
    @Column(name = "tipoDocumentoID")
    private Integer tipoDocumentoID;
    @Column(name = "Real_domicilioID")
    private Integer realdomicilioID;
    @Column(name = "Fiscal_domicilioID")
    private Integer fiscaldomicilioID;
    @Column(name = "condicionIvaID")
    private Integer condicionIvaID;
    @Column(name = "diaDePago")
    private String diaDePago;
    @Column(name = "cuentaCorrienteID")
    private Integer cuentaCorrienteID;

    public ClienteBueno() {
    }

    public ClienteBueno(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public ClienteBueno(Integer clienteID, String nombre) {
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getNombreYApellidoYRazonSocial() {
        return "Nombre y Apellido: ".concat(nombre).concat(" ").concat(apellido).concat(" RS: ").concat(razonSocial);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTipoClienteID() {
        return tipoClienteID;
    }

    public void setTipoClienteID(Integer tipoClienteID) {
        this.tipoClienteID = tipoClienteID;
    }

    public Integer getFormaDePagoID() {
        return formaDePagoID;
    }

    public void setFormaDePagoID(Integer formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Integer getFiadoMaximo() {
        return fiadoMaximo;
    }

    public void setFiadoMaximo(Integer fiadoMaximo) {
        this.fiadoMaximo = fiadoMaximo;
    }

    public Integer getTipoDocumentoID() {
        return tipoDocumentoID;
    }

    public void setTipoDocumentoID(Integer tipoDocumentoID) {
        this.tipoDocumentoID = tipoDocumentoID;
    }

    public Integer getRealdomicilioID() {
        return realdomicilioID;
    }

    public void setRealdomicilioID(Integer realdomicilioID) {
        this.realdomicilioID = realdomicilioID;
    }

    public Integer getFiscaldomicilioID() {
        return fiscaldomicilioID;
    }

    public void setFiscaldomicilioID(Integer fiscaldomicilioID) {
        this.fiscaldomicilioID = fiscaldomicilioID;
    }

    public Integer getCondicionIvaID() {
        return condicionIvaID;
    }

    public void setCondicionIvaID(Integer condicionIvaID) {
        this.condicionIvaID = condicionIvaID;
    }

    public String getDiaDePago() {
        return diaDePago;
    }

    public void setDiaDePago(String diaDePago) {
        this.diaDePago = diaDePago;
    }

    public Integer getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(Integer cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteID != null ? clienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteBueno)) {
            return false;
        }
        ClienteBueno other = (ClienteBueno) object;
        if ((this.clienteID == null && other.clienteID != null) || (this.clienteID != null && !this.clienteID.equals(other.clienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre.concat(", ").concat(apellido) ;
    }
    
}