package com.blastoide.jsfcontroller;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
import com.blastoide.jpa.ConfiguracionesGeneralesController;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class DownloadBean implements Serializable {

private static final long serialVersionUID = 626953318628565053L;
    private StreamedContent file;

//private final  String PDF_URL = ConfiguracionesGenerales.getPDF_URL();

/**
     * This method reads PDF from the URL and writes it back as a response. 
     * @throws IOException 
     * @param nombreDelDocumento */

public void downloadPdf(String nombreDelDocumento) throws IOException, InterruptedException {
    System.err.println("");    
    System.err.println("");
    System.err.println("nombreDelDocumento: " + nombreDelDocumento.toString());
    
// Get the FacesContext
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

//create facecontext to set the data PDF_URL retrieved to database
 FacesContext context = FacesContext.getCurrentInstance();
 ConfiguracionesGeneralesController configuracionesGeneralesController = context.getApplication().evaluateExpressionGet(context, "#{configuracionesGeneralesController}", ConfiguracionesGeneralesController.class);
      
// Read PDF contents
URL url = new URL(configuracionesGeneralesController.getConfiguracionesGenerales(1).getPdfUrl().concat(nombreDelDocumento).concat(".pdf"));
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

//FacesContext context = FacesContext.getCurrentInstance();

}
    

public DownloadBean() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("resources/images/MundoLimpieza2.jpg");
        file = new DefaultStreamedContent(stream, "image/jpg", "MundoLimpieza2.jpg");
    }
 
public void downloadPdfEnNavegador(String nombreDelDocumento) throws InterruptedException{
        Thread.sleep(2000);
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    
    System.out.println("nombre del documento: " + nombreDelDocumento);
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    System.out.println("/////////////////////////////////////////////");
    
     //InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/home/jelastic/"+nombreDelDocumento+".pdf");
     // file = new DefaultStreamedContent(stream, "application/pdf", nombreDelDocumento+".pdf");
        
     InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("resources/facturas/DocumentspedroFriSep07135439CDT2018.pdf");
     file = new DefaultStreamedContent(stream, "application/pdf", "DocumentspedroFriSep07135439CDT2018.pdf");
        
        
} 
    
public StreamedContent getFile() {
       return file;
}



}