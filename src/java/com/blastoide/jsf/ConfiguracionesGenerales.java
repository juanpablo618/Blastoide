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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "ConfiguracionesGenerales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionesGenerales.findAll", query = "SELECT c FROM ConfiguracionesGenerales c")
    , @NamedQuery(name = "ConfiguracionesGenerales.findByIdConfiguracionsGenerales", query = "SELECT c FROM ConfiguracionesGenerales c WHERE c.idConfiguracionsGenerales = :idConfiguracionsGenerales")
    , @NamedQuery(name = "ConfiguracionesGenerales.findByTelefonoSucursal", query = "SELECT c FROM ConfiguracionesGenerales c WHERE c.telefonoSucursal = :telefonoSucursal")
    , @NamedQuery(name = "ConfiguracionesGenerales.findByCarpetaDePresupuestos", query = "SELECT c FROM ConfiguracionesGenerales c WHERE c.carpetaDePresupuestos = :carpetaDePresupuestos")
    , @NamedQuery(name = "ConfiguracionesGenerales.findByPdfUrl", query = "SELECT c FROM ConfiguracionesGenerales c WHERE c.pdfUrl = :pdfUrl")
    , @NamedQuery(name = "ConfiguracionesGenerales.findByUrlDeLogoMundoLimpieza", query = "SELECT c FROM ConfiguracionesGenerales c WHERE c.urlDeLogoMundoLimpieza = :urlDeLogoMundoLimpieza")})
public class ConfiguracionesGenerales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdConfiguracionsGenerales")
    private Integer idConfiguracionsGenerales;
    @Size(max = 400)
    @Column(name = "telefonoSucursal")
    private String telefonoSucursal;
    @Size(max = 400)
    @Column(name = "carpetaDePresupuestos")
    private String carpetaDePresupuestos;
    @Size(max = 400)
    @Column(name = "pdfUrl")
    private String pdfUrl;
    @Size(max = 500)
    @Column(name = "urlDeLogoMundoLimpieza")
    private String urlDeLogoMundoLimpieza;

    public ConfiguracionesGenerales() {
    }

    public ConfiguracionesGenerales(Integer idConfiguracionsGenerales) {
        this.idConfiguracionsGenerales = idConfiguracionsGenerales;
    }

    public Integer getIdConfiguracionsGenerales() {
        return idConfiguracionsGenerales;
    }

    public void setIdConfiguracionsGenerales(Integer idConfiguracionsGenerales) {
        this.idConfiguracionsGenerales = idConfiguracionsGenerales;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getCarpetaDePresupuestos() {
        return carpetaDePresupuestos;
    }

    public void setCarpetaDePresupuestos(String carpetaDePresupuestos) {
        this.carpetaDePresupuestos = carpetaDePresupuestos;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getUrlDeLogoMundoLimpieza() {
        return urlDeLogoMundoLimpieza;
    }

    public void setUrlDeLogoMundoLimpieza(String urlDeLogoMundoLimpieza) {
        this.urlDeLogoMundoLimpieza = urlDeLogoMundoLimpieza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracionsGenerales != null ? idConfiguracionsGenerales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionesGenerales)) {
            return false;
        }
        ConfiguracionesGenerales other = (ConfiguracionesGenerales) object;
        if ((this.idConfiguracionsGenerales == null && other.idConfiguracionsGenerales != null) || (this.idConfiguracionsGenerales != null && !this.idConfiguracionsGenerales.equals(other.idConfiguracionsGenerales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blastoide.jsf.ConfiguracionesGenerales[ idConfiguracionsGenerales=" + idConfiguracionsGenerales + " ]";
    }
    
}
