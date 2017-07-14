package com.blastoide.jsfcontroller;

import com.blastoide.configuraciones.ConfiguracionesGenerales;
import com.blastoide.jpa.FormaDePago;
import com.blastoide.jpa.FormaDePagoDAO;
import com.blastoide.jpa.VentaDAO;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Productos;
import com.blastoide.jsf.Venta;
import com.blastoide.jsf.util.MembretePresupuesto;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class VentaBean extends ConfiguracionesGenerales implements Serializable{

    private Venta venta = new Venta();
    private Productos producto = new Productos();
    private int cantidad;
    private List<DetalleVenta> lista = new ArrayList();
    
    private int formaDePagoID;

    
    public int getFormaDePagoID() {
        return formaDePagoID;
    }

    public void setFormaDePagoID(int formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
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

    public void agregar() {

        DetalleVenta det = new DetalleVenta();
        det.setCantidad(cantidad);
        det.setProducto(producto);
        this.lista.add(det);

    }

    
    
/**
 *
 *  
 * monto = es el total del precio de todos los productos en la venta por su cantidad.
 */
    public void facturar() throws Exception {

        VentaDAO dao;
        FormaDePagoDAO formapagoDao = new FormaDePagoDAO();
        
        
        double monto = 0;
        try {

            for (DetalleVenta det : lista) {
                monto += det.getProducto().getPrecioVenta() * det.getCantidad();

            }
            
            Double porcentaje;
            porcentaje = formapagoDao.buscarPorcentaje(formaDePagoID);

            System.err.println("porcentaje: "+porcentaje);
            
            double montoFinal;
            
            montoFinal = monto*porcentaje /100.0;
            
            System.err.println("montofinal: "+montoFinal);
            
            
            monto = monto + montoFinal; 
            
            dao = new VentaDAO();
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            venta.setFormadePagoID(formaDePagoID);
            dao.registrar(venta, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta Factururada exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo realizar la facturación"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

    }

    public void presupuestar() throws FileNotFoundException, DocumentException, IOException {

        double monto = 0;

        for (DetalleVenta det : lista) {
            monto += det.getProducto().getPrecioVenta() * det.getCantidad();
        }

        venta.setMonto(monto);
        venta.setFecha(Calendar.getInstance().getTime());
        
         MembretePresupuesto doc = new MembretePresupuesto();
            doc.createPdf("documento.pdf",lista,venta);
        
        // Se crea el documento
        //Document documento = new Document(PageSize.A4, 35, 30, 50, 50);
        // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        //Date fechaDiaria = Calendar.getInstance().getTime();

        //FileOutputStream ficheroPdf = new FileOutputStream(getCARPETA_DE_PRESUPUESTOS().concat(fechaDiaria.toString()).concat(".pdf"));

        // Se asocia el documento al OutputStream y se indica que el espaciado entre
        // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
        //PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);

        // Se abre el documento.
        //documento.open();

      //  Image image;
      //  try {
            //  ./../resources/images/pdf.png
      //      image = Image.getInstance(getURL_DE_LOGO_MUNDO_LIMPIEZA());
      //      image.setAbsolutePosition(10, 650f);

      //      documento.add(image);
      //  } catch (BadElementException ex) {
      //      System.out.println("Image BadElementException" + ex);
      //  }

       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));
       // documento.add(new Phrase(Chunk.NEWLINE));

       // documento.add(new Paragraph("Mundo Limpieza - Presupuesto sin valor comercial"));

       // documento.add(new Phrase(Chunk.NEWLINE));

       // documento.add(new Paragraph("LISTA de productos y cantidad: "));
        //documento.add(new Paragraph(lista.toString()));
       
        //documento.add(new Phrase(Chunk.NEWLINE));

        //documento.add(new Paragraph("Posible VENTA al cliente: "));
        //documento.add(new Paragraph(venta.toString()));
        //documento.add(new Phrase(Chunk.NEWLINE));

        //documento.close();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PDF generado"));

    }

}
