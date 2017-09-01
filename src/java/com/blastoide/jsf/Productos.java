/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import com.blastoide.jsf.TiposProductos;
import com.blastoide.jsf.TiposRubros;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByProductoID", query = "SELECT p FROM Productos p WHERE p.productoID = :productoID")
    , @NamedQuery(name = "Productos.findByCodigo", query = "SELECT p FROM Productos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Productos.findByMarca", query = "SELECT p FROM Productos p WHERE p.marca = :marca")
    , @NamedQuery(name = "Productos.findByFragancia", query = "SELECT p FROM Productos p WHERE p.fragancia = :fragancia")
    , @NamedQuery(name = "Productos.findByCaracteristica", query = "SELECT p FROM Productos p WHERE p.caracteristica = :caracteristica")
    , @NamedQuery(name = "Productos.findByMedida", query = "SELECT p FROM Productos p WHERE p.medida = :medida")
    , @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Productos.findByUltimaActualizacionStock", query = "SELECT p FROM Productos p WHERE p.ultimaActualizacionStock = :ultimaActualizacionStock")
    , @NamedQuery(name = "Productos.findByInventarioID", query = "SELECT p FROM Productos p WHERE p.inventarioID = :inventarioID")
    , @NamedQuery(name = "Productos.findByPrecioFinalAFacturar", query = "SELECT p FROM Productos p WHERE p.precioFinalAFacturar = :precioFinalAFacturar")
    , @NamedQuery(name = "Productos.findByStockactual", query = "SELECT p FROM Productos p WHERE p.stockactual = :stockactual")
    , @NamedQuery(name = "Productos.findByStockMinimo", query = "SELECT p FROM Productos p WHERE p.stockMinimo = :stockMinimo")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productoID")
    private Integer productoID;
    @Size(max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "fragancia")
    private String fragancia;
    @Size(max = 200)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Size(max = 100)
    @Column(name = "medida")
    private String medida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioVenta")
    private double precioVenta;
    @Column(name = "ultimaActualizacionStock")
    @Temporal(TemporalType.DATE)
    private Date ultimaActualizacionStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventarioID")
    private int inventarioID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioFinalAFacturar")
    private Double precioFinalAFacturar;
    @Column(name = "stockactual")
    private Integer stockactual;
    @Column(name = "stockMinimo")
    private Integer stockMinimo;
    @JoinColumn(name = "tipoProductoID", referencedColumnName = "tipoProductoID")
    @ManyToOne
    private TiposProductos tipoProductoID;
    @JoinColumn(name = "tipoRubroID", referencedColumnName = "tipoRubroID")
    @ManyToOne
    private TiposRubros tipoRubroID;

    public Productos() {
    }

    public Productos(Integer productoID) {
        this.productoID = productoID;
    }

    public Productos(Integer productoID, double precioVenta, int inventarioID) {
        this.productoID = productoID;
        this.precioVenta = precioVenta;
        this.inventarioID = inventarioID;
    }

    public Integer getProductoID() {
        return productoID;
    }

    public void setProductoID(Integer productoID) {
        this.productoID = productoID;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFragancia() {
        return fragancia;
    }

    public void setFragancia(String fragancia) {
        this.fragancia = fragancia;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getUltimaActualizacionStock() {
        return ultimaActualizacionStock;
    }

    public void setUltimaActualizacionStock(Date ultimaActualizacionStock) {
        this.ultimaActualizacionStock = ultimaActualizacionStock;
    }

    public int getInventarioID() {
        return inventarioID;
    }

    public void setInventarioID(int inventarioID) {
        this.inventarioID = inventarioID;
    }

    public Double getPrecioFinalAFacturar() {
        return precioFinalAFacturar;
    }

    public void setPrecioFinalAFacturar(Double precioFinalAFacturar) {
        this.precioFinalAFacturar = precioFinalAFacturar;
    }

    public Integer getStockactual() {
        return stockactual;
    }

    public void setStockactual(Integer stockactual) {
        this.stockactual = stockactual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public TiposProductos getTipoProductoID() {
        return tipoProductoID;
    }

    public void setTipoProductoID(TiposProductos tipoProductoID) {
        this.tipoProductoID = tipoProductoID;
    }

  
    public TiposRubros getTipoRubroID() {
        return tipoRubroID;
    }

    public void setTipoRubroID(TiposRubros tipoRubroID) {
        this.tipoRubroID = tipoRubroID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoID != null ? productoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productoID == null && other.productoID != null) || (this.productoID != null && !this.productoID.equals(other.productoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
