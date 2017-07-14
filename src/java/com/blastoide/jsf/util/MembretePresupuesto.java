
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
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author developer
 */
public class MembretePresupuesto {
    
       /**
     * Crea un documento con encabezado
     * 
     * @param filename Nombre del archivo
     * @param lista de objetos DetalleVenta
     * @param venta para sacar el monto, el cliente, y la forma de pago
     * 
     */
    public void createPdf(String filename, List<DetalleVenta> lista, Venta venta) throws IOException, DocumentException
    {        
        Document document = new Document(PageSize.LETTER, 36, 36, 140, 36);
        
        Date fechaDiaria = Calendar.getInstance().getTime();
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(getCARPETA_DE_PRESUPUESTOS().concat(fechaDiaria.toString()).concat(".pdf")));
        
        FormatoDocumentoPresupuesto encabezado = new FormatoDocumentoPresupuesto();
        Paragraph parrafo;
        int i = 0;
        
        // indicamos que objecto manejara los eventos al escribir el Pdf
        writer.setPageEvent(encabezado);
        
        document.open();
        
            parrafo = new Paragraph("Esta es una de las paginas de prueba de nuestro programa, es la pagina numero 0x" + String.format("%03X", i+42));            
            parrafo.setAlignment(Element.ALIGN_CENTER);
            
            document.add(parrafo);
            
            document.add(Chunk.NEWLINE);
            
            
            document.add(new Paragraph(venta.toString()));

            document.add(new Paragraph(lista.toString()));

        
        document.close();        
    }
    
    
}
