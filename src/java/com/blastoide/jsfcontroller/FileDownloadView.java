package com.blastoide.jsfcontroller;


 
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
@ApplicationScoped
@Named("fileDownloadView")
public class FileDownloadView {
     
    private StreamedContent file ;
    private String nombreDelArchivo;
     
     public FileDownloadView() {        
      //  InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/caja.jpg");
      //  file = new DefaultStreamedContent(stream, "image/jpg", "caja.jpg");
    
       //InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/facturas/DocumentspedroFriSep07135439CDT2018.pdf");
       //file = new DefaultStreamedContent(stream, "application/pdf", "DocumentspedroFriSep07135439CDT2018.pdf");
    
     
     }
     
     public StreamedContent downloadJuan() throws InterruptedException{
     
         FacesContext context = FacesContext.getCurrentInstance();
         FileDownloadView fileDownloadView = context.getApplication().evaluateExpressionGet(context, "#{fileDownloadView}", FileDownloadView.class);
        
     System.out.println("nombre del documento en fileDownload: "+ fileDownloadView.getNombreDelArchivo());
        
       InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/facturas/"+fileDownloadView.getNombreDelArchivo()+".pdf");
       file = new DefaultStreamedContent(stream, "application/pdf", fileDownloadView.getNombreDelArchivo()+".pdf");
    
      return file;   
     }

    public String getNombreDelArchivo() {
        return nombreDelArchivo;
    }

    public void setNombreDelArchivo(String nombreDelArchivo) {
        this.nombreDelArchivo = nombreDelArchivo;
    }


         
     
    public void setFileConNombre(String nombreDelDocumento) throws InterruptedException{
          Thread.sleep(4000);

        System.out.println("nombre del documento en setFileConNombre de fileDownloadVIew: "+ nombreDelDocumento);
        
        FacesContext context = FacesContext.getCurrentInstance();
         FileDownloadView fileDownloadView = context.getApplication().evaluateExpressionGet(context, "#{fileDownloadView}", FileDownloadView.class);
        fileDownloadView.setNombreDelArchivo(nombreDelDocumento);
        
        //downloadJuan(nombreDelDocumento);
    }
    
    
     public StreamedContent getFile() {
        return file;
    }
}