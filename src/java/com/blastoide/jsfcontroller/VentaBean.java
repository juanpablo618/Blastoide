package com.blastoide.jsfcontroller;

import com.blastoide.jpa.VentaDAO;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Productos;
import com.blastoide.jsf.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author developer
 */
@ManagedBean
@ViewScoped
public class VentaBean implements Serializable{

    private Venta venta = new Venta();
    private Productos producto = new Productos();
    private int cantidad;
    private List<DetalleVenta> lista = new ArrayList();

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

    
    
    
    
    
    public void agregar(){
        
        DetalleVenta det = new DetalleVenta();
        det.setCantidad(cantidad);
        det.setProducto(producto);
        this.lista.add(det);
        
        
    }
    
    public void registrar() throws Exception{
        
        VentaDAO dao;
        double monto = 0;
        try {
            
            for(DetalleVenta det : lista){
                monto += det.getProducto().getPrecioVenta();
            }
            
            
            dao = new VentaDAO();
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            dao.registrar(venta, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("aviso exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("algo salio mal"));
        }
        
    
    }
    
    
    
    
    
    
    
    
    
}
