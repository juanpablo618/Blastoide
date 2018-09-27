package com.blastoide.jsfcontroller;


 
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
public class FileDownloadView {
     
    private StreamedContent file;
     
     public FileDownloadView() {        
      //  InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/caja.jpg");
      //  file = new DefaultStreamedContent(stream, "image/jpg", "caja.jpg");
    
       //InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/facturas/DocumentspedroFriSep07135439CDT2018.pdf");
       //file = new DefaultStreamedContent(stream, "application/pdf", "DocumentspedroFriSep07135439CDT2018.pdf");
    
     
     }
     
     public StreamedContent downloadJuan(String nombreDelDocumento) throws InterruptedException{
             Thread.sleep(2000);

     System.out.println("nombre del documento en fileDownload: "+ nombreDelDocumento);
        
       InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/facturas/"+nombreDelDocumento+".pdf");
       file = new DefaultStreamedContent(stream, "application/pdf", nombreDelDocumento+".pdf");
    
      return file;   
     }


         
     
    public void setFileConNombre(String nombreDelDocumento) throws InterruptedException{
          Thread.sleep(2000);

        System.out.println("nombre del documento en setFileConNombre de fileDownloadVIew: "+ nombreDelDocumento);
        
       InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/facturas/"+nombreDelDocumento+".pdf");
       
       this.file = new DefaultStreamedContent(stream, "application/pdf", nombreDelDocumento+".pdf");
        
       
       
    }
    
    
     public StreamedContent getFile() {
        return file;
    }
}