/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

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
 * @author juan C.
 */
@Entity
@Table(name = "FormaDePago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaDePago.findAll", query = "SELECT f FROM FormaDePago f")
    , @NamedQuery(name = "FormaDePago.findByFormaDePagoID", query = "SELECT f FROM FormaDePago f WHERE f.formaDePagoID = :formaDePagoID")
    , @NamedQuery(name = "FormaDePago.findByDescripcion", query = "SELECT f FROM FormaDePago f WHERE f.descripcion = :descripcion")
    
    , @NamedQuery(name = "FormaDePago.findByNombre", query = "SELECT f FROM FormaDePago f WHERE f.nombre = :nombre")})
    
public class FormaDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formaDePagoID")
    private Integer formaDePagoID;
    @Size(max = 2500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "porcentaje")
    private Double porcentaje;
    

    public FormaDePago() {
    }

    public FormaDePago(Integer formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
    }

    public Integer getFormaDePagoID() {
        return formaDePagoID;
    }

    
    public void setFormaDePagoID(Integer formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formaDePagoID != null ? formaDePagoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaDePago)) {
            return false;
        }
        FormaDePago other = (FormaDePago) object;
        if ((this.formaDePagoID == null && other.formaDePagoID != null) || (this.formaDePagoID != null && !this.formaDePagoID.equals(other.formaDePagoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
