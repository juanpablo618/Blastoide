package com.blastoide.jsfcontroller;

import com.blastoide.configuraciones.ConfiguracionesGenerales;
import com.blastoide.jpa.CajaDiariaDAO;
import com.blastoide.jpa.CuentasCorrientesDAO;
import com.blastoide.jpa.DetalleCuentasCorrientesDAO;
import com.blastoide.jpa.FormaDePagoDAO;
import com.blastoide.jpa.ProductosDAO;
import com.blastoide.jpa.TipoDeClienteDAO;
import com.blastoide.jpa.VentaDAO;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Productos;
import com.blastoide.jsf.Venta;
import com.blastoide.jsf.util.MembreteFactura;
import com.blastoide.jsf.util.MembretePresupuesto;
import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class VentaBean extends ConfiguracionesGenerales implements Serializable{

    private Venta venta = new Venta();
    private Productos producto = new Productos();
    private int cantidad = 1;
    private List<DetalleVenta> lista = new ArrayList();
    private int formaDePagoID;

    private String nombreDelDocumento; 

    private String productoCondBarra;

    public String getProductoCondBarra() {
        return productoCondBarra;
    }

    public void setProductoCondBarra(String productoCondBarra) {
        this.productoCondBarra = productoCondBarra;
    }
    
    public void borrarVentaActual(){
    
    this.getLista().clear();
    
    FacesContext context = FacesContext.getCurrentInstance();
        
    ClienteBuenoController clienteBuenoController = context.getApplication().evaluateExpressionGet(context, "#{clienteBuenoController}", ClienteBuenoController.class);
        
    //System.out.println("clienteBuenoController.getClienteBueno(32)"+ clienteBuenoController.getClienteBueno(32));
    int clienteComunConContadoEfectivo = 0;
    
    for(int i=0;i<=clienteBuenoController.getItems().size() -1;i++){
            if( (clienteBuenoController.getItems().get(i).getApellido().equals("comun") ) || (clienteBuenoController.getItems().get(i).getNombre().equals("cliente"))){
                       clienteComunConContadoEfectivo =  clienteBuenoController.getItems().get(i).getClienteID();
            }
    }
    
        System.out.println("ACAAAA:"+ clienteComunConContadoEfectivo );
    
    this.venta.setCliente(clienteBuenoController.getClienteBueno(clienteComunConContadoEfectivo));
    
    //    System.out.println("clienteBuenoController.getClienteBueno(32).getFormaDePagoID()"+ clienteBuenoController.getClienteBueno(32).getFormaDePagoID());
    
        this.venta.setFormadePagoID(clienteBuenoController.getClienteBueno(clienteComunConContadoEfectivo).getFormaDePagoID());
        
        transferir();
    }
    
    public String getNombreDelDocumento() {
        return nombreDelDocumento;
    }

    public void setNombreDelDocumento(String nombreDelDocumento) {
        this.nombreDelDocumento = nombreDelDocumento;
    }
    
    public int getFormaDePagoID() {
        return formaDePagoID;
    }

    public void setFormaDePagoID(int formaDePagoID) {
        this.formaDePagoID = formaDePagoID;
    }
    
    public List<DetalleVenta> getLista() {
    
        Collections.reverse(lista);
        
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

    public void CambiarFormaDePago() throws Exception {

        try {
            System.out.println("En el metodo CambiarFormaDePago: ");
            System.out.println("");

            FormaDePagoDAO formapagoDao = new FormaDePagoDAO();

            Double porcentajeDeFormaDePago;
            porcentajeDeFormaDePago = formapagoDao.buscarPorcentaje(formaDePagoID);
                                System.err.println("porcentaje por Forma De Pago: "+porcentajeDeFormaDePago);

            TipoDeClienteDAO tipoClienteDao = new TipoDeClienteDAO();

            Double porcentajePorTipoDeCliente;
            porcentajePorTipoDeCliente = tipoClienteDao.buscarPorcentajeDeTipoDeCLiente(venta.getCliente().getTipoClienteID());
                                System.err.println("porcentaje Por Tipo De Cliente: "+porcentajePorTipoDeCliente);

            FacesContext context = FacesContext.getCurrentInstance();
        
            VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);
            
            for(int i=0 ; i<ventaBean.getLista().size() ; i++){

                int idProductoPorCambiarValor = ventaBean.getLista().get(i).getProducto().getProductoID();
                
                ProductosDAO productosDao = new ProductosDAO();
                
                double precioFinalDelProductoEnBD = productosDao.buscarPrecioFinalAFacturar(idProductoPorCambiarValor);
                
                //Double precioUnitario = ventaBean.getLista().get(i).getProducto().getPrecioFinalAFacturar();
                Double precioUnitario = precioFinalDelProductoEnBD ;
                System.err.println("Producto precio venta unitario modificado por juan: "+precioUnitario);


                double cantidadDeFormaDePago;
                double cantidadPorTipoDeCliente;

                cantidadDeFormaDePago = precioUnitario*porcentajeDeFormaDePago /100.0;
                System.err.println("Cantidad a Sumar de forma de pago: "+cantidadDeFormaDePago);

                cantidadPorTipoDeCliente = precioUnitario*porcentajePorTipoDeCliente /100.0;
                
                System.err.println("Cantidad a restar por tipo de cliente: "+cantidadPorTipoDeCliente);
                
               Double PrecioTotal = precioUnitario + cantidadDeFormaDePago - cantidadPorTipoDeCliente;
                System.err.println("PrecioTotal: "+PrecioTotal);

             ventaBean.getLista().get(i).getProducto().setPrecioFinalAFacturar(PrecioTotal);
        }                    
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esta forma de pago no tiene asociado un porcentaje, contactar al administrador"));
        }
    }

    public void agregarPorCodBarra(String productoCodBarra) throws Exception {

        try {
        
        FacesContext context = FacesContext.getCurrentInstance();
        ProductosController productoControllerBean = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);
        
        ProductosDAO productoDAO = new ProductosDAO();
        
        int idBuscado = productoDAO.buscarPorCodigoDeBarra(productoCodBarra);
        
          this.producto = productoControllerBean.getProductos(idBuscado);
        
        FormaDePagoDAO formapagoDao = new FormaDePagoDAO();
        
        Double porcentajeDeFormaDePago;
        porcentajeDeFormaDePago = formapagoDao.buscarPorcentaje(formaDePagoID);
                            System.err.println("porcentaje por Forma De Pago: "+porcentajeDeFormaDePago);

        TipoDeClienteDAO tipoClienteDao = new TipoDeClienteDAO();
        
        Double porcentajePorTipoDeCliente;
        porcentajePorTipoDeCliente = tipoClienteDao.buscarPorcentajeDeTipoDeCLiente(venta.getCliente().getTipoClienteID());
                            System.err.println("porcentaje Por Tipo De Cliente: "+porcentajePorTipoDeCliente);
                
                
        DetalleVenta det = new DetalleVenta();
        
        det.setCantidad(cantidad);
        
        
        Double precioUnitario = this.producto.getPrecioFinalAFacturar();
                            System.err.println("Producto precio final a facturar: "+this.producto.getPrecioFinalAFacturar());
    
        double cantidadDeFormaDePago;
        double cantidadPorTipoDeCliente;
        
            cantidadDeFormaDePago = precioUnitario*porcentajeDeFormaDePago /100.0;
                            System.err.println("Cantidad a Sumar de forma de pago: "+cantidadDeFormaDePago);

            cantidadPorTipoDeCliente = precioUnitario*porcentajePorTipoDeCliente /100.0;
            
           Double PrecioTotal = precioUnitario + cantidadDeFormaDePago - cantidadPorTipoDeCliente;
            System.err.println("PrecioTotal: "+PrecioTotal);
       
        this.producto.setPrecioFinalAFacturar(PrecioTotal);
                    
        det.setProducto(this.producto);
        
        ComprobarSiExiste(det);
        
        this.lista.add(det);
            
        this.productoCondBarra = null;
            System.out.println("codigo del producto insertado en la lista: " + det.getProducto().getCodigo());
        } catch (Exception e) {
        this.productoCondBarra = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El producto no tiene cargado el precio de venta ."));
        }
    }
    
     public void facturar() throws Exception {

        VentaDAO ventadao;
        CajaDiariaDAO cajaDiariaDAO ;
        
        double monto = 0;
        try {

            for (DetalleVenta det : lista) {
                monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
            }
            
            ventadao = new VentaDAO();
            cajaDiariaDAO = new CajaDiariaDAO();
            
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            venta.setFormadePagoID(formaDePagoID);
            
            nombreDelDocumento = new String();
            nombreDelDocumento = venta.getCliente().getNombre().concat(Calendar.getInstance().getTime().toString());
            nombreDelDocumento = nombreDelDocumento.replace(" ","");
            nombreDelDocumento = nombreDelDocumento.replace(":","");
            
            this.setNombreDelDocumento(nombreDelDocumento);
            
              MembreteFactura doc = new MembreteFactura();
              doc.createPdf(nombreDelDocumento,lista,venta);
              
            
            if(venta.getCliente().getFormaDePagoID().equals(3)|| venta.getCliente().getFormaDePagoID().equals(4) || venta.getCliente().getFormaDePagoID().equals(5) || venta.getCliente().getFormaDePagoID().equals(6)){
        
                //1ro registra la venta y sus detalles de la venta
                ventadao.registrar(venta, lista);
                cajaDiariaDAO.registrarEnCajaDiaria(venta);
     
                System.err.println("tamaño de la lista: "+ lista.size());
                
                //Se podría sacar a un metodo por que hace lo mismo que lo de abajo // hacer más adelante  ahora tiene un bug que por cada producto mande una notificacion de "actualizado" 
                for (DetalleVenta det : lista) {
                    
                        monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
                        System.err.println("producto: "+det.getProducto() + " cantidad: " + det.getCantidad());
                        System.err.println("");

                        FacesContext context = FacesContext.getCurrentInstance();

                        ProductosController productoControllerBean = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);

                        System.err.println("stock actual del producto: "+ productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual().toString() );                

                        int stockActual = productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual();
                        System.err.println("stockActual: "+ stockActual );                

                        int stockModificado = stockActual - det.getCantidad();
                        System.err.println("stockModificado: "+ stockModificado );                

                        productoControllerBean.setSelected(productoControllerBean.getProductos(det.getProducto().getProductoID()));
                        productoControllerBean.getSelected().setStockactual(stockModificado);
                        productoControllerBean.updateSinNotificacion();
                }
                
                //2do tiene que insertar en detalleCuentaCorriente el haber va en cero por que es una venta de productos esto.
                CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
                DetalleCuentasCorrientesDAO detalleCuentasCorrientesDAO = new DetalleCuentasCorrientesDAO();
                
                float haber = 0;
                float saldohistorico = cuentasCorrientesDAO.buscarSaldo(venta.getCliente().getCuentaCorrienteID());
                       
                venta.setVentaID(ventadao.buscarUltimoIdInsertado());
                
                saldohistorico = (float) (saldohistorico + venta.getMonto());
                detalleCuentasCorrientesDAO.insertarDetalleCtaCorriente(venta.getMonto(), haber, "FAC-"+venta.getVentaID(), venta.getCliente().getCuentaCorrienteID(), saldohistorico );
                
                //3ro actualizar saldo de cta corriente
                float saldoactual = saldohistorico  ;
                cuentasCorrientesDAO.actualizarSaldo(venta.getCliente().getCuentaCorrienteID(), saldoactual);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta Factururada exitosamente"));
                
            } else{
            
                ventadao.registrar(venta, lista);
                cajaDiariaDAO.registrarEnCajaDiaria(venta);
                
                //Se podría sacar a un metodo por que hace lo mismo que lo de arriba
                for (DetalleVenta det : lista) {
                monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
                System.err.println("producto: "+det.getProducto() + " cantidad: " + det.getCantidad());
                System.err.println("");
     
                FacesContext context = FacesContext.getCurrentInstance();
                ProductosController productoControllerBean = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);
        
                System.err.println("stock actual del producto: "+ productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual().toString() );                
                
                int stockActual = productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual();
                System.err.println("stockActual: "+ stockActual );                
                
                int stockModificado = stockActual - det.getCantidad();
                System.err.println("stockModificado: "+ stockModificado );                
               
                productoControllerBean.setSelected(productoControllerBean.getProductos(det.getProducto().getProductoID()));
                productoControllerBean.getSelected().setStockactual(stockModificado);
                productoControllerBean.update();
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta Factururada exitosamente"));

            }
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo realizar la facturación"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
     }

     public void presupuestar() throws FileNotFoundException, DocumentException, IOException {

        System.err.println("entro en el metodo presupuestar de VentaBean: ");
        System.err.println("");
        VentaDAO ventadao;
        CajaDiariaDAO cajaDiariaDAO ;
        
        double monto = 0;
        try {

            for (DetalleVenta det : lista) {
                monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
            }
            
            ventadao = new VentaDAO();
            cajaDiariaDAO = new CajaDiariaDAO();
            
            venta.setMonto(monto);
            venta.setFecha(Calendar.getInstance().getTime());
            venta.setFormadePagoID(formaDePagoID);
            
            
            nombreDelDocumento = new String();
            nombreDelDocumento = "PRESUPUESTO_".concat(venta.getCliente().getNombre().concat(Calendar.getInstance().getTime().toString()));
            nombreDelDocumento = nombreDelDocumento.replace(" ","");
            nombreDelDocumento = nombreDelDocumento.replace(":","");
            
            this.setNombreDelDocumento(nombreDelDocumento);
            
              MembretePresupuesto doc = new MembretePresupuesto();
              doc.createPdf(nombreDelDocumento,lista,venta);
            
            if(venta.getCliente().getFormaDePagoID().equals(3)|| venta.getCliente().getFormaDePagoID().equals(4) || venta.getCliente().getFormaDePagoID().equals(5) || venta.getCliente().getFormaDePagoID().equals(6)){
        
                //1ro registra la venta y sus detalles de la venta
                ventadao.registrar(venta, lista);
                cajaDiariaDAO.registrarEnCajaDiaria(venta);
     
                System.err.println("tamaño de la lista: "+ lista.size());
                
                //Se podría sacar a un metodo por que hace lo mismo que lo de abajo // hacer más adelante  ahora tiene un bug que por cada producto mande una notificacion de "actualizado" 
                for (DetalleVenta det : lista) {
                    
                        monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
                        System.err.println("producto: "+det.getProducto() + " cantidad: " + det.getCantidad());
                        System.err.println("");

                        FacesContext context = FacesContext.getCurrentInstance();

                        ProductosController productoControllerBean = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);

                        System.err.println("stock actual del producto: "+ productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual().toString() );                

                        int stockActual = productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual();
                        System.err.println("stockActual: "+ stockActual );                

                        int stockModificado = stockActual - det.getCantidad();
                        System.err.println("stockModificado: "+ stockModificado );                

                        productoControllerBean.setSelected(productoControllerBean.getProductos(det.getProducto().getProductoID()));
                        productoControllerBean.getSelected().setStockactual(stockModificado);
                        productoControllerBean.updateSinNotificacion();
                }
                
                //2do tiene que insertar en detalleCuentaCorriente el haber va en cero por que es una venta de productos esto.
                CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
                DetalleCuentasCorrientesDAO detalleCuentasCorrientesDAO = new DetalleCuentasCorrientesDAO();
                
                float haber = 0;
                float saldohistorico = cuentasCorrientesDAO.buscarSaldo(venta.getCliente().getCuentaCorrienteID());
                
                venta.setVentaID(ventadao.buscarUltimoIdInsertado());
                
                saldohistorico = (float) (saldohistorico + venta.getMonto());
                detalleCuentasCorrientesDAO.insertarDetalleCtaCorriente(venta.getMonto(), haber, "PRE-"+venta.getVentaID(), venta.getCliente().getCuentaCorrienteID(), saldohistorico );
                
                //3ro actualizar saldo de cta corriente
                float saldoactual = saldohistorico  ;
                cuentasCorrientesDAO.actualizarSaldo(venta.getCliente().getCuentaCorrienteID(), saldoactual);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta Factururada exitosamente"));
                
            } else{
            
                ventadao.registrar(venta, lista);
                cajaDiariaDAO.registrarEnCajaDiaria(venta);
                
                //Se podría sacar a un metodo por que hace lo mismo que lo de arriba
                for (DetalleVenta det : lista) {
                monto += det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
                System.err.println("producto: "+det.getProducto() + " cantidad: " + det.getCantidad());
                System.err.println("");
     
                FacesContext context = FacesContext.getCurrentInstance();
                ProductosController productoControllerBean = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);
        
                System.err.println("stock actual del producto: "+ productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual().toString() );                
                
                int stockActual = productoControllerBean.getProductos(det.getProducto().getProductoID()).getStockactual();
                System.err.println("stockActual: "+ stockActual );                
                
                int stockModificado = stockActual - det.getCantidad();
                System.err.println("stockModificado: "+ stockModificado );                
               
                productoControllerBean.setSelected(productoControllerBean.getProductos(det.getProducto().getProductoID()));
                productoControllerBean.getSelected().setStockactual(stockModificado);
                productoControllerBean.update();
                
                }
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PDF generado"));
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta Factururada exitosamente"));
            }   
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo realizar la facturación"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         
        }
     }
    
    public void transferir(){
    
        FacesContext context = FacesContext.getCurrentInstance();
        
        VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);
        
        ventaBean.setFormaDePagoID(this.venta.getCliente().getFormaDePagoID());
        
    }
    
    public void cambiarDetalleVenta(DetalleVenta deta, int cantidad){
        FacesContext context = FacesContext.getCurrentInstance();
        
        VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);
        
        for (DetalleVenta det : lista) {
            if(det.getCodigo() == deta.getCodigo())
                deta.setCantidad(cantidad);
        }
    }
    
    public List<Productos> completenombre(String query) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        ProductosController productosController = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);
        return productosController.getItems();
    }

    private void ComprobarSiExiste(DetalleVenta det) {
    
        FacesContext context = FacesContext.getCurrentInstance();
        VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);
               
        for (int i=0 ; i<ventaBean.getLista().size();i++){
            
            if(det.getProducto().getCodigo().equals(ventaBean.getLista().get(i).getProducto().getCodigo())){
                    int cantidadTotal = ventaBean.getLista().get(i).getCantidad();
                        cantidadTotal = cantidadTotal +1;
                    det.setCantidad(cantidadTotal);
                    ventaBean.getLista().remove(i);
            }
        }
    }
    
    public void BorrarDetalle(DetalleVenta detalleVenta){
       FacesContext context = FacesContext.getCurrentInstance();
        VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);
       
        for (int i=0 ; i<ventaBean.getLista().size();i++){
            if(detalleVenta.getProducto().getCodigo().equals(ventaBean.getLista().get(i).getProducto().getCodigo())){
                    ventaBean.getLista().remove(i);
            }
        }
   
    }

/**
     * This method reads PDF from the URL and writes it back as a response. 
     * @throws IOException 
     */
    public void downloadPdf() throws IOException {
        // Get the FacesContext
         String PDF_URL = "file:///home/juan/Documentsdocumento.pdf";

        FacesContext facesContext = FacesContext.getCurrentInstance();

        // Get HTTP response
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        // Set response headers
        response.reset();
        // Reset the response in the first place
        response.setHeader("Content-Type", "application/pdf"); 
        // Set only the content type

        // Open response output stream
        OutputStream responseOutputStream = response.getOutputStream();

        // Read PDF contents
        URL url = new URL(PDF_URL);
        InputStream pdfInputStream = url.openStream();

        // Read PDF contents and write them to the output
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
        responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }

        // Make sure that everything is out
        responseOutputStream.flush();

        // Close both streams
        pdfInputStream.close();
        responseOutputStream.close();

        // JSF doc: 
        // Signal the JavaServer Faces implementation that the HTTP response for this request has already been generated 
        // (such as an HTTP redirect), and that the request processing lifecycle should be terminated
        // as soon as the current phase is completed.
        facesContext.responseComplete();
    }
}
