package com.blastoide.jsfcontroller;

import com.blastoide.jpa.VentaDAO;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Productos;
import com.blastoide.jsf.Venta;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
                monto += det.getProducto().getPrecioVenta() * det.getCantidad();
                
            }
            
            
            dao = new VentaDAO();
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            dao.registrar(venta, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("aviso exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("algo salio mal"));
        }finally{
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        
    
    }
    
    
    public void generarFactura() throws FileNotFoundException, DocumentException{
    
        
        double monto = 0;
            
            for(DetalleVenta det : lista){
                monto += det.getProducto().getPrecioVenta() * det.getCantidad();
                
            }
            
            
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            //dao.registrar(venta, lista);
            
        
            // Se crea el documento
            Document documento = new Document();
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream("/home/developer/Desktop/fichero.pdf");
            // Se abre el documento.
            documento.open(); 
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(10);
            
                
        //crea tabla    
        PdfPTable tabla = new PdfPTable(3);
            
        System.out.println("lista: "+lista.toString());
        System.out.println("venta: "+venta.toString());
        
        documento.add(new Paragraph("Mundo Limpiaza - factura sin valor comercial"));
         documento.add(new Paragraph("LISTA: "));
                
        documento.add(new Paragraph(lista.toString()));
         documento.add(new Paragraph("VENTA: "));
        
        documento.add(new Paragraph(venta.toString()));
            
        documento.close();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PDF generado"));
        
            
    }
    
        
       
    
}
