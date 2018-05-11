package com.blastoide.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Entity
@Table(name = "CuentaCorriente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaCorriente.findAll", query = "SELECT c FROM CuentaCorriente c")
    , @NamedQuery(name = "CuentaCorriente.findByCuentaCorrienteID", query = "SELECT c FROM CuentaCorriente c WHERE c.cuentaCorrienteID = :cuentaCorrienteID")
    , @NamedQuery(name = "CuentaCorriente.findByFecha", query = "SELECT c FROM CuentaCorriente c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CuentaCorriente.findByConcepto", query = "SELECT c FROM CuentaCorriente c WHERE c.concepto = :concepto")
    , @NamedQuery(name = "CuentaCorriente.findByNroDeComprobante", query = "SELECT c FROM CuentaCorriente c WHERE c.nroDeComprobante = :nroDeComprobante")
    , @NamedQuery(name = "CuentaCorriente.findByDebe", query = "SELECT c FROM CuentaCorriente c WHERE c.debe = :debe")
    , @NamedQuery(name = "CuentaCorriente.findByHaber", query = "SELECT c FROM CuentaCorriente c WHERE c.haber = :haber")
    , @NamedQuery(name = "CuentaCorriente.findByNombreyApellido", query = "SELECT c FROM CuentaCorriente c WHERE c.nombreyApellido = :nombreyApellido")
    , @NamedQuery(name = "CuentaCorriente.findByDireccionReal", query = "SELECT c FROM CuentaCorriente c WHERE c.direccionReal = :direccionReal")
    , @NamedQuery(name = "CuentaCorriente.findByDireccionFacturacion", query = "SELECT c FROM CuentaCorriente c WHERE c.direccionFacturacion = :direccionFacturacion")
    , @NamedQuery(name = "CuentaCorriente.findByNombreDeFantasia", query = "SELECT c FROM CuentaCorriente c WHERE c.nombreDeFantasia = :nombreDeFantasia")
    , @NamedQuery(name = "CuentaCorriente.findByNombreDeFacturacion", query = "SELECT c FROM CuentaCorriente c WHERE c.nombreDeFacturacion = :nombreDeFacturacion")
    , @NamedQuery(name = "CuentaCorriente.findByCodigoPostal", query = "SELECT c FROM CuentaCorriente c WHERE c.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "CuentaCorriente.findByTelefono", query = "SELECT c FROM CuentaCorriente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "CuentaCorriente.findByCredito", query = "SELECT c FROM CuentaCorriente c WHERE c.credito = :credito")
    , @NamedQuery(name = "CuentaCorriente.findByDescuento", query = "SELECT c FROM CuentaCorriente c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "CuentaCorriente.findByFechaDePago", query = "SELECT c FROM CuentaCorriente c WHERE c.fechaDePago = :fechaDePago")
    , @NamedQuery(name = "CuentaCorriente.findByConducta", query = "SELECT c FROM CuentaCorriente c WHERE c.conducta = :conducta")
    , @NamedQuery(name = "CuentaCorriente.findByCuit", query = "SELECT c FROM CuentaCorriente c WHERE c.cuit = :cuit")
    , @NamedQuery(name = "CuentaCorriente.findByObservaciones", query = "SELECT c FROM CuentaCorriente c WHERE c.observaciones = :observaciones")})
public class CuentaCorriente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuentaCorrienteID")
    private Integer cuentaCorrienteID;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 500)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "nroDeComprobante")
    private Integer nroDeComprobante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "debe")
    private Float debe;
    @Column(name = "haber")
    private Float haber;
    @Size(max = 250)
    @Column(name = "nombreyApellido")
    private String nombreyApellido;
    @Size(max = 1000)
    @Column(name = "direccionReal")
    private String direccionReal;
    @Size(max = 1000)
    @Column(name = "direccionFacturacion")
    private String direccionFacturacion;
    
    @Column(name = "nombreDeFantasia")
    private String nombreDeFantasia;
    @Column(name = "nombreDeFacturacion")
    private String nombreDeFacturacion;
    
    @Column(name = "CodigoPostal")
    private Integer codigoPostal;
    @Size(max = 1000)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "credito")
    private Integer credito;
    @Column(name = "descuento")
    private Float descuento;
    @Column(name = "fechaDePago")
    @Temporal(TemporalType.DATE)
    private Date fechaDePago;
    @Size(max = 1000)
    @Column(name = "Conducta")
    private String conducta;
    @Size(max = 50)
    @Column(name = "CUIT")
    private String cuit;
    @Size(max = 1000)
    @Column(name = "observaciones")
    private String observaciones;
    
    @JoinColumn(name = "localidadID", referencedColumnName = "LocalidadID")
    @ManyToOne
    private Localidades localidadID;
    
    private String formaDePagoID;
    
    @JoinColumn(name = "condicionIVAID", referencedColumnName = "condicionIVAID")
    @ManyToOne
    private CondicionIVA condicionIVAID;

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public Integer getCuentaCorrienteID() {
        return cuentaCorrienteID;
    }

    public void setCuentaCorrienteID(Integer cuentaCorrienteID) {
        this.cuentaCorrienteID = cuentaCorrienteID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getNroDeComprobante() {
        return nroDeComprobante;
    }

    public void setNroDeComprobante(Integer nroDeComprobante) {
        this.nroDeComprobante = nroDeComprobante;
    }

    public Float getDebe() {
        return debe;
    }

    public void setDebe(Float debe) {
        this.debe = debe;
    }

    public Float getHaber() {
        return haber;
    }

    public void setHaber(Float haber) {
        this.haber = haber;
    }

    public String getNombreyApellido() {
        return nombreyApellido;
    }

    public void setNombreyApellido(String nombreyApellido) {
        this.nombreyApellido = nombreyApellido;
    }

    public String getDireccionReal() {
        return direccionReal;
    }

    public void setDireccionReal(String direccionReal) {
        this.direccionReal = direccionReal;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public String getNombreDeFantasia() {
        return nombreDeFantasia;
    }

    public void setNombreDeFantasia(String nombreDeFantasia) {
        this.nombreDeFantasia = nombreDeFantasia;
    }

    public String getNombreDeFacturacion() {
        return nombreDeFacturacion;
    }

    public void setNombreDeFacturacion(String nombreDeFacturacion) {
        this.nombreDeFacturacion = nombreDeFacturacion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Localidades getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Localidades localidadID) {
        this.localidadID = localidadID;
    }

    public String getFormaDePagoID() {
        return formaDePagoID;
    }

    public void setFormaDePagoID(String formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
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
        hash += (cuentaCorrienteID != null ? cuentaCorrienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaCorriente)) {
            return false;
        }
        CuentaCorriente other = (CuentaCorriente) object;
        if ((this.cuentaCorrienteID == null && other.cuentaCorrienteID != null) || (this.cuentaCorrienteID != null && !this.cuentaCorrienteID.equals(other.cuentaCorrienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.CuentaCorriente[ cuentaCorrienteID=" + cuentaCorrienteID + " ]";
    }
    
}