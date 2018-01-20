package com.blastoide.jsfcontroller;

/**
 *
 * @author juan
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

@ManagedBean
public class DownloadBean implements Serializable {

private static final long serialVersionUID = 626953318628565053L;

//configuracion para mi linux = file:///home/juan/Documents

//configuracion q anda para lucas
private static final String PDF_URL = "file:///C:\\Users\\Usuario\\Desktop\\BLASTOIDE\\documentos\\";

//private static final String PDF_URL = "file:///home/juan/Documents";


/**
     * This method reads PDF from the URL and writes it back as a response. 
     * @throws IOException 
    
     * @param nombreDelDocumento */
public void downloadPdf(String nombreDelDocumento) throws IOException, InterruptedException {
    System.err.println("");    
    System.err.println("");
    System.err.println("nombreDelDocumento: " + nombreDelDocumento.toString());
    
    Thread.sleep(2000);
    
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

// Read PDF contents
URL url = new URL(PDF_URL.concat(nombreDelDocumento).concat(".pdf"));
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
        
//VentaBean ventaBean = context.getApplication().evaluateExpressionGet(context, "#{ventaBean}", VentaBean.class);

//ventaBean.setLista(null);
//    System.err.println("ccaaaaaaaaaaaaaaaaacccccccccaaaaaaaaa: " + ventaBean.getLista());

}
}