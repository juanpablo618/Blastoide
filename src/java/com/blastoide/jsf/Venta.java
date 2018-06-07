package com.blastoide.jsf;

import com.blastoide.jsfcontroller.ClienteBuenoController;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@ManagedBean
@ViewScoped
public class Venta {
    
    private int ventaID;
    private Date fecha;
    private ClienteBueno cliente;
    private double monto;
    private int formadePagoID;
    
    private String empleado;

    @PostConstruct
    public void init(){
    
    FacesContext context = FacesContext.getCurrentInstance();
    ClienteBuenoController clienteBuenoController = context.getApplication().evaluateExpressionGet(context, "#{clienteBuenoController}", ClienteBuenoController.class);
    
    System.out.println("clienteBuenoController.getClienteBueno(37): " + clienteBuenoController.getClienteBueno(37).toString());     
    setCliente(clienteBuenoController.getClienteBueno(37));
    }
    
    
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
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
        return "Venta{" + "ventaID=" + ventaID + ", fecha=" + fecha + ", cliente=" + cliente + ", monto=" + monto + ", formadePagoID=" + formadePagoID + ", empleado=" + empleado + '}';
    }

}