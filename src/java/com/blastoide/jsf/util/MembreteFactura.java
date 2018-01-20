package com.blastoide.jsf.util;

import static com.blastoide.configuraciones.ConfiguracionesGenerales.getCARPETA_DE_PRESUPUESTOS;
import com.blastoide.jsf.DetalleVenta;
import com.blastoide.jsf.Venta;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(getCARPETA_DE_PRESUPUESTOS().concat(filename).concat(".pdf")));

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

        Paragraph parrafo4 = new Paragraph("Nombre del cliente :" + venta.getCliente().getNombre());
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

        for (DetalleVenta det : lista) {

            //cantidad
            table.addCell("" + new DecimalFormat("#.##").format(det.getCantidad()));
            //detalle nombre del producto
            table.addCell(det.getProducto().toString());
            //precio unitario con el interes sumado
            
            table.addCell("" + det.getProducto().getPrecioFinalAFacturar());
            //precio total el pu con interes sumado * cantidad
                        
            totalDeFactura = totalDeFactura + det.getProducto().getPrecioFinalAFacturar() * det.getCantidad();
            table.addCell("" + new DecimalFormat("#.##").format(det.getProducto().getPrecioFinalAFacturar() * det.getCantidad()));
            
        }

        table.addCell("");
        table.addCell("");
        table.addCell("Precio total:");
        table.addCell(""+new DecimalFormat("#.##").format(totalDeFactura));
        
        


        PdfPCell celdaFinal2 = new PdfPCell(new Paragraph("Firma, Aclaración y Dni: "));

        celdaFinal2.setColspan(4);
        celdaFinal2.setMinimumHeight(50);
        table.addCell(celdaFinal2);

        document.add(table);

        document.close();
        
        }

    
}
