
package com.blastoide.jsfcontroller;

import com.blastoide.jpa.ClienteDAO;
import com.blastoide.jsf.Cliente;
import com.blastoide.jsf.CuentasCorrientes;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@javax.enterprise.context.SessionScoped
public class ClienteBean implements Serializable{
    
    private List<Cliente> lstClientes;
    private Cliente cliente = new Cliente();
    
    private CuentasCorrientes cuentasCorrientes = new CuentasCorrientes();

    
    
    
    
    
    
    public CuentasCorrientes getCuentasCorrientes() {
        return cuentasCorrientes;
    }

    public void setCuentasCorrientes(CuentasCorrientes cuentasCorrientes) {
        this.cuentasCorrientes = cuentasCorrientes;
    }

    
    
    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
    public void listar(String valor) throws Exception{
     ClienteDAO dao;
        
           try {
               if(valor.equals("F") ){
               
                   if(isPostBacak() == false){
                   
                        dao = new ClienteDAO();
                        lstClientes = dao.listar();
                        System.err.println("paso por listar de clienteBean");
               }
                   
               }else{
                        dao = new ClienteDAO();
                        lstClientes = dao.listar();
               
               }
               
         } catch (Exception e) {
        }
 
    
    }
    
    public void leerId(Cliente cliente) throws Exception{
        
        ClienteDAO dao;
        
        Cliente clienteTemporal;
        
           try {
            dao = new ClienteDAO();
           clienteTemporal = dao.leerId(cliente);
            
           
           if(clienteTemporal != null){
               this.cliente = clienteTemporal;
           }
            
        } catch (Exception e) {
        }
 
        
        
        
    }
    
    
    private boolean isPostBacak(){
    
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        
        return respuesta;
    }
    
    
    public void CrearClienteNuevo(){
        try{
            
            ClienteDAO clientedao;
            clientedao = new ClienteDAO();
            System.err.println("crearClienteNuevo paso por aca");
            
            clientedao.crearClienteNuevo(cliente,cuentasCorrientes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente creado exitosamente"));
        
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo realizar el cliente"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        
    
    }
    
    
    
    
    
    
    
}
