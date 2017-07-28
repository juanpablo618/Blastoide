/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsf;

import com.blastoide.jsf.ClienteBueno;
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
    private int formadePagoID;

    public int getFormadePagoID() {
        return formadePagoID;
    }

    public void setFormadePagoID(int formadePagoID) {
        this.formadePagoID = formadePagoID;
    }
    
    
    
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

    @Override
    public String toString() {
        return "Fecha=" + fecha + ", Cliente=" + cliente.getNombre() + ", Monto total=" + monto;
    }
    
    
    
    
    
    
    
    
    
    
}
