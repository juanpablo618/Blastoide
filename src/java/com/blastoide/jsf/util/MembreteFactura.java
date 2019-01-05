package com.blastoide.jsf.util;

import com.blastoide.jpa.ConfiguracionesGeneralesController;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Venta;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public class MembreteFactura {

    /**
     * Crea un documento con encabezado
     *
     * @param filename Nombre del archivo
     * @param lista de objetos DetalleVenta
     * @param venta para sacar el monto, el cliente, y la forma de pago
     *
     */
    public void createPdf(String filename, List<DetalleVenta> lista, Venta venta) throws IOException, DocumentException {
        Document document = new Document(PageSize.LETTER, 36, 36, 140, 36);
        
        System.out.println("lista: " +lista.toString());
        System.out.println("venta: " +venta.toString());
       // Date fechaDiaria = Calendar.getInstance().getTime();

        FacesContext context = FacesContext.getCurrentInstance();
        ConfiguracionesGeneralesController configuracionesGeneralesController = context.getApplication().evaluateExpressionGet(context, "#{configuracionesGeneralesController}", ConfiguracionesGeneralesController.class);
        
        System.out.print("PRINT WRD: "+configuracionesGeneralesController.getConfiguracionesGenerales(1).getCarpetaDePresupuestos().concat(filename).concat(".pdf").toString());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(configuracionesGeneralesController.getConfiguracionesGenerales(1).getCarpetaDePresupuestos().concat(filename).concat(".pdf")));

        FormatoDocumentoPresupuesto encabezado = new FormatoDocumentoPresupuesto();
        Paragraph parrafo;
        int i = 0;

        // indicamos que objecto manejara los eventos al escribir el Pdf
        writer.setPageEvent(encabezado);

        document.open();

        parrafo = new Paragraph("Factura  - Mundo Limpieza");
        parrafo.setAlignment(Element.ALIGN_CENTER);

        document.add(parrafo);

        document.add(Chunk.NEWLINE);

        Paragraph parrafo4 = new Paragraph("Nombre y Apellido: ".concat(venta.getCliente().getNombre()).concat(" ").concat(venta.getCliente().getApellido()).concat(". RS: ").concat(venta.getCliente().getRazonSocial()) );
        document.add(parrafo4);

                String formato="dd-MM-yyyy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        
        Paragraph parrafo5 = new Paragraph("Fecha: " + dateFormat.format(venta.getFecha()));
        document.add(parrafo5);

        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(4);
        
        
        float[] medidaCeldas = {0.55f, 2.25f, 0.50f, 0.50f};

        // ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
        table.setWidths(medidaCeldas);
        
        table.addCell("Cantidad");
        table.addCell("Detalle del producto");
        table.addCell("P.U");
        table.addCell("P.T");

        double totalDeFactura = 0;
        DecimalFormat formateador = new DecimalFormat("####.00");
        DecimalFormat formateadorCantidades = new DecimalFormat("#.##");

        for (DetalleVenta det : lista) {

            //cantidad
           //Paragraph paragraphCantidad = new Paragraph(formateadorCantidades.format(det.getCantidad()));
            //paragraphCantidad.setAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell = new PdfPCell(new Paragraph(formateadorCantidades.format(det.getCantidad())));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell(cell);
            //detalle nombre del producto
            String detallePorProducto = "";
            
             detallePorProducto = detallePorProducto + det.getProducto().toString();
            detallePorProducto = detallePorProducto + " ";
             
            
                if(det.getProducto().getMarca()!=null){
                   detallePorProducto = detallePorProducto + det.getProducto().getMarca();
                }
                if(det.getProducto().getCaracteristica()!=null){
                        detallePorProducto = detallePorProducto + " ";
                        detallePorProducto = detallePorProducto + det.getProducto().getCaracteristica();
                }
                if(det.getProducto().getFragancia()!=null){
                        detallePorProducto = detallePorProducto + " ";
                        detallePorProducto = detallePorProducto + det.getProducto().getFragancia();
                }

                if(det.getProducto().getMedida()!=null){
                                detallePorProducto = detallePorProducto + " ";
                                detallePorProducto = detallePorProducto + det.getProducto().getMedida();
                }
                    
            System.out.println("detallePorProducto :" +detallePorProducto);
            table.addCell(detallePorProducto);
            //precio unitario con el interes sumado
            PdfPCell cellPU = new PdfPCell(new Paragraph(formateador.format(det.getProducto().getPrecioFinalAFacturar())));
            cellPU.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            table.addCell(cellPU);
            
            totalDeFactura = totalDeFactura + det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
            //precio total el pu con interes sumado * cantidad
            PdfPCell cellPT = new PdfPCell(new Paragraph(formateador.format(det.getProducto().getPrecioFinalAFacturar() * det.getCantidad())));
            cellPT.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            table.addCell(cellPT);
        }
        
        table.addCell("");
        table.addCell("");
        table.addCell("Precio total:");
          PdfPCell cellFinalPT = new PdfPCell(new Paragraph(formateador.format(totalDeFactura)));
          cellFinalPT.setHorizontalAlignment(Element.ALIGN_RIGHT);
        
        table.addCell(cellFinalPT);
        
        PdfPCell celdaFinal2 = new PdfPCell(new Paragraph("Firma, Aclaración y Dni: "));

        celdaFinal2.setColspan(4);
        celdaFinal2.setMinimumHeight(50);
        table.addCell(celdaFinal2);

        document.add(table);

        document.close();
        
        }
}