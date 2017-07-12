/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import com.blastoide.jpa.ClienteBueno;
import com.blastoide.jpa.VentaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author developer
 */
@ManagedBean
@ViewScoped
public class Venta {
    
    private int ventaID;
    private Date fecha;
    private ClienteBueno cliente;
    private double monto;

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(ClienteBueno cliente) {
        this.cliente = cliente;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
            
    
    
    
    
    
    
    
    
            
    
    
    /*
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    
    
    
    
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    private Date fecha = new Date();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
    
    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    
    
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    */

    public int getVentaID() {
        return ventaID;
    }

    public Date getFecha() {
        return fecha;
    }

    public ClienteBueno getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }
}
