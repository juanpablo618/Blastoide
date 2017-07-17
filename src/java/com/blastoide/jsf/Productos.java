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
    , @NamedQuery(name = "Productos.findByUltimaActualizacionStock", query = "SELECT p FROM Productos p WHERE p.ultimaActualizacionStock = :ultimaActualizacionStock")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productoID")
    private Integer productoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fragancia")
    private String fragancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "medida")
    private String medida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioVenta")
    private double precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultimaActualizacionStock")
    @Temporal(TemporalType.DATE)
    private Date ultimaActualizacionStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<ProductoXProveedor> productoXProveedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<ProductoXDeposito> productoXDepositoCollection;
    @JoinColumn(name = "tipoProductoID", referencedColumnName = "tipoProductoID")
    @ManyToOne(optional = false)
    private TiposProductos tipoProductoID;
    @JoinColumn(name = "inventarioID", referencedColumnName = "inventarioID")
    @ManyToOne(optional = false)
    private Inventarios inventarioID;
    @JoinColumn(name = "unidadMedidaID", referencedColumnName = "unidadMedidaID")
    @ManyToOne(optional = false)
    private UnidadesMedida unidadMedidaID;
    @JoinColumn(name = "tipoRubroID", referencedColumnName = "tipoRubroID")
    @ManyToOne(optional = false)
    private TiposRubros tipoRubroID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoID")
    private Collection<Imagenes> imagenesCollection;

    
    private double precioFinalAFacturar;
    
    
    public Productos() {
    }

    public Productos(Integer productoID) {
        this.productoID = productoID;
    }

    public Productos(Integer productoID, String codigo, String nombre, String marca, String fragancia, String caracteristica, String medida, double precioVenta, Date ultimaActualizacionStock, double  precioFinalAFacturar) {
        this.productoID = productoID;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.fragancia = fragancia;
        this.caracteristica = caracteristica;
        this.medida = medida;
        this.precioVenta = precioVenta;
        this.ultimaActualizacionStock = ultimaActualizacionStock;
        this.precioFinalAFacturar = precioFinalAFacturar;
    }

    public double getPrecioFinalAFacturar() {
        return precioFinalAFacturar;
    }

    public void setPrecioFinalAFacturar(double precioFinalAFacturar) {
        this.precioFinalAFacturar = precioFinalAFacturar;
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

    @XmlTransient
    public Collection<ProductoXProveedor> getProductoXProveedorCollection() {
        return productoXProveedorCollection;
    }

    public void setProductoXProveedorCollection(Collection<ProductoXProveedor> productoXProveedorCollection) {
        this.productoXProveedorCollection = productoXProveedorCollection;
    }

    @XmlTransient
    public Collection<ProductoXDeposito> getProductoXDepositoCollection() {
        return productoXDepositoCollection;
    }

    public void setProductoXDepositoCollection(Collection<ProductoXDeposito> productoXDepositoCollection) {
        this.productoXDepositoCollection = productoXDepositoCollection;
    }

    public TiposProductos getTipoProductoID() {
        return tipoProductoID;
    }

    public void setTipoProductoID(TiposProductos tipoProductoID) {
        this.tipoProductoID = tipoProductoID;
    }

    public Inventarios getInventarioID() {
        return inventarioID;
    }

    public void setInventarioID(Inventarios inventarioID) {
        this.inventarioID = inventarioID;
    }

    public UnidadesMedida getUnidadMedidaID() {
        return unidadMedidaID;
    }

    public void setUnidadMedidaID(UnidadesMedida unidadMedidaID) {
        this.unidadMedidaID = unidadMedidaID;
    }

    public TiposRubros getTipoRubroID() {
        return tipoRubroID;
    }

    public void setTipoRubroID(TiposRubros tipoRubroID) {
        this.tipoRubroID = tipoRubroID;
    }

    @XmlTransient
    public Collection<ProductoXDepositoXEventualidad> getProductoXDepositoXEventualidadCollection() {
        return productoXDepositoXEventualidadCollection;
    }

    public void setProductoXDepositoXEventualidadCollection(Collection<ProductoXDepositoXEventualidad> productoXDepositoXEventualidadCollection) {
        this.productoXDepositoXEventualidadCollection = productoXDepositoXEventualidadCollection;
    }

    @XmlTransient
    public Collection<Imagenes> getImagenesCollection() {
        return imagenesCollection;
    }

    public void setImagenesCollection(Collection<Imagenes> imagenesCollection) {
        this.imagenesCollection = imagenesCollection;
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
